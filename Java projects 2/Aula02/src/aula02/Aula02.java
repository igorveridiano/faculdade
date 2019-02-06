/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula02;

/**
 *
 * @author igorv
 */
public class Aula02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Caneta caneta = new Caneta();
        caneta.cor = "azul";
        caneta.ponta = 0.5f;
        caneta.tampada = false;
        caneta.tampar();
        caneta.status();
        caneta.rabisacar();
        
        Caneta caneta2 = new Caneta();
        caneta2.modelo = "Hostnet";
        caneta2.cor = "Preta";
        caneta2.destampar();
        caneta2.status();
        caneta2.rabisacar();
    }
    
}
