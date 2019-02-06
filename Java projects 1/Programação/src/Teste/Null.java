package Teste;

public class Null {

	private static String string;

	public static void main(String[] args) {
		string = null;
		if(string.equals(null)){
			System.out.println("Deu certo");
		}
	}

}
