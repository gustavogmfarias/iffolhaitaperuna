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
import br.com.iffolhaitap.dao.CursoDao;
import br.com.iffolhaitap.model.Curso;
import br.com.iffolhaitap.paginacao.Paginacao;
import br.com.iffolhaitap.service.CursoService;
import br.com.iffolhaitap.util.HibernateUtil;
import br.com.iffolhaitap.util.Sessao;

@Entity
@Controller
public class CursoController {

	@Inject
	private Result result;
	@ManyToOne
	@Inject
	private CursoDao cursoDao;
	@Inject
	private Validator validator;
	@ManyToOne
	@Inject
	private Sessao sessao;
	@ManyToOne
	@Inject
	private CursoService cursoService;

	@Privado
	@Get("/adm/cursos")
	public void lista(String busca, Integer paginaAtual) {
		Paginacao<Curso> paginacao = cursoDao.lista(busca, paginaAtual);
		result.include("paginacao", paginacao);
		result.include("busca", busca);

	}

	@Privado
	@Get("/adm/cursos/novo")
	public void novo() {

	}

	@Privado
	@Post("/adm/cursos")
	public void adiciona(@Valid Curso curso) throws IOException {

		try {
			HibernateUtil.beginTransaction();
			cursoService.adiciona(curso);
			HibernateUtil.commit();

		} catch (Exception e) {
			HibernateUtil.rollback();
			validator.add(new SimpleMessage("error", e.getMessage()));
			validator.onErrorRedirectTo(this).novo();
		}
		result.include("message", "Curso adicionado com sucesso");

		result.redirectTo(this).lista("",1);

	}

	@Privado
	@Get("/adm/cursos/{curso.id}/editar")
	public void editar(Curso curso) {
		result.include("curso", cursoDao.get(curso.getId()));
	}

	@Privado
	@Post("/adm/cursos/editar")
	public void atualizar(@Valid Curso curso, String nomeAnterior) throws IOException {

		try {

			HibernateUtil.beginTransaction();
			cursoService.atualizar(curso, nomeAnterior);
			HibernateUtil.commit();
			validator.onErrorRedirectTo(this).lista("",1);
			;

		} catch (Exception e) {
			HibernateUtil.rollback();
			validator.add(new SimpleMessage("error", e.getMessage()));
			validator.onErrorRedirectTo(this).editar(curso);
		}

		result.include("mensagem", "Curso atualizado com sucesso");

		result.redirectTo(this).lista("",1);

	}

	@Privado
	@Get("/adm/cursos/{curso.id}/apagar")
	public void remove(Curso curso) {

		try {

			HibernateUtil.beginTransaction();
			cursoService.remove(curso);
			HibernateUtil.commit();
			result.include("mensagem", "Curso removido com sucesso");
			result.redirectTo(this).lista("",1);
		} catch (Exception e) {
			HibernateUtil.rollback();
			validator.add(new SimpleMessage("error", "Transa��o n�o Efetuada"));
			validator.onErrorRedirectTo(this).lista("",1);
		}

	}
}
