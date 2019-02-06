map_maze = {
    'A': [('B', 5)],
    'B': [('A', 5), ('C', 7), ('F', 2)],
    'C': [('B', 7), ('L', 8)],
    'D': [('E', 3)],
    'E': [('D', 3), ('I', 6)],
    'F': [('B', 2), ('G', 5), ('J', 6)],
    'G': [('F', 5), ('K', 6)],
    'H': [('I', 3)],
    'I': [('E', 6), ('J', 2), ('H', 3)],
    'J': [('F', 6), ('I', 2), ('K', 5), ('O', 2)],
    'K': [('G', 6), ('J', 5), ('L', 2), ('T', 9)],
    'L': [('C', 8), ('K', 2), ('U', 9)],
    'M': [('N', 3)],
    'N': [('M', 3), ('O', 2), ('R', 7)],
    'O': [('J', 2), ('N', 2), ('P', 3)],
    'P': [('O', 3), ('S', 7)],
    'Q': [('R', 3)],
    'R': [('N', 7), ('Q', 3), ('S', 5)],
    'S': [('P', 7), ('R', 5), ('T', 2)],
    'T': [('K', 9), ('S', 2), ('U', 2)],
    'U': [('L', 9), ('T', 2)]
}

first_state = 'A'
objective_state = 'Q'
state = first_state
way = []
count_cost = 0
parametro = False

visited = [first_state]


def get_adjacent_not_visited(state):
    global visited
    global map_maze

    states = map_maze[state]
    return_ = []

    for s in states:
        if s[0] not in visited:
            return_.append(s)

    return return_

def get_min_way(state):
    global vertice
    global count_cost
    global map_maze
    list_vertice = get_adjacent_not_visited(state)
    if (len(list_vertice) == 0):
        aux1 = way[len(way) - 1]
        way.remove(way[len(way) - 1])
        aux2 = way[len(way) - 1]
        states = map_maze[aux2]
        for s in states:
            if aux1.__eq__(s[0]):
                h =  s[1]
        count_cost = count_cost - h
        return aux2
    aux = True
    for x in list_vertice:
        if(aux):
            vertice = x
            aux = False
        else:
            if (x[1] < vertice[1]):
                vertice = x
    return vertice

way.append(first_state)
y = get_min_way(state)
way.append(y[0])
count_cost = count_cost + y[1]
visited.append(y[0])
state = y[0]
while parametro is not True:
    if not (y[0].__eq__(way[len(way) -1])):
        way.append(y[0])
        count_cost = count_cost + y[1]
        visited.append(y[0])
        state = y[0]
    else:
        state = y[0]
    if(objective_state.__eq__(y[0])):
        parametro = True
        break;
    else:
        y = get_min_way(state)

print("Caminho resultante: %s" % way)
print("Custo do caminho: %s" % count_cost)