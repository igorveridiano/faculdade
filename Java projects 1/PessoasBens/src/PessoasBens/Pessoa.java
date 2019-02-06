package PessoasBens;



public class Pessoa implements Comparable<Pessoa> {

	private int Cod_Pessoa;
	private String Nome;
	private TreeABB<Integer, Bens> ValorBens;

	public Pessoa(int cod_Pessoa, String nome) {
		Cod_Pessoa = cod_Pessoa;
		Nome = nome;
		ValorBens = new TreeABB<>();
	}

	public int getCod_Pessoa() {
		return Cod_Pessoa;
	}

	public void setCod_Pessoa(int cod_Pessoa) {
		Cod_Pessoa = cod_Pessoa;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	@Override
	public int compareTo(Pessoa elemento) {
		if (this.getCod_Pessoa() > elemento.getCod_Pessoa()) {
			return 1;
		} else if (this.getCod_Pessoa() < elemento.getCod_Pessoa()) {
			return -1;
		} else {
			return 0;
		}

	}

	@Override
	public String toString() {
		return this.getCod_Pessoa() + " - " + this.getNome();
	}

	

	public void AddBemPessoa(Bens b) {
		this.ValorBens.inserirElemento(b.getCodBem(), b);
	}
	
	
	// verificar
	public void ExcluirBem (int chaveBem) {
		this.ValorBens.removeElemento(chaveBem);
		
		
	
}
	
	public double Vbens(){
		double valorBens=0;
		
		   for (Bens b :ValorBens.listElements())valorBens+=b.getValor(); 
			
		   return valorBens;
		
	}
	public void ListBens() {
		System.out.println("Codigo Pessoa:" + this.Cod_Pessoa + "          Nome:" + this.Nome);
		System.out.println();
		System.out.println("Relação de Bens");
		System.out.println();
		System.out.println("CodBem   Nome do Bem                                               Valor");
		System.out.println("------   ---------------------------------------------   ---------------");

		//System.out.println(ValorBens.listElements());
		for (Bens b : ValorBens.listElements()) {
			System.out.println(b.getCodBem() + "         " + b.getNomeBem() + "                                       "
					+ b.getValor());
		}

	}
}


	

