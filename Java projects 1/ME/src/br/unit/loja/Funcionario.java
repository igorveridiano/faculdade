package br.unit.loja;

import java.util.ArrayList;


public class Funcionario extends Pessoa implements IComissao{
	
	
	private String matricula;
	private String senha;
	private Departamento departamento;
	private int id; 
	private ArrayList<Venda> listaVenda;

	public Funcionario(String nome, String matricula, String senha, Departamento departamento, int id) {
		super(nome);
		this.setMatricula(matricula);
		this.setSenha(senha);
		this.setDepartamento(departamento);
		this.setId(id);
		new ArrayList<Venda>();
	}
	
	@Override
	public float GerarComissao(int mes, int ano) {
		float comissao = 0;
		for (Venda venda : listaVenda) {
			if ((venda.getData().getMonthValue() == mes) && (venda.getData().getYear() == ano)){
				comissao = (float) (venda.getPrecoTotal() * 0.1);
			} 
		}
		return comissao;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public ArrayList<Venda> getListaVenda() {
		return listaVenda;
	}

	public void setListaVenda(ArrayList<Venda> listaVenda) {
		this.listaVenda = listaVenda;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
