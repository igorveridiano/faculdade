-- Exercicios Iniciais
-- 1

SELECT
    alunos.mat_alu    matricula,
    replace(alunos.nom_alu,'- TESTE') nome,
    alunos.dat_nasc   "DATA NASCIMENTO"
FROM
    alunos
WHERE
    alunos.cod_curso = 44
ORDER BY
    alunos.dat_nasc ASC;

-- 2

SELECT
    alunos.mat_alu    matricula,
    replace(alunos.nom_alu,'- TESTE') nome,
    alunos.dat_nasc   "DATA NASCIMENTO"
FROM
    alunos
WHERE
    alunos.cod_curso = 44
ORDER BY
    trunc(months_between(SYSDATE,alunos.dat_nasc) / 12) DESC;

-- 3

SELECT
    alunos.cod_curso   "CODIGO CURSO",
    alunos.mat_alu     matricula,
    replace(alunos.nom_alu,'- TESTE') nome
FROM
    alunos
WHERE
    alunos.cod_curso IN (
        44,
        13
    )
    AND mgp > 7
ORDER BY
    alunos.cod_curso,
    alunos.nom_alu ASC;

-- 4

SELECT
    alunos.mat_alu   matricula,
    replace(alunos.nom_alu,'- TESTE') nome
FROM
    alunos
WHERE
    lower(alunos.nom_alu) LIKE '%maria%'
ORDER BY
    alunos.nom_alu ASC;