/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaEscola;

/**
 *
 * @author igorv
 */
public class Administrador {
    
    private String nome;
    private final int cpf;
    private String senha;
    private String matricula;
    
    public Administrador (String nome, int cpf, String senha, String matricula){
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public int getCpf() {
        return cpf;
    }

    public String getSenha() {
        return senha;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setLogin(String matricula) {
        this.matricula = matricula;
    }
}
