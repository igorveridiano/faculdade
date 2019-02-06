package aula3;

import java.util.Arrays;
import java.util.Random;

public class exemplo1 {

	private static Random sorteio;

	public static void main(String[] args) {
		sorteio = new Random();
		int i;
		int[] vet = new int[16];
		for(i = 0; i < vet.length; i++){
			vet[i] = sorteio.nextInt(99) + 1;
		}
		System.out.print("Vetor A: ");
		imrpimeVetor(vet);
		imprimeLinha();
		System.out.print("\nVetor ordenado: ");
		Arrays.sort(vet);
		imrpimeVetor(vet); 
	}
	static void imrpimeVetor(int[] vetor){
		for (int i = 0; i < vetor.length; i++) {
			 System.out.print(vetor[i] + " ");
			 }
			 System.out.print("\n"); 
	}
	static void imprimeLinha() {
		 System.out.print("\n");
		 for (int x = 1; x <= 163; x++){
		 System.out.print("-");
		 }
		 System.out.print("\n");
		} 
}
