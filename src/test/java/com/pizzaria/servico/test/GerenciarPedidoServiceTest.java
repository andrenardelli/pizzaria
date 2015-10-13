package com.pizzaria.servico.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pizzaria.dominio.Consumidor;
import com.pizzaria.dominio.ItemPedido;
import com.pizzaria.dominio.Pedido;
import com.pizzaria.dominio.Produto;
import com.pizzaria.dominio.SaborPizza;
import com.pizzaria.dominio.enums.TipoProduto;
import com.pizzaria.repositorio.PedidoRepo;
import com.pizzaria.repositorio.ProdutoRepo;
import com.pizzaria.servico.GerenciarPedidoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContextTest.xml")
public class GerenciarPedidoServiceTest {

	@Autowired
	GerenciarPedidoService service;	

	@Autowired
	PedidoRepo pedidoRepo;	

	@Autowired
	ProdutoRepo produtoRepo;
	
	Pedido pedido;
	Pedido pedidoIncluir;
	
	@Before
	public void setUp() throws Exception {
		pedido = pedidoRepo.getById(Pedido.class, 2l);
		pedidoIncluir = new Pedido();
		
		Consumidor consumidor = new Consumidor();
		consumidor.setLogin("consumidor");
		consumidor.setCPFConsumidor("22222222222");
		consumidor.setNomeConsumidor("Nardelli");
		consumidor.setSenha("123");
		
		pedidoIncluir.setConsumidor(consumidor);
		
		Produto produto = produtoRepo.getById(Produto.class, 1l);
		
		ItemPedido itemPedido = new ItemPedido();
		itemPedido.setProduto(produto);
		itemPedido.setQtdeProdutos(2);
		
		pedidoIncluir.adicionarItemPedido(itemPedido);
		pedidoIncluir.setDataSolicitacao(new Date());
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void recuperarProdutosTest() {
		List<Produto> produtos = service.recuperarProdutos(TipoProduto.S);
		assertNotNull("Não foi possível recuperar os produtos!", produtos);
	}
	
	@Test
	public void recuperarSaboresPizzaTest() {
		List<SaborPizza> sabores = service.recuperarSaboresPizza();
		assertNotNull("Não foi possível recuperar os sabores de pizza!", sabores);
	}

	@Test
	public void finalizarPedidoIdPedidoTest() {
		assertTrue("Não foi possível finalizar o pedido pelo ID!",service.finalizarPedido(2l));
	}

	@Test
	public void finalizarPedidoPedidoTest() {
		service.finalizarPedido(pedido);
		assertNotNull("Não foi possível finalizar o pedido pelo objeto pedido!",pedido.getDataFechamento());
	}

	@Test
	public void recuperarPedidosTest() {
		List<Pedido> pedidos = service.recuperarPedidos();
		assertNotNull("Não foi possível recuperar os pedidos!",pedidos);
	}

	@Test
	public void incluirPedidoTest() {
		service.incluirPedido(pedidoIncluir);
		Pedido pedidoIncluido = pedidoRepo.getById(Pedido.class, 1l);
		assertNotNull("Não foi possível incluir o pedido!",pedidoIncluido);
	}

}
