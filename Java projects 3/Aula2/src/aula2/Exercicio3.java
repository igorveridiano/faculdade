package aula2;

import java.util.Scanner;

public class Exercicio3 {

	private static Scanner leia;

	public static void main(String[] args) {
		leia = new Scanner(System.in);
		int a,b,c;
		System.out.print("Digite um numero: ");
		a = leia.nextInt();
		System.out.print("Digite um numero: ");
		b = leia.nextInt();
		System.out.print("Digite um numero: ");
		c = leia.nextInt();
		if ((a > c & b > c) | (a == b & a > c)) {
			System.out.println("\nA media aritmetica �: " + ((a + b) / 2));
		} else {
			if ((a > b & c > b) | (a == c & a > b)) {
				System.out.println("\nA media aritmetica �: " + ((a + c) / 2));
			} else {
				if ((b > a & c > a) | (b == c & b > a)) {
					System.out.println("\nA media aritmetica �: " + ((c + b) / 2));
				} else {
					System.out.println("\nN�o se pode comparar pois os tr�s valores iguais, por favor digite outros numeros");
				}
			}
		}
	}

}
