 -- Prova Semestre anterior
-- Questão 01
-- A
SELECT
    cod_comp   "CÓDIGO COMPANHIA",
    cod_tpa    "CÓDIGO TIPO AVIÃO",
    horario    "HORÁRIO DO VÔO"
FROM
    voos
WHERE
    ( dia = 2
      OR dia = 4 )
    AND horario BETWEEN 2000 AND 2200;

-- B
SELECT
    cod_comp   "CÓDIGO COMPANHIA",
    (
        SELECT
            c.dsc_comp
        FROM
            companhias_aereas c
        WHERE
            v.cod_comp = c.cod_comp
    ) "NOME DA COMPANHIA",
    cod_voo    "CÓDIGO DO VÔO"
FROM
    voos v
WHERE
    (
        SELECT
            t1.capacidade
        FROM
            tipos_avioes t1
        WHERE
            v.cod_tpa = t1.cod_tpa
    ) = (
        SELECT
            MAX(capacidade)
        FROM
            tipos_avioes
            INNER JOIN voos USING ( cod_tpa )
    )
ORDER BY
    v.cod_comp;
    
-- C

SELECT
    cod_cid   "CÓDIGO DA CIDADE",
    nom_cid   "NOME DA CIDADE",
    (
        SELECT
            dsc_pais
        FROM
            paises p
        WHERE
            c.cod_pais = p.cod_pais
    ) "PAÍS"
FROM
    cidades c
WHERE
    EXISTS (
        SELECT
            1
        FROM
            aeroportos a
        WHERE
            c.cod_cid = a.cod_cid
            AND tpo_aero LIKE ( 'I' )
    );  
    
-- D

SELECT
    cod_comp   "CÓDIGO DA COMPANHIA",
    (
        SELECT
            dsc_comp
        FROM
            companhias_aereas c
        WHERE
            v.cod_comp = c.cod_comp
    ) "NOMDE DA COMPANHIA",
    cod_voo    "CÓDIGO DO VÔO",
    horario    "HORÁRIO DO VÔO",
    (
        SELECT
            COUNT(*)
        FROM
            escalas e
        WHERE
            v.cod_voo = e.cod_voo
    ) "QUANTIDADE DE ESCALAS"
FROM
    voos v
ORDER BY
    cod_comp;

-- E

WITH quantidade_escalas AS (
    SELECT
        cod_voo,
        COUNT(*) quant_esc
    FROM
        escalas
    GROUP BY
        cod_voo
)
SELECT
    v.cod_comp   "CÓDIGO DA COMPANHIA",
    (
        SELECT
            c.dsc_comp
        FROM
            companhias_aereas c
        WHERE
            v.cod_comp = c.cod_comp
    ) "NOMDE DA COMPANHIA",
    v.cod_voo    "CÓDIGO DO VÔO",
    v.horario    "HORÁRIO DO VÔO"
FROM
    voos v
    INNER JOIN quantidade_escalas q ON v.cod_voo = q.cod_voo
WHERE
    EXISTS (
        SELECT
            1
        FROM
            escalas e
        WHERE
            v.cod_voo = e.cod_voo
            AND e.num_esc = 1
                AND e.cod_aero LIKE ( 'SLV' )
    )
    AND EXISTS (
        SELECT
            1
        FROM
            escalas e
        WHERE
            v.cod_voo = e.cod_voo
            AND e.num_esc = q.quant_esc
                AND e.cod_aero LIKE ( 'GUA' )
    )
        AND q.quant_esc <= 4;