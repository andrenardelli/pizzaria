package com.pizzaria.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Loja")
@PrimaryKeyJoinColumn(name="login")
public class Loja extends Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name="nm_loja", nullable=false)
	private String nomeLoja;
	
	@Column(name="end_loja", nullable=false)
	private String enderecoLoja;

	public String getNomeLoja() {
		return nomeLoja;
	}

	public void setNomeLoja(String nomeLoja) {
		this.nomeLoja = nomeLoja;
	}

	public String getEnderecoLoja() {
		return enderecoLoja;
	}

	public void setEnderecoLoja(String enderecoLoja) {
		this.enderecoLoja = enderecoLoja;
	}
	
}
