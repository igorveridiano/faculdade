/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmacia;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 *
 * @author igorv
 */

@DatabaseTable( tableName = "produtos")
public class Produto {
    @DatabaseField(id = true)
    private int codigo;
    @DatabaseField
    private String descricao;
    @DatabaseField
    private float preco;
    @DatabaseField
    private int quantidade;

    public Produto() {
        
    }

    public Produto(int codigo, String descricao, float preco, int quantidade) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
    }
    
    @Override
    public String toString() {
        return  codigo + " " + descricao + " " + preco + " " + quantidade;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    
}
