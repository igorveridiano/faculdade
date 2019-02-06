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
import java.text.ParseException;
import java.util.List;
import model.vo.MalhaFinaVo;
import model.vo.PessoaJuridicaVo;

/**
 *
 * @author igorv
 */
public class MalhaFinaDao {
    
    public static void Persistir(int ano, String pessoaCpfOuCnpj) throws SQLException, IOException, ParseException {
        // this uses h2 by default but change to match your database
        String databaseUrl = "jdbc:sqlite:Banco//MalhaFina.db";
        // instantiate the dao
        try ( // create a connection source to our database
                ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl)) {
            // instantiate the dao
            Dao<MalhaFinaVo, Integer> malhaFinaDao = DaoManager.createDao(connectionSource, MalhaFinaVo.class);
            // if you need to create the 'accounts' table make this call
            TableUtils.createTableIfNotExists(connectionSource, MalhaFinaVo.class);
            
            MalhaFinaVo malhaFina = new MalhaFinaVo();
            
           malhaFina.setId(CarregarDados().size() + 1);
           malhaFina.setAno(ano);
           malhaFina.setPessoaCpfOuCnpj(pessoaCpfOuCnpj);
            
            malhaFinaDao.createOrUpdate(malhaFina);
        }    
    }

    public static List<MalhaFinaVo> CarregarDados() throws SQLException, IOException {
        // this uses h2 by default but change to match your database
        String databaseUrl = "jdbc:sqlite:Banco//MalhaFina.db";
        List<MalhaFinaVo> listaMalhaFina;
        // instantiate the dao
        try ( // create a connection source to our database
                ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl)) {
            // instantiate the dao
            Dao<MalhaFinaVo, Integer> malhaFina = DaoManager.createDao(connectionSource, MalhaFinaVo.class);
            listaMalhaFina = malhaFina.queryForAll();
        }
        
        return listaMalhaFina;
    }
}
