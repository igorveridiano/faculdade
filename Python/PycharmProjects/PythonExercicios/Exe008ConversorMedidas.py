metros = float(input('Digite a quantidade de metros: '))
centimetros = metros * 100
milimetros = metros * 1000
kilometro = metros / 1000
decametro = metros / 10
print('{} metros, em centrimetros é {} cm e em milimetros é {} mm.'.format(metros, centimetros, milimetros))
print('{} metros, em kilometros é {} km e em decametro é {} dam.'.format(metros, kilometro, decametro))
