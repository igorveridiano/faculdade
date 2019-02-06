-- ############ Funções de Caractere ############

select lpad('a',5,'.') from dual

select lpad('124',10,'0') from dual

select rpad('a',5,'.') from dual

select rtrim('a------','-') from dual

select chr(39)||rtrim( 'a   ' )||chr(39) from dual

select ascii('a'), ascii('A') from dual

select ltrim('------a','-') from dual

select chr(39)||ltrim( '     a' )||chr(39) from dual

select chr(39)||trim( '     a  ' )||chr(39) from dual

select length('teste') from dual

select instr('teste', 'e') from dual

select instr('teste', 'e',1,2) from dual

select substr('01/09/1990',4,2) from dual

select substr('01/09/1990',7) from dual

select replace( 'thiago sobrenome sobrenome', 
                'sobrenome', 'lima' ) from dual

select nom_curso, substr(nom_curso, 1, 3 )
  from cursos

select initcap( 'thiago lima' ) from dual

select ascii( 'A' ) from dual
select ascii( 'a' ) from dual

select chr( 65 ) from dual
select chr( 97 ) from dual

select lower( 'ThIaGo' ) from dual

select upper( 'thIagO' ) from dual


-- ############ Funções numéricas ############

select round(35.59,1) from dual

select round(35.59) from dual

select trunc(35.59,1) from dual

select trunc(35.59) from dual

select mod(4,2) from dual

select mod(3,2) from dual

select ABS( -253 ) from dual

select Ceil( 25.69 ) from dual

select Floor( 25.69 ) from dual

select POWER( 2, 3 ) from dual

select SQRT( 4 ) from dual

select SIN( 90 ) from dual

select COS( 90 ) from dual

select TAN( 90 ) from dual


-- ############ Funções de data ############

alter session set nls_date_format = 'dd/mm/yyyy hh24:mi:ss';

select SYSDATE + 1 from dual

select SYSDATE, SYSDATE + 10/1440 from dual

select SYSDATE, SYSDATE + 1/1440 from dual

select SYSDATE, SYSDATE + 1/86400 from dual

select sysdate, ADD_MONTHS(SYSDATE,1) from dual

select trunc(MONTHS_BETWEEN( '17/11/2006', '04/10/1979' )/12) from dual

select next_day(sysdate,'sábado') from dual

select last_day(sysdate) from dual

select TRUNC( MONTHS_BETWEEN( TRUNC( SYSDATE ), '04/10/1979' )/12 )||' anos' from dual

select to_char(sysdate,'D') from dual

select to_char(sysdate,'DAY') from dual

select to_char(sysdate,'DY') from dual

select to_char(sysdate,'MONTH') from dual

select to_char(sysdate,'MON') from dual

select to_char(sysdate,'DD "de" MONTH "de" YYYY') from dual



-- ############ Outras funções ############

select NVL(NULL,3) from dual

select NVL(3,1) from dual

select nvl2( null, 'Não é nulo', 'NULL'  ) from dual;

select nvl2( 3, 'Não é nulo', 'NULL'  ) from dual;

select * from academico.disciplinas

select distinct 
       tpo_disc,
       decode( tpo_disc, 'T', 'TCC', 
                         'N', 'Normal',
                         'E', 'Estágio',
                         'S', 'Especial',
                         'Não definida'  )
  from academico.disciplinas

select user from dual

show user

select GREATEST( 5, 7, 4, 10, 3, 8, 9, 1, 6, 2 ) from dual

select LEAST( 5, 7, 4, 10, 3, 8, 9, 1, 6, 2 ) from dual



-- ############ Funções de conversão ############

alter session set NLS_NUMERIC_CHARACTERS=',.';

alter session set NLS_CURRENCY='R$ ';

select to_char(113356.34,'999G999D00') from dual

select to_char(113356.34,'L999G999D00') from dual

select EXTRACT( DAY from to_date('20090901','YYYYMMDD')+10 )
   from dual




select sysdate, extract( MONTH from sysdate ) mes,
       extract( DAY from sysdate ) dia, 
       extract( YEAR from sysdate ) ano from dual

select mat_alu, nom_alu, dat_nasc,
       extract(YEAR from dat_nasc ) ano
  from alunos
  where cod_curso = 26 and
        extract(YEAR from dat_nasc ) between 1970 and 1990 and
        rownum <= 10




