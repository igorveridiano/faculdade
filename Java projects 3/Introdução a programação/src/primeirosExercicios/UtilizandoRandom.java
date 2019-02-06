package primeirosExercicios;

import java.util.Random;

public class UtilizandoRandom {

	private static Random gerador;

	public static void main(String[] args) {
		int i , j , x = 0 , d = 0, c = 0;
		int [] vet = new int [10];
		gerador = new Random();
		for (i = 0 ; i < vet.length ; i++){
			vet [i] = gerador.nextInt(9) + 1;
		}
		for (i = 0 ; i <= vet.length - 1  ; i++){
			System.out.printf("%02d " , vet[i]);
			for (j = vet.length - 1 ; j >= 0 ; j--){
				if (vet [i] > vet [j]) {
				x = x + 1;
				if (x == vet.length - 1 ) {
					d = d + vet [i];
					c = c + i;
				}
				}
			}
			x = 0;
		}
		System.out.print("\nNumero:" + d);
		System.out.print("\nPosição:" + c);
	}

}
