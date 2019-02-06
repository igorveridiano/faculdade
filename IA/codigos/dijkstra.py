map_maze = {
    'A': {'B': 5},
    'B': {'A' : 5, 'C' : 7, 'F' : 2},
    'C': {'B' : 7, 'L' : 8},
    'D': {'E' : 3},
    'E': {'D' : 3, 'I' : 6},
    'F': {'B' : 2, 'G' : 5, 'J' : 6},
    'G': {'F' : 5, 'K' : 6},
    'H': {'I' : 3},
    'I': {'E' : 6, 'J' : 2},
    'J': {'F' : 6, 'I' : 2, 'K' : 5, 'O' : 2},
    'K': {'G' : 6, 'J' : 5, 'L' : 2, 'T' : 9},
    'L': {'C' : 8, 'K' : 2, 'U' : 9},
    'M': {'N' : 3},
    'N': {'M' : 3, 'O' : 2, 'R' : 7},
    'O': {'J' : 2, 'N' : 2, 'P' : 3},
    'P': {'O' : 3, 'S' : 7},
    'Q': {'R' : 3},
    'R': {'N' : 7, 'Q' : 3, 'S' : 5},
    'S': {'P' : 7, 'R' : 5, 'T' : 2},
    'T': {'K' : 9, 'S' : 2, 'U' : 2},
    'U': {'L' : 9, 'T' : 2}
}

grafo = { "A" : { "B" : 1, "C":2 },
          "B" : { "D":2, "E":4 },
          "C" : { "E":2 },
          "D" : { "F": 6 },
          "E" : { "F": 7 },
          "F" : { }
          }

grafo2 = {  "D" : { "A": 4, "H": 1 },
            "A" : { "H": 10, "E": 1 },
            "H" : { "E": 5, "I": 9 },
            "E" : { "F" : 3 },
            "I" : { "J" : 2 },
            "F" : { "I" : 1, "G": 7, "B": 1, "C": 3 },
            "G" : { },
            "J" : { "G" : 1 },
            "B" : { "C" : 2 },
            "C" : { } }

def dijkstra_path(grafo, origem,
                  fim):  # retorna a menor distancia de um No origem até um No destino e o caminho até ele

    controle = {}
    distanciaAtual = {}
    noAtual = {}
    naoVisitados = []
    atual = origem
    noAtual[atual] = 0

    for vertice in grafo.keys():
        naoVisitados.append(vertice)  # inclui os vertices nos não visitados
        distanciaAtual[vertice] = float('inf')  # inicia os vertices como infinito

    distanciaAtual[atual] = [0, origem]

    naoVisitados.remove(atual)

    while naoVisitados:
        for vizinho, peso in grafo[atual].items():
            pesoCalc = peso + noAtual[atual]
            if distanciaAtual[vizinho] == float("inf") or distanciaAtual[vizinho][0] > pesoCalc:
                distanciaAtual[vizinho] = [pesoCalc, atual]
                controle[vizinho] = pesoCalc
                print(controle)

        if controle == {}: break
        minVizinho = min(controle.items(), key=lambda x: x[1])  # seleciona o menor vizinho
        atual = minVizinho[0]
        noAtual[atual] = minVizinho[1]
        naoVisitados.remove(atual)
        del controle[atual]

    print("A menor distância de %s atá %s é: %s" % (origem, fim, distanciaAtual[fim][0]))
    print("O menor caminho é: %s" % printPath(distanciaAtual, origem, fim))


def printPath(distancias, inicio, fim):
    if fim != inicio:
        return "%s -- > %s" % (printPath(distancias, inicio, distancias[fim][1]), fim)
    else:
        return inicio

dijkstra_path(map_maze, 'A', 'Q')
