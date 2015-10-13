package com.pizzaria.webservice.test;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import org.apache.axis.AxisFault;

import com.pizzaria.webservice.test.LojaWS;

public class LojaWsTestMain {

public LojaWS lojaWS;
	
	public static void main(String[] args) throws ServiceException, AxisFault {
		LojaWS lojaWS = new LojaWSProxy().getLojaWS();
		
		Pedido[] pedidos;
		try {
			pedidos = lojaWS.getPedidos();
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
}
