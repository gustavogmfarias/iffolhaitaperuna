package br.com.iffolhaitap.interceptor;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.iffolhaitap.util.Sessao;


@RequestScoped @Intercepts
public class AlimentaDadosSessaoInterceptor implements Interceptor {
	
	@Inject private Sessao sessao;
	
	
	@Override
	public void intercept(InterceptorStack stack, ControllerMethod method, Object controllerInstance)
			throws InterceptionException {
		
		sessao.setTitulo("IFFolha - Itaperuna");
		sessao.setUrl("http://localhost:8080/iffolha");
		sessao.setUrlPadrao("http://localhost:8080/iffolha/");
		stack.next(method, controllerInstance);
	}

	@Override
	public boolean accepts(ControllerMethod method) {

		return true;
	}

	
	
	
}
