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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import model.vo.ItemVo;

/**
 *
 * @author igorv
 */
public class ItemDao {
    
    private static Date dataCompras = null;
    
    public static void Persistir(String descricao, String situacao, String data, Float valor, String Midia, String produtora) throws SQLException, IOException, ParseException {
        // this uses h2 by default but change to match your database
        String databaseUrl = "jdbc:sqlite:Banco//Itens.db";
        // instantiate the dao
        try ( // create a connection source to our database
                ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl)) {
            // instantiate the dao
            Dao<ItemVo, Integer> itemDao = DaoManager.createDao(connectionSource, ItemVo.class);
            // if you need to create the 'accounts' table make this call
            TableUtils.createTableIfNotExists(connectionSource, ItemVo.class);
            ItemVo item = new ItemVo();
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            try {
                Date dataFormatada = formato.parse(data);
                dataCompras = dataFormatada;
            } catch (ParseException e) {
            }
            item.setDescricao(descricao);
            item.setId(CarregarDados().size() + 1);
            item.setSituacao(situacao);
            item.setDataCompra(formato.format(dataCompras));
            item.setValor(valor);
            item.setMidia(Midia);
            item.setProdutora(produtora);
            itemDao.createOrUpdate(item);
        }    }
    
    public static void Atualizar(int id, String descricao, String data, String produtora, String situacao, float valor, String midia) throws SQLException, IOException, ParseException {
        // this uses h2 by default but change to match your database
        String databaseUrl = "jdbc:sqlite:Banco//Itens.db";
        // instantiate the dao
        try ( // create a connection source to our database
                ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl)) {
            // instantiate the dao
            Dao<ItemVo, Integer> itemDao = DaoManager.createDao(connectionSource, ItemVo.class);
            
            // if you need to create the 'accounts' table make this call
            TableUtils.createTableIfNotExists(connectionSource, ItemVo.class);
            ItemVo item = new ItemVo();
            
            item.setId(id);
            item.setDescricao(descricao);
            item.setDataCompra(data);
            item.setProdutora(produtora);
            item.setSituacao(situacao);
            item.setValor(valor);
            item.setMidia(midia);
            
            
            itemDao.update(item);
        }
    }

    public static List<ItemVo> CarregarDados() throws SQLException, IOException {
        // this uses h2 by default but change to match your database
        String databaseUrl = "jdbc:sqlite:Banco//Itens.db";
        List<ItemVo> listaItens;
        // instantiate the dao
        try ( // create a connection source to our database
                ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl)) {
            // instantiate the dao
            Dao<ItemVo, Integer> item = DaoManager.createDao(connectionSource, ItemVo.class);
            listaItens = item.queryForAll();
        }
        
        return listaItens;
    }
    
    public static Date getDataCompras() {
        return dataCompras;
    }

    public static void setDataCompras(Date dataCompras) {
        ItemDao.dataCompras = dataCompras;
    }
}
