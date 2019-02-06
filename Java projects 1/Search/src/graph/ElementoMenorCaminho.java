package graph;

public class ElementoMenorCaminho {
	
	private String vertice;
	private boolean S = false;
	private double distancia;
	private String path;
	
	public ElementoMenorCaminho(String vertice, double distancia, String path){
		this.vertice = vertice;
		this.distancia = distancia;
		this.path = path;
	}
	
	public ElementoMenorCaminho(String vertice, double distancia){
		this.vertice = vertice;
		this.distancia = distancia;
	}
	
	public String getVertice() {
		return vertice;
	}
	public void setVertice(String vertice) {
		this.vertice = vertice;
	}
	public boolean isS() {
		return S;
	}
	public void setS(boolean s) {
		S = s;
	}
	public double getDistancia() {
		return distancia;
	}
	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	
}
