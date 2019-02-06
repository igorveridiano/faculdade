-- 1.1
DELETE FROM matriculas m
WHERE
    (
        SELECT
            COUNT(*)
        FROM
            historicos h
        WHERE
            h.mat_alu = m.mat_alu
            AND h.cod_disc = m.cod_disc
    ) > 0;

ROLLBACK;
-- 1.2

DELETE FROM matriculas m
WHERE
    EXISTS (
        SELECT
            1
        FROM
            historicos h
        WHERE
            h.mat_alu = m.mat_alu
            AND h.cod_disc = m.cod_disc
    );

ROLLBACK;

-- 2

UPDATE alunos a
SET
    mgp = nvl( (
        SELECT
            AVG(media)
        FROM
            historicos h
        WHERE
            h.mat_alu = a.mat_alu
            AND h.situacao <> 'RF'
            AND EXISTS(
                SELECT
                    1
                FROM
                    matrizes m
                WHERE
                    m.cod_curso = a.cod_curso
                    AND m.cod_disc = h.cod_disc
            )
    ),0);

ROLLBACK;