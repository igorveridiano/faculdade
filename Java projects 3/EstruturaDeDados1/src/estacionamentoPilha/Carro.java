package estacionamentoPilha;

public class Carro {
	
	private String placa;
	private int numeroDaVaga;
	private int manobras = 0;
	
	public Carro(String placa){
		this.setPlaca(placa);
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public int getNumeroDaVaga() {
		return numeroDaVaga;
	}

	public void setNumeroDaVaga(int numeroDaVaga) {
		this.numeroDaVaga = numeroDaVaga;
	}

	public int getManobras() {
		return manobras;
	}

	public void setManobras(int manobras) {
		this.manobras = manobras;
	}

}
