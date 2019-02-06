package ME;

import java.util.Scanner;

public class main {
	static Cursinho cursinho = new Cursinho();
	static boolean flag = true;

	

	public static void main(String[] args) {
		int valor;
		while (flag) {
			Menu();
			try {
				valor = getScanner().nextInt();
			} catch (NumberFormatException e) {
				System.err.println("Insira um numero");
				continue;
			}
			switch (valor) {
			case 1:
				try {

					System.out.println("Digite o codigo da turma: ");
					int codigo = getScanner().nextInt();
					System.out.println("Digite o numero maximo de alunos: ");
					int numeroMaximoAlunos = getScanner().nextInt();
					Turma turma = new Turma(codigo, numeroMaximoAlunos);
					cursinho.getLista_turma().adicionar(turma);
				} catch (NumberFormatException e) {
					System.err.println("Colocar um numero aceitavel");
				}
				break;
			case 2:
				System.out.println("Digite o nome do cliente: ");
				String nome = getScanner().nextLine();
				System.out.println("Digite o Rg do cliente (apenas numeros): ");
				try {
					int rg = getScanner().nextInt();
					Cliente cliente = new Cliente(nome, rg);
					cursinho.getLista_cliente().adicionar(cliente);
				} catch (NumberFormatException e) {
					System.err.println("Colocar um numero aceitavel");
				}
				break;

			case 3:
				System.out.println("Insira o codigo da turma");
				try {
					int codigo = getScanner().nextInt();
					boolean flag = true;
					Turma turma1 = null;
					for (Turma turma : cursinho.getLista_turma()) {
						if (codigo == turma.getCod()) {
							turma1 = turma;
							flag = false;
							break;
						}
					}
					if (flag) {
						System.out.println("Esse código de turma não existe");
					} else {
						boolean fla1 = true;
						System.out.println("Insira o rg do aluno");
						int numero = getScanner().nextInt();
						Cliente cliente1 = null;
						for (Cliente cliente : cursinho.getLista_cliente()) {
							if (cliente.getRg() == numero) {
								cliente1 = cliente;
								fla1 = false;
								break;
							}
						}
						if (fla1) {
							System.out.println("Esse código de aluno nao existe");
						} else {
							turma1.Efetuar_reserva(cliente1);
						}
					}
				} catch (NumberFormatException e) {
					System.err.println("Insira um numero");

				}
				break;
			case 4:
				System.out.println("Insira o codigo da turma");
				try {
					int codigo = getScanner().nextInt();
					boolean flag = true;
					Turma turma1 = null;
					for (Turma turma : cursinho.getLista_turma()) {
						if (codigo == turma.getCod()) {
							turma1 = turma;
							flag = false;
							break;
						}
					}
					if (flag) {
						System.out.println("Esse código de turma não existe");
					} else {
						boolean fla1 = true;
						System.out.println("Insira o rg do aluno");
						int numero = getScanner().nextInt();
						Cliente cliente1 = null;
						for (Cliente cliente : turma1.getLista_pessoa()) {
							if (cliente.getRg() == numero) {
								cliente1 = cliente;
								fla1 = false;
								break;
							}
						}
						if (fla1) {
							System.out.println("Esse código de turma não existe");
						} else {
							turma1.Cancelar_reserva(cliente1);
						}
					}
				} catch (NumberFormatException e) {
					System.err.println("Insira um numero");

				}
				break;

			case 5:

				System.out.println("Insira o codigo da turma");
				try {
					int codigo = getScanner().nextInt();
					boolean flag = true;

					for (Turma turma : cursinho.getLista_turma()) {
						if (codigo == turma.getCod()) {
							flag = false;
							cursinho.getLista_turma().remover(turma);
							break;
						}
					}
					if (flag) {
						System.out.println("Esse código de turma não existe");
					}
				} catch (NumberFormatException e) {
					System.err.println("Insira um numero");

				}
				break;
			case 6:
				System.out.println("Insira o codigo da turma");
				try {
					int codigo = getScanner().nextInt();
					boolean flag = true;

					for (Turma turma : cursinho.getLista_turma()) {
						if (codigo == turma.getCod()) {
							flag = false;
							turma.Listar_alunos();
							break;
						}
					}
					if (flag) {
						System.out.println("Esse código de turma não existe");
					}
				} catch (NumberFormatException e) {
					System.err.println("Insira um numero");

				}
				break;
			case 7:
				cursinho.listar_turmas();
				break;
			case 8:
				System.out.println("Obrigado por utilizar o problema");
				flag = false;
				break;

			default:
				break;
			}

		}

	}

	private static Scanner getScanner() {

		return new Scanner(System.in);
	}

	public static void Menu() {
		System.out.println("Insira a opção desejada");
		System.out.println("1-Cadastrar turmas");
		System.out.println("2-Cadastrar cliente");
		System.out.println("3-Efetuar reserva");
		System.out.println("4-Cancelar reserva");
		System.out.println("5-Cancelar turma");
		System.out.println("6-Listar alunos na turma");
		System.out.println("7-Listar turmas");
		System.out.println("8-Encerra aplicação");

	}

}
