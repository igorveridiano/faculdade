package br.unit.loja;

import java.util.ArrayList;


public class Cidade {
	
	private int id;
	private String nome;
	private String sigla;
	private Estado estado;
	private ArrayList<Endereco> listaEndereco;
	private ArrayList<Cliente> listaCliente;

	public Cidade(int id, String nome, String sigla, Estado estado){
		this.setId(id);
		this.setNome(nome);
		this.setSigla(sigla);
		this.setEstado(estado);
		new ArrayList<Endereco>();
		new ArrayList<Cliente>();
	}
	
	public void adicionarEndereco(Endereco endereco){
		listaEndereco.add(endereco);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<Endereco> getListaEndereco() {
		return listaEndereco;
	}

	public void setListaEndereco(ArrayList<Endereco> listaEndereco) {
		this.listaEndereco = listaEndereco;
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

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public ArrayList<Cliente> getListaCliente() {
		return listaCliente;
	}

	public void setListaCliente(ArrayList<Cliente> listaCliente) {
		this.listaCliente = listaCliente;
	}

}
