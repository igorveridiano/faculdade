package Threads;

public class TesteIsAlive {
	public static void main(String[] args){
	
	
	MinhaInterfaceRunnable thread1 = new MinhaInterfaceRunnable("Thread#1",200);
	MinhaInterfaceRunnable thread2 = new MinhaInterfaceRunnable("Thread#2",300);
	MinhaInterfaceRunnable thread3 = new MinhaInterfaceRunnable("Thread#3",500);
	Thread t1=new Thread(thread1);
	Thread t2=new Thread(thread2);
	Thread t3=new Thread(thread3);
	t1.start();
	t2.start();
	t3.start();
	while(t1.isAlive()||t2.isAlive()||t3.isAlive()){
	//espera para só sair quando todas as threads se encerrarem	
	}
	System.out.println("Acabou :)");
	}
}
