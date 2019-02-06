/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.vo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 *
 * @author igorv
 */
@DatabaseTable(tableName = "notasFiscais")
public class NotaFiscalVo {
    
    @DatabaseField(id = true)
    private int numero;
    @DatabaseField
    private String compradorCpfOuCnpj;
    @DatabaseField
    private String vendedorCpfOuCnpj;
    @DatabaseField
    private float valor;
    @DatabaseField
    private int ano;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCompradorCpfOuCnpj() {
        return compradorCpfOuCnpj;
    }

    public void setCompradorCpfOuCnpj(String compradorCpfOuCnpj) {
        this.compradorCpfOuCnpj = compradorCpfOuCnpj;
    }

    public String getVendedorCpfOuCnpj() {
        return vendedorCpfOuCnpj;
    }

    public void setVendedorCpfOuCnpj(String vendedorCpfOuCnpj) {
        this.vendedorCpfOuCnpj = vendedorCpfOuCnpj;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
    
}
