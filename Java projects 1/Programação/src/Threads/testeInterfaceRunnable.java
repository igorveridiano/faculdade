package Threads;

public class testeInterfaceRunnable {

	public static void main(String[] args) {
		ThreadInterface thread1 =new ThreadInterface("Thread #1", 500);
		//Thread t =new Thread(thread1);
		//t.start();
		ThreadInterface thread2 =new ThreadInterface("Thread #2", 200);
		ThreadInterface thread3 =new ThreadInterface("Thread #3", 1000);
	}

}
