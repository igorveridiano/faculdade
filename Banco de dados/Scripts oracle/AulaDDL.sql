-- Criando tabelas
CREATE TABLE tipos_contas (
    idt_tpo   NUMBER(4) NOT NULL,
    dsc_tpo   VARCHAR2(80) NOT NULL
)
TABLESPACE dados_acad;

CREATE TABLE contas (
    idt_conta     NUMBER(6) NOT NULL,
    dat_emissao   DATE NOT NULL,
    ano           NUMBER(4) NOT NULL,
    mes           NUMBER(2) NOT NULL,
    dat_venc      DATE NOT NULL,
    idt_cred      NUMBER(4) NOT NULL,
    idt_tpo       NUMBER(4) NOT NULL,
    valor         NUMBER(5,2) NOT NULL,
    status        CHAR(1) NOT NULL,
    dat_baixa     DATE,
    obs           VARCHAR2(300)
)
TABLESPACE dados_acad;

CREATE TABLE credores (
    idt_cred   NUMBER(4) NOT NULL,
    nom_cr     VARCHAR2(80) NOT NULL,
    fones      VARCHAR2(10)
)
TABLESPACE dados_acad;

-- Restrição de chave única

CREATE UNIQUE INDEX cre_uk_01 ON
    credores (
        cpf_cnpj
    );

-- Exemplos Alter

ALTER TABLE credores RENAME COLUMN nom_cr TO nom_cred;

ALTER TABLE credores MODIFY
    fones VARCHAR2(40) NOT NULL;

ALTER TABLE credores ADD cpf_cnpj VARCHAR2(14) NOT NULL;

-- Restrição de chave primária

ALTER TABLE tipos_contas ADD (
    CONSTRAINT tca_pk PRIMARY KEY ( idt_tpo )
        USING INDEX TABLESPACE indices_acad
);

ALTER TABLE contas ADD (
    CONSTRAINT coa_pk PRIMARY KEY ( idt_conta )
        USING INDEX TABLESPACE indices_acad
);

ALTER TABLE credores ADD (
    CONSTRAINT cre_pk PRIMARY KEY ( idt_cred )
        USING INDEX TABLESPACE indices_acad
);

SELECT
    *
FROM
    user_tables
WHERE
    table_name IN (
        'CREDORES',
        'TIPOS_CONTAS',
        'CONTAS'
    );

SELECT
    column_name || ','
FROM
    user_tab_columns
WHERE
    table_name = 'CONTAS'
ORDER BY
    column_id;

SELECT
    *
FROM
    user_constraints
WHERE
    contraint_name = 'CRE_PK';

SELECT
    column_name
FROM
    user_ind_columns
WHERE
    index_name = 'CRE_PK';
    
-- Restrição de domínio    

ALTER TABLE tipos_contas ADD (
    CONSTRAINT tpo_idt_tpo_ck CHECK ( idt_tpo BETWEEN 1 AND 9999 )
);

ALTER TABLE contas ADD (
    CONSTRAINT con_idt_conta_ck CHECK ( idt_conta BETWEEN 1 AND 999999 )
);

ALTER TABLE contas ADD (
    CONSTRAINT con_idt_cred_ck CHECK ( idt_cred BETWEEN 1 AND 9999 )
);

ALTER TABLE contas ADD (
    CONSTRAINT con_idt_tpo_ck CHECK ( idt_tpo BETWEEN 1 AND 9999 )
);

ALTER TABLE contas DROP CONSTRAINT con_status_ck;

ALTER TABLE contas ADD (
    CONSTRAINT con_status_ck CHECK ( status IN (
        'P',
        'N'
    ) )
);

ALTER TABLE contas ADD (
    CONSTRAINT cre_idt_cred_ck CHECK ( idt_cred BETWEEN 1 AND 9999 )
);

-- Restrição de integridade referencial

ALTER TABLE contas ADD (
    CONSTRAINT coa_cre_fk FOREIGN KEY ( idt_cred )
        REFERENCES credores ( idt_cred )
);

ALTER TABLE contas ADD (
    CONSTRAINT coa_tca_fk FOREIGN KEY ( idt_tpo )
        REFERENCES tipos_contas ( idt_tpo )
);

ALTER TABLE contas DROP CONSTRAINT coa_cre_fk;

