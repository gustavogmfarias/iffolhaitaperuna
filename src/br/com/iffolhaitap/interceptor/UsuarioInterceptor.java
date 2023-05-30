package br.com.iffolhaitap.interceptor;

import java.util.Arrays;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.servlet.http.HttpServletRequest;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.iffolhaitap.annotation.Privado;
import br.com.iffolhaitap.controller.IndexController;
import br.com.iffolhaitap.controller.LoginController;
import br.com.iffolhaitap.model.Perfil;
import br.com.iffolhaitap.util.Sessao;


@Entity
@RequestScoped @Intercepts
public class UsuarioInterceptor implements Interceptor {
	
	@ManyToOne
	@Inject private Sessao sessao;
	@Inject private Result result;
	@Inject private HttpServletRequest request;
	
	@Override
	public void intercept(InterceptorStack stack, ControllerMethod method, Object controllerInstance)
			throws InterceptionException {
		String urlDeContinuacao = request.getRequestURL().toString();
		
		if(method.containsAnnotation(Privado.class)) {
			if(sessao.getUsuario() == null ) {
				sessao.setUrlContinuacao(urlDeContinuacao);
				result.include("error", "Voc� precisa efetuar o login");
				result.redirectTo(LoginController.class).login();
				return;
			}
			Perfil[] perfis = method.getMethod().getAnnotation(Privado.class).value();
			if(perfis != null && perfis.length > 0) {
				boolean podeAcessar = Arrays.asList(perfis).contains(sessao.getUsuario().getPerfil());
				if(!podeAcessar) {
					
					sessao.limparUrlDeContinuacao();
					result.include("error", "Voc� n�o tem permiss�o para acessar essa url");
					result.redirectTo(IndexController.class).inicio();
					
				}
			} 
		} 
		
		
		
		sessao.limparUrlDeContinuacao();
		stack.next(method, controllerInstance);
	}

	@Override
	public boolean accepts(ControllerMethod method) {
		
		if(method.getController().getType().equals(LoginController.class))
			return false;
		
		return true;
	}

	
	
	
}
