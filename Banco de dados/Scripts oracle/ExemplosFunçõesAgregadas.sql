-- Exclus�o de tabela sem deixar backup
DROP TABLE teste PURGE;

-- Cria��o de tabela

CREATE TABLE teste (
    numero   NUMBER(10)
);
    
-- Inclus�o de dados

INSERT INTO teste VALUES ( 10 );

INSERT INTO teste VALUES ( 20 );

INSERT INTO teste VALUES ( 30 );

INSERT INTO teste VALUES ( 20 );

INSERT INTO teste VALUES ( NULL );

COMMIT;

-- Conteudo da tabela

SELECT
    *
FROM
    teste;


-- Fun��o agregada count:
-- quantidade de linhas da tabela(inclusive null)

SELECT
    COUNT(*) total_linhas
FROM
    teste;

-- Fun��o agregada count:
-- linhas distintas da tabela(neste caso o null n�o � considerado)

SELECT
    COUNT(numero)
FROM
    teste;

SELECT
    COUNT(DISTINCT numero)
FROM
    teste;

-- Fun��o agregada sum: soma dos numeros (null n�o � considerado)

SELECT
    SUM(numero)
FROM
    teste;

SELECT
    SUM(DISTINCT numero)
FROM
    teste;

-- Fun��o agregada avg: m�dia aritmetica (null n�o � considerado)

SELECT
    AVG(nvl(numero,0) )
FROM
    teste;

SELECT
    AVG(numero)
FROM
    teste;

-- Fun��o agregada max: retorna o maximo

SELECT
    MAX(numero)
FROM
    teste;

--Fun��o agregada min: retorna o minimo

SELECT
    MIN(numero)
FROM
    teste;