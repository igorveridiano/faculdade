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
import model.vo.PessoaFisicaVo;

/**
 *
 * @author igorv
 */
public class PessoaFisicaDao {
    
    public static void Persistir(String cpf, String nome) throws SQLException, IOException, ParseException {
        // this uses h2 by default but change to match your database
        String databaseUrl = "jdbc:sqlite:Banco//Pessoas.db";
        // instantiate the dao
        try ( // create a connection source to our database
                ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl)) {
            // instantiate the dao
            Dao<PessoaFisicaVo, Integer> pessoaDao = DaoManager.createDao(connectionSource, PessoaFisicaVo.class);
            // if you need to create the 'accounts' table make this call
            TableUtils.createTableIfNotExists(connectionSource, PessoaFisicaVo.class);
            
            PessoaFisicaVo pessoa = new PessoaFisicaVo();
            
            pessoa.setCpf(cpf);
            pessoa.setNome(nome);
            
            pessoaDao.createOrUpdate(pessoa);
        }    
    }

    public static List<PessoaFisicaVo> CarregarDados() throws SQLException, IOException {
        // this uses h2 by default but change to match your database
        String databaseUrl = "jdbc:sqlite:Banco//Pessoas.db";
        List<PessoaFisicaVo> listaPessoas;
        // instantiate the dao
        try ( // create a connection source to our database
                ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl)) {
            // instantiate the dao
            Dao<PessoaFisicaVo, Integer> pessoa = DaoManager.createDao(connectionSource, PessoaFisicaVo.class);
            listaPessoas = pessoa.queryForAll();
        }
        
        return listaPessoas;
    }
}
