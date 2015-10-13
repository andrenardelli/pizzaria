package com.pizzaria.repositorio;

import org.springframework.stereotype.Repository;

import com.pizzaria.dominio.Usuario;
import com.pizzaria.excecao.SenhaInvalidaException;
import com.pizzaria.excecao.UsuarioNaoEncontradoException;

@Repository
public class UsuarioRepo extends DefaultRepository<Usuario, String> {	

	public Usuario getUsuario(String login, String senha) throws UsuarioNaoEncontradoException, SenhaInvalidaException {

		log.info("Início UsuarioRepo.getUsuario(" + login + ")");	
		
		Usuario usuario = getById(Usuario.class, login);

		if(usuario == null)
		{
			log.error("Exception UsuarioRepo.UsuarioNaoEncontradoException");	
			throw new UsuarioNaoEncontradoException();
		}

		if (!senha.equals(usuario.getSenha()))
		{
			log.info("Exception UsuarioRepo.SenhaInvalidaException");	
			throw new SenhaInvalidaException();
		}

		log.info("Fim UsuarioRepo.getUsuario(" + login + ")");	
		return usuario;
	}

}
