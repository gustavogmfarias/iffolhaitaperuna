package br.com.iffolhaitap.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import br.com.iffolhaitap.annotation.Privado;
import br.com.iffolhaitap.dao.LogDao;
import br.com.iffolhaitap.model.Log;
import br.com.iffolhaitap.paginacao.Paginacao;
import br.com.iffolhaitap.util.Sessao;

@Controller
public class LogController {

	@Inject
	private Result result;
	@Inject
	private LogDao logDao;
	@Inject
	private Validator validator;
	@Inject
	private Sessao sessao;

	@Privado
	@Get("/adm/log")
	public void lista(String busca, Integer paginaAtual) {
		Paginacao<Log> paginacao = logDao.lista(busca, paginaAtual);
		result.include("paginacao", paginacao);
		result.include("busca", busca);

	}

}
