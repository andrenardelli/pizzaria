package com.pizzaria.dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlTransient;

import com.pizzaria.util.PizzariaUtil;

@Entity
@Table(name="Pedido")
public class Pedido implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_pedido")
	@GeneratedValue
	private Long idPedido;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dta_solicitacao", nullable=false)
	private Date dataSolicitacao;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dta_fechamento", nullable=true)
	private Date dataFechamento;
	
	@OneToMany(fetch=FetchType.EAGER, targetEntity = ItemPedido.class, cascade = CascadeType.ALL)
	@JoinColumn(name="id_pedido")
	List<ItemPedido> itensPedido;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="login")
	private Consumidor consumidor;	
	
	public BigDecimal getValorTotal()
	{
		BigDecimal valorTotal = new BigDecimal(0);
		if (itensPedido !=null)
		{
			for (ItemPedido itemPedido : itensPedido) {
				valorTotal = valorTotal.add(itemPedido.getPrecoItemPedido());
			}
		}
		return valorTotal.add(PizzariaUtil.get10Porcento(valorTotal));
	}
	
	public void adicionarItemPedido(ItemPedido itemPedido)
	{
		if (itensPedido == null) {
			itensPedido = new ArrayList<ItemPedido>();
		}
		itensPedido.add(itemPedido);
	}

	public List<ItemPedido> getItensPedido() {
		return itensPedido;
	}

	public void setItensPedido(List<ItemPedido> itensPedido) {
		this.itensPedido = itensPedido;
	}

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	@Override
	public String toString() {
		return "Pedido [idPedido=" + getIdPedido() + ", itensPedido=" + getItensPedido()
				+ "]";
	}

	public Date getDataSolicitacao() {
		return dataSolicitacao;
	}

	public void setDataSolicitacao(Date dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}

	public Date getDataFechamento() {
		return dataFechamento;
	}

	public void setDataFechamento(Date dataFechamento) {
		this.dataFechamento = dataFechamento;
	}

	public Consumidor getConsumidor() {
		return consumidor;
	}

	public void setConsumidor(Consumidor consumidor) {
		this.consumidor = consumidor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((consumidor == null) ? 0 : consumidor.hashCode());
		result = prime * result
				+ ((dataSolicitacao == null) ? 0 : dataSolicitacao.hashCode());
		result = prime * result
				+ ((idPedido == null) ? 0 : idPedido.hashCode());
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
		Pedido other = (Pedido) obj;
		if (consumidor == null) {
			if (other.consumidor != null)
				return false;
		} else if (!consumidor.equals(other.consumidor))
			return false;
		if (dataSolicitacao == null) {
			if (other.dataSolicitacao != null)
				return false;
		} else if (!dataSolicitacao.equals(other.dataSolicitacao))
			return false;
		if (idPedido == null) {
			if (other.idPedido != null)
				return false;
		} else if (!idPedido.equals(other.idPedido))
			return false;
		return true;
	}
	
}
