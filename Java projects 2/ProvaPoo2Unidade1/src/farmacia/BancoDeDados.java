/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmacia;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author igorv
 */
public class BancoDeDados {
   
    
    public static void CarregarAdministrador() throws SQLException, IOException{
        // this uses h2 by default but change to match your database
        String databaseUrl = "jdbc:sqlite:C://Users//igorv//Downloads//Exercicio//Banco//Administrador.db";
        
        // create a connection source to our database
        ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl);

        // instantiate the dao
        Dao<Administrador, Integer> administradorDao = DaoManager.createDao(connectionSource, Administrador.class);

        // if you need to create the 'accounts' table make this call
        TableUtils.createTableIfNotExists(connectionSource, Administrador.class);
        
        Administrador administrador = new Administrador();
        administrador.setMatriclula(1);
        administrador.setNome("Igor Veridano");
        administrador.setSenha("admin");
        
        administradorDao.createOrUpdate(administrador);
        
        List<Administrador> lista = administradorDao.queryForAll();
     
        for (Administrador administradores : lista) {
            TelaLogin.getListaAdministradores().add(administradores);
        }
        connectionSource.close();
    }
    
    public static void SalvarCliente(Cliente cliente) throws SQLException, IOException{
        // this uses h2 by default but change to match your database
        String databaseUrl = "jdbc:sqlite:C://Users//igorv//Downloads//Exercicio//Banco//Cliente.db";
        // create a connection source to our database
        ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl);

        // instantiate the dao
        Dao<Cliente, Integer> clienteDao = DaoManager.createDao(connectionSource, Cliente.class);

        // if you need to create the 'accounts' table make this call
        TableUtils.createTableIfNotExists(connectionSource, Cliente.class);
        
        Cliente clientes = new Cliente();
        clientes.setCodigo(cliente.getCodigo());
        clientes.setNome(cliente.getNome());
        
        clienteDao.createOrUpdate(clientes);
        
        connectionSource.close();
    }
    
    public static void CarregarCliente() throws SQLException, IOException{
        // this uses h2 by default but change to match your database
        String databaseUrl = "jdbc:sqlite:C://Users//igorv//Downloads//Exercicio//Banco//Cliente.db";
        // create a connection source to our database
        ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl);

        // instantiate the dao
        Dao<Cliente, Integer> cliente = DaoManager.createDao(connectionSource, Cliente.class);
        
        List<Cliente> lista = cliente.queryForAll();
        for (Cliente clientes : lista) {
            TelaPrincipal.getListaCliente().add(clientes);
        }
        
        connectionSource.close();
    }
    
    public static void SalvarFuncionario(Funcionario funcionario) throws SQLException, IOException{
        // this uses h2 by default but change to match your database
        String databaseUrl = "jdbc:sqlite:C://Users//igorv//Downloads//Exercicio//Banco//Funcionario.db";
        // create a connection source to our database
        ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl);

        // instantiate the dao
        Dao<Funcionario, Integer> funcionarioDao = DaoManager.createDao(connectionSource, Funcionario.class);

        // if you need to create the 'accounts' table make this call
        TableUtils.createTableIfNotExists(connectionSource, Funcionario.class);
        
        Funcionario funcionarios = new Funcionario();
        funcionarios.setMatricula(funcionario.getMatricula());
        funcionarios.setNome(funcionario.getNome());
        funcionarios.setSenha(funcionario.getSenha());
        
        funcionarioDao.createOrUpdate(funcionarios);
        
        connectionSource.close();
    }
    
    public static void CarregarFuncionario() throws SQLException, IOException{
        // this uses h2 by default but change to match your database
        String databaseUrl = "jdbc:sqlite:C://Users//igorv//Downloads//Exercicio//Banco//Funcionario.db";
        // create a connection source to our database
        ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl);

        // instantiate the dao
        Dao<Funcionario, Integer> funcionario = DaoManager.createDao(connectionSource, Funcionario.class);
        
        List<Funcionario> lista = funcionario.queryForAll();
  
        for (Funcionario funcionarios : lista) {
            TelaPrincipal.getListaFuncionarios().add(funcionarios);
        }
        
        connectionSource.close();
    }
    
    public static void SalvarProduto(Produto produto) throws SQLException, IOException{
        // this uses h2 by default but change to match your database
        String databaseUrl = "jdbc:sqlite:C://Users//igorv//Downloads//Exercicio//Banco//Produto.db";
        // create a connection source to our database
        ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl);

        // instantiate the dao
        Dao<Produto, Integer> produtoDao = DaoManager.createDao(connectionSource, Produto.class);

        // if you need to create the 'accounts' table make this call
        TableUtils.createTableIfNotExists(connectionSource, Produto.class);
        
        Produto produtos = new Produto();
        produtos.setCodigo(produto.getCodigo());
        produtos.setDescricao(produto.getDescricao());
        produtos.setPreco(produto.getPreco());
        produtos.setQuantidade(produto.getQuantidade());
        
        produtoDao.createOrUpdate(produtos);
        
        connectionSource.close();
    }
    
    public static void CarregarProduto() throws SQLException, IOException{
        // this uses h2 by default but change to match your database
        String databaseUrl = "jdbc:sqlite:C://Users//igorv//Downloads//Exercicio//Banco//Produto.db";
        // create a connection source to our database
        ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl);

        // instantiate the dao
        Dao<Produto, Integer> produto = DaoManager.createDao(connectionSource, Produto.class);
        
        List<Produto> lista = produto.queryForAll();
        
        for (Produto produtos : lista) {
            TelaPrincipal.getListaProdutos().add(produtos);
        }
        
        connectionSource.close();
    }
    
    public static void SalvarVenda(Venda venda) throws SQLException, IOException{
        // this uses h2 by default but change to match your database
        String databaseUrl = "jdbc:sqlite:C://Users//igorv//Downloads//Exercicio//Banco//Vendas.db";
        // create a connection source to our database
        ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl);

        // instantiate the dao
        Dao<Venda, Integer> vendaDao = DaoManager.createDao(connectionSource, Venda.class);

        // if you need to create the 'accounts' table make this call
        TableUtils.createTableIfNotExists(connectionSource, Venda.class);
        
        Venda vendas = new Venda();
        vendas.setCodigo(venda.getCodigo());
        vendas.setTipo(venda.getTipo());
        vendas.setCliente(venda.getCliente());
        vendas.setFuncionario(venda.getFuncionario());
        vendas.setPreco(venda.getPreco());
        
        vendaDao.createOrUpdate(vendas);
        
        connectionSource.close();
    }
    
    public static void CarregarVenda() throws SQLException, IOException{
        // this uses h2 by default but change to match your database
        String databaseUrl = "jdbc:sqlite:C://Users//igorv//Downloads//Exercicio//Banco//Vendas.db";
        // create a connection source to our database
        ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl);

        // instantiate the dao
        Dao<Venda, Integer> venda = DaoManager.createDao(connectionSource, Venda.class);
        
        List<Venda> lista = venda.queryForAll();
        
        for (Venda vendas : lista) {
            TelaPrincipal.getListaVendas().add(vendas);
        }
        
        connectionSource.close();
    }
}
