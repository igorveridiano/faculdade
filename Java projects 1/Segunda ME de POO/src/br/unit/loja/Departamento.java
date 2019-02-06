package br.unit.loja;

import java.util.ArrayList;


public class Departamento {
	
	private int id;
	private String nome;
	private String sigla;
	private ArrayList<Funcionario> listaFuncionario;

	public Departamento (int id, String nome, String sigla){
		this.setId(id);
		this.setNome(nome);
		this.setSigla(sigla);
		new ArrayList<Funcionario>();
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

	public ArrayList<Funcionario> getListaFuncionario() {
		return listaFuncionario;
	}

	public void setListaFuncionario(ArrayList<Funcionario> listaFuncionario) {
		this.listaFuncionario = listaFuncionario;
	}

}
