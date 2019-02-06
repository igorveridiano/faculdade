#Desafio 22

nome = input('Digite o seu nome completo:')

print(nome.upper())
print(nome.lower())
list = nome.split()
new_nome = ''.join(list)
print(len(new_nome))
print(len(list[0]))

#Desafio 23

numero = input('Digite um numero entre 0 e 9999:')

if (len(numero) == 1):
    print('Unidade:', numero)
if (len(numero) == 2):
    print('Unidade:', numero[1])
    print('Dezena:', numero[0])
if (len(numero) == 3):
    print('Unidade:', numero[2])
    print('Dezena:', numero[1])
    print('Centena:', numero[0])
if (len(numero) == 4):
    print('Unidade:', numero[3])
    print('Dezena:', numero[2])
    print('Centena:', numero[1])
    print('Milhar:', numero[0])

numero = int(input('Digite um numero entre 0 e 9999:'))

numero.__str__()

if (len(numero.__str__()) == 1):
    print('Unidade:', numero.__str__())
if (len(numero.__str__()) == 2):
    print('Unidade:', numero.__str__()[1])
    print('Dezena:', numero.__str__()[0])
if (len(numero.__str__()) == 3):
    print('Unidade:', numero.__str__()[2])
    print('Dezena:', numero.__str__()[1])
    print('Centena:', numero.__str__()[0])
if (len(numero.__str__()) == 4):
    print('Unidade:', numero.__str__()[3])
    print('Dezena:', numero.__str__()[2])
    print('Centena:', numero.__str__()[1])
    print('Milhar:', numero.__str__()[0])


#Desafio 24

cidade = input('Digite o nome de sua cidade:')

if ('santo' in cidade.split()[0].lower()):
    print('Sua cidade começa com santo')
else:
    print('Sua cidade não começa com santo')

#Desafio 25

nome = input('Digite seu nome completo:')

if('silva' in nome.lower()):
    print('Você tem silva no nome')
else:
    print('Você não tem silva no nome')


#Desafio 26

frase = input('Digite uma frase:')

print("Quantas vezes a letra 'a' aparece:", frase.lower().count('a'))
print("A primeira posição que 'a' aparece:", frase.lower().find('a'))
print("A ultima posição que 'a' aparece:", frase.lower().rfind('a'))

#Desafio 27

nome = input('Digite seu nome completo:')

print('Primeiro:', nome.split()[0])
print('Ultimo:', nome.split()[len(nome.split()) - 1])
