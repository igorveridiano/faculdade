import java.util.Scanner;

public class fibonacci_recursao {
	public static void main(String[] args) {
		int n = 0;
		Scanner input = new Scanner(System.in);

		System.out.println("Insira o numero que vc quer da serie de fibonacci");
		n = input.nextInt();
		long fim, inicio =System.nanoTime();
		//System.out.println("O valor desejado eh: "+soma(n) );
		soma(n);
		fim =System.nanoTime();
		System.out.println(fim-inicio);
		
	}
	public static int soma(int numero){
		
		int valor=0;
		if(numero<=1){
			
			return 1;
		}
		if(numero==2){
			valor=soma(numero-1);
			
		}
		else{
			valor= soma(numero-1)+soma(numero-2);
			
		}
	
		return valor;
	}
	
}