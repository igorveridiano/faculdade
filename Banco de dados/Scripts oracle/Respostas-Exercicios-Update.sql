-- Respostas Exercicios Update

-- 1º 
UPDATE atend_bebidas a
SET
    subtotal = (
        SELECT
            preco_unitario * a.qtde_pedida
        FROM
            bebidas
        WHERE
            idt_bebida = a.idt_bebida
    );

UPDATE atend_pratos a
SET
    subtotal = (
        SELECT
            preco_unitario * a.qtde_pedida
        FROM
            pratos
        WHERE
            idt_prato = a.idt_prato
    );

-- 2º

UPDATE atendimentos a
SET
    valor_total = (
        SELECT
            nvl(SUM(subtotal),0)
        FROM
            atend_pratos
        WHERE
            num_atendimento = a.num_atendimento
    ) + (
        SELECT
            nvl(SUM(subtotal),0)
        FROM
            atend_bebidas
        WHERE
            num_atendimento = a.num_atendimento
    ),
    valor_comissao = ( (
        SELECT
            nvl(SUM(subtotal),0)
        FROM
            atend_pratos
        WHERE
            num_atendimento = a.num_atendimento
    ) + (
        SELECT
            nvl(SUM(subtotal),0)
        FROM
            atend_bebidas
        WHERE
            num_atendimento = a.num_atendimento
    ) ) * 0.1;

-- 3º

SELECT
    'Bebida' modalidade,
    nome_bebida,
    preco_unitario,
    qtde_pedida,
    subtotal
FROM
    atend_bebidas
    JOIN bebidas USING ( idt_bebida )
WHERE
    num_atendimento = 1
UNION ALL
SELECT
    'Prato' modalidade,
    nome_prato,
    preco_unitario,
    qtde_pedida,
    subtotal
FROM
    atend_pratos
    JOIN pratos USING ( idt_prato )
WHERE
    num_atendimento = 1;