package com.pizzaria.servico;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pizzaria.dominio.Bebida;
import com.pizzaria.dominio.Pedido;
import com.pizzaria.dominio.Produto;
import com.pizzaria.dominio.SaborPizza;
import com.pizzaria.dominio.Sobremesa;
import com.pizzaria.dominio.enums.TipoProduto;
import com.pizzaria.repositorio.PedidoRepo;
import com.pizzaria.repositorio.ProdutoRepo;
import com.pizzaria.repositorio.SaborPizzaRepo;

@Service
public class GerenciarPedidoService extends DefaultService{	

	@Autowired
	PedidoRepo pedidoRepo;
	
	@Autowired
	ProdutoRepo produtoRepo;
	
	@Autowired
	SaborPizzaRepo saborPizzaRepo;

	public List<Produto> recuperarProdutos(TipoProduto tipoProduto)
	{
		log.info("Início GerenciarPedidoService.recuperarProdutos(" + tipoProduto + ")");	
		List<Produto> produtos = null;
		
		if (TipoProduto.B.equals(tipoProduto)) {
			produtos = produtoRepo.listar(Bebida.class);
		} else if (TipoProduto.S.equals(tipoProduto)) {
			produtos = produtoRepo.listar(Sobremesa.class);
		}

		log.info("Fim GerenciarPedidoService.recuperarProdutos(" + tipoProduto + ")");	
		return produtos;
	}

	public List<SaborPizza> recuperarSaboresPizza()
	{
		log.info("Início GerenciarPedidoService.recuperarSaboresPizza()");	
		return saborPizzaRepo.listar(SaborPizza.class);
	}

	@Transactional
	public boolean finalizarPedido(Long idPedido)
	{
		log.info("Início GerenciarPedidoService.finalizarPedido(" + idPedido + ")");	
		
		Pedido pedido = pedidoRepo.getById(Pedido.class, idPedido);
		if (pedido == null) {
			log.error("Pedido de id " + idPedido + " não encontrado!");	
			return false;
		}
		finalizarPedido(pedido);

		log.info("Fim GerenciarPedidoService.finalizarPedido(" + idPedido + ")");	
		return true;
	}

	@Transactional
	public void finalizarPedido(Pedido pedido)
	{
		log.info("Início GerenciarPedidoService.finalizarPedido(" + pedido + ")");
		
		pedido.setDataFechamento(new Date());
		pedidoRepo.save(pedido);
		
		log.info("Fim GerenciarPedidoService.finalizarPedido(" + pedido + ")");
	}
	
	public List<Pedido> recuperarPedidos()
	{
		return pedidoRepo.listar(Pedido.class);
	}
	
	@Transactional
	public void incluirPedido(Pedido pedido)
	{
		
		pedidoRepo.save(pedido);
		
	}
	
}
