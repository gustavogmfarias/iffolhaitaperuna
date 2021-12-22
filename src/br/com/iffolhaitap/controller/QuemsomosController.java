package br.com.iffolhaitap.controller;

import javax.inject.Inject;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;
import br.com.iffolhaitap.dao.NoticiaDao;
import br.com.iffolhaitap.model.Noticia;

@Controller
public class QuemsomosController {

	@Inject
	private Result result;
	@Inject
	private NoticiaDao noticiaDao;

	@Get("/quemsomos")
	public void quemsomos() {

		Noticia quemsomos = noticiaDao.get(47l);
		result.include("noticia", quemsomos);

	}
}
