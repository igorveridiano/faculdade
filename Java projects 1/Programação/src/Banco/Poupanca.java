package Banco;

public class Poupanca extends Conta {

	public Poupanca() {
		this.setNumero(random.nextInt(999)+1) ;
		this.setSaldo(0);
	}
	
	
}
