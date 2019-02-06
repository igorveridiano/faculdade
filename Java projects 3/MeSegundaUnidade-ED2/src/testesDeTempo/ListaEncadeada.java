package testesDeTempo;

import java.util.LinkedList;

public class ListaEncadeada {
	public static void main(String[] args) {
		LinkedList<Integer> lista = new LinkedList<>();
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

			// Adição de 20 mil elementos
			inicio = System.currentTimeMillis();
			for (int i = 0; i < 20000; i++) {
				lista.add(i);
			}
			fim = System.currentTimeMillis();
			listaTestes[aux2] += (fim - inicio);
			aux2++;

			// Adição de um elemento
			inicio = System.currentTimeMillis();
			lista.add(aux1);
			fim = System.currentTimeMillis();
			listaTestes[aux2] += (fim - inicio);
			aux2++;

			// Adição no Inicio
			inicio = System.currentTimeMillis();
			lista.addFirst(aux1);
			fim = System.currentTimeMillis();
			listaTestes[aux2] += (fim - inicio);
			aux2++;

			// Adição no Meio
			inicio = System.currentTimeMillis();
			lista.add(lista.size() / 2, aux1);
			fim = System.currentTimeMillis();
			listaTestes[aux2] += (fim - inicio);
			aux2++;

			// Remoção no Fim
			inicio = System.currentTimeMillis();
			lista.removeLast();
			fim = System.currentTimeMillis();
			listaTestes[aux2] += (fim - inicio);
			aux2++;

			// Remover do Inicio
			inicio = System.currentTimeMillis();
			lista.removeFirst();
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
			lista.getFirst();
			fim = System.currentTimeMillis();
			listaTestes[aux2] += (fim - inicio);
			aux2++;

			// Obter ultimo elemento
			inicio = System.currentTimeMillis();
			lista.getLast();
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
				"O tempo de adição de 20 mil elementos é de: " + (listaTestes[aux3]) / 5 + " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para adição de um novo elemento no fim da lista é de: " + (listaTestes[aux3]) / 5
				+ " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para adição de um novo elemento no inicio da lista é de: " + (listaTestes[aux3]) / 5
				+ " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para adição de um novo elemento no meio da lista é de: " + (listaTestes[aux3]) / 5
				+ " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para remoção de um elemento no final da lista é de: " + (listaTestes[aux3]) / 5
				+ " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para remoção de um elemento no inicio da lista é de: " + (listaTestes[aux3]) / 5
				+ " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para remoção de um elemento no meio da lista é de: " + (listaTestes[aux3]) / 5
				+ " milisegundos\n\n");
		aux3++;
		System.out.println(
				"O tempo para obter o primeiro numero da lista é de: " + (listaTestes[aux3]) / 5 + " milisegundos\n\n");
		aux3++;
		System.out.println(
				"O tempo para obter o ultimo numero da lista é de: " + (listaTestes[aux3]) / 5 + " milisegundos\n\n");
		aux3++;
		System.out.println(
				"O tempo para obter o numero do meio da lista é de: " + (listaTestes[aux3]) / 5 + " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para obter um elemento inexistente da tabela é de: " + (listaTestes[aux3]) / 5
				+ " milisegundos\n\n");
		aux3++;
		System.out.println(
				"O tempo para percorrer totalmente a lista é de: " + (listaTestes[aux3]) / 5 + " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo limpar a lista é de: " + (listaTestes[aux3]) / 5 + " milisegundos\n\n");

		// Zerando o vetor
		for (int i = 0; i < listaTestes.length; i++) {
			listaTestes[i] = 0;
		}

		contador = 0;

