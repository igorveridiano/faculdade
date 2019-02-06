/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bo;

import javax.swing.table.DefaultTableModel;
import view.AluguelView;
import view.CadastroDeItensView;
import view.VerificarTitulosView;

/**
 *
 * @author igorv
 */
public class LimparDadosBo {
    
    public static void LimparComboBox(AluguelView tela) {
        tela.getCbTipoDeMidia().removeAllItems();
        tela.getCbFiltrarPorProdutora().removeAllItems();
    }
    
    public static void LimparTabela(AluguelView tela) {
        DefaultTableModel model = (DefaultTableModel) tela.getTbItens().getModel();
        for (int i = 0; i < tela.getTbItens().getRowCount(); i++) {
            model.removeRow(i);
        }
    }
    
    public static void LimparComboBox(CadastroDeItensView tela) {
        tela.getCbTipoMidia().removeAllItems();
        tela.getCbProdutora().removeAllItems();
    }
    
    public static void LimparTabela(VerificarTitulosView tela) {
        DefaultTableModel model = (DefaultTableModel) tela.getTbTitulos().getModel();
        for (int i = 0; i < tela.getTbTitulos().getRowCount(); i++) {
            model.removeRow(i);
        }
    }
}
