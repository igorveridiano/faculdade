/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bo;

import controller.ItemControl;
import controller.MidiaControl;
import java.io.IOException;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import model.vo.ItemVo;
import model.vo.MidiaVo;
import view.AluguelView;

/**
 *
 * @author igorv
 */
public class FiltrarDadosBo {
    
    public static void FiltroMidia(AluguelView tela, String midia) throws SQLException, IOException {
        DefaultTableModel model = (DefaultTableModel) tela.getTbItens().getModel();
        for (MidiaVo midias : MidiaControl.CarregarDados()) {
            if (midias.getDescricao().equals(midia)) {
                for (ItemVo item : ItemControl.CarregarDados()) {
                    Object[] informacoes = {"selecionar", item.getId(), item.getDescricao(), item.getValor(), item.getSituacao(), midias.getDescricao(), item.getProdutora(),item.getDataCompra()};
                    model.addRow(informacoes);
                }
            }
        }
    }

    public static void FiltroSituacao(AluguelView tela, String situacao, String midia, String produtora) throws SQLException, IOException {
        DefaultTableModel model = (DefaultTableModel) tela.getTbItens().getModel();
        for (MidiaVo midias : MidiaControl.CarregarDados()) {
            if (midias.getDescricao().equals(midia)) {
                for (ItemVo item : ItemControl.CarregarDados()) {
                    if (item.getSituacao().equals(situacao) && item.getProdutora().equals(produtora)) {
                        Object[] informacoes = {"selecionar", item.getId(), item.getDescricao(), item.getValor(), item.getSituacao(), midias.getDescricao(), item.getProdutora(),item.getDataCompra()};
                        model.addRow(informacoes);
                    }
                }
            }
        }
    }

    public static void FiltroProdutora(AluguelView tela, String produtora, String midia) throws SQLException, IOException {
        DefaultTableModel model = (DefaultTableModel) tela.getTbItens().getModel();
        for (MidiaVo midias : MidiaControl.CarregarDados()) {
            if (midias.getDescricao().equals(midia)) {
                for (ItemVo item : ItemControl.CarregarDados()) {
                    try {
                        if (item.getProdutora().equals(produtora)) {
                            Object[] informacoes = {"selecionar", item.getId(), item.getDescricao(), item.getValor(), item.getSituacao(), midias.getDescricao(), item.getProdutora(),item.getDataCompra()};
                            model.addRow(informacoes);
                        }
                    } catch(NullPointerException x){
                        
                    }
                }
            }
        }
    }
}
