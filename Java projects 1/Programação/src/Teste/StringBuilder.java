package Teste;

public class StringBuilder {
	public static void main(String[]args){
		String string="";
		StringBuffer sb=new StringBuffer();
		sb.insert(-20, "Matricula");
		sb.insert(-10, "Nome");
		sb.insert(-10, "Idade");
		string =new String(sb);
		System.out.println(string);
		
		
	}
}
