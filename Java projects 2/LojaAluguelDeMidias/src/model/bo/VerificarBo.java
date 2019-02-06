/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bo;

import controller.ItemControl;
import java.io.IOException;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import model.vo.ItemVo;
import view.VerificarTitulosView;

/**
 *
 * @author igorv
 */
public class VerificarBo {
    
    public static void VerificarTitulos(VerificarTitulosView tela) throws SQLException, IOException {
        DefaultTableModel model = (DefaultTableModel) tela.getTbTitulos().getModel();
        for (ItemVo item : ItemControl.CarregarDados()) {
            Object[] informacoes = {item.getId(), item.getDescricao(), item.getDataCompra(), item.getProdutora(), item.getSituacao(), item.getValor(), item.getMidia()};
            model.addRow(informacoes);
        }
    }
}
