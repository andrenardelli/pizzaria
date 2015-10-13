package com.pizzaria.dominio;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="ItemPedido")
public class ItemPedido implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_item_pedido")
	@GeneratedValue
	private Long idItemPedido;
	
	@Column(name="qt_produto")
	@NotNull
	private int qtdeProdutos;
	
	@ManyToOne(cascade=CascadeType.MERGE, optional=false, fetch=FetchType.EAGER)
	@JoinColumn(name="id_produto", nullable=false, unique=false)
	private Produto produto;
	
//	@ManyToOne
//	@JoinColumn(name="id_pedido")
//	private Pedido pedido;
	
	public BigDecimal getPrecoItemPedido()
	{
		BigDecimal preco = new BigDecimal(0);
		if (produto !=null) {
			preco = produto.getValorProduto().multiply(new BigDecimal(qtdeProdutos));
		}
		return preco;
	}

	public Long getIdItemPedido() {
		return idItemPedido;
	}

	public void setIdItemPedido(Long idItemPedido) {
		this.idItemPedido = idItemPedido;
	}

	public int getQtdeProdutos() {
		return qtdeProdutos;
	}

	public void setQtdeProdutos(int qtdeProdutos) {
		this.qtdeProdutos = qtdeProdutos;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public String toString() {
		return "ItemPedido [qtdeProdutos=" + getQtdeProdutos()
				+ ", produto=" + getProduto() + "]";
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idItemPedido == null) ? 0 : idItemPedido.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedido other = (ItemPedido) obj;
		
		if (idItemPedido != null && other.idItemPedido != null
				&& idItemPedido.equals(other.idItemPedido))
		{
			return true;
		}
		
		return false;
	}

}
