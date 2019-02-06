numero_movimentos = 0
conjuto_movimentos = []


def hanoi(n, pino_ini, pino_fim, pino_aux, controle):
    if n == 1:
        move(n, pino_ini, pino_fim, controle)
    else:
        hanoi(n - 1, pino_ini, pino_aux, pino_fim, controle)
        move(n, pino_ini, pino_fim, controle)
        hanoi(n - 1, pino_ini, pino_aux, pino_fim, controle)


def move(n, pino_ini, pino_fim, controle):
    global numero_movimentos
    numero_movimentos += 1
    print("Movimento numero:", numero_movimentos, "move disco: ", n, "de:", pino_ini, "para", pino_fim)

    if controle[n - 1] == 0:
        controle[n - 1] = 1
    else:
        controle[n - 1] = 0

    pega_conjunto(controle)
    print(conjuto_movimentos)


def pega_conjunto(controle):
    conjunto = []
    for i in range(0, len(controle)):
        if controle[i] == 1:
            conjunto.append(i + 1)

    conjuto_movimentos.append(conjunto)
    return


ndiscos = 4
controle = []
conjuto_movimentos.append([])
for i in range(0, ndiscos):
    controle.append(0)
hanoi(ndiscos, 'A', 'B', 'C', controle)
