package com.pizzaria.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name="Consumidor")
@PrimaryKeyJoinColumn(name="login")
public class Consumidor extends Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	
//	@Id
//	@Column(name="id_consumidor")
//	@GeneratedValue
//	private long idConsumidor;
//	
//	@OneToOne
//	@Column(name="usuario")
//	private Usuario usuario;
	
	@OneToMany(fetch=FetchType.LAZY, targetEntity = Pedido.class, cascade = CascadeType.ALL)
	@JoinColumn(name="login")
	private List<Pedido> pedidos;
	
	@Column(name="nm_consumidor", length=80, nullable=false)
	@NotNull
	private String nomeConsumidor;

	@Column(name="cpf_consumidor", length=11, nullable=false, unique=true)
	@NotNull
	private String CPFConsumidor;

	
//	public long getId() {
//		return idConsumidor;
//	}
//
//	public void setId(long idConsumidor) {
//		this.idConsumidor = idConsumidor;
//	}

	public void adicionarPedido(Pedido pedido)
	{
		pedido.setConsumidor(this);
		if (pedidos == null) {
			pedidos = new ArrayList<Pedido>();
		}
		pedidos.add(pedido);
	}
	
	public String getNomeConsumidor() {
		return nomeConsumidor;
	}

	public void setNomeConsumidor(String nomeConsumidor) {
		this.nomeConsumidor = nomeConsumidor;
	}

	public String getCPFConsumidor() {
		return CPFConsumidor;
	}

	public void setCPFConsumidor(String cPFConsumidor) {
		CPFConsumidor = cPFConsumidor;
	}

	@XmlTransient
	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((CPFConsumidor == null) ? 0 : CPFConsumidor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Consumidor other = (Consumidor) obj;
		if (CPFConsumidor == null) {
			if (other.CPFConsumidor != null)
				return false;
		} else if (!CPFConsumidor.equals(other.CPFConsumidor))
			return false;
		return true;
	}
	
}
