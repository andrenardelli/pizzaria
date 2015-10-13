package com.pizzaria.controlador;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pizzaria.dominio.Consumidor;
import com.pizzaria.dominio.Loja;
import com.pizzaria.dominio.Usuario;
import com.pizzaria.excecao.SenhaInvalidaException;
import com.pizzaria.excecao.UsuarioNaoEncontradoException;
import com.pizzaria.servico.AutenticarUsuarioService;
import com.pizzaria.util.Constantes;

@Component
@ManagedBean
@SessionScoped
public class LoginMB extends DefaultMB implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private AutenticarUsuarioService autenticarUsuario;

	private String usuario;
	private String senha;
	
	public LoginMB() {
		try {
			HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
			request.getSession().invalidate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public String sair()
	{
		log.info("Início LoginMB.login()");
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		HttpSession session = request.getSession();
		session.invalidate();
		log.info("Fim LoginMB.sair()");
		return "/publico/login.xhtml?faces-redirect=true";
	}
	
	public String login(){
		log.info("Início LoginMB.login()");
		try {
			Usuario usuarioLogado = autenticarUsuario.autenticarUsuario(usuario, senha);
			if (usuarioLogado !=null){

				HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

				HttpSession session = request.getSession();
				session.setAttribute(Constantes.SESSAO_USUARIO, usuarioLogado); 
				
				String perfil = null;
				
				if (usuarioLogado.getClass().equals(Consumidor.class))
				{
					perfil = Constantes.PERFIL_CONSUMIDOR;
				} else if (usuarioLogado.getClass().equals(Loja.class)) {
					perfil = Constantes.PERFIL_LOJA;
				}				

				session.setAttribute(Constantes.SESSAO_PERFIL, perfil); 
				
				log.info("Fim LoginMB.login() com sucesso!");
				return "/privado/" + perfil + "?faces-redirect=true";
			} else {
				// Pega o locale atual
				super.addMessage("login_erro_autenticacao");

				log.info("Fim LoginMB.login() com excecao!");
			}
			
		} catch (SenhaInvalidaException e) {
			addMessage("login_erro_senha_invalida");
		} catch (UsuarioNaoEncontradoException e) {
			addMessage("login_erro_usuario_nao_encontrado");
		}
		log.info("Fim LoginMB.login() com erro!");
		return "#";
	}

	public String getUsuario() {
		return usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
