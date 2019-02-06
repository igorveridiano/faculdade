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
@DatabaseTable(tableName = "itens")
public class ItemVo {
    
    @DatabaseField(id = true)
    private int id;
    @DatabaseField
    private String descricao;
    @DatabaseField
    private String dataCompra;
    @DatabaseField
    private String produtora;
    @DatabaseField
    private String situacao;
    @DatabaseField
    private Float valor;
    @DatabaseField
    private String Midia;    

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(String dataCompra) {
        this.dataCompra = dataCompra;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public String getMidia() {
        return Midia;
    }

    public void setMidia(String Midia) {
        this.Midia = Midia;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProdutora() {
        return produtora;
    }

    public void setProdutora(String produtora) {
        this.produtora = produtora;
    }
}
