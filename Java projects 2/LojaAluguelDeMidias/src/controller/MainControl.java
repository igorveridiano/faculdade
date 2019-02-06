/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import view.AluguelView;
import view.CadastroDeClientesView;
import view.CadastroDeItensView;
import view.CadastroDeMidiasView;
import view.CadastroDeProdutoraView;
import view.DevolucaoView;
import view.MainView;
import view.VerificarTitulosView;

/**
 *
 * @author igorv
 */
public class MainControl {
    
    public static void CadastroDeMidia(){
        CadastroDeMidiasView tela = new CadastroDeMidiasView();
        tela.setVisible(true);
    }
    
    public static void CadastroDeCliente(){
        CadastroDeClientesView tela = new CadastroDeClientesView();
        tela.setVisible(true);
    }
    
    public static void CadastroDeItem(){
        CadastroDeItensView tela = new CadastroDeItensView();
        tela.setVisible(true);
    }
    
    public static void Devolucao(){
        DevolucaoView tela = new DevolucaoView();
        tela.setVisible(true);
    }
    
    public static void Aluguel(){
       AluguelView tela = new AluguelView();
       tela.setVisible(true);
    }
    
    public static void AcessarMenu(){
        MainView tela = new MainView();
        tela.setVisible(true);
    }
    
    public static void CadastroProdutora(){
        CadastroDeProdutoraView tela = new CadastroDeProdutoraView();
        tela.setVisible(true);
    }

    public static void VerificarTitulos(){
       VerificarTitulosView tela = new VerificarTitulosView();
       tela.setVisible(true);
    }
}
