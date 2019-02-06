dias = int(input('Quantos dias alugado? '))
km = float(input('Qauntos Km rodados? '))
valor = (60 * dias) + (km * 0.15)
print('O total a pagar é R${:.2f}'.format(valor))
