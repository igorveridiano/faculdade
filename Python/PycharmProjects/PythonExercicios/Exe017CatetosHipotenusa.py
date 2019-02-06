from math import hypot
co = float(input('Qual o cateto oposto? '))
ca = float(input('Qual o cateto adjacente? '))
print('A hipotenusa do cateto oposto {} e cateto adjacente {} é igual á {:.2f}'.format(co, ca, hypot(co, ca)))

