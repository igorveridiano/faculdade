package tabelaHash;

public class TesteTabelaHash {

	public static void main(String[] args) {
		TabelaHash<Integer, String> tabela = new TabelaHash<>();
		System.out.println(tabela.contem("Igor"));
		System.out.println(tabela.tamanho());
		System.out.println(tabela.buscar(10));
		System.out.println(tabela.remover(10));
		System.out.println(	tabela.vazio());
		tabela.inserir(25, "Igor");
		tabela.inserir(5, "Jose");
		tabela.inserir(0, "Caio");
		tabela.inserir(47, "Luis");
		tabela.inserir(15, "Rafael");
		tabela.inserir(12, "Ig");
		tabela.inserir(7, "Jo");
		tabela.inserir(6, "Cai");
		tabela.inserir(2, "Lu");
		tabela.inserir(1, "Rafa");
		
		for (String string : tabela) {
			System.out.println(string);
		}
		
	}

}
