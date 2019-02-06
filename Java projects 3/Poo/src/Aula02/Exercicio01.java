package Aula02;

import java.util.Scanner;

public class Exercicio01 {

	private static Scanner leia;

	public static void main(String[] args) {
		int quantidade;
		leia = new Scanner(System.in);
		System.out.print("Digite o tamanho do seu vetor: ");
		quantidade = leia.nextInt();
		int numeros [] = new int [quantidade];
		for (int i = 0; i < numeros.length; i ++) {
			System.out.print("Digite um numero: ");
			numeros [i] = leia.nextInt();
		}
		System.out.println("Quantidade de numeros = " + quantidade);
		System.out.print("Numeros: ");
		for (int i = 0; i < numeros.length; i++) {
			System.out.print(numeros [i] + " ");
		}
	}

}
