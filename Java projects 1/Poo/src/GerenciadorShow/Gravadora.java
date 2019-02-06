package GerenciadorShow;

import java.util.ArrayList;

public class Gravadora {
	
	private final int codigo;
	private String nome;
	private final String sede;
	private ArrayList<Artista> ListaArtista;
	
	public Gravadora(String nome, String sede, int qtdArtistas){
		this.codigo = Main.GerarCodigo();
		this.nome = nome;
		this.sede = sede;
		new ArrayList<Artista>(qtdArtistas) ;
	}
	
	public boolean ContratarArtista(Artista artista){
		boolean ArtistaValido = false;
		for (Artista ContratarArtista : this.ListaArtista){
			if (ContratarArtista.getCodigo() != artista.getCodigo()){
				ArtistaValido = true;
			}
		}
		if (ArtistaValido){
			System.out.println("Artista contratado");
			this.ListaArtista.add(artista);
			return true;
		} else {
			System.out.println("O artista ja se encontra contratado pela gravadora");
			return false;
		}
	}
	
	public boolean DemitirArtista(int codigo){
		boolean ArtistaEncontrado = false;
		for (Artista artista : this.ListaArtista){
			if (artista.getCodigo() == codigo){
				ArtistaEncontrado = true;
			}
		}
		if (ArtistaEncontrado){
			System.out.println("Artista demitido");
			this.ListaArtista.remove(codigo);
			return true;
		} else {
			System.out.println("Artista não encontrado");
			return false;
		}
	}
	
	public double VenderShow(int CodigoArtista){
		double ValorShow = 0;
		boolean ArtistaEncontrado = false;
		for (Artista artista : this.ListaArtista){
			if (artista.getCodigo() == CodigoArtista){
				ValorShow = artista.getValorShow();
				artista.setQtdShow(artista.getQtdShow() + 1);
				ArtistaEncontrado = true;
			}
		}
		if (ArtistaEncontrado){
			System.out.println("Valor do Show: R$ " + ValorShow);
			return ValorShow;
		} else {
			System.out.println("-1");
			return ValorShow;
		}
	}
	
	public String ArtistaShow(Artista artistas){
		String nome = null;
		for (Artista artista : this.ListaArtista){
			if (artista.getQtdShow() > artistas.getQtdShow()){
				nome = artista.getNome();
			}
		}
		System.out.println("Artista: " + nome);
		return nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getSede() {
		return sede;
	}
	public ArrayList<Artista> getListaArtista() {
		return ListaArtista;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
