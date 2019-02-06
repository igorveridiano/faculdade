-- Exercicios Update
-- 1
-- A
UPDATE atend_bebidas a
SET
    subtotal = (
        SELECT
            subtotal
        FROM
            (
                SELECT
                    num_atendimento,
                    idt_bebida,
                    ( qtde_pedida * preco_unitario ) subtotal
                FROM
                    atend_bebidas
                    INNER JOIN bebidas USING ( idt_bebida )
                GROUP BY
                    num_atendimento,
                    idt_bebida,
                    ( qtde_pedida * preco_unitario )
            ) b
        WHERE
            a.num_atendimento = b.num_atendimento
            AND a.idt_bebida = b.idt_bebida
    );

-- B

UPDATE atend_pratos a
SET
    subtotal = (
        SELECT
            subtotal
        FROM
            (
                SELECT
                    num_atendimento,
                    idt_prato,
                    ( qtde_pedida * preco_unitario ) subtotal
                FROM
                    atend_pratos
                    INNER JOIN pratos USING ( idt_prato )
                GROUP BY
                    num_atendimento,
                    idt_prato,
                    ( qtde_pedida * preco_unitario )
            ) b
        WHERE
            a.num_atendimento = b.num_atendimento
            AND a.idt_prato = b.idt_prato
    );

-- 2

UPDATE atendimentos a
SET
    valor_total = (
        SELECT
            total
        FROM
            (
                SELECT
                    p.num_atendimento,
                    ( p.subtotal + b.subtotal ) total
                FROM
                    (
                        SELECT
                            num_atendimento,
                            SUM(subtotal) subtotal
                        FROM
                            atend_pratos
                        GROUP BY
                            num_atendimento
                    ) p
                    INNER JOIN (
                        SELECT
                            num_atendimento,
                            SUM(subtotal) subtotal
                        FROM
                            atend_bebidas
                        GROUP BY
                            num_atendimento
                    ) b ON p.num_atendimento = b.num_atendimento
            ) c
        WHERE
            a.num_atendimento = c.num_atendimento
    ),
    valor_comissao = (
        SELECT
            comissao
        FROM
            (
                SELECT
                    p.num_atendimento,
                    ( ( p.subtotal + b.subtotal ) * 0.1 ) comissao
                FROM
                    (
                        SELECT
                            num_atendimento,
                            SUM(subtotal) subtotal
                        FROM
                            atend_pratos
                        GROUP BY
                            num_atendimento
                    ) p
                    INNER JOIN (
                        SELECT
                            num_atendimento,
                            SUM(subtotal) subtotal
                        FROM
                            atend_bebidas
                        GROUP BY
                            num_atendimento
                    ) b ON p.num_atendimento = b.num_atendimento
            ) c
        WHERE
            a.num_atendimento = c.num_atendimento
    )
WHERE
    (
        SELECT
            pedidos
        FROM
            (
                SELECT
                    p.num_atendimento,
                    ( p.pedidos + b.pedidos ) pedidos
                FROM
                    (
                        SELECT
                            num_atendimento,
                            COUNT(idt_prato) pedidos
                        FROM
                            atend_pratos
                        GROUP BY
                            num_atendimento
                    ) p
                    INNER JOIN (
                        SELECT
                            num_atendimento,
                            COUNT(idt_bebida) pedidos
                        FROM
                            atend_bebidas
                        GROUP BY
                            num_atendimento
                    ) b ON p.num_atendimento = b.num_atendimento
            ) c
        WHERE
            a.num_atendimento = c.num_atendimento
    ) > 0;
    
-- 3

SELECT
    modalidade,
    nome             item,
    preco_unitario   "PREÇO UNITARIO",
    quantidade,
    subtotal         total
FROM
    (
        SELECT
            num_atendimento   atendimento,
            'Prato' modalidade,
            idt_prato         codigo,
            nome_prato        nome,
            qtde_pedida       quantidade,
            preco_unitario,
            subtotal
        FROM
            atend_pratos
            INNER JOIN pratos USING ( idt_prato )
        UNION
        SELECT
            num_atendimento,
            'Bebida' modalidade,
            idt_bebida,
            nome_bebida,
            qtde_pedida,
            preco_unitario,
            subtotal
        FROM
            atend_bebidas
            INNER JOIN bebidas USING ( idt_bebida )
    )
WHERE
    atendimento = 1;