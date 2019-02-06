package questao3;


public class Main {

	public static void main(String[] args) throws InterruptedException {
		ArvoreR<Integer, Integer> tree = new ArvoreR<>();
		int chave;
		tree.insert(25, 25);
		Thread.sleep(60000);
		tree.insert(10, 10);
		tree.insert(42, 42);
		Thread.sleep(60000);
		tree.insert(3, 3);
		tree.insert(25, 25);
		System.out.println(tree.get(10).getKey()); //Esse é o buscar por chave
		System.out.println("Valores:");
		for (Integer value : tree.obterTodos()) {
			System.out.println(value);
		}
		System.out.println("\nHoras:");
		chave = 10;
		for (String hora : tree.obterHoraRepeticao(chave)) {
			System.out.println(hora);
		}
		System.out.println("\nHoras:");
		chave = 3;
		for (String hora : tree.obterHoraRepeticao(chave)) {
			System.out.println(hora);
		}
		System.out.println("\nHoras:");
		chave = 25;
		for (String hora : tree.obterHoraRepeticao(chave)) {
			System.out.println(hora);
		}
		System.out.println("\nHoras:");
		chave = 42;
		for (String hora : tree.obterHoraRepeticao(chave)) {
			System.out.println(hora);
		}
		tree.limpar();
		System.out.println("\nItens na arvore: " + tree.getSize());
		/*System.out.println(tree.toString());
		System.out.println(tree.inOrder());
		System.out.println(tree.preOrder());
		System.out.println(tree.postOrder());*/
	}

}
