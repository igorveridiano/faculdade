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