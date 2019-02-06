package aula02;

import java.util.Random;

public class VerificandoNumerosPrimosDeUmVetorRandom {

	private static Random sorteio;

	public static void main(String[] args) {
		int i,j,p=0,x = 0;
		sorteio = new Random();
		int[] vet = new int[16];
		int[] vet1 = new int[16];
		for (i = 0 ; i < vet.length ; i++) {
			vet [i] = sorteio.nextInt(99) + 1;
		}
		for (i = 0 ; i < vet.length ; i++) {
			for (j = 2 ; j <= vet[i]/2 ; j++){
				if (vet[i] % j == 0) {
					x = x + 1;
				} 
			}
			if (x == 0) {
				vet1[p] = vet [i];
				p++;
			}
			x = 0;
		}
		System.out.print("Vetor a = ");
		for (i = 0 ; i < vet.length ; i++) {
			System.out.printf("%02d " , vet[i]);
		}
		System.out.print("\nVetor b = ");
		for (i = 0 ; i < p ; i++) {
			System.out.printf("%02d " , vet1[i]);
		}
	}

}
