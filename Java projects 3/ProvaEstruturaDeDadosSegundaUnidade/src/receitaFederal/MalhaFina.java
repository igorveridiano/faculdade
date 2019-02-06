package receitaFederal;

import fila.FilaVetor;

public class MalhaFina {
	
	private Pessoa pessoa;
	FilaVetor<Integer> filaAno = new FilaVetor<>();
	
	public MalhaFina(Pessoa pessoa, int ano) {
		this.setPessoa(pessoa);
		this.filaAno.enfileirar(ano);
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
}
