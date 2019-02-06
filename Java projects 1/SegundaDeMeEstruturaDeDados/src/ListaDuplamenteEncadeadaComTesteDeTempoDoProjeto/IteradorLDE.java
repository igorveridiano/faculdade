package ListaDuplamenteEncadeadaComTesteDeTempoDoProjeto;


public class IteradorLDE<T> implements java.util.Iterator<T>{

	private int posicao;
	private ListaDuplamenteEncadeada<T> ListaDuplamenteEncadeada;
	
	public IteradorLDE(ListaDuplamenteEncadeada<T> ListaDuplamenteEncadeada) {
		this.ListaDuplamenteEncadeada = ListaDuplamenteEncadeada;
	}
	
	@Override
	public boolean hasNext() {
		if ( !(this.ListaDuplamenteEncadeada.obter(posicao) == null) && this.posicao < this.ListaDuplamenteEncadeada.tamanho() ) {
			return true;
		}
		return false;
	}

	@Override
	public T next() {
		if (hasNext()) {
			return this.ListaDuplamenteEncadeada.obter(posicao++);
		}
		return null;
	}
}
