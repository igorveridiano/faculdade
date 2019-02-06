package Threads;

public class Calculadora {
	private int soma;

	public int SomaArray(int[] array) {
		soma = 0;
		for (int i = 0; i < array.length; i++) {
			soma += array[i];
			System.out.println("Executando a soma" + Thread.currentThread().getName() + "somando o valor" + array[i]
					+ " com o total de " + soma);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return soma;
	}
	//com o metodo abaixo o resultado da certo,pois somente uma thread por vez pode ter acesso ao método
	/*
	public synchronized int SomaArray(int[] array) {
		soma = 0;
		for (int i = 0; i < array.length; i++) {
			soma += array[i];
			System.out.println("Executando a soma" + Thread.currentThread().getName() + " somando o valor" + array[i]
					+ " com o total de " + soma);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return soma;
	}
	*/
}
