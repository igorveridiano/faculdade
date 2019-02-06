/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import model.bo.CalculoAluguelBo;
import model.bo.FiltrarDadosBo;
import model.bo.LimparDadosBo;
import model.bo.ListarDadosBo;
import model.bo.SelecaoDeItemBo;
import model.dao.AluguelDao;
import model.vo.AluguelVo;
import view.AluguelView;

/**
 *
 * @author igorv
 */
public class AluguelControl {

    public static void SalvarAluguel(int idCliente, String item, String situacao, Date dataAluguel, Date dataDevolucao, Float valor) throws SQLException, IOException {
        AluguelDao.Persistir(idCliente, item, situacao, dataAluguel, dataDevolucao, valor);
    }

    public static List<AluguelVo> CarregarDados() throws SQLException, IOException {
        return AluguelDao.CarregarDados();
    }
    
    public static void ItemSelecionado(AluguelView tela, int linha){
        SelecaoDeItemBo.ItemSelecionado(tela, linha);
    }
    
    public static Date FormatarData(String data){
        Date dataDevolucao = AluguelVo.FormatarData(data);
        return dataDevolucao;
    }
    
    public static float CarcularValor(int dias, String item) throws SQLException, IOException{
        float valorTotal = CalculoAluguelBo.CarcularValor(dias, item);
        return valorTotal;
    }
    
    public static void CarregarDadosMidia(AluguelView tela) throws SQLException, IOException {
        ListarDadosBo.CarregarDadosMidia(tela);
    }
    
     public static void CarregarDadosProdutora(AluguelView tela) throws SQLException, IOException {
        ListarDadosBo.CarregarDadosProdutora(tela);
     }
    
    public static void FiltroMidia(AluguelView tela, String midia) throws SQLException, IOException {
        FiltrarDadosBo.FiltroMidia(tela, midia);
    }
    
    public static void FiltroSituacao(AluguelView tela, String situacao, String midia, String produtora) throws SQLException, IOException {
        FiltrarDadosBo.FiltroSituacao(tela, situacao, midia, produtora);
    }
    public static void LimparComboBox(AluguelView tela) {
        LimparDadosBo.LimparComboBox(tela);
    }
    
     public static void FiltroProdutora(AluguelView tela, String produtora, String midia) throws SQLException, IOException {
         FiltrarDadosBo.FiltroProdutora(tela, produtora, midia);
     }
     
     public static void LimparTabela(AluguelView tela){
         LimparDadosBo.LimparTabela(tela);
     }

    public static void Atualizar(int id, int idCliente, String item, String d, Date dataAluguel, Date dataDevolucao, Float valor) throws SQLException, IOException {
        AluguelDao.Atualizar(id, idCliente, item, item, dataAluguel, dataDevolucao, valor);
    }
}
