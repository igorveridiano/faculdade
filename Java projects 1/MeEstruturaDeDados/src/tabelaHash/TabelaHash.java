package tabelaHash;

import java.util.Iterator;

import listaDuplamenteEncadeada.ListaDuplamenteEncadeada;
import listaVetor.Vetor;

public class TabelaHash<K, V> implements ITabelaHash<K, V> {
	
	
	Vetor<ListaDuplamenteEncadeada<TabelaHashNo>> vet;
	private int tamanho;
	private final double limite = 0.75;
	private final int tamanhoInicial;
	private int tamanhoRehash;
	
	private class TabelaHashNo {
		private K chave;
		private V valor;
		
		private TabelaHashNo (K chave, V valor){
			this.chave = chave;
			this.valor = valor;
		}
	}
	
	private class IteradorTabelaHash implements Iterator<V> {

		private Vetor<ListaDuplamenteEncadeada<TabelaHashNo>> tabela;
		private int posicao1, posicao2, posicao3, aux1, aux2;
		
		public IteradorTabelaHash(Vetor<ListaDuplamenteEncadeada<TabelaHashNo>> vet) {
			this.tabela = vet;
		}
		
		@Override
		public boolean hasNext() {
			if (this.posicao1 >= 0 && this.posicao1 <= tabela.getTamanho()) {
				return true;
			} else {
				return false;
			}
		}

		@Override
		public V next() {
			if (hasNext()) {
				if (aux1 != 0){
					ListaDuplamenteEncadeada<TabelaHashNo> lista = vet.obter(posicao3);
					if(lista != null){
						while(aux1 >= 0 && aux1 < lista.tamanho()) {
							TabelaHashNo hashNo = lista.obter(aux1++);
							if (hashNo != null){
								setAux2(getAux2() + 1);
								return hashNo.valor;
								}
							}
						}
				}
				posicao3 = posicao1;
				ListaDuplamenteEncadeada<TabelaHashNo> lista = vet.obter(posicao1++);
				posicao2 = 0;
				aux1 = 0;
				if(lista != null){
					while(posicao2 >= 0 && posicao2 < lista.tamanho()) {
						aux1++;
						TabelaHashNo hashNo = lista.obter(posicao2++);
						if (hashNo != null){
							setAux2(getAux2() + 1);
							return hashNo.valor;
							}
						}
					} 
				}
			return null;
			}

		public int getAux2() {
			return aux2;
		}

		public void setAux2(int aux2) {
			this.aux2 = aux2;
		}
		}
	
	public TabelaHash() {
		this.vet = new Vetor<>(17);
		tamanhoRehash = 17;
		tamanhoInicial = 17;
	}

	public TabelaHash(int tamanho) {
		this.vet = new Vetor<>(tamanho);
		tamanhoRehash = tamanho;
		tamanhoInicial = tamanho;
	}
	
	private void reHash(){
		tamanhoRehash = tamanhoRehash * 2;
		tamanho = 0;
		Vetor<ListaDuplamenteEncadeada<TabelaHashNo>> tabelaAux = vet;
		vet = new Vetor<>(tamanhoRehash);
		for (ListaDuplamenteEncadeada<TabelaHashNo> lista : tabelaAux){
			if (lista != null) {
				for (TabelaHashNo hashNo : lista){
					inserir(hashNo.chave, hashNo.valor);
				}		
			}
		}	
	}
	
	private int Posicao(K chave) {
		return (int) chave.hashCode() / getTamanhoInicial();
	}
   
	@Override
	public Iterator<V> iterator() {
		try {
			return new IteradorTabelaHash(vet);
		} catch (NullPointerException e) {
			return null;
		}
	}

	@Override
	public void inserir(K chave, V valor) {
		TabelaHashNo tabelaHashNo = new TabelaHashNo(chave, valor);
		int posicao = Posicao(chave);
		if (tamanho / tamanhoRehash >= limite) {
			reHash();
		}	
		try {
			if (vet.obter(posicao).equals(null)){
			} else {
				ListaDuplamenteEncadeada<TabelaHashNo> lista2;
				lista2 = vet.obter(posicao);
				lista2.adicionar(tabelaHashNo);
				vet.adicionar(posicao, lista2);
				tamanho++;
			}
		} catch (NullPointerException e){
			ListaDuplamenteEncadeada<TabelaHashNo> lista1 = new ListaDuplamenteEncadeada<>();
			lista1.adicionar(tabelaHashNo);
			vet.adicionar(posicao, lista1);
			tamanho++;
		}
	}

	@Override
	public boolean remover(K chave) {
		int posicao = Posicao(chave);
		try {
			for (TabelaHashNo tabelaHashNo : vet.obter(posicao)) {
				if (tabelaHashNo.chave.equals(chave)){
					vet.obter(posicao).remover(tabelaHashNo);
					tamanho--;
					return true;
				} 
			}
		} catch (NullPointerException e){
			return false;
		}
		return false;
	}

	@Override
	public V buscar(K chave) {
		int posicao = Posicao(chave);
		try {
			for (TabelaHashNo tabelaHashNo : vet.obter(posicao)) {
				if (tabelaHashNo.chave.equals(chave)){
					return tabelaHashNo.valor;
				}
			}
		} catch (NullPointerException e) {
			return null;
		}
		return null;
	}
	
	@Override
	public boolean contem(V valor) {
		if (this.tamanho != 0){
			for (ListaDuplamenteEncadeada<TabelaHashNo> ListaDuplamenteEncadeada : vet) {
				if (aux(ListaDuplamenteEncadeada)){
					for (TabelaHashNo tabelaHashNo : ListaDuplamenteEncadeada) {
						if (tabelaHashNo.valor.equals(valor)){
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	
	private boolean aux(ListaDuplamenteEncadeada<TabelaHashNo> lista){
		try {
			if (lista.tamanho() != 0) {
				return true;
			}
		} catch (NullPointerException e) {
			return false;
		}
		return false;
	}

	@Override
	public int tamanho() {
		return tamanho;
	}

	@Override
	public boolean vazio() {
		if (vet.tamanho() == 0){
			return true;
		}
		return false;
	}

	@Override
	public void limpar() {
		vet.limpar();
		tamanho = 0;
	}

	public int getTamanhoInicial() {
		return tamanhoInicial;
	}
}
