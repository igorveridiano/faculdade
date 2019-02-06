package aula03;

import java.util.Random;

public class exericio1 {

	public static void main(String[] args) {
		int i,k,j,z1 = 0,z2 = 0,z3 = 0;
		int[] vet1 = new int[6];
		int[] vet2 = new int[6];
		int[] vet3 = new int[6];
		int [] vetaux = new int[18];
		Random sorteio = new Random();
		for(i = 0; i < vet1.length; i++){
			vet1[i] = sorteio.nextInt(59) + 1;
		}
		for(i = 0; i < vet2.length; i++){
			vet2[i] = sorteio.nextInt(59) + 1;
		}
		for(i = 0; i < vet3.length; i++){
			vet3[i] = sorteio.nextInt(59) + 1;
		}
		for (i = 0; i < vet1.length; i++){
			k = 0;
			for (j = i + 1; j < vet1.length; j++){
				if (vet1[i] == vet1[j]){
					k++;
				}
			}
			if (k == 0){
				vet1[z1] = vet1[i];
				z1++;
			}
		}
		System.out.print("Sorteio 1:");
		for(i = 0; i < z1; i++){
			System.out.print(" " + vet1[i]);
		}
		for (i = 0; i < vet2.length; i++){
			k = 0;
			for (j = i + 1; j < vet2.length; j++){
				if (vet2[i] == vet2[j]){
					k++;
				}
			}
			if (k == 0){
				vet2[z2] = vet2[i];
				z2++;
			}
		}
		System.out.print("\nSorteio 2:");
		for(i = 0; i < z2; i++){
			System.out.print(" " + vet2[i]);
		}
		for (i = 0; i < vet3.length; i++){
			k = 0;
			for (j = i + 1; j < vet3.length; j++){
				if (vet3[i] == vet3[j]){
					k++;
				}
			}
			if (k == 0){
				vet3[z3] = vet3[i];
				z3++;
			}
		}
		System.out.print("\nSorteio 3:");
		for(i = 0; i < z3; i++){
			System.out.print(" " + vet3[i]);
		}
		k = 0;
		for (i = 0; i < z1; i++){
			for (j = 0 ; j < z2; j++){
				if (vet1[i] == vet2[j]){
					vetaux[k] = vet1[i];
					k++;
				}
			}
		}
		for (i = 0; i < z1; i++){
			for (j = 0 ; j < z3; j++){
				if (vet1[i] == vet3[j]){
					vetaux[k] = vet1[i];
					k++;
				}
			}
		}
		for (i = 0; i < z3; i++){
			for (j = 0 ; j < z2; j++){
				if (vet3[i] == vet2[j]){
					vetaux[k] = vet3[i];
					k++;
				}
			}
		}
		System.out.print("\nNumeros iguais entre os sorteios:");
		for (i = 0; i < k; i++){
			System.out.print(" " + vetaux[i]);
		}
	}
}
