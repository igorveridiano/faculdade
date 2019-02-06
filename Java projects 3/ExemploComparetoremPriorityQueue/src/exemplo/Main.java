package exemplo;

import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) {
		PriorityQueue<Cliente> queue = new PriorityQueue<Cliente>(new Exemplo());
		Cliente cli2 = new Cliente("Joao", 1);
		Cliente cli1 = new Cliente("Thiago", 2);
		queue.offer(cli2);
		queue.offer(cli1);
		while (queue.size() > 0) {
			System.out.println("Topo: " + queue.peek().getNome());
			queue.poll();
		}
	}
}
