package ALUNOS_PROFESSORES.copy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	static ArrayList<Pessoa> Lista_Pessoa = new ArrayList<>();
	Pessoa pessoa;
	static int var = 0;
	static Scanner input = new Scanner(System.in);

	public static <T> void main(String[] args) {
		while (var < 100) {
			
			Menu();
			//input= new Scanner(System.in);
			var = input.nextInt();
			
			switch (var) {
			case 1:
				System.out.println("Insira a matrícula,o nome e a quantidade de créditos");
				try {
					Aluno aluno = new Aluno(getScanner().nextInt(), getScanner().nextLine(), getScanner().nextInt());
					Lista_Pessoa.add(aluno);
				} catch (Exception e) {
					System.err.println("Alguma informação foi dada da maneira errada");
					
				}

				break;
			case 2:
				System.out.println("Insira a matrícula,o nome , a quantidade de créditos e o valor da hora aula");
				try {
					Professor professor = new Professor(input.nextInt(), input.next(), input.nextInt(),
							input.nextFloat());
					Lista_Pessoa.add(professor);
				} catch (Exception e) {
					System.err.println("Alguma informação foi dada da maneira errada");

				}
				break;
			case 3:
				System.out.printf("%-20s %-35s %-10s %-10s\n", "Matricula", "Nome", "Creditos", "Hora/aula");
				Collections.sort(Lista_Pessoa);
				for (Pessoa pessoa : Lista_Pessoa) {
					if (pessoa instanceof Aluno) {
						Aluno aluno = (Aluno) pessoa;
						System.out.println(aluno.toString());

					} else {
						Professor professor = (Professor) pessoa;
						System.out.println(professor.toString());
					}
				}

				break;

			default:
				break;
			}

		}
	}

	public static void Menu() {
		System.out.println("MENU");
		System.out.println("1 - Criar Aluno");
		System.out.println("2 - Criar Professor");
		System.out.println("3 - Listar Pessoas");

	}
	public static Scanner getScanner(){
		return new Scanner(System.in);
	}

}
