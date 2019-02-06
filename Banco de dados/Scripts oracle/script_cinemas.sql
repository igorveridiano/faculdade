prompt Init cinemas dataset loading...
set feedback off
set define off
prompt Dropping tables dataset...

drop table CINEMAS cascade constraints purge;
drop table DIRECOES cascade constraints purge;
drop table DIRETORES cascade constraints purge;
drop table FILMES cascade constraints purge;
drop table PRECOS cascade constraints purge;
drop table PRODUTORAS cascade constraints purge;
drop table SALAS cascade constraints purge;
drop table SESSOES cascade constraints purge;

create table CINEMAS
(
  cod_cinema   NUMBER(3) not null,
  nom_cinema   VARCHAR2(40) not null,
  hor_ini_func NUMBER(2) not null,
  min_ini_func NUMBER(2) not null,
  hor_fim_func NUMBER(2) not null,
  min_fim_func NUMBER(2) not null,
  endereco     VARCHAR2(100)
)
tablespace dados_acad
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index CIA_NOME_IDX on CINEMAS (NOM_CINEMA)
  tablespace dados_acad
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table CINEMAS
  add constraint CIA_PK primary key (COD_CINEMA)
  using index 
  tablespace dados_acad
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table CINEMAS
  add constraint AVCON_1086357368_COD_C_002
  check (COD_CINEMA BETWEEN 1 AND 9999);
alter table CINEMAS
  add constraint AVCON_1086357368_HOR_F_000
  check (HOR_FIM_FUNC BETWEEN 0 AND 23);
alter table CINEMAS
  add constraint AVCON_1086357368_HOR_I_001
  check (HOR_INI_FUNC BETWEEN 0 AND 23);
alter table CINEMAS
  add constraint AVCON_1086357368_MIN_F_000
  check (MIN_FIM_FUNC BETWEEN 0 AND 59);
alter table CINEMAS
  add constraint AVCON_1086357368_MIN_I_000
  check (MIN_INI_FUNC BETWEEN 0 AND 59);

prompt Creating DIRETORES...
create table DIRETORES
(
  cod_diretor NUMBER(4) not null,
  nom_diretor VARCHAR2(40) not null,
  tot_filmes  NUMBER(4) not null,
  media       NUMBER(3,1) not null
)
tablespace dados_acad
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index DIR_NOME_IDX on DIRETORES (NOM_DIRETOR)
  tablespace dados_acad
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table DIRETORES
  add constraint DIR_PK primary key (COD_DIRETOR)
  using index 
  tablespace dados_acad
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table DIRETORES
  add constraint AVCON_1086357368_COD_D_001
  check (COD_DIRETOR BETWEEN 1 AND 9999);
alter table DIRETORES
  add constraint AVCON_1086357368_MEDIA_000
  check (MEDIA BETWEEN 0 AND 10);
alter table DIRETORES
  add constraint AVCON_1086357368_TOT_F_001
  check (TOT_FILMES BETWEEN 1 AND 9999);

prompt Creating PRODUTORAS...
create table PRODUTORAS
(
  cod_prod   NUMBER(4) not null,
  nom_prod   VARCHAR2(40) not null,
  tot_filmes NUMBER(3) not null
)
tablespace dados_acad
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index PRA_NOME_IDX on PRODUTORAS (NOM_PROD)
  tablespace dados_acad
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table PRODUTORAS
  add constraint PRA_PK primary key (COD_PROD)
  using index 
  tablespace dados_acad
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table PRODUTORAS
  add constraint AVCON_1086357368_COD_P_000
  check (COD_PROD BETWEEN 1 AND 9999);
alter table PRODUTORAS
  add constraint AVCON_1086357368_TOT_F_000
  check (TOT_FILMES BETWEEN 1 AND 999);

prompt Creating FILMES...
create table FILMES
(
  cod_filme NUMBER(4) not null,
  tit_filme VARCHAR2(40) not null,
  ano_filme NUMBER(4) not null,
  cod_prod  NUMBER(4) not null,
  dur_min   NUMBER(3) not null,
  censura   NUMBER(3) not null
)
tablespace dados_acad
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index FIE_PRA_FK_IDX on FILMES (COD_PROD)
  tablespace dados_acad
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index FIE_TITULO_IDX on FILMES (TIT_FILME)
  tablespace dados_acad
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table FILMES
  add constraint FIE_PK primary key (COD_FILME)
  using index 
  tablespace dados_acad
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table FILMES
  add constraint FIE_PRA_FK foreign key (COD_PROD)
  references PRODUTORAS (COD_PROD);
alter table FILMES
  add constraint AVCON_1086357368_ANO_F_000
  check (ANO_FILME BETWEEN 1 AND 9999);
