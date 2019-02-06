package Teste;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.*;

public class Grafo implements Igrafo {

	private Set<Vertice> vertices = new HashSet<Vertice>();
	private Set<Aresta> arestas = new HashSet<Aresta>();

	private List<Vertice> visitados = new ArrayList<Vertice>();
	private List<Vertice> explorados = new ArrayList<Vertice>();

	private static boolean conexo;

	public Grafo(Set<Vertice> vertices, Set<Aresta> arestas) {
		this.vertices = vertices;
		this.arestas = arestas;
	}

	/*
	 * Verifica se um grafo e completo
	 */

	@Override
	public boolean ehCompleto() {

		for (Vertice vertice : this.vertices) {
			if (this.getAdjacentes(vertice).size() == this.vertices.size() - 1) {
				continue;
			} else {
				return false;
			}
		}

		return true;
	}

	@Override
	public boolean ehConexo() {

		return isConexo();
	}

	@Override
	public boolean ehRegular() {
		boolean flag = true;
		Vertice v = null;
		for (Vertice vertice : this.vertices) {
			v = vertice;
			this.getAdjacentes(vertice);

		}
		for (Vertice vertice : this.vertices) {
			if (v.getOrdem() == vertice.getOrdem()) {

				continue;
			} else {
				flag = false;
				break;
			}
		}
		return flag;
	}

	/*
	 * Retorna a lista de vertices adjacentes de um determinado vertice
	 */
	@Override
	public Set<Vertice> getAdjacentes(Vertice v) {
		Set<Vertice> adjacentes = new HashSet<Vertice>();
		v.setOrdem(0);
		for (Aresta aresta : this.arestas) {
			if (aresta.getA() == v) {
				adjacentes.add(aresta.getB());
				v.setOrdem(v.getOrdem() + 1);
			}

			if (aresta.getB() == v) {
				adjacentes.add(aresta.getA());
				v.setOrdem(v.getOrdem() + 1);
			}
		}
		return adjacentes;

	}

	/*
	 * Retorna o proximo vertice nao visitado da lista de adjacentes
	 */
	private Vertice getProximo(Set<Vertice> adjacentes) {
		for (Vertice v : adjacentes) {
			if (!v.isVisitado()) {
				return v;
			}
		}
		return null;
	}

	@Override
	public void buscaLargura() {
		Vertice verticeInicial = this.getNaoVisitado();
		int cont=0;
		while (verticeInicial != null) {
			this.buscaLarguraVertice(verticeInicial);
			
			verticeInicial = this.getNaoVisitado();
			cont++;
		}
		if (cont == 1) {
			this.conexo = true;
		} else {
			this.conexo = false;
		}

	}

	public void buscaLarguraVertice(Vertice v) {
		LinkedList<Vertice> fila = new LinkedList();
		v.setVisitado(true);
		this.visitados.add(v);
		fila.addLast(v);

		while (!fila.isEmpty()) {
			
			Vertice u = fila.getFirst();
			Set<Vertice> adj = this.getAdjacentes(u);

			if (adj.size() != 0) {
				for (Vertice vertice : adj) {
					if(!vertice.isVisitado()){
					fila.addLast(vertice);
					vertice.setVisitado(true);
					this.visitados.add(vertice);
				}

			}
			}
			explorados.add(u);
			fila.removeFirst();
		}

	}

	@Override
	public void buscaProfundidade() {
		Vertice verticeInicial = this.getNaoVisitado();
		int cont = 0;

		while (verticeInicial != null) {
			System.out.println("entrou");
			this.buscaEmProfundidadeVertice(verticeInicial);
			verticeInicial = this.getNaoVisitado();
			cont++;
		}
		System.out.println("o valor de cont eh" + cont);
		if (cont == 1) {
			this.conexo = true;
		} else {
			this.conexo = false;
		}
	}

	/*
	 * Retorna um vertice nao visitado do conjunto de vertices do grafo
	 */
	public Vertice getNaoVisitado() {
		for (Vertice vertice : this.vertices) {
			if (vertice.isVisitado() == false) {
				return vertice;
			}
		}

		return null;
	}

	/*
	 * Executa a busca em profundidade a partide de um vertice especifico
	 */
	public void buscaEmProfundidadeVertice(Vertice v) {
		Stack<Vertice> pilha = new Stack<Vertice>();
		v.setVisitado(true);
		this.visitados.add(v);
		pilha.push(v);

		while (!pilha.isEmpty()) {
			Set<Vertice> adjacentes = this.getAdjacentes(pilha.lastElement());
			Vertice w = getProximo(adjacentes);
			if (w != null) {
				w.setVisitado(true);
				this.visitados.add(w);
				pilha.push(w);
			} else {
				this.explorados.add(pilha.lastElement());
				pilha.pop();
			}
		}
	}

	/*
	 * Imprime o grafo
	 */
	@Override
	public String toString() {

		String retorno = "";

		for (Vertice v : vertices) {
			retorno += v.toString() + "[ ";

			Set<Vertice> adjacentes = this.getAdjacentes(v);

			for (Vertice adj : adjacentes) {
				retorno += adj.toString() + " ";
				if (adj.isVisitado()) {
					retorno += "(*) ";
				} else {
					retorno += "( ) ";
				}
			}

			retorno += "]\n";

		}

		retorno += "\n";
		retorno += "Ordem Visitados: " + this.visitados.toString();
		retorno += "\n";
		retorno += "Ordem Explorados: " + this.explorados.toString();

		return retorno;
	}

	public static boolean isConexo() {
		return conexo;
	}

	public static void setConexo(boolean conexo) {
		Grafo.conexo = conexo;
	}

}