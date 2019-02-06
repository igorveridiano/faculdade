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
public class Turma {
    
    private String codigo;
    private Professor professor;
    private Disciplina disciplina;
    ArrayList<Aluno> listaAlunos;

    public Turma(String codigo, Professor professor, Disciplina disciplina) {
        this.codigo = codigo;
        this.professor = professor;
        this.disciplina = disciplina;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
   
}
