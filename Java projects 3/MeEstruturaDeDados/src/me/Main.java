package me;

import java.util.Scanner;

public class Main {

	private static Scanner leia;
	private static Scanner input;

	public static void main(String[] args) {
		input = new Scanner(System.in);
		int verificador1, codigo, numeroMaximoAlunos, rg;
		String verificador2 = "continuar", comparador = "continuar", nome;
		Cursinho cursinho = new Cursinho();
		leia = new Scanner(System.in);
		do {
			System.out.println("1-Cadastrar Turma");
			System.out.println("2-Cadastrar Cliente");
			System.out.println("3-Efetuar Reserva");
			System.out.println("4-Cancelar Reserva");
			System.out.println("5-Cancelar Turma");
			System.out.println("6-Listar Aluno na Turma");
			System.out.println("7-Listar Turmas");
			System.out.println("8-Sair");
			System.out.println("Escolha a opção desejada: ");
			verificador1 = leia.nextInt();
			switch (verificador1){
			case 1:
				try {
					System.out.println("Digite o codigo da turma: ");
					codigo = leia.nextInt();
					System.out.println("Digite o numero maximo de alunos: ");
					numeroMaximoAlunos = leia.nextInt();
					Turma turma = new Turma(codigo, numeroMaximoAlunos);
					cursinho.CadastrarTurma(turma);
				} catch (NumberFormatException e){
					System.err.println("Colocar um numero aceitavel");
				}
				break;
			case 2:
				try {
					System.out.println("Digite o nome do cliente: ");
					nome = input.nextLine();
					System.out.println("Digite o Rg do cliente (apenas numeros): ");
					rg = leia.nextInt();
					Cliente cliente = new Cliente(nome, rg);
					cursinho.CadastrarCliente(cliente);
				} catch (NumberFormatException e){
					System.err.println("Colocar um numero aceitavel");
				}
				break;
			case 3:
				try {
					System.out.println("Digite o codigo da turma: ");
					codigo = leia.nextInt();
					System.out.println("Digite o Rg do cliente: ");
					rg = leia.nextInt();
					for (Turma turma : cursinho.getListaDeTurmas()) {
						if (turma.getCodigo() == codigo){
							for (Cliente cliente : cursinho.getListaDeClientes()) {
								if (cliente.getRg() == rg){
									turma.EfetuarReserva(cliente);
								}
							}
						}
					}
				} catch (NumberFormatException e){
					System.err.println("Colocar um numero aceitavel");
				}
				break;
			case 4:
				try {
					System.out.println("Digite o codigo da turma: ");
					codigo = leia.nextInt();
					System.out.println("Digite o Rg do cliente: ");
					rg = leia.nextInt();
					for (Turma turma : cursinho.getListaDeTurmas()) {
						if (turma.getCodigo() == codigo){
							for (Cliente cliente : cursinho.getListaDeClientes()) {
								if (cliente.getRg() == rg){
									turma.CancelarReserva(cliente);
								}
							}
						}
					}
				} catch (NumberFormatException e){
					System.err.println("Colocar um numero aceitavel");
				}
				break;
			case 5:
				System.out.println("Insira o codigo da turma");
				try {
					int codigo1 = input.nextInt();
					for (Turma turma : cursinho.getListaDeTurmas()) {
						if (codigo1 == turma.getCodigo()) {
							
							cursinho.getListaDeTurmas().remover(turma);
							break;
						}
					}
				} catch (NumberFormatException e) {
					System.err.println("Insira um numero");

				}
				break;
			case 6:
				System.out.println("Insira o codigo da turma");
				try {
					int codigo1 = input.nextInt();
					for (Turma turma : cursinho.getListaDeTurmas()) {
						if (codigo1 == turma.getCodigo()) {
							
							turma.Listar_alunos();
							break;
						}
					}
				} catch (NumberFormatException e) {
					System.err.println("Insira um numero");

				}
				break;
			case 7:
				cursinho.listar_turmas();
				break;
			case 8:
				System.out.println("Saindo");
				verificador2 = "sair";
				break;
			default:
				break;	
			}
		} while(verificador2.equals(comparador));
		
	}

}
