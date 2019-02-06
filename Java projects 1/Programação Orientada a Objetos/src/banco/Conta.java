package banco;

public class Conta {
	
	public String nomecorrentista;
	public int numeroconta;
	public double saldo;
	public double limite;
	
	public Conta (String nomecorrentista, int numeroconta, double saldo, double limite) {
		this.nomecorrentista = nomecorrentista;
		this.numeroconta = numeroconta;
		this.saldo = saldo;
		this.limite = limite;
	}
	
	public void Sacar (double saldo, double saque) {
		if (this.saldo < saque) {
			System.out.print("Seu saldo é insuficiente");
		} else {
			this.saldo = saldo - saque;	
		}
	}
	
	public void Depositar (double saldo, double deposito) {
		this.saldo = saldo + deposito;
	}
	
	public void Saldo (double saldo) {
		System.out.print("Saldo: R$ " + this.saldo);
	}
	
	public void Transferir (double saldo, double transferencia, int contasaida, int contaentrada, int numeroconta) {
		if (contasaida == numeroconta && contasaida >= this.saldo){
			this.saldo = saldo - transferencia;
		}
		if (contaentrada == numeroconta){
			this.saldo = saldo + transferencia;
		}
		if (contasaida < this.saldo){
			System.out.print("Saldo insuficiente");
		}
	}

	public String getNomecorrentista() {
		return nomecorrentista;
	}

	public void setNomecorrentista(String nomecorrentista) {
		this.nomecorrentista = nomecorrentista;
	}

	public int getNumeroconta() {
		return numeroconta;
	}

	public void setNumeroconta(int numeroconta) {
		this.numeroconta = numeroconta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}

	public static void main(String[] args) {
	}

}
