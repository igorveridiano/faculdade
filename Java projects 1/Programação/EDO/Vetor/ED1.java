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
public class ED1 {

    public static void main(String[] args) {
        Vetor<Integer> vet = new Vetor<>();
        Integer numero =8;
        
        
        
        for (int i = 0; i < 100; i++) {
			vet.adicionar(i);
			
		}
        vet.adicionar(2);
        vet.adicionar(3);
        vet.adicionar(4);
        System.out.println(vet.toString());
//        vet.adicionar(5, 5);
//        System.out.println(vet.toString());
//        vet.adicionar(0, 8);
//        System.out.println(vet.toString());
//        vet.adicionar(1,7);
//        System.out.println(vet.toString());
//        vet.adicionar(5,9);
//        System.out.println(vet.toString());
//        if(vet.contem(9)){
//        System.out.println("Contem");
//        }
//        else{
//        System.out.println("Nao contem");
//        }
//        vet.remover(2);
//        System.out.println(vet.toString());
//        vet.remover(numero);
//        System.out.println(vet.toString());
//        System.out.println( vet.obter(1));
//        vet.limpar();
//        System.out.println(vet.toString());
//        vet.adicionar(1);
//        System.out.println(vet.toString());
//    
        
                
    }
    
}
