package br.unit.loja;

import java.util.ArrayList;


public class Estado {
	
	private int id;
	private String nome;
	private String sigla;
	private ArrayList<Cidade> listaCidade;
	
	public Estado(int id, String nome, String sigla){
		this.setId(id);
		this.setNome(nome);
		this.setSigla(sigla);
		new ArrayList<Cidade>();
	}
	
	public void operation1(){	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public ArrayList<Cidade> getListaCidade() {
		return listaCidade;
	}

	public void setListaCidade(ArrayList<Cidade> listaCidade) {
		this.listaCidade = listaCidade;
	}

}
