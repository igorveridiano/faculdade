package PessoasBens;

public class Bens {
	
	private int CodBem;
	private String NomeBem;
	private double valor;
	private TreeABB<Integer, Pessoa> ArvorePessoa = new TreeABB<Integer,Pessoa>();;

	public Bens(int codBem, String nomeBem, double valor) {
		CodBem = codBem;
		NomeBem = nomeBem;
		this.valor = valor;
	}

	public int getCodBem() {
		return CodBem;
	}

	public void setCodBem(int codBem) {
		CodBem = codBem;
	}

	public String getNomeBem() {
		return NomeBem;
	}

	public void setNomeBem(String nomeBem) {
		NomeBem = nomeBem;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor; 
	}  
	 

	}
	
	
	
    

	




