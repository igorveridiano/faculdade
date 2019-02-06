package GerenciadorShow;

import java.util.ArrayList;

public class EmpresaEventos {
	
	private int cnpj;
	private String nome;
	private ArrayList<Show> ListaShow;
	private int qtdMaxShow;
	
	public EmpresaEventos(String nome, int cnpj, int qtdMaxShow){
		this.nome = nome;
		this.cnpj = cnpj;
		new ArrayList<Show>(qtdMaxShow);
	}
	
	public boolean ContratarShow(Show show){
		boolean ShowValido = false;
		for (Show ShowContratado : this.ListaShow){
			if ((ShowContratado.getCodigo() != show.getCodigo()) && (this.ListaShow.size() < qtdMaxShow)){
				ShowValido = true;
			}
		}
		if (ShowValido){
			System.out.println("Show cadastrado");
			this.ListaShow.add(show);
			return true;
		} else {
			System.out.println("o show não pode ser cadastrado");
			return false;
		}
	}

	public int getCnpj() {
		return cnpj;
	}

	public void setCnpj(int cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Show> getListaShow() {
		return ListaShow;
	}

	public void setListaShow(ArrayList<Show> listaShow) {
		ListaShow = listaShow;
	}

	public int getQtdMaxShow() {
		return qtdMaxShow;
	}

	public void setQtdMaxShow(int qtdMaxShow) {
		this.qtdMaxShow = qtdMaxShow;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
