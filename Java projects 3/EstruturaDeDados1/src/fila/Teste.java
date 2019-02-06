package fila;



public class Teste {

	public static void main(String[] args) {
		FilaDupEnc<Integer> fila = new FilaDupEnc<Integer>();
		FilaDupEnc<Integer> fila2 = new FilaDupEnc<Integer>();
		fila.enfileirar(2);
		fila.enfileirar(3);
		System.out.println(fila.desenfileirar());
		for (Integer integer : fila) {
			fila2.enfileirar(integer);
			System.out.println(fila.primeiro());
			System.out.println(fila2.primeiro());
		}
	}

}
