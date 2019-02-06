package Turma01;

import java.util.Scanner;

public class exemplo01 {

	 private static Scanner leia;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
