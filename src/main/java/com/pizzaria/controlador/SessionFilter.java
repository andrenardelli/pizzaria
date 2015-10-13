package com.pizzaria.controlador;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pizzaria.dominio.Usuario;
import com.pizzaria.util.Constantes;

/**
 * Servlet Filter implementation class SSLFilter
 */
@WebFilter(filterName = "SessionFilter", urlPatterns = {"/publico/*","/privado/*"})
public class SessionFilter implements Filter {

	/**
	 * Default constructor. 
	 */
	public SessionFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		Usuario usuario = (Usuario) req.getSession().getAttribute(Constantes.SESSAO_USUARIO);  

		if (req.getRequestURL().toString().indexOf("publico") == -1) {

			if (usuario == null) {  
				res.sendRedirect(req.getContextPath() + "/publico/login.xhtml");
			} else {  

				//Verificar se trata-se de um Consumidor acessando a Loja e vice-versa
				if (Constantes.PERFIL_CONSUMIDOR.equals(req.getSession().getAttribute(Constantes.SESSAO_PERFIL))
						&& req.getRequestURL().toString().indexOf(Constantes.PERFIL_CONSUMIDOR) == -1)
				{
					res.sendRedirect(req.getContextPath() + "/privado/consumidor.xhtml");	
				} else if (Constantes.PERFIL_LOJA.equals(req.getSession().getAttribute(Constantes.SESSAO_PERFIL))
						&& req.getRequestURL().toString().indexOf(Constantes.PERFIL_LOJA) == -1)
				{
					res.sendRedirect(req.getContextPath() + "/privado/loja.xhtml");	
				}
				chain.doFilter(req, res);	
			}  

		} else {
//			if (!req.getRequestURL().toString().startsWith("https")){
//				url = req.getRequestURL().toString().replaceFirst("http", "https").replaceFirst("8080", "8443");
//				res.sendRedirect(url);				  
//			} else {
				chain.doFilter(req, res);	
//			}
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
