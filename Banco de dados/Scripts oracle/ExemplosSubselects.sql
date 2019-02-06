-- Exemplo de subselect que retorna uma linha
SELECT
    mat_alu,
    nom_alu,
    mgp
FROM
    alunos
WHERE
    mgp > (
        SELECT
            mgp
        FROM
            alunos
        WHERE
            mat_alu = 89877
    )
ORDER BY
    mgp DESC;

-- Exemplo de subselect que retorna varias linhas

SELECT
    mat_alu,
    nom_alu,
    mgp,
    cod_curso
FROM
    alunos
WHERE
    cod_curso <> 26
    AND mgp >= ALL (
        SELECT
            mgp
        FROM
            alunos
        WHERE
            cod_curso = 26
    )
ORDER BY
    mgp DESC;

SELECT
    cod_curso,
    nom_curso
FROM
    cursos
WHERE
    cod_curso IN (
        SELECT
            cod_curso
        FROM
            alunos
        WHERE
            nom_alu LIKE upper('%maria %')
    );

-- Subselect com mais de um parametro (lista de valores)

SELECT
    cod_curso,
    nom_curso,
    mat_alu,
    nom_alu,
    mgp
FROM
    alunos
    INNER JOIN cursos USING ( cod_curso )
WHERE
    ( cod_curso,
      mgp ) IN (
        SELECT
            cod_curso,
            MAX(mgp)
        FROM
            alunos
        GROUP BY
            cod_curso
    )
ORDER BY
    nom_curso,
    nom_alu;


-- Subselect criando tabela temporaria    

WITH maximo AS (
    SELECT
        cod_curso,
        MAX(mgp) mgp
    FROM
        alunos
    GROUP BY
        cod_curso
)
SELECT
    cod_curso,
    nom_alu,
    mgp
FROM
    alunos
    INNER JOIN maximo USING ( cod_curso,
                              mgp )
WHERE
    ROWNUM <= 5
ORDER BY
    mgp DESC;