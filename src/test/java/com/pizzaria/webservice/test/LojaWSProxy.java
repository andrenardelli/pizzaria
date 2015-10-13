package com.pizzaria.webservice.test;

import java.rmi.RemoteException;
import java.util.List;

public class LojaWSProxy implements com.pizzaria.webservice.test.LojaWS {
	private String _endpoint = null;
	private com.pizzaria.webservice.test.LojaWS lojaWS = null;

	public LojaWSProxy() {
		_initLojaWSProxy();
	}

	public LojaWSProxy(String endpoint) {
		_endpoint = endpoint;
		_initLojaWSProxy();
	}

	private void _initLojaWSProxy() {
		try {
			lojaWS = (new com.pizzaria.webservice.test.LojaServiceLocator()).getLojaWSPort();
			if (lojaWS != null) {
				if (_endpoint != null)
					((javax.xml.rpc.Stub)lojaWS)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
				else
					_endpoint = (String)((javax.xml.rpc.Stub)lojaWS)._getProperty("javax.xml.rpc.service.endpoint.address");
			}

		}
		catch (javax.xml.rpc.ServiceException serviceException) {}
	}

	public String getEndpoint() {
		return _endpoint;
	}

	public void setEndpoint(String endpoint) {
		_endpoint = endpoint;
		if (lojaWS != null)
			((javax.xml.rpc.Stub)lojaWS)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);

	}

	public com.pizzaria.webservice.test.LojaWS getLojaWS() {
		if (lojaWS == null)
			_initLojaWSProxy();
		return lojaWS;
	}

	public Pedido[] getPedidos() {
		if (lojaWS == null)
			_initLojaWSProxy();
		Pedido[] pedidos = null;
		try {
			pedidos = lojaWS.getPedidos();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pedidos;
	}

	public void finalizarPedido(java.lang.Long idPedido) {
		if (lojaWS == null)
			_initLojaWSProxy();
		try {
			lojaWS.finalizarPedido(idPedido);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}