package com.pizzaria.excecao;

public class PizzariaException extends Exception{

	private static final long serialVersionUID = 1L;
	
	private String msg;  
	
    public PizzariaException(String msg){  
      super(msg);  
      this.msg = msg;  
    }  
    public String getMessage(){  
      return msg;  
    }  
}
