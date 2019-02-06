package listaVetor;

public class IteradorAoContrario<Tipo> implements java.util.Iterator<Tipo> {

	private Vetor<Tipo> vetor;
	private int posicao;

	public IteradorAoContrario(Vetor<Tipo> vetor) {
		this.vetor = vetor;
		this.posicao = vetor.tamanho() - 1;
	}

	@Override
	public boolean hasNext() {
		return this.posicao >= 0 && this.posicao < this.vetor.tamanho();
	}

	@Override
	public Tipo next() {
		if (hasNext()) {
			return this.vetor.obter(posicao--);
		}
		return null;
	}

}
