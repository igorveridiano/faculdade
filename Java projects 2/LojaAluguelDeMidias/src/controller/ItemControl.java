/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import model.bo.LimparDadosBo;
import model.bo.ListarDadosBo;
import model.bo.VerificarBo;
import model.dao.ItemDao;
import model.vo.ItemVo;
import view.CadastroDeItensView;
import view.VerificarTitulosView;

/**
 *
 * @author igorv
 */
public class ItemControl {

    public static void SalvarItem(String descricao, String situacao, String data, Float valor, String Midia, String produtora) throws ParseException, SQLException, IOException {
        ItemDao.Persistir(descricao, situacao, data, valor, Midia, produtora);
    }
    
    public static void Atualizar(int id, String descriao, String data, String produtora, String situacao, float valor, String midia) throws SQLException, IOException, ParseException{
        ItemDao.Atualizar(id, descriao, data, produtora, situacao, valor, midia);
    }

    public static List<ItemVo> CarregarDados() throws SQLException, IOException {
        return ItemDao.CarregarDados();
    }
    
    public static void CarregarDadosMidia(CadastroDeItensView tela) throws SQLException, IOException {
        ListarDadosBo.CarregarDadosMidia(tela);
    }
    
    public static void CarregarDadosProdutora(CadastroDeItensView tela) throws IOException, SQLException {
        ListarDadosBo.CarregarDadosProdutora(tela);
    }
    
    public static void Limpar(CadastroDeItensView tela) {
        LimparDadosBo.LimparComboBox(tela);
    }
    
    public static void VerificarTitulos(VerificarTitulosView tela) throws SQLException, IOException{
        VerificarBo.VerificarTitulos(tela);
    }
    
    public static void Limpar(VerificarTitulosView tela){
        LimparDadosBo.LimparTabela(tela);
    }
}
