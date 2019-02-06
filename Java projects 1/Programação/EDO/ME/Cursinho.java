package ME;



import ListaSimplesmenteEncadeadaComTesteDeTempoDoProjeto.ListaSimplesmenteEncadeada;

public class Cursinho {
	private ListaSimplesmenteEncadeada<Turma> lista_turma;
	private ListaSimplesmenteEncadeada<Cliente> lista_cliente;

	public Cursinho() {
		this.lista_turma = new ListaSimplesmenteEncadeada<Turma>();
		this.lista_cliente = new ListaSimplesmenteEncadeada<Cliente>();
	}

	public void Cadastrar_cliente(Cliente cliente) {
		this.lista_cliente.adicionar(cliente);
	}

	public void Cadastrar_turma(Turma turma) {
		this.lista_turma.adicionar(turma);
	}

	public void Cancelar_Turma(Turma turma) {
		this.lista_turma.remover(turma);
	}

	public void listar_turmas() {
		System.out.printf("%-25s %-25s %-25s %-25s \n","Codigo da turma","Número de vagas","Número de alunos","Tamanho da fila de espera");
		for (Turma turma : lista_turma) {
			System.out.printf("%-25d %-25d %-25d %-25d\n ",turma.getCod(),turma.getNumero_maximo(),turma.getLista_pessoa().tamanho(),turma.getLista_reserva().tamanho());
		}
		
	}

	public ListaSimplesmenteEncadeada<Turma> getLista_turma() {
		return lista_turma;
	}

	public void setLista_turma(ListaSimplesmenteEncadeada<Turma> lista_turma) {
		this.lista_turma = lista_turma;
	}

	public ListaSimplesmenteEncadeada<Cliente> getLista_cliente() {
		return lista_cliente;
	}

	public void setLista_cliente(ListaSimplesmenteEncadeada<Cliente> lista_cliente) {
		this.lista_cliente = lista_cliente;
	}
}


