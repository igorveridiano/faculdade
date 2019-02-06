-- Exercicio 7 Unigrande
-- 1
SELECT
    nom_alu    nome,
    mat_alu    matricula,
    mgp,
    dat_nasc   "DATA NASCIMENTO"
FROM
    alunos
WHERE
    cod_curso = 26
ORDER BY
    mgp DESC;
    
-- 2

SELECT
    cod_curso   "CÓDIGO CURSO",
    nom_curso,
    mat_prof    matricula,
    nom_prof
FROM
    professores
    INNER JOIN cursos USING ( idt_prof )
ORDER BY
    cod_curso ASC;
    
-- 3.1

SELECT
    *
FROM
    professores
ORDER BY
    mat_prof ASC;

INSERT INTO professores (
    idt_prof,
    mat_prof,
    nom_prof
) VALUES (
    1,
    1500,
    'Kaneki Ken'
);

-- 3.2

UPDATE cursos
SET
    idt_prof = (
        SELECT
            idt_prof
        FROM
            professores
        WHERE
            idt_prof = 1
    )
WHERE
    cod_curso = 52;

-- 4

SELECT
    *
FROM
    periodos_letivos p
WHERE
    NOT EXISTS (
        SELECT
            1
        FROM
            historicos h
        WHERE
            h.ano = p.ano
            AND h.semestre = p.semestre
    )
        AND NOT EXISTS (
        SELECT
            1
        FROM
            turmas t
        WHERE
            t.ano = p.ano
            AND t.semestre = p.semestre
    )
        AND NOT EXISTS (
        SELECT
            1
        FROM
            matriculas m
        WHERE
            m.ano = p.ano
            AND m.semestre = p.semestre
    );
    
-- 5

DELETE FROM periodos_letivos p
WHERE
    NOT EXISTS (
        SELECT
            1
        FROM
            historicos h
        WHERE
            h.ano = p.ano
            AND h.semestre = p.semestre
    )
        AND NOT EXISTS (
        SELECT
            1
        FROM
            turmas t
        WHERE
            t.ano = p.ano
            AND t.semestre = p.semestre
    )
        AND NOT EXISTS (
        SELECT
            1
        FROM
            matriculas m
        WHERE
            m.ano = p.ano
            AND m.semestre = p.semestre
    );
    
-- 6

SELECT
    cod_curso   "CÓDIGO CURSO",
    nom_curso   curso,
    MAX(mgp)
FROM
    cursos
    INNER JOIN alunos USING ( cod_curso )
GROUP BY
    cod_curso,
    nom_curso;
    
-- 7    

SELECT
    nom_curso   curso,
    COUNT(mat_alu) "TOTAL DE ALUNOS"
FROM
    alunos
    INNER JOIN cursos USING ( cod_curso )
GROUP BY
    cod_curso,
    nom_curso;
    
-- 8    

SELECT
    ano,
    semestre,
    nom_disc   disciplina
FROM
    disciplinas d
    INNER JOIN historicos h ON d.cod_disc = h.cod_disc
GROUP BY
    ano,
    semestre,
    nom_disc
HAVING
    ( (
        SELECT
            COUNT(mat_alu)
        FROM
            historicos i
        WHERE
            h.ano = i.ano
            AND h.semestre = i.semestre
            AND ( situacao LIKE 'RM'
                  OR situacao LIKE 'RF' )
        GROUP BY
            ano,
            semestre
    ) / (
        SELECT
            COUNT(mat_alu)
        FROM
            historicos i
        WHERE
            h.ano = i.ano
            AND h.semestre = i.semestre
        GROUP BY
            ano,
            semestre
    ) ) > 0.5;
    
-- 9

SELECT
    m.periodo,
    m.cod_disc   codigo,
    (
        SELECT
            nom_disc
        FROM
            disciplinas d
        WHERE
            d.cod_disc = m.cod_disc
    ) disciplina
FROM
    cursos c
    INNER JOIN matrizes m ON c.cod_curso = m.cod_curso
WHERE
    c.cod_curso = 4
ORDER BY
    m.periodo,
    disciplina;
    
-- 10

SELECT
    COUNT(semestre) "QUANTIDADE DE TURMAS"
FROM
    turmas
WHERE
    ano = 1999
    AND idt_prof = NULL
GROUP BY
    ano,
    semestre;
    
-- 11

SELECT
    cod_disc   codigo,
    nom_disc   disciplina
FROM
    disciplinas d
