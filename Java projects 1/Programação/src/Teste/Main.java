package Teste;

import java.util.HashSet;
import java.util.Set;


public class Main {
	
	
	public static void main(String[] args) {
		
		Set<Vertice> vertices = new HashSet<Vertice>();
		Set<Aresta> arestas = new HashSet<Aresta>();
		
		Vertice v1 = new Vertice("v1");
		Vertice v2 = new Vertice("v2");
		Vertice v3 = new Vertice("v3");
		
		Aresta aresta1 = new Aresta(v1, v2, 0);		
		Aresta aresta2 = new Aresta(v1, v3, 0);
		Aresta aresta3 = new Aresta(v3, v2, 0);
		
		vertices.add(v1);
		vertices.add(v2);
		vertices.add(v3);

		arestas.add(aresta1);
		arestas.add(aresta2);
		arestas.add(aresta3);
		
		Grafo grafo = new Grafo(vertices, arestas);
		
		grafo.buscaLargura();
		//grafo.buscaProfundidade();
		System.out.println("Comecou");
		System.out.println(grafo.toString());
		
		if(grafo.ehRegular()){ 	
		  	System.out.println("� regular");
		  
		}
		else{
		  System.out.println("N�o � regular");
		}
		if(grafo.ehConexo()){
		  	System.out.println("� conexo");
		  
		}
		else{
		  System.out.println("N�o � conexo");
		  
		}
	}

}
