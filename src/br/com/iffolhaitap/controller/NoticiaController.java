package br.com.iffolhaitap.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.iffolhaitap.dao.AutorDao;
import br.com.iffolhaitap.dao.CursoDao;
import br.com.iffolhaitap.dao.NoticiaDao;
import br.com.iffolhaitap.dao.TurmaDao;
import br.com.iffolhaitap.model.Autor;
import br.com.iffolhaitap.model.Curso;
import br.com.iffolhaitap.model.Noticia;
import br.com.iffolhaitap.model.Turma;
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

	@Inject
	private AutorDao autorDao;
	@Inject
	private TurmaDao turmaDao;
	@Inject
	private CursoDao cursoDao;
	
	@Get("/adm/noticias")
	public void lista(String busca, Boolean ehDestaque) {
		List<Noticia> noticias = noticiaDao.lista(busca, ehDestaque);
		result.include("noticiaList", noticias);
		result.include("busca", busca);

	}

	@Get("/adm/noticias/novo")
	public void novo() {

		List<Autor> autoresList = autorDao.buscaTodos();
		result.include("autoresList", autoresList);
		List<Turma> turmasList = turmaDao.buscaTodos();
		result.include("turmasList", turmasList);
		List<Curso> cursosList = cursoDao.buscaTodos();
		result.include("cursosList", cursosList);
	}

	@Post("/adm/noticias")
	public void adiciona(@Valid Noticia noticia) throws IOException {

		validator.onErrorUsePageOf(this).novo();

		noticia.setPublicadoPor(sessao.getUsuario());
		noticia.setDataDePublicacao(new Date());

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

		result.redirectTo(this).lista("", null);

	}

	@Get("/adm/noticias/{noticia.id}/editar")
	public void editar(Noticia noticia) {

		List<Autor> autoresList = autorDao.buscaTodos();

		result.include("autoresList", autoresList);
		result.include("noticia", noticiaDao.get(noticia.getId()));

		List<Turma> turmasList = turmaDao.buscaTodos();
		result.include("turmasList", turmasList);
		List<Curso> cursosList = cursoDao.buscaTodos();
		result.include("cursosList", cursosList);
	}

	@Post("/adm/noticias/editar")
	public void atualizar(@Valid Noticia noticia) throws IOException {

		Noticia noticiaDoBancoDeDados = noticiaDao.get(noticia.getId());

		validator.onErrorRedirectTo(this).editar(noticia);

		noticia.setDataDePublicacao(noticiaDoBancoDeDados.getDataDePublicacao());
		noticia.setPublicadoPor(noticiaDoBancoDeDados.getPublicadoPor());
		noticia.setEditadoPor(sessao.getUsuario());
		noticia.setDataEdicao(new Date());

		try {

			HibernateUtil.beginTransaction();
			noticiaDao.atualizar(noticia);
			HibernateUtil.commit();
			validator.onErrorRedirectTo(this).lista("", null);
			;

		} catch (Exception e) {
			HibernateUtil.rollback();
			validator.add(new SimpleMessage("error", "Transação não Efetuada"));
			validator.onErrorRedirectTo(this).editar(noticia);
		}

		result.include("mensagem", "Noticia atualizado com sucesso");

		result.redirectTo(this).lista("", null);

	}

	@Get("/adm/noticias/{noticia.id}/apagar")
	public void remove(Noticia noticia) {

		try {

			HibernateUtil.beginTransaction();
			noticiaDao.remove(noticia);
			HibernateUtil.commit();
			result.include("mensagem", "Noticia removido com sucesso");
			result.redirectTo(this).lista("", null);
		} catch (Exception e) {
			HibernateUtil.rollback();
			validator.add(new SimpleMessage("error", "Transação não Efetuada"));
			validator.onErrorRedirectTo(this).lista("", null);
		}

	}

}
