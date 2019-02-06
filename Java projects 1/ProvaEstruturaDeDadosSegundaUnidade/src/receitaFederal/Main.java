package receitaFederal;

import java.util.Scanner;

import fila.FilaVetor;



public class Main {

	private static Scanner leia;
	private static Scanner input;

	public static void main(String[] args) {
		leia = new Scanner(System.in);
		input = new Scanner(System.in);
		int verificador1, verificador2 = 1, verificador3, verificador4, numeroNf, ano;
		double valor;
		FilaVetor<Pessoa> filaPessoa = new FilaVetor<>();
		FilaVetor<NotaFiscal> filaNotaFiscal = new FilaVetor<>();
		FilaVetor<MalhaFina> filaPessoasCaidasNaMalhaFina = new FilaVetor<>();
		String nome, cpf;
		do {
			System.out.println("1-Cadastrar pessoa");
			System.out.println("2-Cadastrar rendimento");
			System.out.println("3-Emitir nota fiscal");
			System.out.println("4-Adicionar pessoa na malha fina");
			System.out.println("5-Listar anos em que uma pessoa esteve malha fina");
			System.out.println("6-Listar todas as pessoas na malha fina");
			System.out.println("7-Listar todas as nostas fiscais de uma pessoa em um determinado ano");
			System.out.print("8-Sair: ");
			verificador1 = input.nextInt();
			switch (verificador1){
			case 1:
				verificador4 = 0;
				System.out.print("Quantos pessoas quer cadastrar: ");
				verificador3 = input.nextInt();
				do {
					System.out.print("Nome: ");
					nome = leia.nextLine();
					System.out.print("Cpf: ");
					cpf = leia.nextLine();
					Pessoa pessoa = new Pessoa(nome, cpf);
					filaPessoa.enfileirar(pessoa);
					verificador4++;
				} while(verificador4 < verificador3);
				break;
			case 2:
				verificador4 = 0;
				System.out.print("Quantas rendimentos quer cadastrar: ");
				verificador3 = input.nextInt();
				do {
					System.out.print("Valor: R$ ");
					valor = input.nextDouble();
					System.out.print("Ano: ");
					ano = input.nextInt();
					System.out.print("CPF da pessoa deste rendimento: ");
					cpf = leia.nextLine();
					Rendimentos rendimento = new Rendimentos(valor, ano);
					if (filaPessoa != null){
						for (Pessoa pessoa : filaPessoa) {
							if (pessoa != null){
								if(pessoa.getCpf().equals(cpf)){
									pessoa.filaRendimentos.enfileirar(rendimento);
								}
							}
						}
					}
					verificador4++;
				} while(verificador4 < verificador3);
				break;
			case 3:
				verificador4 = 0;
				System.out.print("Quantas notas fiscais quer emetir: ");
				verificador3 = input.nextInt();
				do {
					System.out.print("Numero da nota fiscal: ");
					numeroNf = input.nextInt();
					System.out.print("Numero do cpf do comprador: ");
					cpf = leia.nextLine();
					System.out.print("Valor da nota fiscal: R$ ");
					valor = input.nextDouble();
					System.out.print("Ano da emissão da nota fiscal: ");
					ano = input.nextInt();
					NotaFiscal notaFiscal = new NotaFiscal(numeroNf, cpf, valor, ano);
					filaNotaFiscal.enfileirar(notaFiscal);
					verificador4++;
				} while(verificador4 < verificador3);
				break;
			case 4:
				verificador4 = 0;
				System.out.print("Quantas pessoas quer adicionar na malha fina: ");
				verificador3 = input.nextInt();
				double valorAux1 = 0, valorAux2 = 0;
				do {
					System.out.print("CPF da pessoa: ");
					cpf = leia.nextLine();
					System.out.print("Ano da Malha Fina: ");
					ano = input.nextInt();
					if (filaPessoa != null){
						for (Pessoa pessoa : filaPessoa) {
							if (pessoa != null){
								if (pessoa.getCpf().equals(cpf)){
									if (pessoa.filaRendimentos != null){
										for (Rendimentos rendimento : pessoa.filaRendimentos) {
											if (rendimento != null){
												if(rendimento.getAno() == ano){
													valorAux1 = valorAux1 + rendimento.getValor();
												}
											}
										}
										if (filaNotaFiscal != null){
											for (NotaFiscal notaFiscal : filaNotaFiscal) {
												if (notaFiscal != null){
													if (notaFiscal.getCpfComprador().equals(cpf) && notaFiscal.getAno() == ano){
														valorAux2 = valorAux2 + notaFiscal.getValor();
													}
												}
											}
											if (valorAux1 < valorAux2){
												MalhaFina malhaFina = new MalhaFina(pessoa, ano);
												filaPessoasCaidasNaMalhaFina.enfileirar(malhaFina);
											}
										}
									}
								}
							}
						}
					}
					verificador4++;
				} while(verificador4 < verificador3);
				break;
			case 5:
				System.out.print("CPF da Pessoa: ");
				cpf = leia.nextLine();
				System.out.printf("%5s", "Anos:" + "\n");
				if (filaPessoasCaidasNaMalhaFina != null){
					for (MalhaFina malhaFina : filaPessoasCaidasNaMalhaFina) {
						if(malhaFina != null){
							if (malhaFina.getPessoa().getCpf().equals(cpf)){
								if(malhaFina.filaAno != null){
									for (Integer anoAux : malhaFina.filaAno) {
										if (anoAux != null){
											System.out.printf("%5s", anoAux + "\n");
										}
									}
								}
							}
						}
					}
				}
				break;
			case 6:
				verificador4 = 0;
				System.out.print("Ano a ser verificado: ");
				ano = input.nextInt();
				System.out.printf("%20s", "Pessoas que cairam na malha fina:" + "\n");
				if (filaPessoasCaidasNaMalhaFina != null){
					for (MalhaFina malhaFina : filaPessoasCaidasNaMalhaFina) {
						if(malhaFina != null){
							for (Integer anoAux : malhaFina.filaAno) {
								if (anoAux != null){
									if(ano == anoAux){
										System.out.printf("%20s", malhaFina.getPessoa().getNome() + "\n");
									}
								}
							}
						}
					}
				}
				break;
			case 7:
				System.out.print("CPF da pessoa: ");
				cpf = leia.nextLine();
				System.out.print("Ano a ser verificado: ");
				ano = input.nextInt();
				System.out.printf("%25s %20s %25s %20s", "Numero da nota fiscal", "CPF do comprador", "Valor da nota fiscal", "Ano de emissão" + "\n");
				if (filaNotaFiscal != null){
					for (NotaFiscal notaFiscal : filaNotaFiscal) {
						if(notaFiscal != null){
							if (notaFiscal.getCpfComprador().equals(cpf) && notaFiscal.getAno() == ano){
								System.out.printf("%25s %20s %25s %20s", notaFiscal.getNumeroNf(), notaFiscal.getCpfComprador(), "R$ " + notaFiscal.getValor(), notaFiscal.getAno() + "\n");
							}
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
