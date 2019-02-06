import java.util.Scanner;

public class fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int soma = 0, n = 0, c = 1, cont = 1;
		
		System.out.println("Insira o numero que vc quer da serie de fibonacci");
		n = input.nextInt();
		long fim, inicio =System.nanoTime();
		//System.out.println("O valor desejado eh: "+soma(n) );
	
		
		while (cont <= n) {
			soma = soma + c;
			c = soma - c;
			cont++;	
			

		}
		//System.out.println("O número que vc deseja eh:" + soma);
		fim =System.nanoTime();
		System.out.println(fim-inicio);
	}

}
