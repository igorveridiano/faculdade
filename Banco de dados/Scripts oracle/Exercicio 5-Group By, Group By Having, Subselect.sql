-- Exercicios Group By
-- A
SELECT
    TO_CHAR(hire_date,'MONTH') mês,
    COUNT(employee_id) contratados
FROM
    employees
GROUP BY
    TO_CHAR(hire_date,'MONTH')
ORDER BY
    contratados;

-- B

SELECT
    manager_id   "ID GERENTE",
    COUNT(employee_id) "QUANT. GERENCIADOS"
FROM
    employees
WHERE
    manager_id IS NOT NULL
GROUP BY
    manager_id;
    
-- C

SELECT
    employee_id   "ID FUNCIONARIO",
    MAX(end_date) " DATA FINAL DO ULTIMO TRABALHO"
FROM
    job_history
GROUP BY
    employee_id;
    
-- D

SELECT
    country_id     "ID PAÍS",
    country_name   país,
    COUNT(location_id) "QUANTIDADE DE CIDADES"
FROM
    locations
    INNER JOIN countries USING ( country_id )
GROUP BY
    country_id,
    country_name
ORDER BY
    country_id;
    
-- E

SELECT
    department_id   "ID DEPARTAMENTO",
    trunc(AVG(salary),2) "SALARIO MÉDIO"
FROM
    employees
WHERE
    commission_pct > 0
    AND department_id IS NOT NULL
GROUP BY
    department_id;
    
-- F

SELECT
    job_id   "ID TRABALHO",
    COUNT(employee_id) "QUANT. FUNCIONARIOS",
    SUM(salary) "SOMA DOS SALARIOS",
    ( MAX(salary) - MIN(salary) ) "DIFERENÇA MAX/MIN SALARIO"
FROM
    employees
GROUP BY
    job_id
ORDER BY
    job_id;
    
-- Exercicios Group By Having
-- A

SELECT
    job_id   "ID TRABALHO",
    trunc(AVG(salary),2) "SALARIO MÉDIO"
FROM
    employees
GROUP BY
    job_id
HAVING
    trunc(AVG(salary),2) > 10000;
 
-- B

SELECT
    EXTRACT(YEAR FROM hire_date) ano
FROM
    employees
GROUP BY
    EXTRACT(YEAR FROM hire_date)
HAVING
    COUNT(employee_id) > 10;
    
-- C

SELECT
    department_id   "ID DEPARTAMENTO"
FROM
    employees
WHERE
    commission_pct IS NOT NULL
GROUP BY
    department_id
HAVING
    MIN(commission_pct) > 0.05;
  
-- D

SELECT
    job_id   "ID TRABALHO",
    COUNT(DISTINCT(employee_id) )
FROM
    job_history
WHERE
    end_date - start_date > 100
GROUP BY
    job_id
HAVING
    COUNT(DISTINCT(employee_id) ) > 1;
   
-- E

SELECT DISTINCT
    e.department_id     "ID DEPARTAMENTO",
    d.department_name   departamento,
    COUNT(e.employee_id) funcionarios
FROM
    employees e
    INNER JOIN departments d ON e.department_id = d.department_id
WHERE
    e.manager_id IS NOT NULL
GROUP BY
    e.department_id,
    d.department_name,
    e.manager_id
HAVING
    COUNT(employee_id) > 5;
    
-- Exercicios Subselect
-- A

SELECT
    *
FROM
    departments d
WHERE
    (
        SELECT
            MAX(salary)
        FROM
            employees e
        WHERE
            d.department_id = e.department_id
    ) > 10000;

-- B

SELECT
    *
FROM
    departments d
WHERE
    EXISTS (
        SELECT
            employee_id
        FROM
            employees e
        WHERE
            d.department_id = e.department_id
            AND ( lower(first_name) LIKE ( '%russel%' )
                  OR lower(last_name) LIKE ( '%russel%' ) )
            AND e.employee_id = d.manager_id
    );
    
-- C

SELECT
    job_title   "TRABALHO"
FROM
    jobs j
WHERE
    (
        SELECT
            COUNT(employee_id)
        FROM
            employees e
        WHERE
            j.job_id = e.job_id
            AND ( ( EXTRACT(YEAR FROM SYSDATE) ) = ( EXTRACT(YEAR FROM hire_date) ) )
    ) > 0;
    
-- D

SELECT
    employee_id   "ID",
    first_name    nome
FROM
    employees e
WHERE
    NOT EXISTS (
        SELECT
            *
        FROM
            job_history j
        WHERE
            e.employee_id = j.employee_id
    );

-- E

SELECT
    l.country_name   país,
    l.city           cidade,
    COUNT(d.department_id) "QUANT. DEPARTAMENTOS"
FROM
    departments d
    INNER JOIN (
        SELECT
            location_id,
            country_name,
            city
        FROM
            countries
            INNER JOIN locations USING ( country_id )
    ) l ON d.location_id = l.location_id
WHERE
    (
        SELECT
            COUNT(employee_id)
        FROM
            employees e
        WHERE
            d.department_id = e.department_id
    ) > 5
GROUP BY
    l.country_name,
    l.city;
    
-- F

SELECT
    *
FROM
    employees e
WHERE
    (
        SELECT
            COUNT(employee_id)
        FROM
            employees x
        WHERE
            e.employee_id = x.manager_id
    ) > 5;

-- G

SELECT
    department_name
FROM
    departments d
WHERE
    NOT EXISTS (
        SELECT
            *
        FROM
            employees e
        WHERE
            d.department_id = e.department_id
            AND ( trunc(months_between(SYSDATE,hire_date) ) / 12 ) < 2
    );
    
-- H

SELECT
    *
FROM
    departments d
WHERE
    (
        SELECT
            MAX(salary)
        FROM
            employees e
        WHERE
            d.department_id = e.department_id
            AND EXISTS (
                SELECT
                    *
                FROM
                    job_history j
                WHERE
                    e.employee_id = j.employee_id
            )
    ) > 10000;
    
-- I

SELECT
    *
FROM
    employees e
WHERE
    e.salary = (
        SELECT
            MAX(salary)
        FROM
            employees x
        WHERE
            e.department_id = x.department_id
    );
    
-- J

SELECT
    city
FROM
    locations l
WHERE
    l.location_id = (
        SELECT
            location_id
        FROM
            departments d
        WHERE
            d.department_id = (
                SELECT
                    department_id
                FROM
                    employees e
                WHERE
                    e.employee_id = 105
            )
    );