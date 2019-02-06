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
@DatabaseTable(tableName = "malhaFina")
public class MalhaFinaVo {
    
    @DatabaseField(id = true)
    private int id;
    @DatabaseField
    private int ano;
    @DatabaseField
    private String pessoaCpfOuCnpj;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getPessoaCpfOuCnpj() {
        return pessoaCpfOuCnpj;
    }

    public void setPessoaCpfOuCnpj(String pessoaCpfOuCnpj) {
        this.pessoaCpfOuCnpj = pessoaCpfOuCnpj;
    }
    
    
}
