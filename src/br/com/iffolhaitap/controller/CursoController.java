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
import br.com.iffolhaitap.dao.CursoDao;
import br.com.iffolhaitap.model.Curso;
import br.com.iffolhaitap.util.HibernateUtil;
import br.com.iffolhaitap.util.Sessao;

@Controller
public class CursoController {

	@Inject
	private Result result;
	@Inject
	private CursoDao cursoDao;
	@Inject
	private Validator validator;
	@Inject
	private Sessao sessao;

	@Get("/adm/cursos")
	public void lista(String busca) {
		List<Curso> cursos = cursoDao.lista(busca);
		result.include("cursoList", cursos);
		result.include("busca", busca);

	}

	@Get("/adm/cursos/novo")
	public void novo() {

	}

	@Post("/adm/cursos")
	public void adiciona(@Valid Curso curso) throws IOException {

		if (cursoDao.existeCursoPorNome(curso.getNome())) {
			validator.add(new SimpleMessage("error", "J� existe um curso cadastrado com esse nome"));
			validator.onErrorRedirectTo(this).novo();
		}
		
		validator.onErrorUsePageOf(this).novo();

		try {
			HibernateUtil.beginTransaction();
			cursoDao.adiciona(curso);
			HibernateUtil.commit();

		} catch (Exception e) {
			HibernateUtil.rollback();
			validator.add(new SimpleMessage("error", "Transa��o n�o Efetuada"));
			validator.onErrorRedirectTo(this).novo();
		}
		result.include("message", "Curso adicionado com sucesso");

		result.redirectTo(this).lista("");

	}

	@Get("/adm/cursos/{curso.id}/editar")
	public void editar(Curso curso) {
		result.include("curso", cursoDao.get(curso.getId()));
	}

	@Post("/adm/cursos/editar")
	public void atualizar(@Valid Curso curso) throws IOException {


		if (cursoDao.existeCursoPorNome(curso.getNome())) {

			validator.add(new SimpleMessage("error", "J� existe curso cadastrado com esse nome"));
			validator.onErrorRedirectTo(this).novo();

		}
		
		validator.onErrorRedirectTo(this).editar(curso);

		try {

			HibernateUtil.beginTransaction();
			cursoDao.atualizar(curso);
			HibernateUtil.commit();
			validator.onErrorRedirectTo(this).lista("");
			;

		} catch (Exception e) {
			HibernateUtil.rollback();
			validator.add(new SimpleMessage("error", "Transa��o n�o Efetuada"));
			validator.onErrorRedirectTo(this).editar(curso);
		}

		result.include("mensagem", "Curso atualizado com sucesso");

		result.redirectTo(this).lista("");

	}

	@Get("/adm/cursos/{curso.id}/apagar")
	public void remove(Curso curso) {

		try {

			HibernateUtil.beginTransaction();
			cursoDao.remove(curso);
			HibernateUtil.commit();
			result.include("mensagem", "Curso removido com sucesso");
			result.redirectTo(this).lista("");
		} catch (Exception e) {
			HibernateUtil.rollback();
			validator.add(new SimpleMessage("error", "Transa��o n�o Efetuada"));
			validator.onErrorRedirectTo(this).lista("");
		}

	}
}
