package pilha;

public class Teste {

	public static void main(String[] args) {
		
		
		PilhaEncadeada<Integer> pilha = new PilhaEncadeada<Integer>();
		PilhaEncadeada<Integer> pilha2 = new PilhaEncadeada<Integer>();
		pilha.empilhar(3);
		for (Integer integer : pilha) {
			pilha2.empilhar(integer);
			System.out.println(pilha.topo());
			System.out.println(pilha2.topo());
		}
	}

}
