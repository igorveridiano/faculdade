--Left join - com valores nulos do lado direito 
SELECT
    *
FROM
    cursos c
    LEFT JOIN professores p ON c.idt_prof = p.idt_prof
WHERE
    p.idt_prof IS NULL;

--Right join - com valores nulos do lado esquerdo  

SELECT
    *
FROM
    cursos c
    RIGHT JOIN professores p ON c.idt_prof = p.idt_prof
WHERE
    c.idt_prof IS NULL;

--Full join - sem os pares iguais das duas tabelas

SELECT
    *
FROM
    cursos c
    FULL OUTER JOIN professores p ON c.idt_prof = p.idt_prof
WHERE
    c.idt_prof IS NULL
    OR p.idt_prof IS NULL;
       
--Full join - sem os pares iguais das duas tabelas

SELECT
    *
FROM
    cursos c
    FULL OUTER JOIN professores p ON c.idt_prof = p.idt_prof;