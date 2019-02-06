package aula04;

import java.util.Scanner;

public class Exercicio05 {
	
	private static Scanner leia;

	public static void main(String[] args) {
		int vetorA [] = new int [10];
		int vetorB [] = new int [10];
		int vetorC [] = new int [20];
		int i = 0, x = 0, y = 0;
		leia = new Scanner(System.in);
		for (int z = 0; z < vetorA.length; z++){
			System.out.print("Digite um numero: ");
			vetorA [z] = leia.nextInt();
		}
		for (int z = 0; z < vetorB.length; z++){
			System.out.print("Digite um numero: ");
			vetorB [z] = leia.nextInt();
		}
		while (i < vetorC.length){
			vetorC [i] = vetorA [x];
			x++;
			i++;
			vetorC [i] = vetorB [y];
			y++;
			i++;
		}
		System.out.print("VetorA: ");
		for (int z = 0; z < vetorA.length; z++){
			System.out.print(vetorA[z] + " ");
		}
		System.out.print("\nVetorB: ");
		for (int z = 0; z < vetorB.length; z++){
			System.out.print(vetorB[z] + " ");
		}
		System.out.print("\nVetorC: ");
		for (int z = 0; z < vetorC.length; z++){
			System.out.print(vetorC[z] + " ");
		}
	}

}
