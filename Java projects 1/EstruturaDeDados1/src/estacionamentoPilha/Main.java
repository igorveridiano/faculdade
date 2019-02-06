package estacionamentoPilha;

import java.util.Scanner;


public class Main {

	private static Scanner input;
	private static Scanner leia;

	public static void main(String[] args) {
		leia = new Scanner(System.in);
		input = new Scanner(System.in);
		Estacionamento estacionamento = new Estacionamento();
		int verificador1 = 0, verificador2, verificador3, verificador4 = 0;
		String placa;
		do {
			System.out.println("1-Entrada de veiculos");
			System.out.println("2-Saida de veiculos");
			System.out.print("3-Sair: ");
			verificador2 = input.nextInt();
			switch (verificador2){
			case 1:
				System.out.print("Quantos carros vão dar entrada: ");
				verificador3 = input.nextInt();
				do {
					System.out.print("Placa do carro: ");
					placa = leia.nextLine();
					Carro carro = new Carro(placa);
					estacionamento.Entrada(carro);
					verificador4++;
				} while (verificador4 < verificador3);
				break;
			case 2:
				System.out.print("Quantos carros vão sair: ");
				verificador3 = input.nextInt();
				do {
					System.out.print("Placa do carro: ");
					placa = leia.nextLine();
					Carro carro = new Carro(placa);
					estacionamento.Saida(carro);
					verificador4++;
				} while (verificador4 < verificador3);
				break;
			case 3:
				System.out.println("Saindo");
				verificador1 = 1;
				break;
			}
		} while(verificador1 == 0);
	}

}
