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
import br.com.caelum.vraptor.observer.upload.UploadedFile;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.iffolhaitap.annotation.Privado;
import br.com.iffolhaitap.dao.AutorDao;
import br.com.iffolhaitap.dao.CursoDao;
import br.com.iffolhaitap.dao.NoticiaDao;
import br.com.iffolhaitap.dao.TagDao;
import br.com.iffolhaitap.dao.TurmaDao;
import br.com.iffolhaitap.model.Autor;
import br.com.iffolhaitap.model.Curso;
import br.com.iffolhaitap.model.Noticia;
import br.com.iffolhaitap.model.Tag;
import br.com.iffolhaitap.model.Turma;
import br.com.iffolhaitap.paginacao.Paginacao;
import br.com.iffolhaitap.service.NoticiaService;
import br.com.iffolhaitap.util.HibernateUtil;
import br.com.iffolhaitap.util.Sessao;

@Entity
@Controller
public class NoticiaController {

	@Inject
	private Result result;
	@ManyToOne
	@Inject
	private NoticiaDao noticiaDao;
	@Inject
	private Validator validator;
	@ManyToOne
	@Inject
	private Sessao sessao;
	@ManyToOne
	@Inject
	private AutorDao autorDao;
	@ManyToOne
	@Inject
	private TurmaDao turmaDao;
	@ManyToOne
	@Inject
	private CursoDao cursoDao;
	@ManyToOne
	@Inject
	private TagDao tagDao;
	@ManyToOne
	@Inject
	private NoticiaService noticiaService;

	@Privado
	@Get("/adm/noticias")
	public void lista(String busca, Integer paginaAtual, Boolean ehDestaque) {
		Paginacao<Noticia> paginacao = noticiaDao.lista(busca, paginaAtual, ehDestaque, null);
		result.include("paginacao", paginacao);
		result.include("busca", busca);
		result.include("ehDestaque", ehDestaque);

	}

	@Privado
	@Get("/adm/noticias/novo")
	public void novo() {

		List<Autor> autoresList = autorDao.buscaTodos();
		result.include("autoresList", autoresList);
		List<Turma> turmasList = turmaDao.buscaTodos();
		result.include("turmasList", turmasList);
		List<Curso> cursosList = cursoDao.buscaTodos();
		result.include("cursosList", cursosList);
	}

	@Privado
	@Post("/adm/noticias")
	public void adiciona(@Valid Noticia noticia, UploadedFile imagemNoticia) throws IOException {

		validator.onErrorUsePageOf(this).novo();

		try {

			HibernateUtil.beginTransaction();
			noticia = noticiaService.adicionar(noticia, imagemNoticia);
			HibernateUtil.commit();

		} catch (Exception e) {
			HibernateUtil.rollback();
			e.printStackTrace();
			validator.add(new SimpleMessage("error", e.getMessage()));
			validator.onErrorRedirectTo(this).novo();
		}
		result.include("mensagem", "Noticia adicionado com sucesso");

		result.redirectTo(this).lista("", 1, null);

	}

	@Privado
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

	@Privado
	@Post("/adm/noticias/editar")
	public void atualizar(@Valid Noticia noticia, UploadedFile imagemNoticia) throws IOException {

		validator.onErrorRedirectTo(this).editar(noticia);

		try {

			HibernateUtil.beginTransaction();
			noticia = noticiaService.atualizar(noticia, imagemNoticia);
			HibernateUtil.commit();

		} catch (Exception e) {
			HibernateUtil.rollback();
			validator.add(new SimpleMessage("error", e.getMessage()));
			validator.onErrorRedirectTo(this).editar(noticia);
		}

		result.include("mensagem", "Noticia atualizado com sucesso");

		result.redirectTo(this).lista("", 1, null);

	}

	@Privado
	@Get("/adm/noticias/{noticia.id}/apagar")
	public void remove(Noticia noticia) {

		try {

			HibernateUtil.beginTransaction();
			noticiaService.remove(noticia);
			HibernateUtil.commit();
			result.include("mensagem", "Noticia removido com sucesso");
			result.redirectTo(this).lista("", 1,null);
		} catch (Exception e) {
			HibernateUtil.rollback();
			validator.add(new SimpleMessage("error", "Transa��o n�o Efetuada"));
			validator.onErrorRedirectTo(this).lista("", 1,null);
		}

	}

	@Get("/noticias")
	public void noticias(String busca, Integer paginaAtual, Tag tag) {

		List<Tag> tags = tagDao.buscaTodos();
		Paginacao<Noticia> paginacao = noticiaDao.lista(busca, paginaAtual, null, tag);
		result.include("paginacao", paginacao);
		result.include("busca", busca);
		result.include("tags", tags);
		result.include("tag", tag);

	}

	@Get("/noticias/{noticia.url}")
	public void showNoticia(Noticia noticia) {

		noticia = noticiaDao.procuraPorUrl(noticia);
		result.include("noticia",noticia);

	}

	@Get("/noticias/tags/{tag.url}")
	public void buscaNoticiasPorTag(Tag tag) {
		tag = tagDao.procuraPorUrl(tag);
		result.forwardTo(this).noticias(null, null, tag);
	}

	@Get("/noticias/pesquisar")
	public void pesquisa(String busca, Integer paginaAtual, Tag tag) {

		List<Tag> tags = tagDao.buscaTodos();
		Paginacao<Noticia> paginacao = noticiaDao.lista(busca, paginaAtual, null, null);
		result.include("paginacao", paginacao);
		result.include("busca", busca);
		result.include("tags", tags);
		result.include("tag", tag);

	}

}
