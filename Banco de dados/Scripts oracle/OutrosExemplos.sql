-- Construção SQL Completa - SELECT, FROM, WHERE, GROUP BY, HAVING e ORDER BY
SELECT
    cod_curso,
    nom_curso,
    COUNT(*) total_alunos,
    COUNT(DISTINCT cod_curso) tot_cursos_dif,
    MAX(mgp) maior_mgp,
    MIN(mgp) menor_mgp,
    trunc(AVG(mgp),2) media_geral_mgp
FROM
    alunos
    JOIN cursos USING ( cod_curso )
WHERE
    cod_curso IN (
        103,
        52,
        125,
        26
    )
GROUP BY
    cod_curso,
    nom_curso
HAVING
    COUNT(*) > 110
ORDER BY
    cod_curso;   
 
-- Group BY com expressão  

SELECT
    ano,
    semestre,
    ano
    || '/'
    || DECODE(semestre,1,'Primeiro',2,'Inverno',3,'Segundo',4,'Verão') per_letivo,
    CASE
        WHEN semestre = 1 THEN 'Primeiro'
        WHEN semestre = 2 THEN 'Inverno'
        ELSE 'Não sei'
    END per_let_2,
    COUNT(*)
FROM
    historicos
GROUP BY
    ano,
    semestre,
    ano
    || '/'
    || DECODE(semestre,1,'Primeiro',2,'Inverno',3,'Segundo',4,'Verão'),
    CASE
        WHEN semestre = 1 THEN 'Primeiro'
        WHEN semestre = 2 THEN 'Inverno'
        ELSE 'Não sei'
    END
ORDER BY
    1,
    2;