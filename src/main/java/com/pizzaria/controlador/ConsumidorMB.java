package com.pizzaria.controlador;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pizzaria.dominio.Consumidor;
import com.pizzaria.dominio.ItemPedido;
import com.pizzaria.dominio.Pedido;
import com.pizzaria.dominio.Pizza;
import com.pizzaria.dominio.Produto;
import com.pizzaria.dominio.SaborPizza;
import com.pizzaria.dominio.enums.TipoProduto;
import com.pizzaria.excecao.QuantidadeSaborPizzaException;
import com.pizzaria.servico.GerenciarPedidoService;

@Component
@ManagedBean
@ViewScoped
public class ConsumidorMB extends DefaultMB {

	//private Pizza pizza;
	private Pedido pedido;
	private Produto produto;
	private Pizza pizza;
	private TipoProduto tipoProduto;
	private List<SaborPizza> saboresPizza;
	private List<Produto> produtos;
	private ItemPedido itemPedido;
	
	private String tituloProduto;

	@Autowired
	private GerenciarPedidoService gerenciarPedido;

	@PostConstruct
	public void init()
	{
		log.info("Início ConsumidorMB.init()");	
		
		setSaboresPizza();
		produto=null;
		pizza=null;
		
		log.info("Fim ConsumidorMB.init()");	
	}

	//	public List<Produto> getProdutos()
	//	{
	//		return gerenciarPedido.recuperarProdutos();		
	//	}

	public void setSaboresPizza()
	{
		log.info("Início ConsumidorMB.setSaboresPizza()");	
		
		saboresPizza = gerenciarPedido.recuperarSaboresPizza();		
		
		log.info("Fim ConsumidorMB.setSaboresPizza()");	
	}

	public void adicionarSaborASuaPizza(SaborPizza saborPizza)
	{
		log.info("Início ConsumidorMB.adicionarSaborASuaPizza()");	
		
		if (pizza == null)
		{
			criarPizza();
		}
		try {
			pizza.adicionarSabor(saborPizza);
		} catch (QuantidadeSaborPizzaException e) {
			addMessage("consumidor_erro_qtde_sabor_invalida");
		}
		
		log.info("Fim ConsumidorMB.adicionarSaborASuaPizza()");	
	}
	
	public void adicionarProduto(Produto _produto)
	{
		log.info("Início ConsumidorMB.adicionarProduto(" + _produto + ")");	
		
		if (produto != null)
		{
			addMessage("consumidor_um_produto_vez");
		}
		else
		{
			produto = _produto;
			itemPedido = new ItemPedido();
			itemPedido.setProduto(produto);
		}
		
		log.info("Fim ConsumidorMB.adicionarProduto(" + _produto + ")");	
	}

	public void criarPizza()
	{
		log.info("Início ConsumidorMB.criarPizza()");	
		
		pizza = new Pizza();
		pizza.setNomeProduto("Pizza");
		pizza.setTipoProduto(TipoProduto.P);
		
		log.info("Fim ConsumidorMB.criarPizza()");	
	}

	public void criarProduto(TipoProduto _tipoProduto)
	{
		log.info("Início ConsumidorMB.criarProduto(" + _tipoProduto + ")");	
		
		produto=null;
		tipoProduto = _tipoProduto;
		setTituloTipoProduto();
		setProdutos();		

		log.info("Fim ConsumidorMB.criarProduto(" + _tipoProduto + ")");	
	}

	public void setTituloTipoProduto()
	{
		log.info("Início ConsumidorMB.setTituloTipoProduto()");	
		
		if (tipoProduto != null)
		{
			if(TipoProduto.B.equals(tipoProduto))
			{
				tituloProduto = identifyMessage("consumidor_bebida");
			} else if (TipoProduto.S.equals(tipoProduto)) {
				tituloProduto = identifyMessage("consumidor_sobremesa");
			}
		}
		
		log.info("Fim ConsumidorMB.setTituloTipoProduto()");	
	}
	
	public void setProdutos()
	{
		log.info("Início ConsumidorMB.setProdutos()");	
		
		if (tipoProduto !=null)
		{
			produtos = gerenciarPedido.recuperarProdutos(tipoProduto);	
		}			

		log.info("Fim ConsumidorMB.setProdutos()");	
	}

