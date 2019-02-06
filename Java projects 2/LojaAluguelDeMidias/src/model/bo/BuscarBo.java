/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import model.dao.AluguelDao;
import model.dao.ClienteDao;
import model.vo.AluguelVo;
import model.vo.ClienteVo;
import view.DevolucaoView;

/**
 *
 * @author igorv
 */
public class BuscarBo {
    private static Date dataAluguel;
    private static Date dataDevolucao;

    public static boolean BuscarClientePorId(int id, DevolucaoView tela) throws SQLException, IOException {
        for (ClienteVo cliente : ClienteDao.CarregarDados()) {
            if (cliente.getCpf() == id) {
                for (AluguelVo aluguel : AluguelDao.CarregarDados()) {
                    if (aluguel.getIdCliente() == id && aluguel.getSituacao().equals("A")) {
                        tela.getLblCliente().setText(cliente.getNome());
                        DefaultTableModel model = (DefaultTableModel) tela.getTbDevolver().getModel();
                        Object[] informacoes = {aluguel.getId(), aluguel.getItem(), aluguel.getSituacao(), aluguel.getValor()};
                        model.addRow(informacoes);
                        tela.getTpDevolver().setVisible(true);
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
