/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import model.dao.ProdutoraDao;
import model.vo.ProdutoraVo;

/**
 *
 * @author igorv
 */
public class ProdutoraControl {
    
    public static void SalvarProdutora(String nome) throws SQLException, IOException{
        ProdutoraDao.Persistir(nome);
    }
    
    public static List<ProdutoraVo> CarregarDados() throws SQLException, IOException{
        return ProdutoraDao.CarregarDados();
    }
    
}
