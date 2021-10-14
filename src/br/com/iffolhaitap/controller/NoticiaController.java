package br.com.iffolhaitap.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.observer.upload.UploadedFile;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.iffolhaitap.dao.NoticiaDao;
import br.com.iffolhaitap.model.Noticia;
import br.com.iffolhaitap.util.HibernateUtil;
import br.com.iffolhaitap.util.Sessao;

@Controller
public class NoticiaController {

	@Inject
	private Result result;
	@Inject
	private NoticiaDao noticiaDao;
	@Inject
	private Validator validator;
	@Inject
	private Sessao sessao;

	@Get("/adm/noticias")
	public void lista(String busca) {
		List<Noticia> noticias = noticiaDao.lista(busca);
		result.include("noticiaList", noticias);
		result.include("busca", busca);

	}

	@Get("/adm/noticias/novo")
	public void novo() {

	}

	@Post("/adm/noticias")
	public void adiciona(@Valid Noticia noticia) throws IOException {

	

		validator.onErrorUsePageOf(this).novo();

	

		try {

			HibernateUtil.beginTransaction();
			noticiaDao.adiciona(noticia);
			HibernateUtil.commit();

		} catch (Exception e) {
			HibernateUtil.rollback();
			validator.add(new SimpleMessage("error", "Transação não Efetuada"));
			validator.onErrorRedirectTo(this).novo();
		}
		result.include("mensagem", "Noticia adicionado com sucesso");

		result.redirectTo(this).lista("");

	}

	@Get("/adm/noticias/{noticia.id}/editar")
	public void editar(Noticia noticia) {
		result.include("noticia", noticiaDao.get(noticia.getId()));
	}

	@Post("/adm/noticias/editar")
	public void atualizar(@Valid Noticia noticia) throws IOException {


		
		validator.onErrorRedirectTo(this).editar(noticia);

		try {

			HibernateUtil.beginTransaction();
			noticiaDao.atualizar(noticia);
			HibernateUtil.commit();
			validator.onErrorRedirectTo(this).lista("");
			;

		} catch (Exception e) {
			HibernateUtil.rollback();
			validator.add(new SimpleMessage("error", "Transação não Efetuada"));
			validator.onErrorRedirectTo(this).editar(noticia);
		}

		result.include("mensagem", "Noticia atualizado com sucesso");

		result.redirectTo(this).lista("");

	}

	@Get("/adm/noticias/{noticia.id}/apagar")
	public void remove(Noticia noticia) {

		try {

			HibernateUtil.beginTransaction();
			noticiaDao.remove(noticia);
			HibernateUtil.commit();
			result.include("mensagem", "Noticia removido com sucesso");
			result.redirectTo(this).lista("");
		} catch (Exception e) {
			HibernateUtil.rollback();
			validator.add(new SimpleMessage("error", "Transação não Efetuada"));
			validator.onErrorRedirectTo(this).lista("");
		}

	}


}
