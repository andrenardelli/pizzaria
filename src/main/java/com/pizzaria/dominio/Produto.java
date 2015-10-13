package com.pizzaria.dominio;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.pizzaria.dominio.enums.TipoProduto;

//@MappedSuperclass
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="tp_produto", discriminatorType=DiscriminatorType.STRING)    
@Entity
@Table(name="Produto")
public class Produto implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_produto")
	@GeneratedValue
	protected Long idProduto;
	
	@Column(name = "tp_produto", length=1, nullable = false, insertable = false, updatable = false) 
    @Enumerated(EnumType.STRING)
    private TipoProduto tipoProduto;	
	
    @Column(name = "nm_produto", nullable = false, length=80)
	@NotNull
	private String nomeProduto;
	
	@Column(name = "vl_produto")
	private BigDecimal valorProduto;

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public BigDecimal getValorProduto() {
		return valorProduto;
	}

	public void setValorProduto(BigDecimal valorProduto) {
		this.valorProduto = valorProduto;
	}

	public TipoProduto getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(TipoProduto tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}
	

	@Override
	public String toString() {
		return nomeProduto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idProduto == null) ? 0 : idProduto.hashCode());
		result = prime * result
				+ ((nomeProduto == null) ? 0 : nomeProduto.hashCode());
		result = prime * result
				+ ((tipoProduto == null) ? 0 : tipoProduto.hashCode());
		result = prime * result
				+ ((valorProduto == null) ? 0 : valorProduto.hashCode());
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
		Produto other = (Produto) obj;
		if (idProduto == null) {
			if (other.idProduto != null)
				return false;
		} else if (!idProduto.equals(other.idProduto))
			return false;
		if (nomeProduto == null) {
			if (other.nomeProduto != null)
				return false;
		} else if (!nomeProduto.equals(other.nomeProduto))
			return false;
		if (tipoProduto != other.tipoProduto)
			return false;
		if (valorProduto == null) {
			if (other.valorProduto != null)
				return false;
		} else if (!valorProduto.equals(other.valorProduto))
			return false;
		return true;
	}
	
}
