package com.pizzaria.webservice;

import org.apache.log4j.Logger;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

public class DefaultWS extends SpringBeanAutowiringSupport{

	protected static Logger log = Logger.getLogger("Pizzaria - WebService");
}
