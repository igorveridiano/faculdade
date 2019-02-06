def fibonnaci(n):
    if n < 2:
        return n
    return fibonnaci(n - 1) + fibonnaci(n - 2)


n = int(input('Digite um numero:'))
print(fibonnaci(n))
