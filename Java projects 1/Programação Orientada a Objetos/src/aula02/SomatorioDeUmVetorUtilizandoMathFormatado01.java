package aula02;

import java.util.Scanner;

public class SomatorioDeUmVetorUtilizandoMathFormatado01 {

	private static Scanner leia;

	public static void main(String[] args) {
		int n, d = 1,i;
		double x,x1,h = 0;
		double[] vet = new double[100000];
		leia = new Scanner(System.in);
		System.out.print("digite um numero para n: ");
		n = leia.nextInt();
		System.out.print("digite um numero para x: ");
		x = leia.nextDouble();
		for (i = 0; i < n; i++) {
			x1 = Math.pow(x, 2);
			h = h + x1/d;
			vet[i] = h;
			d = d + 3;
			h = 0;
		}
		d = 1;
		for (i = 0; i < n; i++) {
			x1 = Math.pow(x, 2);
			h = h + (x1/d);
			d = d + 3;
		}
		System.out.print("Termos do somatorio: ");
		for (i = 0; i < n; i++) {
			System.out.printf("%4.3f ", vet[i]);
			if (i < n-1) {
				System.out.print("+ ");
			}
		}
		System.out.print("= ");
		System.out.printf("%4.3f", h);
	}

}
