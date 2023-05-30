package br.com.iffolhaitap.controller;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.observer.upload.UploadedFile;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.iffolhaitap.annotation.Privado;
import br.com.iffolhaitap.dao.ArtigoDao;
import br.com.iffolhaitap.dao.AutorDao;
import br.com.iffolhaitap.dao.CursoDao;
import br.com.iffolhaitap.dao.GeneroTextoDao;
import br.com.iffolhaitap.dao.TagDao;
import br.com.iffolhaitap.dao.TurmaDao;
import br.com.iffolhaitap.model.Artigo;
import br.com.iffolhaitap.model.Autor;
import br.com.iffolhaitap.model.Curso;
import br.com.iffolhaitap.model.GeneroTexto;
import br.com.iffolhaitap.model.Tag;
import br.com.iffolhaitap.model.Turma;
import br.com.iffolhaitap.paginacao.Paginacao;
import br.com.iffolhaitap.service.ArtigoService;
import br.com.iffolhaitap.util.HibernateUtil;
import br.com.iffolhaitap.util.Sessao;

@Entity
@Controller
public class ArtigoController {

	@Inject
	private Result result;
	@ManyToOne
	@Inject
	private ArtigoDao artigoDao;
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
	private GeneroTextoDao generoDao;
	@ManyToOne
	@Inject
	private ArtigoService artigoService;

	@Privado
	@Get("/adm/artigos")
	public void lista(String busca, Integer paginaAtual) {
		Paginacao<Artigo> paginacao = artigoDao.lista(busca, paginaAtual, null, null);
		result.include("paginacao", paginacao);
		result.include("busca", busca);

	}

	@Privado
	@Get("/adm/artigos/novo")
	public void novo() {

		List<Autor> autoresList = autorDao.buscaTodos();
		result.include("autoresList", autoresList);
		List<Turma> turmasList = turmaDao.buscaTodos();
		result.include("turmasList", turmasList);
		List<Curso> cursosList = cursoDao.buscaTodos();
		result.include("cursosList", cursosList);
		List<GeneroTexto> generosList = generoDao.buscaTodos();
		result.include("generosList", generosList);
	}

	@Privado
	@Post("/adm/artigos")
	public void adiciona(@Valid Artigo artigo, UploadedFile imagemArtigo) throws IOException {

		validator.onErrorUsePageOf(this).novo();

		try {

			HibernateUtil.beginTransaction();
			artigo = artigoService.adicionar(artigo, imagemArtigo);
			HibernateUtil.commit();

		} catch (Exception e) {
			HibernateUtil.rollback();
			e.printStackTrace();
			validator.add(new SimpleMessage("error", e.getMessage()));
			validator.onErrorRedirectTo(this).novo();
		}
		result.include("mensagem", "Artigo adicionado com sucesso");

		result.redirectTo(this).lista("", 1);

	}

	@Privado
	@Get("/adm/artigos/{artigo.id}/editar")
	public void editar(Artigo artigo) {

		List<Autor> autoresList = autorDao.buscaTodos();
		result.include("autoresList", autoresList);
		List<Turma> turmasList = turmaDao.buscaTodos();
		result.include("turmasList", turmasList);
		List<Curso> cursosList = cursoDao.buscaTodos();
		result.include("cursosList", cursosList);
		List<GeneroTexto> generosList = generoDao.buscaTodos();
		result.include("generosList", generosList);
		artigo = artigoDao.get(artigo.getId());
		result.include("artigo", artigo);

	}

	@Privado
	@Post("/adm/artigos/editar")
	public void atualizar(@Valid Artigo artigo, UploadedFile imagemArtigo) throws IOException {

		validator.onErrorRedirectTo(this).editar(artigo);

		try {

			HibernateUtil.beginTransaction();
			artigo = artigoService.atualizar(artigo, imagemArtigo);
			HibernateUtil.commit();

		} catch (Exception e) {
			HibernateUtil.rollback();
			validator.add(new SimpleMessage("error", e.getMessage()));
			validator.onErrorRedirectTo(this).editar(artigo);
		}

		result.include("mensagem", "Artigo atualizado com sucesso");

		result.redirectTo(this).lista("", 1);

	}

	@Privado
	@Get("/adm/artigos/{artigo.id}/apagar")
	public void remove(Artigo artigo) {

		try {

			HibernateUtil.beginTransaction();
			artigoService.remove(artigo);
			HibernateUtil.commit();
			result.include("mensagem", "Artigo removido com sucesso");
			result.redirectTo(this).lista("", 1);
		} catch (Exception e) {
			HibernateUtil.rollback();
			validator.add(new SimpleMessage("error", "Transa��o n�o Efetuada"));
			validator.onErrorRedirectTo(this).lista("", 1);
		}

	}

	@Get("/artigos")
	public void artigos(String busca, Integer paginaAtual, Tag tag, GeneroTexto genero) {

		List<GeneroTexto> generos = generoDao.buscaTodos();
		Paginacao<Artigo> paginacao = artigoDao.lista(busca, paginaAtual, genero, tag);
		result.include("paginacao", paginacao);
		result.include("busca", busca);
		result.include("generos", generos);

	}

	@Get("/artigos/{artigo.url}")
	public void showArtigo(Artigo artigo) {

		artigo = artigoDao.procuraPorUrl(artigo);
		result.include("artigo", artigo);

	}

	@Get("/artigos/tags/{tag.url}")
	public void buscaArtigoPorTag(Tag tag) {
		tag = tagDao.procuraPorUrl(tag);
		result.forwardTo(this).artigos(null, null, tag, null);
	}

	@Get("/artigos/generos/{genero.url}")
	public void buscaArtigoPorGenero(GeneroTexto genero) {
		genero = generoDao.procuraPorUrl(genero);
		result.forwardTo(this).artigos(null, null, null, genero);
	}

}
