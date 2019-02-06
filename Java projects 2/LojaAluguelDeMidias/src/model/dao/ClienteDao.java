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
import model.vo.ClienteVo;

/**
 *
 * @author igorv
 */
public class ClienteDao {
    
    public static void Persistir(String nome, int cpf) throws SQLException, IOException {
        // this uses h2 by default but change to match your database
        String databaseUrl = "jdbc:sqlite:Banco//Clientes.db";
        // instantiate the dao
        try ( // create a connection source to our database
                ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl)) {
            // instantiate the dao
            Dao<ClienteVo, Integer> clienteDao = DaoManager.createDao(connectionSource, ClienteVo.class);
            
            // if you need to create the 'accounts' table make this call
            TableUtils.createTableIfNotExists(connectionSource, ClienteVo.class);
            ClienteVo cliente = new ClienteVo();
            cliente.setNome(nome);
            cliente.setCpf(cpf);
            
            clienteDao.createOrUpdate(cliente);
        }
    }

    public static List<ClienteVo> CarregarDados() throws SQLException, IOException {
        // this uses h2 by default but change to match your database
        String databaseUrl = "jdbc:sqlite:Banco//Clientes.db";
        List<ClienteVo> listaClientes;
        // instantiate the dao
        try ( // create a connection source to our database
                ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl)) {
            // instantiate the dao
            Dao<ClienteVo, Integer> cliente = DaoManager.createDao(connectionSource, ClienteVo.class);
            listaClientes = cliente.queryForAll();
        }
        
        return listaClientes;
    }
}
