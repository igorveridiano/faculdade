--Produto cartesiano
SELECT
    *
FROM
    professores p,
    cursos c
ORDER BY
    p.idt_prof,
    c.cod_curso;

--Junção natural(não usar)

SELECT
    *
FROM
    professores
    NATURAL JOIN cursos;

SELECT
    *
FROM
    alunos
    NATURAL JOIN cursos;

--Junção Interna - opção 01: cartesiano mais seleção--

SELECT
    *
FROM
    cursos c,
    professores p
WHERE
    c.idt_prof = p.idt_prof
    AND c.cod_curso IN (
        26,
        52
    );
  
--Junção interna - opção 02: join- on

SELECT
    *
FROM
    cursos c
    JOIN professores p ON c.idt_prof = p.idt_prof
WHERE
    c.cod_curso IN (
        26,
        52
    );
  
--Junção interna - opção 03: inner join - on

SELECT
    *
FROM
    cursos c
    INNER JOIN professores p ON c.idt_prof = p.idt_prof
WHERE
    c.cod_curso IN (
        26,
        52
    );
  
--Junção interna - opção 04: join - using

SELECT
    *
FROM
    cursos
    JOIN professores USING ( idt_prof )
WHERE
    cod_curso IN (
        26,
        52
    );
  
--Junção interna - opção 05: inner join - using

SELECT
    *
FROM
    cursos
    INNER JOIN professores USING ( idt_prof )
WHERE
    cod_curso IN (
        26,
        52
    );

--Junção externa a esquerda(left join) opção 01: cartesiano com seleção

SELECT
    *
FROM
    cursos c,
    professores p
WHERE
    c.idt_prof = p.idt_prof (+);

--Junção externa a esquerda(left join) opção 02: left join - on

SELECT
    *
FROM
    cursos c
    LEFT JOIN professores p ON c.idt_prof = p.idt_prof;
  
--Junção externa a esquerda(left join) opção 03: left outer join - on  

SELECT
    *
FROM
    cursos c
    LEFT OUTER JOIN professores p ON c.idt_prof = p.idt_prof;
  
--Junção externa a esquerda(left join) opção 04: left join - using

SELECT
    *
FROM
    cursos left
    JOIN professores USING ( idt_prof );
  
--Junção externa a esquerda(left join) opção 05: left outer join - using

SELECT
    *
FROM
    cursos
    LEFT OUTER JOIN professores USING ( idt_prof );