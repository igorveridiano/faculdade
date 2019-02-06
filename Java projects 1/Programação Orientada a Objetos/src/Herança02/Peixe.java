package Herança02;

public class Peixe extends Animal {
	
	private int profundidade;

	public Peixe(String especie, int profundidade) {
		super(especie);
		this.setProfundidade(profundidade);
	}

	public int getProfundidade() {
		return profundidade;
	}

	public void setProfundidade(int profundidade) {
		this.profundidade = profundidade;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
