package primeirosExercicios;

import java.util.Scanner;

public class VerificadorDeQuantoPrecisaParaPassar {

	private static Scanner leia;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        double nota1, nota2, media = 60;
        leia = new Scanner(System.in);
        System.out.print("Digite a primeira nota:");
        nota1 = leia.nextDouble();
        nota2 = ((media) - (nota1 * 4))/6;
        System.out.printf("\nPrecisa tirar:%4.2f",nota2);
	}

}
