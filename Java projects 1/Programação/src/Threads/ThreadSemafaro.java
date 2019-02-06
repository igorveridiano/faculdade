package Threads;

public class ThreadSemafaro implements Runnable {
	private CorSemafaro cor;
	private boolean parar;
	private boolean corMudou;

	public ThreadSemafaro() {
		this.cor = CorSemafaro.VERMELHO;
		this.corMudou = false;
		this.parar = false;
		new Thread(this).start();
	}

	public CorSemafaro getCor() {
		return cor;
	}

	@Override
	public void run() {
		while (!parar) {

			try {
				switch (this.cor) {
				case VERMELHO:

					Thread.sleep(4000);
					break;
				case VERDE:

					Thread.sleep(2000);
					break;
				case AMARELO:

					Thread.sleep(800);
					break;

				default:
					break;
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		this.trocaCor();

	}

	synchronized private void trocaCor() {

		switch (this.cor) {
		case VERMELHO:
			this.cor = CorSemafaro.VERDE;

			break;
		case VERDE:
			this.cor = CorSemafaro.AMARELO;
			break;
		case AMARELO:
			this.cor = CorSemafaro.VERMELHO;
			break;

		default:
			break;
		}
		this.corMudou = true;
		notify();

	}

	public synchronized void esperarCorMudar() {
		while (!this.corMudou) {
			try {
				this.wait();
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
	}
}