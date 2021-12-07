package br.com.iffolhaitap.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.iffolhaitap.dao.ArtigoDao;
import br.com.iffolhaitap.dao.ConfiguracaoDao;
import br.com.iffolhaitap.dao.GeneroTextoDao;
import br.com.iffolhaitap.dao.NewsletterDao;
import br.com.iffolhaitap.dao.NoticiaDao;
import br.com.iffolhaitap.dao.VideoDao;
import br.com.iffolhaitap.model.Artigo;
import br.com.iffolhaitap.model.GeneroTexto;
import br.com.iffolhaitap.model.Newsletter;
import br.com.iffolhaitap.model.Noticia;
import br.com.iffolhaitap.model.Video;
import br.com.iffolhaitap.service.NewsletterService;
import br.com.iffolhaitap.util.HibernateUtil;
import br.com.iffolhaitap.util.Sessao;

@Controller
public class SiteController {

	@Inject
	private Result result;
	@Inject
	private ConfiguracaoDao configuracaoDao;
	@Inject
	private Sessao sessao;

	@Inject private NoticiaDao noticiaDao;
	@Inject private ArtigoDao artigoDao;
	@Inject private GeneroTextoDao generoTextoDao;
	@Inject private VideoDao videoDao;
	@Inject private NewsletterDao newsletterDao;
	@Inject private NewsletterService newsletterService;



	@Get("/")
	public void home() {

		List<Noticia> tresUltimasNoticias = noticiaDao.buscarTresUltimasNoticias();
		result.include("tresUltimasNoticias", tresUltimasNoticias);
		Noticia destaque = noticiaDao.pegarDestaque();
		result.include("destaque", destaque);
		List<Artigo> tresUltimosArtigos = artigoDao.buscarTresUltimosArtigos();
		result.include("tresUltimosArtigos", tresUltimosArtigos);
		List<GeneroTexto> todosGeneros = generoTextoDao.buscarTodosGeneros();
		result.include("todosGeneros", todosGeneros);
		List<Video> destaquesVideo = videoDao.pegarDestaque();
		result.include("destaquesVideo", destaquesVideo);

		List<Video> cincoUltimosVideos= videoDao.buscarCincoUltimosVideos();
		result.include("videos", cincoUltimosVideos);

	}





}
