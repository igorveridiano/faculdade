package receitaFederal;

public class NotaFiscal {
	
	private int numeroNf;
	private String cpfComprador;
	private double valor;
	private int ano;
	
	public NotaFiscal(int numeroNf, String cpfComprador, double valor, int ano) {
		this.setNumeroNf(numeroNf);
		this.setCpfComprador(cpfComprador);
		this.setValor(valor);
		this.setAno(ano);
	}

	public int getNumeroNf() {
		return numeroNf;
	}

	public void setNumeroNf(int numeroNf) {
		this.numeroNf = numeroNf;
	}

	public String getCpfComprador() {
		return cpfComprador;
	}

	public void setCpfComprador(String cpfComprador) {
		this.cpfComprador = cpfComprador;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}
	
}
