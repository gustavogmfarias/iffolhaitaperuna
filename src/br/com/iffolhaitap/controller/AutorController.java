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
import br.com.iffolhaitap.dao.AutorDao;
import br.com.iffolhaitap.model.Autor;
import br.com.iffolhaitap.service.AutorService;
import br.com.iffolhaitap.util.HibernateUtil;
import br.com.iffolhaitap.util.Sessao;

@Controller
public class AutorController {

	@Inject
	private Result result;
	@Inject
	private AutorDao autorDao;
	@Inject
	private Validator validator;
	@Inject
	private Sessao sessao;
	@Inject
	private AutorService autorService;

	@Get("/adm/autores")
	public void lista(String busca) {
		List<Autor> autores = autorDao.lista(busca);
		result.include("autorList", autores);
		result.include("busca", busca);

	}

	@Get("/adm/autores/novo")
	public void novo() {

	}

	@Post("/adm/autores")
	public void adiciona(@Valid Autor autor, UploadedFile imagemAutor) throws IOException {

		try {

			HibernateUtil.beginTransaction();
			autorService.adiciona(autor, imagemAutor);
			HibernateUtil.commit();

		} catch (Exception e) {
			HibernateUtil.rollback();
			validator.add(new SimpleMessage("error", e.getMessage()));
			validator.onErrorRedirectTo(this).novo();
		}
		result.include("message", "Autor adicionado com sucesso");

		result.redirectTo(this).lista("");

	}

	@Get("/adm/autores/{autor.id}/editar")
	public void editar(Autor autor) {
		result.include("autor", autorDao.get(autor.getId()));
	}

	@Post("/adm/autores/editar")
	public void atualizar(@Valid Autor autor, UploadedFile imagemAutor) throws IOException {

		try {

			HibernateUtil.beginTransaction();
			autorService.atualizar(autor, imagemAutor);
			HibernateUtil.commit();
			validator.onErrorRedirectTo(this).lista("");
			;

		} catch (Exception e) {
			HibernateUtil.rollback();
			validator.add(new SimpleMessage("error", e.getMessage()));
			validator.onErrorRedirectTo(this).editar(autor);
		}

		result.include("mensagem", "Autor atualizado com sucesso");

		result.redirectTo(this).lista("");

	}

	@Get("/adm/autores/{autor.id}/apagar")
	public void remove(Autor autor) {

		try {

			HibernateUtil.beginTransaction();
			autorDao.remove(autor);
			HibernateUtil.commit();
			result.include("mensagem", "Autor removido com sucesso");
			result.redirectTo(this).lista("");
		} catch (Exception e) {
			HibernateUtil.rollback();
			validator.add(new SimpleMessage("error", "Transação não Efetuada"));
			validator.onErrorRedirectTo(this).lista("");
		}

	}
}
