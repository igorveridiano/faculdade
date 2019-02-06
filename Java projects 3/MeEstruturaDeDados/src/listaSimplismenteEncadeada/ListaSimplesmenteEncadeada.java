package listaSimplismenteEncadeada;

import java.util.Iterator;

public class ListaSimplesmenteEncadeada<T> implements IListaSimplesmenteEncadeada<T>, Iterable<T> {

	NoSimplesmenteEncadeado<T> inicio, fim;
	int tamanho;

	public ListaSimplesmenteEncadeada() {
		this.inicio = null;
		this.fim = null;
		this.tamanho = 0;
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterador<>(this);
	}

	@Override
	public boolean adicionarNoInicio(T valor) {
		NoSimplesmenteEncadeado<T> novo = new NoSimplesmenteEncadeado<>(valor, this.inicio);
		this.inicio = novo;
		if (this.tamanho == 0) {
			this.fim = this.inicio;
		}
		this.tamanho++;
		return true;
	}

	@Override
	public boolean adicionarNoFim(T valor) {
		if (this.tamanho == 0) {
			this.adicionarNoInicio(valor);
		} else {
			NoSimplesmenteEncadeado<T> novo = new NoSimplesmenteEncadeado<>(valor);
			this.fim.setProximo(novo);
			this.fim = novo;
			this.tamanho++;
		}
		return true;
	}

	@Override
	public void removerDoInicio() {
		if (!this.posicaoOcupada(0)) {
			throw new IllegalArgumentException("Posição não existe");
		}
		this.inicio = this.inicio.getProximo();
		this.tamanho--;
		if (this.tamanho == 0) {
			this.fim = null;
		}
	}

	@Override
	public void removerDoFim() {
		if (!this.posicaoOcupada(this.tamanho - 1)) {
			throw new IllegalArgumentException("Posição não existe");
		}
		if (this.tamanho == 1) {
			this.removerDoInicio();
		} else {
			boolean comparador = false;
			NoSimplesmenteEncadeado<T> primeiro = this.inicio;
			NoSimplesmenteEncadeado<T> guardar = null;
			for (int i = 0; i < this.tamanho; i++) {
				if (i == this.tamanho - 2) {
					guardar = primeiro;
					comparador = true;
					break;
				}
				primeiro = primeiro.proximo;
			}
			if (comparador) {
				this.fim = guardar;
				this.fim.proximo = null;
				this.tamanho--;
			}
		}
	}

	@Override
	public boolean adicionar(T valor) {
		if (this.tamanho == 0) {
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
		} else if (posicao == this.tamanho) {
			this.adicionarNoFim(valor);
		} else {
			NoSimplesmenteEncadeado<T> anterior = this.obterNo(posicao - 1);
			NoSimplesmenteEncadeado<T> nova = new NoSimplesmenteEncadeado<>(valor, anterior.getProximo());
			anterior.setProximo(nova);
			this.tamanho++;
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
		} else if (posicao == this.tamanho - 1) {
			this.removerDoFim();
		} else {
			boolean comparador = false;
			NoSimplesmenteEncadeado<T> primeiro = this.inicio;
			NoSimplesmenteEncadeado<T> guardar1 = null;
			NoSimplesmenteEncadeado<T> guardar2 = null;
			for (int i = 0; i < posicao + 2; i++) {
				if (i == posicao - 1) {
					guardar1 = primeiro;
				}
				if (i == posicao + 1) {
					guardar2 = primeiro;
					comparador = true;
					break;
				}
				primeiro = primeiro.proximo;
			}
			if (comparador) {
				guardar1.proximo = guardar2;
				this.tamanho--;
			}
		}
	}

	@Override
	public boolean remover(T valor) {
		boolean comparador = false;
		NoSimplesmenteEncadeado<T> primeiro = this.inicio;
		int auxiliar = 0;
		for (int j = 0; j < this.tamanho; j++) {
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
		NoSimplesmenteEncadeado<T> primeiro = this.inicio;
		NoSimplesmenteEncadeado<T> guardar = null;
		for (int i = 0; i < this.tamanho; i++) {
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
				this.tamanho--;
				return true;
			} else if (this.fim.equals(primeiro)) {
				guardar.proximo = null;
				this.fim = guardar;
				this.tamanho--;
				return true;
			} else {
				guardar.proximo = primeiro.proximo;
				this.tamanho--;
				return true;
			}
		} else {
			return false;
		}
	}

	@Override
	public boolean contem(T valor) {
		NoSimplesmenteEncadeado<T> atual = this.inicio;
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
	public int tamanho() {
		return this.tamanho;
	}

	@Override
	public void limpar() {
		NoSimplesmenteEncadeado<T> primeiro = this.inicio;
		NoSimplesmenteEncadeado<T> guardar = null;
		for (int i = 0; i < this.tamanho; i++) {
			guardar = primeiro;
			primeiro = primeiro.proximo;
			guardar.proximo = null;
			guardar = null;
		}
		this.tamanho = 0;
	}

	private NoSimplesmenteEncadeado<T> obterNo(int posicao) {
		if (!this.posicaoOcupada(posicao)) {
			throw new IllegalArgumentException("Posição não existe");
		}

		NoSimplesmenteEncadeado<T> atual = inicio;
		for (int i = 0; i < posicao; i++) {
			atual = atual.getProximo();
		}
		return atual;
	}

	private boolean posicaoOcupada(int posicao) {
		return posicao >= 0 && posicao < this.tamanho;
	}

	@Override
	public String toString() {

		if (this.tamanho == 0) {
			return "[]";
		}

		StringBuilder builder = new StringBuilder("[");
		NoSimplesmenteEncadeado<T> atual = inicio;

		for (int i = 0; i < this.tamanho - 1; i++) {
			builder.append(atual.getValor());
			builder.append(", ");
			atual = atual.getProximo();
		}

		builder.append(atual.getValor());
		builder.append("]");

		return builder.toString();
	}
}
