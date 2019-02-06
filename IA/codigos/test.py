import math
objective_position = [0, 1, 2, 3, 4, 5, 6, 7, 8]
init_position = [7, 2, 4, 5, 0, 6, 8, 3, 1]

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

print(number_of_outside(init_position, objective_position))