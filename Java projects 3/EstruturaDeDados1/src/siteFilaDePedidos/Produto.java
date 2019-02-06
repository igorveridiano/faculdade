package siteFilaDePedidos;


public class Produto {
	
	private String nome;
	private int id;
	private int quantidade;
	private int quantidadeVendida;
	private float precoDaCompra;
	private float precoUnitario;
	
	public Produto (String nome, int id, int quantidade, float precoDaCompra){
		setNome(nome);
		setId(id);
		setQuantidade(quantidade);
		setPrecoDaCompra(precoDaCompra);
		setPrecoUnitario(precoDaCompra);
	}
	
	public void CompraDeProdutoEmEstoque (int quantidade, float precoDaCompra){
		setPrecoDaCompra(precoDaCompra + getPrecoDaCompra());
		setQuantidade(quantidade + getQuantidade());
		setPrecoUnitario(getPrecoDaCompra());
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getPrecoDaCompra() {
		return precoDaCompra;
	}
	public void setPrecoDaCompra(float precoDaCompra) {
		this.precoDaCompra = precoDaCompra;
	}
	public float getPrecoUnitario() {
		return precoUnitario;
	}
	public void setPrecoUnitario(float precoDaCompra) {
		this.precoUnitario = (float) ((precoDaCompra/getQuantidade()) * 1.5);
	}

	public int getQuantidadeVendida() {
		return quantidadeVendida;
	}

	public void setQuantidadeVendida(int quantidadeVendida) {
		this.setQuantidade(getQuantidade() - quantidadeVendida);
	}
	

}
