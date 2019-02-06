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
        Vertice H = new Vertice("H");
        Vertice I = new Vertice("I");

        Aresta aresta1 = new Aresta(C, A, 10);
        Aresta aresta2 = new Aresta(C, B, 5);
        Aresta aresta3 = new Aresta(C, D, 1);
        Aresta aresta4 = new Aresta(C, E, 4);
        Aresta aresta5 = new Aresta(A, B, 5);
        Aresta aresta6 = new Aresta(D, B, 3);
        Aresta aresta7 = new Aresta(D, E, 7);
        Aresta aresta8 = new Aresta(D, F, 3);
        Aresta aresta9 = new Aresta(E, F, 3);
        Aresta aresta10 = new Aresta(E, G, 8);
        Aresta aresta11 = new Aresta(E, I, 1);
        Aresta aresta12 = new Aresta(I, G, 2);
        Aresta aresta13 = new Aresta(I, F, 10);
        Aresta aresta14 = new Aresta(I, H, 5);
        Aresta aresta15 = new Aresta(H, F, 4);

        vertices.add(A);
        vertices.add(B);
        vertices.add(C);
        vertices.add(D);
        vertices.add(E);
        vertices.add(F);
        vertices.add(G);
        vertices.add(H);
        vertices.add(I);

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
        arestas.add(aresta12);
        arestas.add(aresta13);
        arestas.add(aresta14);
        arestas.add(aresta15);

        Grafo grafo = new Grafo(vertices, arestas);

        grafo.algoritmoDijkstra(C);
        grafo.algoritmoDijkstraDirecionado(C);
        
    }

}
