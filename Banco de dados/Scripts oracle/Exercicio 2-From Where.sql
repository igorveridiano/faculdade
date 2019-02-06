-- Exercicios From Where
--A
SELECT
    job_title    "NOME CARGO",
    min_salary   "SALARIO MINIMO",
    max_salary   "SALARIO MAXIMO"
FROM
    jobs
WHERE
    min_salary > 10000;

--B  

SELECT
    first_name   nome,
    start_date   "DATA DE ADMISSÃO"
FROM
    job_history
    INNER JOIN employees USING ( employee_id )
WHERE
    EXTRACT(YEAR FROM start_date) BETWEEN 2002 AND 2005;
 
--C  

SELECT
    first_name   nome,
    start_date   "DATA ADMISSÃO"
FROM
    job_history h
    JOIN employees e ON h.employee_id = e.employee_id
    JOIN jobs j ON h.job_id = j.job_id
WHERE
    lower(job_title) LIKE ( '%programmer%' )
    OR lower(job_title) LIKE ( '%sales manager%' );
  
--D

SELECT
    first_name   nome,
    last_name    sobrenome
FROM
    job_history
    INNER JOIN employees USING ( employee_id )
WHERE
    start_date > '01/01/2008';

--E

SELECT
    *
FROM
    employees
WHERE
    employee_id = 150
    OR employee_id = 160;

--F

SELECT
    first_name       nome,
    last_name        sobrenome,
    salary           salario,
    commission_pct   "comissão",
    start_date       "DATA ADMISSÃO"
FROM
    job_history
    INNER JOIN employees USING ( employee_id )
WHERE
    salary < 10000;

--G

SELECT
    job_title   cargo,
    ( max_salary - min_salary ) "DIFERENÇA SALARIO"
FROM
    jobs
WHERE
    max_salary BETWEEN 10000 AND 20000;

--H

SELECT
    first_name   nome,
    last_name    sobrenome
FROM
    employees
WHERE
    lower(first_name) LIKE ( 's%' )
    OR lower(last_name) LIKE ( 's%' );

--I

SELECT
    first_name   nome,
    last_name    sobrenome
FROM
    job_history
    INNER JOIN employees USING ( employee_id )
WHERE
    EXTRACT(MONTH FROM start_date) = 5;
  
--J

SELECT
    *
FROM
    employees
WHERE
    commission_pct IS NULL
    AND department_id = 30
    AND salary BETWEEN 5000 AND 10000;
  
--K

SELECT
    first_name   nome,
    last_name    sobrenome,
    trunc(months_between(trunc(SYSDATE),start_date) / 12) "TEMPO DE EXPERIÊNCIA ANOS"
FROM
    job_history
    INNER JOIN employees USING ( employee_id );

--L

SELECT
    first_name
FROM
    job_history
    INNER JOIN employees USING ( employee_id )
WHERE
    EXTRACT(YEAR FROM start_date) = 2001;

--M

SELECT
    first_name,
    last_name,
    length(first_name) "TAMANHO DO PRIMEIRO NOME"
FROM
    employees
WHERE
    substr(lower(last_name),3) LIKE '%b%';

--N

SELECT
    upper(first_name) nome,
    lower(email) email
FROM
    employees
WHERE
    lower(first_name) LIKE lower('email%');

--O

SELECT
    *
FROM
    job_history
    INNER JOIN employees USING ( employee_id )
WHERE
    EXTRACT(YEAR FROM start_date) = 2018;

--ou 

--O

SELECT
    *
FROM
    job_history
    INNER JOIN employees USING ( employee_id )
WHERE
    EXTRACT(YEAR FROM start_date) = EXTRACT(YEAR FROM SYSDATE);

--P

SELECT
    employee_id   id,
    first_name    "PRIMEIRO NOME",
    last_name     "SOBRENOME"
FROM
    employees
WHERE
    salary BETWEEN 0 AND 2000
    OR salary >= 5000;