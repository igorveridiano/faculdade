package Turma01;

import java.util.Scanner;

public class exercicio01 {

	private static Scanner leia;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        double nota1, nota2, media;
        leia = new Scanner(System.in);
        System.out.print("Digite a primeira nota:");
        nota1 = leia.nextDouble();
        System.out.print("Digite a segunda nota:");
        nota2 = leia.nextDouble();
        media = ((nota1 * 4) + (nota2 * 6)) / 10;
        System.out.printf("\nMedia:%4.2f",media);
	}

}
