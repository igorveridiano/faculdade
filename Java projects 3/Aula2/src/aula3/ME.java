package aula3;

import java.util.Random;

public class ME {

	private static Random sorteio;

	public static void main(String[] args) {
		sorteio = new Random();
		int i, z = 0;
		int[] vet = new int[20];
		int[] vetprimo = new int[20];
		for(i = 0; i < vet.length; i++){
			vet[i] = sorteio.nextInt(99) + 1;
		}
		System.out.print("Vetor A: ");
		imrpimeVetor(vet);
		for (i = 0; i < vet.length; i++){
			 if (primo(vet[i])){
			 vetprimo[z] = vet[i];
			 z++;
			 }
			 }
		System.out.print("Vetor Primo: ");
		imrpimeVetor(vetprimo);
	}
	static boolean primo(int x) {
		 boolean primo;
		 int j, s = 0;
		 for(j = 2; j <= x/2; j++){
			 if (x % j == 0) {
					s = s + 1;
				} 
		 }
		 if (s == 0){
		 primo = true;
		 }else {
		 primo = false;
		 }
		 return primo;
		 }
	static void imrpimeVetor(int[] vetor){
		for (int i = 0; i < vetor.length; i++) {
			if(vetor[i] != 0){
			 System.out.print(vetor[i] + " ");
			}
			 }
			 System.out.print("\n"); 
	}
}