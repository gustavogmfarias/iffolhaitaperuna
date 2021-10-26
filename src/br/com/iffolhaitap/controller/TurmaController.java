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
import br.com.iffolhaitap.annotation.Privado;
import br.com.iffolhaitap.dao.CursoDao;
import br.com.iffolhaitap.dao.TurmaDao;
import br.com.iffolhaitap.model.Curso;
import br.com.iffolhaitap.model.Turma;
import br.com.iffolhaitap.service.TurmaService;
import br.com.iffolhaitap.util.HibernateUtil;
import br.com.iffolhaitap.util.Sessao;

@Controller
public class TurmaController {

	@Inject
	private Result result;
	@Inject
	private TurmaDao turmaDao;
	@Inject
	private Validator validator;
	@Inject
	private Sessao sessao;
	@Inject
	private CursoDao cursoDao;
	@Inject private TurmaService turmaService;

	@Privado
	@Get("/adm/turmas")
	public void lista(String busca) {
		List<Turma> turmas = turmaDao.lista(busca);
		result.include("turmaList", turmas);
		result.include("busca", busca);

	}

	@Privado
	@Get("/adm/turmas/novo")
	public void novo() {
		List<Curso> cursoList = cursoDao.buscaTodos();

		result.include("cursoList", cursoList);
	}

	@Privado
	@Post("/adm/turmas")
	public void adiciona(@Valid Turma turma) throws IOException {

		validator.onErrorUsePageOf(this).novo();

		try {
			HibernateUtil.beginTransaction();
			turmaService.adiciona(turma);
			HibernateUtil.commit();

		} catch (Exception e) {
			HibernateUtil.rollback();
			validator.add(new SimpleMessage("error", e.getMessage()));
			validator.onErrorRedirectTo(this).novo();
		}
		result.include("message", "Turma adicionado com sucesso");

		result.redirectTo(this).lista("");

	}

	@Privado
	@Get("/adm/turmas/{turma.id}/editar")
	public void editar(Turma turma) {
		List<Curso> cursoList = cursoDao.buscaTodos();
		result.include("cursoList", cursoList);
		result.include("turma", turmaDao.get(turma.getId()));
	}

	@Privado
	@Post("/adm/turmas/editar")
	public void atualizar(@Valid Turma turma, String nomeAnterior) throws IOException {

		validator.onErrorRedirectTo(this).editar(turma);

		try {

			HibernateUtil.beginTransaction();
			turmaService.atualizar(turma, nomeAnterior);
			HibernateUtil.commit();
			validator.onErrorRedirectTo(this).lista("");
			;

		} catch (Exception e) {
			HibernateUtil.rollback();
			validator.add(new SimpleMessage("error", "Transação não Efetuada"));
			validator.onErrorRedirectTo(this).editar(turma);
		}

		result.include("mensagem", "Turma atualizado com sucesso");

		result.redirectTo(this).lista("");

	}

	@Privado
	@Get("/adm/turmas/{turma.id}/apagar")
	public void remove(Turma turma) {

		try {

			HibernateUtil.beginTransaction();
			turmaDao.remove(turma);
			HibernateUtil.commit();
			result.include("mensagem", "Turma removido com sucesso");
			result.redirectTo(this).lista("");
		} catch (Exception e) {
			HibernateUtil.rollback();
			validator.add(new SimpleMessage("error", "Transação não Efetuada"));
			validator.onErrorRedirectTo(this).lista("");
		}

	}
}
