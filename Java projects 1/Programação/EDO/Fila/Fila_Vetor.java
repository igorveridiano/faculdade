package Fila;

import java.util.Iterator;

import Vetor.Vetor;

public class Fila_Vetor implements IFila{
	Vetor<Object> vet = new Vetor<>();
	int fim=0;
	int inicio=0;
	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void enfileirar(Object elemento) {
		fim++;
		vet.adicionar(elemento);
		
		
	}

	@Override
	public Object desenfileirar() {
		Object item =vet.obter(inicio);
		vet.remover(inicio);
		inicio++;
		return item;
		
	}

	@Override
	public Object primeiro() {
		return vet.obter(inicio);
	}

	@Override
	public int tamanho() {

		return vet.tamanho();
	}

	@Override
	public boolean vazia() {
		if (this.vet.tamanho() == 0) {
			return true;
		}

		return false;
	}

	@Override
	public void limpar() {
		vet.limpar();
		
	}

}
