package Banco;

import java.util.Scanner;

public class Cliente {
	private int Cpf;
	private String nome;
	private Poupanca poupanca;
	private Conta conta;
	private Scanner input = new Scanner(System.in);

	public Cliente(String nome, int Cpf) {
		this.nome = nome;
		this.Cpf = Cpf;
		this.poupanca = new Poupanca();
		int tipo_da_conta = 0;
		while (tipo_da_conta != 1 && tipo_da_conta != 2) {
			System.out.println("Insira 1 se vc quiser conta comum ou 2 se quiser Conta com cheque especial");
			tipo_da_conta = input.nextInt();
			switch (tipo_da_conta) {
			case 1:
				this.conta = new ContaComum();
				break;

			case 2:
				this.conta = new ContaEspecial();
				break;
			default:
				System.err.println("Insira a opção desejada");
				break;
			}
		}

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Poupanca getPoupanca() {
		return poupanca;
	}

	public void setPoupanca(Poupanca poupanca) {
		this.poupanca = poupanca;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public int getCpf() {
		return Cpf;
	}

	public void setCpf(int cpf) {
		Cpf = cpf;
	}

}
