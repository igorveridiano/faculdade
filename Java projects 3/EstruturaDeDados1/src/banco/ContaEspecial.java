package banco;

import java.util.Scanner;

public class ContaEspecial extends Conta {
	
	private double limiteChequeEspecial;
	private Scanner leia;

	public ContaEspecial(int numeroAgencia, int numeroConta, String nomeCliente, int senhaCliente, int cpf,
			double saldo, double limiteChequeEspecial) {
		super(numeroAgencia, numeroConta, nomeCliente, senhaCliente, cpf, saldo);
		this.setLimiteChequeEspecial(limiteChequeEspecial);
	}
	
	public void Sacar(double saldo, double saque){
		leia = new Scanner(System.in);
		System.out.print("Valor do saque: ");
		saque = leia.nextDouble();
		if ((this.getSaldo() + this.getLimiteChequeEspecial()) < saque) {
			System.out.print("Seu limite é insuficiente");
		} else {
			if (this.getSaldo() > saque) {
				saldo = this.getSaldo() - saque;
				this.setSaldo(saldo);
			} else {
				saldo = this.getSaldo() - saque;
				this.setSaldo(saldo);
				this.setLimiteChequeEspecial(this.getLimiteChequeEspecial() - saldo);
			}
		}
	}
	
	public void Depositar (double saldo, double deposito) {
		leia = new Scanner(System.in);
		System.out.print("Valor do deposito: ");
		deposito = leia.nextDouble();
		saldo = this.getSaldo() + deposito;
		this.setSaldo(saldo);
	}

	public double getLimiteChequeEspecial() {
		return limiteChequeEspecial;
	}

	public void setLimiteChequeEspecial(double limiteChequeEspecial) {
		this.limiteChequeEspecial = limiteChequeEspecial;
	}

}
