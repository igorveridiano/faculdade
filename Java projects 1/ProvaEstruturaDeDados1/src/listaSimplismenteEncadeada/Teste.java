package listaSimplismenteEncadeada;

public class Teste {

	public static void main(String[] args) {
		ListaSimplesmenteEncadeada<Integer> lista = new ListaSimplesmenteEncadeada<>();
		Integer valor = 7;
		System.out.println(lista);
		lista.adicionar(6);
		System.out.println(lista);
		lista.adicionarNoInicio(1);
		System.out.println(lista);
		lista.adicionarNoFim(7);
		lista.adicionarNoFim(7);
		System.out.println(lista);
		lista.adicionar(1, 5);
		lista.adicionar(2, 7);
		System.out.println(lista);
		System.out.println(lista.obter(1));
		lista.adicionarNoInicio(7);
		System.out.println(lista);
		lista.remover(valor);
		System.out.println(lista);
		lista.contem(9);
		System.out.println(lista.tamanho());
		lista.adicionar(8);
		System.out.println(lista);
		lista.remover(3);
		System.out.println(lista);
		System.out.println(lista.tamanho());
		// lista.adicionar(5, 2);
		System.out.println(lista);
		lista.limpar();
		System.out.println(lista);
		System.out.println(lista.tamanho);
	}
}
