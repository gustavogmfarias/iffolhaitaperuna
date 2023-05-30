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
import br.com.iffolhaitap.dao.ContatoDao;
import br.com.iffolhaitap.model.Contato;
import br.com.iffolhaitap.paginacao.Paginacao;
import br.com.iffolhaitap.service.ContatoService;
import br.com.iffolhaitap.util.HibernateUtil;

@Entity
@Controller
public class ContatoController {

	@Inject
	private Result result;
	@ManyToOne
	@Inject
	private ContatoDao contatoDao;
	@Inject
	private Validator validator;
	@ManyToOne
	@Inject
	private ContatoService contatoService;

	@Privado
	@Get("/adm/contatos")
	public void lista(String busca, Integer paginaAtual, Boolean estaRespondida) {
		Paginacao<Contato> paginacao = contatoDao.lista(busca, paginaAtual, estaRespondida);
		result.include("paginacao", paginacao);
		result.include("busca", busca);
		result.include("ehDestaque", estaRespondida);

	}

	@Privado
	@Get("/adm/contatos/novo")
	public void novo() {

	}



	@Post("/adm/contatos")
	public void adiciona(@Valid Contato contato) throws IOException {

		validator.onErrorUsePageOf(this).contato();

		try {

			HibernateUtil.beginTransaction();
			contato = contatoService.adicionar(contato);
			HibernateUtil.commit();

		} catch (Exception e) {
			HibernateUtil.rollback();
			e.printStackTrace();
			validator.add(new SimpleMessage("error", e.getMessage()));
			validator.onErrorRedirectTo(this).contato();
		}
		result.include("mensagem", "Contato adicionado com sucesso");

		result.redirectTo(this).contato();

	}

	@Privado
	@Get("/adm/contatos/{contato.id}/editar")
	public void editar(Contato contato) {

		result.include("contato", contatoDao.get(contato.getId()));

	}

	@Privado
	@Post("/adm/contatos/editar")
	public void atualizar(@Valid Contato contato) throws IOException {

		validator.onErrorRedirectTo(this).editar(contato);

		try {

			HibernateUtil.beginTransaction();
			contato = contatoService.atualizar(contato);
			HibernateUtil.commit();

		} catch (Exception e) {
			HibernateUtil.rollback();
			validator.add(new SimpleMessage("error", e.getMessage()));
			validator.onErrorRedirectTo(this).editar(contato);
		}

		result.include("mensagem", "Contato atualizado com sucesso");

		result.redirectTo(this).lista("", 1, null);

	}

	@Privado
	@Get("/adm/contatos/{contato.id}/apagar")
	public void remove(Contato contato) {

		try {

			HibernateUtil.beginTransaction();
			contatoService.remove(contato);
			HibernateUtil.commit();
			result.include("mensagem", "Contato removido com sucesso");
			result.redirectTo(this).lista("", 1,null);
		} catch (Exception e) {
			HibernateUtil.rollback();
			validator.add(new SimpleMessage("error", "Transa��o n�o Efetuada"));
			validator.onErrorRedirectTo(this).lista("", 1,null);
		}

	}

	@Get("/contato")
	public void contato() {

	}


}