ALTER TABLE contas
    ADD CONSTRAINT coa_cre_fk FOREIGN KEY ( idt_cred )
        REFERENCES credores ( idt_cred )
            ON DELETE CASCADE;

ALTER TABLE contas DROP CONSTRAINT coa_tca_fk;

ALTER TABLE contas
    ADD CONSTRAINT coa_tca_fk FOREIGN KEY ( idt_tpo )
        REFERENCES tipos_contas ( idt_tpo )
            ON DELETE SET NULL;
            
-- Criação de index

CREATE INDEX tca_dsc_i ON
    tipos_contas (
        dsc_tpo
    )
        TABLESPACE indices_acad;

CREATE INDEX cre_nom_i ON
    credores (
        nom_cred
    )
        TABLESPACE indices_acad;

CREATE INDEX coa_cre_fk_i ON
    contas (
        idt_cred
    )
        TABLESPACE indices_acad;

CREATE INDEX coa_tca_fk_i ON
    contas (
        idt_tpo
    )
        TABLESPACE indices_acad;
        
-- Criaçã de sequência

CREATE SEQUENCE seq_cred MAXVALUE 9999 MINVALUE 1 NOCYCLE;

CREATE SEQUENCE seq_contas MAXVALUE 999999 MINVALUE 1 NOCYCLE;

CREATE SEQUENCE seq_tpo_conta MAXVALUE 9999 MINVALUE 1 NOCYCLE;

-- Gerando dados

INSERT INTO tipos_contas VALUES (
    1,
    'Custos fixos'
);

INSERT INTO tipos_contas VALUES (
    2,
    'Custos variáveis'
);

SELECT
    *
FROM
    tipos_contas;

COMMIT;

INSERT INTO credores VALUES (
    1,
    'Credor 1',
    'X',
    '11111111111'
);

INSERT INTO credores VALUES (
    2,
    'Credor 2',
    'X',
    '22222222222'
);

INSERT INTO credores VALUES (
    3,
    'Credor 3',
    'X',
    '33333333333'
);

SELECT
    *
FROM
    credores;

INSERT INTO contas VALUES (
    1,
    SYSDATE,
    2018,
    10,
    '20/11/2018',
    3,
    1,
    800,
    'N',
    NULL,
    NULL
);

INSERT INTO contas VALUES (
    2,
    SYSDATE,
    2018,
    10,
    '25/11/2018',
    1,
    2,
    500,
    'N',
    NULL,
    NULL
);

SELECT
    *
FROM
    contas;

COMMIT;

-- Criação de visões (Views)

CREATE OR REPLACE FORCE VIEW v_contas (
    idt_conta,
    ano,
    mes,
    dat_emissao,
    dat_venc,
    idt_cred,
    nom_cred,
    idt_tpo,
    dsc_tpo,
    valor,
    status,
    obs
) AS
    SELECT
        idt_conta     idt_conta,
        ano           ano,
        mes           mes,
        dat_emissao   dat_emissao,
        dat_venc      dat_venc,
        c.idt_cred    idt_cred,
        nom_cred      nom_cred,
        t.idt_tpo     idt_tpo,
        dsc_tpo       dsc_tpo,
        valor         valor,
        status        status,
        obs           obs
    FROM
        contas c,
        credores cr,
        tipos_contas t
    WHERE
        c.idt_cred = cr.idt_cred
        AND c.idt_tpo = t.idt_tpo
/

SELECT
    *
FROM
    v_contas;

-- Triggers de INSTEAD OF

SELECT
    *
FROM
    contas;
    
INSERT INTO contas VALUES (
    NULL,
    SYSDATE,
    2018,
    10,
    '25/11/2018',
    1,
    2,
    500,
    'P',
    NULL,
    NULL
);    

CREATE OR REPLACE TRIGGER contas_biu BEFORE
    INSERT OR UPDATE ON contas
    FOR EACH ROW
BEGIN
    IF inserting THEN
        :new.status := 'N';
        SELECT
            seq_contas.NEXTVAL
        INTO :new.idt_conta
        FROM
            dual;

    END IF;

    :new.dat_emissao := trunc(:new.dat_emissao);
    :new.dat_venc := trunc(:new.dat_venc);
END;