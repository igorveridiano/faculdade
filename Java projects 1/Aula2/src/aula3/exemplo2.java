package aula3;

import java.util.Scanner;

public class exemplo2 {

	private static Scanner leia;
	public static void main(String[] args) {
		 int n, i;
		 leia = new Scanner(System.in);
		 System.out.print("Informe um número inteiro: ");
		 n = leia.nextInt();
		 System.out.print("Numeros perfeitos menores que " + n + ": ");
		 for (i = 1; i < n; i++){
		 if (perfeito(i)){
		 System.out.print(i + " ");
		 }
		 }
		 System.out.print("\nFim do programa");

		}
		static boolean perfeito(int x) {
		 boolean teste;
		 int soma =0, j;
		 j = 1;
		 while (j <= x/2){
		 if (x % j == 0){
		 soma = soma + j;
		 }
		j = j + 1;
		 }
		 if (soma == x){
		 teste = true;
		 }else {
		 teste = false;
		 }
		 return teste;
		 }
		} 