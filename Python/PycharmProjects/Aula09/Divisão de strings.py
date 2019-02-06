frase = 'Curso em Video Python'

print('Dividindo a string em uma lista de strings:', frase.split())

new_frase = frase.split()

print('Junção de uma lista de strings (Juntando espaços em branco no meio das strings da lista, e por fim juntando toudo junto):', ' '.join(new_frase[0:]))

print('Outro exmplo:', '-'.join(new_frase[0:]))

print('Outro exmplo:', '-'.join(new_frase))

print('Outro exmplo:', ' '.join(new_frase))

print('Outro exmplo:', '-'.join(frase))



