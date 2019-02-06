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

@DatabaseTable( tableName = "funcionarios")
public class Funcionario {
    @DatabaseField(id = true)
    private int matricula;
    @DatabaseField
    private String nome;
    @DatabaseField
    private String senha;
    ArrayList<Venda> listavendas = new ArrayList<>();

    public Funcionario() {
        
    }
    
    public Funcionario(int matricula, String nome, String senha) {
        this.matricula = matricula;
        this.nome = nome;
        this.senha = senha;
    }
    
    @Override
    public String toString() {
        return  matricula + " " + nome + " " + senha;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
}
