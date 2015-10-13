package com.pizzaria.dominio;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="SaborPizza")
public class SaborPizza implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_sabor_pizza")
	@GeneratedValue
	private Long idSaborPizza;
	
	@Column(name="nm_sabor_pizza", length=80, nullable = false, unique=true )
	@NotNull
	private String nomeSaborPizza;	

	@Column(name="vl_sabor_pizza", nullable=false, scale=2)
	@NotNull
	private BigDecimal valorSaborPizza;

	public Long getIdSaborPizza() {
		return idSaborPizza;
	}

	public void setIdSaborPizza(Long idSaborPizza) {
		this.idSaborPizza = idSaborPizza;
	}
	
	public String getNomeSaborPizza() {
		return nomeSaborPizza;
	}

	public void setNomeSaborPizza(String nomeSaborPizza) {
		this.nomeSaborPizza = nomeSaborPizza;
	}

	public BigDecimal getValorSaborPizza() {
		return valorSaborPizza;
	}

	public void setValorSaborPizza(BigDecimal valorSaborPizza) {
		this.valorSaborPizza = valorSaborPizza;
	}	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getNomeSaborPizza();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idSaborPizza == null) ? 0 : idSaborPizza.hashCode());
		result = prime * result
				+ ((nomeSaborPizza == null) ? 0 : nomeSaborPizza.hashCode());
		result = prime * result
				+ ((valorSaborPizza == null) ? 0 : valorSaborPizza.hashCode());
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
		SaborPizza other = (SaborPizza) obj;
		if (idSaborPizza == null) {
			if (other.idSaborPizza != null)
				return false;
		} else if (!idSaborPizza.equals(other.idSaborPizza))
			return false;
		if (nomeSaborPizza == null) {
			if (other.nomeSaborPizza != null)
				return false;
		} else if (!nomeSaborPizza.equals(other.nomeSaborPizza))
			return false;
		if (valorSaborPizza == null) {
			if (other.valorSaborPizza != null)
				return false;
		} else if (!valorSaborPizza.equals(other.valorSaborPizza))
			return false;
		return true;
	}
	
}
