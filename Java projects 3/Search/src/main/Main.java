package main;

import graph.Aresta;
import graph.Grafo;
import graph.Vertice;

import java.util.HashSet;
import java.util.Set;

public class Main {


    public static void main(String[] args) {

        Set<Vertice> vertices = new HashSet<Vertice>();
        Set<Aresta> arestas = new HashSet<Aresta>();

        Vertice A = new Vertice("A");
        Vertice B = new Vertice("B");
        Vertice C = new Vertice("C");
        Vertice D = new Vertice("D");
        Vertice E = new Vertice("E");
        Vertice F = new Vertice("F");
        Vertice G = new Vertice("G");

        Aresta aresta1 = new Aresta(A, B, 3);
        Aresta aresta2 = new Aresta(B, D, 2);
        Aresta aresta3 = new Aresta(B, F, 4);
        Aresta aresta4 = new Aresta(C, B, 2);
        Aresta aresta5 = new Aresta(C, G, 6);
        Aresta aresta6 = new Aresta(D, B, 7);
        Aresta aresta7 = new Aresta(D, C, 2);
        Aresta aresta8 = new Aresta(E, G, 1);
        Aresta aresta9 = new Aresta(F, A, 5);
        Aresta aresta10 = new Aresta(F, E, 5);
        Aresta aresta11 = new Aresta(G, F, 12);
        

        vertices.add(A);
        vertices.add(B);
        vertices.add(C);
        vertices.add(D);
        vertices.add(E);
        vertices.add(F);
        vertices.add(G);

        arestas.add(aresta1);
        arestas.add(aresta2);
        arestas.add(aresta3);
        arestas.add(aresta4);
        arestas.add(aresta5);
        arestas.add(aresta6);
        arestas.add(aresta7);
        arestas.add(aresta8);
        arestas.add(aresta9);
        arestas.add(aresta10);
        arestas.add(aresta11);


        Grafo grafo = new Grafo(vertices, arestas);
        
        grafo.algoritmoDijkstraDirecionado(A);
        
    }

}
