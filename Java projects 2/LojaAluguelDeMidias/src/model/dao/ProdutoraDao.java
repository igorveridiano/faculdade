/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import model.vo.ProdutoraVo;

/**
 *
 * @author igorv
 */
public class ProdutoraDao {
    
    public static void Persistir(String nome) throws SQLException, IOException {
        // this uses h2 by default but change to match your database
        String databaseUrl = "jdbc:sqlite:Banco//Produtoras.db";
        // instantiate the dao
        try ( // create a connection source to our database
                ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl)) {
            // instantiate the dao
            Dao<ProdutoraVo, Integer> produtoraDao = DaoManager.createDao(connectionSource, ProdutoraVo.class);
            
            // if you need to create the 'accounts' table make this call
            TableUtils.createTableIfNotExists(connectionSource, ProdutoraVo.class);
            ProdutoraVo produtora = new ProdutoraVo();
            produtora.setId(CarregarDados().size() + 1);
            produtora.setNome(nome);
            
            produtoraDao.createOrUpdate(produtora);
        }
    }

    public static List<ProdutoraVo> CarregarDados() throws SQLException, IOException {
        // this uses h2 by default but change to match your database
        String databaseUrl = "jdbc:sqlite:Banco//Produtoras.db";
        List<ProdutoraVo> listaProdutora;
        // instantiate the dao
        try ( // create a connection source to our database
                ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl)) {
            // instantiate the dao
            Dao<ProdutoraVo, Integer> produtora = DaoManager.createDao(connectionSource, ProdutoraVo.class);
            listaProdutora = produtora.queryForAll();
        }
        
        return listaProdutora;
    }
}
