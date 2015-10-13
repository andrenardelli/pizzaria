package com.pizzaria.controlador;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pizzaria.dominio.Pedido;
import com.pizzaria.servico.GerenciarPedidoService;
@Component
@ManagedBean
@ViewScoped
public class LojaPizzariaMB extends DefaultMB implements Serializable{

	private static final long serialVersionUID = 1L;

	private List<Pedido> pedidos;
	private Pedido pedido;

	@Autowired
	GerenciarPedidoService gerenciarPedido;

	public void listarPedidos()
	{
		log.info("Início LojaPizzariaMB.listarPedidos");	

		pedidos = gerenciarPedido.recuperarPedidos();

		log.info("Fim LojaPizzariaMB.listarPedidos()");	
	}

	public void finalizarPedido()
	{
		log.info("Início LojaPizzariaMB.finalizarPedido");	

		gerenciarPedido.finalizarPedido(pedido);
		listarPedidos();
		addMessage("loja_pedido_finalizado");

		log.info("Fim LojaPizzariaMB.finalizarPedido");	
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}
	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

}
