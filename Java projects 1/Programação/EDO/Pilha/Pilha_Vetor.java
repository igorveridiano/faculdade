package Pilha;

import java.util.Iterator;

import Vetor.Vetor;

public class Pilha_Vetor implements IPilha {

	Vetor<Object> vet = new Vetor<>();

	@Override
	public void empilhar(Object elemento) {
		this.vet.adicionar(elemento);

	}

	@Override
	public Object desempilhar() {
		return this.vet.remover(vet.tamanho() - 1);
	}

	@Override
	public Object topo() {
		return this.vet.obter(this.tamanho() - 1);

	}

	@Override
	public int tamanho() {
		return this.vet.tamanho();
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
		this.vet.limpar();
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}
}

