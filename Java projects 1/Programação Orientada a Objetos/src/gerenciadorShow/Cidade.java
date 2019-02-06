package gerenciadorShow;

public class Cidade {
	
	private int Codigo;
	private String Nome;
	private String Estado;
	
	public Cidade  (int codigo, String nome, String estado){
		this.Codigo = codigo;
		this.Nome = nome;
		this.Estado = estado;
	}
	
	public int getCodigo() {
		return Codigo;
	}

	
	
	public void setCodigo(int codigo) {
		Codigo = codigo;
	}



	public String getNome() {
		return Nome;
	}



	public void setNome(String nome) {
		Nome = nome;
	}



	public String getEstado() {
		return Estado;
	}



	public void setEstado(String estado) {
		Estado = estado;
	}
	
	public static void main(String[] args) {
	}

}
