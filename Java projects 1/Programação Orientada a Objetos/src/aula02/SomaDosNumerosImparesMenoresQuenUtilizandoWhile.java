package aula02;

import java.util.Scanner;

public class SomaDosNumerosImparesMenoresQuenUtilizandoWhile {

	private static Scanner leia;

	public static void main(String[] args) {
		leia = new Scanner(System.in);
		int n,a,b;
		System.out.print("Digite um numero: ");
		n = leia.nextInt();
		b = n;
		a = 0;
		while (n > 0) {
			n = n - 1; 
			if (n % 2 == 1) {
				a = a + n;
			} 
		}
		System.out.println("Soma dos numeros impares menores que " + b + ": " + a);
	}

}
