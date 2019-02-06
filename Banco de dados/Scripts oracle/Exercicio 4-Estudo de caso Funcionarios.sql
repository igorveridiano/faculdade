-- Exercicios Estudo de caso Funcionarios
-- 1
SELECT
    codigo   codigo,
    nome     nome
FROM
    funcionarios
WHERE
    codigo = SOME (
        SELECT
            cod_chefe
        FROM
            funcionarios
    );

-- 2

SELECT
    f.codigo   "CODIGO FUNCIONARIO",
    f.nome     funcionario,
    t.codigo   "CODIGO CHEFE",
    t.nome     chefe
FROM
    funcionarios f
    LEFT JOIN funcionarios t ON f.cod_chefe = t.codigo;
    
-- 3

SELECT
    f.codigo   codigo,
    f.nome     nome
FROM
    funcionarios f
WHERE
    f.salario > (
        SELECT
            t.salario
        FROM
            funcionarios t
        WHERE
            f.cod_chefe = t.codigo
    );

-- 5
     WITH relacao_chefias AS (
      SELECT
          f.codigo      codigo,
          t.codigo      cod_chefe,
          t.cod_chefe   cod_chefe_chefe
      FROM
          funcionarios f
          INNER JOIN funcionarios t ON f.cod_chefe = t.codigo
  )
  SELECT
      nome   nome,
      CASE
          WHEN f.cod_chefe IS NULL THEN 'NÍVEL GERENCIAL'
          WHEN (
              SELECT
                  COUNT(*)
              FROM
                  relacao_chefias r
              WHERE
                  f.codigo = r.codigo
                  AND r.cod_chefe_chefe IS NOT NULL
          ) = 0 THEN 'NÍVEL TÁTICO'
          WHEN (
              SELECT
                  COUNT(*)
              FROM
                  relacao_chefias r
              WHERE
                  f.codigo = r.codigo
                  AND r.cod_chefe_chefe IS NOT NULL
          ) >= 1 THEN 'NÍVEL OPERACIONAL'
      END "NÍVEL"
  FROM
      funcionarios f;