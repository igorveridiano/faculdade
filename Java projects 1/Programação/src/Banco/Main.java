package Banco;

import java.util.Scanner;

public class Main {
	static Agencia agencia1 = new Agencia(122);
	static Agencia agencia2 = new Agencia(110);
	static int aux = 0;
	static int aux1 = 0;

	public static void main(String[] args) {

		while (aux != 7) {
			Menu();
			System.out.println("Insira a sua op��o");
			try {
				aux = getScanner().nextInt();
			} catch (Exception e) {
				System.err.println("Insira um n�mero");
				aux = 0;
			}
			switch (aux) {
			case 1:

				System.out.println("Voc� deseja cadastrar o cliente na ag�ncia 1 ou na Ag�ncia 2");
				try {
					aux1 = getScanner().nextInt();
					if (aux1 != 1 && aux1 != 2) {
						throw new Exception();
					}
				} catch (Exception e) {
					System.err.println("Ag�ncia n�o encontrada");
					break;
				}
				System.out.println("Insira o nome e o CPF do Cliente");
				try {
					Cliente cliente = new Cliente(getScanner().nextLine(), getScanner().nextInt());
					System.out.println("Cliente criado");

					if (aux1 == 1) {
						agencia1.getLista_Cliente().add(cliente);
						agencia1.getLista_Conta().add(cliente.getConta());
						agencia1.getLista_Conta().add(cliente.getPoupanca());
					} else {
						agencia2.getLista_Cliente().add(cliente);
						agencia2.getLista_Conta().add(cliente.getConta());
						agencia2.getLista_Conta().add(cliente.getPoupanca());
					}
					if (cliente.getConta() instanceof ContaComum) {
						System.out.println("A conta comum tem como n�mero: " + cliente.getConta().getNumero());
					} else {
						System.out.println("A conta especial tem como n�mero: " + cliente.getConta().getNumero());
					}
					System.out.println("A poupan�a tem como n�mero: " + cliente.getPoupanca().getNumero());
				} catch (Exception e) {
					System.err.println("Alguma informa��o foi dada errado");
				}

				break;
			case 2:
				System.out.println("De qual ag�ncia � a conta?");
				try {
					aux1 = getScanner().nextInt();
					if (aux1 != 1 && aux1 != 2) {
						throw new Exception("N�o existe essa agencia");
					}
				} catch (Exception e) {
					System.err.println("Ag�ncia n�o encontrada");
					
				}
				if (aux1 == 1) {
					if (TranferenciaMsmAgencia(agencia1)) {
						System.out.println("Transfer�ncia Completa");
					}
				}
				if (aux1 == 2) {
					if (TranferenciaMsmAgencia(agencia2)) {
						System.out.println("Transfer�ncia Completa");
					}
				}

				break;
			case 3:

				break;
			case 4:

				break;
			case 5:
				System.out.println("De qual ag�ncia � a conta?");
				try {
					aux1 = getScanner().nextInt();
					if (aux1 != 1 && aux1 != 2) {
						throw new Exception("N�o existe essa agencia");
					}
				} catch (Exception e) {
					System.err.println("Ag�ncia n�o encontrada");

				}
				try {
					Conta conta1 = null;
					boolean flag = false;
					if (aux1 == 1) {

						System.out.println("Insira o numero da conta que vai enviar o dinheiro");
						int numero = getScanner().nextInt();
						for (Conta conta : agencia1.getLista_Conta()) {
							if (numero == conta.getNumero()) {
								conta1 = conta;

								flag = true;
								break;
							}

						}
						if (aux1 == 2) {

							System.out.println("Insira o numero da conta que vai enviar o dinheiro");
							int numero1 = getScanner().nextInt();
							for (Conta conta : agencia2.getLista_Conta()) {
								if (numero1 == conta.getNumero()) {
									conta1 = conta;

									flag = true;
									break;
								}

							}
						}
						if (!flag) {
							throw new Exception();
						} else {
							conta1.depositar();
						}
					}

				}

				catch (Exception e) {
					System.err.println("Conta n�o encontrada");
				}
				break;
			case 6:
				System.out.println("De qual ag�ncia � a conta?");
				try {
					aux1 = getScanner().nextInt();
					if (aux1 != 1 && aux1 != 2) {
						throw new Exception("N�o existe essa agencia");
					}
				} catch (Exception e) {
					System.err.println("Ag�ncia n�o encontrada");

				}
				try {
					Conta conta1 = null;
					boolean flag = false;
					if (aux1 == 1) {

						System.out.println("Insira o n�mero da conta que voc� deseja sacar?");
						int numero = getScanner().nextInt();
						for (Conta conta : agencia1.getLista_Conta()) {
							if (numero == conta.getNumero()) {
								conta1 = conta;

								flag = true;
								break;
							}

						}
						if (aux1 == 2) {

							System.out.println("Insira o n�mero da conta que voc� deseja sacar?");
							int numero1 = getScanner().nextInt();
							for (Conta conta : agencia2.getLista_Conta()) {
								if (numero1 == conta.getNumero()) {
									conta1 = conta;

									flag = true;
									break;
								}

							}
						}
						if (!flag) {
							throw new Exception();
						} else {
							conta1.sacar();
						}

					}
				} catch (Exception e) {
					System.err.println("Conta n�o encontrada");

				}
				break;
			default:
				break;
			}
		}

	}

	public static void Menu() {
		System.out.println("\n\n1 => Cadastrar cliente");
		System.out.println("2 => Transfer�ncia entre contas do banco");
		System.out.println("3 => Transfer�ncia para conta de outro banco");
		System.out.println("4 => Consultar extrato");
		System.out.println("5 => Dep�sito");
		System.out.println("6 => Saque");
		System.out.println("7 => Sair");
	}

	public static Scanner getScanner() {
		return new Scanner(System.in);
	}

	public static boolean TranferenciaMsmAgencia(Agencia agencia) {
		try {
			Conta conta1 = null, conta2 = null;
			if (aux1 == 1) {

				boolean flag = false;
				while (!flag) {
					System.out.println("Insira o numero da conta que vai enviar o dinheiro");
					int numero = getScanner().nextInt();
					for (Conta conta : agencia.getLista_Conta()) {
						if (numero == conta.getNumero()) {
							conta1 = conta;

							flag = true;
							break;
						}

					}
					System.out.println("Essa conta n�o existe");
					System.out
							.println("Se quiser continuar tentando coloque um n�mero,se quiser sair digite uma letra");

				}
				System.out.println("Insira o n�mero da outra conta");
				boolean flag1 = false;
				while (!flag1) {
					System.out.println("Insira o numero da conta");
					int numero = getScanner().nextInt();
					for (Conta conta : agencia.getLista_Conta()) {
						if (numero == conta.getNumero()) {
							conta2 = conta;
							flag1 = true;
							break;
						}

					}
					System.out.println("Essa conta n�o existe");
					System.out
							.println("Se quiser continuar tentando coloque um n�mero,se quiser sair digite uma letra");

				}
				if (conta1.transferir(conta2)) {
					return true;
				}

			}
		} catch (Exception e) {
			System.err.println("Sa�da do metodo de transfer�ncia");

		}
		return false;
	}
}
