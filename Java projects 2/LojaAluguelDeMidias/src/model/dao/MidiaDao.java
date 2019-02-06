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
import model.vo.MidiaVo;

/**
 *
 * @author igorv
 */
public class MidiaDao {
    
    public static void Persistir(String descricao) throws SQLException, IOException {
        // this uses h2 by default but change to match your database
        String databaseUrl = "jdbc:sqlite:Banco//Midias.db";
        // instantiate the dao
        try ( // create a connection source to our database
                ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl)) {
            // instantiate the dao
            Dao<MidiaVo, Integer> midiaDao = DaoManager.createDao(connectionSource, MidiaVo.class);
            
            // if you need to create the 'accounts' table make this call
            TableUtils.createTableIfNotExists(connectionSource, MidiaVo.class);
            MidiaVo midia = new MidiaVo();
            midia.setId(CarregarDados().size() + 1);
            midia.setDescricao(descricao);
            
            midiaDao.createOrUpdate(midia);
        }
    }

    public static List<MidiaVo> CarregarDados() throws SQLException, IOException {
        // this uses h2 by default but change to match your database
        String databaseUrl = "jdbc:sqlite:Banco//Midias.db";
        List<MidiaVo> listaMidias;
        // instantiate the dao
        try ( // create a connection source to our database
                ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl)) {
            // instantiate the dao
            Dao<MidiaVo, Integer> midia = DaoManager.createDao(connectionSource, MidiaVo.class);
            listaMidias = midia.queryForAll();
        }
        
        return listaMidias;
    }
}
