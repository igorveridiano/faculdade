package Threads;

public class TesteJoin2 {

	public static void main(String[] args) {
		MinhaInterfaceRunnable thread1 = new MinhaInterfaceRunnable("Thread#1",200);
		MinhaInterfaceRunnable thread2 = new MinhaInterfaceRunnable("Thread#2",300);
		MinhaInterfaceRunnable thread3 = new MinhaInterfaceRunnable("Thread#3",500);
		Thread t1=new Thread(thread1);
		Thread t2=new Thread(thread2);
		Thread t3=new Thread(thread3);
		t1.start();
		try {
			t1.join(1000);
			//espera um tempo de 1 s para continuar a execução
		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t2.start();
		t3.start();
	/*try {
		t1.join();
		t2.join();
		t3.join();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	*/
		//Se eu quisesse liberar o teste só no final
		//o join sem o tempo só libera quando a thread acabar
		System.out.println("Teste");
	}

}
