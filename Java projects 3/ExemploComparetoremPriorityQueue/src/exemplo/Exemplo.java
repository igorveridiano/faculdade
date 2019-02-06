package exemplo;

import java.util.Comparator;

public class Exemplo implements Comparator<Cliente> {
	public int compare(Cliente cli1, Cliente cli2) {
		Cliente cliente1 = (Cliente) cli1;
		Cliente cliente2 = (Cliente) cli2;
		//maior vem primeiro
		if (cliente1.getPrioridade() > cliente2.getPrioridade())
			return -1;
		else
			return +1;
	}
}
