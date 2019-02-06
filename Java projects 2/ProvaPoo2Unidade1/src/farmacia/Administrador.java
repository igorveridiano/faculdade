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

@DatabaseTable( tableName = "administradores")
public class Administrador {
    @DatabaseField(id = true)
    private int matriclula;
    @DatabaseField
    private String nome;
    @DatabaseField
    private String senha;

    public Administrador() {
        
    }

    public Administrador(int matriclula, String nome, String senha) {
        this.matriclula = matriclula;
        this.nome = nome;
        this.senha = senha;
    }    
    
    @Override
    public String toString() {
        return  matriclula + " " + nome + " " + senha;
    }

    public int getMatriclula() {
        return matriclula;
    }

    public void setMatriclula(int matriclula) {
        this.matriclula = matriclula;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
}
