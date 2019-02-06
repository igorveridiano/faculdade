package primeirosExercicios;

import java.util.Scanner;

public class NomeSoma {

	 private static Scanner leia;

	public static void main(String[] args) {
		int a , b , c;
		String nome;
		leia = new Scanner(System.in);
		System.out.print("Digite um nome:");
		nome = leia.next();
		System.out.print("Digite um numero:");
		a = leia.nextInt();
		System.out.print("Digite um numero:");
		b = leia.nextInt();
		System.out.print("Digite um numero:");
		c = leia.nextInt();
		System.out.println("Nome:" + nome);
		System.out.println("Soma:" + (a + b + c));
	}

}
