package companhiaAerea;

import listaDuplamenteEncadeada.ListaDuplamenteEncadeada;

public class Clientes {
	
	ListaDuplamenteEncadeada<Cliente> listaClientes;
	
	public Clientes() {
		listaClientes = new ListaDuplamenteEncadeada<>();
	}

	public boolean CadastrarCliente(Cliente cliente){
		if(listaClientes.tamanho() == 0){
			listaClientes.adicionar(cliente);
			return true;
		} else {
			for (Cliente clienteAux : listaClientes) {
				if (clienteAux.getCpf().equals(cliente.getCpf())){
					return false;
				} else {
					listaClientes.adicionar(cliente);
					return true;
				}
			}
		}
		return false;
	}
}
