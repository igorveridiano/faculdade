package ALUNOS_PROFESSORES;

public class Aluno extends Pessoa {

	public Aluno(int matricula, String nome, int quantidade_Creditos) {
		super(matricula, nome, quantidade_Creditos);
		// TODO Auto-generated constructor stub
	}
	public String toString(){
		String saida;
		
		saida=String.format("%-20s %-35s %-10s %-10s\n",this.getMatricula(), this.getNome(), this.getQuantidade_Creditos(), "--------");
		/*StringBuilder string =new StringBuilder();
		string.append(this.getMatricula());
		while(string.length()<20){
			string.append(" ");
		}
		string.append(this.getNome());
		while(string.length()<55){
			string.append(" ");
		}
		string.append(this.getQuantidade_Creditos());
		while(string.length()<65){
			string.append(" ");
		}
		string.append("----- ");
		String saida;
		saida=new String(string);*/
		return saida;
		
	}

}
