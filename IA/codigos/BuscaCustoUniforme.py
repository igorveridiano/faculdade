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

visited = [first_state]
result = []
state_ = ''
list_ways = []

count_cost = 0

# Function declaration
def get_adjacent_not_visited(state):
    global visited
    global map_maze

    states = map_maze[state]
    return_ = []

    for s in states:
        if s[0] not in visited:
            return_.append(s)

    return return_


class SmallestPathElement:

    def __init__(self, vertex, dist):
        self.path = ''
        self.vertex = vertex
        self.S = False
        self.dist = dist

    def setvertex(self, vertex):
        self.vertex = vertex

    def sets(self, s):
        self.S = s

    def setdist(self, dist):
        self.dist = dist

    def setpath(self, path):
        self.path = path

    def getvertex(self):
        return self.vertex

    def getdist(self):
        return self.dist

    def getpath(self):
        return self.path

    def gets(self):
        return self.S

def getsmallerpath(current_vertex, list_elements):
    for vertex in get_adjacent_not_visited(current_vertex):
        help_x = False
        if vertex not in visited:
            for element_y in list_elements:
                if element_y.getvertex().__eq__(vertex[0]):
                    for element_x in list_elements:
                        if element_x.getvertex().__eq__(current_vertex) and element_x.gets():
                            distance = element_x.getdist() + vertex[1]
                            if distance.__lt__(element_y.getdist()):
                                element_y.setdist(distance)
                                element_y.setpath(current_vertex)
                                help_x = True
                                break
                if help_x:
                    break

# Code Implementation
for elements in map_maze:
    element = SmallestPathElement(elements, 9999999999999999999999)
    list_ways.append(element)
list_element = [first_state]
for elements in list_ways:
    if elements.getvertex().__eq__(first_state):
        elements.setdist(0)
        elements.setpath('-')
        elements.sets(True)
        break

while len(list_element) != 0:
    help_y = True
    current = list_element.pop()
    getsmallerpath(current, list_ways)
    for x in range(len(list_ways)):
        for y in range(len(list_ways)):
            if list_ways[x].getdist() < list_ways[y].getdist():
                elementaux1 = list_ways[x]
                list_ways.insert(x, list_ways[y])
                list_ways.remove(elementaux1)
                elementaux2 = list_ways[y]
                list_ways.insert(y, elementaux1)
                list_ways.remove(elementaux2)
    for elements_x in list_ways:
        if help_y:
            if not elements_x.gets():
                elements_x.sets(True)
                for elements_y in map_maze:
                    if elements_y.__eq__(elements_x.getvertex()) and elements_y not in visited:
                        visited.append(elements_y)
                        list_element.append(elements_y)
                        break
                help_y = False
        else:
            break
visited = []
while state_.__ne__(first_state):
    for elements_z in list_ways:
        if elements_z.getvertex().__eq__(objective_state) and elements_z not in visited:
            visited.append(elements_z)
            state_ = elements_z.getpath()
            count_cost = elements_z.getdist()
        elif elements_z.getvertex().__eq__(state_) and elements_z not in visited:
            visited.append(elements_z)
            if elements_z.getvertex().__ne__(first_state):
                state_ = elements_z.getpath()
            else:
                state_ = first_state
while len(visited) != 0:
    result.append(visited[len(visited) - 1].getvertex())
    x = visited[len(visited) - 1]
    visited.remove(x)

print("Caminho resultante: %s" % result)
print("Custo do caminho: %s" % count_cost)

