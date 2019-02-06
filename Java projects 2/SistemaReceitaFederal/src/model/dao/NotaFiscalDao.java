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
import model.vo.NotaFiscalVo;
import model.vo.RendimentoVo;

/**
 *
 * @author igorv
 */
public class NotaFiscalDao {
    
    public static void Persistir(int numero, String compradorCpfOuCnpj, String vendedorCpfOuCnpj, float valor, int ano) throws SQLException, IOException, ParseException {
        // this uses h2 by default but change to match your database
        String databaseUrl = "jdbc:sqlite:Banco//NotasFiscais.db";
        // instantiate the dao
        try ( // create a connection source to our database
                ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl)) {
            // instantiate the dao
            Dao<NotaFiscalVo, Integer> notaFiscalDao = DaoManager.createDao(connectionSource, NotaFiscalVo.class);
            // if you need to create the 'accounts' table make this call
            TableUtils.createTableIfNotExists(connectionSource, NotaFiscalVo.class);
            
            NotaFiscalVo notaFiscal = new NotaFiscalVo();
            
            notaFiscal.setNumero(numero);
            notaFiscal.setCompradorCpfOuCnpj(compradorCpfOuCnpj);
            notaFiscal.setVendedorCpfOuCnpj(vendedorCpfOuCnpj);
            notaFiscal.setValor(valor);
            notaFiscal.setAno(ano);
            
            notaFiscalDao.createOrUpdate(notaFiscal);
        }    
    }

    public static List<NotaFiscalVo> CarregarDados() throws SQLException, IOException {
        // this uses h2 by default but change to match your database
        String databaseUrl = "jdbc:sqlite:Banco//NotasFiscais.db";
        List<NotaFiscalVo> listaNotasFiscais;
        // instantiate the dao
        try ( // create a connection source to our database
                ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl)) {
            // instantiate the dao
            Dao<NotaFiscalVo, Integer> notaFiscal = DaoManager.createDao(connectionSource, NotaFiscalVo.class);
            listaNotasFiscais = notaFiscal.queryForAll();
        }
        
        return listaNotasFiscais;
    }
}
