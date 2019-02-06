package provaEstruturaDeDados1;

import java.util.Scanner;

import listaSimplismenteEncadeada.ListaSimplesmenteEncadeada;


public class Main {

	private static Scanner leia;
	private static Scanner input;

	public static void main(String[] args) {
		leia = new Scanner(System.in);
		input = new Scanner(System.in);
		String nome;
		int verificador1, verificador2 = 1, matricula, codigo;
		float nota1, nota2;
	    ListaSimplesmenteEncadeada<Aluno> ListaAlunos = new ListaSimplesmenteEncadeada<>(); 
		ListaSimplesmenteEncadeada<Turma> ListaTurmas = new ListaSimplesmenteEncadeada<>(); 
		do {
			System.out.println("1-Cadastrar Turma");
			System.out.println("2-Cadastrar Alunos");
			System.out.println("3-Realizar Matricula");
			System.out.println("4-Lista Alunos Aprovados");
			System.out.println("5-Lista Alunos Reprovados");
			System.out.println("6-Aluno(s) Com a Maior Nota");
			System.out.println("7-Trancar Disciplina: ");
			System.out.print("8-Sair: ");
			verificador1 = leia.nextInt();
			switch (verificador1){
			case 1:
				System.out.print("Turma: ");
				nome = input.nextLine();
				System.out.print("Codigo: ");
				codigo = leia.nextInt();
				Turma turma = new Turma(nome, codigo);
				ListaTurmas.adicionar(turma);
				break;
			case 2:
					System.out.print("Matricula: ");
					matricula = leia.nextInt();
					System.out.print("Nome: ");
					nome = input.nextLine();
					Aluno aluno = new Aluno(matricula,nome);
					ListaAlunos.adicionar(aluno);
				break;
			case 3:
				System.out.print("Codigo da Turma: ");
				codigo = leia.nextInt();
				System.out.print("Matricula do Aluno: ");
				matricula = leia.nextInt();
				System.out.print("Nota Priemira Unidade: ");
				nota1 = leia.nextFloat();
				System.out.print("Nota Segunda Unidade: ");
				nota2 = leia.nextFloat();
				for (Aluno aluno1 : ListaAlunos) {
					if (aluno1.getMatricula() == matricula){
						aluno1.setNota1(nota1);
						aluno1.setNota2(nota2);
					}
				}
				for (Turma turma1 : ListaTurmas) {
					if(turma1.getCodigo() == codigo){
						for (Aluno aluno1 : ListaAlunos) {
							if(aluno1.getMatricula() == matricula){
								turma1.cadastrarAlunos(aluno1);
								aluno1.ListaTurmas.adicionar(turma1);
							}
						}
					}
				}
				break;
			case 4:
				System.out.print("Codigo da Turma: ");
				codigo = leia.nextInt();
				for (Turma turma1 : ListaTurmas) {
					if (turma1.getCodigo() == codigo){
						turma1.ListarAlunosAprovados();
					}
				}
				break;
			case 5:
				System.out.print("Codigo da Turma: ");
				codigo = leia.nextInt();
				for (Turma turma1 : ListaTurmas) {
					if (turma1.getCodigo() == codigo){
						turma1.ListarAlunosReprovados();
					}
				}
				break;
			case 6:
				System.out.print("Codigo da Turma: ");
				codigo = leia.nextInt();
				for (Turma turma1 : ListaTurmas) {
					if (turma1.getCodigo() == codigo){
						turma1.alunosMaiorNota();
						turma1.ListarAlunosDestaques();
					}
				}
				break;
			case 7:
				System.out.print("Matricula do Aluno: ");
				matricula = leia.nextInt();
				boolean teste;
				for (Aluno aluno1 : ListaAlunos) {
					if (aluno1.getMatricula() == matricula){
						teste = aluno1.trancarTurmas(aluno1);
						if (teste == true){
							System.out.println("Disciplina Trancada com Sucesso");
						} else {
							System.out.println("Falha ao Trancar a Disciplina");
						}
					}
				}
				break;
			case 8:
				System.out.println("Saindo");
				verificador2 = 0;
				break;
			}		
		} while (verificador2 != 0);
		
	}

}
