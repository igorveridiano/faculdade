package Turma01;

import java.util.Scanner;

public class exercicio18 {

	private static Scanner leia;

	public static void main(String[] args) {
		int n , nf , p , pf , s , d , df ;
		leia = new Scanner(System.in);
		do {
		System.out.print("Digite um numero: ");
		n = leia.nextInt();
		System.out.print("Digite um numero: ");
		p = leia.nextInt();
		} while ( n <= p);
		d = n - p;
		nf = n;
		pf = p;
		df = d;
		for (int a = 1; nf > a ; a = a + 1){
			n = n * a;
		}
		for (int a = 1; pf > a ; a = a + 1){
			p = p * a;
		}
		for (int a = 1; df > a ; a = a + 1){
			d = d * a;
		}
		s = n / ((d) * p);
		System.out.println("S é: " + s);
	}

}
