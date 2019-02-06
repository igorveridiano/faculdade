package testesDeTempo;

import java.util.ArrayList;

public class ListaVetor {
	public static void main(String[] args) {
		ArrayList<Integer> lista = new ArrayList<>();
		double listaTestes[] = new double[13];
		int contador = 0;
		int aux1 = 10, aux2, aux3;
		long fim, inicio;

		// Zerando o vetor
		for (int i = 0; i < listaTestes.length; i++) {
			listaTestes[i] = 0;
		}

		while (contador != 5) {
			aux2 = 0; // controle do teste

			// Adi��o de 20 mil elementos
			inicio = System.currentTimeMillis();
			for (int i = 0; i < 20000; i++) {
				lista.add(i);
			}
			fim = System.currentTimeMillis();
			listaTestes[aux2] += (fim - inicio);
			aux2++;

			// Adi��o de um elemento
			inicio = System.currentTimeMillis();
			lista.add(aux1);
			fim = System.currentTimeMillis();
			listaTestes[aux2] += (fim - inicio);
			aux2++;

			// Adi��o no Inicio
			inicio = System.currentTimeMillis();
			lista.add(0, aux1);
			fim = System.currentTimeMillis();
			listaTestes[aux2] += (fim - inicio);
			aux2++;

			// Adi��o no Meio
			inicio = System.currentTimeMillis();
			lista.add(lista.size() / 2, aux1);
			fim = System.currentTimeMillis();
			listaTestes[aux2] += (fim - inicio);
			aux2++;

			// Remo��o no Fim
			inicio = System.currentTimeMillis();
			lista.remove(lista.size() - 1);
			fim = System.currentTimeMillis();
			listaTestes[aux2] += (fim - inicio);
			aux2++;

			// Remover do Inicio
			inicio = System.currentTimeMillis();
			lista.remove(0);
			fim = System.currentTimeMillis();
			listaTestes[aux2] += (fim - inicio);
			aux2++;

			// Remover no Meio
			inicio = System.currentTimeMillis();
			lista.remove(lista.size() / 2);
			fim = System.currentTimeMillis();
			listaTestes[aux2] += (fim - inicio);
			aux2++;

			// Obter primeiro elemento
			inicio = System.currentTimeMillis();
			lista.get(0);
			fim = System.currentTimeMillis();
			listaTestes[aux2] += (fim - inicio);
			aux2++;

			// Obter ultimo elemento
			inicio = System.currentTimeMillis();
			lista.get(lista.size() - 1);
			fim = System.currentTimeMillis();
			listaTestes[aux2] += (fim - inicio);
			aux2++;

			// Obter elemento do meio
			inicio = System.currentTimeMillis();
			lista.get(lista.size() / 2);
			fim = System.currentTimeMillis();
			listaTestes[aux2] += (fim - inicio);
			aux2++;

			// Obter um elemento inexistente
			inicio = System.currentTimeMillis();
			lista.contains(-1);
			fim = System.currentTimeMillis();
			listaTestes[aux2] += (fim - inicio);
			aux2++;

			// Percorre totalmente a lista
			inicio = System.currentTimeMillis();
			for (int i = 0; i < lista.size(); i++) {

			}
			fim = System.currentTimeMillis();
			listaTestes[aux2] += (fim - inicio);
			aux2++;

			// Tempo para limpar a lista
			inicio = System.currentTimeMillis();
			lista.clear();
			fim = System.currentTimeMillis();
			listaTestes[aux2] += (fim - inicio);
			aux2++;
			contador++;
		}
		System.out.println("TESTE COM 20 MIL\n\n");
		aux3 = 0;
		System.out.println(
				"O tempo de adi��o de 20 mil elementos � de: " + (listaTestes[aux3]) / 5 + " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para adi��o de um novo elemento no fim da lista � de: " + (listaTestes[aux3]) / 5
				+ " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para adi��o de um novo elemento no inicio da lista � de: " + (listaTestes[aux3]) / 5
				+ " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para adi��o de um novo elemento no meio da lista � de: " + (listaTestes[aux3]) / 5
				+ " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para remo��o de um elemento no final da lista � de: " + (listaTestes[aux3]) / 5
				+ " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para remo��o de um elemento no inicio da lista � de: " + (listaTestes[aux3]) / 5
				+ " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para remo��o de um elemento no meio da lista � de: " + (listaTestes[aux3]) / 5
				+ " milisegundos\n\n");
		aux3++;
		System.out.println(
				"O tempo para obter o primeiro numero da lista � de: " + (listaTestes[aux3]) / 5 + " milisegundos\n\n");
		aux3++;
		System.out.println(
				"O tempo para obter o ultimo numero da lista � de: " + (listaTestes[aux3]) / 5 + " milisegundos\n\n");
		aux3++;
		System.out.println(
				"O tempo para obter o numero do meio da lista � de: " + (listaTestes[aux3]) / 5 + " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para obter um elemento inexistente da tabela � de: " + (listaTestes[aux3]) / 5
				+ " milisegundos\n\n");
		aux3++;
		System.out.println(
				"O tempo para percorrer totalmente a lista � de: " + (listaTestes[aux3]) / 5 + " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo limpar a lista � de: " + (listaTestes[aux3]) / 5 + " milisegundos\n\n");

		// Zerando o vetor
		for (int i = 0; i < listaTestes.length; i++) {
			listaTestes[i] = 0;
		}

		contador = 0;

		while (contador != 5) {
			aux2 = 0; // controle do teste

			// Adi��o de 200 mil elementos
			inicio = System.currentTimeMillis();
			for (int i = 0; i < 200000; i++) {
				lista.add(i);
			}
			fim = System.currentTimeMillis();
			listaTestes[aux2] += (fim - inicio);
			aux2++;

			// Adi��o de um elemento
			inicio = System.currentTimeMillis();
			lista.add(aux1);
			fim = System.currentTimeMillis();
			listaTestes[aux2] += (fim - inicio);
			aux2++;

			// Adi��o no Inicio
			inicio = System.currentTimeMillis();
			lista.add(0, aux1);
			fim = System.currentTimeMillis();
			listaTestes[aux2] += (fim - inicio);
			aux2++;

			// Adi��o no Meio
			inicio = System.currentTimeMillis();
			lista.add(lista.size() / 2, aux1);
			fim = System.currentTimeMillis();
			listaTestes[aux2] += (fim - inicio);
			aux2++;

			// Remo��o no Fim
			inicio = System.currentTimeMillis();
			lista.remove(lista.size() - 1);
			fim = System.currentTimeMillis();
			listaTestes[aux2] += (fim - inicio);
			aux2++;

			// Remover do Inicio
			inicio = System.currentTimeMillis();
			lista.remove(0);
			fim = System.currentTimeMillis();
			listaTestes[aux2] += (fim - inicio);
			aux2++;

			// Remover no Meio
			inicio = System.currentTimeMillis();
			lista.remove(lista.size() / 2);
			fim = System.currentTimeMillis();
			listaTestes[aux2] += (fim - inicio);
			aux2++;

			// Obter primeiro elemento
			inicio = System.currentTimeMillis();
			lista.get(0);
			fim = System.currentTimeMillis();
			listaTestes[aux2] += (fim - inicio);
			aux2++;

			// Obter ultimo elemento
			inicio = System.currentTimeMillis();
			lista.get(lista.size() - 1);
			fim = System.currentTimeMillis();
			listaTestes[aux2] += (fim - inicio);
			aux2++;

			// Obter elemento do meio
			inicio = System.currentTimeMillis();
			lista.get(lista.size() / 2);
			fim = System.currentTimeMillis();
			listaTestes[aux2] += (fim - inicio);
			aux2++;

			// Obter um elemento inexistente
			inicio = System.currentTimeMillis();
			lista.contains(-1);
			fim = System.currentTimeMillis();
			listaTestes[aux2] += (fim - inicio);
			aux2++;

			// Percorre totalmente a lista
			inicio = System.currentTimeMillis();
			for (int i = 0; i < lista.size(); i++) {

			}
			fim = System.currentTimeMillis();
			listaTestes[aux2] += (fim - inicio);
			aux2++;

			// Tempo para limpar a lista
			inicio = System.currentTimeMillis();
			lista.clear();
			fim = System.currentTimeMillis();
			listaTestes[aux2] += (fim - inicio);
			aux2++;
			contador++;
		}
		System.out.println("TESTE COM 200 MIL\n\n");
		aux3 = 0;
		System.out.println(
				"O tempo de adi��o de 200 mil elementos � de: " + (listaTestes[aux3]) / 5 + " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para adi��o de um novo elemento no fim da lista � de: " + (listaTestes[aux3]) / 5
				+ " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para adi��o de um novo elemento no inicio da lista � de: " + (listaTestes[aux3]) / 5
				+ " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para adi��o de um novo elemento no meio da lista � de: " + (listaTestes[aux3]) / 5
				+ " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para remo��o de um elemento no final da lista � de: " + (listaTestes[aux3]) / 5
				+ " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para remo��o de um elemento no inicio da lista � de: " + (listaTestes[aux3]) / 5
				+ " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para remo��o de um elemento no meio da lista � de: " + (listaTestes[aux3]) / 5
				+ " milisegundos\n\n");
		aux3++;
		System.out.println(
				"O tempo para obter o primeiro numero da lista � de: " + (listaTestes[aux3]) / 5 + " milisegundos\n\n");
		aux3++;
		System.out.println(
				"O tempo para obter o ultimo numero da lista � de: " + (listaTestes[aux3]) / 5 + " milisegundos\n\n");
		aux3++;
		System.out.println(
				"O tempo para obter o numero do meio da lista � de: " + (listaTestes[aux3]) / 5 + " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para obter um elemento inexistente da tabela � de: " + (listaTestes[aux3]) / 5
				+ " milisegundos\n\n");
		aux3++;
		System.out.println(
				"O tempo para percorrer totalmente a lista � de: " + (listaTestes[aux3]) / 5 + " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo limpar a lista � de: " + (listaTestes[aux3]) / 5 + " milisegundos\n\n");

		// Zerando o vetor
		for (int i = 0; i < listaTestes.length; i++) {
			listaTestes[i] = 0;
		}

		contador = 0;

		while (contador != 5) {
			aux2 = 0; // controle do teste

			// Adi��o de 2 milh�es elementos
			inicio = System.currentTimeMillis();
			for (int i = 0; i < 2000000; i++) {
				lista.add(i);
			}
			fim = System.currentTimeMillis();
			listaTestes[aux2] += (fim - inicio);
			aux2++;

			// Adi��o de um elemento
			inicio = System.currentTimeMillis();
			lista.add(aux1);
			fim = System.currentTimeMillis();
			listaTestes[aux2] += (fim - inicio);
			aux2++;

			// Adi��o no Inicio
			inicio = System.currentTimeMillis();
			lista.add(0, aux1);
			fim = System.currentTimeMillis();
			listaTestes[aux2] += (fim - inicio);
			aux2++;

			// Adi��o no Meio
			inicio = System.currentTimeMillis();
			lista.add(lista.size() / 2, aux1);
			fim = System.currentTimeMillis();
			listaTestes[aux2] += (fim - inicio);
			aux2++;

			// Remo��o no Fim
			inicio = System.currentTimeMillis();
			lista.remove(lista.size() - 1);
			fim = System.currentTimeMillis();
			listaTestes[aux2] += (fim - inicio);
			aux2++;

			// Remover do Inicio
			inicio = System.currentTimeMillis();
			lista.remove(0);
			fim = System.currentTimeMillis();
			listaTestes[aux2] += (fim - inicio);
			aux2++;

			// Remover no Meio
			inicio = System.currentTimeMillis();
			lista.remove(lista.size() / 2);
			fim = System.currentTimeMillis();
			listaTestes[aux2] += (fim - inicio);
			aux2++;

			// Obter primeiro elemento
			inicio = System.currentTimeMillis();
			lista.get(0);
			fim = System.currentTimeMillis();
			listaTestes[aux2] += (fim - inicio);
			aux2++;

			// Obter ultimo elemento
			inicio = System.currentTimeMillis();
			lista.get(lista.size() - 1);
			fim = System.currentTimeMillis();
			listaTestes[aux2] += (fim - inicio);
			aux2++;

			// Obter elemento do meio
			inicio = System.currentTimeMillis();
			lista.get(lista.size() / 2);
			fim = System.currentTimeMillis();
			listaTestes[aux2] += (fim - inicio);
			aux2++;

			// Obter um elemento inexistente
			inicio = System.currentTimeMillis();
			lista.contains(-1);
			fim = System.currentTimeMillis();
			listaTestes[aux2] += (fim - inicio);
			aux2++;

			// Percorre totalmente a lista
			inicio = System.currentTimeMillis();
			for (int i = 0; i < lista.size(); i++) {

			}
			fim = System.currentTimeMillis();
			listaTestes[aux2] += (fim - inicio);
			aux2++;

			// Tempo para limpar a lista
			inicio = System.currentTimeMillis();
			lista.clear();
			fim = System.currentTimeMillis();
			listaTestes[aux2] += (fim - inicio);
			aux2++;
			contador++;
		}
		System.out.println("TESTE COM 2 MILH�ES\n\n");
		aux3 = 0;
		System.out.println(
				"O tempo de adi��o de 2 milh�es elementos � de: " + (listaTestes[aux3]) / 5 + " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para adi��o de um novo elemento no fim da lista � de: " + (listaTestes[aux3]) / 5
				+ " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para adi��o de um novo elemento no inicio da lista � de: " + (listaTestes[aux3]) / 5
				+ " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para adi��o de um novo elemento no meio da lista � de: " + (listaTestes[aux3]) / 5
				+ " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para remo��o de um elemento no final da lista � de: " + (listaTestes[aux3]) / 5
				+ " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para remo��o de um elemento no inicio da lista � de: " + (listaTestes[aux3]) / 5
				+ " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para remo��o de um elemento no meio da lista � de: " + (listaTestes[aux3]) / 5
				+ " milisegundos\n\n");
		aux3++;
		System.out.println(
				"O tempo para obter o primeiro numero da lista � de: " + (listaTestes[aux3]) / 5 + " milisegundos\n\n");
		aux3++;
		System.out.println(
				"O tempo para obter o ultimo numero da lista � de: " + (listaTestes[aux3]) / 5 + " milisegundos\n\n");
		aux3++;
		System.out.println(
				"O tempo para obter o numero do meio da lista � de: " + (listaTestes[aux3]) / 5 + " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para obter um elemento inexistente da tabela � de: " + (listaTestes[aux3]) / 5
				+ " milisegundos\n\n");
		aux3++;
		System.out.println(
				"O tempo para percorrer totalmente a lista � de: " + (listaTestes[aux3]) / 5 + " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo limpar a lista � de: " + (listaTestes[aux3]) / 5 + " milisegundos\n\n");

		// Zerando o vetor
		for (int i = 0; i < listaTestes.length; i++) {
			listaTestes[i] = 0;
		}

		contador = 0;

		while (contador != 5) {
			aux2 = 0; // controle do teste

			// Adi��o de 20 milh�es elementos
			inicio = System.currentTimeMillis();
			for (int i = 0; i < 20000000; i++) {
				lista.add(i);
			}
			fim = System.currentTimeMillis();
			listaTestes[aux2] += (fim - inicio);
			aux2++;

			// Adi��o de um elemento
			inicio = System.currentTimeMillis();
			lista.add(aux1);
			fim = System.currentTimeMillis();
			listaTestes[aux2] += (fim - inicio);
			aux2++;

			// Adi��o no Inicio
			inicio = System.currentTimeMillis();
			lista.add(0, aux1);
			fim = System.currentTimeMillis();
			listaTestes[aux2] += (fim - inicio);
			aux2++;

			// Adi��o no Meio
			inicio = System.currentTimeMillis();
			lista.add(lista.size() / 2, aux1);
			fim = System.currentTimeMillis();
			listaTestes[aux2] += (fim - inicio);
			aux2++;

			// Remo��o no Fim
			inicio = System.currentTimeMillis();
			lista.remove(lista.size() - 1);
			fim = System.currentTimeMillis();
			listaTestes[aux2] += (fim - inicio);
			aux2++;

			// Remover do Inicio
			inicio = System.currentTimeMillis();
			lista.remove(0);
			fim = System.currentTimeMillis();
			listaTestes[aux2] += (fim - inicio);
			aux2++;

			// Remover no Meio
			inicio = System.currentTimeMillis();
			lista.remove(lista.size() / 2);
			fim = System.currentTimeMillis();
			listaTestes[aux2] += (fim - inicio);
			aux2++;

			// Obter primeiro elemento
			inicio = System.currentTimeMillis();
			lista.get(0);
			fim = System.currentTimeMillis();
			listaTestes[aux2] += (fim - inicio);
			aux2++;

			// Obter ultimo elemento
			inicio = System.currentTimeMillis();
			lista.get(lista.size() - 1);
			fim = System.currentTimeMillis();
			listaTestes[aux2] += (fim - inicio);
			aux2++;

			// Obter elemento do meio
			inicio = System.currentTimeMillis();
			lista.get(lista.size() / 2);
			fim = System.currentTimeMillis();
			listaTestes[aux2] += (fim - inicio);
			aux2++;

			// Obter um elemento inexistente
			inicio = System.currentTimeMillis();
			lista.contains(-1);
			fim = System.currentTimeMillis();
			listaTestes[aux2] += (fim - inicio);
			aux2++;

			// Percorre totalmente a lista
			inicio = System.currentTimeMillis();
			for (int i = 0; i < lista.size(); i++) {

			}
			fim = System.currentTimeMillis();
			listaTestes[aux2] += (fim - inicio);
			aux2++;

			// Tempo para limpar a lista
			inicio = System.currentTimeMillis();
			lista.clear();
			fim = System.currentTimeMillis();
			listaTestes[aux2] += (fim - inicio);
			aux2++;
			contador++;
		}
		System.out.println("TESTE COM 20 MILH�ES\n\n");
		aux3 = 0;
		System.out.println(
				"O tempo de adi��o de 20 milh�es elementos � de: " + (listaTestes[aux3]) / 5 + " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para adi��o de um novo elemento no fim da lista � de: " + (listaTestes[aux3]) / 5
				+ " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para adi��o de um novo elemento no inicio da lista � de: " + (listaTestes[aux3]) / 5
				+ " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para adi��o de um novo elemento no meio da lista � de: " + (listaTestes[aux3]) / 5
				+ " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para remo��o de um elemento no final da lista � de: " + (listaTestes[aux3]) / 5
				+ " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para remo��o de um elemento no inicio da lista � de: " + (listaTestes[aux3]) / 5
				+ " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para remo��o de um elemento no meio da lista � de: " + (listaTestes[aux3]) / 5
				+ " milisegundos\n\n");
		aux3++;
		System.out.println(
				"O tempo para obter o primeiro numero da lista � de: " + (listaTestes[aux3]) / 5 + " milisegundos\n\n");
		aux3++;
		System.out.println(
				"O tempo para obter o ultimo numero da lista � de: " + (listaTestes[aux3]) / 5 + " milisegundos\n\n");
		aux3++;
		System.out.println(
				"O tempo para obter o numero do meio da lista � de: " + (listaTestes[aux3]) / 5 + " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para obter um elemento inexistente da tabela � de: " + (listaTestes[aux3]) / 5
				+ " milisegundos\n\n");
		aux3++;
		System.out.println(
				"O tempo para percorrer totalmente a lista � de: " + (listaTestes[aux3]) / 5 + " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo limpar a lista � de: " + (listaTestes[aux3]) / 5 + " milisegundos\n\n");

	}
}
