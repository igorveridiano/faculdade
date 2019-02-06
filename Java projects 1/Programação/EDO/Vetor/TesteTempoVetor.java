package Vetor;

public class TesteTempoVetor {
	static Vetor<Integer> vet = new Vetor<>();
	static double array_soma_testes[] = new double[13];
	static int cont = 0;
	

	public static void main(String[] args) {
		for (int i = 0; i < array_soma_testes.length; i++) { // zerando o vetor
			array_soma_testes[i] = 0;
		}
		while (cont != 3) {
			System.out.println("Repetiu");
			int c = 0; // controle do teste
			// System.out.println("Inserção de 20 mil elementos");
			long fim, inicio = System.nanoTime();
			for (int i = 0; i < 19999; i++) {
				vet.adicionar(i + 1);
			}
			fim = System.nanoTime();
			array_soma_testes[c] += (fim - inicio);
			c++;
			// System.out.println(
			// "O tempo de adição de 20 mil elementos é de " + (fim - inicio) +
			// " nanosegundos\n\n");

			inicio = System.nanoTime();

			vet.adicionar(0);
			fim = System.nanoTime();
			array_soma_testes[c] += (fim - inicio);
			c++;
			// System.out.println("O tempo para adição de um novo elemento no
			// fim do vetor é de " + (fim - inicio)
			// + " nanosegundos\n\n");
			//
			//
			//
			//
			//
			//
			//
			//
			 inicio = System.nanoTime();
//			
			 vet.adicionar(0, 3);
			 fim=System.nanoTime();
			array_soma_testes [c]+=(fim - inicio);
			c++;
			//System.out.println("O tempo para adição de um novo elemento no
			//início do vetor é de "+(fim - inicio) / 1000 + "
			// microsegundos\n\n");
			//
			//
			//
			//
			//
			//
			//
			//
			//

			inicio = System.nanoTime();

			vet.adicionar(10000, 0);
			fim = System.nanoTime();
			array_soma_testes[c] += (fim - inicio);
			c++;
			// System.out.println("O tempo para adição de um novo elemento no
			// meio do vetor é de " + (fim - inicio)
			// + " nanosegundos\n\n");

			inicio = System.nanoTime();
			vet.remover(vet.tamanho() - 1);
			fim = System.nanoTime();
			array_soma_testes[c] += (fim - inicio);
			c++;
			// System.out.println("O tempo para remoção de um elemento no final
			// do vetor é de " + (fim - inicio)
			// + " nanosegundos\n\n");

			inicio = System.nanoTime();
		
			vet.remover(0);
			fim = System.nanoTime();
			array_soma_testes[c] += (fim - inicio);
			c++;
			// System.out.println("O tempo para remoção de um elemento no inicio
			// do vetor é de " + (fim - inicio)
			// + " nanosegundos\n\n");

			inicio = System.nanoTime();
			vet.remover(10000);
			fim = System.nanoTime();
			array_soma_testes[c] += (fim - inicio);
			c++;
			// System.out.println("O tempo para remoção de um elemento no meio
			// do vetor é de " + (fim - inicio)
			// + " nanosegundos\n\n");

			inicio = System.nanoTime();
			vet.obter(0);
			fim = System.nanoTime();
			array_soma_testes[c] += (fim - inicio);
			c++;
			// System.out.println(
			// "O tempo para obter o primeiro numero do vetor é de " + (fim -
			// inicio) + " nanosegundos\n\n");

			inicio = System.nanoTime();
			vet.obter(vet.tamanho() - 1);
			fim = System.nanoTime();
			array_soma_testes[c] += (fim - inicio);
			c++;
			// System.out.println(
			// "O tempo para obter o ultimo numero do vetor é de " + (fim -
			// inicio) + " nanosegundos\n\n");
			//
			//
			//
			//
			inicio = System.nanoTime();
			 vet.obter(10000);
			 fim = System.nanoTime();
			 array_soma_testes [c]+=(fim - inicio);
			c++;
			// System.out.println("O tempo para obter o numero do meio do vetor
			// é de" + (fim - inicio) / 1000 + " microsegundos\n\n");
			//
			//
			//
			//
			//
			//
			//
			//
			//
			inicio = System.nanoTime();
			vet.contem(-1); // valor que não tem no vetor para forçar ele
							// percorrer
							// ou vetor espaço por espaço
			fim = System.nanoTime();
			array_soma_testes[c] += (fim - inicio);
			c++;
			// System.out.println("O tempo para percorrer totalmente o veto é de
			// " + (fim - inicio) + " nanosegundos\n\n");

			inicio = System.nanoTime();
			vet.limpar();
			fim = System.nanoTime();
			array_soma_testes[c] += (fim - inicio);
			c++;
			// System.out.println("O tempo limpar o vetor é de" + (fim - inicio)
			// + " nanosegundos\n\n");
			cont++;
		}
		System.out.println("TESTE COM 20 MIL\n\n");
		int c = 0;
		System.out.println(
				"O tempo de adição de 20 mil elementos é de " + (array_soma_testes[c]) / 3 + " nanosegundos\n\n");
		c++;
		System.out.println("O tempo para adição de um novo elemento no fim do vetor é de " + (array_soma_testes[c]) / 3
				+ " nanosegundos\n\n");
		c++;
		System.out.println("O tempo para adição de um novo elemento no inicio do vetor é de "
				+ (array_soma_testes[c]) / 3 + " nanosegundos\n\n");
		c++;
		System.out.println("O tempo para adição de um novo elemento no meio do vetor é de " + (array_soma_testes[c]) / 3
				+ " nanosegundos\n\n");
		c++;
		System.out.println("O tempo para remoção de um elemento no final do vetor é de " + (array_soma_testes[c]) / 3
				+ " nanosegundos\n\n");
		c++;
		System.out.println("O tempo para remoção de um elemento no inicio do vetor é de " + (array_soma_testes[c]) / 3
				+ " nanosegundos\n\n");
		c++;
		System.out.println("O tempo para remoção de um elemento no meio do vetor é de " + (array_soma_testes[c]) / 3
				+ " nanosegundos\n\n");
		c++;
		System.out.println("O tempo para obter o primeiro numero do vetor é de " + (array_soma_testes[c]) / 3
				+ " nanosegundos\n\n");
		c++;
		System.out.println(
				"O tempo para obter o ultimo numero do vetor é de " + (array_soma_testes[c]) / 3 + " nanosegundos\n\n");
		c++;
		System.out.println("O tempo para obter o numero do meio do vetor é de " + (array_soma_testes[c]) / 3
				+ " nanosegundos\n\n");
		c++;

		System.out.println(
				"O tempo para percorrer totalmente o vetor é de " + (array_soma_testes[c]) / 3 + " nanosegundos\n\n");
		c++;

		System.out.println("O tempo limpar o vetor é de" + (array_soma_testes[c]) / 3 + " nanosegundos\n\n");
		//
		//
		//
		//
		//
		//
		//
		//
		//
		//
		cont=0;
		for (int i = 0; i < array_soma_testes.length; i++) { // zerando o vetor
			array_soma_testes[i] = 0;
		}
		while (cont != 3) {
			c = 0; // controle do teste
			// System.out.println("Inserção de 200 mil elementos");
			long fim, inicio = System.nanoTime();
			for (int i = 0; i < 199999; i++) {
				vet.adicionar(i + 1);
			}
			fim = System.nanoTime();
			array_soma_testes[c] += (fim - inicio);
			c++;
			// System.out.println(
			// "O tempo de adição de 200 mil elementos é de " + (fim - inicio) +
			// " nanosegundos\n\n");

			inicio = System.nanoTime();

			vet.adicionar(0);
			fim = System.nanoTime();
			array_soma_testes[c] += (fim - inicio);
			c++;
			// System.out.println("O tempo para adição de um novo elemento no
			// fim do vetor é de " + (fim - inicio)
			// + " nanosegundos\n\n");
			//
			//
			//
			//
			//
			//
			//
			//
			 inicio = System.nanoTime();
			
			 vet.adicionar(0, 3);
			 fim=System.nanoTime();
			 array_soma_testes [c]+=(fim - inicio);
			c++;
			// System.out.println("O tempo para adição de um novo elemento no
			// início do vetor é de "+(fim - inicio) / 1000 + "
			// microsegundos\n\n");
			//
			//
			//
			//
			//
			//
			//
			//
			//

			inicio = System.nanoTime();

			vet.adicionar(100000, 0);
			fim = System.nanoTime();
			array_soma_testes[c] += (fim - inicio);
			c++;
			// System.out.println("O tempo para adição de um novo elemento no
			// meio do vetor é de " + (fim - inicio)
			// + " nanosegundos\n\n");

			inicio = System.nanoTime();
			vet.remover(vet.tamanho() - 1);
			fim = System.nanoTime();
			array_soma_testes[c] += (fim - inicio);
			c++;
			// System.out.println("O tempo para remoção de um elemento no final
			// do vetor é de " + (fim - inicio)
			// + " nanosegundos\n\n");

			inicio = System.nanoTime();
			System.out.println("Repetiu");
			vet.remover(0);
			fim = System.nanoTime();
			array_soma_testes[c] += (fim - inicio);
			c++;
			// System.out.println("O tempo para remoção de um elemento no inicio
			// do vetor é de " + (fim - inicio)
			// + " nanosegundos\n\n");

			inicio = System.nanoTime();
			vet.remover(100000);
			fim = System.nanoTime();
			array_soma_testes[c] += (fim - inicio);
			c++;
			// System.out.println("O tempo para remoção de um elemento no meio
			// do vetor é de " + (fim - inicio)
			// + " nanosegundos\n\n");

			inicio = System.nanoTime();
			vet.obter(0);
			fim = System.nanoTime();
			array_soma_testes[c] += (fim - inicio);
			c++;
			// System.out.println(
			// "O tempo para obter o primeiro numero do vetor é de " + (fim -
			// inicio) + " nanosegundos\n\n");

			inicio = System.nanoTime();
			vet.obter(vet.tamanho() - 1);
			fim = System.nanoTime();
			array_soma_testes[c] += (fim - inicio);
			c++;
			// System.out.println(
			// "O tempo para obter o ultimo numero do vetor é de " + (fim -
			// inicio) + " nanosegundos\n\n");
			//
			//
			//
			//
			inicio = System.nanoTime();
			vet.obter(100000);
			fim = System.nanoTime();
			 array_soma_testes [c]+=(fim - inicio);
			c++;
			// System.out.println("O tempo para obter o numero do meio do vetor
			// é de" + (fim - inicio) / 1000 + " microsegundos\n\n");
			//
			//
			//
			//
			//
			//
			//
			//
			//
			inicio = System.nanoTime();
			vet.contem(-1); // valor que não tem no vetor para forçar ele
							// percorrer
							// ou vetor espaço por espaço
			fim = System.nanoTime();
			array_soma_testes[c] += (fim - inicio);
			c++;
			// System.out.println("O tempo para percorrer totalmente o veto é de
			// " + (fim - inicio) + " nanosegundos\n\n");

			inicio = System.nanoTime();
			vet.limpar();
			fim = System.nanoTime();
			array_soma_testes[c] += (fim - inicio);
			c++;
			// System.out.println("O tempo limpar o vetor é de" + (fim - inicio)
			// + " nanosegundos\n\n");
			cont++;
		}
		System.out.println("TESTE COM 200 MIL\n\n");
		
		c = 0;
		System.out.println(
				"O tempo de adição de 200 mil elementos é de " + (array_soma_testes[c]) / 3 + " nanosegundos\n\n");
		c++;
		System.out.println("O tempo para adição de um novo elemento no fim do vetor é de " + (array_soma_testes[c]) / 3
				+ " nanosegundos\n\n");
		c++;
		System.out.println("O tempo para adição de um novo elemento no inicio do vetor é de "
				+ (array_soma_testes[c]) / 3 + " nanosegundos\n\n");
		c++;
		System.out.println("O tempo para adição de um novo elemento no meio do vetor é de " + (array_soma_testes[c]) / 3
				+ " nanosegundos\n\n");
		c++;
		System.out.println("O tempo para remoção de um elemento no final do vetor é de " + (array_soma_testes[c]) / 3
				+ " nanosegundos\n\n");
		c++;
		System.out.println("O tempo para remoção de um elemento no inicio do vetor é de " + (array_soma_testes[c]) / 3
				+ " nanosegundos\n\n");
		c++;
		System.out.println("O tempo para remoção de um elemento no meio do vetor é de " + (array_soma_testes[c]) / 3
				+ " nanosegundos\n\n");
		c++;
		System.out.println("O tempo para obter o primeiro numero do vetor é de " + (array_soma_testes[c]) / 3
				+ " nanosegundos\n\n");
		c++;
		System.out.println(
				"O tempo para obter o ultimo numero do vetor é de " + (array_soma_testes[c]) / 3 + " nanosegundos\n\n");
		c++;
		System.out.println("O tempo para obter o numero do meio do vetor é de " + (array_soma_testes[c]) / 3
				+ " nanosegundos\n\n");
		c++;

		System.out.println(
				"O tempo para percorrer totalmente o vetor é de " + (array_soma_testes[c]) / 3 + " nanosegundos\n\n");
		c++;

		System.out.println("O tempo limpar o vetor é de" + (array_soma_testes[c]) / 3 + " nanosegundos\n\n");
		
		
		
		cont=0;
		for (int i = 0; i < array_soma_testes.length; i++) { // zerando o vetor
			array_soma_testes[i] = 0;
		}
		while (cont != 3) {
			System.out.println("Repetiu");
			c = 0; // controle do teste
			// System.out.println("Inserção de 2 milhões elementos");
			long fim, inicio = System.nanoTime();
			for (int i = 0; i < 1999999; i++) {
				vet.adicionar(i + 1);
			}
			fim = System.nanoTime();
			array_soma_testes[c] += (fim - inicio);
			c++;
			// System.out.println(
			// "O tempo de adição de 2 milões elementos é de " + (fim - inicio) +
			// " nanosegundos\n\n");

			inicio = System.nanoTime();

			vet.adicionar(0);
			fim = System.nanoTime();
			array_soma_testes[c] += (fim - inicio);
			c++;
			// System.out.println("O tempo para adição de um novo elemento no
			// fim do vetor é de " + (fim - inicio)
			// + " nanosegundos\n\n");
			//
			//
			//
			//
			//
			//
			//
			//
			inicio = System.nanoTime();
			
			 vet.adicionar(0, 3);
			 fim=System.nanoTime();
			 array_soma_testes [c]+=(fim - inicio);
			c++;
			// System.out.println("O tempo para adição de um novo elemento no
			// início do vetor é de "+(fim - inicio) / 1000 + "
			// microsegundos\n\n");
			//
			//
			//
			//
			//
			//
			//
			//
			//

			inicio = System.nanoTime();

			vet.adicionar(1000000, 0);
			fim = System.nanoTime();
			array_soma_testes[c] += (fim - inicio);
			c++;
			// System.out.println("O tempo para adição de um novo elemento no
			// meio do vetor é de " + (fim - inicio)
			// + " nanosegundos\n\n");

			inicio = System.nanoTime();
			vet.remover(vet.tamanho() - 1);
			fim = System.nanoTime();
			array_soma_testes[c] += (fim - inicio);
			c++;
			// System.out.println("O tempo para remoção de um elemento no final
			// do vetor é de " + (fim - inicio)
			// + " nanosegundos\n\n");

			inicio = System.nanoTime();
			vet.remover(0);
			fim = System.nanoTime();
			array_soma_testes[c] += (fim - inicio);
			c++;
			// System.out.println("O tempo para remoção de um elemento no inicio
			// do vetor é de " + (fim - inicio)
			// + " nanosegundos\n\n");

			inicio = System.nanoTime();
			vet.remover(1000000);
			fim = System.nanoTime();
			array_soma_testes[c] += (fim - inicio);
			c++;
			// System.out.println("O tempo para remoção de um elemento no meio
			// do vetor é de " + (fim - inicio)
			// + " nanosegundos\n\n");

			inicio = System.nanoTime();
			vet.obter(0);
			fim = System.nanoTime();
			array_soma_testes[c] += (fim - inicio);
			c++;
			// System.out.println(
			// "O tempo para obter o primeiro numero do vetor é de " + (fim -
			// inicio) + " nanosegundos\n\n");

			inicio = System.nanoTime();
			vet.obter(vet.tamanho() - 1);
			fim = System.nanoTime();
			array_soma_testes[c] += (fim - inicio);
			c++;
			// System.out.println(
			// "O tempo para obter o ultimo numero do vetor é de " + (fim -
			// inicio) + " nanosegundos\n\n");
			//
			//
			//
			//
			 inicio = System.nanoTime();
			 vet.obter(1000000);
			 fim = System.nanoTime();
			 array_soma_testes [c]+=(fim - inicio);
			c++;
			// System.out.println("O tempo para obter o numero do meio do vetor
			// é de" + (fim - inicio) / 1000 + " microsegundos\n\n");
			//
			//
			//
			//
			//
			//
			//
			//
			//
			inicio = System.nanoTime();
			vet.contem(-1); // valor que não tem no vetor para forçar ele
							// percorrer
							// ou vetor espaço por espaço
			fim = System.nanoTime();
			array_soma_testes[c] += (fim - inicio);
			c++;
			// System.out.println("O tempo para percorrer totalmente o veto é de
			// " + (fim - inicio) + " nanosegundos\n\n");

			inicio = System.nanoTime();
			vet.limpar();
			fim = System.nanoTime();
			array_soma_testes[c] += (fim - inicio);
			c++;
			// System.out.println("O tempo limpar o vetor é de" + (fim - inicio)
			// + " nanosegundos\n\n");
			cont++;
		}
		System.out.println("TESTE COM 2 MILHÕES\n\n");
		
		c = 0;
		System.out.println(
				"O tempo de adição de 2 milhões elementos é de " + (array_soma_testes[c]) / 3 + " nanosegundos\n\n");
		c++;
		System.out.println("O tempo para adição de um novo elemento no fim do vetor é de " + (array_soma_testes[c]) / 3
				+ " nanosegundos\n\n");
		c++;
		System.out.println("O tempo para adição de um novo elemento no inicio do vetor é de "
				+ (array_soma_testes[c]) / 3 + " nanosegundos\n\n");
		c++;
		System.out.println("O tempo para adição de um novo elemento no meio do vetor é de " + (array_soma_testes[c]) / 3
				+ " nanosegundos\n\n");
		c++;
		System.out.println("O tempo para remoção de um elemento no final do vetor é de " + (array_soma_testes[c]) / 3
				+ " nanosegundos\n\n");
		c++;
		System.out.println("O tempo para remoção de um elemento no inicio do vetor é de " + (array_soma_testes[c]) / 3
				+ " nanosegundos\n\n");
		c++;
		System.out.println("O tempo para remoção de um elemento no meio do vetor é de " + (array_soma_testes[c]) / 3
				+ " nanosegundos\n\n");
		c++;
		System.out.println("O tempo para obter o primeiro numero do vetor é de " + (array_soma_testes[c]) / 3
				+ " nanosegundos\n\n");
		c++;
		System.out.println(
				"O tempo para obter o ultimo numero do vetor é de " + (array_soma_testes[c]) / 3 + " nanosegundos\n\n");
		c++;
		System.out.println("O tempo para obter o numero do meio do vetor é de " + (array_soma_testes[c]) / 3
				+ " nanosegundos\n\n");
		c++;

		System.out.println(
				"O tempo para percorrer totalmente o vetor é de " + (array_soma_testes[c]) / 3 + " nanosegundos\n\n");
		c++;

		System.out.println("O tempo limpar o vetor é de" + (array_soma_testes[c]) / 3 + " nanosegundos\n\n");
		
//		System.out.println("LISTAGEM\n\n");
//		//
//		//
//
//		for (int i = 0; i < 19999; i++) {
//			vet.adicionar(i + 1);
//		}
//		long inicio = System.nanoTime();
//		for (int i = 0; i < 19999; i++) {
//			vet.obter(i);
//		}
//
//		long fim = System.nanoTime();
//
//		System.out.println("Tempo para listar 20 mil elementos com o for é de " + (fim - inicio) + " milisegundos");
//
//		inicio = System.nanoTime();
//		for (Integer Integer : vet) {
//		}
//
//		fim = System.nanoTime();
//		System.out.println("Tempo para listar 20 mil elementos com o foreach é de " + (fim - inicio) + " milisegundos");
//		vet.limpar();
//
//		for (int i = 0; i < 199999; i++) {
//			vet.adicionar(i + 1);
//		}
//		inicio = System.nanoTime();
//		for (int i = 0; i < 199999; i++) {
//			vet.obter(i);
//		}
//
//		fim = System.nanoTime();
//
//		System.out.println("Tempo para listar 200 mil elementos com o for é de " + (fim - inicio) + " milisegundos");
//
//		inicio = System.nanoTime();
//	//	for (Integer Integer : vet) {
//		}
//
//		fim = System.nanoTime();
//		System.out
//				.println("Tempo para listar 200 mil elementos com o foreach é de " + (fim - inicio) + " milisegundos");
//		vet.limpar();
//		for (int i = 0; i < 1999999; i++) {
//			vet.adicionar(i + 1);
//		}
//		inicio = System.nanoTime();
//		for (int i = 0; i < 1999999; i++) {
//			vet.obter(i);
//		}
//
//		fim = System.nanoTime();
//
//		System.out.println("Tempo para listar 2 milhões elementos com o for é de " + (fim - inicio) + " milisegundos");
//
//		inicio = System.nanoTime();
//		for (Integer Integer : vet) {
//		}
//
//		fim = System.nanoTime();
//		System.out
//				.println("Tempo para listar 2 millhões elementos com o foreach é de " + (fim - inicio) + " milisegundos");
//		vet.limpar();
//		
//		
		
		
		System.out.println("Programa encerrado");
		
	
		/*
		 * System.out.println("Inserção de 2 milhões elementos"); inicio =
		 * System.nanoTime(); fim = inicio; for (int i = 0; i < 1999999; i++) {
		 * vet.adicionar(i); } fim = System.nanoTime();
		 * System.out.println("O tempo de adição de 2 milhões elementos é de" +
		 * (fim - inicio) / 1000000 + " milisegundos");
		 */

	}
}
