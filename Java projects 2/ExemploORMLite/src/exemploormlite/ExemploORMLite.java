/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemploormlite;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author 11645
 */
public class ExemploORMLite {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // this uses h2 by default but change to match your database
        String databaseUrl = "jdbc:sqlite:C://Users//igorv//Downloads//banco_de_dados.db";
        
        // create a connection source to our database
        ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl);

        // instantiate the dao
        Dao<Pessoa, Integer> pessoaDao = DaoManager.createDao(connectionSource, Pessoa.class);

        // if you need to create the 'accounts' table make this call
        TableUtils.createTableIfNotExists(connectionSource, Pessoa.class);
        
        Pessoa pessoa = new Pessoa();
        pessoa.id = 4;
        pessoa.nome = "Zezinho";
        pessoa.idade = 15;
        
        pessoaDao.createOrUpdate(pessoa);

        
        Pessoa pessoaBanco = pessoaDao.queryForId(2);
        System.out.println(pessoaBanco);
        List<Pessoa> lista = pessoaDao.queryForEq("nome", "Zezinho");
        //List<Pessoa> lista = pessoaDao.queryForAll();
        
        System.out.println(lista);
        
        connectionSource.close();
        
    }
    
}
