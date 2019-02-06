package gerenciadorShow;

public class Titulo {
	
	private int codigo;
	private final String genero;
	private String descricao;
	private final int anoLanc;
	
	public Titulo (String genero, String descricao, int anoLanc){
		this.codigo = Main.GerarCodigo();
		this.genero = genero;
		this.descricao = descricao;
		this.anoLanc = anoLanc;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getGenero() {
		return genero;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getAnoLanc() {
		return anoLanc;
	}

}
