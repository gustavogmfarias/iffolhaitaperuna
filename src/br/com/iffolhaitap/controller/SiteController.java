package br.com.iffolhaitap.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import br.com.iffolhaitap.dao.ConfiguracaoDao;
import br.com.iffolhaitap.model.Configuracao;
import br.com.iffolhaitap.service.ConfiguracaoService;
import br.com.iffolhaitap.util.Sessao;

@Controller
public class SiteController {

	@Inject
	private Result result;
	@Inject
	private ConfiguracaoDao configuracaoDao;
	@Inject
	private Sessao sessao;

	@Get("/")
	public void home() {

	}
}
