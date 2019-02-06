package Fila;

import java.util.Iterator;

import ListaDuplamenteEncadeadaComTesteDeTempoDoProjeto.ListaDuplamenteEncadeada;

public class FilaEncadeada implements IFila {
	private ListaDuplamenteEncadeada<Object> lista =new ListaDuplamenteEncadeada<>();
	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void enfileirar(Object elemento) {
		lista.adicionar(elemento);
		
	}

	@Override
	public Object desenfileirar() {
		Object item =lista.obter(0);
		lista.remover(0);
		return item;
		
	}

	@Override
	public Object primeiro() {
		return lista.obter(0);
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

	public ListaDuplamenteEncadeada<Object> getLista() {
		return lista;
	}

	public void setLista(ListaDuplamenteEncadeada<Object> lista) {
		this.lista = lista;
	}

}
