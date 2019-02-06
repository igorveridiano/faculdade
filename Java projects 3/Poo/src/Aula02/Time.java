package Aula02;

public class Time {
	
	public String nome;
	public String estado;
	
	public Time(String nome, String estado) {
		this.nome = nome;
		this.estado = estado;
	}
	
	public void AlterarNome(String novonome) {
		this.nome = novonome;
	}
	
	public void AlterarEstado(String novoestado) {
		this.estado = novoestado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	@Override
	public String toString() {
	 	return "Time: " + nome + "  Estado: " + estado; 
 	}
	
	public static void main(String[] args) {
		Time Time1 = new Time("São Paulo", "SP");
		Time Time2 = new Time("Flamengo", "RJ");
		Time Time3 = new Time("Santos", "SP");
		System.out.println(Time1.toString());
		System.out.println(Time2.toString());
		System.out.println(Time3.toString());
	}

}
