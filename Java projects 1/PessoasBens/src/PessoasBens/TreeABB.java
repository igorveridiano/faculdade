package PessoasBens;

import java.util.ArrayList;
import java.util.Collection;



public class TreeABB <K extends Comparable<K>, T> {

	private NoABB<K, T> raiz;

	public boolean isEmpaty() {
		return (this.raiz == null);
	}

	public T buscarElemento(K chave) {
		NoABB<K, T> noFound = this.buscarElemento(raiz, chave);
		if (noFound == null) {
			return null;

		} else {
			return (T) noFound.getElemento();
		}
	}

	public NoABB<K, T> buscarElemento(NoABB<K, T> start, K chave) {
		if (start != null) {
		} else {
			return null;
		}

		if (start.getChave().compareTo(chave) < 0) {
			return this.buscarElemento(start.getNoEsquerdo(), chave);
		} else if (start.getChave().compareTo(chave) > 0) {
			return this.buscarElemento(start.getNoDireito(), chave);
		} else {
			return start;
		}
	}

	public void inserirElemento(K chave, T elemento) {
		this.inserirElemento(chave, raiz, elemento);
	}

	private boolean inserirElemento(K chave, NoABB<K, T> start, T elemento) {
		if (this.raiz == null) {
			NoABB<K, T> no = new NoABB<>(chave, elemento);
			this.raiz = no;
			return true;
		}

		if (start.getChave().compareTo(chave) < 0) {
			// Lado Esquerdo
			if (start.getNoEsquerdo() == null) {
				NoABB<K, T> no = new NoABB<>(chave, elemento);
				no.setNoPai(start);
				start.setNoEsquerdo(no);
				return true;
			} else {
				return this.inserirElemento(chave, start.getNoEsquerdo(), elemento);
			}
		} else if (start.getChave().compareTo(chave) > 0) {
			// Lado Direito
			if (start.getNoDireito() == null) {
				NoABB<K, T> no = new NoABB<>(chave, elemento);
				no.setNoPai(start);
				start.setNoDireito(no);
				return true;
			} else {
				return this.inserirElemento(chave, start.getNoDireito(), elemento);
			}

		} else {
			// Chave já existe
			System.out.println("Essa Chave ja existe");
			return false;
		}
	}

	public boolean removeElemento(K chave) {
		this.raiz = this.removeElemento(this.raiz, chave);
		return true;
	}

	public NoABB<K, T> removeElemento(NoABB<K, T> start, K chave) {
		if (start == null) {
			return null;
		}

		if (start.getChave().compareTo(chave) < 0) {
			start.setNoEsquerdo(this.removeElemento(start.getNoEsquerdo(), chave));
		} else if (start.getChave().compareTo(chave) > 0) {
			start.setNoDireito(this.removeElemento(start.getNoDireito(), chave));
		} else {

			if (start.getNoEsquerdo() != null && start.getNoDireito() != null) {
				// Quando um nó tem 2 filhos
				NoABB<K, T> noDireito = start.getNoDireito();
				NoABB<K, T> noEsquerdo = start.getNoEsquerdo();

				start = this.removeMin(start.getNoDireito(), start);

				NoABB<K, T> minRight = start.getNoDireito();

				start.setNoDireito(noDireito);
				start.setNoEsquerdo(noEsquerdo);

				if (start.getNoDireito().getChave() == start.getChave()) {
					start.setNoDireito(minRight);

					// Setando novo pai
					start.getNoEsquerdo().setNoPai(start);
				}

			} else if (start.getNoEsquerdo() == null && start.getNoDireito() == null) {
				// Quando o no não tem filhos
				start = null;
			} else if (start.getNoEsquerdo() != null) {
				start = start.getNoEsquerdo();
			} else {
				start = start.getNoDireito();
			}
		}
		return start;
	}

	public NoABB<K, T> removeMin(NoABB<K, T> start, NoABB<K, T> parent) {
		if (start == null) {
			return null;
		}

		if (start.getNoEsquerdo() == null) {
			if (parent != this.raiz) {
				parent.setNoEsquerdo(start.getNoDireito());
			} else {
				start.setNoPai(null);
			}
			return start;
		}

		return removeMin(start.getNoEsquerdo(), start);

	}

	public void clear() {
		this.raiz = null;
	}

	public void print() {
		this.print(this.raiz);
	}

	private void print(NoABB<K, T> start) {
		// Simetrica
		if (start != null) {
			print(start.getNoEsquerdo());
			System.out.println(start.getElemento().toString());

			print(start.getNoDireito());
		}
	}

	private void preOrdem(NoABB<K, T> start) {
		if (start != null) {
			start.getElemento();
			this.preOrdem(start.getNoEsquerdo());
			this.preOrdem(start.getNoDireito());

		}
	}

	public void posOrdem() {
		this.posOrdem(this.raiz);
	}

	private void posOrdem(NoABB<K, T> start) {
		if (start != null) {
			this.preOrdem(start.getNoEsquerdo());
			this.preOrdem(start.getNoDireito());
			start.getElemento();

		}
	}

	public Collection<T> listElements() {
		ArrayList<T> lista = new ArrayList<>();
		this.listElements(this.raiz, lista);
		return lista;
	}

	public void listElements(NoABB<K, T> start, ArrayList<T> lista) {
		// Simetrica
		if (start != null) {
			this.listElements(start.getNoEsquerdo(), lista);
			lista.add(start.getElemento());
			this.listElements(start.getNoDireito(), lista);
		}

	}

}
