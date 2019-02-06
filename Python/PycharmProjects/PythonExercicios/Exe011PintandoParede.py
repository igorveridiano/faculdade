altura = float(input('Digite a altura da parede: '))
largura = float(input('Digite a largura da parede: '))
area = altura * largura
quantidadeTinta = area / 2
print('Para pintar {} m², será necessário {} litros de tinta.'.format(area, quantidadeTinta))
