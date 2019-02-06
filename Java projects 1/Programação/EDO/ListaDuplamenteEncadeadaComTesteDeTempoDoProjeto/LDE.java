package ListaDuplamenteEncadeadaComTesteDeTempoDoProjeto;



public class LDE {

	public static void main(String[] args) {
		ListaDuplamenteEncadeada<Integer> LDE = new ListaDuplamenteEncadeada<>();
		Integer numero = 3;

		LDE.adicionar(2);
		System.out.println(LDE.toString());
		LDE.adicionar(3);
		System.out.println(LDE.toString());
		LDE.adicionarNoInicio(4);
		System.out.println(LDE.toString());
		LDE.adicionar(8, 6);
		System.out.println(LDE.toString());
		LDE.adicionar(0, 8);
		System.out.println(LDE.toString());
		LDE.adicionar(1, 7);
		System.out.println(LDE.toString());
		LDE.adicionar(5, 9);
		System.out.println(LDE.toString());
		if (LDE.contem(9)) {
			System.out.println("Contem");
		} else {
			System.out.println("Nao contem");
		}
		if (LDE.contemRecursivo(10)) {
			System.out.println("Contem");
		} else {
			System.out.println("Nao contem");
		}
		LDE.remover(2);
		System.out.println(LDE.toString());
		LDE.remover(10);
		System.out.println(LDE.toString());
		LDE.remover(numero);
		System.out.println(LDE.toString());
		System.out.println(LDE.obter(1));
		LDE.limpar();
		System.out.println(LDE.toString());

	}
}
