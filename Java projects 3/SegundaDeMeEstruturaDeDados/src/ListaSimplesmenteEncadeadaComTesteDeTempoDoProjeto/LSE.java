package ListaSimplesmenteEncadeadaComTesteDeTempoDoProjeto;



public class LSE {
	public static void main(String []args){
		ListaSimplesmenteEncadeada <Integer>  LSE = new ListaSimplesmenteEncadeada<>();
	        Integer numero =3;
	       
	        LSE.adicionar(2);
	        System.out.println(LSE.toString());
	        LSE.adicionar(3);
	        System.out.println(LSE.toString());
	        LSE.adicionarNoInicio(4);
	        System.out.println(LSE.toString());
	        LSE.adicionar(8, 6);
	        System.out.println(LSE.toString());
	        LSE.adicionar(0, 8);
	        System.out.println(LSE.toString());
	        LSE.adicionar(1,7);
	        System.out.println(LSE.toString());
	        LSE.adicionar(5, 9);
	        System.out.println(LSE.toString());
	        if(LSE.contem(9)){
	        System.out.println("Contem");
	        }
	        else{
	        System.out.println("Nao contem");
	        }
	        if(LSE.contemRecursivo(10)){
		        System.out.println("Contem");
		        }
		        else{
		        System.out.println("Nao contem");
		        }
	        LSE.remover(2);
	        System.out.println(LSE.toString());
	        LSE.remover(10);
	        System.out.println(LSE.toString());
	        LSE.remover(numero);
	        System.out.println(LSE.toString());
	        System.out.println( LSE.obter(1));			
	        LSE.limpar();
	        System.out.println(LSE.toString());
	    
	}
}
