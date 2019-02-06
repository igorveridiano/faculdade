package Prova;

import java.util.Scanner;

import ListaDuplamenteEncadeadaComTesteDeTempoDoProjeto.ListaDuplamenteEncadeada;
;

public class main {
	static Escola escola = new Escola();
	static boolean flag = true;

	public static void main(String []args) {
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
					System.out.println("Digite o nome da turma: ");
					String nome = getScanner().nextLine();
					Turma turma = new Turma(codigo, nome);
					escola.getLista_turma().adicionar(turma);
				} catch (NumberFormatException e) {
					System.err.println("Colocar um numero aceitavel");
				}
				break;
			case 2:
				System.out.println("Digite o nome do aluno: ");
				String nome = getScanner().nextLine();
				System.out.println("Digite o matricula do aluno: ");
				try {
					int matricula = getScanner().nextInt();
					Aluno aluno = new Aluno(nome, matricula);
					escola.getLista_aluno().adicionar(aluno);
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
					for (Turma turma : escola.getLista_turma()) {
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
						System.out.println("Insira o matricula do aluno");
						int numero = getScanner().nextInt();
						Aluno aluno1 = null;
						for (Aluno aluno : escola.getLista_aluno()) {
							if (aluno.getMatricula() == numero) {
								aluno1 = aluno;
								fla1 = false;
								break;
							}
						}
						if (fla1) {
							System.out.println("Esse código de aluno nao existe");
						} else {
							System.out.println("Insira a nota 1 e a nota 2 do aluno");
							turma1.Efetuar_matricula(aluno1, getScanner().nextInt(), getScanner().nextInt());
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
					for (Turma turma : escola.getLista_turma()) {
						if (codigo == turma.getCod()) {
							turma1 = turma;
							flag = false;
							break;
						}
					}
					if (flag) {
						System.out.println("Esse c�digo de turma n�o existe");
					} else {
						System.out.printf("Alunos aprovados na turma %s \n", turma1.getNome());
						System.out.printf("%-20s %-35s %-10s %-10s %-10s \n", "Matricula", "Nome", "Nota 1", "Nota 2",
								"M�dia");
						for (Aluno aluno : turma1.getLista_pessoa()) {
							for (Nota nota : aluno.getLista_nota()) {
								if (nota.getTurma().equals(turma1)) {
									if (nota.getMedia() >= 6) {
										System.out.printf("%-20s %-35s %-10s %-10s %-10s \n", aluno.getMatricula(),
												aluno.getNome(), nota.getNota1(), nota.getNota2(), nota.getMedia());
									}
								}
							}

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
					Turma turma1 = null;
					for (Turma turma : escola.getLista_turma()) {
						if (codigo == turma.getCod()) {
							turma1 = turma;
							flag = false;
							break;
						}
					}
					if (flag) {
						System.out.println("Esse c�digo de turma n�o existe");
					} else {
						System.out.printf("Alunos reprovados na turma %s \n", turma1.getNome());
						System.out.printf("%-20s %-35s %-10s %-10s %-10s \n", "Matricula", "Nome", "Nota 1", "Nota 2",
								"M�dia");
						for (Aluno aluno : turma1.getLista_pessoa()) {
							for (Nota nota : aluno.getLista_nota()) {
								if (nota.getTurma().equals(turma1)) {
									if (nota.getMedia() < 6) {
										System.out.printf("%-20s %-35s %-10s %-10s %-10s \n", aluno.getMatricula(),
												aluno.getNome(), nota.getNota1(), nota.getNota2(), nota.getMedia());
									}
								}
							}

						}
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
					Turma turma1 = null;
					for (Turma turma : escola.getLista_turma()) {
						if (codigo == turma.getCod()) {
							turma1 = turma;
							flag = false;
							break;
						}
					}
					if (flag) {
						System.out.println("Esse c�digo de turma n�o existe");
					} else {
						System.out.printf("Alunos destaques na turma %s \n", turma1.getNome());
						System.out.printf("%-20s %-35s %-10s %-10s %-10s \n", "Matricula", "Nome", "Nota 1", "Nota 2",
								"M�dia");
						ListaDuplamenteEncadeada<Aluno> lista_aluno = new ListaDuplamenteEncadeada<>();
						double maior = 0;
						for (Aluno aluno : turma1.getLista_pessoa()) {
							for (Nota nota : aluno.getLista_nota()) {
								if (nota.getTurma().equals(turma1)) {
									if (nota.getMedia() > maior) {
										maior = nota.getMedia();

									}
								}
							}

						}
						for (Aluno aluno : turma1.getLista_pessoa()) {
							for (Nota nota : aluno.getLista_nota()) {
								if (nota.getTurma().equals(turma1)) {
									if (nota.getMedia() == maior) {
										lista_aluno.adicionar(aluno);

									}
								}
							}

						}
						for (Aluno aluno : lista_aluno) {
							for (Nota nota : aluno.getLista_nota()) {
								if (nota.getTurma().equals(turma1)) {

									System.out.printf("%-20s %-35s %-10s %-10s %-10s \n", aluno.getMatricula(),
											aluno.getNome(), nota.getNota1(), nota.getNota2(), nota.getMedia());

								}
							}
						}

					}
				} catch (NumberFormatException e) {
					System.err.println("Insira um numero");

				}

				break;

			case 7:
				try{
				boolean fla1 = true;
				System.out.println("Insira o matricula do aluno");
				int numero = getScanner().nextInt();
				Aluno aluno1 = null;
				for (Aluno aluno : escola.getLista_aluno()) {
					if (aluno.getMatricula() == numero) {
						aluno1 = aluno;
						fla1 = false;
						break;
					}
				}
				if (fla1) {
					System.out.println("Esse c�digo de aluno nao existe");
				} else {
					aluno1.getLista_nota().limpar();
					for (Turma turma : escola.getLista_turma()) {
						if(turma.getLista_pessoa().contem(aluno1)){
							turma.getLista_pessoa().remover(aluno1);
						}
					}
				}
				}
				catch (Exception e) {
				System.err.println("Insira um numero");
				}
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
		System.out.println("2-Cadastrar aluno");
		System.out.println("3-Matricular alunos na turma");
		System.out.println("4-Listar alunos aprovados na turma");
		System.out.println("5-Listar alunos reprovados na turma");
		System.out.println("6-Listar alunos com maior nota");
		System.out.println("7-Trancar matricula de aluno");

	}

}
