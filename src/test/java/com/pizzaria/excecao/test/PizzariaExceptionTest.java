package com.pizzaria.excecao.test;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pizzaria.dominio.Pizza;
import com.pizzaria.dominio.SaborPizza;
import com.pizzaria.dominio.enums.TipoProduto;
import com.pizzaria.excecao.QuantidadeSaborPizzaException;
import com.pizzaria.excecao.SenhaInvalidaException;
import com.pizzaria.excecao.UsuarioNaoEncontradoException;
import com.pizzaria.repositorio.UsuarioRepo;
import com.pizzaria.servico.GerenciarPedidoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContextTest.xml")
public class PizzariaExceptionTest {

	@Autowired
	GerenciarPedidoService service;	

	@Autowired
	UsuarioRepo usuarioRepo;

	
	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test(expected = QuantidadeSaborPizzaException.class)
	public void maximoSaboresExcedidoExceptionTest() throws QuantidadeSaborPizzaException {
		
		Pizza pizza = new Pizza();
		pizza.setNomeProduto("Pizza");
		pizza.setTipoProduto(TipoProduto.P);		


		List<SaborPizza> saboresPizza = service.recuperarSaboresPizza();

		pizza.adicionarSabor(saboresPizza.get(0));
		pizza.adicionarSabor(saboresPizza.get(1));
		pizza.adicionarSabor(saboresPizza.get(2));
		pizza.adicionarSabor(saboresPizza.get(3));
		
		pizza.adicionarSabor(saboresPizza.get(4));
	}
	
	@Test(expected = UsuarioNaoEncontradoException.class)
	public void usuarioNaoEncontradoExceptionTest() throws SenhaInvalidaException, UsuarioNaoEncontradoException {
		usuarioRepo.getUsuario("loja_", "123");
	}
	
	@Test(expected = SenhaInvalidaException.class)
	public void senhaInvalidaExceptionTest() throws SenhaInvalidaException, UsuarioNaoEncontradoException {
		usuarioRepo.getUsuario("loja", "1234");
	}
	
}
