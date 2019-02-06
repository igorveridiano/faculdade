--Merge

CREATE TABLE dm_cursos
    AS
        SELECT
            *
        FROM
            cursos
        WHERE
            1 <> 1;

MERGE INTO dm_cursos dc USING cursos c ON ( c.cod_curso = dc.cod_curso )
WHEN MATCHED THEN UPDATE SET dc.nom_curso = c.nom_curso,
                             dc.tot_cred = c.tot_cred,
                             dc.idt_prof = c.idt_prof
WHEN NOT MATCHED THEN INSERT (
    dc.cod_curso,
    dc.nom_curso,
    dc.tot_cred,
    dc.idt_prof ) VALUES (
    c.cod_curso,
    c.nom_curso,
    c.tot_cred,
    c.idt_prof );

SELECT
    *
FROM
    dm_cursos;

DROP TABLE dm_cursos;

ROLLBACK;