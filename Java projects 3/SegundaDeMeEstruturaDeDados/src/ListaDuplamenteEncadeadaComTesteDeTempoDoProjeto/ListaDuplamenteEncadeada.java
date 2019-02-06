package ListaDuplamenteEncadeadaComTesteDeTempoDoProjeto;

import java.util.Iterator;

public class ListaDuplamenteEncadeada<T> implements IListaDuplamenteEncadeada<T>, Iterable<T> {
	NoDuplamenteEncadeado<T> inicio, fim;
	int tamanho;

	public ListaDuplamenteEncadeada() {
		this.inicio = null;
		this.fim = null;
		this.tamanho = 0;
	}

	@Override
	public boolean adicionarNoInicio(T valor) {
		if (this.tamanho != 0) {
			NoDuplamenteEncadeado<T> valor1 = new NoDuplamenteEncadeado<T>();
			valor1.valor = valor;
			valor1.proximo = this.inicio;
			this.inicio.anterior = valor1;
			this.inicio = valor1;
			this.tamanho++;

			return true;
		} else {
			NoDuplamenteEncadeado<T> valor1 = new NoDuplamenteEncadeado<T>();
			valor1.valor = valor;
			this.inicio = valor1;
			this.tamanho++;
			this.fim = valor1;
			return true;
		}

	}

	@Override
	public T removerDoInicio() {
		if (tamanho > 0) {
			this.inicio = this.inicio.proximo;
			this.inicio.anterior = null;
			this.tamanho--;
			return this.inicio.valor;
		}
		return null;
	}

	@Override
	public T removerDoFim() {
		if (tamanho != 0) {
			NoDuplamenteEncadeado<T> no = this.fim;
			this.fim = this.fim.anterior;

			this.fim.proximo = null;
			this.tamanho--;
			return no.valor;

		} else {
			return null;
		}
	}

	@Override
	public boolean adicionar(T valor) {
		if (this.tamanho == 0) {
			this.adicionarNoInicio(valor);
		} else {
			NoDuplamenteEncadeado<T> valor1 = new NoDuplamenteEncadeado<T>();
			valor1.valor = valor;
			this.fim.proximo = valor1;
			valor1.anterior = this.fim;
			this.fim = valor1;
			this.tamanho++;
		}

		return true;
	}

	@Override
	public boolean adicionar(int posicao, T valor) {
		if (posicao < tamanho) {
			if (posicao == 0) {
				this.adicionarNoInicio(valor);
				return true;
			}
			if (posicao <= (tamanho / 2)) {
				NoDuplamenteEncadeado<T> valor1 = this.inicio;
				NoDuplamenteEncadeado<T> valor2 = new NoDuplamenteEncadeado<T>();
				for (int i = 0; i < posicao; i++) {

					valor1 = valor1.proximo;
				}
				valor2.valor = valor;
				valor2.proximo = valor1;
				valor2.anterior = valor1.anterior;
				valor1.anterior = valor2;
				valor2.anterior.proximo = valor2;
			} else {
				NoDuplamenteEncadeado<T> valor1 = this.fim;
				NoDuplamenteEncadeado<T> valor2 = new NoDuplamenteEncadeado<T>();
				for (int i = tamanho - 1; i > posicao; i--) {
					valor1 = valor1.anterior;
				}
				valor2.valor = valor;
				valor2.proximo = valor1;
				valor2.anterior = valor1.anterior;
				valor1.anterior = valor2;
				valor2.anterior.proximo = valor2;
			}
			this.tamanho++;
			return true;

		}
		if (posicao > tamanho) {
			return false;
		}

		if (posicao == tamanho) {
			this.adicionar(valor);
			return true;
		}
		return false;
	}

	@Override
	public T obter(int posicao) {
		NoDuplamenteEncadeado<T> valor1;
		if (posicao < tamanho) {
			if (posicao <= (tamanho / 2)) {
				valor1 = this.inicio;

				for (int i = 0; i < posicao; i++) {
					valor1 = valor1.proximo;
				}
			} else {
				valor1 = this.fim;
				for (int i = tamanho - 1; i > posicao; i--) {
					valor1 = valor1.anterior;
				}
			}
			return valor1.valor;
		} else {
			return null;
		}
	}

	@Override
	public T remover(int posicao) {
		if (posicao <= tamanho) {
			NoDuplamenteEncadeado<T> valor1;
			if (posicao <= (tamanho / 2)) {
				valor1 = this.inicio;
				NoDuplamenteEncadeado<T> valor2 = new NoDuplamenteEncadeado<T>();
				for (int i = 0; i < posicao; i++) {
					valor2 = valor1;
					valor1 = valor1.proximo;
				}
				valor2.proximo = valor1.proximo;
				valor2.proximo.anterior = valor2;
			} else {
				valor1 = this.fim;
				NoDuplamenteEncadeado<T> valor2 = new NoDuplamenteEncadeado<T>();
				for (int i = tamanho - 1; i > posicao; i--) {

					valor2 = valor1;
					valor1 = valor1.anterior;
				}
				valor2.anterior = valor1.anterior;
				valor2.anterior.proximo = valor2;
			}
			this.tamanho--;
			return valor1.valor;
		} else {
			return null;
		}
	}

	@Override
	public boolean remover(T valor) {
		boolean flag = false;
		NoDuplamenteEncadeado<T> valor1 = this.inicio;
		NoDuplamenteEncadeado<T> valor2 = new NoDuplamenteEncadeado<T>();
		for (int i = 0; i < tamanho; i++) {

			valor2 = valor1;

			if (i != 0) {
				valor1 = valor1.proximo;
			}
			if (valor1.valor.equals(valor)) {
				flag = true;

				break;
			}

		}
		if (flag) {
			if (this.inicio.equals(valor1)) {
				this.inicio = valor1.proximo;
				if (this.tamanho() != 1) {
					this.inicio.anterior = null;
				}
				this.tamanho--;
				return true;

			}
			valor2.proximo = valor1.proximo;
			valor2.proximo.anterior = valor2;
			this.tamanho--;
			return true;
		} else {
			return false;
		}
	}

	public boolean contemRecursivo(T valor) {
		return contem(valor, inicio);
	}

	private boolean contem(T valor, NoDuplamenteEncadeado<T> corrente) {
		if (corrente == null) {
			return false;
		}

		if (corrente.valor.equals(valor)) {
			return true;
		}

		return contem(valor, corrente.proximo);
	}

	@Override
	public boolean contem(T valor) {

		NoDuplamenteEncadeado<T> valor1 = this.inicio;
		for (int i = 0; i < tamanho; i++) {
			if (i != 0) {
				valor1 = valor1.proximo;
			}
			if (valor1.valor.equals(valor)) {
				return true;
			}
		}

		return false;

	}

	@Override
	public int tamanho() {

		return tamanho;
	}

	@Override
	public void limpar() {
		this.inicio = null;
		this.fim = null;
		this.tamanho = 0;
	}

	public String toString() {
		if (tamanho == 0) {
			return "{ }";
		}
		NoDuplamenteEncadeado<T> celula = this.inicio;
		StringBuilder string = new StringBuilder();
		string.append("{ ");

		for (int i = 0; i < tamanho - 1; i++) {
			string.append(celula.valor);
			string.append(", ");
			celula = celula.proximo;
		}

		string.append(celula.valor);
		string.append(" }");
		// String saida;
		// saida=new String(string);
		// return saida;
		return string.toString();
	}

	@Override

	public Iterator<T> iterator() {
		return new IteradorLDE<T>(this);
		// return new ListaSimplesmenteEncadeada().Iterator<T>(this);
	}

}
