package Loja;

import ListaSimplesmenteEncadeadaComTesteDeTempoDoProjeto.ListaSimplesmenteEncadeada;

public class Produto {
	private int cod_produto;
	private String nome;
	private int qtd;
	private double custo;
	private ListaSimplesmenteEncadeada<Compra> lista_compra ;
	private ListaSimplesmenteEncadeada<Venda> lista_venda ;

	public Produto(int cod_produto, String nome, double custo) {
		this.cod_produto = cod_produto;

		this.nome = nome;
		this.qtd = 0;
		this.custo = custo;
		this.lista_venda = new ListaSimplesmenteEncadeada<Venda>();
		this.lista_compra = new ListaSimplesmenteEncadeada<Compra>();
	}

	public void Compra(int qtd,double custo){
		Compra compra=new Compra(qtd, custo);
		this.qtd+=qtd;
		lista_compra.adicionar(compra);
	}
	public void Venda(int qtd,double d){
		
		Venda venda=new Venda(qtd, d);
		this.qtd-=qtd;
		lista_venda.adicionar(venda);
	}
	public int getCod_produto() {
		return cod_produto;
	}

	public void setCod_produto(int cod_produto) {
		this.cod_produto = cod_produto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public double getCusto() {
		return custo;
	}

	public void setCusto(double custo) {
		this.custo = custo;
	}

	public ListaSimplesmenteEncadeada getLista_compra() {
		return lista_compra;
	}

	public void setLista_compra(ListaSimplesmenteEncadeada lista_compra) {
		this.lista_compra = lista_compra;
	}

	public ListaSimplesmenteEncadeada getLista_venda() {
		return lista_venda;
	}

	public void setLista_venda(ListaSimplesmenteEncadeada lista_venda) {
		this.lista_venda = lista_venda;
	}
@Override
public String toString() {// TODO Auto-generated method stub
	String saida;
	saida= String.format("%-10d %-20s %-10d %-10f ",this.cod_produto,this.nome,this.qtd,this.custo );
	
	return saida;
}
}
