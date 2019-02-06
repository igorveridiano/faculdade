package listaVetor;

public class Iterador<Tipo> implements java.util.Iterator<Tipo> {

	private Vetor<Tipo> vetor;
	private int posicao;

	public Iterador(Vetor<Tipo> vetor) {
		this.vetor = vetor;
	}

	@Override
	public boolean hasNext() {
		return this.posicao >= 0 && this.posicao < this.vetor.getTamanho();
	}

	@Override
	public Tipo next() {
		if (hasNext()) {
			return (Tipo) this.vetor.obter(posicao++);
		}
		return null;
	}

}