	public TipoProduto getTipoProduto()
	{
		log.info("Início ConsumidorMB.getTipoProduto()");	
		
		TipoProduto tipoProduto = null;
		
		if (produto != null)
		{
			tipoProduto = produto.getTipoProduto();
		}

		log.info("Fim ConsumidorMB.getTipoProduto()");	
		return tipoProduto;
	}

	public void cancelarProduto()
	{
		log.info("Início ConsumidorMB.cancelarProduto()");	
		
		produto=null;
		pizza=null;
		itemPedido=null;

		log.info("Fim ConsumidorMB.cancelarProduto()");	
	}

	public void confirmarProduto()
	{
		log.info("Início ConsumidorMB.confirmarProduto()");	
		
		if (pedido == null)
		{
			pedido = new Pedido();
		}
		pedido.adicionarItemPedido(itemPedido);
		pizza = null;
		produto = null;
		itemPedido = null;
		
		log.info("Fim ConsumidorMB.confirmarProduto()");	
	}

	public void confirmarPizza()
	{
		log.info("Início ConsumidorMB.confirmarPizza()");	
		
		if (pedido == null)
		{
			pedido = new Pedido();
		}
		ItemPedido itemPedidoPizza = new ItemPedido();
		itemPedidoPizza.setProduto(pizza);
		itemPedidoPizza.setQtdeProdutos(1);
		pedido.adicionarItemPedido(itemPedidoPizza);
		pizza = null;
		produto = null;
		itemPedido = null;

		log.info("Fim ConsumidorMB.confirmarPizza()");	
	}

	public void confirmarPedido()
	{
		log.info("Início ConsumidorMB.confirmarPedido()");	
		
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		HttpSession session = request.getSession();
		Consumidor consumidor = (Consumidor) session.getAttribute("usuario");

		pedido.setDataSolicitacao(new Date());
		pedido.setConsumidor(consumidor);

		gerenciarPedido.incluirPedido(pedido);
		addMessage("consumidor_pedido_solicitado");
		pedido = null;

		log.info("Fim ConsumidorMB.confirmarPedido()");	
	}

	public void cancelarPedido()
	{
		log.info("Início ConsumidorMB.cancelarPedido()");	
		
		pedido = null;

		log.info("Fim ConsumidorMB.cancelarPedido()");	
	}

	public void removerSaborDeSuaPizza(SaborPizza saborPizza)
	{
		log.info("Início ConsumidorMB.removerSaborDeSuaPizza(" + saborPizza + ")");	
	
		pizza.getSaboresPizza().remove(saborPizza);

		log.info("Fim ConsumidorMB.removerSaborDeSuaPizza(" + saborPizza + ")");	
	}

	public void removerItemPedido(ItemPedido itemPedido)
	{
		log.info("Início ConsumidorMB.removerItemPedido(" + itemPedido + ")");	
		
		pedido.getItensPedido().remove(itemPedido);

		log.info("Fim ConsumidorMB.removerItemPedido(" + itemPedido + ")");	
	}

	public void removerProduto()
	{
		log.info("Início ConsumidorMB.removerProduto()");	
		
		pizza=null;
		produto=null;
		
		log.info("Fim ConsumidorMB.removerProduto()");	
	}

	//Getters e Setters
	//	public Pizza getPizza() {
	//		return pizza;
	//	}
	//
	//	public void setPizza(Pizza pizza) {
	//		this.pizza = pizza;
	//	}

	public List<SaborPizza> getSaboresPizza() {
		return saboresPizza;
	}

	public void setSaboresPizza(List<SaborPizza> saboresPizza) {
		this.saboresPizza = saboresPizza;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public void setTipoProduto(TipoProduto tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public String getTituloProduto() {
		return tituloProduto;
	}

	public void setTituloProduto(String tituloProduto) {
		this.tituloProduto = tituloProduto;
	}

	public ItemPedido getItemPedido() {
		return itemPedido;
	}

	public void setItemPedido(ItemPedido itemPedido) {
		this.itemPedido = itemPedido;
	}

	public Pizza getPizza() {
		return pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}

}
