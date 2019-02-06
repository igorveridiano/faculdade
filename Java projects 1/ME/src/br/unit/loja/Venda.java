package br.unit.loja;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Venda {
	
	private int codigo;
	private LocalDate data;
	private float precoTotal;
	private Cliente cliente;
	private Funcionario funcionario;
	private ArrayList<VendaProduto> listaProduto;
	private Scanner leia;
	private boolean finalizar = false;
	private static String endereço = "C://Users//igorv//Desktop//Igor Veridiano Andrade -1161105457//vendas";

	public Venda (int codigo, LocalDate data, float precoTotal, Cliente cliente, Funcionario funcionario){
		this.setCodigo(codigo);
		this.setData(data);
		this.setPrecoTotal(precoTotal);
		this.setCliente(cliente);
		this.setFuncionario(funcionario);
		new ArrayList<VendaProduto>();
	}
	
	public void finalizarVenda(){
		finalizar = true;
	}
	
	public void removerProduto(int prodId){
		if (finalizar == false){
			for (VendaProduto vendaProduto : listaProduto) {
				if(vendaProduto.getProduto().getId() == prodId){
					listaProduto.remove(vendaProduto);
				} else {
					System.out.println("Produto não encontrado");
				}
			}
		}
	}
	
	public void removerProduto(VendaProduto produto){
		if (finalizar == false) {
			for (VendaProduto vendaProduto : listaProduto) {
				if (vendaProduto == produto){
					listaProduto.remove(vendaProduto);
				} else {
					System.out.println("Produto não encontrado");
				}
			}
		}
	}
	
	public ArrayList<Produto> obterProdutoSimilares(){
		ArrayList<Produto> ListaSimilar = new ArrayList<Produto>();
		for (VendaProduto vendaProduto : listaProduto) {
			if(vendaProduto.getProduto().getProdutoMarca() != null){
				ListaSimilar.add(vendaProduto.getProduto());
			}
		}
		return ListaSimilar;
	}
	
	public void obterProdutosDestaques(Produto prodMaisBarato, Produto prodMaisCaro){
		prodMaisCaro.setPreco(0);
		prodMaisBarato.setPreco(100000);
		for (VendaProduto vendaProduto : listaProduto) {
			if (vendaProduto.getProduto().getPreco() > prodMaisCaro.getPreco()){
				prodMaisCaro = vendaProduto.getProduto();
			}
			if (vendaProduto.getPreco() < prodMaisBarato.getPreco()){
				prodMaisBarato = vendaProduto.getProduto();
			}
		}
		System.out.println("Produto mais caro: " + prodMaisCaro.getNome() + " R$ " + prodMaisCaro.getPreco());
		System.out.println("Produto mais barato: " + prodMaisBarato.getNome() + "R$ " + prodMaisBarato.getPreco());
	}
	
	public void adicionarProduto(Produto produto){
		if (finalizar == false) {
			leia = new Scanner(System.in);
			int quantidade;
			for (VendaProduto vendaProduto : listaProduto) {
				if (produto.getId() == vendaProduto.getProduto().getId()){
					quantidade = vendaProduto.getQuantidade();
					vendaProduto.setQuantidade(quantidade++);
				} else {
					System.out.print("Quantidade do produto: ");
					quantidade = leia.nextInt();
					listaProduto.add(vendaProduto);
					vendaProduto.setQuantidade(quantidade);
				}
			}
		}
	}
	
	public void salvarVendas(Venda venda){
		String escrever;
		escrever = Integer.toString(venda.getCodigo()) + "; " + venda.getData() + "; " + Float.toString(venda.getPrecoTotal()) + "; " + Integer.toString(venda.getCliente().getId()) + "; " +Integer.toString(venda.getFuncionario().getId());
		String nomeArquivo = ("Venda_" + venda.getCodigo() + ".txt");
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
	
	public static ArrayList<Venda> obterVendas() throws IOException{
		ArrayList<Venda> listaVendas = new ArrayList<Venda>();
		FileReader file = new FileReader("C://Users//igorv//Desktop//Igor Veridiano Andrade -1161105457//Produto");
		String linha = null;
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(file);
			while((linha = bufferedReader.readLine()) != ";"){
			}
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			bufferedReader.close();
		}
		return listaVendas;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public float getPrecoTotal() {
		return precoTotal;
	}

	public void setPrecoTotal(float precoTotal) {
		this.precoTotal = precoTotal;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public ArrayList<VendaProduto> getListaProduto() {
		return listaProduto;
	}

	public void setListaProduto(ArrayList<VendaProduto> listaProduto) {
		this.listaProduto = listaProduto;
	}

}
