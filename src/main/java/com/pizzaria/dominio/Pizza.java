package com.pizzaria.dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.pizzaria.dominio.enums.TipoProduto;
import com.pizzaria.excecao.QuantidadeSaborPizzaException;
import com.pizzaria.util.Parametros;

@Entity
@DiscriminatorValue(value=TipoProduto.Values.PIZZA)
public class Pizza extends Produto implements Serializable, Cloneable{

	private static final long serialVersionUID = 1L;

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="Pizza_SaborPizza",
	joinColumns=@JoinColumn(name="id_pizza"),
	inverseJoinColumns=@JoinColumn(name="id_sabor_pizza"))	
	private List<SaborPizza> saboresPizza;

	@Override
	public BigDecimal getValorProduto()
	{
		BigDecimal valorTotal = new BigDecimal(0);
		if (saboresPizza !=null)
		{
			for (SaborPizza saborPizza : saboresPizza) {
				if (valorTotal.compareTo(saborPizza.getValorSaborPizza()) < 0)
				{
					valorTotal = saborPizza.getValorSaborPizza();
				}
			}
		}
		return valorTotal;
	}

	public List<SaborPizza> getSaboresPizza() {
		return saboresPizza;
	}

	public void setSaboresPizza(List<SaborPizza> saboresPizza) {
		this.saboresPizza = saboresPizza;
	}

	public void adicionarSabor(SaborPizza saborPizza) throws QuantidadeSaborPizzaException
	{
		if (saboresPizza == null)
		{
			saboresPizza = new ArrayList<SaborPizza>();
		}
		if (saboresPizza.size() == Parametros.TOTAL_SABORES_POR_PIZZA)
		{
			throw new QuantidadeSaborPizzaException();
		}
		else {
			saboresPizza.add(saborPizza);
		}
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append(getNomeProduto());
		if (saboresPizza !=null)
		{

			for (SaborPizza saborPizza : saboresPizza) {
				sb.append(" - ");
				sb.append(saborPizza.getNomeSaborPizza());
			}
			
		}
		return sb.toString();
	}

}
