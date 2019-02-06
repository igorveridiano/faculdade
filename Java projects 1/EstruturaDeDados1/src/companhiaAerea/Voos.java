package companhiaAerea;

import java.text.SimpleDateFormat;

import tabelaHash.TabelaHash;

public class Voos {
	
	TabelaHash<Integer, Voo> listaVoos;
	
	public Voos() {
		listaVoos = new TabelaHash<>();
	}
	
	public boolean CadastrarVoo(Voo voo){
		if (listaVoos.tamanho() == 0){
			listaVoos.inserir(voo.getCodigo(), voo);
			return true;
		} else {
			for (Voo vooAux : listaVoos) {
				if (vooAux.getCodigo() != voo.getCodigo()){
					listaVoos.inserir(voo.getCodigo(), voo);
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean CancelarVoo(Voo voo){
		for (Voo vooAux : listaVoos) {
			if (vooAux != null){
				if (vooAux.getCodigo() == voo.getCodigo()){
					listaVoos.remover(voo.getCodigo());
					return true;
				}
			}
		}
		return false;
	}
	
	public void ListarVoos(){
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		System.out.printf("%15s %10s %20s %20s %15s %18s %18s %25s", "Codigo", "Vagas", "Local de Saida", "Destino", "Data", "Hora da Partida",
				"Hora de Chegada", "Tipo de Voo" + "\n");
		for (Voo voo : listaVoos) {
			if (voo != null){
				System.out.printf("%15d %10d %20s %20s %15s %18s %18s %25s", voo.getCodigo(), voo.getVagas(), voo.getLocalSaida(), voo.getDestino(), 
						formato.format(voo.getData()), voo.getHoraSaida(), voo.getHoraChegada(), voo.getTipoVoo() + "\n");
			}
		}
	}
}
