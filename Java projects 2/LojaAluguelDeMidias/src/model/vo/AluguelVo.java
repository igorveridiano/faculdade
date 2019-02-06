/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.vo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author igorv
 */
@DatabaseTable(tableName = "alugueis")
public class AluguelVo {
    
    @DatabaseField(id = true)
    private int id;
    @DatabaseField
    private int idCliente;
    @DatabaseField
    private String item;
    @DatabaseField
    private String Situacao;
    @DatabaseField
    private String dataAluguel;
    @DatabaseField
    private String dataDevolucao;
    @DatabaseField
    private Float valor;

    public static Date FormatarData(String data) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date dataFormatada = formato.parse(data);
            Date datas = dataFormatada;
            return datas;
        } catch (ParseException e) {
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getDataAluguel() {
        return dataAluguel;
    }

    public void setDataAluguel(String dataAluguel) {
        this.dataAluguel = dataAluguel;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public String getSituacao() {
        return Situacao;
    }

    public void setSituacao(String Situacao) {
        this.Situacao = Situacao;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
}
