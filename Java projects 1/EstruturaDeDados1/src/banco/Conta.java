package banco;

import java.util.Scanner;

public abstract class Conta {
	
	private int numeroAgencia;
	private int numeroConta;
	private String nomeCliente;
	private int senhaCliente;
	private int cpf;
	private double saldo;
	private Scanner leia;
	
	public Conta (int numeroAgencia, int numeroConta, String nomeCliente, int senhaCliente, int cpf, double saldo){
		this.setNumeroAgencia(numeroAgencia);
		this.setNumeroConta(numeroConta);
		this.setNomeCliente(nomeCliente);
		this.setSenhaCliente(senhaCliente);
		this.setCpf(cpf);
		this.setSaldo(saldo);
	}
	
	public void Sacar(double saldo, double saque){
		leia = new Scanner(System.in);
		System.out.print("Valor do saque: ");
		saque = leia.nextDouble();
		if (this.getSaldo() < saque) {
			System.out.print("Seu saldo é insuficiente");
		} else {
			saldo = this.getSaldo() - saque;
			this.setSaldo(saldo);
		}
	}
	
	public void Depositar (double saldo, double deposito) {
		leia = new Scanner(System.in);
		System.out.print("Valor do deposito: ");
		deposito = leia.nextDouble();
		saldo = this.getSaldo() + deposito;
		this.setSaldo(saldo);
	}

	public int getNumeroAgencia() {
		return numeroAgencia;
	}

	public void setNumeroAgencia(int numeroAgencia) {
		this.numeroAgencia = numeroAgencia;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public int getSenhaCliente() {
		return senhaCliente;
	}

	public void setSenhaCliente(int senhaCliente) {
		this.senhaCliente = senhaCliente;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

}
