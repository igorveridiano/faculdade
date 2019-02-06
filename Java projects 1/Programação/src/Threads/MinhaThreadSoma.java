package Threads;

public class MinhaThreadSoma implements Runnable {
	private String nome;
	private int[] nums;
	private static Calculadora calc =new Calculadora();
	public MinhaThreadSoma(String nome,int[]nums){
		this.nome=nome;
		this.nums=nums;
		new Thread(this,nome).start();
		//Thread t =new Thread(this,nome);
		//t.start();
		
	}
	@Override
	public void run() {
		System.out.println(this.nome + " iniciada");
		int soma =calc.SomaArray(this.nums);
		System.out.println("O resultado da soma é :"+ soma);
		System.out.println(this.nome + " encerrada");
		

	}
}
