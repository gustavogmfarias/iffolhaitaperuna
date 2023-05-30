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
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.iffolhaitap.annotation.Privado;
import br.com.iffolhaitap.dao.NewsletterDao;
import br.com.iffolhaitap.model.Newsletter;
import br.com.iffolhaitap.paginacao.Paginacao;
import br.com.iffolhaitap.service.NewsletterService;
import br.com.iffolhaitap.util.HibernateUtil;
import br.com.iffolhaitap.util.Sessao;

@Entity
@Controller
public class NewsletterController {

	@Inject
	private Result result;
	@ManyToOne
	@Inject
	private NewsletterDao newsletterDao;
	@Inject
	private Validator validator;
	@ManyToOne
	@Inject
	private Sessao sessao;
	@ManyToOne
	@Inject
	private NewsletterService newsletterService;

	@Privado
	@Get("/adm/newsletters")
	public void lista(String busca, Integer paginaAtual) {
		Paginacao<Newsletter> paginacao = newsletterDao.lista(busca, paginaAtual);
		result.include("paginacao", paginacao);
		result.include("busca", busca);

	}

	@Privado
	@Get("/adm/newsletters/novo")
	public void novo() {

	}

	@Post("/adm/newsletters")
	public void adiciona(@Valid Newsletter newsletter) throws IOException {
		validator.onErrorForwardTo(SiteController.class).home();

		try {
			HibernateUtil.beginTransaction();
			newsletterService.adiciona(newsletter);
			HibernateUtil.commit();

		} catch (Exception e) {
			HibernateUtil.rollback();
			validator.add(new SimpleMessage("error", e.getMessage()));
			validator.onErrorForwardTo(SiteController.class).home();
		}
		result.include("message", "E-mail adicionado com sucesso");
		result.redirectTo(SiteController.class).home();

	}

	@Privado
	@Get("/adm/newsletters/{newsletter.id}/editar")
	public void editar(Newsletter newsletter) {
		result.include("newsletter", newsletterDao.get(newsletter.getId()));
	}

	@Privado
	@Post("/adm/newsletters/editar")
	public void atualizar(@Valid Newsletter newsletter, String nomeAnterior) throws IOException {

		try {

			HibernateUtil.beginTransaction();
			newsletterService.atualizar(newsletter, nomeAnterior);
			HibernateUtil.commit();
			validator.onErrorRedirectTo(this).lista("", 1);
			;

		} catch (Exception e) {
			HibernateUtil.rollback();
			validator.add(new SimpleMessage("error", e.getMessage()));
			validator.onErrorRedirectTo(this).editar(newsletter);
		}

		result.include("mensagem", "Newsletter atualizado com sucesso");
		result.redirectTo(this).lista("", 1);

	}

	@Privado
	@Get("/adm/newsletters/{newsletter.id}/apagar")
	public void remove(Newsletter newsletter) {

		try {

			HibernateUtil.beginTransaction();
			newsletterService.remove(newsletter);
			HibernateUtil.commit();
			result.include("mensagem", "Newsletter removido com sucesso");
			result.redirectTo(this).lista("", 1);
		} catch (Exception e) {
			HibernateUtil.rollback();
			validator.add(new SimpleMessage("error", "Transa��o n�o Efetuada"));
			validator.onErrorRedirectTo(this).lista("", 1);
		}

	}
}
