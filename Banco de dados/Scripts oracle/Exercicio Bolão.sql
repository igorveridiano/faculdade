-- Exercicio Bolão
-- Criação das tabelas
CREATE TABLE usuarios (
    idt_usu      NUMBER(2) NOT NULL,
    nom_usu      VARCHAR2(80) NOT NULL,
    qtd_pontos   NUMBER(4) NOT NULL,
    creditos     NUMBER(8,2) NOT NULL
);

CREATE TABLE times (
    cod_time   NUMBER(2) NOT NULL,
    dsc_time   VARCHAR2(80) NOT NULL,
    cidade     VARCHAR2(40) NOT NULL,
    uf         CHAR(2) NOT NULL
);

CREATE TABLE jogos (
    rodada      NUMBER(2) NOT NULL,
    num_jogo    NUMBER(2) NOT NULL,
    cod_time1   NUMBER(2) NOT NULL,
    cod_time2   NUMBER(2) NOT NULL,
    placar1     NUMBER(2),
    placar2     NUMBER(2)
);

CREATE TABLE palpites (
    idt_usu    NUMBER(2) NOT NULL,
    rodada     NUMBER(2) NOT NULL,
    num_jogo   NUMBER(2) NOT NULL,
    placar1    NUMBER(2) NOT NULL,
    placar2    NUMBER(2) NOT NULL
);

-- Restrições de dominio

ALTER TABLE usuarios ADD (
    CONSTRAINT usu_idt_usu_ck CHECK ( idt_usu BETWEEN 1 AND 99 )
);

ALTER TABLE usuarios ADD (
    CONSTRAINT usu_qtd_pontos_ck CHECK ( qtd_pontos BETWEEN 1 AND 9999 )
);

ALTER TABLE times ADD (
    CONSTRAINT time_cod_time_ck CHECK ( cod_time BETWEEN 1 AND 99 )
);

ALTER TABLE jogos ADD (
    CONSTRAINT jogos_rodada_ck CHECK ( rodada BETWEEN 1 AND 99 )
);

ALTER TABLE jogos ADD (
    CONSTRAINT jogos_num_jogo_ck CHECK ( num_jogo BETWEEN 1 AND 99 )
);

ALTER TABLE jogos ADD (
    CONSTRAINT jogos_cod_time1_ck CHECK ( cod_time1 BETWEEN 1 AND 99 )
);

ALTER TABLE jogos ADD (
    CONSTRAINT jogos_cod_time2_ck CHECK ( cod_time2 BETWEEN 1 AND 99 )
);

ALTER TABLE jogos ADD (
    CONSTRAINT jogos_placar1_ck CHECK ( placar1 BETWEEN 1 AND 99 )
);

ALTER TABLE jogos ADD (
    CONSTRAINT jogos_placar2_ck CHECK ( placar2 BETWEEN 1 AND 99 )
);

-- Restrição de chave primaria

ALTER TABLE usuarios ADD (
    CONSTRAINT usu_pk PRIMARY KEY ( idt_usu )
);

ALTER TABLE times ADD (
    CONSTRAINT times_pk PRIMARY KEY ( cod_time )
);

ALTER TABLE jogos ADD (
    CONSTRAINT jogos_pk PRIMARY KEY ( rodada,
                                      num_jogo )
);

ALTER TABLE palpites ADD (
    CONSTRAINT palpites_pk PRIMARY KEY ( idt_usu,
                                         rodada,
                                         num_jogo )
);

-- Restrição de integridade referencial

ALTER TABLE jogos ADD (
    CONSTRAINT jogos_cod_time1_fk FOREIGN KEY ( cod_time1 )
        REFERENCES times ( cod_time )
);

ALTER TABLE jogos ADD (
    CONSTRAINT jogos_cod_time2_fk FOREIGN KEY ( cod_time2 )
        REFERENCES times ( cod_time )
);

ALTER TABLE palpites ADD (
    CONSTRAINT palpites_idt_usu_fk FOREIGN KEY ( idt_usu )
        REFERENCES usuarios ( idt_usu )
);

ALTER TABLE palpites ADD (
    CONSTRAINT palpites_rodada_num_jogo_fk FOREIGN KEY ( rodada,
                                                         num_jogo )
        REFERENCES jogos ( rodada,
                           num_jogo )
);

-- Index

CREATE INDEX nom_usu_i ON
    usuarios (
        nom_usu
    );

CREATE INDEX qtd_pontos_i ON
    usuarios (
        qtd_pontos
    );

CREATE INDEX creditos_i ON
    usuarios (
        creditos
    );

CREATE INDEX dsc_time_i ON
    times (
        dsc_time
    );

CREATE INDEX cidade_i ON
    times (
        cidade
    );

CREATE INDEX uf_i ON
    times (
        uf
    );

CREATE INDEX placar1_i ON
    palpites (
        placar1
    );

CREATE INDEX placar2_i ON
    palpites (
        placar2
    );

CREATE INDEX jogos_placar1_i ON
    jogos (
        placar1
    );

CREATE INDEX jogos_placar12_i ON
    jogos (
        placar2
    );
    
-- Views

CREATE OR REPLACE FORCE VIEW v_usuarios (
    nom_usu,
    qtd_pontos
) AS
    SELECT
        nom_usu      nom_usu,
        qtd_pontos   qtd_pontos
    FROM
        usuarios;     