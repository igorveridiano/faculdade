package excessaoDeErros;

import java.util.Scanner;

public class ConvertendoStringParaInt {

	private static Scanner leia;
	private static int numero2;

	public static void main(String[] args) {
		leia = new Scanner(System.in);
		String numero1;
		System.out.print("Digite um numero: ");
		numero1 = leia.nextLine();
		try{
			setNumero2(Integer.parseInt(numero1));
		}
		catch (NumberFormatException exc){
			System.out.println("Formato invalido");
			setNumero2(0);
		}
		finally {
			System.out.println(numero1);
		}
	}

	public static int getNumero2() {
		return numero2;
	}

	public static void setNumero2(int numero2) {
		ConvertendoStringParaInt.numero2 = numero2;
	}

}
