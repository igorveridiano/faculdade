package GerenciadorShow;

import java.util.ArrayList;

public class Artista {
	
	private final int codigo;
	private String nome;
	private double ValorShow;
	private String nacionalidade;
	private int qtdShow;
	private ArrayList<Titulo> ListaTitulos;
	
	public Artista(String nome, double ValorShow, String nacionalidade){ 
	    this.codigo = Main.GerarCodigo();
		this.nome = nome;
		this.ValorShow = ValorShow;
		this.nacionalidade = nacionalidade;
		new ArrayList<Titulo>(10);
	}
	
	public boolean LancarTitulo(Titulo NovoTitulo){
		int AnosIguais = 0;
		boolean TitulosIguais = false;
		for (Titulo novotitulo : this.ListaTitulos){
			if (novotitulo.getAnoLanc() == NovoTitulo.getAnoLanc()){
				AnosIguais++;
			}
			if (NovoTitulo.equals(novotitulo)){
				TitulosIguais = true;
			}
		}
		if ((TitulosIguais == false) && (AnosIguais < 2) && (this.ListaTitulos.size() < 10)){
			System.out.println("Titulo cadastrado");
			this.ListaTitulos.add(NovoTitulo);
			return true;
		}else{
			System.out.println("O titulo não pode ser cadastrado");
			return false;
		}
	}
	
	public boolean ExcluirTitulo(int codigo){
		boolean encontrado = false;
		for (Titulo titulo : this.ListaTitulos){
			if(titulo.getCodigo() == codigo){
				encontrado = true;
			}
		}
		if (encontrado){
			System.out.println("Titulo excluido");
			this.ListaTitulos.remove(codigo);
			return true;
		}else {
			System.out.println("O titulo não existe");
			return false;
		}
	}
	
	public Titulo BuscarTitulo(int codigo){
		boolean encontrado = false;
		Titulo NomeTitulo = null;
		for (Titulo titulo : this.ListaTitulos){
			if (titulo.getCodigo() == codigo){
				NomeTitulo = titulo;
				encontrado = true;
			}
		}
		if (encontrado){
			System.out.println("Titulo: " + NomeTitulo);
			System.out.println("Codigo: " + NomeTitulo.getCodigo());
			return NomeTitulo;
		} else {
			System.out.println("O titulo não existe");
			System.out.println("Codigo: " + null);
			return NomeTitulo;
		}
		
	}
	
	public int QuantidadeTitulos(int ano){
		int NumeroDeTitulos = 0;
		for (Titulo titulo : this.ListaTitulos){
			if (titulo.getAnoLanc() == ano){
				NumeroDeTitulos++;
			}
		}
		System.out.println("Quantidade de titulos: " + NumeroDeTitulos);
		return NumeroDeTitulos;
	}
	
	public int QuantidadeTitulos(String genero){
		int NumeroTitulos = 0;
		for (Titulo titulo : this.ListaTitulos){
			if (titulo.getGenero() == genero){
				NumeroTitulos++;
			}
		}
		System.out.println("Quantidade de titulos: " + NumeroTitulos);
		return NumeroTitulos;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValorShow() {
		return ValorShow;
	}

	public void setValorShow(double valorShow) {
		ValorShow = valorShow;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public int getCodigo() {
		return codigo;
	}

 	
	public int getQtdShow() {
		return qtdShow;
	}

	public void setQtdShow(int qtdShow) {
		this.qtdShow = qtdShow;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
