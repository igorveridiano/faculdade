/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bo;

import view.AluguelView;

/**
 *
 * @author igorv
 */
public class SelecaoDeItemBo {
    
    public static void ItemSelecionado(AluguelView tela, int linha) {
        String descricao = (String) tela.getTbItens().getValueAt(linha, 2);
        tela.setIdItem((int) tela.getTbItens().getValueAt(linha, 1));
        tela.setDataItem((String) tela.getTbItens().getValueAt(linha, 7));
        tela.setProdutoraItem((String) tela.getTbItens().getValueAt(linha, 6));
        tela.setValorItem((float) tela.getTbItens().getValueAt(linha, 3));
        tela.setMidiaItem((String) tela.getTbItens().getValueAt(linha, 5));
        tela.getLblItemEscolhido().setText(descricao);
    }
}
