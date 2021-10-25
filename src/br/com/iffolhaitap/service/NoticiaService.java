package br.com.iffolhaitap.service;

import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.iffolhaitap.dao.NoticiaDao;
import br.com.iffolhaitap.model.Noticia;
import br.com.iffolhaitap.util.Sessao;

@RequestScoped
public class NoticiaService {

	@Inject
	private Sessao sessao;
	@Inject
	private NoticiaDao noticiaDao;
	@Inject private TagService tagService;
	
	public Noticia adicionar(Noticia noticia) {
		
		String tagsEmTexto = noticia.getTagsEmTexto();
		noticia.setPublicadoPor(sessao.getUsuario());
		noticia.setDataDePublicacao(new Date());
		noticia = noticiaDao.merge(noticia);
		noticia = tagService.criarTags(noticia, tagsEmTexto);
		noticia = noticiaDao.merge(noticia);

		return noticia;
	}

	public Noticia atualizar(Noticia noticia) {

		Noticia noticiaDoBancoDeDados = noticiaDao.get(noticia.getId());
		noticia.setDataDePublicacao(noticiaDoBancoDeDados.getDataDePublicacao());
		noticia.setPublicadoPor(noticiaDoBancoDeDados.getPublicadoPor());
		noticia.setEditadoPor(sessao.getUsuario());
		noticia.setDataEdicao(new Date());
		String tagsEmTexto = noticia.getTagsEmTexto();
		noticia = noticiaDao.merge(noticia);
		noticia = tagService.criarTags(noticia, tagsEmTexto);
		noticia = noticiaDao.merge(noticia);

		return noticia;
	}

}
