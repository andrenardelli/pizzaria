package com.pizzaria.servico.test;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pizzaria.dominio.Usuario;
import com.pizzaria.excecao.SenhaInvalidaException;
import com.pizzaria.excecao.UsuarioNaoEncontradoException;
import com.pizzaria.servico.AutenticarUsuarioService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContextTest.xml")
public class AutenticarUsuarioServiceTest {

	@Autowired
	AutenticarUsuarioService service;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void autenticarUsuarioTest() {
		try {
			Usuario user = service.autenticarUsuario("loja", "123");
			assertNotNull("usuario nulo",user);
		} catch (SenhaInvalidaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UsuarioNaoEncontradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
