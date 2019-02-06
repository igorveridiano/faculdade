package testesDeTempo;

import java.util.TreeMap;

public class Arvore {
	public static void main(String[] args) {
		TreeMap<Integer, Integer> tabela = new TreeMap<>();
		double tabelaTestes[] = new double[7];
		int contador = 0;
		int aux1 = 10, aux2, aux3;
		long fim, inicio;

		// Zerando o vetor
		for (int i = 0; i < tabelaTestes.length; i++) {
			tabelaTestes[i] = 0;
		}

		while (contador != 5) {
			aux2 = 0; // controle do teste

			// Adição de 20 mil elementos
			inicio = System.currentTimeMillis();
			for (int i = 0; i < 20000; i++) {
				tabela.put(i, i);
			}
			fim = System.currentTimeMillis();
			tabelaTestes[aux2] += (fim - inicio);
			aux2++;

			// Adição de um elemento
			inicio = System.currentTimeMillis();
			tabela.put(aux1, aux1);
			fim = System.currentTimeMillis();
			tabelaTestes[aux2] += (fim - inicio);
			aux2++;

			// Obter um elemento qualquer
			inicio = System.currentTimeMillis();
			tabela.getOrDefault(aux1, aux1);
			fim = System.currentTimeMillis();
			tabelaTestes[aux2] += (fim - inicio);
			aux2++;

			// Obter um elemento inexistente
			inicio = System.currentTimeMillis();
			tabela.getOrDefault(-1, -1);
			fim = System.currentTimeMillis();
			tabelaTestes[aux2] += (fim - inicio);
			aux2++;

			// Remoção de um elemento qualquer
			inicio = System.currentTimeMillis();
			tabela.remove(aux1);
			fim = System.currentTimeMillis();
			tabelaTestes[aux2] += (fim - inicio);
			aux2++;

			// Percorre totalmente a tabela
			inicio = System.currentTimeMillis();
			tabela.containsKey(-1); // Passando uma chave que não existe para percorre a tabela inteira
			fim = System.currentTimeMillis();
			tabelaTestes[aux2] += (fim - inicio);
			aux2++;

			// Tempo para limpar a tabela
			inicio = System.currentTimeMillis();
			tabela.clear();
			fim = System.currentTimeMillis();
			tabelaTestes[aux2] += (fim - inicio);
			aux2++;
			contador++;
		}
		System.out.println("TESTE COM 20 MIL\n\n");
		aux3 = 0;
		System.out.println(
				"O tempo de adição de 20 mil elementos é de: " + (tabelaTestes[aux3]) / 5 + " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para adição de um novo elemento na tabela é de: " + (tabelaTestes[aux3]) / 5
				+ " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para obter um elemento qualquer da tabela é de: "
				+ (tabelaTestes[aux3]) / 5 + " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para obter um elemento inexistente da tabela é de: "
				+ (tabelaTestes[aux3]) / 5 + " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para remoção de um elemento qualquer da tabela é de: "
				+ (tabelaTestes[aux3]) / 5 + " milisegundos\n\n");
		aux3++;
		System.out.println(
				"O tempo para percorrer totalmente a tabela é de: " + (tabelaTestes[aux3]) / 5 + " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo limpar a tabela é de: " + (tabelaTestes[aux3]) / 5 + " milisegundos\n\n");

		// Zerando o vetor
		for (int i = 0; i < tabelaTestes.length; i++) {
			tabelaTestes[i] = 0;
		}

		contador = 0;

		while (contador != 5) {
			aux2 = 0; // controle do teste

			// Adição de 200 mil elementos
			inicio = System.currentTimeMillis();
			for (int i = 0; i < 200000; i++) {
				tabela.put(i, i);
			}
			fim = System.currentTimeMillis();
			tabelaTestes[aux2] += (fim - inicio);
			aux2++;

			// Adição de um elemento
			inicio = System.currentTimeMillis();
			tabela.put(aux1, aux1);
			fim = System.currentTimeMillis();
			tabelaTestes[aux2] += (fim - inicio);
			aux2++;

			// Obter um elemento qualquer 
			inicio = System.currentTimeMillis();
			tabela.get(aux1);
			fim = System.currentTimeMillis();
			tabelaTestes[aux2] += (fim - inicio);
			aux2++;

			// Obter um elemento inexistente
			inicio = System.currentTimeMillis();
			tabela.getOrDefault(-1, -1);
			fim = System.currentTimeMillis();
			tabelaTestes[aux2] += (fim - inicio);
			aux2++;

			// Remoção de um elemento qualquer
			inicio = System.currentTimeMillis();
			tabela.remove(aux1);
			fim = System.currentTimeMillis();
			tabelaTestes[aux2] += (fim - inicio);
			aux2++;

			// Percorre totalmente a tabela
			inicio = System.currentTimeMillis();
			tabela.containsKey(-1); // Passando uma chave que não existe para percorre a tabela inteira
			fim = System.currentTimeMillis();
			tabelaTestes[aux2] += (fim - inicio);
			aux2++;

			// Tempo para limpar a tabela
			inicio = System.currentTimeMillis();
			tabela.clear();
			fim = System.currentTimeMillis();
			tabelaTestes[aux2] += (fim - inicio);
			aux2++;
			contador++;
		}
		System.out.println("TESTE COM 200 MIL\n\n");
		aux3 = 0;
		System.out.println(
				"O tempo de adição de 200 mil elementos é de: " + (tabelaTestes[aux3]) / 5 + " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para adição de um novo elemento na tabela é de: " + (tabelaTestes[aux3]) / 5
				+ " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para obter um elemento qualquer da tabela é de: "
				+ (tabelaTestes[aux3]) / 5 + " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para obter um elemento inexistente da tabela é de: "
				+ (tabelaTestes[aux3]) / 5 + " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para remoção de um elemento qualquer da tabela é de: "
				+ (tabelaTestes[aux3]) / 5 + " milisegundos\n\n");
		aux3++;
		System.out.println(
				"O tempo para percorrer totalmente a tabela é de: " + (tabelaTestes[aux3]) / 5 + " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo limpar a tabela é de: " + (tabelaTestes[aux3]) / 5 + " milisegundos\n\n");

		// Zerando o vetor
		for (int i = 0; i < tabelaTestes.length; i++) {
			tabelaTestes[i] = 0;
		}

		contador = 0;

		while (contador != 5) {
			aux2 = 0; // controle do teste

			// Adição de 2 milhões elementos
			inicio = System.currentTimeMillis();
			for (int i = 0; i < 2000000; i++) {
				tabela.put(i, i);
			}
			fim = System.currentTimeMillis();
			tabelaTestes[aux2] += (fim - inicio);
			aux2++;

			// Adição de um elemento
			inicio = System.currentTimeMillis();
			tabela.put(aux1, aux1);
			fim = System.currentTimeMillis();
			tabelaTestes[aux2] += (fim - inicio);
			aux2++;

			// Obter um elemento qualquer
			inicio = System.currentTimeMillis();
			tabela.get(aux1);
			fim = System.currentTimeMillis();
			tabelaTestes[aux2] += (fim - inicio);
			aux2++;
			
			// Obter um elemento inexistente
			inicio = System.currentTimeMillis();
			tabela.getOrDefault(-1, -1);
			fim = System.currentTimeMillis();
			tabelaTestes[aux2] += (fim - inicio);
			aux2++;

			// Remoção de um elemento qualquer
			inicio = System.currentTimeMillis();
			tabela.remove(aux1);
			fim = System.currentTimeMillis();
			tabelaTestes[aux2] += (fim - inicio);
			aux2++;

			// Percorre totalmente a tabela
			inicio = System.currentTimeMillis();
			tabela.containsKey(-1); // Passando uma chave que não existe para percorre a tabela inteira
			fim = System.currentTimeMillis();
			tabelaTestes[aux2] += (fim - inicio);
			aux2++;

			// Tempo para limpar a tabela
			inicio = System.currentTimeMillis();
			tabela.clear();
			fim = System.currentTimeMillis();
			tabelaTestes[aux2] += (fim - inicio);
			aux2++;
			contador++;
		}
		System.out.println("TESTE COM 2 MILHÕES\n\n");
		aux3 = 0;
		System.out.println(
				"O tempo de adição de 2 milhões elementos é de: " + (tabelaTestes[aux3]) / 5 + " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para adição de um novo elemento na tabela é de: " + (tabelaTestes[aux3]) / 5
				+ " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para obter um elemento qualquer da tabela é de: "
				+ (tabelaTestes[aux3]) / 5 + " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para obter um elemento inexistente da tabela é de: "
				+ (tabelaTestes[aux3]) / 5 + " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para remoção de um elemento qualquer da tabela é de: "
				+ (tabelaTestes[aux3]) / 5 + " milisegundos\n\n");
		aux3++;
		System.out.println(
				"O tempo para percorrer totalmente a tabela é de: " + (tabelaTestes[aux3]) / 5 + " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo limpar a tabela é de: " + (tabelaTestes[aux3]) / 5 + " milisegundos\n\n");

		// Zerando o vetor
		for (int i = 0; i < tabelaTestes.length; i++) {
			tabelaTestes[i] = 0;
		}

		contador = 0;

		while (contador != 5) {
			aux2 = 0; // controle do teste

			// Adição de 20 milhões elementos
			inicio = System.currentTimeMillis();
			for (int i = 0; i < 20000000; i++) {
				tabela.put(i, i);
			}
			fim = System.currentTimeMillis();
			tabelaTestes[aux2] += (fim - inicio);
			aux2++;

			// Adição de um elemento
			inicio = System.currentTimeMillis();
			tabela.put(aux1, aux1);
			fim = System.currentTimeMillis();
			tabelaTestes[aux2] += (fim - inicio);
			aux2++;

			// Obter um elemento qualquer pela chave
			inicio = System.currentTimeMillis();
			tabela.get(aux1);
			fim = System.currentTimeMillis();
			tabelaTestes[aux2] += (fim - inicio);
			aux2++;
			
			// Obter um elemento inexistente
			inicio = System.currentTimeMillis();
			tabela.getOrDefault(-1, -1);
			fim = System.currentTimeMillis();
			tabelaTestes[aux2] += (fim - inicio);
			aux2++;

			// Remoção de um elemento qualquer
			inicio = System.currentTimeMillis();
			tabela.remove(aux1);
			fim = System.currentTimeMillis();
			tabelaTestes[aux2] += (fim - inicio);
			aux2++;

			// Percorre totalmente a tabela
			inicio = System.currentTimeMillis();
			tabela.containsKey(-1); // Passando uma chave que não existe para percorre a tabela inteira
			fim = System.currentTimeMillis();
			tabelaTestes[aux2] += (fim - inicio);
			aux2++;

			// Tempo para limpar a tabela
			inicio = System.currentTimeMillis();
			tabela.clear();
			fim = System.currentTimeMillis();
			tabelaTestes[aux2] += (fim - inicio);
			aux2++;
			contador++;
		}
		System.out.println("TESTE COM 20 MILHÕES\n\n");
		aux3 = 0;
		System.out.println(
				"O tempo de adição de 20 milhões elementos é de: " + (tabelaTestes[aux3]) / 5 + " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para adição de um novo elemento na tabela é de: " + (tabelaTestes[aux3]) / 5
				+ " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para obter um elemento qualquer da tabela é de: "
				+ (tabelaTestes[aux3]) / 5 + " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para obter um elemento inexistente da tabela é de: "
				+ (tabelaTestes[aux3]) / 5 + " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para remoção de um elemento qualquer da tabela é de: "
				+ (tabelaTestes[aux3]) / 5 + " milisegundos\n\n");
		aux3++;
		System.out.println(
				"O tempo para percorrer totalmente a tabela é de: " + (tabelaTestes[aux3]) / 5 + " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo limpar a tabela é de: " + (tabelaTestes[aux3]) / 5 + " milisegundos\n\n");
	}
}
