-- 1
WITH total AS (
    SELECT
        ano,
        semestre,
        cod_disc,
        COUNT(mat_alu) total_alu
    FROM
        matriculas
        INNER JOIN turmas USING ( ano,
                                  semestre,
                                  cod_disc )
    GROUP BY
        cod_disc,
        ano,
        semestre
),max_alu AS (
    SELECT
        MAX(total_alu) total_alu
    FROM
        total
)
SELECT
    cod_disc    "CODIGO DISCIPLINA",
    total_alu   "TOTAL DE ALUNOS"
FROM
    disciplinas
    INNER JOIN total USING ( cod_disc )
    JOIN max_alu USING ( total_alu );
    
-- 2

WITH total AS (
    SELECT
        cod_disc,
        COUNT(mat_alu) total_alu
    FROM
        matriculas
    GROUP BY
        cod_disc
),max_alu AS (
    SELECT
        MAX(total_alu) total_alu
    FROM
        total
)
SELECT
    cod_disc    codigo,
    nom_disc    nom_alu,
    total_alu   "TOTAL DE ALUNOS"
FROM
    disciplinas
    INNER JOIN total USING ( cod_disc )
    JOIN max_alu USING ( total_alu );
    
-- 3

WITH reprovados AS (
    SELECT
        cod_disc,
        COUNT(mat_alu) total_reprovados
    FROM
        historicos
    WHERE
        situacao LIKE 'RM'
    GROUP BY
        cod_disc
),total AS (
    SELECT
        cod_disc,
        COUNT(mat_alu) total_alunos
    FROM
        historicos
    GROUP BY
        cod_disc
)
SELECT
    cod_disc,
    nom_disc,
    trunc( ( (total_reprovados / total_alunos) * 100),2) percentual
FROM
    disciplinas
    INNER JOIN reprovados USING ( cod_disc )
    INNER JOIN total USING ( cod_disc )
ORDER BY
    percentual DESC;
    
-- 4

WITH reprovados AS (
    SELECT
        idt_prof,
        COUNT(mat_alu) total_reprovados
    FROM
        historicos
        INNER JOIN turmas USING ( ano,
                                  semestre )
    WHERE
        situacao LIKE 'RM'
    GROUP BY
        idt_prof
),total AS (
    SELECT
        idt_prof,
        COUNT(mat_alu) total_alunos
    FROM
        historicos
        INNER JOIN turmas USING ( ano,
                                  semestre )
        INNER JOIN professores USING ( idt_prof )
    GROUP BY
        idt_prof
),percentuais AS (
    SELECT
        idt_prof,
        trunc( ( (total_reprovados / total_alunos) * 100),2) percentual
    FROM
        total
        INNER JOIN reprovados USING ( idt_prof )
)
SELECT
    idt_prof
FROM
    percentuais
WHERE
    percentual = (
        SELECT
            MAX(percentual)
        FROM
            percentuais
    );
    
-- 4 professor

WITH reprovados AS (
    SELECT
        idt_prof,
        COUNT(*) reprovados
    FROM
        historicos
        JOIN turmas USING ( ano,
                            semestre,
                            cod_disc )
    WHERE
        situacao <> 'AP'
    GROUP BY
        idt_prof
),cursaram AS (
    SELECT
        idt_prof,
        COUNT(*) cursaram
    FROM
        historicos
        JOIN turmas USING ( ano,
                            semestre,
                            cod_disc )
    GROUP BY
        idt_prof
),percentual AS (
    SELECT
        mat_prof,
        nom_prof,
        reprovados,
        cursaram,
        ( reprovados / cursaram ) * 100 perc_reprov
    FROM
        reprovados
        JOIN cursaram USING ( idt_prof )
        JOIN professores USING ( idt_prof )
)
SELECT
    *
FROM
    percentual
WHERE
    perc_reprov = (
        SELECT
            MAX(perc_reprov)
        FROM
            percentual
    );