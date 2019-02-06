/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaEscola;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


/**
 *
 * @author igorv
 */
public class Arquivos {
    
    public void Gravar (String diretorio, String nomeArquivo, String dados){
       try {
           File arquivo = new File(diretorio, nomeArquivo);
           if(!arquivo.exists()){
               arquivo.createNewFile();
           }
           FileWriter fw = new FileWriter(arquivo.getAbsoluteFile());
           try (BufferedWriter bw = new BufferedWriter(fw)) {
               bw.write(dados);
           }
       } catch (IOException e){
       }
    }
    
    public void Carregar (String diretorio){
    }
}
