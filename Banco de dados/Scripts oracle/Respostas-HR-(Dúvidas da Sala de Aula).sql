-- Respostas HR (D�vidas da Sala de Aula)

-- Group by - Quest�o 'D'
SELECT
    country_id,
    country_name,
    COUNT(DISTINCT city) dist_city
FROM
    locations
    JOIN countries USING ( country_id )
GROUP BY
    country_id,
    country_name
ORDER BY
    dist_city DESC;

SELECT
    commission_pct,
    department_id
FROM
    hr.employees
WHERE
    commission_pct IS NOT NULL;

-- Having - Quest�o 'C'

SELECT
    department_id
FROM
    employees
WHERE
    commission_pct IS NOT NULL
GROUP BY
    department_id
HAVING
    MIN(commission_pct) > 0.05;

-- Having - Quest�o 'D'

SELECT
    job_id,
    COUNT(*)
FROM
    job_history
WHERE
    end_date - start_date > 100
GROUP BY
    job_id
HAVING
    COUNT(*) > 1; 

-- Having - Quest�o 'E'

SELECT
    e.manager_id,
    department_id,
    department_name,
    COUNT(*) qtd_funcionarios
FROM
    employees e
    JOIN departments USING ( department_id )
WHERE
    e.manager_id IS NOT NULL
GROUP BY
    e.manager_id,
    department_id,
    department_name
HAVING
    COUNT(*) > 5
ORDER BY
    2;

-- Join - Quest�o 'H'

SELECT
    job_title,
    first_name,
    max_salary,
    salary,
    max_salary - salary difference
FROM
    employees
    NATURAL JOIN jobs;

SELECT
    job_title,
    first_name,
    max_salary,
    salary,
    max_salary - salary difference
FROM
    employees
    INNER JOIN jobs USING ( job_id );

-- Join - Quest�o 'L'

SELECT
    TRIM(lower(city) ) city,
    TO_CHAR(hire_date,'MON-YYYY'),
    COUNT(*)
FROM
    employees
    JOIN departments USING ( department_id )
    JOIN locations USING ( location_id )
WHERE
    TRIM(lower(city) ) = 'sydney'
GROUP BY
    TRIM(lower(city) ),
    TO_CHAR(hire_date,'MON-YYYY')
HAVING
    COUNT(*) > 5;

SELECT
    TRIM(lower(city) ) city,
    EXTRACT(MONTH FROM hire_date)
    || '/'
    || EXTRACT(YEAR FROM hire_date) hire_month,
    COUNT(*)
FROM
    employees
    JOIN departments USING ( department_id )
    JOIN locations USING ( location_id )
WHERE
    TRIM(lower(city) ) = 'sydney'
GROUP BY
    TRIM(lower(city) ),
    EXTRACT(YEAR FROM hire_date),
    EXTRACT(MONTH FROM hire_date)
HAVING
    COUNT(*) > 5;

-- Subselect - Quest�o 'B'

SELECT
    *
FROM
    departments
WHERE
    manager_id IN (
        SELECT
            employee_id
        FROM
            employees
        WHERE
            upper(last_name) = upper('Russell')
    );

SELECT
    *
FROM
    departments d
WHERE
    EXISTS (
        SELECT
            1
        FROM
            employees e
        WHERE
            upper(last_name) = upper('Russell')
            AND d.manager_id = e.employee_id
    );

SELECT
    *
FROM
    departments d
WHERE
    (
        SELECT
            COUNT(*)
        FROM
            employees e
        WHERE
            upper(last_name) = upper('Russell')
            AND d.manager_id = e.employee_id
    ) > 0;

WITH managers AS (
    SELECT
        employee_id   manager_id
    FROM
        employees
    WHERE
        upper(last_name) = upper('Russell')
)
SELECT
    *
FROM
    departments
    JOIN managers USING ( manager_id );

-- Subselect - Quest�o 'D'

SELECT
    *
FROM
    employees
WHERE
    employee_id NOT IN (
        SELECT
            employee_id
        FROM
            job_history
    );

SELECT
    *
FROM
    employees e
WHERE
    NOT EXISTS (
        SELECT
            1
        FROM
            job_history h
        WHERE
            h.employee_id = e.employee_id
    );

SELECT
    *
FROM
    employees e
WHERE
    (
        SELECT
            COUNT(*)
        FROM
            job_history h
        WHERE
            h.employee_id = e.employee_id
    ) = 0;

ALTER SESSION SET current_schema = hr;

-- Subselect - Quest�o 'E'

SELECT
    country_name,
    city,
    COUNT(department_id)
FROM
    countries
    JOIN locations USING ( country_id )
    JOIN departments USING ( location_id )
WHERE
    department_id IN (
        SELECT
            department_id
        FROM
            employees
        GROUP BY
            department_id
        HAVING
            COUNT(department_id) > 5
    )
GROUP BY
    country_name,
    city; 

-- Subselect - Quest�o 'G'

SELECT
    *
FROM
    departments
WHERE
    department_id NOT IN (
        SELECT
            department_id
        FROM
            employees
        WHERE
            trunc(months_between(SYSDATE,hire_date) / 12) < 2
    );

SELECT
    *
FROM
    departments d
WHERE
    NOT EXISTS (
        SELECT
            1
        FROM
            employees e
        WHERE
            e.department_id = d.department_id
            AND trunc(months_between(SYSDATE,hire_date) / 12) < 2
    );

SELECT
    *
FROM
    job_history;

-- Subselect - Quest�o 'H'

SELECT
    *
FROM
    departments
WHERE
    department_id IN (
        SELECT
            e.department_id
        FROM
            employees e
            JOIN job_history USING ( employee_id )
        GROUP BY
            e.department_id
        HAVING
            MAX(salary) > 10000
    );

-- Subselect - Quest�o 'I'

SELECT
    department_id,
    first_name,
    salary
FROM
    employees e
WHERE
    salary = (
        SELECT
            MAX(salary)
        FROM
            employees
        WHERE
            department_id = e.department_id
    );

WITH maximo AS (
    SELECT
        department_id,
        MAX(salary) maior_salario
    FROM
        employees
    GROUP BY
        department_id
)
SELECT
    e.department_id,
    first_name,
    salary
FROM
    employees e
    JOIN maximo m ON e.department_id = m.department_id
                     AND e.salary = m.maior_salario;

WITH maximo AS (
    SELECT
        department_id,
        MAX(salary) salary
    FROM
        employees
    GROUP BY
        department_id
)
SELECT
    department_id,
    first_name,
    salary
FROM
    employees
    JOIN maximo USING ( department_id,
                        salary );

-- Subselect - Quest�o 'J'

SELECT
    city
FROM
    locations
WHERE
    location_id = (
        SELECT
            location_id
        FROM
            departments
        WHERE
            department_id = (
                SELECT
                    department_id
                FROM
                    employees
                WHERE
                    employee_id = 105
            )
    )