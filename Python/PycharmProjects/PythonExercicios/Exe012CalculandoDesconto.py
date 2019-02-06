preco = float(input('Digite o preço do produto: R$ '))
desconto = preco * 0.05
print('O desconto será de R$ {:.2f} e o preço de R$ {:.2f} passara a ser de R$ {:.2f}'.format(desconto, preco, preco - desconto))

