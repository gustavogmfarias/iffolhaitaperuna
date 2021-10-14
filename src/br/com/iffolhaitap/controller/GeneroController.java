package br.com.iffolhaitap.controller;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.iffolhaitap.dao.GeneroTextoDao;
import br.com.iffolhaitap.model.GeneroTexto;
import br.com.iffolhaitap.util.HibernateUtil;
import br.com.iffolhaitap.util.Sessao;

@Controller
public class GeneroController {

	@Inject
	private Result result;
	@Inject
	private GeneroTextoDao generoTextoDao;
	@Inject
	private Validator validator;
	@Inject
	private Sessao sessao;

	@Get("/adm/generosdetexto")
	public void lista(String busca) {
		List<GeneroTexto> generosdeTexto = generoTextoDao.lista(busca);
		result.include("generoTextoList", generosdeTexto);
		result.include("busca", busca);

	}

	@Get("/adm/generosdetexto/novo")
	public void novo() {

	}

	@Post("/adm/generosdetexto")
	public void adiciona(@Valid GeneroTexto generoTexto) throws IOException {

		if (generoTextoDao.existeGeneroTextoPorNome(generoTexto.getGenero())) {
			validator.add(new SimpleMessage("error", "Já existe um Gênero de Texto cadastrado com esse genero"));
			validator.onErrorRedirectTo(this).novo();
		}
		
		validator.onErrorUsePageOf(this).novo();

		try {
			HibernateUtil.beginTransaction();
			generoTextoDao.adiciona(generoTexto);
			HibernateUtil.commit();

		} catch (Exception e) {
			HibernateUtil.rollback();
			validator.add(new SimpleMessage("error", "Transação não Efetuada"));
			validator.onErrorRedirectTo(this).novo();
		}
		result.include("message", "Genero de Texto adicionado com sucesso");

		result.redirectTo(this).lista("");

	}

	@Get("/adm/generosdetexto/{generoTexto.id}/editar")
	public void editar(GeneroTexto generoTexto) {
		result.include("generoTexto", generoTextoDao.get(generoTexto.getId()));
	}

	@Post("/adm/generosdetexto/editar")
	public void atualizar(@Valid GeneroTexto generoTexto) throws IOException {


		if (generoTextoDao.existeGeneroTextoPorNome(generoTexto.getGenero())) {

			validator.add(new SimpleMessage("error", "Já existe um Genero de Texto cadastrado com esse genero"));
			validator.onErrorRedirectTo(this).novo();

		}
		
		validator.onErrorRedirectTo(this).editar(generoTexto);

		try {

			HibernateUtil.beginTransaction();
			generoTextoDao.atualizar(generoTexto);
			HibernateUtil.commit();
			validator.onErrorRedirectTo(this).lista("");
			;

		} catch (Exception e) {
			HibernateUtil.rollback();
			validator.add(new SimpleMessage("error", "Transação não Efetuada"));
			validator.onErrorRedirectTo(this).editar(generoTexto);
		}

		result.include("mensagem", "Genero de Texto atualizado com sucesso");

		result.redirectTo(this).lista("");

	}

	@Get("/adm/generosdetexto/{generoTexto.id}/apagar")
	public void remove(GeneroTexto generoTexto) {

		try {

			HibernateUtil.beginTransaction();
			generoTextoDao.remove(generoTexto);
			HibernateUtil.commit();
			result.include("mensagem", "Genero de Texto removido com sucesso");
			result.redirectTo(this).lista("");
		} catch (Exception e) {
			HibernateUtil.rollback();
			validator.add(new SimpleMessage("error", "Transação não Efetuada"));
			validator.onErrorRedirectTo(this).lista("");
		}

	}
}
