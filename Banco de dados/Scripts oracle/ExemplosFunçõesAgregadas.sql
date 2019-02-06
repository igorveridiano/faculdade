-- Exclusão de tabela sem deixar backup
DROP TABLE teste PURGE;

-- Criação de tabela

CREATE TABLE teste (
    numero   NUMBER(10)
);
    
-- Inclusão de dados

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


-- Função agregada count:
-- quantidade de linhas da tabela(inclusive null)

SELECT
    COUNT(*) total_linhas
FROM
    teste;

-- Função agregada count:
-- linhas distintas da tabela(neste caso o null não é considerado)

SELECT
    COUNT(numero)
FROM
    teste;

SELECT
    COUNT(DISTINCT numero)
FROM
    teste;

-- Função agregada sum: soma dos numeros (null não é considerado)

SELECT
    SUM(numero)
FROM
    teste;

SELECT
    SUM(DISTINCT numero)
FROM
    teste;

-- Função agregada avg: média aritmetica (null não é considerado)

SELECT
    AVG(nvl(numero,0) )
FROM
    teste;

SELECT
    AVG(numero)
FROM
    teste;

-- Função agregada max: retorna o maximo

SELECT
    MAX(numero)
FROM
    teste;

--Função agregada min: retorna o minimo

SELECT
    MIN(numero)
FROM
    teste;