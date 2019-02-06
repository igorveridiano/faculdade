package ListaSimplesmenteEncadeadaComTesteDeTempoDoProjeto;

public class Iterador<T> implements java.util.Iterator<T> {

	private int posicao;
	private ListaSimplesmenteEncadeada<T> listaSimplesmenteEncadeada;
	
	public Iterador(ListaSimplesmenteEncadeada<T> listaSimplesmenteEncadeada) {
		this.listaSimplesmenteEncadeada = listaSimplesmenteEncadeada;
	}
	
	@Override
	public boolean hasNext() {
		if ( !(this.listaSimplesmenteEncadeada.obter(posicao) == null) && this.posicao < this.listaSimplesmenteEncadeada.tamanho() ) {
			return true;
		}
		return false;
	}

	@Override
	public T next() {
		if (hasNext()) {
			return this.listaSimplesmenteEncadeada.obter(posicao++);
		}
		return null;
	}

}
