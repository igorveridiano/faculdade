package aula04;

import java.util.Scanner;

public class Exercicio04 {

	private static Scanner leia;

	public static void main(String[] args) {
		int numeros [] = new int [10];
		int aux;
		leia = new Scanner(System.in);
		for (int i = 0; i < numeros.length; i++){
			System.out.print("Digite um numero: ");
			numeros [i] = leia.nextInt();
		}
		for (int i = 0; i < numeros.length; i++) {
			for (int j = 0; j < numeros.length - 1; j++){
				if (numeros [i] < numeros [j]){
					aux = numeros [i];
					numeros [i] = numeros [j];
					numeros [j] = aux;
				}
			}
		}
		System.out.print("Vetor ordenado: ");
		for (int i = 0; i < numeros.length; i++){
			System.out.print(numeros[i] + " ");
		}
	}

}
