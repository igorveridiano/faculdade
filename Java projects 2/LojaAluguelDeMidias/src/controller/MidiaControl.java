/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import model.dao.MidiaDao;
import model.vo.MidiaVo;

/**
 *
 * @author igorv
 */
public class MidiaControl {

    public static void SalvarMidiaModel(String descricao) throws SQLException, IOException {
        MidiaDao.Persistir(descricao);
    }

    public static List<MidiaVo> CarregarDados() throws SQLException, IOException {
        return MidiaDao.CarregarDados();
    }

}
