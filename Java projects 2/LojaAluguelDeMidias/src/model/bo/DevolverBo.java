/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bo;

import controller.AluguelControl;
import controller.ItemControl;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.dao.AluguelDao;
import model.vo.AluguelVo;
import model.vo.ItemVo;
import view.DevolucaoView;

/**
 *
 * @author igorv
 */
public class DevolverBo {
    
    private static Date dataAluguel;
    private static Date dataDevolucao;
    
    public static boolean Devolver(int id, DevolucaoView tela, String item) throws SQLException, IOException, ParseException {
        for (AluguelVo aluguel : AluguelDao.CarregarDados()) {
            for (ItemVo itens : ItemControl.CarregarDados()) {
                if (aluguel.getIdCliente() == id && aluguel.getItem().equals(item)) {
                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                    try {
                        Date dataFormatada = formato.parse(aluguel.getDataAluguel());
                        dataAluguel = dataFormatada;
                    } catch (ParseException e) {
                    }
                    try {
                        Date dataFormatada = formato.parse(aluguel.getDataDevolucao());
                        dataDevolucao = dataFormatada;
                    } catch (ParseException e) {
                    }
                    AluguelControl.Atualizar(aluguel.getId(),id, aluguel.getItem(), "D", dataAluguel, dataDevolucao, aluguel.getValor());
                    ItemControl.Atualizar(itens.getId(),itens.getDescricao(),itens.getDataCompra(), itens.getProdutora(), "D", itens.getValor(), itens.getMidia());
                    return true;
                }
            }
        }
        return false;
    }
}
