/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bo;

import controller.MidiaControl;
import controller.ProdutoraControl;
import java.io.IOException;
import java.sql.SQLException;
import model.vo.MidiaVo;
import model.vo.ProdutoraVo;
import view.AluguelView;
import view.CadastroDeItensView;

/**
 *
 * @author igorv
 */
public class ListarDadosBo {
    
    public static void CarregarDadosMidia(AluguelView tela) throws SQLException, IOException {
        tela.getCbTipoDeMidia().addItem("Selecionar");
        for (MidiaVo midia : MidiaControl.CarregarDados()) {
            tela.getCbTipoDeMidia().addItem(midia.getDescricao());
        }
    }

    public static void CarregarDadosProdutora(AluguelView tela) throws SQLException, IOException {
        tela.getCbFiltrarPorProdutora().addItem("Selecionar");
        for (ProdutoraVo produtora : ProdutoraControl.CarregarDados()) {
            tela.getCbFiltrarPorProdutora().addItem(produtora.getNome());
        }
    }
    
    public static void CarregarDadosMidia(CadastroDeItensView tela) throws SQLException, IOException {
        tela.getCbTipoMidia().addItem("Selecionar");
        for (MidiaVo midia : MidiaControl.CarregarDados()) {
            tela.getCbTipoMidia().addItem(midia.getDescricao());
        }
    }

    public static void CarregarDadosProdutora(CadastroDeItensView tela) throws SQLException, IOException {
        tela.getCbProdutora().addItem("Selecionar");
        for (ProdutoraVo produtora : ProdutoraControl.CarregarDados()) {
            tela.getCbProdutora().addItem(produtora.getNome());
        }
    }
}
