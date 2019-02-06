package estacionamentoPilha;

import pilha.PilhaVetor;

public class Estacionamento {
	
	private int vagas;
	PilhaVetor<Carro> CarrosEstacionados;
	PilhaVetor<Carro> CarrosSaindo;
	
	public Estacionamento(){
		CarrosEstacionados = new PilhaVetor<>();
		CarrosSaindo = new PilhaVetor<>();
	}
	
	public void Entrada(Carro carro){
		if(getVagas() < 10){
			System.out.println("O carro pode ser estacionado");
			System.out.println("Carro de placa " + carro.getPlaca() + " entrando");
			carro.setNumeroDaVaga(getVagas() + 1);
			CarrosEstacionados.empilhar(carro);
			setVagas(getVagas() + 1);
		} else {
			System.out.println("Não há vagas no estacionamento");
		}
	}
	
	public void Saida(Carro carro){
		boolean verificador = false;
		Carro carro2 = null;
		for (Carro carro1 : CarrosEstacionados) {
			if(carro.getPlaca().equals(carro1.getPlaca())){
				carro2 = carro1;
				carro2.setNumeroDaVaga(0);
				CarrosEstacionados.desempilhar();
				verificador = true;
			} else {
				CarrosEstacionados.desempilhar();
				carro1.setManobras(carro1.getManobras() + 1);
				CarrosSaindo.empilhar(carro1);
			}
			if(verificador){
				break;
			}
		}
		if (verificador){
			System.out.println("O carro de placa " + carro2.getPlaca() +" saiu do estacionamento" );
			for (Carro carro1 : CarrosSaindo) {
				CarrosSaindo.desempilhar();
				System.out.println("O carro de placa " + carro1.getPlaca() + " fez " + carro1.getManobras() + " manobras");
				carro1.setManobras(0);
				carro1.setNumeroDaVaga(getVagas() - 1);
				CarrosEstacionados.empilhar(carro1);
		    }
		} else {
			System.out.println("O carro de placa " + carro.getPlaca() + " não foi encontrado");
			for (Carro carro1 : CarrosSaindo) {
				CarrosSaindo.desempilhar();
				CarrosEstacionados.empilhar(carro1);
		    }
		}
	}
	
	public int getVagas() {
		return vagas;
	}
	public void setVagas(int vagas) {
		this.vagas = vagas;
	}

}
