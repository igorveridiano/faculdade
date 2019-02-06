-- Insert exemples
SELECT
    *
FROM
    cursos;

-- 1

INSERT INTO cursos VALUES (
    130,
    'Medicina',
    500,
    NULL
);

-- 2

INSERT INTO cursos (
    cod_curso,
    nom_curso,
    idt_prof,
    tot_cred
) VALUES (
    130,
    'Medicina',
    NULL,
    500
);

-- 3

INSERT INTO cursos (
    nom_curso,
    tot_cred,
    cod_curso
) VALUES (
    'Medicina',
    500,
    130
);

-- 4

INSERT INTO cursos (
    cod_curso,
    nom_curso,
    idt_prof,
    tot_cred
) VALUES (
    130,
    'Medicina',
    1865,
    500
);

ROLLBACK;

-- Delete examples

-- 1

DELETE FROM cursos;

-- 2

DELETE FROM cursos
WHERE
    cod_curso IN (
        26,
        52
    );


-- 3

DELETE FROM cursos c
WHERE
    cod_curso NOT IN (
        SELECT
            cod_curso
        FROM
            alunos
    );

DELETE FROM cursos c
WHERE
    cod_curso NOT IN (
        SELECT
            cod_curso
        FROM
            alunos
    )
    AND cod_curso NOT IN (
        SELECT
            cod_curso
        FROM
            matrizes
    );

-- 4

DELETE FROM cursos c
WHERE
    NOT EXISTS (
        SELECT
            1
        FROM
            alunos a
        WHERE
            c.cod_curso = a.cod_curso
    )
        AND NOT EXISTS (
        SELECT
            1
        FROM
            matrizes m
        WHERE
            m.cod_curso = c.cod_curso
    );

ROLLBACK;

-- Update exemples

-- 1 

UPDATE cursos
SET
    nom_curso = 'Desenvolimento de Aplicações Web',
    tot_cred = tot_cred + 20
WHERE
    cod_curso = 95;

-- 2

UPDATE cursos
SET
    tot_cred = 210;

-- 3

UPDATE cursos
SET
    tot_cred = 300
WHERE
    cod_curso IN (
        SELECT DISTINCT
            cod_curso
        FROM
            alunos
        WHERE
            mgp > 9
    );

-- 4

UPDATE cursos c
SET
    tot_cred = 0
WHERE
    NOT EXISTS (
        SELECT
            mat_alu
        FROM
            alunos a
        WHERE
            c.cod_curso = a.cod_curso
    );

-- 5

UPDATE cursos c
SET
    tot_cred = nvl( (
        SELECT
            SUM(creditos)
        FROM
            matrizes m
            INNER JOIN disciplinas d USING(cod_disc)
        WHERE
            c.cod_curso = m.cod_curso
        HAVING
            SUM(creditos) < 1000
    ),0);
    
-- 6

UPDATE cursos c
SET
    tot_cred = 0
WHERE
    (
        SELECT
            COUNT(*)
        FROM
            alunos a
        WHERE
            a.cod_curso = c.cod_curso
    ) = 0;

ROLLBACK;