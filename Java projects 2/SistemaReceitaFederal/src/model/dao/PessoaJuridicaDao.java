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
import model.vo.PessoaJuridicaVo;

/**
 *
 * @author igorv
 */
public class PessoaJuridicaDao {
    
    public static void Persistir(String cnpj, String nome) throws SQLException, IOException, ParseException {
        // this uses h2 by default but change to match your database
        String databaseUrl = "jdbc:sqlite:Banco//Empresas.db";
        // instantiate the dao
        try ( // create a connection source to our database
                ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl)) {
            // instantiate the dao
            Dao<PessoaJuridicaVo, Integer> pessoaDao = DaoManager.createDao(connectionSource, PessoaJuridicaVo.class);
            // if you need to create the 'accounts' table make this call
            TableUtils.createTableIfNotExists(connectionSource, PessoaJuridicaVo.class);
            
            PessoaJuridicaVo pessoa = new PessoaJuridicaVo();
            
            pessoa.setCnpj(cnpj);
            pessoa.setNome(nome);
            
            pessoaDao.createOrUpdate(pessoa);
        }    
    }

    public static List<PessoaJuridicaVo> CarregarDados() throws SQLException, IOException {
        // this uses h2 by default but change to match your database
        String databaseUrl = "jdbc:sqlite:Banco//Empresas.db";
        List<PessoaJuridicaVo> listaEmpresas;
        // instantiate the dao
        try ( // create a connection source to our database
                ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl)) {
            // instantiate the dao
            Dao<PessoaJuridicaVo, Integer> pessoa = DaoManager.createDao(connectionSource, PessoaJuridicaVo.class);
            listaEmpresas = pessoa.queryForAll();
        }
        
        return listaEmpresas;
    }
}
