package listaDuplamenteEncadeada;

import java.util.Iterator;

public class ListaDuplamenteEncadeada<T> implements IListaDuplamenteEncadeada<T>, Iterable<T> {

	NoDuplamenteEncadeado<T> inicio, fim;
	int size;

	public ListaDuplamenteEncadeada() {
		this.inicio = null;
		this.fim = null;
		this.size = 0;
	}

	@Override
	public boolean adicionarNoInicio(T valor) {
		if (this.size == 0) {
			NoDuplamenteEncadeado<T> novo = new NoDuplamenteEncadeado<>(valor);
			this.inicio = novo;
			this.fim = novo;
		} else {
			NoDuplamenteEncadeado<T> novo = new NoDuplamenteEncadeado<>(valor, this.inicio);
			this.inicio.setAnterior(novo);
			this.inicio = novo;
		}
		this.size++;
		return true;
	}

	@Override
	public boolean adicionarNoFim(T valor) {
		if (this.size == 0) {
			this.adicionarNoInicio(valor);
		} else {
			NoDuplamenteEncadeado<T> novo = new NoDuplamenteEncadeado<>(valor);
			this.fim.setProximo(novo);
			novo.setAnterior(this.fim);
			this.fim = novo;
			this.size++;
		}
		return true;
	}

	@Override
	public void removerDoInicio() {
		if (!this.posicaoOcupada(0)) {
			throw new IllegalArgumentException("Posição não existe");
		}
		this.inicio = this.inicio.getProximo();
		this.size--;
		if (this.size == 0) {
			this.fim = null;
		}
	}

	@Override
	public void removerDoFim() {
		if (!this.posicaoOcupada(this.size - 1)) {
			throw new IllegalArgumentException("Posição não existe");
		}
		if (this.size == 1) {
			this.removerDoInicio();
		} else {
			boolean comparador = false;
			NoDuplamenteEncadeado<T> primeiro = this.inicio;
			NoDuplamenteEncadeado<T> guardar = null;
			for (int i = 0; i < this.size; i++) {
				if (i == this.size - 2) {
					guardar = primeiro;
					comparador = true;
					break;
				}
				primeiro = primeiro.proximo;
			}
			if (comparador) {
				this.fim = guardar;
				this.fim.proximo = null;
				this.size--;
			}
		}
	}

	@Override
	public boolean adicionar(T valor) {
		if (this.size == 0) {
			this.adicionarNoInicio(valor);
		} else {
			this.adicionarNoFim(valor);
		}
		return true;
	}

	@Override
	public boolean adicionar(int posicao, T valor) {
		if (posicao == 0) {
			this.adicionarNoInicio(valor);
		} else if (posicao == this.size) {
			this.adicionarNoFim(valor);
		} else {
			NoDuplamenteEncadeado<T> anterior = this.obterNo(posicao - 1);
			NoDuplamenteEncadeado<T> proximo = anterior.getProximo();
			NoDuplamenteEncadeado<T> novo = new NoDuplamenteEncadeado<>(valor, anterior.getProximo());
			novo.setAnterior(anterior);
			anterior.setProximo(novo);
			proximo.setAnterior(novo);
			this.size++;
		}
		return true;
	}

	@Override
	public T obter(int posicao) {
		try {
			return this.obterNo(posicao).getValor();
		} catch (NullPointerException | IllegalArgumentException e) {
			return null;
		}
	}

	@Override
	public void remover(int posicao) {
		if (!this.posicaoOcupada(posicao)) {
			throw new IllegalArgumentException("Posição não existe");
		}
		if (posicao == 0) {
			this.removerDoInicio();
		} else if (posicao == this.size - 1) {
			this.removerDoFim();
		} else {
			NoDuplamenteEncadeado<T> anterior = this.obterNo(posicao - 1);
			NoDuplamenteEncadeado<T> atual = anterior.getProximo();
			NoDuplamenteEncadeado<T> proximo = atual.getProximo();
			anterior.setProximo(proximo);
			proximo.setAnterior(anterior);
			this.size--;
		}
	}

	@Override
	public boolean remover(T valor) {
		boolean comparador = false;
		NoDuplamenteEncadeado<T> primeiro = this.inicio;
		int auxiliar = 0;
		for (int j = 0; j < this.size; j++) {
			if (j != 0) {
				primeiro = primeiro.proximo;
			}
			if (primeiro.valor.equals(valor)) {
				auxiliar++;
			}
		}
		for (int i = 0; i < auxiliar; i++) {
			comparador = removerAuxiliar(valor);
		}
		if (comparador) {
			return true;
		} else {
			System.out.println("Valor não encontrado");
			return false;
		}
	}

	public boolean removerAuxiliar(T valor) {
		boolean comparador = false;
		NoDuplamenteEncadeado<T> primeiro = this.inicio;
		NoDuplamenteEncadeado<T> guardar = null;
		for (int i = 0; i < this.size; i++) {
			guardar = primeiro;
			if (i != 0) {
				primeiro = primeiro.proximo;
			}
			if (primeiro.valor.equals(valor)) {
				comparador = true;
				break;
			}
		}
		if (comparador) {
			if (this.inicio.equals(primeiro)) {
				this.inicio = primeiro.proximo;
				primeiro.proximo.anterior = null;
				this.size--;
				return true;
			} else if (this.fim.equals(primeiro)) {
				guardar.proximo = guardar;
				this.fim = guardar;
				this.size--;
				return true;
			} else {
				guardar.proximo = primeiro.proximo;
				primeiro.proximo.anterior = guardar;
				this.size--;
				return true;
			}
		} else {
			return false;
		}
	}

	@Override
	public boolean contem(T valor) {
		NoDuplamenteEncadeado<T> atual = this.inicio;
		while (atual != null) {
			if (atual.getValor().equals(valor)) {
				System.out.println("O valor contem na lista");
				return true;
			}
			atual = atual.getProximo();
		}
		System.out.println("O valor não contem na lista");
		return false;
	}

	@Override
	public int getSize() {
		return this.size;
	}

	@Override
	public void limpar() {
		NoDuplamenteEncadeado<T> primeiro = this.inicio;
		NoDuplamenteEncadeado<T> guardar = null;
		for (int i = 0; i < this.size; i++) {
			guardar = primeiro;
			primeiro = primeiro.proximo;
			guardar.proximo = null;
			guardar.anterior = null;
			guardar = null;
		}
		this.size = 0;
	}

	private NoDuplamenteEncadeado<T> obterNo(int posicao) {
		if (!this.posicaoOcupada(posicao)) {
			throw new IllegalArgumentException("Posição não existe");
		}

		NoDuplamenteEncadeado<T> atual = inicio;
		for (int i = 0; i < posicao; i++) {
			atual = atual.getProximo();
		}
		return atual;
	}

	private boolean posicaoOcupada(int posicao) {
		return posicao >= 0 && posicao < this.size;
	}

	@Override
	public String toString() {

		if (this.size == 0) {
			return "[]";
		}

		StringBuilder builder = new StringBuilder("[");
		NoDuplamenteEncadeado<T> atual = inicio;

		for (int i = 0; i < this.size - 1; i++) {
			builder.append(atual.getValor());
			builder.append(", ");
			atual = atual.getProximo();
		}

		builder.append(atual.getValor());
		builder.append("]");

		return builder.toString();
	}

	public NoDuplamenteEncadeado<T> getInicio() {
		return inicio;
	}

	public NoDuplamenteEncadeado<T> getFim() {
		return fim;
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterador<>(this);
	}

}
