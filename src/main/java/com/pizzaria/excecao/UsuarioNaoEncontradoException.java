package com.pizzaria.excecao;

public class UsuarioNaoEncontradoException extends Exception{

	private static final long serialVersionUID = 1L;

	public UsuarioNaoEncontradoException(){  
		super("Usuario nao encontrado!");  
	}  
}
