package tabelaHash;


public class TesteTempoTabelaHash {
	
	
	static TabelaHash<Integer, Integer> tabela = new TabelaHash<>(20000000);

	static double array_soma_testes[] = new double[6];
	static int cont = 0;

	public static void main(String[] args) {
		for (int i = 0; i < array_soma_testes.length; i++) { // zerando o vetor
			array_soma_testes[i] = 0;
		}
		while (cont != 5) {
			System.out.println("REPETE");
			int c = 0; // controle do teste
			// System.out.println("Inser��o de 20 mil elementos");
			long fim, inicio = System.currentTimeMillis();
			for (int i = 0; i < 19999; i++) {
				tabela.inserir(i,(i + 1));
			}
			fim = System.currentTimeMillis();
			array_soma_testes[c] += (fim - inicio);
			c++;
			// System.out.println(
			// "O tempo de adi��o de 20 mil elementos � de " + (fim - inicio) +
			// " milisegundos\n\n");

			inicio = System.nanoTime();

			tabela.inserir(0, 0);
			fim = System.nanoTime();
			array_soma_testes[c] += (fim - inicio);
			c++;
			// System.out.println("O tempo para adi��o de um novo elemento na
			// tabela � de " + (fim - inicio)
			// + " milisegundos\n\n");


			inicio = System.currentTimeMillis();
			tabela.remover(20000);
			fim = System.currentTimeMillis();
			array_soma_testes[c] += (fim - inicio);
			c++;
			// System.out.println("O tempo para remo��o de um elemento na tabela
			// � de " + (fim - inicio)
			// + " milisegundos\n\n");
			
			inicio = System.currentTimeMillis();
			tabela.buscar(10000);
			
			
			fim = System.currentTimeMillis();
			array_soma_testes[c] += (fim - inicio);
			c++; 
			// System.out.println(
			// "O tempo para obter um numero qualquer da tbela � de " + (fim -
			// inicio) + " milisegundos\n\n");

			
			inicio = System.currentTimeMillis();
			tabela.contem(-1); // valor que n�o tem no vetor para for�ar ele
							// percorrer
							// ou vetor espa�o por espa�o
			fim = System.currentTimeMillis();
			array_soma_testes[c] += (fim - inicio);
			c++;
			// System.out.println("O tempo para percorrer totalmente a tabela � de
			// " + (fim - inicio) + " milisegundos\n\n")
			
			inicio = System.nanoTime();
			tabela.limpar();
			fim = System.nanoTime();
			array_soma_testes[c] += (fim - inicio);
			c++;
			// System.out.println("O tempo limpar a tabela � de" + (fim - inicio)
			// + " milisegundos\n\n");
			cont++;
		}
		System.out.println("TESTE COM 20 MIL\n\n");
		int c = 0;
		System.out.println(
				"O tempo de adi��o de 20 mil elementos � de " + (array_soma_testes[c]) / 5 + " milisegundos\n\n");
		c++;
		System.out.println("O tempo para adi��o de um novo elemento � de " + (array_soma_testes[c]) / 5
				+ " nanosegundos\n\n");
		c++;
		System.out.println("O tempo para remo��o de um elemento � de " + (array_soma_testes[c]) / 5
				+ " milisegundos\n\n");
		c++;
		System.out.println("O tempo para obter um elemento qualquer � de " + (array_soma_testes[c]) / 5
				+ " milisegundos\n\n");
		c++;
		System.out.println(
				"O tempo para percorrer totalmente a tabela � de " + (array_soma_testes[c]) / 5 + " milisegundos\n\n");
		c++;
		System.out.println("O tempo limpar a tabela � de " + (array_soma_testes[c]) / 5 + " nanosegundos\n\n");
		
		
		
		
		
		
		
		
		for (int i = 0; i < array_soma_testes.length; i++) { // zerando o vetor
			array_soma_testes[i] = 0;
		}
		cont = 0;
		while (cont != 5) {
			System.out.println("REPETE");
			c = 0; // controle do teste
			// System.out.println("Inser��o de 200 mil elementos");
			long fim, inicio = System.currentTimeMillis();
			for (int i = 0; i < 199999; i++) {
				tabela.inserir(i,(i + 1));
			}
			fim = System.currentTimeMillis();
			array_soma_testes[c] += (fim - inicio);
			c++;
			// System.out.println(
			// "O tempo de adi��o de 200 mil elementos � de " + (fim - inicio) +
			// " milisegundos\n\n");

			inicio = System.nanoTime();

			tabela.inserir(0, 0);
			fim = System.nanoTime();
			array_soma_testes[c] += (fim - inicio);
			c++;
			// System.out.println("O tempo para adi��o de um novo elemento na
			// tabela � de " + (fim - inicio)
			// + " milisegundos\n\n");


			inicio = System.currentTimeMillis();
			tabela.remover(200000);
			fim = System.currentTimeMillis();
			array_soma_testes[c] += (fim - inicio);
			c++;
			// System.out.println("O tempo para remo��o de um elemento na tabela
			// � de " + (fim - inicio)
			// + " milisegundos\n\n");
			
			inicio = System.currentTimeMillis();
			tabela.buscar(100000);
			
			
			fim = System.currentTimeMillis();
			array_soma_testes[c] += (fim - inicio);
			c++; 
			// System.out.println(
			// "O tempo para obter um numero qualquer da tbela � de " + (fim -
			// inicio) + " milisegundos\n\n");

			
			inicio = System.currentTimeMillis();
			tabela.contem(-1); // valor que n�o tem no vetor para for�ar ele
							// percorrer
							// ou vetor espa�o por espa�o
			fim = System.currentTimeMillis();
			array_soma_testes[c] += (fim - inicio);
			c++;
			// System.out.println("O tempo para percorrer totalmente a tabela � de
			// " + (fim - inicio) + " milisegundos\n\n")
			
			inicio = System.nanoTime();
			tabela.limpar();
			fim = System.nanoTime();
			array_soma_testes[c] += (fim - inicio);
			c++;
			// System.out.println("O tempo limpar a tabela � de" + (fim - inicio)
			// + " milisegundos\n\n");
			cont++;
		}
		System.out.println("TESTE COM 200 MIL\n\n");
		c = 0;
		System.out.println(
				"O tempo de adi��o de 200 mil elementos � de " + (array_soma_testes[c]) / 5 + " milisegundos\n\n");
		c++;
		System.out.println("O tempo para adi��o de um novo elemento � de " + (array_soma_testes[c]) / 5
				+ " nanosegundos\n\n");
		c++;
		System.out.println("O tempo para remo��o de um elemento � de " + (array_soma_testes[c]) / 5
				+ " milisegundos\n\n");
		c++;
		System.out.println("O tempo para obter um elemento qualquer � de " + (array_soma_testes[c]) / 5
				+ " milisegundos\n\n");
		c++;
		System.out.println(
				"O tempo para percorrer totalmente a tabela � de " + (array_soma_testes[c]) / 5 + " milisegundos\n\n");
		c++;
		System.out.println("O tempo limpar a tabela � de " + (array_soma_testes[c]) / 5 + " nanosegundos\n\n");
		
		
		
		
		
		
		
		for (int i = 0; i < array_soma_testes.length; i++) { // zerando o vetor
			array_soma_testes[i] = 0;
		}
		cont = 0;
		while (cont != 5) {
			System.out.println("REPETE");
			c = 0; // controle do teste
			// System.out.println("Inser��o de 2 milh�es elementos");
			long fim, inicio = System.currentTimeMillis();
			for (int i = 0; i < 1999999; i++) {
				tabela.inserir(i,(i + 1));
			}
			fim = System.currentTimeMillis();
			array_soma_testes[c] += (fim - inicio);
			c++;
			// System.out.println(
			// "O tempo de adi��o de 2 milh�es elementos � de " + (fim - inicio) +
			// " milisegundos\n\n");

			inicio = System.nanoTime();

			tabela.inserir(0, 0);
			fim = System.nanoTime();
			array_soma_testes[c] += (fim - inicio);
			c++;
			// System.out.println("O tempo para adi��o de um novo elemento na
			// tabela � de " + (fim - inicio)
			// + " milisegundos\n\n");


			inicio = System.currentTimeMillis();
			tabela.remover(200000);
			fim = System.currentTimeMillis();
			array_soma_testes[c] += (fim - inicio);
			c++;
			// System.out.println("O tempo para remo��o de um elemento na tabela
			// � de " + (fim - inicio)
			// + " milisegundos\n\n");
			
			inicio = System.currentTimeMillis();
			tabela.buscar(100000);
			
			
			fim = System.currentTimeMillis();
			array_soma_testes[c] += (fim - inicio);
			c++; 
			// System.out.println(
			// "O tempo para obter um numero qualquer da tbela � de " + (fim -
			// inicio) + " milisegundos\n\n");

			
			inicio = System.currentTimeMillis();
			tabela.contem(-1); // valor que n�o tem no vetor para for�ar ele
							// percorrer
							// ou vetor espa�o por espa�o
			fim = System.currentTimeMillis();
			array_soma_testes[c] += (fim - inicio);
			c++;
			// System.out.println("O tempo para percorrer totalmente a tabela � de
			// " + (fim - inicio) + " milisegundos\n\n")
			
			inicio = System.nanoTime();
			tabela.limpar();
			fim = System.nanoTime();
			array_soma_testes[c] += (fim - inicio);
			c++;
			// System.out.println("O tempo limpar a tabela � de" + (fim - inicio)
			// + " milisegundos\n\n");
			cont++;
		}
		System.out.println("TESTE COM 2 MILH�ES\n\n");
		c = 0;
		System.out.println(
				"O tempo de adi��o de 2 milh�es elementos � de " + (array_soma_testes[c]) / 5 + " milisegundos\n\n");
		c++;
		System.out.println("O tempo para adi��o de um novo elemento � de " + (array_soma_testes[c]) / 5
				+ " nanosegundos\n\n");
		c++;
		System.out.println("O tempo para remo��o de um elemento � de " + (array_soma_testes[c]) / 5
				+ " milisegundos\n\n");
		c++;
		System.out.println("O tempo para obter um elemento qualquer � de " + (array_soma_testes[c]) / 5
				+ " milisegundos\n\n");
		c++;
		System.out.println(
				"O tempo para percorrer totalmente a tabela � de " + (array_soma_testes[c]) / 5 + " milisegundos\n\n");
		c++;
		System.out.println("O tempo limpar a tabela � de " + (array_soma_testes[c]) / 5 + " nanosegundos\n\n");
	
		
		
		
		
		
		
		
		
		
		for (int i = 0; i < array_soma_testes.length; i++) { // zerando o vetor
			array_soma_testes[i] = 0;
		}
		cont = 0;
		while (cont != 5) {
			System.out.println("REPETE");
			c = 0; // controle do teste
			// System.out.println("Inser��o de 20 milh�es elementos");
			long fim, inicio = System.currentTimeMillis();
			for (int i = 0; i < 19999999; i++) {
				tabela.inserir(i,(i + 1));
			}
			fim = System.currentTimeMillis();
			array_soma_testes[c] += (fim - inicio);
			c++;
			// System.out.println(
			// "O tempo de adi��o de 20 milh�es elementos � de " + (fim - inicio) +
			// " milisegundos\n\n");

			inicio = System.nanoTime();

			tabela.inserir(0, 0);
			fim = System.nanoTime();
			array_soma_testes[c] += (fim - inicio);
			c++;
			// System.out.println("O tempo para adi��o de um novo elemento na
			// tabela � de " + (fim - inicio)
			// + " milisegundos\n\n");


			inicio = System.currentTimeMillis();
			tabela.remover(200000);
			fim = System.currentTimeMillis();
			array_soma_testes[c] += (fim - inicio);
			c++;
			// System.out.println("O tempo para remo��o de um elemento na tabela
			// � de " + (fim - inicio)
			// + " milisegundos\n\n");
			
			inicio = System.currentTimeMillis();
			tabela.buscar(100000);
			
			
			fim = System.currentTimeMillis();
			array_soma_testes[c] += (fim - inicio);
			c++; 
			// System.out.println(
			// "O tempo para obter um numero qualquer da tbela � de " + (fim -
			// inicio) + " milisegundos\n\n");

			
			inicio = System.currentTimeMillis();
			tabela.contem(-1); // valor que n�o tem no vetor para for�ar ele
							// percorrer
							// ou vetor espa�o por espa�o
			fim = System.currentTimeMillis();
			array_soma_testes[c] += (fim - inicio);
			c++;
			// System.out.println("O tempo para percorrer totalmente a tabela � de
			// " + (fim - inicio) + " milisegundos\n\n")
			
			inicio = System.nanoTime();
			tabela.limpar();
			fim = System.nanoTime();
			array_soma_testes[c] += (fim - inicio);
			c++;
			// System.out.println("O tempo limpar a tabela � de" + (fim - inicio)
			// + " milisegundos\n\n");
			cont++;
		}
		System.out.println("TESTE COM 20 MILH�ES\n\n");
		c = 0;
		System.out.println(
				"O tempo de adi��o de 20 milh�es elementos � de " + (array_soma_testes[c]) / 5 + " milisegundos\n\n");
		c++;
		System.out.println("O tempo para adi��o de um novo elemento � de " + (array_soma_testes[c]) / 5
				+ " nanosegundos\n\n");
		c++;
		System.out.println("O tempo para remo��o de um elemento � de " + (array_soma_testes[c]) / 5
				+ " milisegundos\n\n");
		c++;
		System.out.println("O tempo para obter um elemento qualquer � de " + (array_soma_testes[c]) / 5
				+ " milisegundos\n\n");
		c++;
		System.out.println(
				"O tempo para percorrer totalmente a tabela � de " + (array_soma_testes[c]) / 5 + " milisegundos\n\n");
		c++;
		System.out.println("O tempo limpar a tabela � de " + (array_soma_testes[c]) / 5 + " nanosegundos\n\n");
		
		
		
		
		
	}	

}

