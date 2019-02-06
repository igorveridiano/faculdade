package listaSimplismenteEncadeada;

public class NoSimplesmenteEncadeado<T> {

	T valor;
	NoSimplesmenteEncadeado<T> proximo;

	public NoSimplesmenteEncadeado(T valor, NoSimplesmenteEncadeado<T> proximo) {
		this.valor = valor;
		this.proximo = proximo;
	}

	public NoSimplesmenteEncadeado(T valor) {
		this.valor = valor;
	}

	public T getValor() {
		return valor;
	}

	public void setValor(T valor) {
		this.valor = valor;
	}

	public NoSimplesmenteEncadeado<T> getProximo() {
		return proximo;
	}

	public void setProximo(NoSimplesmenteEncadeado<T> proximo) {
		this.proximo = proximo;
	}

}
