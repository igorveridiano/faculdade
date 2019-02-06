package br.aju.aprendeEmCasa.entidades;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

	private static Scanner leia;
	private static String endereco = "C://Users//igorv//Desktop//Igor Veridiano Andrade -1161105457//Prova//estoque";
	
	
	
	public void salvarCurso(Curso curso){
		String nome;
		String escrever;
		System.out.print("Nome do curso: ");
    	nome = leia.nextLine();
    	escrever = nome + "; " + curso.getCodigo() + "; " + curso.getCusto() + "; " + curso.getTema() + "; " + curso.getLancamento() + "; ";
		String nomeArquivo = (nome + "_" + curso.getCodigo() + ".txt");
		try {
			File arquivo = new File(endereco , nomeArquivo);
			if (!arquivo.exists()) {
				arquivo.createNewFile();
			}
			FileWriter fw = new FileWriter(arquivo.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(escrever);
			bw.close();
	        System.out.println("arquivo salvo com sucesso");
	     } catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String verificador1, verificador2, verificador3 = null;
		leia = new Scanner(System.in);
		ArrayList<Curso> cursos = new ArrayList<Curso>();
		ArrayList<Estoque> estoques = new ArrayList<Estoque>();
		ArrayList<DVD> dvds = new ArrayList<DVD>();
		ArrayList<VHS> vhss = new ArrayList<VHS>();
		do {
			System.out.println("Escolha o menu que deseja acessar:");
			System.out.println("1-Curso");
			System.out.println("2-Estoque");
			System.out.println("3-DVD");
			System.out.println("4-VHS");
			System.out.print("5-Sair: ");
			verificador1 = leia.nextLine();
			switch (verificador1){
			case "1" :
				System.out.println("1-Cadastrar Curso");
				System.out.print("1-Adicionar Curso");
				verificador2 = leia.nextLine();
			    switch (verificador2){
			    case "1":
			    	int codigo;
			    	String tema, lancamento;
			    	double custo;
			    	System.out.print("Codigo: ");
			    	codigo = leia.nextInt();
			    	System.out.print("Tema: ");
			    	tema = leia.nextLine();
			    	System.out.print("Custo: ");
			    	custo = leia.nextDouble();
			    	System.out.print("Lançamento: ");
			    	lancamento = leia.nextLine();
			    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
					LocalDate date = LocalDate.parse(lancamento,formatter);
			    	Curso curso = new Curso(codigo, tema, custo, date);
			    	cursos.add(curso);
			    	break;	
			    case "2":
			    	int codigo1, quantidade;
			    	System.out.print("Codigo: ");
			    	codigo1 = leia.nextInt();
			    	System.out.print("Quantidade: ");
			    	quantidade = leia.nextInt();
			    	for (Curso c : cursos) {
						if(c.getCodigo() == codigo1){
							for (Estoque estoque : estoques) {
								if(estoque.getCurso() == c){
									estoque.cadastrarCurso(c, quantidade);
								}
							}
						}
					}
			    	break;
			    default :
			    	break;
			    }
				break;
			case "2" :
				System.out.println("1-Adicionar Estoque");
				System.out.println("2-Aumentar estoque: ");
				System.out.println("3-Remoção de curso: ");
				System.out.println("4-Buscar curso: ");
				verificador2 = leia.nextLine();
			    switch (verificador2){
			    case "1":
			    	String  midia;
			    	int codigoCurso;
			    	System.out.print("Codigo do Curso: ");
			    	codigoCurso = leia.nextInt();
			    	System.out.print("Midia: ");
			    	midia = leia.nextLine();
			    	for (Curso curso : cursos) {
						if (curso.getCodigo() == codigoCurso){
							if (midia == "vhs"){
								int midiaCodigo;
								System.out.print("Midia: ");
								midiaCodigo =leia.nextInt();
								for (VHS vhs : vhss) {
									if(vhs.getCodigo() == midiaCodigo){
										Estoque estoque = new Estoque(curso, vhs);
										estoques.add(estoque);
									}
								}
							} if (midia == "dvd"){
								int midiaCodigo;
								System.out.print("Midia: ");
								midiaCodigo =leia.nextInt();
								for (DVD dvd : dvds) {
									if(dvd.getCodigo() == midiaCodigo){
										Estoque estoque = new Estoque(curso, dvd);
										estoques.add(estoque);
									}
							}
							
						}
					  } 
			    	}
			    	break;
			    case "2" :
			    	int codigo, quantidade;
			    	System.out.print("Codigo do curso: ");
			    	codigo = leia.nextInt();
			    	System.out.print("Quantidade do curso: ");
			    	quantidade = leia.nextInt();
			    	for (Curso curso : cursos) {
						if(curso.getCodigo() == codigo){
							for (Estoque estoque : estoques) {
								if(estoque.getCurso() == curso){
									estoque.aumentarEstoque(codigo, quantidade);
								}
							}
						}
					}
			    	break;
			    case "3" :
			    	int codigo1;
			    	System.out.print("Codigo do curso: ");
			    	codigo1 = leia.nextInt();
			    	for (Curso curso : cursos) {
						if(curso.getCodigo() == codigo1){
							for (Estoque estoque : estoques) {
								if(estoque.getCurso() == curso){
									estoque.removerCurso(codigo1);
								}
							}
						}
					}
			    	break;
			    case "4" :
			    	int codigo2;
			    	System.out.print("Codigo do curso: ");
			    	codigo2 = leia.nextInt();
			    	for (Curso curso : cursos) {
						if (curso.getCodigo() == codigo2){
							for (Estoque estoque : estoques) {
								if(estoque.getCurso() == curso){
									estoque.buscarsCurso(codigo2);
								}
							}
						}
					}
			    default :
			    	break;
			    }
				break;
			case "3" :
				System.out.print("1-Cadastrar DVD");
				verificador2 = leia.nextLine();
			    switch (verificador2){
			    case "1" :
			    	int codigo;
			    	String tema, lancamento;
			    	double custo;
			    	System.out.print("Codigo: ");
			    	codigo = leia.nextInt();
			    	System.out.print("Tema: ");
			    	tema = leia.nextLine();
			    	System.out.print("Custo do curso: ");
			    	custo = leia.nextDouble();
			    	System.out.print("Lançamento: ");
			    	lancamento = leia.nextLine();
			    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
					LocalDate date = LocalDate.parse(lancamento,formatter);
					DVD dvd = new DVD(codigo, tema, custo, date);
					dvds.add(dvd);
			    	break;
			    default :
			    	break;
			    }
				break;
			case "4" :
				System.out.print("1-Cadastrar VHS");
				verificador2 = leia.nextLine();
			    switch (verificador2){
			    case "1" :
			    	int codigo;
			    	String tema, lancamento, marca;
			    	double custo, custoDaFita;
			    	System.out.print("Codigo: ");
			    	codigo = leia.nextInt();
			    	System.out.print("Tema: ");
			    	tema = leia.nextLine();
			    	System.out.print("Custo do curso: ");
			    	custo = leia.nextDouble();
			    	System.out.print("Lançamento: ");
			    	lancamento = leia.nextLine();
			    	System.out.print("Custo da Fita: ");
			    	custoDaFita = leia.nextDouble();
			    	System.out.print("marca: ");
			    	marca = leia.nextLine();
			    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
					LocalDate date = LocalDate.parse(lancamento,formatter);
					VHS vhs = new VHS(codigo, tema, custo, date, custoDaFita, marca);
					vhss.add(vhs);
			    	break;
			    default :
			    	break;
			    }
				break;
			case "5" :
				System.out.print("Saindo");
				verificador3 = "sair";
				break;
			default :
				break;
		} 
	  }while(verificador3 != "sair");
  }	
}
	
