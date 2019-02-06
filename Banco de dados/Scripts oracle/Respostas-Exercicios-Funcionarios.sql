-- Respostas Exercicios Funcionarios

/*1. Listar todos os funcion?rios que exercem o papel de lideran?a;
*/
SELECT
    codigo,
    nome,
    cod_chefe
FROM
    funcionarios f
WHERE
    EXISTS (
        SELECT
            1
        FROM
            funcionarios f1
        WHERE
            f1.cod_chefe = f.codigo
    );

SELECT
    codigo,
    nome,
    cod_chefe
FROM
    funcionarios f
WHERE
    f.codigo IN (
        SELECT
            cod_chefe
        FROM
            funcionarios
    );

WITH chefes AS (
    SELECT DISTINCT
        cod_chefe   codigo
    FROM
        funcionarios
    WHERE
        cod_chefe IS NOT NULL
)
SELECT
    codigo,
    nome,
    cod_chefe
FROM
    funcionarios
    JOIN chefes USING ( codigo );

SELECT
    codigo,
    nome,
    cod_chefe
FROM
    funcionarios
    JOIN (
        SELECT DISTINCT
            cod_chefe   codigo
        FROM
            funcionarios
        WHERE
            cod_chefe IS NOT NULL
    ) USING ( codigo );

SELECT
    codigo,
    nome,
    cod_chefe
FROM
    funcionarios f
WHERE
    (
        SELECT
            COUNT(*)
        FROM
            funcionarios f1
        WHERE
            f1.cod_chefe = f.codigo
    ) > 0;

WITH chefes AS (
    SELECT
        cod_chefe   codigo,
        COUNT(*) subordinados
    FROM
        funcionarios
    GROUP BY
        cod_chefe
)
SELECT
    codigo,
    nome,
    subordinados
FROM
    funcionarios
    JOIN chefes USING ( codigo );

SELECT
    f.cod_chefe   codigo,
    c.nome,
    COUNT(*) subordinados
FROM
    funcionarios f
    JOIN funcionarios c ON f.cod_chefe = c.codigo
GROUP BY
    f.cod_chefe,
    c.nome;

/*2. Listar os funcion?rios e respectivos chefes. Exibir matr?cula e nome;
*/

SELECT
    f.nome   funcionario,
    nvl(c.nome,'* Não tem chefe *') chefe
FROM
    funcionarios f
    LEFT JOIN funcionarios c ON f.cod_chefe = c.codigo
ORDER BY
    f.codigo;

SELECT
    f.*,
    nvl( (
        SELECT
            c.nome
        FROM
            funcionarios c
        WHERE
            c.codigo = f.cod_chefe
    ),'Sem chefe!!!') chefe
FROM
    funcionarios f;

WITH chefes AS (
    SELECT
        codigo   cod_chefe,
        nome
    FROM
        funcionarios f
    WHERE
        f.codigo IN (
            SELECT
                cod_chefe
            FROM
                funcionarios
        )
)
SELECT
    f.*,
    c.*
FROM
    funcionarios f
    LEFT JOIN chefes c ON f.cod_chefe = c.cod_chefe;

/*3. Recupere todos os liderados com salário superior ao chefe imediato;*/

SELECT
    *
FROM
    funcionarios;

UPDATE funcionarios
SET
    salario = 1001
WHERE
    codigo = 2;

SELECT
    f.codigo,
    f.nome,
    f.salario,
    f.cod_chefe,
    (
        SELECT
            nome
        FROM
            funcionarios
        WHERE
            codigo = f.cod_chefe
    ) nome_chefe,
    (
        SELECT
            salario
        FROM
            funcionarios
        WHERE
            codigo = f.cod_chefe
    ) salario_chefe
FROM
    funcionarios f
WHERE
    EXISTS (
        SELECT
            1
        FROM
            funcionarios f1
        WHERE
            f1.codigo = f.cod_chefe
            AND f.salario > f1.salario
    );

SELECT
    f.codigo,
    f.nome,
    f.salario,
    f.cod_chefe
FROM
    funcionarios f
    JOIN funcionarios f1 ON f1.codigo = f.cod_chefe
WHERE
    f.salario > f1.salario;

/*
4. Com base na quest?o anterior, atualize o sal?rio do chefe com acr?scimo
de mil reais em rela??o ao maior sal?rio;*/

SELECT
    f.codigo,
    f.nome,
    f.salario,
    f.cod_chefe,
    (
        SELECT
            MAX(salario) + 1000
        FROM
            funcionarios
        WHERE
            cod_chefe = f.codigo
    ) maior_salario
FROM
    funcionarios f
WHERE
    EXISTS (
        SELECT
            1
        FROM
            funcionarios f1
        WHERE
            f1.cod_chefe = f.codigo
            AND f.salario < f1.salario
    );

UPDATE funcionarios f
SET
    salario = (
        SELECT
            MAX(salario) + 1000
        FROM
            funcionarios
        WHERE
            cod_chefe = f.codigo
    )
WHERE
    EXISTS (
        SELECT
            1
        FROM
            funcionarios f1
        WHERE
            f1.cod_chefe = f.codigo
            AND f.salario < f1.salario
    );


/*
5. Considerando:
a) N?vel gerencial: Todos os funcion?rios que n?o possuem chefe;
b) N?vel t?tico: Todos os funcion?rios que possui um ?nico 
superior na hierarquia;
c) N?vel operacional: Todos os funcion?rios que possuem mais de um
superior na hirarquia funcional;
Elabore uma consulta que liste todos os funcion?rios com n?vel que 
se enquadra;
*/

/*
Consulta hier?rquica
*/

SELECT
    f.*,
    CASE
        WHEN cod_chefe IS NULL THEN 'Gerencial'
        WHEN (
            SELECT
                f1.cod_chefe
            FROM
                funcionarios f1
            WHERE
                f1.codigo = f.cod_chefe
        ) IS NULL THEN 'Tático'
        ELSE 'Operacional'
    END hierarquia
FROM
    funcionarios f;

SELECT
    codigo,
    lpad(' ',level * 4 - 1)
    || nome nome,
    cod_chefe,
    CASE
        WHEN cod_chefe IS NULL THEN 'Gerencial'
        WHEN (
            SELECT
                f1.cod_chefe
            FROM
                funcionarios f1
            WHERE
                f1.codigo = f.cod_chefe
        ) IS NULL THEN 'Tático'
        ELSE 'Operacional'
    END hierarquia
FROM
    funcionarios f
START WITH
    cod_chefe IS NULL
CONNECT BY
    cod_chefe = PRIOR codigo;