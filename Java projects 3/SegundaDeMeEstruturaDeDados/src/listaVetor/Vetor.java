/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listaVetor;

import java.util.Iterator;

/**
 *
 * @author 11645
 */
public class Vetor<Tipo> implements IVetor<Tipo>, Iterable<Tipo> {

	Object[] vetor;
	private int size;
	private int tamanho;

	public Vetor() {
		vetor = new Object[10];
		setTamanho(10);
	}

	public Vetor(int tamanhoInicial) {
		vetor = new Object[tamanhoInicial];
		setTamanho(tamanhoInicial);
	}

	public Vetor(int tamanhoInicial, int incremento) {
		vetor = new Object[tamanhoInicial];
		setTamanho(tamanhoInicial);
	}

	@Override
	public boolean adicionar(Tipo valor) {
		if (vetor.length == size) {
			aumentarvetor();
		}
		if (getSize() == 0) {
			vetor[0] = valor;
			setSize(1);
		} else {
			try {
				vetor[getSize()].equals(null);
			} catch (NullPointerException a) {
				vetor[getSize()] = valor;
				setSize(getSize() + 1);
			}
		}
		return true;
	}

	@Override
	public boolean adicionar(int posicao, Tipo valor) {
		if (vetor.length == size) {
			aumentarvetor();
		}
		if (posicao >= 0 && posicao < this.vetor.length) {
			for (int i = getSize() - 1; i >= posicao; i--) {
				this.vetor[i + 1] = this.vetor[i];
			}
			this.vetor[posicao] = valor;
			setSize(getSize() + 1);
		} else {
			System.out.println("Posição inválida");
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Tipo obter(int posicao) {
		try {
			return (Tipo) this.vetor[posicao];
		} catch (ArrayIndexOutOfBoundsException e) {
			return null;
		}
	}

	@Override
	public Tipo remover(int posicao) {
		if (posicao < getSize() && posicao >= 0) {
			for (int i = posicao; i < getSize() - 1; i++) {
				this.vetor[i] = this.vetor[i + 1];
			}
			setSize(getSize() - 1);
			this.vetor[getSize()] = null;
		} else {
			System.out.println("Posição inválida");
		}
		return null;
	}

	@Override
	public boolean remover(Tipo valor) {
		for (int i = 0; i < getSize(); i++) {
			if (this.vetor[i].equals(valor)) {
				for (int x = i; x < getSize() - 1; x++) {
					this.vetor[x] = this.vetor[x + 1];
				}
				setSize(getSize() - 1);
				this.vetor[getSize()] = null;
			}
		}
		return true;
	}

	@Override
	public boolean contem(Tipo valor) {
		for (int i = 0; i < this.getSize(); i++) {
			if (valor.equals(this.vetor[i])) {
				System.out.println("O valor contem na lista");
				return true;
			}
		}
		System.out.println("O valor não contem na lista");
		return false;
	}

	@Override
	public int tamanho() {
		return this.getSize();
	}

	@Override
	public void limpar() {
		for (int x = 0; x < this.getSize(); x++) {
			this.vetor[x] = null;
		}
		setSize(0);
	}

	public void aumentarvetor() {
		Object[] novoVetor = new Object[getSize() + 10];
		System.arraycopy(this.vetor, 0, novoVetor, 0, getSize());
		this.vetor = novoVetor;
	}

	@Override
	public String toString() {
		if (this.getSize() == 0) {
			return "[]";
		}

		StringBuilder builder = new StringBuilder();
		builder.append("[");

		for (int i = 0; i < this.getSize() - 1; i++) {
			builder.append(this.vetor[i]);
			builder.append(", ");
		}

		builder.append(this.vetor[this.getSize() - 1]);
		builder.append("]");

		return builder.toString();
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	public Object[] getVetor() {
		return vetor;
	}

	public void setVetor(Object[] vetor) {
		this.vetor = vetor;
	}

	@Override
	public Iterator<Tipo> iterator() {
		return new listaVetor.Iterador<>(this);
	}

	public Iterator<Tipo> iterador() {
		return new listaVetor.IteradorAoContrario<>(this);
	}

}
