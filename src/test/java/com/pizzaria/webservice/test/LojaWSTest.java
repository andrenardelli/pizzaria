package com.pizzaria.webservice.test;

import static org.junit.Assert.assertNotNull;

import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


public class LojaWSTest {

	@Before
	public void setUp() throws Exception {
	}

//	@Ignore("Teste ignorado por exigir servidor de teste")
	@Test
	public void getPedidosWStest() {
		LojaWS lojaWS = new LojaWSProxy().getLojaWS();

		Pedido[] pedidos;

		try {
			pedidos = lojaWS.getPedidos();
			assertNotNull("pedidos nulo!", pedidos);
			for (Pedido pedido : pedidos) {
				System.out.println(pedido.getIdPedido());
				System.out.println(pedido.getConsumidor().getNomeConsumidor());
				for (ItemPedido item : pedido.getItensPedido()) {
					System.out.println(">" + item.getProduto().getNomeProduto());
				}
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

//	@Ignore("Teste ignorado por exigir servidor de teste")
	@Test
	public void finalizarPedidoWSTest() {
		LojaWS lojaWS = new LojaWSProxy().getLojaWS();

		Pedido[] pedidos;

		Long idPedido = null;
		
		try {
			pedidos = lojaWS.getPedidos();
			for (Pedido pedido : pedidos) {
				if (pedido.getDataFechamento() == null) {
					idPedido = pedido.getIdPedido();
				}
			}
			assertNotNull("Id do pedido a finalizar nulo", idPedido);
			lojaWS.finalizarPedido(idPedido);
			pedidos = lojaWS.getPedidos();
			
			Pedido pedido = null;
			for (Pedido _pedido : pedidos) {
				if (idPedido.equals(_pedido.getIdPedido())) {
					pedido = _pedido;
				}
			}
			assertNotNull("Pedido não encontrado apos finalizar",pedido);
			assertNotNull("Pedido não foi finalizado corretamente",pedido.getDataFechamento());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
