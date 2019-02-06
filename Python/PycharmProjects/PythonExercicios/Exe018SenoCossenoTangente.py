from math import sin, cos, tan, radians
angulo = float(input('Digite um angulo: '))
print('O seno, cosseno e tangente do angulo {}º, são respectivamente em radianos: {:.2f}, {:.2f} e {:.2f}.'.format(angulo, sin(radians(angulo)), cos(radians(angulo)), tan(radians(angulo))))
