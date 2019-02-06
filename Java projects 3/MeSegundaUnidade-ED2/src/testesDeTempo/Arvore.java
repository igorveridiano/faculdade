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

			// Adi��o de 20 mil elementos
			inicio = System.currentTimeMillis();
			for (int i = 0; i < 20000; i++) {
				tabela.put(i, i);
			}
			fim = System.currentTimeMillis();
			tabelaTestes[aux2] += (fim - inicio);
			aux2++;

			// Adi��o de um elemento
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

			// Remo��o de um elemento qualquer
			inicio = System.currentTimeMillis();
			tabela.remove(aux1);
			fim = System.currentTimeMillis();
			tabelaTestes[aux2] += (fim - inicio);
			aux2++;

			// Percorre totalmente a tabela
			inicio = System.currentTimeMillis();
			tabela.containsKey(-1); // Passando uma chave que n�o existe para percorre a tabela inteira
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
				"O tempo de adi��o de 20 mil elementos � de: " + (tabelaTestes[aux3]) / 5 + " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para adi��o de um novo elemento na tabela � de: " + (tabelaTestes[aux3]) / 5
				+ " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para obter um elemento qualquer da tabela � de: "
				+ (tabelaTestes[aux3]) / 5 + " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para obter um elemento inexistente da tabela � de: "
				+ (tabelaTestes[aux3]) / 5 + " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para remo��o de um elemento qualquer da tabela � de: "
				+ (tabelaTestes[aux3]) / 5 + " milisegundos\n\n");
		aux3++;
		System.out.println(
				"O tempo para percorrer totalmente a tabela � de: " + (tabelaTestes[aux3]) / 5 + " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo limpar a tabela � de: " + (tabelaTestes[aux3]) / 5 + " milisegundos\n\n");

		// Zerando o vetor
		for (int i = 0; i < tabelaTestes.length; i++) {
			tabelaTestes[i] = 0;
		}

		contador = 0;

		while (contador != 5) {
			aux2 = 0; // controle do teste

			// Adi��o de 200 mil elementos
			inicio = System.currentTimeMillis();
			for (int i = 0; i < 200000; i++) {
				tabela.put(i, i);
			}
			fim = System.currentTimeMillis();
			tabelaTestes[aux2] += (fim - inicio);
			aux2++;

			// Adi��o de um elemento
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

			// Remo��o de um elemento qualquer
			inicio = System.currentTimeMillis();
			tabela.remove(aux1);
			fim = System.currentTimeMillis();
			tabelaTestes[aux2] += (fim - inicio);
			aux2++;

			// Percorre totalmente a tabela
			inicio = System.currentTimeMillis();
			tabela.containsKey(-1); // Passando uma chave que n�o existe para percorre a tabela inteira
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
				"O tempo de adi��o de 200 mil elementos � de: " + (tabelaTestes[aux3]) / 5 + " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para adi��o de um novo elemento na tabela � de: " + (tabelaTestes[aux3]) / 5
				+ " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para obter um elemento qualquer da tabela � de: "
				+ (tabelaTestes[aux3]) / 5 + " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para obter um elemento inexistente da tabela � de: "
				+ (tabelaTestes[aux3]) / 5 + " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para remo��o de um elemento qualquer da tabela � de: "
				+ (tabelaTestes[aux3]) / 5 + " milisegundos\n\n");
		aux3++;
		System.out.println(
				"O tempo para percorrer totalmente a tabela � de: " + (tabelaTestes[aux3]) / 5 + " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo limpar a tabela � de: " + (tabelaTestes[aux3]) / 5 + " milisegundos\n\n");

		// Zerando o vetor
		for (int i = 0; i < tabelaTestes.length; i++) {
			tabelaTestes[i] = 0;
		}

		contador = 0;

		while (contador != 5) {
			aux2 = 0; // controle do teste

			// Adi��o de 2 milh�es elementos
			inicio = System.currentTimeMillis();
			for (int i = 0; i < 2000000; i++) {
				tabela.put(i, i);
			}
			fim = System.currentTimeMillis();
			tabelaTestes[aux2] += (fim - inicio);
			aux2++;

			// Adi��o de um elemento
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

			// Remo��o de um elemento qualquer
			inicio = System.currentTimeMillis();
			tabela.remove(aux1);
			fim = System.currentTimeMillis();
			tabelaTestes[aux2] += (fim - inicio);
			aux2++;

			// Percorre totalmente a tabela
			inicio = System.currentTimeMillis();
			tabela.containsKey(-1); // Passando uma chave que n�o existe para percorre a tabela inteira
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
		System.out.println("TESTE COM 2 MILH�ES\n\n");
		aux3 = 0;
		System.out.println(
				"O tempo de adi��o de 2 milh�es elementos � de: " + (tabelaTestes[aux3]) / 5 + " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para adi��o de um novo elemento na tabela � de: " + (tabelaTestes[aux3]) / 5
				+ " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para obter um elemento qualquer da tabela � de: "
				+ (tabelaTestes[aux3]) / 5 + " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para obter um elemento inexistente da tabela � de: "
				+ (tabelaTestes[aux3]) / 5 + " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para remo��o de um elemento qualquer da tabela � de: "
				+ (tabelaTestes[aux3]) / 5 + " milisegundos\n\n");
		aux3++;
		System.out.println(
				"O tempo para percorrer totalmente a tabela � de: " + (tabelaTestes[aux3]) / 5 + " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo limpar a tabela � de: " + (tabelaTestes[aux3]) / 5 + " milisegundos\n\n");

		// Zerando o vetor
		for (int i = 0; i < tabelaTestes.length; i++) {
			tabelaTestes[i] = 0;
		}

		contador = 0;

		while (contador != 5) {
			aux2 = 0; // controle do teste

			// Adi��o de 20 milh�es elementos
			inicio = System.currentTimeMillis();
			for (int i = 0; i < 20000000; i++) {
				tabela.put(i, i);
			}
			fim = System.currentTimeMillis();
			tabelaTestes[aux2] += (fim - inicio);
			aux2++;

			// Adi��o de um elemento
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

			// Remo��o de um elemento qualquer
			inicio = System.currentTimeMillis();
			tabela.remove(aux1);
			fim = System.currentTimeMillis();
			tabelaTestes[aux2] += (fim - inicio);
			aux2++;

			// Percorre totalmente a tabela
			inicio = System.currentTimeMillis();
			tabela.containsKey(-1); // Passando uma chave que n�o existe para percorre a tabela inteira
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
		System.out.println("TESTE COM 20 MILH�ES\n\n");
		aux3 = 0;
		System.out.println(
				"O tempo de adi��o de 20 milh�es elementos � de: " + (tabelaTestes[aux3]) / 5 + " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para adi��o de um novo elemento na tabela � de: " + (tabelaTestes[aux3]) / 5
				+ " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para obter um elemento qualquer da tabela � de: "
				+ (tabelaTestes[aux3]) / 5 + " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para obter um elemento inexistente da tabela � de: "
				+ (tabelaTestes[aux3]) / 5 + " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo para remo��o de um elemento qualquer da tabela � de: "
				+ (tabelaTestes[aux3]) / 5 + " milisegundos\n\n");
		aux3++;
		System.out.println(
				"O tempo para percorrer totalmente a tabela � de: " + (tabelaTestes[aux3]) / 5 + " milisegundos\n\n");
		aux3++;
		System.out.println("O tempo limpar a tabela � de: " + (tabelaTestes[aux3]) / 5 + " milisegundos\n\n");
	}
}
