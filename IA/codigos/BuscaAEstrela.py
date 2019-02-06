objective_position = [0, 1, 2, 3, 4, 5, 6, 7, 8]
init_position = [5, 2, 8, 4, 1, 7, 0, 3, 6]

explored = []


def pretty_print(result):
    for r in result:
        print("\t" + str(r))

# Heurística utilizada: o número de pedras fora do lugar
def number_of_outside(array, objective):
    result = 0
    x1 = 0
    y1 = 0
    for x in objective:
        heur = 0
        x2 = 0
        y2 = 0
        for y in array:
            if x != 0 and y != 0:
                if x.__eq__(y):
                    a = (x1 - x2)
                    b = (y1 - y2)
                    if a < 0:
                        a = a * -1
                    if b < 0:
                        b = b * -1
                    heur = a + b
                    result = result + heur
            if y2 == 2:
                x2 = x2 + 1
                y2 = 0
            else:
                y2 = y2 + 1
        if y1 == 2:
            x1 = x1 + 1
            y1 = 0
        else:
            y1 = y1 + 1
    return result


def get_best_frontier(frontier):

    less_value = float('Inf')
    best_frontier_ = []

    for path in frontier:
        path_cost = len(path) - 1
        heuristc_cost = path[-1][1]
        final_cost = path_cost + heuristc_cost
        if final_cost < less_value:
            less_value = final_cost
            best_frontier_ = path

    return best_frontier_


def get_possible_states(best_frontier):
    global explored
    last_path = best_frontier[-1][0]
    black_index = [index for index, number in enumerate(last_path) if number == 0][0]

    index_up = black_index - 3
    index_down = black_index + 3
    index_right = black_index + 1
    index_left = black_index - 1

    possible_states = []

    if index_up >= 0:
        new_path = [e for e in last_path]
        temp_value = new_path[index_up]
        new_path[index_up] = 0
        new_path[black_index] = temp_value

        if new_path not in explored:
            possible_states.append(new_path)

    if index_down < 9:
        new_path = [e for e in last_path]
        temp_value = new_path[index_down]
        new_path[index_down] = 0
        new_path[black_index] = temp_value

        if new_path not in explored:
            possible_states.append(new_path)

    if index_right < 9 and index_right % 3 != 0:
        new_path = [e for e in last_path]
        temp_value = new_path[index_right]
        new_path[index_right] = 0
        new_path[black_index] = temp_value

        if new_path not in explored:
            possible_states.append(new_path)

    if index_left >= 0 and black_index % 3 != 0:
        new_path = [e for e in last_path]
        temp_value = new_path[index_left]
        new_path[index_left] = 0
        new_path[black_index] = temp_value

        if new_path not in explored:
            possible_states.append(new_path)

    return possible_states


first_state = (init_position, number_of_outside(init_position, objective_position))

frontier = [
    [first_state],
]

best_frontier = get_best_frontier(frontier)

if best_frontier[-1][0] not in explored:
    explored.append(best_frontier[-1][0])

count = 0
while best_frontier[-1][0] != objective_position:
    possible_states = get_possible_states(best_frontier)

    frontier.remove(best_frontier)

    for state in possible_states:
        new_frontier = [e for e in best_frontier]
        new_frontier.append((state, number_of_outside(state, objective_position)))
        frontier.append(new_frontier)

    best_frontier = get_best_frontier(frontier)

    if best_frontier[-1][0] not in explored:
        explored.append(best_frontier[-1][0])

    count += 1

result = [e[0] for e in best_frontier]
count_cost = (len(best_frontier) - 1) + best_frontier[-1][1]


print("Melhor caminho da fronteira:")
pretty_print(result)
print("Custo do melhor caminho: %s" % count_cost)
print("Numero de estados explorados: %s" % len(explored))