package primeirosExercicios;

import java.util.Scanner;

public class NumeroPerfeito {

	private static Scanner leia;

	public static void main(String[] args) {
		int n , a , b = 0 ;
		leia = new Scanner(System.in);
		System.out.print("Digite um numeoro: ");
		n = leia.nextInt();
		for (a = 1; n > a ; a = a + 1) {
			if (n % a == 0){
				b = b + a;
			}
		}
		if (b == n) {
			System.out.print("Ele � perfeito");
		} else {
			System.out.print("Ele n�o � perfeito");
		}
	}

}
