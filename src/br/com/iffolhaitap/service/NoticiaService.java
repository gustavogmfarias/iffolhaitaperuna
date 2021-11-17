package br.com.iffolhaitap.service;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.caelum.vraptor.observer.upload.UploadedFile;
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
	@Inject private LogService logService;

	public Noticia adicionar(Noticia noticia, UploadedFile imagemNoticia) throws Exception {

		if (imagemNoticia != null) {
			File fotoSalva = new File("C:\\Workspace\\iffolha\\WebContent\\img\\imagens-noticia", imagemNoticia.getFileName());
			imagemNoticia.writeTo(fotoSalva);
			noticia.setImagemPrincipal(imagemNoticia.getFileName()); }

		String tagsEmTexto = noticia.getTagsEmTexto();
		noticia.setPublicadoPor(sessao.getUsuario());
		noticia.setDataDePublicacao(new Date());
		noticia = noticiaDao.merge(noticia);
		noticia = tagService.criarTags(noticia, tagsEmTexto);
		noticia = noticiaDao.merge(noticia);
		logService.criarLog("NOTICIA-ADICIONAR", noticia.toString());

		return noticia;
	}

	public Noticia atualizar(Noticia noticia, UploadedFile imagemNoticia) throws Exception {

		if (imagemNoticia != null) {
			File fotoSalva = new File("C:\\Workspace\\iffolha\\WebContent\\img\\imagens-noticia", imagemNoticia.getFileName());
			imagemNoticia.writeTo(fotoSalva);
			noticia.setImagemPrincipal(imagemNoticia.getFileName()); }

		Noticia noticiaDoBancoDeDados = noticiaDao.get(noticia.getId());
		noticia.setDataDePublicacao(noticiaDoBancoDeDados.getDataDePublicacao());
		noticia.setPublicadoPor(noticiaDoBancoDeDados.getPublicadoPor());
		noticia.setEditadoPor(sessao.getUsuario());
		noticia.setDataEdicao(new Date());
		String tagsEmTexto = noticia.getTagsEmTexto();
		noticia = noticiaDao.merge(noticia);
		noticia = tagService.criarTags(noticia, tagsEmTexto);
		noticia = noticiaDao.merge(noticia);
		logService.criarLog("NOTICIA-ATUALIZAR", noticia.toString());

		return noticia;
	}

	public void remove(Noticia noticia) {

		noticia = noticiaDao.get(noticia.getId());
		noticiaDao.remove(noticia);
		logService.criarLog("NOTICIA-REMOVER", noticia.toString());

	}



}
