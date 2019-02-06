package Loja;

import java.util.Scanner;

import ListaSimplesmenteEncadeadaComTesteDeTempoDoProjeto.ListaSimplesmenteEncadeada;

public class Main {
	static boolean t = true;
	static int i = 0;
	static Produto produto;
	public static void main(String[] args) {
		System.out.println("Bem vindo ao Atacadão Caju");
		while (t) {
			Menu();
			i=getScanner().nextInt();
			switch (i) {
			case 1:
				System.out.println("Insira o  codigo do produto,o nome e o custo");
				produto =new Produto(getScanner().nextInt(),getScanner().nextLine() ,getScanner().nextDouble() );
				System.out.println("Produto cadastrado com sucesso");
				break;

			case 2:
				try {
					System.out.println("Insira a quantidade e o custo da compra");
					produto.Compra(getScanner().nextInt(), getScanner().nextDouble());
					System.out.println("Compra efetuada com sucesso");
				} catch (NullPointerException e) {
					System.err.println("Produto ainda nao foi cadastrado");
				}
				break;
			case 3:
				try {
					System.out.println("Insira a quantidade e o custo da venda");
					produto.Venda(getScanner().nextInt(), getScanner().nextDouble());
					System.out.println("Venda efetuada com sucesso");
				} catch (NullPointerException e) {
					System.err.println("Produto ainda nao foi cadastrado");
				}
				break;
			case 4:
				System.out.println(produto);
				break;
			case 5:

				break;
			case 6:

				break;
			default:
				System.out.println("Opção não encontrada");
				break;
			}
		}
	}

	public static void Menu() {

		System.out.println("Digite a opção desejada");
		System.out.println("1- Cadastrar Produto");
		System.out.println("2- Registrar Compra");
		System.out.println("3- Registrar Venda");
		System.out.println("4 – Exibir informações de um produto");
		System.out.println("5 – Imprimir compras");
		System.out.println("6 – Imprimir vendas");
	}

	public static Scanner getScanner(){
		return new Scanner(System.in);
	}
}