		while (contador != 5) {
			aux2 = 0; // controle do teste

			// Adição de 200 mil elementos
			inicio = System.currentTimeMillis();
			for (int i = 0; i < 200000; i++) {
				lista.add(i);
			}
			fim = System.currentTimeMillis();
			listaTestes[aux2] += (fim - inicio);
			aux2++;

			// Adição de um elemento
			inicio = System.currentTimeMillis();
			lista.add(aux1);
			fim = System.currentTimeMillis();
			listaTestes[aux2] += (fim - inicio);
			aux2++;

			// Adição no Inicio
			inicio = System.currentTimeMillis();
			lista.addFirst(aux1);
			fim = System.currentTimeMillis();
			listaTestes[aux2] += (fim - inicio);
			aux2++;

			// Adição no Meio
			inicio = System.currentTimeMillis();
			lista.add(lista.size() / 2, aux1);
			fim = System.currentTimeMillis();
			listaTestes[aux2] += (fim - inicio);
			aux2++;

			// Remoção no Fim
			inicio = System.currentTimeMillis();
			lista.removeLast();
			fim = System.currentTimeMillis();
			listaTestes[aux2] += (fim - inicio);
			aux2++;

			// Remover do Inicio
			inicio = System.currentTimeMillis();
			lista.removeFirst();
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
			lista.getFirst();
			fim = System.currentTimeMillis();
			listaTestes[aux2] += (fim - inicio);
			aux2++;

			// Obter ultimo elemento
			inicio = System.currentTimeMillis();
			lista.getLast();
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
				"O tempo de adição de 200 mil elementos é de: " + (listaTestes[aux3]) / 5 + " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para adição de um novo elemento no fim da lista é de: " + (listaTestes[aux3]) / 5
				+ " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para adição de um novo elemento no inicio da lista é de: " + (listaTestes[aux3]) / 5
				+ " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para adição de um novo elemento no meio da lista é de: " + (listaTestes[aux3]) / 5
				+ " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para remoção de um elemento no final da lista é de: " + (listaTestes[aux3]) / 5
				+ " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para remoção de um elemento no inicio da lista é de: " + (listaTestes[aux3]) / 5
				+ " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para remoção de um elemento no meio da lista é de: " + (listaTestes[aux3]) / 5
				+ " milisegundos\n\n");
		aux3++;
		System.out.println(
				"O tempo para obter o primeiro numero da lista é de: " + (listaTestes[aux3]) / 5 + " milisegundos\n\n");
		aux3++;
		System.out.println(
				"O tempo para obter o ultimo numero da lista é de: " + (listaTestes[aux3]) / 5 + " milisegundos\n\n");
		aux3++;
		System.out.println(
				"O tempo para obter o numero do meio da lista é de: " + (listaTestes[aux3]) / 5 + " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para obter um elemento inexistente da tabela é de: " + (listaTestes[aux3]) / 5
				+ " milisegundos\n\n");
		aux3++;
		System.out.println(
				"O tempo para percorrer totalmente a lista é de: " + (listaTestes[aux3]) / 5 + " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo limpar a lista é de: " + (listaTestes[aux3]) / 5 + " milisegundos\n\n");

		// Zerando o vetor
		for (int i = 0; i < listaTestes.length; i++) {
			listaTestes[i] = 0;
		}

		contador = 0;

