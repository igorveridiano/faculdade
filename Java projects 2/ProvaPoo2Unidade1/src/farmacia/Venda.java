/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmacia;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import java.util.ArrayList;

/**
 *
 * @author igorv
 */
@DatabaseTable( tableName = "vendas")
public class Venda {
    @DatabaseField(id = true)
    private int codigo;
    @DatabaseField
    private String tipo;
    @DatabaseField
    private String cliente;
    @DatabaseField
    private String funcionario;
    @DatabaseField
    private float preco;
      
    ArrayList<Produto> listaprodutos = new ArrayList<>();

    public Venda() {
        
    }
    
    public Venda(int codigo, String tipo, String cliente, String funcionario, float preco) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.preco = preco;
    }
    
    @Override
    public String toString() {
        return  codigo + " " + tipo + " " + cliente + " " + funcionario + " " + preco;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(String funcionario) {
        this.funcionario = funcionario;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
    
}
