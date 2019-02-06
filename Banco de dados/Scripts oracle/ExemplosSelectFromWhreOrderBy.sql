SELECT
    'Exemplo de Constante' constante,
    dummy,
    'Data atual: ' || TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI:SS') "Expressão"
FROM
    dual;

SELECT
    alunos.mat_alu    matricula,
    replace(alunos.nom_alu,'- TESTE') "NOME DO ALUNO REPLACE",
    rtrim(alunos.nom_alu,'- TESTE') "NOME DO ALUNO RTRIM",
    alunos.dat_nasc   "DATA NASCIMENTO",
    trunc(months_between(SYSDATE,alunos.dat_nasc) / 12) "IDADE DO ALUNO",
    EXTRACT(YEAR FROM dat_nasc) "ANO NASCIMENTO"
FROM
    alunos;

SELECT
    alunos.mat_alu   AS matricula,
    alunos.nom_alu   AS nome,
    alunos.mgp       AS "MEDIA PONDERADA"
FROM
    alunos
WHERE
    alunos.cod_curso = 4
    AND alunos.mgp > 7;

SELECT
    a.mat_alu     AS "Matricula",
    a.nom_alu     AS "Nome",
    a.cod_curso   AS "Curso"
FROM
    alunos a
WHERE
    cod_curso = 44
    OR cod_curso = 13;

SELECT
    a.mat_alu     AS "Matricula",
    a.nom_alu     AS "Nome",
    a.cod_curso   AS "Curso"
FROM
    alunos a
WHERE
    cod_curso IN (
        44,
        13
    );

SELECT
    a.mat_alu     AS "Matricula",
    a.nom_alu     AS "Nome",
    a.cod_curso   AS "Curso"
FROM
    alunos a
WHERE
    cod_curso = 26
    AND mgp >= 5;

SELECT
    a.mat_alu     AS "Matricula",
    a.nom_alu     AS "Nome",
    a.cod_curso   AS "Curso"
FROM
    alunos a
WHERE
    mgp BETWEEN 3 AND 5;

SELECT
    a.mat_alu     AS "Matricula",
    a.nom_alu     AS "Nome",
    a.cod_curso   AS "Curso"
FROM
    alunos a
WHERE
    mgp NOT BETWEEN 3 AND 5;

SELECT
    a.mat_alu     AS "Matricula",
    a.nom_alu     AS "Nome",
    a.cod_curso   AS "Curso"
FROM
    alunos a
WHERE
    cod_curso NOT IN (
        10,
        8
    );

SELECT DISTINCT
    cod_curso
FROM
    alunos
WHERE
    upper(nom_alu) LIKE '%OLIVEIRA%'
    OR upper(nom_alu) LIKE '%SANTOS%';

SELECT
    cod_curso,
    mat_alu,
    nom_alu,
    mgp
FROM
    alunos
WHERE
    dat_nasc >= '01/01/1990'
    AND mgp > 7
ORDER BY
    cod_curso,
    nom_alu DESC;

SELECT
    cod_curso,
    mat_alu,
    nom_alu,
    mgp
FROM
    alunos
WHERE
    dat_nasc >= '01/01/1990'
    AND mgp > 7
ORDER BY
    cod_curso,
    nom_alu ASC;

SELECT
    cod_curso,
    nom_curso,
    tot_cred
FROM
    cursos
ORDER BY
    2,
    tot_cred;