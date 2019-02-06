package tabelaHash;

import java.util.Iterator;

import listaDuplamenteEncadeada.ListaDuplamenteEncadeada;
import listaVetor.Vetor;

public class TabelaHash<K, V> implements ITabelaHash<K, V> {
	
	
	Vetor<ListaDuplamenteEncadeada<TabelaHashNo>> vet;
	private int posicao;
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
		private int contador = 0, posicaoLista = 0, posicaoTabela = 0;
		
		public IteradorTabelaHash(Vetor<ListaDuplamenteEncadeada<TabelaHashNo>> vet) {
			this.tabela = vet;
		}
		
		@Override
		public boolean hasNext() {
			return contador < tabela.tamanho();
		}

		@Override
		public V next() {
			V valor = null;
			while(tabela.obter(posicaoLista) == null || posicaoTabela >= tabela.obter(posicaoLista).tamanho()){
				posicaoLista += 1;
				posicaoTabela = 0;
			}
			if(posicaoTabela < tabela.obter(posicaoLista).tamanho()){
				valor = (V)tabela.obter(posicaoLista).obter(posicaoTabela).valor;
				posicaoTabela++;
				contador++;
			}
			return valor;
		}
		
	}
	
	public TabelaHash() {
		this.vet = new Vetor<>(16);
		tamanhoRehash = 16;
		tamanhoInicial = 16;
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
   

	@Override
	public Iterator<V> iterator() {
		return new IteradorTabelaHash(vet);
	}

	@Override
	public void inserir(K chave, V valor) {
		posicao = (chave.hashCode() % getTamanhoInicial());
		TabelaHashNo tabelaHashNo = new TabelaHashNo(chave, valor);
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
		posicao = (chave.hashCode() % getTamanhoInicial());
		ListaDuplamenteEncadeada<TabelaHashNo> lista = new ListaDuplamenteEncadeada<>();
		lista = vet.obter(posicao);
		try {
			for (TabelaHashNo tabelaHashNo : lista) {
				if (tabelaHashNo.chave.equals(chave)){
					lista.remover(tabelaHashNo);
					vet.adicionar(posicao, lista);
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
		posicao = (chave.hashCode() % getTamanhoInicial());
		ListaDuplamenteEncadeada<TabelaHashNo> lista ;
		lista = vet.obter(posicao);
		try {
			for (TabelaHashNo tabelaHashNo : lista) {
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
