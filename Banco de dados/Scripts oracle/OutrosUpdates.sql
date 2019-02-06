-- Outros Updates
-- 1

UPDATE pratos p1
SET
    nome_prato = (
        SELECT
            replace(nome_prato,'Filé','Fil�')
        FROM
            pratos p2
        WHERE
            p1.idt_prato = p2.idt_prato
    );

-- 2

UPDATE pratos p1
SET
    nome_prato = (
        SELECT
            replace(nome_prato,'Medalhão','Medalh�o')
        FROM
            pratos p2
        WHERE
            p1.idt_prato = p2.idt_prato
    );
    
-- 3

UPDATE bebidas b1
SET
    nome_bebida = (
        SELECT
            replace(nome_bebida,'�?gua','�gua')
        FROM
            bebidas b2
        WHERE
            b1.idt_bebida = b2.idt_bebida
    );
    
-- 4

UPDATE bebidas b1
SET
    nome_bebida = (
        SELECT
            replace(nome_bebida,'tônica','T�nica')
        FROM
            bebidas b2
        WHERE
            b1.idt_bebida = b2.idt_bebida
    );

COMMIT;