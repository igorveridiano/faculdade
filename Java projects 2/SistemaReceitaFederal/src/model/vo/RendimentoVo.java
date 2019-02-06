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
@DatabaseTable(tableName = "rendimentos")
public class RendimentoVo {
    
    @DatabaseField(id = true)
    private int id;
    @DatabaseField
    private float rendimento;
    @DatabaseField
    private String pessoaCpfOuCnpj;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getRendimento() {
        return rendimento;
    }

    public void setRendimento(float rendimento) {
        this.rendimento = rendimento;
    }

    public String getPessoaCpfOuCnpj() {
        return pessoaCpfOuCnpj;
    }

    public void setPessoaCpfOuCnpj(String pessoaCpfOuCnpj) {
        this.pessoaCpfOuCnpj = pessoaCpfOuCnpj;
    }
    
}
