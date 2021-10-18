package br.com.iffolhaitap.interceptor;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.iffolhaitap.controller.LoginController;
import br.com.iffolhaitap.util.Sessao;


@RequestScoped @Intercepts
public class UsuarioInterceptor implements Interceptor {
	
	@Inject private Sessao sessao;
	@Inject private Result result;
	@Inject private HttpServletRequest request;
	
	@Override
	public void intercept(InterceptorStack stack, ControllerMethod method, Object controllerInstance)
			throws InterceptionException {
		String urlDeContinuacao = request.getRequestURL().toString();
		
		if(sessao.getUsuario() == null ) {
			sessao.setUrlContinuacao(urlDeContinuacao);
			result.include("error", "Você precisa efetuar o login");
			result.redirectTo(LoginController.class).login();
			return;
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
