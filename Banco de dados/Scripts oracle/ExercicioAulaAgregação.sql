-- 1
SELECT
    cod_curso   curso,
    COUNT(DISTINCT mat_alu) "Total alunos"
FROM
    alunos
GROUP BY
    cod_curso
ORDER BY
    cod_curso ASC;
  
-- 2

SELECT
    cod_disc   disciplina,
    COUNT(DISTINCT mat_alu) "Total alunos"
FROM
    matriculas
GROUP BY
    cod_disc
HAVING
    COUNT(DISTINCT mat_alu) > 10;
  
-- 3

SELECT
    MAX(mgp) "Maior mgp",
    MIN(mgp) "Menor mgp"
FROM
    alunos;
  
-- 4

SELECT
    ano,
    semestre,
    COUNT(DISTINCT mat_alu) "Total alunos"
FROM
    matriculas
GROUP BY
    ano,
    semestre;

-- 5

SELECT
    cod_disc   disciplina,
    nom_disc   nome,
    creditos   creditos
FROM
    disciplinas
    INNER JOIN matrizes USING ( cod_disc )
WHERE
    cod_curso = 13
ORDER BY
    periodo,
    nom_disc;
  
--6

SELECT
    cod_curso   codigo,
    nom_curso   curso,
    COUNT(DISTINCT mat_alu) "Total alunos"
FROM
    alunos
    INNER JOIN cursos USING ( cod_curso )
GROUP BY
    cod_curso,
    nom_curso
ORDER BY
    nom_curso ASC;