alter table FILMES
  add constraint AVCON_1086357368_COD_F_001
  check (COD_FILME BETWEEN 1 AND 9999);
alter table FILMES
  add constraint AVCON_1086357368_COD_P_001
  check (COD_PROD BETWEEN 1 AND 9999);
alter table FILMES
  add constraint AVCON_1086357368_DUR_M_000
  check (DUR_MIN BETWEEN 0 AND 999);

prompt Creating DIRECOES...
create table DIRECOES
(
  cod_diretor NUMBER(4) not null,
  cod_filme   NUMBER(4) not null,
  avaliacao   NUMBER(3,1) not null
)
tablespace dados_acad
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index DIE_DIR_FK_IDX on DIRECOES (COD_DIRETOR)
  tablespace dados_acad
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index DIE_FIE_FK_IDX on DIRECOES (COD_FILME)
  tablespace dados_acad
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table DIRECOES
  add constraint DIE_PK primary key (COD_DIRETOR, COD_FILME)
  using index 
  tablespace dados_acad
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table DIRECOES
  add constraint DIE_DIR_FK foreign key (COD_DIRETOR)
  references DIRETORES (COD_DIRETOR);
alter table DIRECOES
  add constraint DIE_FIE_FK foreign key (COD_FILME)
  references FILMES (COD_FILME);
alter table DIRECOES
  add constraint AVCON_1086357368_AVALI_000
  check (AVALIACAO BETWEEN 1 AND 10);
alter table DIRECOES
  add constraint AVCON_1086357368_COD_D_000
  check (COD_DIRETOR BETWEEN 1 AND 9999);
alter table DIRECOES
  add constraint AVCON_1086357368_COD_F_000
  check (COD_FILME BETWEEN 1 AND 9999);

prompt Creating PRECOS...
create table PRECOS
(
  cod_cinema   NUMBER(3) not null,
  hor_ini      NUMBER(2) not null,
  val_ingresso NUMBER(4,2) not null
)
tablespace dados_acad
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index PRO_CIA_FK_IDX on PRECOS (COD_CINEMA)
  tablespace dados_acad
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table PRECOS
  add constraint PRO_PK primary key (COD_CINEMA, HOR_INI)
  using index 
  tablespace dados_acad
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table PRECOS
  add constraint PRO_CIA_FK foreign key (COD_CINEMA)
  references CINEMAS (COD_CINEMA);
alter table PRECOS
  add constraint AVCON_1086357368_COD_C_000
  check (COD_CINEMA BETWEEN 1 AND 9999);
alter table PRECOS
  add constraint AVCON_1086357368_HOR_I_000
  check (HOR_INI BETWEEN 1 AND 23);
alter table PRECOS
  add constraint AVCON_1086357368_VAL_I_000
  check (VAL_INGRESSO BETWEEN 1 AND 99);

prompt Creating SALAS...
create table SALAS
(
  cod_cinema NUMBER(3) not null,
  num_sala   NUMBER(2) not null,
  capacidade NUMBER(3) not null
)
tablespace dados_acad
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index SAA_CIA_FK_IDX on SALAS (COD_CINEMA)
  tablespace dados_acad
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table SALAS
  add constraint SAA_PK primary key (COD_CINEMA, NUM_SALA)
  using index 
  tablespace dados_acad
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table SALAS
  add constraint SAA_CIA_FK foreign key (COD_CINEMA)
  references CINEMAS (COD_CINEMA);
alter table SALAS
  add constraint AVCON_1086357368_CAPAC_000
  check (CAPACIDADE BETWEEN 1 AND 999);
alter table SALAS
  add constraint AVCON_1086357368_COD_C_001
  check (COD_CINEMA BETWEEN 1 AND 9999);
alter table SALAS
  add constraint AVCON_1086357368_NUM_S_000
  check (NUM_SALA BETWEEN 1 AND 99);

prompt Creating SESSOES...
create table SESSOES
(
  cod_cinema NUMBER(3) not null,
  num_sala   NUMBER(2) not null,
  hor_ini    NUMBER(2) not null,
  min_ini    NUMBER(2) not null,
  cod_filme  NUMBER(4) not null
)
tablespace dados_acad
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index SEE_FIE_FK_IDX on SESSOES (COD_FILME)
  tablespace dados_acad
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index SEE_SAA_FK_IDX on SESSOES (COD_CINEMA, NUM_SALA)
  tablespace dados_acad
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table SESSOES
  add constraint SEE_PK primary key (COD_CINEMA, NUM_SALA, HOR_INI)
  using index 
  tablespace dados_acad
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table SESSOES
  add constraint SEE_FIE_FK foreign key (COD_FILME)
  references FILMES (COD_FILME);
