package siteFilaDePedidos;

import fila.FilaVetor;

public class Pedidos {
	
	FilaVetor<Pedido> filaDePedidos;
	
	public Pedidos(){
		filaDePedidos = new FilaVetor<>();
	}
	
	public void EfetuarPedido (Pedido pedido){
		filaDePedidos.enfileirar(pedido);
	}
	
	public void DespacharPedido (){
		if(filaDePedidos.vazia() == false){
			System.out.println("O pedido do cliente " + filaDePedidos.desenfileirar().getCliente().getNome() + " foi despachado");
		} else {
			System.out.println("Não há pedidos");
		}
	}
	
	public void ExibirFilaDePedidos (){
		if (filaDePedidos.vazia() == false){
			for (Pedido pedido : filaDePedidos) {
				System.out.println("Pedido do cliente: " + pedido.getCliente().getNome());
				System.out.println("Valor total do pedido: " + pedido.getValorTotalDaCompra());
			}
		} else {
			System.out.println("Não há pedidos");
		}
	}

}