WHERE
    (
        SELECT
            COUNT(cod_curso)
        FROM
            matrizes m
        WHERE
            d.cod_disc = m.cod_disc
        GROUP BY
            cod_disc
    ) > 1;
    
-- 12

CREATE TABLE parametros (
    chave       VARCHAR2(30),
    descricao   VARCHAR2(60),
    valor       VARCHAR2(200)
);

ALTER TABLE parametros ADD (
    CONSTRAINT chave_pk PRIMARY KEY ( chave )
        USING INDEX TABLESPACE indices_acad
);

INSERT INTO parametros (
    chave,
    descricao,
    valor
) VALUES (
    'ANO_ATU',
    'Ano atual',
    2011
);

INSERT INTO parametros (
    chave,
    descricao,
    valor
) VALUES (
    'SEM_ATU',
    'Semestre atual',
    1
);

INSERT INTO parametros (
    chave,
    descricao,
    valor
) VALUES (
    'NOM_EMP',
    'Nome da instituição',
    'Universidade Tiradentes'
);

INSERT INTO parametros (
    chave,
    descricao,
    valor
) VALUES (
    'DAT_VEST',
    'Data do vestibular',
    '03/11/2011'
);

-- 13

SELECT
    mat_alu   matricula,
    (
        SELECT
            nom_alu
        FROM
            alunos a
        WHERE
            a.mat_alu = m.mat_alu
    ) nome,
    nota_01   "NOTA 1º UNIDADE",
    nota_02   "NOTA 2º UNIDADE",
    nota_03   "NOTA 3º UNIDADE"
FROM
    matriculas m
WHERE
    EXISTS (
        SELECT
            1
        FROM
            disciplinas d
        WHERE
            m.cod_disc = d.cod_disc
            AND lower(nom_disc) LIKE '%banco de dados%'
    )
ORDER BY
    nome;
    
-- 14

SELECT
    nom_disc   disciplina
FROM
    disciplinas d
WHERE
    creditos = 6
    AND NOT EXISTS (
        SELECT
            1
        FROM
            historicos h
        WHERE
            d.cod_disc = h.cod_disc
    )
ORDER BY
    disciplina;

-- 15

SELECT
    nom_disc   disciplina
FROM
    disciplinas d
WHERE
    creditos = 6
    AND NOT EXISTS (
        SELECT
            1
        FROM
            matriculas m
        WHERE
            d.cod_disc = m.cod_disc
    )
ORDER BY
    disciplina;

-- 16

SELECT
    nom_disc   disciplina
FROM
    disciplinas d
WHERE
    creditos > 6
    AND NOT EXISTS (
        SELECT
            1
        FROM
            matriculas m
        WHERE
            d.cod_disc = m.cod_disc
    )
    AND NOT EXISTS (
        SELECT
            1
        FROM
            historicos h
        WHERE
            d.cod_disc = h.cod_disc
    )
ORDER BY
    disciplina;
    
-- 17

SELECT
    COUNT(cod_disc) "NUMERO DE DISCIPLINAS"
FROM
    turmas t
WHERE
    ano = 2011
    AND semestre = 3
    AND vagas = (
        SELECT
            COUNT(mat_alu)
        FROM
            matriculas m
        WHERE
            t.ano = m.ano
            AND t.semestre = m.semestre
    );
    
-- 18

SELECT
    nom_alu   nome
FROM
    alunos
WHERE
    mgp = (
        SELECT
            MAX(mgp)
        FROM
            alunos
    );
    
-- 19

UPDATE matriculas
SET
    nota_01 = 7.5,
    nota_02 = 3,
    nota_03 = 8.5,
    faltas_01 = 2,
    faltas_02 = 8,
    faltas_03 = 1
WHERE
    cod_disc = 3855
    AND ano = 2011
    AND semestre = 3
    AND mat_alu = 3835;
    
-- 20

SELECT
    (
        SELECT
            nom_prof
        FROM
            professores p
        WHERE
            p.idt_prof = t.idt_prof
    ) professor
FROM
    turmas t
WHERE
    ( (
        SELECT
            COUNT(mat_alu)
        FROM
            historicos h
        WHERE
            h.ano = t.ano
            AND h.semestre = t.semestre
            AND ( situacao LIKE ( 'RM' )
                  OR situacao LIKE ( 'RF' ) )
        GROUP BY
            ano,
            semestre
    ) / (
        SELECT
            COUNT(mat_alu)
        FROM
            historicos h
        WHERE
            h.ano = t.ano
            AND h.semestre = t.semestre
        GROUP BY
            ano,
            semestre
    ) ) > 0.6;