alter table SESSOES
  add constraint SEE_SAA_FK foreign key (COD_CINEMA, NUM_SALA)
  references SALAS (COD_CINEMA, NUM_SALA);
alter table SESSOES
  add constraint AVCON_1086357368_COD_C_003
  check (COD_CINEMA BETWEEN 1 AND 9999);
alter table SESSOES
  add constraint AVCON_1086357368_COD_F_002
  check (COD_FILME BETWEEN 1 AND 999);
alter table SESSOES
  add constraint AVCON_1086357368_HOR_I_002
  check (HOR_INI BETWEEN 0 AND 23);
alter table SESSOES
  add constraint AVCON_1086357368_MIN_I_001
  check (MIN_INI BETWEEN 0 AND 59);
alter table SESSOES
  add constraint AVCON_1086357368_NUM_S_001
  check (NUM_SALA BETWEEN 1 AND 99);

prompt Disabling triggers for CINEMAS...
alter table CINEMAS disable all triggers;
prompt Disabling triggers for DIRETORES...
alter table DIRETORES disable all triggers;
prompt Disabling triggers for PRODUTORAS...
alter table PRODUTORAS disable all triggers;
prompt Disabling triggers for FILMES...
alter table FILMES disable all triggers;
prompt Disabling triggers for DIRECOES...
alter table DIRECOES disable all triggers;
prompt Disabling triggers for PRECOS...
alter table PRECOS disable all triggers;
prompt Disabling triggers for SALAS...
alter table SALAS disable all triggers;
prompt Disabling triggers for SESSOES...
alter table SESSOES disable all triggers;
prompt Disabling foreign key constraints for FILMES...
alter table FILMES disable constraint FIE_PRA_FK;
prompt Disabling foreign key constraints for DIRECOES...
alter table DIRECOES disable constraint DIE_DIR_FK;
alter table DIRECOES disable constraint DIE_FIE_FK;
prompt Disabling foreign key constraints for PRECOS...
alter table PRECOS disable constraint PRO_CIA_FK;
prompt Disabling foreign key constraints for SALAS...
alter table SALAS disable constraint SAA_CIA_FK;
prompt Disabling foreign key constraints for SESSOES...
alter table SESSOES disable constraint SEE_FIE_FK;
alter table SESSOES disable constraint SEE_SAA_FK;
prompt Loading CINEMAS...
insert into CINEMAS (cod_cinema, nom_cinema, hor_ini_func, min_ini_func, hor_fim_func, min_fim_func, endereco)
values (1, 'Cine Rio-Mar', 7, 50, 23, 20, 'Av. Delmiro Golveia');
insert into CINEMAS (cod_cinema, nom_cinema, hor_ini_func, min_ini_func, hor_fim_func, min_fim_func, endereco)
values (2, 'Cinemark Jardins', 8, 0, 22, 50, 'Av. Pedro Valadares');
commit;
prompt 2 records loaded
prompt Loading DIRETORES...
insert into DIRETORES (cod_diretor, nom_diretor, tot_filmes, media)
values (1, 'Streven Spilberg', 2, 9);
insert into DIRETORES (cod_diretor, nom_diretor, tot_filmes, media)
values (2, 'George Lucas', 3, 9.2);
commit;
prompt 2 records loaded
prompt Loading PRODUTORAS...
insert into PRODUTORAS (cod_prod, nom_prod, tot_filmes)
values (1, 'Fox', 2);
insert into PRODUTORAS (cod_prod, nom_prod, tot_filmes)
values (2, 'Warner', 2);
commit;
prompt 2 records loaded
prompt Loading FILMES...
insert into FILMES (cod_filme, tit_filme, ano_filme, cod_prod, dur_min, censura)
values (1, 'Star War I', 1987, 1, 130, 15);
insert into FILMES (cod_filme, tit_filme, ano_filme, cod_prod, dur_min, censura)
values (2, 'Star War II', 1990, 1, 140, 16);
insert into FILMES (cod_filme, tit_filme, ano_filme, cod_prod, dur_min, censura)
values (3, 'Star War III', 1993, 2, 125, 17);
insert into FILMES (cod_filme, tit_filme, ano_filme, cod_prod, dur_min, censura)
values (4, 'IA', 2002, 2, 110, 18);
commit;
prompt 4 records loaded
prompt Loading DIRECOES...
insert into DIRECOES (cod_diretor, cod_filme, avaliacao)
values (2, 1, 9.4);
insert into DIRECOES (cod_diretor, cod_filme, avaliacao)
values (2, 2, 9);
insert into DIRECOES (cod_diretor, cod_filme, avaliacao)
values (2, 3, 9.2);
insert into DIRECOES (cod_diretor, cod_filme, avaliacao)
values (1, 3, 9.5);
insert into DIRECOES (cod_diretor, cod_filme, avaliacao)
values (1, 4, 8.5);
commit;
prompt 5 records loaded
prompt Loading PRECOS...
insert into PRECOS (cod_cinema, hor_ini, val_ingresso)
values (1, 7, 4.5);
insert into PRECOS (cod_cinema, hor_ini, val_ingresso)
values (1, 12, 6);
insert into PRECOS (cod_cinema, hor_ini, val_ingresso)
values (1, 18, 9);
insert into PRECOS (cod_cinema, hor_ini, val_ingresso)
values (2, 8, 5.7);
insert into PRECOS (cod_cinema, hor_ini, val_ingresso)
values (2, 13, 7);
insert into PRECOS (cod_cinema, hor_ini, val_ingresso)
values (2, 18, 10);
commit;
prompt 6 records loaded
prompt Loading SALAS...
insert into SALAS (cod_cinema, num_sala, capacidade)
values (1, 1, 50);
insert into SALAS (cod_cinema, num_sala, capacidade)
values (1, 2, 80);
insert into SALAS (cod_cinema, num_sala, capacidade)
values (1, 3, 100);
insert into SALAS (cod_cinema, num_sala, capacidade)
values (2, 1, 40);
insert into SALAS (cod_cinema, num_sala, capacidade)
values (2, 2, 80);
insert into SALAS (cod_cinema, num_sala, capacidade)
values (2, 3, 80);
insert into SALAS (cod_cinema, num_sala, capacidade)
values (2, 4, 90);
insert into SALAS (cod_cinema, num_sala, capacidade)
values (2, 5, 130);
insert into SALAS (cod_cinema, num_sala, capacidade)
values (2, 6, 200);
commit;
prompt 9 records loaded
prompt Loading SESSOES...
insert into SESSOES (cod_cinema, num_sala, hor_ini, min_ini, cod_filme)
values (1, 1, 10, 20, 1);
insert into SESSOES (cod_cinema, num_sala, hor_ini, min_ini, cod_filme)
values (1, 1, 15, 0, 1);
insert into SESSOES (cod_cinema, num_sala, hor_ini, min_ini, cod_filme)
values (1, 1, 19, 0, 1);
insert into SESSOES (cod_cinema, num_sala, hor_ini, min_ini, cod_filme)
values (1, 2, 10, 0, 1);
insert into SESSOES (cod_cinema, num_sala, hor_ini, min_ini, cod_filme)
values (1, 2, 15, 10, 1);
insert into SESSOES (cod_cinema, num_sala, hor_ini, min_ini, cod_filme)
values (1, 2, 19, 30, 2);
insert into SESSOES (cod_cinema, num_sala, hor_ini, min_ini, cod_filme)
values (2, 1, 9, 0, 3);
insert into SESSOES (cod_cinema, num_sala, hor_ini, min_ini, cod_filme)
values (2, 1, 14, 10, 3);
insert into SESSOES (cod_cinema, num_sala, hor_ini, min_ini, cod_filme)
values (2, 1, 18, 30, 1);
commit;
prompt 9 records loaded
prompt Enabling foreign key constraints for FILMES...
alter table FILMES enable constraint FIE_PRA_FK;
prompt Enabling foreign key constraints for DIRECOES...
alter table DIRECOES enable constraint DIE_DIR_FK;
alter table DIRECOES enable constraint DIE_FIE_FK;
prompt Enabling foreign key constraints for PRECOS...
alter table PRECOS enable constraint PRO_CIA_FK;
prompt Enabling foreign key constraints for SALAS...
alter table SALAS enable constraint SAA_CIA_FK;
prompt Enabling foreign key constraints for SESSOES...
alter table SESSOES enable constraint SEE_FIE_FK;
alter table SESSOES enable constraint SEE_SAA_FK;
prompt Enabling triggers for CINEMAS...
alter table CINEMAS enable all triggers;
prompt Enabling triggers for DIRETORES...
alter table DIRETORES enable all triggers;
prompt Enabling triggers for PRODUTORAS...
alter table PRODUTORAS enable all triggers;
prompt Enabling triggers for FILMES...
alter table FILMES enable all triggers;
prompt Enabling triggers for DIRECOES...
alter table DIRECOES enable all triggers;
prompt Enabling triggers for PRECOS...
alter table PRECOS enable all triggers;
prompt Enabling triggers for SALAS...
alter table SALAS enable all triggers;
prompt Enabling triggers for SESSOES...
alter table SESSOES enable all triggers;
set feedback on
set define on
prompt Boa prova!
