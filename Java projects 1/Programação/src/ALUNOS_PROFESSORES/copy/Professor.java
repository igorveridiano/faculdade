package ALUNOS_PROFESSORES.copy;

public class Professor extends Pessoa {
	private float valor_hora_aula;
	public float getValor_hora_aula() {
		return valor_hora_aula;
	}
	public void setValor_hora_aula(float valor_hora_aula) {
		this.valor_hora_aula = valor_hora_aula;
	}
	public Professor(int matricula, String nome, int quantidade_Creditos,float valor_hora_aula) {
		super(matricula, nome, quantidade_Creditos);
		this.valor_hora_aula=valor_hora_aula;
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString(){
		String saida;
		
		saida=String.format("%-20s %-35s %-10s %-10s\n",this.getMatricula(), this.getNome(), this.getQuantidade_Creditos(), this.getValor_hora_aula());
		/*StringBuilder string =new StringBuilder();
		string.append(this.getMatricula());
		while(string.length()<21){
			string.append(" ");
		}
		string.append(this.getNome());
		while(string.length()<65){
			string.append(" ");
		}
		string.append(this.getQuantidade_Creditos());
		while(string.length()<75){
			string.append(" ");
		}
		string.append(this.getQuantidade_Creditos());
		String saida;
		saida=new String(string);*/
		return saida;
		
	}

}
