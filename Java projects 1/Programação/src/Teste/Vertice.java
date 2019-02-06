package Teste;

public class Vertice implements Comparable<Vertice> {

	private String nome;
	private boolean visitado;
	private int ordem;
	
	public Vertice(String nome) {
		this.nome = nome;
		
	}

	public String getNome() {
		return this.nome;
	}
	
	public String toString() {
	  return this.getNome();
	}
	
	public void setVisitado(boolean visitado) {
	  this.visitado = visitado;
	}
	
	public boolean isVisitado() {
	  return this.visitado;
	}
	
	public int getOrdem() {
	  return this.ordem;
	}
	
	public void setOrdem(int ordem) {
	  this.ordem = ordem;
	}
	
	public int compareTo(Vertice outro) {
	  return this.getNome().compareTo(outro.getNome());
	}
	
	
	
}
