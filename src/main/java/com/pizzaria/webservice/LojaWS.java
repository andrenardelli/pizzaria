package com.pizzaria.webservice;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import com.pizzaria.dominio.Pedido;
import com.pizzaria.servico.GerenciarPedidoService;

@WebService(serviceName="lojaService")
public class LojaWS extends DefaultWS{
	
	@Autowired
	GerenciarPedidoService gerenciarPedidoService;

	@WebMethod
	public List<Pedido> getPedidos()
	{
		log.info("Início LojaWS.getPedidos()");	
		
		List<Pedido> pedidos = null;
		pedidos = gerenciarPedidoService.recuperarPedidos();
		
		log.info("Fim LojaWS.getPedidos()");	
		return pedidos;
	}
	
	@WebMethod
	public void finalizarPedido(Long idPedido)
	{
		log.info("Início LojaWS.finalizarPedido(" + idPedido + ")");
		
		gerenciarPedidoService.finalizarPedido(idPedido);

		log.info("Início LojaWS.finalizarPedido(" + idPedido + ")");
	}
	
}
