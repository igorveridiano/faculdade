package pilha;

import java.util.Iterator;

import listaVetor.IteradorAoContrario;
import listaVetor.Vetor;

public class PilhaVetor<T> implements IPilha<T> {

	Vetor<T> pilhaVetor = new Vetor<>();
	private int size;
	private int topo;
	private T elemento;

	@Override
	public void empilhar(T elemento) {
		setTopo(getTopo() + 1);
		this.pilhaVetor.adicionar(getTopo(), elemento);
		setSize(getSize() + 1);
	}

	@Override
	public T desempilhar() {
		setElemento((T) this.pilhaVetor.obter(getTopo()));
		setTopo(getTopo() - 1);
		setSize(getSize() - 1);
		return getElemento();
	}

	@Override
	public T topo() {
		setElemento((T) this.pilhaVetor.obter(getTopo()));
		return getElemento();
	}

	@Override
	public int tamanho() {
		return getSize();
	}

	@Override
	public boolean vazia() {
		return getSize() == 0;
	}

	@Override
	public void limpar() {
		this.pilhaVetor.limpar();
		setSize(0);
	}

	@Override
	public Iterator<T> iterator() {
		return new IteradorAoContrario<>(pilhaVetor);
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getTopo() {
		return topo;
	}

	public void setTopo(int topo) {
		this.topo = topo;
	}

	public T getElemento() {
		return elemento;
	}

	public void setElemento(T elemento) {
		this.elemento = elemento;
	}

}
