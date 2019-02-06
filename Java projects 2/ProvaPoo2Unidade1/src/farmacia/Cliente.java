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
@DatabaseTable( tableName = "clientes")
public class Cliente {
    @DatabaseField
    private String nome;
    @DatabaseField(id = true)
    private int codigo;
    ArrayList<Venda> listavendas = new ArrayList<>();

    public Cliente() {
        
    }

    public Cliente(String nome, int codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }
    
    @Override
    public String toString() {
        return  nome + " " + " " + codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

}
