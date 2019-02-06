package br.aju.aprendeEmCasa.entidades;

import java.util.ArrayList;
import java.util.Set;

public class Estoque {
	
	private ArrayList<Curso> cursos;
	private Curso curso;
	private DVD midia1;
	private VHS midia2;
	private int quatidadeExemplar;
	
	public Estoque (Curso curso ,DVD midia){
		this.setMidia1(midia);
		this.setCurso(curso);
		new ArrayList<Curso>();
	}
	
    public Estoque (Curso curso ,VHS midia){
		this.setMidia2(midia);
		this.setCurso(curso);
		new ArrayList<Curso>();
	}
    
    public Estoque(){
    	
    }
    
    public void cadastrarCurso(Curso c, int quantidade){
    	for (Curso curso : cursos) {
			if(curso != c){
				cursos.add(c);
				this.quatidadeExemplar = quantidade;
			} else {
				this.quatidadeExemplar += quantidade;
			}
		}
    }
    
    public void aumentarEstoque(int codigo, int quantidade){
    	for (Curso curso : cursos) {
			if(codigo == curso.getCodigo()){
				this.quatidadeExemplar += quantidade; 
			} else {
				this.quatidadeExemplar = quantidade;
			}
		}
    }
    
    public void removerCurso(int codigo){
    	for (Curso curso : cursos) {
			if ((curso.getCodigo() == codigo) && (this.quatidadeExemplar == 0)){
				cursos.remove(curso);
			}
		}
    }
    
    public Curso buscarsCurso(int codigo){
    	Curso curso1 = null;
    	for (Curso curso : cursos) {
			if(curso.getCodigo() == codigo){
				curso1 = curso;
			}
		}
		return curso1;
    	
    }
    
    public Set<Curso> listarCursos(){
		return null;
    }
    
    public Set<Curso> listarCursos(char tipo){
		return null;
    }

    public ArrayList<Curso> getCursos() {
	return cursos;
    }

    public void setCursos(ArrayList<Curso> cursos) {
	this.cursos = cursos;
    }

    public DVD getMidia1() {
	return midia1;
    }

    public void setMidia1(DVD midia1) {
	this.midia1 = midia1;
    }

    public VHS getMidia2() {
	return midia2;
    }
  
    public void setMidia2(VHS midia2) {
	this.midia2 = midia2;
    }

    public int getQuatidadeExemplar() {
	return quatidadeExemplar;
    }

    public void setQuatidadeExemplar(int quatidadeExemplar) {
	this.quatidadeExemplar = quatidadeExemplar;
    }

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

}
