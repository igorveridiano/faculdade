package Banco;
import java.util.Scanner;
import java.util.Random;
public abstract class Conta {
	private int numero;
	private double saldo;
	private String extrato;
	
	Random random =new Random();
	
	
	Scanner input =new Scanner (System.in);
	public void depositar(){
		System.out.println("Insira o valor a ser depositado");
		this.setSaldo(saldo+input.nextDouble());
		System.out.println("Depositado com Sucesso");
	}
	public void depositar(double valor){
		this.saldo+=valor;
		
	}
	public boolean sacar(){
		System.out.println("Insira o valor a ser sacado");
		double valor =input.nextDouble();
		if (valor>this.getSaldo()) {
			System.out.println("Valor superior ao saldo");
			return false;
		}
		else{
			this.setSaldo(this.getSaldo()-valor);
			return true;
		}
	}
	public boolean sacar(double valor){
		return false;
		
	}
	public boolean transferir(Conta OutraConta){
		System.out.println("Insira o valor a ser transferido");
		double valor =input.nextDouble();
		if(this.sacar(valor)){
			OutraConta.depositar(valor);
			return true;
		}
		return false;
	}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public String getExtrato() {
		return extrato;
	}
	public void setExtrato(String extrato) {
		this.extrato = extrato;
	}
	
}
