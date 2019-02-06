package aula2;

import java.util.Random;
import java.util.Scanner;

public class Exerciciovetor1 {

	private static Random sorteio;
	private static Scanner leia;

	public static void main(String[] args) {
		sorteio = new Random();
		leia = new Scanner(System.in);
		int chave , pos = 1;
		boolean achou = false;
		int i;
		int [] vet = new int[20];
		for (i = 0 ; i < vet.length ; i++) {
			vet [i] = sorteio.nextInt(99)  + 1;
		}
		for (i = 0 ; i < vet.length; i++){
			System.out.printf("%02d ", vet[i]);
			}
			System.out.print("\nInforme uma chave: ");
			chave = leia.nextInt();
			i = 0;
			while (i < vet.length & !achou){
			if (chave == vet[i]){
			pos = i;
			achou = true;
			}
			i++;
			}
			if (achou){
			System.out.println("\nChave na posicao " + pos );
			} else {
			System.out.println("\nChave nao encontrada" );
			}
	}

}
