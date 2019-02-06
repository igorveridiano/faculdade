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
import model.vo.RendimentoVo;

/**
 *
 * @author igorv
 */
public class RendimentoDao {
    
    public static void Persistir(float rendimento, String pessoaCpfOuCnpj) throws SQLException, IOException, ParseException {
        // this uses h2 by default but change to match your database
        String databaseUrl = "jdbc:sqlite:Banco//Rendimentos.db";
        // instantiate the dao
        try ( // create a connection source to our database
                ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl)) {
            // instantiate the dao
            Dao<RendimentoVo, Integer> rendimentoDao = DaoManager.createDao(connectionSource, RendimentoVo.class);
            // if you need to create the 'accounts' table make this call
            TableUtils.createTableIfNotExists(connectionSource, RendimentoVo.class);
            
            RendimentoVo rendimentos = new RendimentoVo();
            
            rendimentos.setId(CarregarDados().size() + 1);
            rendimentos.setPessoaCpfOuCnpj(pessoaCpfOuCnpj);
            rendimentos.setRendimento(rendimento);
            
            rendimentoDao.createOrUpdate(rendimentos);
        }    
    }

    public static List<RendimentoVo> CarregarDados() throws SQLException, IOException {
        // this uses h2 by default but change to match your database
        String databaseUrl = "jdbc:sqlite:Banco//Rendimentos.db";
        List<RendimentoVo> listaRendimentos;
        // instantiate the dao
        try ( // create a connection source to our database
                ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl)) {
            // instantiate the dao
            Dao<RendimentoVo, Integer> rendimento = DaoManager.createDao(connectionSource, RendimentoVo.class);
            listaRendimentos = rendimento.queryForAll();
        }
        
        return listaRendimentos;
    }
}
