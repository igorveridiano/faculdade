package aula02;

import java.util.Scanner;

public class MediaDosDoisMaioresValores {

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
		if ((a > c & b > c)) {
			System.out.println("\nA media aritmetica é: " + ((a + b) / 2));
		} else {
			if ((a > b & c > b)) {
				System.out.println("\nA media aritmetica é: " + ((a + c) / 2));
			} else {
				if ((b > a & c > a)) {
					System.out.println("\nA media aritmetica é: " + ((c + b) / 2));
				} else {
					System.out.println("\nNão se pode comparar pois os três valores iguais, por favor digite outros numeros");
				}
			}
		}
	}

}
