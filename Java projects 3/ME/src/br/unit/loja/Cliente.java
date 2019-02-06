package br.unit.loja;

import java.util.ArrayList;

public class Cliente extends Pessoa {
	

	private String cpf_cnpj;
	private Cidade cidade;
	private String telefone;
	private int id; 
	private ArrayList<Venda> listaCompra;

	public Cliente(String nome, String cpf_cnpj, Cidade cidade, String telefone, int id) {
		super(nome);
		this.setCpf_cnpj(cpf_cnpj);
		this.setCidade(cidade);
		this.setTelefone(telefone);
		this.setId(id);
		new ArrayList<Venda>();
	}

	public String getCpf_cnpj() {
		return cpf_cnpj;
	}

	public void setCpf_cnpj(String cpf_cnpj) {
		this.cpf_cnpj = cpf_cnpj;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidad) {
		this.cidade = cidad;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public ArrayList<Venda> getListaCompra() {
		return listaCompra;
	}

	public void setListaCompra(ArrayList<Venda> listaCompra) {
		this.listaCompra = listaCompra;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
