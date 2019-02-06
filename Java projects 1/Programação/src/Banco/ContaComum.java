package Banco;

public class ContaComum extends Conta {

	public ContaComum() {
		this.setNumero(random.nextInt(999)+1) ;
		this.setSaldo(0);
		
	}

	

}
