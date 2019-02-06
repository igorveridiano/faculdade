package aula02;

import java.util.Arrays;
import java.util.Random;

public class OrdenandoUmVetor {

	private static Random sorteio;

	public static void main(String[] args) {
		int z, maior1, maior2;
		int [] vet = new int[16];
		sorteio = new Random();
		for(z = 0; z < vet.length; z++){
			vet[z] = sorteio.nextInt(99) + 1;
		}
		System.out.print("Vetor inicial: ");
		for(z = 0; z < vet.length; z++){
			System.out.print(vet[z] + " ");
		}
		Arrays.sort(vet);
		System.out.print("\nVetor ordenado: ");
		for(z = 0; z < vet.length ; z++){
			System.out.print(vet[z] + " ");
		}
		maior1 = vet[14];
		maior2 = vet[15];
		System.out.print("\nMaior 1: " + maior1);
		System.out.print("\nMaior 2: " + maior2);
	}

}
