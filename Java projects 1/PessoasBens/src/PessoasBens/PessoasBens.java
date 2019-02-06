package PessoasBens;

import java.util.Scanner;

public class PessoasBens {
	public static void main(String[] args) {
		TreeABB<Integer, Pessoa> Pessoas = new TreeABB<>();
		// TreeABB<Integer, Bens> bens = new TreeABB<>();

		boolean controle = true;
		int opcao = 10;

		while (controle) {
			System.out.println("==========MENU===============");
			System.out.println("1 -Incluir Pessoa ");
			System.out.println("2 - Excluir Pessoa");
			System.out.println("3 - Consultar Pessoa");
			System.out.println("4 - Listar Pessoas");
			System.out.println("5 - Incluir Bens");
			System.out.println("6 - Excluir Bens");
			System.out.println("0 - Sair do Programa");
			System.out.print("Informe a opção: ");
			opcao = obter().nextInt();

			switch (opcao) {
			case 1: {
				IncluirPessoa(Pessoas);

				break;

			}
			case 2: {
				ExcluirPessoa(Pessoas);
				break;
			}
			case 3: {
				ConsultarPessoa(Pessoas);
				break;
			}
			case 4: {
				ListarPessoas(Pessoas);
				break;
			}
			case 5: {
				IncluirBens(Pessoas);
				break;
			}
			case 6 : {
				ExcluirBens (Pessoas);
				break;
			}
			case 0: {
				controle = false;
				break;

			}
			default: {
				System.out.println("Opção invalida");
				break;

			}
			}
		}
	}

	public static Scanner obter() {
		return new Scanner(System.in);
	}

	public static void IncluirPessoa(TreeABB<Integer, Pessoa> listaPessoa) {
		System.out.println("\n--Cadastrar Pessoas--");
		System.out.print("Informe o ID da Pessoa: ");
		int id = obter().nextInt();
		System.out.print("Informe o Nome: ");
		String nome = obter().nextLine().toUpperCase();

		Pessoa p1 = new Pessoa(id, nome);
		listaPessoa.inserirElemento(id, p1);

	}

	public static void ExcluirPessoa(TreeABB<Integer, Pessoa> listaPessoa) {
		System.out.print("Informe a chave: ");
		int chave = obter().nextInt();

		listaPessoa.removeElemento(chave);

	}

	public static void ConsultarPessoa(TreeABB<Integer, Pessoa> listaPessoa) {
		System.out.print("Informe a chave: ");
		int chave = obter().nextInt();

		if (listaPessoa.buscarElemento(chave) != null) {
			listaPessoa.buscarElemento(chave).ListBens();
			System.out.println("Chave existe");
		} else {
			System.out.println("Chave não existe");
		}

	}

	public static void ListarPessoas(TreeABB<Integer, Pessoa> listaPessoa) {
		System.out.println("CodPessoa   Nome                                                      Valor Total");
		System.out.println("---------   ---------------------------------------------   ----------------------");

		for (Pessoa p : listaPessoa.listElements()) {
			System.out.println(p.getCod_Pessoa() + "            " + p.getNome()
					+ "                                          " + p.Vbens());
		}
	}
  
	public static void IncluirBens(TreeABB<Integer, Pessoa> listaPessoa) {
		System.out.println("\n--Cadastrar Bens--");
		System.out.print("Informe o ID da Pessoa: ");
		int id = obter().nextInt();
		System.out.print("Informe o ID do Bem: ");
		int idBem = obter().nextInt();
		System.out.print("Informe o Nome do Bem: ");
		String nomebem = obter().nextLine().toUpperCase();
		System.out.print("Valor do bem: ");
		double valor = obter().nextDouble();

		Bens b1 = new Bens(idBem, nomebem, valor);
		Pessoa p = (Pessoa) listaPessoa.buscarElemento(id);
		p.AddBemPessoa(b1);

	}// erro qd tem mais de um bem
	public static void ExcluirBens(TreeABB<Integer, Pessoa> listaPessoa) {
		System.out.print("Informe o ID da Pessoa: ");
		int id = obter().nextInt();
		System.out.print("Informe o ID do Bem: ");
		int idBem = obter().nextInt();
		
		//Bens b2 = new Bens(id, idBem);
		Pessoa p2 = (Pessoa)listaPessoa.buscarElemento(id);
		p2.ExcluirBem(idBem);
		
		
	
}
}
