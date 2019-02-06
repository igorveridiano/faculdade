/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import model.dao.ClienteDao;
import model.vo.ClienteVo;

/**
 *
 * @author igorv
 */
public class ClienteControl {

    public static void SalvarCliente(String nome, int cpf) throws SQLException, IOException {
        ClienteDao.Persistir(nome, cpf);
    }

    public static List<ClienteVo> CarregarDados() throws SQLException, IOException {
        return ClienteDao.CarregarDados();
    }
}
