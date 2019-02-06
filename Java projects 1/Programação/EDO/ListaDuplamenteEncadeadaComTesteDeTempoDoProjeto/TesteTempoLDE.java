package ListaDuplamenteEncadeadaComTesteDeTempoDoProjeto;



public class TesteTempoLDE {

	static ListaDuplamenteEncadeada<Integer> LDE = new ListaDuplamenteEncadeada<>();
	static double array_soma_testes[] = new double[13];
	static int cont = 0;
	
	public static void main(String[] args) {
		

		

			
				for (int i = 0; i < array_soma_testes.length; i++) { // zerando o vetor
					array_soma_testes[i] = 0;
				}
				while (cont != 5) {
					System.out.println("REPETE");
					int c = 0; // controle do teste
					// System.out.println("Inserção de 20 mil elementos");
					long fim, inicio = System.currentTimeMillis();
					for (int i = 0; i < 19999; i++) {
						LDE.adicionar(i + 1);
					}
					fim = System.currentTimeMillis();
					array_soma_testes[c] += (fim - inicio);
					c++;
//					 System.out.println(
//					 "O tempo de adição de 20 mil elementos é de " + (fim - inicio) +
//					  " milisegundos\n\n");

					inicio = System.nanoTime();
					LDE.adicionar(0);
					fim = System.nanoTime();
					array_soma_testes[c] += (fim - inicio);
					c++;
					// System.out.println("O tempo para adição de um novo elemento no
					// fim da lista é de " + (fim - inicio)
					// + " milisegundos\n\n");

					inicio = System.nanoTime();
					LDE.adicionarNoInicio(0);
					fim = System.nanoTime();
					array_soma_testes[c] += (fim - inicio);
					c++;
					// System.out.println("O tempo para adição de um novo elemento no
					// início da lista é de "+(fim - inicio) / 1000 + "
					// microsegundos\n\n");

					inicio = System.currentTimeMillis();
					LDE.adicionar(10000, 0);
					fim = System.currentTimeMillis();
					array_soma_testes[c] += (fim - inicio);
					c++;
					// System.out.println("O tempo para adição de um novo elemento no
					// meio da lista de " + (fim - inicio)
					// + " milisegundos\n\n");

					inicio = System.nanoTime();
					LDE.removerDoFim();
					fim = System.nanoTime();
					array_soma_testes[c] += (fim - inicio);
					c++;
					// System.out.println("O tempo para remoção de um elemento no final
					// da lista é de " + (fim - inicio)
					// + " milisegundos\n\n");

					inicio = System.nanoTime();
					LDE.removerDoInicio();
					fim = System.nanoTime();
					array_soma_testes[c] += (fim - inicio);
					c++;
					// System.out.println("O tempo para remoção de um elemento no inicio
					// da lista é de " + (fim - inicio)
					// + " milisegundos\n\n");

					inicio = System.currentTimeMillis();
					LDE.remover(10000);
					fim = System.currentTimeMillis();
					array_soma_testes[c] += (fim - inicio);
					c++;
					// System.out.println("O tempo para remoção de um elemento no meio
					// da lista é de " + (fim - inicio)
					// + " milisegundos\n\n");

					inicio = System.nanoTime();
					LDE.obter(0);
					fim = System.nanoTime();
					array_soma_testes[c] += (fim - inicio);
					c++;
					// System.out.println(
					// "O tempo para obter o primeiro numero da lista é de " + (fim -
					// inicio) + " milisegundos\n\n");

					inicio = System.nanoTime();
					LDE.obter(LDE.tamanho - 1);
					fim = System.nanoTime();
					array_soma_testes[c] += (fim - inicio);
					c++;
					// System.out.println(
					// "O tempo para obter o ultimo numero da lista é de " + (fim -
					// inicio) + " milisegundos\n\n");

					inicio = System.nanoTime();
					LDE.obter(10000);
					fim = System.nanoTime();
					array_soma_testes[c] += (fim - inicio);
					c++;
					// System.out.println(
					// "O tempo para obter o numero do meio da lista é de" + (fim -
					// inicio) / 1000 + " microsegundos\n\n");

					inicio = System.currentTimeMillis();
					LDE.contem(-1); // valor que não tem no vetor para forçar ele
									// percorrer
									// ou vetor espaço por espaço
					fim = System.currentTimeMillis();
					array_soma_testes[c] += (fim - inicio);
					c++;
					// System.out.println("O tempo para percorrer totalmente a lista é de
					// " + (fim - inicio) + " milisegundos\n\n")

					inicio = System.nanoTime();
					LDE.limpar();
					fim = System.nanoTime();;
					array_soma_testes[c] += (fim - inicio);
					c++;
					// System.out.println("O tempo limpar a lista é de" + (fim - inicio)
					// + " milisegundos\n\n");
					cont++;
				}
				System.out.println("TESTE COM 20 MIL\n\n");
				int c = 0;
				System.out.println(
						"O tempo de adição de 20 mil elementos é de " + (array_soma_testes[c]) / 5+ " milisegundos\n\n");
				c++;
				System.out.println("O tempo para adição de um novo elemento no fim da lista de " + (array_soma_testes[c]) / 3
						+ " nanosegundos\n\n");
				c++;
				System.out.println("O tempo para adição de um novo elemento no inicio da lista é de "
						+ (array_soma_testes[c]) / 5+ " nanosegundos\n\n");
				c++;
				System.out.println("O tempo para adição de um novo elemento no meio da lista é de " + (array_soma_testes[c]) / 3
						+ " milisegundos\n\n");
				c++;
				System.out.println("O tempo para remoção de um elemento no final da lista é de " + (array_soma_testes[c]) / 3
						+ " nanosegundos\n\n");
				c++;
				System.out.println("O tempo para remoção de um elemento no inicio da lista é de " + (array_soma_testes[c]) / 3
						+ " nanosegundos\n\n");
				c++;
				System.out.println("O tempo para remoção de um elemento no meio da lista é de " + (array_soma_testes[c]) / 3
						+ "milisegundos\n\n");
				c++;
				System.out.println("O tempo para obter o primeiro numero da lista é de " + (array_soma_testes[c]) / 3
						+ " nanosegundos\n\n");
				c++;
				System.out.println(
						"O tempo para obter o ultimo numero da lista é de " + (array_soma_testes[c]) / 5+ " nanosegundos\n\n");
				c++;
				System.out.println("O tempo para obter o numero do meio da lista é de " + (array_soma_testes[c]) / 3
						+ " nanosegundos\n\n");
				c++;

				System.out.println(
						"O tempo para percorrer totalmente a lista é de " + (array_soma_testes[c]) / 5+ " milisegundos\n\n");
				c++;

				System.out.println("O tempo limpar a lista é de" + (array_soma_testes[c]) / 5+ " nanosegundos\n\n");
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
				while (cont != 5) {
					System.out.println("REPETE");
					 c = 0; // controle do teste
					// System.out.println("Inserção de 200 mil elementos");
					long fim, inicio = System.currentTimeMillis();
					for (int i = 0; i < 199999; i++) {
						LDE.adicionar(i + 1);
					}
					fim = System.currentTimeMillis();
					array_soma_testes[c] += (fim - inicio);
					c++;
					// System.out.println(
					// "O tempo de adição de 200 mil elementos é de " + (fim - inicio) +
					// " milisegundos\n\n");

					inicio = System.nanoTime();

					LDE.adicionar(0);
					fim = System.nanoTime();
					array_soma_testes[c] += (fim - inicio);
					c++;
					// System.out.println("O tempo para adição de um novo elemento no
					// fim da lista é de " + (fim - inicio)
					// + " milisegundos\n\n");

					inicio = System.nanoTime();
					LDE.adicionarNoInicio(0);
					fim = System.nanoTime();
					array_soma_testes[c] += (fim - inicio);
					c++;
					// System.out.println("O tempo para adição de um novo elemento no
					// início da lista é de "+(fim - inicio) / 1000 + "
					// microsegundos\n\n");

					inicio = System.currentTimeMillis();
					LDE.adicionar(100000, 0);
					fim = System.currentTimeMillis();
					array_soma_testes[c] += (fim - inicio);
					c++;
					// System.out.println("O tempo para adição de um novo elemento no
					// meio da lista de " + (fim - inicio)
					// + " milisegundos\n\n");

					inicio = System.nanoTime();
					LDE.removerDoFim();
					fim = System.nanoTime();
					array_soma_testes[c] += (fim - inicio);
					c++;
					// System.out.println("O tempo para remoção de um elemento no final
					// da lista é de " + (fim - inicio)
					// + " milisegundos\n\n");

					inicio = System.nanoTime();
					LDE.removerDoInicio();
					fim = System.nanoTime();
					array_soma_testes[c] += (fim - inicio);
					c++;
					// System.out.println("O tempo para remoção de um elemento no inicio
					// da lista é de " + (fim - inicio)
					// + " milisegundos\n\n");

					inicio = System.currentTimeMillis();
					LDE.remover(100000);
					fim = System.currentTimeMillis();
					array_soma_testes[c] += (fim - inicio);
					c++;
					// System.out.println("O tempo para remoção de um elemento no meio
					// da lista é de " + (fim - inicio)
					// + " milisegundos\n\n");

					inicio = System.nanoTime();
					LDE.obter(0);
					fim = System.nanoTime();
					array_soma_testes[c] += (fim - inicio);
					c++;
					// System.out.println(
					// "O tempo para obter o primeiro numero da lista é de " + (fim -
					// inicio) + " milisegundos\n\n");

					inicio = System.nanoTime();
					LDE.obter(LDE.tamanho - 1);
					fim = System.nanoTime();
					array_soma_testes[c] += (fim - inicio);
					c++;
					// System.out.println(
					// "O tempo para obter o ultimo numero da lista é de " + (fim -
					// inicio) + " milisegundos\n\n");

					inicio = System.currentTimeMillis();
					LDE.obter(100000);
					fim = System.currentTimeMillis();
					array_soma_testes[c] += (fim - inicio);
					c++;
					// System.out.println(
					// "O tempo para obter o numero do meio da lista é de" + (fim -
					// inicio) / 1000 + " microsegundos\n\n");

					inicio = System.currentTimeMillis();
					LDE.contem(-1); // valor que não tem no vetor para forçar ele
									// percorrer
									// ou vetor espaço por espaço
					fim = System.currentTimeMillis();
					array_soma_testes[c] += (fim - inicio);
					c++;
					// System.out.println("O tempo para percorrer totalmente a lista é de
					// " + (fim - inicio) + " milisegundos\n\n")

					inicio = System.nanoTime();
					LDE.limpar();
					fim = System.nanoTime();
					array_soma_testes[c] += (fim - inicio);
					c++;
					// System.out.println("O tempo limpar a lista é de" + (fim - inicio)
					// + " milisegundos\n\n");
					cont++;
				}
				System.out.println("TESTE COM 200 MIL\n\n");
				 c = 0;
				System.out.println(
						"O tempo de adição de 200 mil elementos é de " + (array_soma_testes[c]) / 5+ " milisegundos\n\n");
				c++;
				System.out.println("O tempo para adição de um novo elemento no fim da lista de " + (array_soma_testes[c]) / 3
						+ " nanosegundos\n\n");
				c++;
				System.out.println("O tempo para adição de um novo elemento no inicio da lista é de "
						+ (array_soma_testes[c]) / 5+ " nanosegundos\n\n");
				c++;
				System.out.println("O tempo para adição de um novo elemento no meio da lista é de " + (array_soma_testes[c]) / 3
						+ " milisegundos\n\n");
				c++;
				System.out.println("O tempo para remoção de um elemento no final da lista é de " + (array_soma_testes[c]) / 3
						+ " nanosegundos\n\n");
				c++;
				System.out.println("O tempo para remoção de um elemento no inicio da lista é de " + (array_soma_testes[c]) / 3
						+ " nanosegundos\n\n");
				c++;
				System.out.println("O tempo para remoção de um elemento no meio da lista é de " + (array_soma_testes[c]) / 3
						+ " milisegundos\n\n");
				c++;
				System.out.println("O tempo para obter o primeiro numero da lista é de " + (array_soma_testes[c]) / 3
						+ " nanosegundos\n\n");
				c++;
				System.out.println(
						"O tempo para obter o ultimo numero da lista é de " + (array_soma_testes[c]) / 5+ " milisegundos\n\n");
				c++;
				System.out.println("O tempo para obter o numero do meio da lista é de " + (array_soma_testes[c]) / 3
						+ " milisegundos\n\n");
				c++;

				System.out.println(
						"O tempo para percorrer totalmente a lista é de " + (array_soma_testes[c]) / 5+ " milisegundos\n\n");
				c++;

				System.out.println("O tempo limpar a lista é de" + (array_soma_testes[c]) / 5+ "nanosegundos\n\n");
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
				while (cont != 5) {
					System.out.println("REPETE");
					 c = 0; // controle do teste
					// System.out.println("Inserção de 2 milhões elementos");
					long fim, inicio = System.currentTimeMillis();
					for (int i = 0; i < 1999999; i++) {
						LDE.adicionar(i + 1);
					}
					fim = System.currentTimeMillis();
					array_soma_testes[c] += (fim - inicio);
					c++;
					// System.out.println(
					// "O tempo de adição de 2 milhões elementos é de " + (fim - inicio) +
					// " milisegundos\n\n");

					inicio = System.nanoTime();

					LDE.adicionar(0);
					fim = System.nanoTime();
					array_soma_testes[c] += (fim - inicio);
					c++;
					// System.out.println("O tempo para adição de um novo elemento no
					// fim da lista é de " + (fim - inicio)
					// + " milisegundos\n\n");

					inicio = System.nanoTime();
					LDE.adicionarNoInicio(0);
					fim = System.nanoTime();
					array_soma_testes[c] += (fim - inicio);
					c++;
					// System.out.println("O tempo para adição de um novo elemento no
					// início da lista é de "+(fim - inicio) / 1000 + "
					// microsegundos\n\n");

					inicio = System.currentTimeMillis();
					LDE.adicionar(1000000, 0);
					fim = System.currentTimeMillis();
					array_soma_testes[c] += (fim - inicio);
					c++;
					// System.out.println("O tempo para adição de um novo elemento no
					// meio da lista de " + (fim - inicio)
					// + " milisegundos\n\n");

					inicio = System.nanoTime();
					LDE.removerDoFim();
					fim = System.nanoTime();
					array_soma_testes[c] += (fim - inicio);
					c++;
					// System.out.println("O tempo para remoção de um elemento no final
					// da lista é de " + (fim - inicio)
					// + " milisegundos\n\n");

					inicio = System.nanoTime();
					LDE.removerDoInicio();
					fim = System.nanoTime();
					array_soma_testes[c] += (fim - inicio);
					c++;
					// System.out.println("O tempo para remoção de um elemento no inicio
					// da lista é de " + (fim - inicio)
					// + " milisegundos\n\n");

					inicio = System.currentTimeMillis();
					LDE.remover(1000000);
					fim = System.currentTimeMillis();
					array_soma_testes[c] += (fim - inicio);
					c++;
					// System.out.println("O tempo para remoção de um elemento no meio
					// da lista é de " + (fim - inicio)
					// + " milisegundos\n\n");

					inicio = System.nanoTime();
					LDE.obter(0);
					fim = System.nanoTime();
					array_soma_testes[c] += (fim - inicio);
					c++;
					// System.out.println(
					// "O tempo para obter o primeiro numero da lista é de " + (fim -
					// inicio) + " milisegundos\n\n");

					inicio = System.nanoTime();
					LDE.obter(LDE.tamanho - 1);
					fim = System.nanoTime();
					array_soma_testes[c] += (fim - inicio);
					c++;
					// System.out.println(
					// "O tempo para obter o ultimo numero da lista é de " + (fim -
					// inicio) + " milisegundos\n\n");

					inicio = System.currentTimeMillis();
					LDE.obter(1000000);
					fim = System.currentTimeMillis();
					array_soma_testes[c] += (fim - inicio);
					c++;
					// System.out.println(
					// "O tempo para obter o numero do meio da lista é de" + (fim -
					// inicio) / 1000 + " microsegundos\n\n");

					inicio = System.currentTimeMillis();
					LDE.contem(-1); // valor que não tem no vetor para forçar ele
									// percorrer
									// ou vetor espaço por espaço
					fim = System.currentTimeMillis();
					array_soma_testes[c] += (fim - inicio);
					c++;
					// System.out.println("O tempo para percorrer totalmente a lista é de
					// " + (fim - inicio) + " milisegundos\n\n")

					inicio = System.nanoTime();
					LDE.limpar();
					fim = System.nanoTime();
					array_soma_testes[c] += (fim - inicio);
					c++;
					// System.out.println("O tempo limpar a lista é de" + (fim - inicio)
					// + " milisegundos\n\n");
					cont++;
				}
				System.out.println("TESTE COM 2 MILHÕES\n\n");
				 c = 0;
				System.out.println(
						"O tempo de adição de 2 milhões elementos é de " + (array_soma_testes[c]) / 5+ " milisegundos\n\n");
				c++;
				System.out.println("O tempo para adição de um novo elemento no fim da lista de " + (array_soma_testes[c]) / 3
						+ " nanosegundos\n\n");
				c++;
				System.out.println("O tempo para adição de um novo elemento no inicio da lista é de "
						+ (array_soma_testes[c]) / 5+ " nanosegundos\n\n");
				c++;
				System.out.println("O tempo para adição de um novo elemento no meio da lista é de " + (array_soma_testes[c]) / 3
						+ " milisegundos\n\n");
				c++;
				System.out.println("O tempo para remoção de um elemento no final da lista é de " + (array_soma_testes[c]) / 3
						+ " nanosegundos\n\n");
				c++;
				System.out.println("O tempo para remoção de um elemento no inicio da lista é de " + (array_soma_testes[c]) / 3
						+ " nanosegundos\n\n");
				c++;
				System.out.println("O tempo para remoção de um elemento no meio da lista é de " + (array_soma_testes[c]) / 3
						+ " milisegundos\n\n");
				c++;
				System.out.println("O tempo para obter o primeiro numero da lista é de " + (array_soma_testes[c]) / 3
						+ " nanosegundos\n\n");
				c++;
				System.out.println(
						"O tempo para obter o ultimo numero da lista é de " + (array_soma_testes[c]) / 5+ " nanosegundos\n\n");
				c++;
				System.out.println("O tempo para obter o numero do meio da lista é de " + (array_soma_testes[c]) / 3
						+ " milisegundos\n\n");
				c++;

				System.out.println(
						"O tempo para percorrer totalmente a lista é de " + (array_soma_testes[c]) / 5+ " milisegundos\n\n");
				c++;

				System.out.println("O tempo limpar a lista é de" + (array_soma_testes[c]) / 5+ " nanosegundos\n\n");
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
				while (cont != 5) {
					System.out.println("REPETE");
					c = 0; // controle do teste
					// System.out.println("Inserção de 20 milhões elementos");
					long fim, inicio = System.currentTimeMillis();
					for (int i = 0; i < 19999999; i++) {
						LDE.adicionar(i + 1);
					}
					fim = System.currentTimeMillis();
					array_soma_testes[c] += (fim - inicio);
					c++;
					// System.out.println(
					// "O tempo de adição de 20 milhões elementos é de " + (fim - inicio)
					// +
					// " milisegundos\n\n");

					inicio = System.nanoTime();

					LDE.adicionar(0);
					fim = System.nanoTime();
					array_soma_testes[c] += (fim - inicio);
					c++;
					// System.out.println("O tempo para adição de um novo elemento no
					// fim da lista é de " + (fim - inicio)
					// + " milisegundos\n\n");

					inicio = System.nanoTime();
					LDE.adicionarNoInicio(0);
					fim = System.nanoTime();
					array_soma_testes[c] += (fim - inicio);
					c++;
					// System.out.println("O tempo para adição de um novo elemento no
					// início da lista é de "+(fim - inicio) / 1000 + "
					// microsegundos\n\n");

					inicio = System.currentTimeMillis();
					LDE.adicionar(10000000, 0);
					fim = System.currentTimeMillis();
					array_soma_testes[c] += (fim - inicio);
					c++;
					// System.out.println("O tempo para adição de um novo elemento no
					// meio da lista de " + (fim - inicio)
					// + " milisegundos\n\n");

					inicio = System.nanoTime();
					LDE.removerDoFim();
					fim = System.nanoTime();
					array_soma_testes[c] += (fim - inicio);
					c++;
					// System.out.println("O tempo para remoção de um elemento no final
					// da lista é de " + (fim - inicio)
					// + " milisegundos\n\n");

					inicio = System.nanoTime();
					LDE.removerDoInicio();
					fim = System.nanoTime();
					array_soma_testes[c] += (fim - inicio);
					c++;
					// System.out.println("O tempo para remoção de um elemento no inicio
					// da lista é de " + (fim - inicio)
					// + " milisegundos\n\n");

					inicio = System.currentTimeMillis();
					LDE.remover(10000000);
					fim = System.currentTimeMillis();
					array_soma_testes[c] += (fim - inicio);
					c++;
					// System.out.println("O tempo para remoção de um elemento no meio
					// da lista é de " + (fim - inicio)
					// + " milisegundos\n\n");

					inicio = System.nanoTime();
					LDE.obter(0);
					fim = System.nanoTime();
					array_soma_testes[c] += (fim - inicio);
					c++;
					// System.out.println(
					// "O tempo para obter o primeiro numero da lista é de " + (fim -
					// inicio) + " milisegundos\n\n");

					inicio = System.nanoTime();
					LDE.obter(LDE.tamanho - 1);
					fim = System.nanoTime();
					array_soma_testes[c] += (fim - inicio);
					c++;
					// System.out.println(
					// "O tempo para obter o ultimo numero da lista é de " + (fim -
					// inicio) + " milisegundos\n\n");

					inicio = System.currentTimeMillis();
					LDE.obter(10000000);
					fim = System.currentTimeMillis();
					array_soma_testes[c] += (fim - inicio);
					c++;
					// System.out.println(
					// "O tempo para obter o numero do meio da lista é de" + (fim -
					// inicio) / 1000 + " microsegundos\n\n");

					inicio = System.currentTimeMillis();
					LDE.contem(-1); // valor que não tem no vetor para forçar ele
									// percorrer
									// ou vetor espaço por espaço
					fim = System.currentTimeMillis();
					System.out.println(LDE.contem(-1));
					array_soma_testes[c] += (fim - inicio);
					c++;
					// System.out.println("O tempo para percorrer totalmente a lista é
					// de
					// " + (fim - inicio) + " milisegundos\n\n")

					inicio = System.nanoTime();
					LDE.limpar();
					fim = System.nanoTime();
					array_soma_testes[c] += (fim - inicio);
					c++;
					// System.out.println("O tempo limpar a lista é de" + (fim - inicio)
					// + " milisegundos\n\n");
					cont++;
				}
				System.out.println("TESTE COM 20 MILHÕES\n\n");
				c = 0;
				System.out.println(
						"O tempo de adição de 20 milhões elementos é de " + (array_soma_testes[c]) / 5 + " milisegundos\n\n");
				c++;
				System.out.println("O tempo para adição de um novo elemento no fim da lista de " + (array_soma_testes[c]) / 3
						+ " nanosegundos\n\n");
				c++;
				System.out.println("O tempo para adição de um novo elemento no inicio da lista é de "
						+ (array_soma_testes[c]) / 5+ " nanosegundos\n\n");
				c++;
				System.out.println("O tempo para adição de um novo elemento no meio da lista é de " + (array_soma_testes[c]) / 3
						+ " milisegundos\n\n");
				c++;
				System.out.println("O tempo para remoção de um elemento no final da lista é de " + (array_soma_testes[c]) / 3
						+ " nanosegundos\n\n");
				c++;
				System.out.println("O tempo para remoção de um elemento no inicio da lista é de " + (array_soma_testes[c]) / 3
						+ " nanosegundos\n\n");
				c++;
				System.out.println("O tempo para remoção de um elemento no meio da lista é de " + (array_soma_testes[c]) / 3
						+ " milisegundos\n\n");
				c++;
				System.out.println("O tempo para obter o primeiro numero da lista é de " + (array_soma_testes[c]) / 3
						+ " nanosegundos\n\n");
				c++;
				System.out.println(
						"O tempo para obter o ultimo numero da lista é de " + (array_soma_testes[c]) / 5+ " nanosegundos\n\n");
				c++;
				System.out.println("O tempo para obter o numero do meio da lista é de " + (array_soma_testes[c]) / 3
						+ " milisegundos\n\n");
				c++;

				System.out.println(
						"O tempo para percorrer totalmente a lista é de " + (array_soma_testes[c]) / 5+ " milisegundos\n\n");
				c++;

				System.out.println("O tempo limpar a lista é de" + (array_soma_testes[c]) / 5+ " nanosegundos\n\n");
				//
				//
				//
				//
				System.out.println("LISTAGEM\n\n");
				//
				//

				for (int i = 0; i < 19999; i++) {
					LDE.adicionar(i + 1);
				}
				long inicio = System.currentTimeMillis();
				for (int i = 0; i < 19999; i++) {
					LDE.obter(i);
				}

				long fim = System.currentTimeMillis();

				System.out.println("Tempo para listar 20 mil elementos com o for é de " + (fim - inicio) + " milisegundos");

				inicio = System.currentTimeMillis();
				for (Integer Integer : LDE) {
				}

				fim = System.currentTimeMillis();
				System.out.println("Tempo para listar 20 mil elementos com o foreach é de " + (fim - inicio) + " milisegundos");
				LDE.limpar();

				for (int i = 0; i < 199999; i++) {
					LDE.adicionar(i + 1);
				}
				inicio = System.currentTimeMillis();
				for (int i = 0; i < 199999; i++) {
					LDE.obter(i);
				}

				fim = System.currentTimeMillis();

				System.out.println("Tempo para listar 200 mil elementos com o for é de " + (fim - inicio) + " milisegundos");

				inicio = System.currentTimeMillis();
				for (Integer Integer : LDE) {
				}

				fim = System.currentTimeMillis();
				System.out
						.println("Tempo para listar 200 mil elementos com o foreach é de " + (fim - inicio) + " milisegundos");
				LDE.limpar();
				for (int i = 0; i < 1999999; i++) {
					LDE.adicionar(i + 1);
				}
				inicio = System.currentTimeMillis();
				for (int i = 0; i < 1999999; i++) {
					LDE.obter(i);
				}

				fim = System.currentTimeMillis();

				System.out.println("Tempo para listar 2 milhões elementos com o for é de " + (fim - inicio) + " milisegundos");

				inicio = System.currentTimeMillis();
				for (Integer Integer : LDE) {
				}

				fim = System.currentTimeMillis();
				System.out
						.println("Tempo para listar 2 millhões elementos com o foreach é de " + (fim - inicio) + " milisegundos");
				LDE.limpar();
			}

		

}
