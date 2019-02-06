package br.unit.loja;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

	private static Scanner leia;

	public static void main(String[] args) {
		leia = new Scanner(System.in);
		String verificador1, verificador2, verificador3 = null;
		ArrayList<Cidade> listaCidades = new ArrayList<Cidade>();
		ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
		ArrayList<Departamento> listaDepartamentos = new ArrayList<Departamento>();
		ArrayList<Endereco> listaEnderecos = new ArrayList<Endereco>();
		ArrayList<Estado> listaEstados = new ArrayList<Estado>();
		ArrayList<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();
		ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
		ArrayList<Venda> listaVendas = new ArrayList<Venda>();
		do {
			System.out.println("Escolha o menu que deseja acessar:");
			System.out.println("1-Cidade");
			System.out.println("2-Cliente");
			System.out.println("3-Departamento");
			System.out.println("4-Endereço");
			System.out.println("5-Estado");
			System.out.println("6-Funcionario");
			System.out.println("7-Produto");
			System.out.println("8-Venda");
			System.out.print("9-Sair: ");
			verificador1 = leia.nextLine();
			switch (verificador1){
			case "1" :
				System.out.println("O que deseja fazer:");
				System.out.println("1-Cadastrar Cidade");
				System.out.println("2-Adicionar Endereço");
				System.out.print("3-Adicionar Cliente: ");
				verificador2 = leia.nextLine();
				switch (verificador2){
				case "1" :
					int id;
					String nome, sigla, estado;
					System.out.print("Id: ");
					id = leia.nextInt();
					System.out.print("Nome: ");
					nome = leia.nextLine();
					System.out.print("Sigla: ");
					sigla = leia.nextLine();
					System.out.print("Estado: ");
					estado = leia.nextLine();
					for (Estado estados : listaEstados) {
						if(estados.getNome() == estado){
							Cidade cidade = new Cidade(id, nome, sigla, estados);
							listaCidades.add(cidade);
						} else {
							System.out.println("O estado esclhido não consta na lista de estados, por isso esta cidade não pode ser cadastrada");
						}
					}
					break;
				case "2" :
					int id1;
					System.out.print("Id: ");
					id1 = leia.nextInt();
					for (Endereco endereco : listaEnderecos) {
						if(endereco.getId() == id1){
							for (Cidade cidade : listaCidades) {
								cidade.adicionarEndereco(endereco);
							}
						}
					}
					break;
				case "3" :
					break;
				default :
					System.out.print("\nA opção escolhida não existe");
					break;
				}
				break;
			case "2" :
				System.out.println("O que deseja fazer:");
				System.out.println("1-Cadastrar Cliente");
				System.out.print("2-Registrar Compra: ");
				verificador2 = leia.nextLine();
				switch (verificador2){
				case "1" :
					String nome, cpf_cnpj, cidade, telefone;
					int id;
					System.out.print("Nome: ");
					nome = leia.nextLine();
					System.out.print("CPF ou CNPJ: ");
					cpf_cnpj = leia.nextLine();
					System.out.print("Cidade: ");
					cidade = leia.nextLine();
					System.out.print("Telefone: ");
					telefone = leia.nextLine();
					System.out.print("Id: ");
					id = leia.nextInt();
					for (Cidade cidades : listaCidades) {
						if(cidades.getNome() == cidade){
							Cliente cliente = new Cliente(nome, cpf_cnpj, cidades, telefone, id);
							listaClientes.add(cliente);
						}else {
							System.out.println("A cidade não foi encontrada na lista, por isso o cliente não pode ser cadastrado");
						}
					}
					break;
				case "2" :
					break;
				default :
					System.out.print("\nA opção escolhida não existe");
					break;
				}
				break;
			case "3" :
				System.out.println("O que deseja fazer:");
				System.out.println("1-Cadastrar Departamento");
				System.out.print("2-Adicionar Funcionario: ");
				verificador2 = leia.nextLine();
				switch (verificador2){
				case "1" :
					int id;
					String nome, sigla;
					System.out.print("Id: ");
					id = leia.nextInt();
					System.out.print("Nome: ");
					nome = leia.nextLine();
					System.out.print("Sigla: ");
					sigla = leia.nextLine();
					Departamento departamento = new Departamento(id, nome, sigla);
					listaDepartamentos.add(departamento);
					break;
				case "2" :
					break;
				default :
					System.out.print("\nA opção escolhida não existe");
					break;
				}
				break;
			case "4" :
				System.out.println("O que deseja fazer:");
				System.out.print("1-Cadastrar Endereço: ");
				verificador2 = leia.nextLine();
				switch (verificador2){
				case "1" :
					int id, numero;
					String rua, bairro, cep, cidade;
					System.out.print("id: ");
					id = leia.nextInt();
					System.out.print("Rua: ");
					rua = leia.nextLine();
					System.out.print("Numero: ");
					numero = leia.nextInt();
					System.out.print("Bairro: ");
					bairro = leia.nextLine();
					System.out.print("Cep: ");
					cep = leia.nextLine();
					System.out.print("Cidade: ");
					cidade = leia.nextLine();
					for (Cidade cidades : listaCidades) {
						if(cidades.getNome() == cidade){
							Endereco endereco = new Endereco(id, rua, numero, bairro, cep, cidades);
							listaEnderecos.add(endereco);
						}else {
							System.out.println("A cidade não foi encontrada na lista, por isso o cliente não pode ser cadastrado");
						}
					}
					break;
				default :
					System.out.print("\nA opção escolhida não existe");
					break;
				}
				break;
			case "5" :
				System.out.println("O que deseja fazer:");
				System.out.println("1-Cadastrar Estado");
				System.out.print("2-Adicionar Cidade: ");
				verificador2 = leia.nextLine();
				switch (verificador2){
				case "1" :
					int id;
					String nome, sigla;
					System.out.print("Id: ");
					id = leia.nextInt();
					System.out.print("Nome: ");
					nome = leia.nextLine();
					System.out.print("Sigla: ");
					sigla = leia.nextLine();
					Estado estado = new Estado(id, nome, sigla);
					listaEstados.add(estado);
					break;
				case "2" :
					break;
				default :
					System.out.print("\nA opção escolhida não existe");
					break;
				}
				break;
			case "6" :
				System.out.println("O que deseja fazer:");
				System.out.println("1-Cadastrar Funcionario");
				System.out.println("2-Registrar Venda");
				System.out.print("3-Verificar Comissão: ");
				verificador2 = leia.nextLine();
				switch (verificador2){
				case "1" :
					String nome, matricula, senha, departamento;
					int id;
					System.out.print("Nome: ");
					nome = leia.nextLine();
					System.out.print("Matricula: ");
					matricula = leia.nextLine();
					System.out.print("Senha: ");
					senha = leia.nextLine();
					System.out.print("Departamento: ");
					departamento = leia.nextLine();
					System.out.print("Id: ");
					id = leia.nextInt();
					for (Departamento departamentos : listaDepartamentos) {
						if(departamentos.getNome() == departamento){
							Funcionario funcionario = new Funcionario(nome, matricula, senha, departamentos, id);
							listaFuncionarios.add(funcionario);
						}
					}
					break;
				case "2" :
					break;
				case "3" :
					break;
				default :
					System.out.print("\nA opção escolhida não existe");
					break;
				}
				break;
			case "7" :
				System.out.println("O que deseja fazer:");
				System.out.println("1-Cadastrar Produto");
				System.out.println("1-Cadastrar Produto Similar");
				System.out.println("3-Adicionar Produto Similar");
				System.out.println("4-Adicionar Venda Produto");
				System.out.println("5-Excluir Produto Similar");
				System.out.println("6-Produto Marca");
				System.out.println("7-Salvar Produto");
				System.out.print("8-Produto Similar: ");
				verificador2 = leia.nextLine();
				switch (verificador2){
				case "1" :
					int id, quantidade;
					String nome, descricao;
					float preco;
					System.out.print("Id: ");
					id = leia.nextInt();
					System.out.print("Nome: ");
					nome = leia.nextLine();
					System.out.print("Descrição: ");
					descricao = leia.nextLine();
					System.out.print("Preço: ");
					preco = leia.nextFloat();
					System.out.print("Quantidade: ");
					quantidade = leia.nextInt();
					Produto produto = new Produto(id, nome, descricao, preco, quantidade);
					listaProdutos.add(produto);
					break;
				case "2" :
					break;
				case "3" :
					break;
				case "4" :
					break;
				case "5" :
					break;
				case "6" :
					break;
				case "7" :
					break;	
				case "8" :
					break;
				default :
					System.out.print("\nA opção escolhida não existe");
					break;
				}
				break;
			case "8" :
				System.out.println("O que deseja fazer:");
				System.out.println("1-Cadastrar Venda");
				System.out.println("2-Adicionar Produto");
				System.out.println("3-Obter Produtos Similares");
				System.out.println("4-Obter Produtos Destaques");
				System.out.println("5-Remover Produto por id");
				System.out.println("6-Remover produto por Produto");
				System.out.println("7-Salvar Venda Produto");
				System.out.println("8-Otbter Venda");
				System.out.print("9-Finalizar Venda: ");
				verificador2 = leia.nextLine();
				switch (verificador2){
				case "1" :
					int codigo;
					String data, cliente, funcionario;
					float precoTotal;
					System.out.print("Codigo: ");
					codigo = leia.nextInt();
					System.out.print("Data: ");
					data = leia.nextLine();
					System.out.print("Preço total: ");
					precoTotal = leia.nextFloat();
					System.out.print("Cliente: ");
					cliente = leia.nextLine();
					System.out.print("Funcionario: ");
					funcionario = leia.nextLine();
				    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
					LocalDate date = LocalDate.parse(data,formatter);
					for (Cliente clientes : listaClientes) {
						if (clientes.getNome() == cliente){
							for (Funcionario funcionarios : listaFuncionarios) {
								if (funcionarios.getNome() == funcionario){
									Venda venda = new Venda(codigo, date, precoTotal, clientes, funcionarios);
									listaVendas.add(venda);
								} else {
									System.out.println("O funcionario não foi encontrado na lista, por isso a venda não pode ser cadastrada");
								}
							}
						} else {
							System.out.println("O cliente não foi encontrado na lista, por isso a veda não pode ser cadastrada");
						}
					}
					break;
				case "2" :
					int id;
					System.out.print("Id: ");
					id = leia.nextInt();
					for (Produto produto : listaProdutos) {
						if(produto.getId() == id){
							int codigo2;
							System.out.print("Codigo: ");
							codigo2 = leia.nextInt();
							for (Venda venda : listaVendas) {
								if(venda.getCodigo() == codigo2){
									venda.adicionarProduto(produto);
								} else {
									System.out.println("A venda não foi encontrada na lista, por isso não foi possivel adicionar o produto");
								}
							}
						} else {
							System.out.println("O produto não foi encontrado na lista, por isso não foi possivel adiciona-lo");
						}
					}
					break;
				case "3" :
					break;
				case "4" :
					break;
				case "5" :
					break;
				case "6" :
					break;
				case "7" :
					break;
				case "8" :
					break;
				case "9" : 
					int codigo1;
					System.out.print("Codigo: ");
					codigo1 = leia.nextInt();
					for (Venda venda : listaVendas) {
						if(venda.getCodigo() == codigo1){
							venda.finalizarVenda();
						}else {
							System.out.println("A venda não está n lista, por isso não pode ser finalizada");
						}
					}
					break;
				default :
					System.out.print("\nA opção escolhida não existe");
					break;
				}
				break;
			case "9" :
				System.out.print("Saindo");
				verificador3 = "sair";
				break;	
			default :
				System.out.print("\nA opção escolhida não existe");
				break;	
			}
		}while(verificador3 != "sair");
	}

}
