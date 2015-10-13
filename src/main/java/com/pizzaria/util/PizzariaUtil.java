package com.pizzaria.util;

import java.math.BigDecimal;

public class PizzariaUtil {

	
	public static BigDecimal get10Porcento(BigDecimal valorTotal)
	{
		return valorTotal.multiply(new BigDecimal(0.10));
	}
}
