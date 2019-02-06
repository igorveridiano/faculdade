package ListaSimplesmenteEncadeadaComTesteDeTempoDoProjeto;

import java.util.Iterator;

public class ListaSimplesmenteEncadeada<T> implements IListaSimplesmenteEncadeada<T>,Iterable<T>  {
	public NoSimplesmenteEncadeado<T> inicio, fim;
	int tamanho;
	

	public ListaSimplesmenteEncadeada() {
		this.inicio = null;
		this.fim = null;
		this.tamanho = 0;
	}

	@Override
	public boolean adicionarNoInicio(T valor) {
		if (this.tamanho != 0) {
			NoSimplesmenteEncadeado<T> valor1 = new NoSimplesmenteEncadeado<T>();
			valor1.valor = valor;
			valor1.proximo = this.inicio;
			this.inicio = valor1;
			this.tamanho++;

			return true;
		} else {
			NoSimplesmenteEncadeado<T> valor1 = new NoSimplesmenteEncadeado<T>();
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
			this.tamanho--;
			return this.inicio.valor;
		}
		return null;
	}

	@Override
	public T removerDoFim() {
		if (tamanho != 0) {
			NoSimplesmenteEncadeado<T> valor1 = this.inicio;
			NoSimplesmenteEncadeado<T> valor2;
			for (int i = 1; i < tamanho - 1; i++) {
				valor1 = valor1.proximo;
			}
			this.fim = valor1;
			valor2 = valor1.proximo;
			valor1.proximo = null;
			this.tamanho--;
			return valor2.valor;
		} else {
			return null;
		}
	}

	@Override
	public boolean adicionar(T valor) {
		if (this.tamanho == 0) {
			this.adicionarNoInicio(valor);
		} else {
			NoSimplesmenteEncadeado<T> valor1 = new NoSimplesmenteEncadeado<T>();
			valor1.valor = valor;
			this.fim.proximo = valor1;
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
			{
				NoSimplesmenteEncadeado<T> valor1 = this.inicio;
				NoSimplesmenteEncadeado<T> valor2 = new NoSimplesmenteEncadeado<>();
				NoSimplesmenteEncadeado<T> valor3 = new NoSimplesmenteEncadeado<T>();
				for (int i = 0; i < posicao; i++) {
					valor2 = valor1;

					valor1 = valor1.proximo;
				}
				valor3.valor = valor;
				valor3.proximo = valor1;
				valor2.proximo = valor3;
				this.tamanho++;
				return true;
			}
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
		if (posicao < tamanho) {

			NoSimplesmenteEncadeado<T> valor1 = this.inicio;

			for (int i = 0; i < posicao; i++) {
				valor1 = valor1.proximo;
			}
			return valor1.valor;
		} else {
			return null;
		}
	}

	@Override
	public T remover(int posicao) {
		if (posicao <= tamanho) {

			NoSimplesmenteEncadeado<T> valor1 = this.inicio;
			NoSimplesmenteEncadeado<T> valor2 = new NoSimplesmenteEncadeado<T>();
			for (int i = 0; i < posicao; i++) {
				valor2 = valor1;
				valor1 = valor1.proximo;
			}
			valor2.proximo = valor1.proximo;
			this.tamanho--;
			return valor1.valor;
		} else {
			return null;
		}
	}

	@Override
	public boolean remover(T valor) {
		boolean flag = false;
		NoSimplesmenteEncadeado<T> valor1 = this.inicio;
		NoSimplesmenteEncadeado<T> valor2 = new NoSimplesmenteEncadeado<T>();
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
				this.tamanho--;
				return true;
			}
			valor2.proximo = valor1.proximo;
			this.tamanho--;
			return true;
		} else {
			return false;
		}
	}
	
	public boolean contemRecursivo(T valor) {
		return contem(valor, inicio);
	}

	private boolean contem(T valor, NoSimplesmenteEncadeado<T> corrente) {
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

		NoSimplesmenteEncadeado<T> valor1 = this.inicio;
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
		NoSimplesmenteEncadeado<T> celula = this.inicio;
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
		return new Iterador<T>(this);
		//return  new ListaSimplesmenteEncadeada().Iterator<T>(this);
	}
	



}
