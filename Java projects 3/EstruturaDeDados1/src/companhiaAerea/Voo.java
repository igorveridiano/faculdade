package companhiaAerea;

import java.util.Date;

import fila.FilaDupEnc;
import listaDuplamenteEncadeada.ListaDuplamenteEncadeada;

public class Voo {
	
	private int codigo;
	private int vagas;
	private String localSaida;
	private String destino;
	private Date data;
	private String horaSaida;
	private String horaChegada;
	private String tipoVoo;
	ListaDuplamenteEncadeada<Cliente> listaPassageiros;
	FilaDupEnc<Cliente> listaEspera;
	
	public Voo(int codigo, int vagas, String localSaida, String destino, Date data, String horaSaida, String horaChegada, String tipoVoo) {
		this.setCodigo(codigo);
		this.setVagas(vagas);
		this.setLocalSaida(localSaida);
		this.setDestino(destino);
		this.setData(data);
		this.setHoraSaida(horaSaida);
		this.setHoraChegada(horaChegada);
		this.setTipoVoo(tipoVoo);
		listaPassageiros = new ListaDuplamenteEncadeada<>();
		listaEspera = new FilaDupEnc<>();
	}
	
	public boolean EfetuarReserva(Cliente cliente){
		if (listaPassageiros.tamanho() < getVagas()){
			listaPassageiros.adicionar(cliente);
			AvisoListaPassageiro();
			return true;
		} else {
			listaEspera.enfileirar(cliente);
			AvisoListaEspera();
			return true;
		}
	}
	
	public void AvisoListaEspera(){
		System.out.println("Voo lotado, você foi colocado na lista de espera, caso haja uma desistencia a depender da sua posição na fila de " + "\n"
				+ "espera, você será repassado para a lista de passageiros e recebera um aviso");
	}
	
	public void AvisoListaPassageiro(){
		System.out.println("A reserva foi efetuada com sucesso");
	}
	
	public boolean CancelarReserva(Cliente cliente){
		Cliente clienteMovido;
		for (Cliente clienteAux : listaPassageiros) {
			if (clienteAux.getCpf().equals(cliente.getCpf())){
				listaPassageiros.remover(cliente);
				clienteMovido = listaEspera.desenfileirar();
				listaPassageiros.adicionar(clienteMovido);
				AvisoListaEspera(clienteMovido);
				return true;
			}
		}
		return false;
	}
	
	public void AvisoListaEspera(Cliente cliente){
		System.out.println("Mandar um e-mail para o cliente " + cliente.getNome() + " avisando que ele está na lista de passageiros do voo agora");
	}
	
	public void ListarPassageiros(){
		System.out.printf("%20s %14s %15s %30s", "Nome", "CPF", "Telefone", "E-mail" + "\n");
		for (Cliente cliente : listaPassageiros) {
			System.out.printf("%20s %14s %15s %30s", cliente.getNome(), cliente.getCpf(), cliente.getTelefone(), cliente.getEmail() + "\n");
		}
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getLocalSaida() {
		return localSaida;
	}

	public void setLocalSaida(String localSaida) {
		this.localSaida = localSaida;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getHoraSaida() {
		return horaSaida;
	}

	public void setHoraSaida(String horaSaida) {
		this.horaSaida = horaSaida;
	}

	public String getHoraChegada() {
		return horaChegada;
	}

	public void setHoraChegada(String horaChegada) {
		this.horaChegada = horaChegada;
	}

	public String getTipoVoo() {
		return tipoVoo;
	}

	public void setTipoVoo(String tipoVoo) {
		this.tipoVoo = tipoVoo;
	}

	public int getVagas() {
		return vagas;
	}

	public void setVagas(int vagas) {
		this.vagas = vagas;
	}
}
