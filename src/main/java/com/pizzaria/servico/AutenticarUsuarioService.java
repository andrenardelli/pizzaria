package com.pizzaria.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pizzaria.dominio.Usuario;
import com.pizzaria.excecao.SenhaInvalidaException;
import com.pizzaria.excecao.UsuarioNaoEncontradoException;
import com.pizzaria.repositorio.UsuarioRepo;

@Service
public class AutenticarUsuarioService extends DefaultService {		

	@Autowired
	UsuarioRepo usuarioRepo;

	public Usuario autenticarUsuario(String usuario, String senha) throws SenhaInvalidaException, UsuarioNaoEncontradoException{
		log.info("Início AutenticarUsuario.autenticarUsuario()");	
		return usuarioRepo.getUsuario(usuario, senha);		
	}
	
}
