package Threads;

public class Thread1 extends Thread {
	private String nome;
	private int tempo;
	public Thread1(String nome,int tempo) {
		this.nome = nome;
		this.tempo=tempo;
		start();
	}
	public void run(){
		for (int i = 0; i < 6; i++) {
			System.out.println(nome+"  contador  "+ i);
			try {
				Thread.sleep(tempo);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.getMessage();
				e.printStackTrace();
			}
			
		}
		System.out.println(nome+ "  acabou a execução");
	}
}
 