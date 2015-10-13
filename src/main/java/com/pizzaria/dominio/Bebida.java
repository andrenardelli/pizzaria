package com.pizzaria.dominio;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.pizzaria.dominio.enums.TipoProduto;

@Entity
@DiscriminatorValue(value=TipoProduto.Values.BEBIDA)
public class Bebida extends Produto implements Serializable{

	private static final long serialVersionUID = 1L;

}
