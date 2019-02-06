package Banco;

import java.util.Scanner;

public class Main {

	private static Scanner leia;
	private static Conta conta;

	public static void main(String[] args) {
	    leia = new Scanner(System.in);
	    int x = 0;
		String Comando , Iniciar;
		String nomecorrentista [] = new String[10];
		int numeroconta[] = new int[10];
		double saldo[] = new double[10];
		double limite[] = new double[10];
		System.out.print("Deseja iniciar o programa: ");
		Iniciar = leia.nextLine();
		while (Iniciar == "Sim") {
			System.out.print("Deseja criar uma conta, depositar, sacar, transferir, ver o saldo ou sair: ");
			Comando = leia.nextLine();
			switch (Comando) {
			case "criar conta":
				System.out.print("Digite o nome do correntista: ");
				nomecorrentista [x] = leia.nextLine();
				System.out.print("Digite o numero da conta: ");
				numeroconta[x] = leia.nextInt();
				System.out.print("Digite o saldo inicial da conta: ");
				saldo [x] = leia.nextDouble();
				System.out.print("Digite o limite da conta: ");
				limite [x] = leia.nextDouble();
				setConta(new Conta(nomecorrentista[x], numeroconta[x], saldo[x], limite[x] ));
				x = x + 1;
				break;
			case "depositar":
				break;
			case "sacar":
				break;
			case "transferir":
				break;
			case "ver saldo":
				break;
			case "sair":
				break;
			default:
				break;
			}
			System.out.print("Deseja continuar: ");
			Iniciar = leia.nextLine();
		}
	}

	public static Conta getConta() {
		return conta;
	}

	public static void setConta(Conta conta) {
		Main.conta = conta;
	}
}
