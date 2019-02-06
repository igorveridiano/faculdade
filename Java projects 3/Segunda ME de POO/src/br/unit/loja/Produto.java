package br.unit.loja;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Produto {
	
	private int id;
	private String nome;
	private String descricao;
	private float preco;
	private int quantidade;
	private Produto produtoMarca;
	private ArrayList<Produto> listaSimilar;
	private ArrayList<VendaProduto> listaVendaProduto;
	private Scanner leia;
	private static String endereço = "C://Users//igorv//Desktop//Igor Veridiano Andrade -1161105457//Produto";
	
	public Produto (int id, String nome, String descricao, float preco, int quantidade){
		this.setId(id);
		this.setNome(nome);
		this.setDescricao(descricao);
		this.setPreco(preco);
		this.setQuantidade(quantidade);
		new ArrayList<Produto>();
		new ArrayList<VendaProduto>();
	}
	
	public int getQuantidadeVendas(){
		int quantidade = 0;
		return quantidade;
	}
	
	public float getTotalArrecadadoVenda(){
		float soma, total = 0;
		int idProduto;
		leia = new Scanner(System.in);
		System.out.print("Id do Produto: ");
		idProduto = leia.nextInt();
		for (VendaProduto vendaProduto : listaVendaProduto) {
			if(vendaProduto.getProduto().getId() == idProduto){
				soma = vendaProduto.getVenda().getPrecoTotal();
				total += soma;
			}
		}
		return total;
	}
	
	public ArrayList<Cidade> getListaCidadeClientes(){
		ArrayList<Cidade> listaCidades = new ArrayList<Cidade>();
		int idProduto;
		leia = new Scanner(System.in);
		System.out.print("Id do Produto: ");
		idProduto = leia.nextInt();
		for (VendaProduto vendaProduto : listaVendaProduto) {
			if (vendaProduto.getProduto().getId() == idProduto) {
				listaCidades.add(vendaProduto.getVenda().getCliente().getCidade());
			}
		}
		return listaCidades;
	}
	
	public void CadastrarSimilar(Produto produto){
		for (Produto produto1 : listaSimilar) {
			if (produto1 != produto){
				produto.listaSimilar.add(produto);
				produto.setProdutoMarca(produto);
			} else{
				System.out.println("Produto ja está cadastrado como similar");
			}
		}
	}
	
	public void ExcluirSimilar(Produto produto){
		for (Produto produto1 : listaSimilar) {
			if (produto1 == produto){
				listaSimilar.remove(produto1);
			} else{
				System.out.println("Produto não encontrado");
			}
		}
	}
	
	public boolean ehProdutoMarca(){
		boolean marca = false;
		String nome = null;
		for (VendaProduto vendaProduto : listaVendaProduto) {
			if (vendaProduto.getProduto().getProdutoMarca() == null) {
				marca = true;
				nome = vendaProduto.getProduto().getNome();
			} 
		}
		if (marca) {
			System.out.println("Produto " + nome + " é de marca");
		} else {
			System.out.println("Produto " + nome + " não é de marca");
		}
		return marca;
	}
	
	public void ehProdutoSimilar(){
		String nome = null;
		for (VendaProduto vendaProduto : listaVendaProduto) {
			if (vendaProduto.getProduto().getProdutoMarca() != null) {
				nome = vendaProduto.getProduto().getNome();
				System.out.println("Produto " + nome +" é similar");
			} else {
				System.out.println("Produto " + nome +" não é similar");
			}
		}
		
	}
	
	public void salvarProduto(Produto produto){
		String idProdutoOriginal = "Este produto é de marca";
		for (Produto produto2 : listaSimilar) {
			if (produto.getId() == produto2.getId()){
				idProdutoOriginal = Integer.toString(produto.getProdutoMarca().getId());
			} 
		}
		String escrever;
		escrever = Integer.toString(produto.getId()) + "; " + produto.getNome() + "; " + produto.getDescricao() + "; " + Float.toString(produto.getPreco()) + idProdutoOriginal;
		String nomeArquivo = (produto.getNome() + "_" + produto.getId() + ".txt");
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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

	public ArrayList<Produto> getListaSimilar() {
		return listaSimilar;
	}

	public void setListaSimilar(ArrayList<Produto> listaSimilar) {
		this.listaSimilar = listaSimilar;
	}

	public Produto getProdutoMarca() {
		return produtoMarca;
	}

	public void setProdutoMarca(Produto produtoMarca) {
		this.produtoMarca = produtoMarca;
	}

	public ArrayList<VendaProduto> getListaVendaProduto() {
		return listaVendaProduto;
	}

	public void setListaVendaProduto(ArrayList<VendaProduto> listaVendaProduto) {
		this.listaVendaProduto = listaVendaProduto;
	}

}
