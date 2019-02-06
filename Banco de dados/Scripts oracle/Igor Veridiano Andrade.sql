-- Questão 01
SELECT
    cod_filme   "CÓDIGO DO FILME",
    tit_filme   filme,
    censura
FROM
    filmes f
WHERE
    (
        SELECT
            cod_cinema
        FROM
            cinemas
        WHERE
            lower(nom_cinema) LIKE ( 'cine rio-mar%' )
    ) IN (
        SELECT
            cod_cinema
        FROM
            sessoes s
        WHERE
            f.cod_filme = s.cod_filme
    );
    
-- Questão 02

WITH cine_filmes AS (
    SELECT
        (
            SELECT
                cod_prod
            FROM
                filmes f
            WHERE
                f.cod_filme = s.cod_filme
        ) cod_prod,
        (
            SELECT
                tit_filme
            FROM
                filmes f
            WHERE
                f.cod_filme = s.cod_filme
        ) filme,
        (
            SELECT
                nom_cinema
            FROM
                cinemas c
            WHERE
                c.cod_cinema = s.cod_cinema
        ) cinema
    FROM
        sessoes s
)
SELECT
    cinema,
    filme,
    nom_prod   produtora
FROM
    produtoras
    INNER JOIN cine_filmes USING ( cod_prod )
WHERE
    lower(nom_prod) LIKE ( 'fox%' );
    
-- Questão 03

INSERT INTO filmes (
    cod_filme,
    tit_filme,
    ano_filme,
    cod_prod,
    dur_min,
    censura
) VALUES (
    5,
    'Rei Leão',
    1993,
    1,
    120,
    8
);

INSERT INTO direcoes (
    cod_diretor,
    cod_filme,
    avaliacao
) VALUES (
    2,
    5,
    8.7
);

COMMIT;

SELECT
    nom_diretor   diretor
FROM
    diretores d1
WHERE
    1 < SOME (
        SELECT
            COUNT(DISTINCT(cod_prod) )
        FROM
            filmes f
            INNER JOIN direcoes d2 ON f.cod_filme = d2.cod_filme
        WHERE
            d2.cod_diretor = d1.cod_diretor
        GROUP BY
            f.ano_filme
    );

-- Questão 04

SELECT
    (
        SELECT
            nom_cinema
        FROM
            cinemaS c
        WHERE
            c.cod_cinema = s.cod_cinema
    ) cinema,
    (
        SELECT
            tit_filme
        FROM
            filmes f
        WHERE
            f.cod_filme = s.cod_filme
    ) filme,
    COUNT(DISTINCT(num_sala) ) "QUANTIDADE DE SALAS"
FROM
    sessoes s
GROUP BY
    s.cod_cinema,
    s.cod_filme
HAVING
    COUNT(DISTINCT(num_sala) ) > 1;
    
-- Questão 05

SELECT
    cod_filme   "CÓDIGO DO FILME",
    tit_filme   filme,
    censura
FROM
    filmes f
WHERE
    (
        SELECT
            cod_cinema
        FROM
            cinemas
        WHERE
            lower(nom_cinema) LIKE ( 'cine rio-mar%' ) 
    ) IN (
    SELECT
        cod_cinema
    FROM
        sessoes s
    WHERE
        f.cod_filme = s.cod_filme
) AND (
    SELECT
        cod_cinema
    FROM
        cinemas
    WHERE
        lower(nom_cinema) LIKE ( 'cinemark jardins%' )
) IN
( SELECT
    cod_cinema
FROM
    sessoes s
WHERE
    f.cod_filme = s.cod_filme
);