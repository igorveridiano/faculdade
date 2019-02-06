/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaEscola;

import java.util.ArrayList;

/**
 *
 * @author igorv
 */
public class Disciplina {
    
    private String nome;
    private int id;
    ArrayList<Professor> listaProfessores;
    ArrayList<Aluno> listaAlunos;

    public Disciplina(String nome, int id) {
        this.nome = nome;
        this.id = id;
        listaProfessores = new ArrayList();
        listaAlunos = new ArrayList();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
