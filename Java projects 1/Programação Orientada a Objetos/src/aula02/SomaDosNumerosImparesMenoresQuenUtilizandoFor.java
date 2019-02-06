package aula02;

import java.util.Scanner;

public class SomaDosNumerosImparesMenoresQuenUtilizandoFor {

	private static Scanner leia;

	public static void main(String[] args) {
		leia = new Scanner(System.in);
		int n,b,a = 0;
		System.out.print("Digite um numero: ");
		n = leia.nextInt();
		b = n;
		for (; n > 0; n = n - 1) {
			if (n % 2 == 1) {
				System.out.println(n);
				a = a + n;
			} 
		}
		System.out.println("Soma dos numeros impares menores que " + b + ": " + a);
	}

}

