/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listaVetor;


/**
 *
 * @author 11645
 */
public class Teste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Vetor<Integer> vet = new Vetor<>();
        Integer numero=7;
        vet.adicionar(1);
        vet.adicionar(2);
        vet.adicionar(3);
        vet.adicionar(4);
        vet.adicionar(5);
        vet.adicionar(6);
        vet.adicionar(8);
        vet.adicionar(9);
        vet.adicionar(6, 7);
        vet.adicionar(9, 10);
        vet.adicionar(0, 0);
        vet.remover(1);
        vet.adicionar(7);
        vet.remover(numero);
        System.out.println(vet);
        System.out.println(vet.tamanho());
        vet.contem(7);
        vet.contem(8);
        System.out.println(vet.obter(3));
        vet.limpar();
        System.out.print(vet);
    }   
}
