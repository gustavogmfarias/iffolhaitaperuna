package br.com.iffolhaitap.interceptor;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.iffolhaitap.dao.ConfiguracaoDao;
import br.com.iffolhaitap.model.Configuracao;
import br.com.iffolhaitap.util.Sessao;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@RequestScoped
@Intercepts
public class AlimentaDadosSessaoInterceptor implements Interceptor {

	@ManyToOne
	@Inject
	private Sessao sessao;
	@ManyToOne
	@Inject
	private ConfiguracaoDao configuracaoDao;

	@Override
	public void intercept(InterceptorStack stack, ControllerMethod method, Object controllerInstance)
			throws InterceptionException {

		sessao.setUrl("http://localhost:8080/iffolha");
		sessao.setUrlPadrao("http://localhost:8080/iffolha/");

		if (sessao.getConfiguracao() == null) {
			Configuracao configuracao = configuracaoDao.get(1l);
			sessao.setConfiguracao(configuracao);
			sessao.setTitulo(configuracao.getTitulo());
		}

		stack.next(method, controllerInstance);
	}

	@Override
	public boolean accepts(ControllerMethod method) {

		return true;
	}

}
