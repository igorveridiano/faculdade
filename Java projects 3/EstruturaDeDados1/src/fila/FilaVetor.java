package fila;

import java.util.Iterator;

import listaVetor.Iterador;
import listaVetor.Vetor;

public class FilaVetor<T> implements IFila<T> {

	private Vetor<T> filaVetor = new Vetor<>();
	private int size = 0;
	private T elemento;

	@Override
	public void enfileirar(T elemento) {
		this.filaVetor.adicionar(0, elemento);
		setSize(getSize() + 1);
	}

	@Override
	public T desenfileirar() {
		setElemento(this.filaVetor.obter(filaVetor.getSize() - 1));
		this.filaVetor.remover(filaVetor.getSize() - 1);
		setSize(getSize() - 1);
		return getElemento();
	}

	@Override
	public T primeiro() {
		setElemento(this.filaVetor.obter(filaVetor.getSize() - 1));
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
		this.filaVetor.limpar();
		setSize(0);
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterador<>(filaVetor);
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public T getElemento() {
		return elemento;
	}

	public void setElemento(T object) {
		this.elemento = (T) object;
	}

}
