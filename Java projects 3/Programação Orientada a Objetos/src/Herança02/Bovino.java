package Herança02;

public class Bovino extends Animal {
	
	private float producaoLeite; 

	public Bovino(String especie, float producaoLeite) {
		super(especie);
		this.setProducaoLeite(producaoLeite);
	}

	public float getProducaoLeite() {
		return producaoLeite;
	}

	public void setProducaoLeite(float producaoLeite) {
		this.producaoLeite = producaoLeite;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
