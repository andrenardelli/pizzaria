package com.pizzaria.controlador;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

public class DefaultMB {

	public DefaultMB() {
		super();
	}

	protected static Logger log = Logger.getLogger("Pizzaria - View");

	public void addMessage(String codigoMensagem) {
		String mensagem = identifyMessage(codigoMensagem);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(mensagem)) ;
	}
	
	public String identifyMessage(String codigoMensagem)
	{
		Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
		ResourceBundle bundle = ResourceBundle.getBundle("messages", locale);
		String mensagem = bundle.getString(codigoMensagem);
		return mensagem;
	}

}