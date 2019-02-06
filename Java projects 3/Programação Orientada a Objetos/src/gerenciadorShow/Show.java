package gerenciadorShow;

import java.util.ArrayList;
import java.util.Date;

public class Show {
	
	private final int codigo;
	private Date data;
	private final Artista artista;
	private Cidade cidade;
	private ArrayList<Cidade> ListaCidade;
	
	public Show(int codigo, Date data, Artista artista, Cidade cidade){
		this.codigo = codigo;
		this.data = data;
		this.artista = artista;
		this.cidade = cidade;
		new ArrayList<Cidade>();
	}
	
	public double getValorShow(){
		double ValorShow = artista.getValorShow();
		double Cache = ValorShow * 0.3;
		return Cache;
	}

	
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getCodigo() {
		return codigo;
	}

	public Artista getArtista() {
		return artista;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
	public ArrayList<Cidade> getListaCidade() {
		return ListaCidade;
	}


}
