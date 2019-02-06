package companhiaAerea;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

	private static Scanner input;
	private static Scanner leia;
	private static Date dataVoo = null;

	public static void main(String[] args) {
		leia = new Scanner(System.in);
		input = new Scanner(System.in);
		Voos voos = new Voos();
		Clientes clientes = new Clientes();
		String localSaida, destino, data, horaSaida, horaChegada, tipoVoo, nome, cpf, email, telefone;
		int verificador1, verificador2 = 1, verificador3, verificador4, codigo, vagas;
		do {
			System.out.println("1-Cadastrar Voos");
			System.out.println("2-Cadastrar Clientes");
			System.out.println("3-Efetuar Reserva");
			System.out.println("4-Cancelar Reserva");
			System.out.println("5-Cancelar Voo");
			System.out.println("6-Listar Passageiros no Voo");
			System.out.println("7-Listar Voos: ");
			System.out.print("8-Sair: ");
			verificador1 = input.nextInt();
			switch (verificador1){
			case 1:
				verificador4 = 0;
				System.out.print("Quantos voos quer cadastrar: ");
				verificador3 = input.nextInt();
				do {
					System.out.print("Codigo do Voo: ");
					codigo = input.nextInt();
					System.out.print("Vagas do Voo: ");
					vagas = input.nextInt();
					System.out.print("Local da Partida do Voo: ");
					localSaida = leia.nextLine();
					System.out.print("Destino do Voo: ");
					destino = leia.nextLine();
					System.out.print("Data do Voo: ");
					data = leia.nextLine();
					System.out.print("Hora de Saida do Voo: ");
					horaSaida = leia.nextLine();
					System.out.print("Hora de Chegada do Voo: ");
					horaChegada = leia.nextLine();
					System.out.print("Tipo do Voo: ");
					tipoVoo = leia.nextLine();
					SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
					try {
						Date dataFormatada = formato.parse(data);
						dataVoo = dataFormatada;
					} catch (ParseException e) {
						e.printStackTrace();
					}
					Voo voo = new Voo(codigo, vagas, localSaida, destino, dataVoo, horaSaida, horaChegada, tipoVoo);
					if (voos.CadastrarVoo(voo)){
						System.out.println("Voo cadastrado com sucesso");
					} else {
						System.out.println("O Voo não pode ser cadastrado");
					}
					verificador4++;
				} while(verificador4 < verificador3);
				break;
			case 2:
				verificador4 = 0;
				System.out.print("Quantas clientes quer cadastrar: ");
				verificador3 = input.nextInt();
				do {
					System.out.print("Nome: ");
					nome = leia.nextLine();
					System.out.print("CPF: ");
					cpf = leia.nextLine();
					System.out.print("Telefone: ");
					telefone = leia.nextLine();
					System.out.print("E-mail: ");
					email = leia.nextLine();
					Cliente cliente = new Cliente(nome, cpf, telefone, email);
					if (clientes.CadastrarCliente(cliente)) {
						System.out.println("Cliente cadastrado com sucesso");
					} else {
						System.out.println("O cliente não pode ser cadastrado");
					}
					verificador4++;
				} while(verificador4 < verificador3);
				break;
			case 3:
				verificador4 = 0;
				System.out.print("Quantas reservas quer efetuar: ");
				verificador3 = input.nextInt();
				do {
					System.out.print("CPF do Cliente: ");
					cpf = leia.nextLine();
					System.out.print("Codigo do Voo: ");
					codigo = input.nextInt();
					for (Cliente cliente : clientes.listaClientes) {
						if (cliente.getCpf().equals(cpf)){
							for (Voo voo : voos.listaVoos) {
								if ( voo != null){
									if(voo.getCodigo() == codigo){
										voo.EfetuarReserva(cliente);
										break;
									} else {
										System.out.println("O voo não foi encontrado");
										break;
									}
								}
							}
						}
					}
					verificador4++;
				} while(verificador4 < verificador3);
				break;
			case 4:
				verificador4 = 0;
				System.out.print("Quantas reservas quer cancelar: ");
				verificador3 = input.nextInt();
				do {
					System.out.print("CPF do Cliente: ");
					cpf = leia.nextLine();
					System.out.print("Codigo do Voo: ");
					codigo = input.nextInt();
					for (Cliente cliente : clientes.listaClientes) {
						if (cliente.getCpf().equals(cpf)){
							for (Voo voo : voos.listaVoos) {
								if (voo != null){
									if(voo.getCodigo() == codigo){
										if (voo.CancelarReserva(cliente)){
											System.out.println("Reserva Cancelada");
											break;
										} else {
											System.out.println("A Reserva não pode ser cancelada");
											break;
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
				verificador4 = 0;
				System.out.print("Quantas voos quer cancelar: ");
				verificador3 = input.nextInt();
				do {
					System.out.print("Codigo do voo: ");
					codigo = input.nextInt();
					for (Voo voo : voos.listaVoos) {
						if (voo != null){
							if(voo.getCodigo() == codigo){
								if(voos.CancelarVoo(voo)){
									System.out.println("Voo Cancelado");
									break;
								} else {
									System.out.println("O Voo não pode ser cancelado");
									break;
								}
							}
						}
					}
					verificador4++;
				} while(verificador4 < verificador3);
				break;
			case 6:
				System.out.print("Codigo do voo: ");
				codigo = input.nextInt();
				if (voos.listaVoos.tamanho() != 0){
					for (Voo voo : voos.listaVoos) {
						if(voo != null){
							if(voo.getCodigo() == codigo){
								voo.ListarPassageiros();
							}
						}
				    } 
				} else {
					System.out.println("O voo não tem reservas efetuadas");
				}
				break;
			case 7:
				if(voos.listaVoos.tamanho() != 0){
					voos.ListarVoos();
				} else {
					System.out.println("Não existem voos com reservas efetuadas");
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
