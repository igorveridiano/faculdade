package Threads;

public class TiqueTaque {
	boolean tique;
	boolean taque;

	synchronized void tique(boolean estaExecutando) {
		if (!estaExecutando) {
			tique = true;
			notify();
			return;
		}
		System.out.print(" Tique ");
		tique = true;
		notify();
		try {
			while (tique) {
				tique = false;

				wait();

			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	synchronized void taque(boolean estaExecutando) {
		if (!estaExecutando) {
			taque = true;
			notify();
			return;
		}
		System.out.println(" Taque ");
		taque = true;
		notify();
		try {
			while (taque) {
				taque = false;

				wait();

			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
