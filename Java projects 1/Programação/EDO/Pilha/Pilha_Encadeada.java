package Pilha;

import java.util.Iterator;

import ListaDuplamenteEncadeadaComTesteDeTempoDoProjeto.ListaDuplamenteEncadeada;



public class Pilha_Encadeada<T> implements IPilha{

	private ListaDuplamenteEncadeada<Object> lista =new ListaDuplamenteEncadeada<>();

	@Override
	public void empilhar(Object elemento) {
		lista.adicionar(elemento);
		
	}

	@Override
	public Object desempilhar() {
		return lista.removerDoFim();
	}

	@Override
	public Object topo() {
		return lista.obter(lista.tamanho()-1);
	}

	@Override
	public int tamanho() {
		return lista.tamanho();
	}

	@Override
	public boolean vazia() {
		if(lista.tamanho()==0){
			return true;
		}
		return false;
	}

	@Override
	public void limpar() {
		lista.limpar();
		
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
