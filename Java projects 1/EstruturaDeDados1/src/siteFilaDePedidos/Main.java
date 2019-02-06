package siteFilaDePedidos;

import java.util.Scanner;

import listaDuplamenteEncadeada.ListaDuplamenteEncadeada;


public class Main {

	private static Scanner leia;
	private static Scanner input;
	private static Pedidos pedidos;

	public static void main(String[] args) {
		leia = new Scanner(System.in);
		input = new Scanner(System.in);
		pedidos = new Pedidos();
		ListaDuplamenteEncadeada<Produto> listaProdutos = new ListaDuplamenteEncadeada<>();
		ListaDuplamenteEncadeada<Cliente> listaClientes = new ListaDuplamenteEncadeada<>();
		int verificador1 = 0, verificador2, id, quantidade, verificador3, verificador4;
		float precoDaCompra;
		String nome, cpf;
		do {
			System.out.println("1-Cadastrar Produto");
			System.out.println("2-Cadastrar Cliente");
			System.out.println("3-Efetuar Pedido");
			System.out.println("4-Despachar Pedido");
			System.out.println("5-Exibir Fila de Pedidos");
			System.out.print("6-Sair: ");
			verificador2 = input.nextInt();
			switch (verificador2){
			case 1:
				verificador4 = 0;
				System.out.print("Quantos produtos quer cadastrar: ");
				verificador3 = input.nextInt();
				do {
					System.out.print("Nome do produto: ");
					nome = leia.nextLine();
					System.out.print("Id do produto: ");
					id = input.nextInt();
					System.out.print("Quantidade do produto: ");
					quantidade = input.nextInt();
					System.out.print("Preço da compra do produto: ");
					precoDaCompra = input.nextFloat();
					Produto produto = new Produto(nome, id, quantidade, precoDaCompra);
					if(listaProdutos.tamanho() == 0){
						listaProdutos.adicionar(produto);
					} else {
						for (Produto produtos : listaProdutos) {
							 if (produtos.getId() == produto.getId()) {
								 produtos.CompraDeProdutoEmEstoque(quantidade, precoDaCompra);
								break;
							} else {
								listaProdutos.adicionar(produto);
								break;
							}
						}
					}
					verificador4++;
				} while(verificador4 < verificador3);
				break;
			case 2:
				verificador4 = 0;
				System.out.print("Quantos clientes quer cadastrar: ");
				verificador3 = input.nextInt();
				do {
					System.out.print("Nome do cliente: ");
					nome = leia.nextLine();
					System.out.print("CPF do cliente: ");
					cpf = leia.nextLine();
					Cliente cliente = new Cliente(nome, cpf);
					if(listaClientes.tamanho() == 0){
						listaClientes.adicionar(cliente);
					} else {
						for (Cliente clientes : listaClientes) {
							 if (cliente.getCpf().equals(clientes.getCpf())){
								System.out.println("O cliente de CPF " + cliente.getCpf() + " já está cadastrado");
							} else {
								listaClientes.adicionar(cliente);
								break;
							}
						}
					}
					verificador4++;
				} while (verificador4 < verificador3);
				break;
			case 3:
				boolean flag1 = false, flag2 = true, flag3 = true;
				System.out.print("CPF do clinete: ");
				cpf = leia.nextLine();
				for (Cliente cliente : listaClientes) {
					if (cliente.getCpf().equals(cpf)){
						flag2 = false;
						Pedido pedido = new Pedido(cliente);
						do {
							System.out.print("Id do produto: ");
							id = input.nextInt();
							if(id == -1) {
								break;
							}
							System.out.print("Quantidade comprada do produto: ");
							quantidade = input.nextInt();
							if(listaProdutos.tamanho() == 0){
								System.out.println("Produto não encontrado");
								break;
							} else {
								for (Produto produto : listaProdutos) {
									if (produto.getId() == id){
										pedido.AdicionarProduto(produto, quantidade);
										flag1 = true;
										flag3 = false;
									} 
								}
								if (flag3){
									System.out.println("Produto de id " + id + " não encontrado");
								}
							}	
						} while(id != -1);
						if(flag1){
							pedidos.EfetuarPedido(pedido);
							System.out.println("A id do pedido é: " + pedido.getId());
							System.out.println("Preço total da compra: R$ " + pedido.getValorTotalDaCompra());
						}
						break;
					} 
				}
				if(flag2) {
					System.out.println("Cliente de CPF " + cpf + " não encontrado");
				}
				break;
			case 4:
				verificador4 = 0;
				System.out.print("Quantos pedidos serão despachados: ");
				verificador3 = input.nextInt();
				do {
					System.out.print("Id do pedido: ");
					id = input.nextInt();
					pedidos.DespacharPedido();
					verificador4++;
				} while(verificador4 < verificador3);
				break;
			case 5:
				pedidos.ExibirFilaDePedidos();
				break;
			case 6:
				System.out.println("Saindo");
				verificador1 = 1;
				break;
			}
		} while(verificador1 == 0);
	}

}
