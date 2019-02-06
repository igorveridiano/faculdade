package Threads;

public class ThreadResumeStopSuspend implements Runnable {
	String nome;
	boolean estaSuspenso;
	boolean foiTerminada;

	public ThreadResumeStopSuspend(String nome) {
		this.nome = nome;
		estaSuspenso = false;
		foiTerminada = false;
		Thread t = new Thread(this, nome);
		t.start();
	}

	@Override
	public void run() {
		System.out.println(nome + " executando");
		try {
			for (int i = 0; i < 10; i++) {
				System.out.println(nome + "Tem valor " + i);
				Thread.sleep(300);
				synchronized (this) {
					while(estaSuspenso){
						wait();
					}
					if (foiTerminada) {
						break;
					}

				}
				}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(nome + " finalizada");

	}

	 void suspend() {
		this.estaSuspenso=true;
		
		
		
	}
	 synchronized void resume(){
		 this.estaSuspenso=false;
		 notify();
		
		 
	 }
	 synchronized void stop(){
		 this.foiTerminada=true;
		 notify();
	 }
}
