/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vetor;



/**
 *
 * @author 11645
 */
public class Vetor<Tipo> implements IVetor<Tipo> {

	private Object[] vetor;
	private int size;

	public Vetor() {
		vetor = new Object[10];
	}

	public Vetor(int tamanhoInicial) {
		vetor = new Object[tamanhoInicial];
	}

	@Override
	public boolean adicionar(Tipo valor) {
		int j = 0;
		if (vetor.length == this.tamanho()) {
			AumentaVetor(vetor);
			
		}
		try {

			for (int i = 0; i < vetor.length; i++) {
				j = i;
				vetor[i].equals(vetor[i]);

			}
		} catch (NullPointerException e) {
			vetor[j] = valor;
			this.size++;
			return true;
		}
		return false;
	}

	@Override
	public boolean adicionar(int posicao, Tipo valor) {

		if (vetor.length == this.tamanho()) {
		 AumentaVetor(vetor);
		}
		if (posicao > this.tamanho()) {
			return false;
		} else {
			if (posicao == this.tamanho()) {
				vetor[posicao] = valor;
			} else {

				for (int i = this.tamanho(); i > posicao; i--) {
					vetor[i] = vetor[i - 1];

				}

				vetor[posicao] = valor;

			}

		}
		this.size++;
		return true;

	}

	@Override
	public boolean remover(int posicao) {
		if (posicao >= this.tamanho()) {
			return false ;
		}
		if (posicao == this.tamanho() - 1) {
			vetor[posicao] = null;
			
		} else {
			for (int i = posicao; i < this.tamanho() - 1; i++) {
				vetor[i] = vetor[i + 1];
			}
			vetor[this.getSize() - 1] = null;
		}
		this.size--;
		return true;
	}

	@Override
	public boolean remover(Tipo valor) {
		int posicao = -1;
		for (int i = 0; i < this.tamanho(); i++) {
			if (vetor[i].equals(valor))	{
				posicao = i;
				break;
			}
		}
		if (posicao >= 0) {
			this.remover(posicao);
			return true;
		} else {
			return false;
		}
	}

	

	@Override
	public boolean contem(Tipo valor) {
		for (int i = 0; i < this.getSize(); i++) {
			if (vetor[i].equals(valor))	{
				
				return true;
			}
		}
		return false;
	}

	@Override
	public int tamanho() {
		return this.getSize();
	}

	@Override
	public void limpar() {
		this.vetor=new Object[10];
		this.setSize(0);
	}

	@Override
	public Tipo obter(int posicao) {
		try{
			return  (Tipo) vetor[posicao];
		}
		catch(NullPointerException e){
			return null;
		}
		
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void AumentaVetor(Object[] vetor) {
		Object[] vetor1 = new Object[vetor.length *2];
		for (int i =0; i < vetor.length; i++) {
			vetor1[i] = vetor[i];
		}
		this.vetor=vetor1;
		

	}

	@Override
	public String toString() {
		//return "Vetor [vetor=" + Arrays.toString(vetor) + "]";
		if (this.tamanho() == 0) {
			return "{ }";
		}
		
		StringBuilder string = new StringBuilder();
		string.append("{ ");

		for (int i = 0; i < tamanho() - 1; i++) {
			string.append(vetor[i]);
			string.append(", ");
			
		}

		string.append(vetor[tamanho()-1]);
		string.append(" }");
		// String saida;
		// saida=new String(string);
		// return saida;
		return string.toString();
	}
}
