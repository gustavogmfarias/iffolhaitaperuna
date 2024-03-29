package br.com.iffolhaitap.controller;

import java.io.IOException;
import java.util.List;

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
import br.com.iffolhaitap.dao.GeneroTextoDao;
import br.com.iffolhaitap.model.GeneroTexto;
import br.com.iffolhaitap.paginacao.Paginacao;
import br.com.iffolhaitap.service.GeneroService;
import br.com.iffolhaitap.util.HibernateUtil;
import br.com.iffolhaitap.util.Sessao;

@Entity
@Controller
public class GeneroController {

	@Inject
	private Result result;
	@ManyToOne
	@Inject
	private GeneroTextoDao generoTextoDao;
	@Inject
	private Validator validator;
	@ManyToOne
	@Inject
	private Sessao sessao;
	@ManyToOne
	@Inject
	private GeneroService generoService;

	@Privado
	@Get("/adm/generosdetexto")
	public void lista(String busca, Integer paginaAtual) {
		Paginacao<GeneroTexto> paginacao = generoTextoDao.lista(busca, paginaAtual);
		result.include("paginacao", paginacao);
		result.include("busca", busca);

	}

	@Privado
	@Get("/adm/generosdetexto/novo")
	public void novo() {

	}

	@Privado
	@Post("/adm/generosdetexto")
	public void adiciona(@Valid GeneroTexto generoTexto) throws IOException {

		try {
			HibernateUtil.beginTransaction();
			generoService.adiciona(generoTexto);
			HibernateUtil.commit();

		} catch (Exception e) {
			HibernateUtil.rollback();
			validator.add(new SimpleMessage("error", e.getMessage()));
			validator.onErrorRedirectTo(this).novo();
		}
		result.include("message", "Genero de Texto adicionado com sucesso");

		result.redirectTo(this).lista("", 1);

	}

	@Privado
	@Get("/adm/generosdetexto/{generoTexto.id}/editar")
	public void editar(GeneroTexto generoTexto) {
		result.include("generoTexto", generoTextoDao.get(generoTexto.getId()));
	}

	@Privado
	@Post("/adm/generosdetexto/editar")
	public void atualizar(@Valid GeneroTexto generoTexto) throws IOException {

		if (generoTextoDao.existeGeneroTextoPorNome(generoTexto.getGenero())) {

			validator.add(new SimpleMessage("error", "J� existe um Genero de Texto cadastrado com esse genero"));
			validator.onErrorRedirectTo(this).novo();

		}

		validator.onErrorRedirectTo(this).editar(generoTexto);

		try {

			HibernateUtil.beginTransaction();
			generoTextoDao.atualizar(generoTexto);
			HibernateUtil.commit();
			validator.onErrorRedirectTo(this).lista("",1);
			;

		} catch (Exception e) {
			HibernateUtil.rollback();
			validator.add(new SimpleMessage("error", "Transa��o n�o Efetuada"));
			validator.onErrorRedirectTo(this).editar(generoTexto);
		}

		result.include("mensagem", "Genero de Texto atualizado com sucesso");

		result.redirectTo(this).lista("",1);

	}

	@Privado
	@Get("/adm/generosdetexto/{generoTexto.id}/apagar")
	public void remove(GeneroTexto generoTexto) {

		try {

			HibernateUtil.beginTransaction();
			generoService.remove(generoTexto);
			HibernateUtil.commit();
			result.include("mensagem", "Genero de Texto removido com sucesso");
			result.redirectTo(this).lista("",1);
		} catch (Exception e) {
			HibernateUtil.rollback();
			validator.add(new SimpleMessage("error", "Transa��o n�o Efetuada"));
			validator.onErrorRedirectTo(this).lista("",1);
		}

	}
}