		while (contador != 5) {
			aux2 = 0; // controle do teste

			// Adição de 2 milhões elementos
			inicio = System.currentTimeMillis();
			for (int i = 0; i < 2000000; i++) {
				lista.add(i);
			}
			fim = System.currentTimeMillis();
			listaTestes[aux2] += (fim - inicio);
			aux2++;

			// Adição de um elemento
			inicio = System.currentTimeMillis();
			lista.add(aux1);
			fim = System.currentTimeMillis();
			listaTestes[aux2] += (fim - inicio);
			aux2++;

			// Adição no Inicio
			inicio = System.currentTimeMillis();
			lista.addFirst(aux1);
			fim = System.currentTimeMillis();
			listaTestes[aux2] += (fim - inicio);
			aux2++;

			// Adição no Meio
			inicio = System.currentTimeMillis();
			lista.add(lista.size() / 2, aux1);
			fim = System.currentTimeMillis();
			listaTestes[aux2] += (fim - inicio);
			aux2++;

			// Remoção no Fim
			inicio = System.currentTimeMillis();
			lista.removeLast();
			fim = System.currentTimeMillis();
			listaTestes[aux2] += (fim - inicio);
			aux2++;

			// Remover do Inicio
			inicio = System.currentTimeMillis();
			lista.removeFirst();
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
			lista.getFirst();
			fim = System.currentTimeMillis();
			listaTestes[aux2] += (fim - inicio);
			aux2++;

			// Obter ultimo elemento
			inicio = System.currentTimeMillis();
			lista.getLast();
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
		System.out.println("TESTE COM 2 MILHÕES\n\n");
		aux3 = 0;
		System.out.println(
				"O tempo de adição de 2 milhões elementos é de: " + (listaTestes[aux3]) / 5 + " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para adição de um novo elemento no fim da lista é de: " + (listaTestes[aux3]) / 5
				+ " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para adição de um novo elemento no inicio da lista é de: " + (listaTestes[aux3]) / 5
				+ " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para adição de um novo elemento no meio da lista é de: " + (listaTestes[aux3]) / 5
				+ " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para remoção de um elemento no final da lista é de: " + (listaTestes[aux3]) / 5
				+ " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para remoção de um elemento no inicio da lista é de: " + (listaTestes[aux3]) / 5
				+ " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para remoção de um elemento no meio da lista é de: " + (listaTestes[aux3]) / 5
				+ " milisegundos\n\n");
		aux3++;
		System.out.println(
				"O tempo para obter o primeiro numero da lista é de: " + (listaTestes[aux3]) / 5 + " milisegundos\n\n");
		aux3++;
		System.out.println(
				"O tempo para obter o ultimo numero da lista é de: " + (listaTestes[aux3]) / 5 + " milisegundos\n\n");
		aux3++;
		System.out.println(
				"O tempo para obter o numero do meio da lista é de: " + (listaTestes[aux3]) / 5 + " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para obter um elemento inexistente da tabela é de: " + (listaTestes[aux3]) / 5
				+ " milisegundos\n\n");
		aux3++;
		System.out.println(
				"O tempo para percorrer totalmente a lista é de: " + (listaTestes[aux3]) / 5 + " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo limpar a lista é de: " + (listaTestes[aux3]) / 5 + " milisegundos\n\n");

		// Zerando o vetor
		for (int i = 0; i < listaTestes.length; i++) {
			listaTestes[i] = 0;
		}

		contador = 0;

		while (contador != 5) {
			aux2 = 0; // controle do teste

			// Adição de 20 milhões elementos
			inicio = System.currentTimeMillis();
			for (int i = 0; i < 20000000; i++) {
				lista.add(i);
			}
			fim = System.currentTimeMillis();
			listaTestes[aux2] += (fim - inicio);
			aux2++;

			// Adição de um elemento
			inicio = System.currentTimeMillis();
			lista.add(aux1);
			fim = System.currentTimeMillis();
			listaTestes[aux2] += (fim - inicio);
			aux2++;

			// Adição no Inicio
			inicio = System.currentTimeMillis();
			lista.addFirst(aux1);
			fim = System.currentTimeMillis();
			listaTestes[aux2] += (fim - inicio);
			aux2++;

			// Adição no Meio
			inicio = System.currentTimeMillis();
			lista.add(lista.size() / 2, aux1);
			fim = System.currentTimeMillis();
			listaTestes[aux2] += (fim - inicio);
			aux2++;

			// Remoção no Fim
			inicio = System.currentTimeMillis();
			lista.removeLast();
			fim = System.currentTimeMillis();
			listaTestes[aux2] += (fim - inicio);
			aux2++;

			// Remover do Inicio
			inicio = System.currentTimeMillis();
			lista.removeFirst();
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
			lista.getFirst();
			fim = System.currentTimeMillis();
			listaTestes[aux2] += (fim - inicio);
			aux2++;

			// Obter ultimo elemento
			inicio = System.currentTimeMillis();
			lista.getLast();
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
		System.out.println("TESTE COM 20 MILHÕES\n\n");
		aux3 = 0;
		System.out.println(
				"O tempo de adição de 20 milhões elementos é de: " + (listaTestes[aux3]) / 5 + " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para adição de um novo elemento no fim da lista é de: " + (listaTestes[aux3]) / 5
				+ " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para adição de um novo elemento no inicio da lista é de: " + (listaTestes[aux3]) / 5
				+ " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para adição de um novo elemento no meio da lista é de: " + (listaTestes[aux3]) / 5
				+ " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para remoção de um elemento no final da lista é de: " + (listaTestes[aux3]) / 5
				+ " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para remoção de um elemento no inicio da lista é de: " + (listaTestes[aux3]) / 5
				+ " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para remoção de um elemento no meio da lista é de: " + (listaTestes[aux3]) / 5
				+ " milisegundos\n\n");
		aux3++;
		System.out.println(
				"O tempo para obter o primeiro numero da lista é de: " + (listaTestes[aux3]) / 5 + " milisegundos\n\n");
		aux3++;
		System.out.println(
				"O tempo para obter o ultimo numero da lista é de: " + (listaTestes[aux3]) / 5 + " milisegundos\n\n");
		aux3++;
		System.out.println(
				"O tempo para obter o numero do meio da lista é de: " + (listaTestes[aux3]) / 5 + " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para obter um elemento inexistente da tabela é de: " + (listaTestes[aux3]) / 5
				+ " milisegundos\n\n");
		aux3++;
		System.out.println(
				"O tempo para percorrer totalmente a lista é de: " + (listaTestes[aux3]) / 5 + " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo limpar a lista é de: " + (listaTestes[aux3]) / 5 + " milisegundos\n\n");

	}

}
