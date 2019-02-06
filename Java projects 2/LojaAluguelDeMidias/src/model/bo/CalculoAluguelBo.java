/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bo;

import controller.ItemControl;
import java.io.IOException;
import java.sql.SQLException;
import model.vo.ItemVo;

/**
 *
 * @author igorv
 */
public class CalculoAluguelBo {
    
    public static float CarcularValor(int dias, String item) throws SQLException, IOException {
        float valorTotal = 0;
        for (ItemVo itens : ItemControl.CarregarDados()) {
            if (itens.getDescricao().equals(item)) {
                valorTotal = dias * itens.getValor();
            }
        }
        return valorTotal;
    }
}
