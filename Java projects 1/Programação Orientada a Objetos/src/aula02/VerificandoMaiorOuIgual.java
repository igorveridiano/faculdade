package aula02;

import java.util.Scanner;

public class VerificandoMaiorOuIgual {

	private static Scanner leia;

	public static void main(String[] args) {
	leia = new Scanner(System.in);
	int a,b;
	System.out.print("Digite um numero: ");
	a = leia.nextInt();
	System.out.print("Digite um numero: ");
	b = leia.nextInt();
	if (a > b) {
		System.out.println("\nO maior numero é: " + a);
	} else {
	    if (b > a) {
		    System.out.println("\nO maior numero é: " + b);
	    } else { 
		    System.out.println("\nValores iguais");
	      }
	  }
	}
}
