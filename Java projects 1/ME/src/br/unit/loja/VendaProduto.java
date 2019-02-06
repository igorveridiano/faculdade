package br.unit.loja;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class VendaProduto {
	
	private Venda venda;
	private Produto produto;
	private float preco;
	private int quantidade;
	private static String endereço = "C://Users//igorv//Desktop//Igor Veridiano Andrade -1161105457//venda produto";

	public VendaProduto (Produto produto){
		this.setProduto(produto);
	}
	
	public void salvarVendaProduto(VendaProduto vendaProduto){
		String escrever;
		escrever = Integer.toString(vendaProduto.getVenda().getCodigo()) + "; " + Integer.toString(vendaProduto.getProduto().getId()) + "; " + Float.toString(vendaProduto.getPreco()) + "; " +Integer.toString(vendaProduto.getQuantidade());
		String nomeArquivo = ("VendaProduto_" + vendaProduto.getVenda().getCodigo() + "_" + vendaProduto.getProduto().getId() +".txt");
		try {
			File arquivo = new File(endereço , nomeArquivo);
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
	
	public Cliente getCliente(){
		return null;
	}
	
	public Funcionario getFuncionario(){
		return null;
	}
	
	public void getProduto1(){
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
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
