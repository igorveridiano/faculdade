/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparaçãostring;

/**
 *
 * @author igorv
 */
public class ComparaçãoString {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String nome1 = "igor";
        String nome2 = "igor";
        String nome3 = new String ("igor");
        String res;
        res = (nome1==nome2) ? "igual":"diferente";
        System.out.println(res);
        res = (nome1==nome3) ? "igual":"diferente";
        System.out.println(res);
        res = (nome1.equals(nome3)) ? "igual":"diferente";
        System.out.println(res);
    }
    
}
