-- Exercicios Join
--A
SELECT
    department_name   departamento,
    COUNT(DISTINCT employee_id) "TOTAL FUNCIONARIOS"
FROM
    employees
    INNER JOIN departments USING ( department_id )
GROUP BY
    department_id,
    department_name
ORDER BY
    department_name;
  
--B

SELECT
    j.job_title     trabalho,
    h.employee_id   "ID FUNCIONARIO",
    trunc( (months_between(h.end_date,h.start_date) / 12) * 365) "DIAS  DE TRABALHO"
FROM
    job_history h
    JOIN employees e ON h.employee_id = e.employee_id
    JOIN jobs j ON h.job_id = j.job_id
WHERE
    h.department_id = 30;     

--C

SELECT
    d.department_name   departamento,
    e.first_name        gerente
FROM
    employees e
    INNER JOIN departments d ON e.department_id = d.department_id
WHERE
    e.employee_id = d.manager_id;
  
--D

SELECT
    d.department_name   departamento,
    e.first_name        gerente,
    l.city              cidade
FROM
    employees e
    INNER JOIN departments d ON e.department_id = d.department_id
    INNER JOIN locations l ON d.location_id = l.location_id
WHERE
    e.employee_id = d.manager_id;
  
--E

SELECT
    d.department_name   departamento,
    c.country_name      país,
    l.city              cidade
FROM
    departments d
    INNER JOIN locations l ON d.location_id = l.location_id
    INNER JOIN countries c ON l.country_id = c.country_id;

--F

SELECT
    j.job_title         cargo,
    d.department_name   departamento,
    e.last_name         "SOBRENOME FUNCIONARIO",
    h.start_date        "DATA INICIO"
FROM
    job_history h
    INNER JOIN employees e ON h.employee_id = e.employee_id
    INNER JOIN departments d ON h.department_id = d.department_id
    INNER JOIN jobs j ON h.job_id = j.job_id
WHERE
    EXTRACT(YEAR FROM h.start_date) BETWEEN 2000 AND 2005;     

--G

SELECT
    job_title   cargo,
    ( SUM(salary) / COUNT(DISTINCT employee_id) ) "SALARIO MÉDIO"
FROM
    employees
    INNER JOIN jobs USING ( job_id )
GROUP BY
    job_id,
    job_title
ORDER BY
    job_title;
  
--H

SELECT
    job_title    cargo,
    first_name   nome,
    last_name    sobrenome,
    ( max_salary - salary ) "SALARIO DIF"
FROM
    employees
    INNER JOIN jobs USING ( job_id );
  
--I

SELECT
    last_name   sobrenome,
    job_title   cargo
FROM
    employees
    INNER JOIN jobs USING ( job_id )
WHERE
    department_id = 30
    AND commission_pct IS NOT NULL;
  
--J

SELECT
    department_name   departamento,
    e.first_name      "NOME GERENTE",
    e.last_name       sobrenome,
    e.salary          salario
FROM
    job_history h
    INNER JOIN employees e ON h.employee_id = e.employee_id
    INNER JOIN departments d ON h.department_id = d.department_id
WHERE
    trunc(months_between(SYSDATE,h.start_date) / 12) > 5; 
  
--OU

SELECT
    department_name   departamento,
    e.first_name      "NOME GERENTE",
    e.last_name       sobrenome,
    e.salary          salario
FROM
    job_history h
    INNER JOIN employees e ON h.employee_id = e.employee_id
    INNER JOIN departments d ON h.department_id = d.department_id
WHERE
    trunc(months_between(h.end_date,h.start_date) / 12) > 5;  
  
--K

SELECT
    m.first_name   nome
FROM
    employees m
    INNER JOIN employees e ON m.manager_id = e.employee_id
WHERE
    m.hire_date < e.hire_date; 

--L

SELECT
    TRIM(lower(city) ) city,
    TO_CHAR(hire_date,'MON-YYYY') "DATA",
    COUNT(*)
FROM
    employees
    INNER JOIN departments USING ( department_id )
    INNER JOIN locations USING ( location_id )
GROUP BY
    TRIM(lower(city) ),
    TO_CHAR(hire_date,'MON-YYYY')
HAVING
    COUNT(employee_id) > 0;
  
--M

SELECT
    d.department_name   departamento,
    e.first_name        gerente
FROM
    employees e,
    departments d,
    locations l
WHERE
    e.employee_id = d.manager_id
    AND d.location_id = l.location_id
    AND lower(l.city) LIKE 'são paulo%';
  
--OU

SELECT
    d.department_name   departamento,
    e.first_name        gerente
FROM
    employees e
    INNER JOIN departments d ON e.employee_id = d.manager_id
    INNER JOIN locations l ON d.location_id = l.location_id
WHERE
    lower(l.city) LIKE 'são paulo%';
  
--N

SELECT
    concat(concat(e.first_name,' '),e.last_name) funcionario,
    e.hire_date    "DATA CONTRATAÇÃO",
    h.start_date   "DATA INICIO",
    h.end_date     "DATA FIM",
    j.job_title    "TRABALHO"
FROM
    job_history h
    INNER JOIN employees e ON h.employee_id = e.employee_id
    INNER JOIN jobs j ON h.job_id = j.job_id;

--O

SELECT
    region_name   região
FROM
    countries
    INNER JOIN regions USING ( region_id )
WHERE
    lower(country_name) LIKE 'a%'
    OR lower(country_name) LIKE 'b%'
    OR lower(country_name) LIKE 'j%';
  
--P

SELECT
    e.employee_id       "ID GERENTE",
    e.first_name        gerente,
    d.department_id     "ID DEPARTAMENTO",
    d.department_name   departamento
FROM
    employees e
    INNER JOIN departments d ON e.employee_id = d.manager_id;
  
--Q

SELECT
    d.department_id     "ID DEPARTAMENTO",
    d.department_name   departamento
FROM
    employees e
    RIGHT JOIN departments d ON e.department_id = d.department_id
WHERE
    e.department_id IS NULL;
  
--R

SELECT
    employee_id       "ID GERENTE",
    first_name        gerente,
    department_name   departamento,
    country_name      país,
    region_name       região
FROM
    employees
    INNER JOIN departments USING ( department_id )
    INNER JOIN locations USING ( location_id )
    INNER JOIN countries USING ( country_id )
    INNER JOIN regions USING ( region_id )
WHERE
    lower(region_name) LIKE 'europe%'
    OR lower(region_name) LIKE 'asia%';