-- Exercício 03 - Slides 
--Exemplo EXISTS
SELECT
    cod_disc,
    nom_disc
FROM
    disciplinas d
WHERE
    EXISTS (
        SELECT
            1
        FROM
            matrizes m
            JOIN alunos a ON m.cod_curso = a.cod_curso
        WHERE
            m.cod_disc = d.cod_disc
            AND a.mat_alu = 83944
    )
    AND NOT EXISTS (
        SELECT
            1
        FROM
            historicos h
        WHERE
            h.cod_disc = d.cod_disc
            AND h.situacao = 'AP'
            AND h.mat_alu = 83944
    )
    AND NOT EXISTS (
        SELECT
            1
        FROM
            matriculas h
        WHERE
            h.cod_disc = d.cod_disc
            AND h.mat_alu = 83944
    )
ORDER BY
    2;


-- Questão 01

SELECT
    ano,
    semestre,
    cod_disc,
    COUNT(*) total_matriculados
FROM
    matriculas
GROUP BY
    ano,
    semestre,
    cod_disc
HAVING
    COUNT(*) = (
        SELECT
            MAX(COUNT(*) )
        FROM
            matriculas
        GROUP BY
            ano,
            semestre,
            cod_disc
    );


-- Questão 02

SELECT
    cod_disc,
    nom_disc,
    COUNT(*) total_matriculados
FROM
    matriculas
    JOIN disciplinas USING ( cod_disc )
GROUP BY
    cod_disc,
    nom_disc
HAVING
    COUNT(*) = (
        SELECT
            MAX(COUNT(*) )
        FROM
            matriculas
        GROUP BY
            cod_disc
    );

-- Questão 03 - Forma 01

WITH reprovados AS (
    SELECT
        cod_disc,
        COUNT(*) reprovados
    FROM
        historicos
    WHERE
        situacao <> 'AP'
    GROUP BY
        cod_disc
),cursaram AS (
    SELECT
        cod_disc,
        COUNT(*) cursaram
    FROM
        historicos
    GROUP BY
        cod_disc
)

-- Questão 03 - Forma 02
SELECT
    cod_disc,
    nom_disc,
    reprovados,
    cursaram,
    trunc( (reprovados / cursaram) * 100,1) perc_reprov
FROM
    (
        SELECT
            cod_disc,
            COUNT(*) reprovados
        FROM
            historicos
        WHERE
            situacao <> 'AP'
        GROUP BY
            cod_disc
    )
    JOIN (
        SELECT
            cod_disc,
            COUNT(*) cursaram
        FROM
            historicos
        GROUP BY
            cod_disc
    ) USING ( cod_disc )
    JOIN disciplinas USING ( cod_disc );

-- Questão 03 - Forma 03

SELECT
    h.cod_disc,
    nom_disc,
    ( COUNT(*) / (
        SELECT
            COUNT(*)
        FROM
            historicos h1
        WHERE
            h1.cod_disc = h.cod_disc
    ) ) * 100 reprovados
FROM
    historicos h
    JOIN disciplinas d ON h.cod_disc = d.cod_disc
WHERE
    situacao <> 'AP'
GROUP BY
    h.cod_disc,
    nom_disc;

-- Questão 04

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