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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import model.vo.AluguelVo;

/**
 *
 * @author igorv
 */
public class AluguelDao {
    
    public static void Persistir(int idCliente, String item, String situacao, Date dataAluguel, Date dataDevolucao, Float valor) throws SQLException, IOException {
        // this uses h2 by default but change to match your database
        String databaseUrl = "jdbc:sqlite:Banco//Alugueis.db";
        // create a connection source to our database
        ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl);

        // instantiate the dao
        Dao<AluguelVo, Integer> aluguelDao = DaoManager.createDao(connectionSource, AluguelVo.class);

        // if you need to create the 'accounts' table make this call
        TableUtils.createTableIfNotExists(connectionSource, AluguelVo.class);

        AluguelVo aluguel = new AluguelVo();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        aluguel.setId(CarregarDados().size() + 1);
        aluguel.setItem(item);
        aluguel.setSituacao(situacao);
        aluguel.setDataAluguel(formato.format(dataAluguel));
        aluguel.setDataDevolucao(formato.format(dataDevolucao));
        aluguel.setValor(valor);
        aluguel.setIdCliente(idCliente);

        aluguelDao.createOrUpdate(aluguel);

        connectionSource.close();
    }
    
    public static void Atualizar(int id, int idCliente, String item, String situacao, Date dataAluguel, Date dataDevolucao, Float valor) throws SQLException, IOException{
        // this uses h2 by default but change to match your database
        String databaseUrl = "jdbc:sqlite:Banco//Alugueis.db";
        // create a connection source to our database
        ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl);

        // instantiate the dao
        Dao<AluguelVo, Integer> aluguelDao = DaoManager.createDao(connectionSource, AluguelVo.class);

        // if you need to create the 'accounts' table make this call
        TableUtils.createTableIfNotExists(connectionSource, AluguelVo.class);

        AluguelVo aluguel = new AluguelVo();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        aluguel.setId(id);
        aluguel.setItem(item);
        aluguel.setSituacao(situacao);
        aluguel.setDataAluguel(formato.format(dataAluguel));
        aluguel.setDataDevolucao(formato.format(dataDevolucao));
        aluguel.setValor(valor);
        aluguel.setIdCliente(idCliente);

        aluguelDao.update(aluguel);

        connectionSource.close();
    }

    public static List<AluguelVo> CarregarDados() throws SQLException, IOException {
        // this uses h2 by default but change to match your database
        String databaseUrl = "jdbc:sqlite:Banco//Alugueis.db";
        // create a connection source to our database
        ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl);

        // instantiate the dao
        Dao<AluguelVo, Integer> aluguel = DaoManager.createDao(connectionSource, AluguelVo.class);

        List<AluguelVo> listaAlugueis = aluguel.queryForAll();

        connectionSource.close();

        return listaAlugueis;
    }
}
