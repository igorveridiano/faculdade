package ME;



import ListaSimplesmenteEncadeadaComTesteDeTempoDoProjeto.ListaSimplesmenteEncadeada;

public class Turma {
	private int cod;
	public ListaSimplesmenteEncadeada<Cliente> getLista_pessoa() {
		return lista_pessoa;
	}

	public void setLista_pessoa(ListaSimplesmenteEncadeada<Cliente> lista_pessoa) {
		this.lista_pessoa = lista_pessoa;
	}

	public ListaSimplesmenteEncadeada<Cliente> getLista_reserva() {
		return lista_reserva;
	}

	public void setLista_reserva(ListaSimplesmenteEncadeada<Cliente> lista_reserva) {
		this.lista_reserva = lista_reserva;
	}

	private int numero_maximo;
	private ListaSimplesmenteEncadeada<Cliente> lista_pessoa;
	private ListaSimplesmenteEncadeada<Cliente> lista_reserva;

	public Turma(int cod, int numero_maximo) {

		this.cod = cod;
		this.numero_maximo = numero_maximo;
		this.lista_pessoa = new ListaSimplesmenteEncadeada<Cliente>();
		this.lista_reserva =new ListaSimplesmenteEncadeada<Cliente>();

	}

	public void Efetuar_reserva(Cliente cliente) {
		if (lista_pessoa.tamanho() == this.numero_maximo) {
			lista_reserva.adicionar(cliente);
			System.out.println("Entrou na reserva");
		} else {
			lista_pessoa.adicionar(cliente);
			System.out.println("Entrou na turma");
		}

	}


	public void Cancelar_reserva(Cliente cliente) {
		if (lista_reserva.tamanho() != 0) {
			lista_pessoa.remover(cliente);
			lista_pessoa.adicionar(lista_reserva.inicio.valor);
			lista_reserva.remover(lista_reserva.inicio.valor);

		} else {
			lista_pessoa.remover(cliente);
		}

	}

	public void Listar_alunos() {
		System.out.println("Lista de alunos");
		for (Cliente cliente : lista_pessoa) {
			System.out.println(cliente.getNome());
		}
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public int getNumero_maximo() {
		return numero_maximo;
	}

	public void setNumero_maximo(int numero_maximo) {
		this.numero_maximo = numero_maximo;
	}

}
