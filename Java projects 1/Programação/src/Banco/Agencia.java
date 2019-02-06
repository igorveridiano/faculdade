package Banco;

import java.util.ArrayList;

public class Agencia {
	private int CNPJ;
	private ArrayList<Cliente> Lista_Cliente;
	private ArrayList<Conta> Lista_Conta;	
	public Agencia(int cNPJ) {
		CNPJ = cNPJ;
		Lista_Cliente=new ArrayList<>();
		Lista_Conta=new ArrayList<Conta>();
		
	}
	public int getCNPJ() {
		return CNPJ;
	}
	public void setCNPJ(int cNPJ) {
		CNPJ = cNPJ;
	}
	public ArrayList<Cliente> getLista_Cliente() {
		return Lista_Cliente;
	}
	public void setLista_Cliente(ArrayList<Cliente> lista_Cliente) {
		Lista_Cliente = lista_Cliente;
	}
	public ArrayList<Conta> getLista_Conta() {
		return Lista_Conta;
	}
	public void setLista_Conta(ArrayList<Conta> lista_Conta) {
		Lista_Conta = lista_Conta;
	}
	
	
}
