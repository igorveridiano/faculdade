/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import model.bo.BuscarBo;
import model.bo.DevolverBo;
import view.DevolucaoView;

/**
 *
 * @author igorv
 */
public class DevolucaoControl {
    
    public static boolean BuscarClientePorId(int id, DevolucaoView tela) throws SQLException, IOException{
        return BuscarBo.BuscarClientePorId(id, tela);
    }
    
    public static boolean Devolver(int id, DevolucaoView tela, String item) throws SQLException, IOException, ParseException{
        return DevolverBo.Devolver(id, tela, item);
    }
}
