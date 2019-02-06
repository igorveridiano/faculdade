from random import shuffle
n1 = input('Digite um nome: ')
n2 = input('Digite um nome: ')
n3 = input('Digite um nome: ')
n4 = input('Digite um nome: ')
nomes = [n1, n2, n3, n4]
shuffle(nomes)
print('A ordem de apresentação será: \n{}'.format(nomes))
