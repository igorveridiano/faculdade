package Teste;

public class MainCripto {

	public static void main(String[] args) {
		Criptografia teste =new Criptografia();
		System.out.println("Encryption Order = "+ new String(teste.encrypt));
		System.out.println("Decryption Order = "+ new String(teste.decrypt));
		String secret ="Ola mundo";
		secret=teste.encrypt(secret);
		System.out.println(secret);
		secret=teste.decrypt(secret);
		System.out.println(secret);

	}

}
