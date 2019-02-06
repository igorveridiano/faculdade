package primeirosExercicios;

import java.util.Random;

public class MediaDeUmVetorRandom {

	private static Random sorteio;

	public static void main(String[] args) {
		int soma = 0 , divisor = 0 , i ;
		double media = 0;
		int [] vet = new int[16];
		sorteio = new Random();
		for (i = 0; i < vet.length ; i++) {
			vet [i] = sorteio.nextInt(99) + 1;
		}
		System.out.print("Vetor: ");
		for (i = 0; i < vet.length ; i++) {
			System.out.printf("%02d " , vet[i]);
		}
		for (i = 0; i < vet.length ; i++) {
			soma = soma + vet [i];
			divisor = divisor + 1;
		}
		media = soma / divisor;
		System.out.printf("\nMedia= %6.2f" , media);
	}

}
