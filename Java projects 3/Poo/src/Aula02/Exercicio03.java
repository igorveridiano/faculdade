package Aula02;

import java.util.Scanner;

public class Exercicio03 {

	private static Scanner leia;

	public static void main(String[] args) {
		int numeros [] = new int [10];
		int pares [] = new int [10];
		int impares [] = new int [10];
		int j = 0, y = 0;
		leia = new Scanner(System.in);
		for (int i = 0; i < numeros.length; i++){
			System.out.print("Digite um numero: ");
			numeros [i] = leia.nextInt();
		}
		for (int i = 0; i < numeros.length; i++) {
			if (numeros [i] % 2 == 0){
				pares [j] = numeros [i];
				j ++;
		  }
	   }
		for (int i = 0; i < numeros.length; i++) {
			if (numeros [i] % 2 == 1){
				impares [y] = numeros [i];
				y ++;
		  }
	   }
		System.out.print("Pares: ");
		for (int i = 0; i < j; i++){
			System.out.print(pares[i] + " ");
		}
		System.out.print("\nImpares: ");
		for (int i = 0; i < y; i++){
			System.out.print(impares[i] + " ");
		}
	}

}
