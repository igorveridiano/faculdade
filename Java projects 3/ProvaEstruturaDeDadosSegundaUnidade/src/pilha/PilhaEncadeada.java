package pilha;

import java.util.Iterator;

import listaDuplamenteEncadeada.Iterador;
import listaDuplamenteEncadeada.ListaDuplamenteEncadeada;

public class PilhaEncadeada<T> implements IPilha<T> {

	ListaDuplamenteEncadeada<T> pilhaEncadeada = new ListaDuplamenteEncadeada<>();
	private int size;
	private T elemento;
	private int posicao = 0;

	@Override
	public void empilhar(T elemento) {
		this.pilhaEncadeada.adicionarNoInicio(elemento);
		setSize(getSize() + 1);
	}

	@Override
	public T desempilhar() {
		elemento = pilhaEncadeada.obter(posicao);
		this.pilhaEncadeada.remover(posicao);
		setSize(getSize() - 1);
		return elemento;
	}

	@Override
	public T topo() {
		return this.pilhaEncadeada.obter(posicao);
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
		this.pilhaEncadeada.limpar();
		setSize(0);
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterador<>(pilhaEncadeada);
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

}
