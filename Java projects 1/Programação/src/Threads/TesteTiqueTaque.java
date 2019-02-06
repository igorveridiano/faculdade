package Threads;

public class TesteTiqueTaque {
	public static void main(String[]args){
		TiqueTaque tt = new TiqueTaque();
		ThreadTiqueTaque tique = new ThreadTiqueTaque("Tique",tt);
		ThreadTiqueTaque taque = new ThreadTiqueTaque("Taque",tt);
		try {
			tique.t.join();
			taque.t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}	
