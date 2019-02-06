package aula02;

import java.util.Scanner;

public class NumerosQueDividemN {

	private static Scanner leia;

	public static void main(String[] args) {
	int n,a;
	leia = new Scanner(System.in);
	System.out.print("Digite um numero: ");
	n = leia.nextInt();
	for (a = 1;n >= a;a = a + 1) {
		if (n % a == 0) {
			System.out.println(a);
		}
	}
  }
}
