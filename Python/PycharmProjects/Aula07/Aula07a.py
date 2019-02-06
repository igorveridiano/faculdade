nome = input('Qual é seu nome? ')
n1 = int(input('Digite um numero: '))
n2 = int(input('Digite um numero: '))
s = n1 + n2
m = n1 * n2
d = n1 / n2
di = n1 // n2
e = n1 ** n2
print('Prazer em te conhecer {:*^20}!'.format(nome), end=' ')
print('{} + {} = {}, {} x {} = {}, {} / {} = {:.3f}, {} // {} = {}, {} ** {} = {}'.format(n1, n2, s, n1, n2, m, n1, n2, d, n1, n2, di, n1, n2, e))

