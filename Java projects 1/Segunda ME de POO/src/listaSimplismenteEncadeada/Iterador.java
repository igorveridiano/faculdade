package listaSimplismenteEncadeada;

public class Iterador<T> implements java.util.Iterator<T> {

	private int posicao;
	private ListaSimplesmenteEncadeada<T> listaSimplesmenteEncadeada;

	public Iterador(ListaSimplesmenteEncadeada<T> listaSimplesmenteEncadeada) {
		this.listaSimplesmenteEncadeada = listaSimplesmenteEncadeada;
	}

	@Override
	public boolean hasNext() {
		return this.posicao >= 0 && this.posicao < this.listaSimplesmenteEncadeada.tamanho();
	}

	@Override
	public T next() {
		if (hasNext()) {
			return this.listaSimplesmenteEncadeada.obter(posicao++);
		}
		return null;
	}

}
