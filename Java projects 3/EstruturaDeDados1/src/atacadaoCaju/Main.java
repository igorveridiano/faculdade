package atacadaoCaju;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import listaSimplismenteEncadeada.ListaSimplesmenteEncadeada;

public class Main {

	private static Date dataCompra = null;
	private static Date dataVenda = null;
	private static Scanner leia;
	private static Scanner input;

	public static void main(String[] args) {
		leia = new Scanner(System.in);
		input = new Scanner(System.in);
		ListaSimplesmenteEncadeada<Produto> listaProdutos = new ListaSimplesmenteEncadeada<>();
		int verificador1, verificador2 = 1, verificador3, verificador4, codigo1, quantidade;
		double valor;
		String nome, data;
		do {
			System.out.println("1-Cadastrar Produto");
			System.out.println("2-Registrar Compra");
			System.out.println("3-Registrar Venda");
			System.out.println("4-Exibir Informações de Produto");
			System.out.println("5-Imprimir Compras");
			System.out.println("6-Imprimir Vendas");
			System.out.print("7-Sair: ");
			verificador1 = input.nextInt();
			switch (verificador1){
			case 1:
				verificador4 = 0;
				System.out.print("Quantos produtos quer cadastrar: ");
				verificador3 = input.nextInt();
				do {
					System.out.print("Nome do produto: ");
					nome = leia.nextLine();
					System.out.print("Id do produto: ");
					codigo1 = input.nextInt();
					Produto produto = new Produto (codigo1, nome);
					if (listaProdutos.tamanho() == 0){
						listaProdutos.adicionar(produto);
					} else {
						for (Produto produtos : listaProdutos) {
							if (produtos.getCodigo() != codigo1){
								listaProdutos.adicionar(produto);
								break;
							} else {
								System.out.println("O produto já está cadastrado");
							}
						}
					}
					verificador4++;
				} while(verificador4 < verificador3);
				break;
			case 2:
				verificador4 = 0;
				System.out.print("Quantas compras quer registrar: ");
				verificador3 = input.nextInt();
				do {
					System.out.print("Data: ");
					data = leia.nextLine();
					System.out.print("Quantidade comprada: ");
					quantidade = input.nextInt();
					System.out.print("Valor da compra: ");
					valor = input.nextDouble();
					System.out.print("Codigo do produto: ");
					codigo1 = input.nextInt();
					SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
					try {
						Date dataFormatada = formato.parse(data);
						dataCompra = dataFormatada;
					} catch (ParseException e) {
						e.printStackTrace();
					}
					for (Produto produtos : listaProdutos) {
						if (produtos.getCodigo() == codigo1){
							Compra compra = new Compra (dataCompra, quantidade, valor, produtos);
							produtos.RegistrarCompra(compra);
							break;
						} 
					}
					verificador4++;
				} while(verificador4 < verificador3);
				break;
			case 3:
				verificador4 = 0;
				System.out.print("Quantas vendas quer registrar: ");
				verificador3 = input.nextInt();
				do {
					System.out.print("Data: ");
					data = leia.nextLine();
					System.out.print("Valor da venda: ");
					valor = input.nextDouble();
					System.out.print("Codigo do produto: ");
					codigo1 = input.nextInt();
					System.out.print("Quantidade vendida: ");
					quantidade = input.nextInt();
					SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
					try {
						Date dataFormatada = formato.parse(data);
						dataVenda = dataFormatada;
					} catch (ParseException e) {
						e.printStackTrace();
					}
					for (Produto produtos : listaProdutos) {
						if (produtos.getCodigo() == codigo1){
							Venda venda = new Venda (dataVenda, quantidade, valor, produtos);
							produtos.RegistrarVenda(venda);
							break;
						} 
					}
					verificador4++;
				} while(verificador4 < verificador3);
				break;
			case 4:
				verificador4 = 0;
				System.out.print("Quantas produtos quer exebir: ");
				verificador3 = input.nextInt();
				do {
					System.out.print("Codigo do produto: ");
					codigo1 = input.nextInt();
					for (Produto produto : listaProdutos) {
						if (produto.getCodigo() == codigo1){
							produto.InformaçõesDeProduto();
						} 
					}
					verificador4++;
				} while(verificador4 < verificador3);
				break;
			case 5:
				verificador4 = 0;
				System.out.print("Quantas compras quer exibir: ");
				verificador3 = input.nextInt();
				do {
					System.out.print("Codigo do produto: ");
					codigo1 = input.nextInt();
					for (Produto produto : listaProdutos) {
						if (produto.getCodigo() == codigo1){
							produto.ImprimirCompras();
						} 
					}
					verificador4++;
				} while(verificador4 < verificador3);
				break;
			case 6:
				verificador4 = 0;
				System.out.print("Quantas vendas quer exebir: ");
				verificador3 = input.nextInt();
				do {
					System.out.print("Codigo do produto: ");
					codigo1 = input.nextInt();
					for (Produto produto : listaProdutos) {
						if (produto.getCodigo() == codigo1){
							produto.ImprimirVendas();
						} 
					}
					verificador4++;
				} while(verificador4 < verificador3);
				break;
			case 7:
				System.out.println("Saindo");
				verificador2 = 0;
				break;
			}		
		} while (verificador2 != 0);
		

	}

}
