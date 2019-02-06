package verificarDisciplina;

import java.util.Scanner;

import listaVetor.Vetor;

public class Main {

	private static Scanner leia;
	private static Scanner input;

	public static void main(String[] args) {
		leia = new Scanner(System.in);
		input = new Scanner(System.in);
		String disciplina, nome;
		int verificador1, verificador2 = 1, verificador3 = 1, matricula;
		float nota1, nota2;
		Vetor<Aluno> ListaAlunos = new Vetor<>(); 
		System.out.print("Disciplina: ");
		disciplina = leia.nextLine();
		Disciplina disciplinas = new Disciplina(disciplina);
		do {
			System.out.println("1-Cadastrar Alunos");
			System.out.println("2-Lista Alunos Aprovados");
			System.out.println("3-Lista Alunos Reprovados");
			System.out.println("4-Aluno(s) Com a Maior Nota");
			System.out.println("5-Trancar Disciplina: ");
			System.out.print("6-Sair: ");
			verificador1 = leia.nextInt();
			switch (verificador1){
			case 1:
				do {
					System.out.print("Matricula: ");
					matricula = leia.nextInt();
					if(matricula < 0){
						break;
					}
					System.out.print("Nome: ");
					nome = input.nextLine();
					System.out.print("Primeira Nota: ");
					nota1 = leia.nextFloat();
					System.out.print("Segunda nota: ");
					nota2 = leia.nextFloat();
					Aluno aluno = new Aluno(matricula, nome, nota1, nota2);
					ListaAlunos.adicionar(aluno);
					disciplinas.cadastrarAlunos(aluno);
				} while(verificador3 != 0);
				break;
			case 2:
				disciplinas.ListarAlunosAprovados();
				break;
			case 3:
				disciplinas.ListarAlunosReprovados();
				break;
			case 4:
				disciplinas.alunosMaiorNota();
				disciplinas.ListarAlunosMaiorNota();
				break;
			case 5:
				System.out.print("Matricula: ");
				matricula = leia.nextInt();
				System.out.print("Nome: ");
				nome = input.nextLine();
				boolean verificador4 = false;
				for (Aluno aluno : ListaAlunos) {
					if (aluno.getMatricula() == matricula && aluno.getNome().equals(nome)){
						if(disciplinas.trancarDisciplina(aluno)){
							verificador4 = true;
							break;
						}
					} else {
						System.out.println("Aluno não encontrado");
					}
				}
				if(verificador4){
					System.out.println("Disciplina trancada com sucesso");
				} else {
					System.out.println("Falha ao trancar a disciplina");
				}
				break;
			case 6:
				System.out.println("Saindo");
				verificador2 = 0;
				break;
			}		
		} while (verificador2 != 0);
		
	}

}
