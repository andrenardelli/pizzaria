package com.pizzaria.excecao;

public class SenhaInvalidaException extends PizzariaException{
	
	private static final long serialVersionUID = 1L;

	public SenhaInvalidaException(){  
		super("Senha invalida!");  
	}  
}
