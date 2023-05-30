package br.com.iffolhaitap.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.observer.upload.UploadedFile;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.iffolhaitap.annotation.Privado;
import br.com.iffolhaitap.dao.AutorDao;
import br.com.iffolhaitap.model.Autor;
import br.com.iffolhaitap.paginacao.Paginacao;
import br.com.iffolhaitap.service.AutorService;
import br.com.iffolhaitap.util.HibernateUtil;
import br.com.iffolhaitap.util.Sessao;

@Entity
@Controller
public class AutorController {

	@Inject
	private Result result;
	@ManyToOne
	@Inject
	private AutorDao autorDao;
	@Inject
	private Validator validator;
	@ManyToOne
	@Inject
	private Sessao sessao;
	@ManyToOne
	@Inject
	private AutorService autorService;

	@Privado
	@Get("/adm/autores")
	public void lista(String busca, Integer paginaAtual) {
		Paginacao<Autor> paginacao = autorDao.lista(busca, paginaAtual);
		result.include("paginacao", paginacao);
		result.include("busca", busca);

	}

	@Privado
	@Get("/adm/autores/novo")
	public void novo() {

	}

	@Privado
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

		result.redirectTo(this).lista("",1);

	}

	@Privado
	@Get("/adm/autores/{autor.id}/editar")
	public void editar(Autor autor) {
		result.include("autor", autorDao.get(autor.getId()));
	}

	@Privado
	@Post("/adm/autores/editar")
	public void atualizar(@Valid Autor autor, UploadedFile imagemAutor) throws IOException {

		try {

			HibernateUtil.beginTransaction();
			autorService.atualizar(autor, imagemAutor);
			HibernateUtil.commit();
			validator.onErrorRedirectTo(this).lista("",1);
			

		} catch (Exception e) {
			HibernateUtil.rollback();
			validator.add(new SimpleMessage("error", e.getMessage()));
			validator.onErrorRedirectTo(this).editar(autor);
		}

		result.include("mensagem", "Autor atualizado com sucesso");

		result.redirectTo(this).lista("",1);

	}

	@Privado
	@Get("/adm/autores/{autor.id}/apagar")
	public void remove(Autor autor) {

		try {

			HibernateUtil.beginTransaction();
			autorService.remove(autor);
			HibernateUtil.commit();
			result.include("mensagem", "Autor removido com sucesso");
			result.redirectTo(this).lista("",1);
		} catch (Exception e) {
			HibernateUtil.rollback();
			validator.add(new SimpleMessage("error", "Transa��o n�o Efetuada"));
			validator.onErrorRedirectTo(this).lista("",1);
		}

	}
}
