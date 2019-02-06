package VOO;

import java.util.ArrayList;

public class Voo {
	private String codigo_voo;
	private int capacidade;
	private ArrayList<Passageiro> Lista_Passageiro;
	private ArrayList<Passageiro> Lista_Espera;
	private String Destino;
	private String Origem;
	public Voo(String codigo_voo, int capacidade, 
			 String destino, String origem) {
		this.codigo_voo = codigo_voo;
		this.capacidade = capacidade;
		Lista_Passageiro = new ArrayList<>();
		Lista_Espera = new ArrayList<>();
		Destino = destino;
		Origem = origem;
	}
	
	public String getCodigo_voo() {
		return codigo_voo;
	}
	public void setCodigo_voo(String codigo_voo) {
		this.codigo_voo = codigo_voo;
	}
	public int getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	public ArrayList<Passageiro> getLista_Passageiro() {
		return Lista_Passageiro;
	}
	public void setLista_Passageiro(ArrayList<Passageiro> lista_Passageiro) {
		Lista_Passageiro = lista_Passageiro;
	}
	public ArrayList<Passageiro> getLista_Espera() {
		return Lista_Espera;
	}
	public void setLista_Espera(ArrayList<Passageiro> lista_Espera) {
		Lista_Espera = lista_Espera;
	}
	public String getDestino() {
		return Destino;
	}
	public void setDestino(String destino) {
		Destino = destino;
	}
	public String getOrigem() {
		return Origem;
	}
	public void setOrigem(String origem) {
		Origem = origem;
	}
	
	

}
