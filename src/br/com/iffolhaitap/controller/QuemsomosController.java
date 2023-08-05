package br.com.iffolhaitap.controller;

import javax.inject.Inject;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;
import br.com.iffolhaitap.dao.NoticiaDao;
import br.com.iffolhaitap.model.Noticia;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Controller
public class QuemsomosController {

	@Inject
	private Result result;
	@ManyToOne
	@Inject
	private NoticiaDao noticiaDao;

	@Get("/quemsomos")
	public void quemsomos() {

		Noticia quemsomos = noticiaDao.get(7l);
		result.include("noticia", quemsomos);

	}
}
