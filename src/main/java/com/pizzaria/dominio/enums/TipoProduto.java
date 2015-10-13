package com.pizzaria.dominio.enums;


public enum TipoProduto {

	P(Values.PIZZA), B(Values.BEBIDA), S(Values.SOBREMESA);
	
	private TipoProduto (String val) {
		if (!"P".equals(val)
		 && !"B".equals(val)
		 && !"S".equals(val))
			throw new IllegalArgumentException("Uso incorreto de TipoProduto");
	}

	public static class Values {
		public static final String PIZZA= "P";
		public static final String BEBIDA= "B";
		public static final String SOBREMESA= "S";
	}

}
