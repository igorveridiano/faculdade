--Cartesiano
SELECT
    d.nom_disc,
    a.mat_alu,
    a.nom_alu
FROM
    periodos_letivos l,
    historicos h,
    disciplinas d,
    alunos a
WHERE
    l.ano = h.ano
    AND l.semestre = h.semestre
    AND h.cod_disc = d.cod_disc
    AND h.mat_alu = a.mat_alu
    AND d.cod_disc = '3810'
    AND h.ano = 2008
    AND h.semestre = 3
    AND h.situacao = 'AP'
    AND h.media > 7
ORDER BY
    a.nom_alu;       
  
--Join - on

SELECT
    d.nom_disc,
    a.mat_alu,
    a.nom_alu
FROM
    historicos h
    JOIN periodos_letivos l ON h.ano = l.ano
                               AND h.semestre = l.semestre
    JOIN disciplinas d ON h.cod_disc = d.cod_disc
    JOIN alunos a ON h.mat_alu = a.mat_alu
WHERE
    d.cod_disc = '3810'
    AND h.ano = 2008
    AND h.semestre = 3
    AND h.situacao = 'AP'
    AND h.media > 7
ORDER BY
    a.nom_alu;      

--inner join - on

SELECT
    d.nom_disc,
    a.mat_alu,
    a.nom_alu
FROM
    historicos h
    INNER JOIN periodos_letivos l ON h.ano = l.ano
                                     AND h.semestre = l.semestre
    INNER JOIN disciplinas d ON h.cod_disc = d.cod_disc
    INNER JOIN alunos a ON h.mat_alu = a.mat_alu
WHERE
    d.cod_disc = '3810'
    AND h.ano = 2008
    AND h.semestre = 3
    AND h.situacao = 'AP'
    AND h.media > 7
ORDER BY
    a.nom_alu;      
  
--Join - using

SELECT
    nom_disc,
    mat_alu,
    nom_alu
FROM
    historicos
    JOIN periodos_letivos USING ( ano,
                                  semestre )
    JOIN disciplinas USING ( cod_disc )
    JOIN alunos USING ( mat_alu )
WHERE
    cod_disc = '3810'
    AND ano = 2008
    AND semestre = 3
    AND situacao = 'AP'
    AND media > 7
ORDER BY
    nom_alu;      
  
--inner join - using

SELECT
    nom_disc,
    mat_alu,
    nom_alu
FROM
    historicos
    INNER JOIN periodos_letivos USING ( ano,
                                        semestre )
    INNER JOIN disciplinas USING ( cod_disc )
    INNER JOIN alunos USING ( mat_alu )
WHERE
    cod_disc = '3810'
    AND ano = 2008
    AND semestre = 3
    AND situacao = 'AP'
    AND media > 7
ORDER BY
    nom_alu;