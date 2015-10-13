package com.pizzaria.excecao;

import com.pizzaria.util.Parametros;

public class QuantidadeSaborPizzaException extends PizzariaException{
	
	private static final long serialVersionUID = 1L;

	public QuantidadeSaborPizzaException(){  
		super("A quantidade de sabores de pizza não pode ultrapassar " + Parametros.TOTAL_SABORES_POR_PIZZA + "!");  
	}  
}
