package br.com.iffolhaitap.service;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.caelum.vraptor.observer.upload.UploadedFile;
import br.com.iffolhaitap.dao.ArtigoDao;
import br.com.iffolhaitap.model.Artigo;
import br.com.iffolhaitap.util.Sessao;

@RequestScoped
public class ArtigoService {

	@Inject
	private Sessao sessao;
	@Inject
	private ArtigoDao artigoDao;
	@Inject private TagService tagService;
	@Inject private LogService logService;
	
	public Artigo adicionar(Artigo artigo, UploadedFile imagemArtigo) throws Exception {
		
		if (imagemArtigo != null) {
			File fotoSalva = new File("C:\\Workspace\\iffolha\\WebContent\\img\\imagens-artigo", imagemArtigo.getFileName());
			imagemArtigo.writeTo(fotoSalva);
			artigo.setImagemPrincipal(imagemArtigo.getFileName()); }
		
		String tagsEmTexto = artigo.getTagsEmTexto();
		artigo.setPublicadoPor(sessao.getUsuario());
		artigo.setDataDePublicacao(new Date());
		artigo = artigoDao.merge(artigo);
		artigo = tagService.criarTags(artigo, tagsEmTexto);
		artigo = artigoDao.merge(artigo);
		logService.criarLog("ARTIGO-ADICIONAR", artigo.toString());

		return artigo;
	}

	public Artigo atualizar(Artigo artigo, UploadedFile imagemArtigo) throws Exception {

		if (imagemArtigo != null) {
			File fotoSalva = new File("C:\\Workspace\\iffolha\\WebContent\\img\\imagens-artigo", imagemArtigo.getFileName());
			imagemArtigo.writeTo(fotoSalva);
			artigo.setImagemPrincipal(imagemArtigo.getFileName()); }
		
		Artigo artigoDoBancoDeDados = artigoDao.get(artigo.getId());
		artigo.setDataDePublicacao(artigoDoBancoDeDados.getDataDePublicacao());
		artigo.setPublicadoPor(artigoDoBancoDeDados.getPublicadoPor());
		artigo.setEditadoPor(sessao.getUsuario());
		artigo.setDataEdicao(new Date());
		String tagsEmTexto = artigo.getTagsEmTexto();
		artigo = artigoDao.merge(artigo);
		artigo = tagService.criarTags(artigo, tagsEmTexto);
		artigo = artigoDao.merge(artigo);
		logService.criarLog("ARTIGO-ATUALIZAR", artigo.toString());

		return artigo;
	}

	public void remove(Artigo artigo) {
		
		artigo = artigoDao.get(artigo.getId());
		artigoDao.remove(artigo);
		logService.criarLog("ARTIGO-REMOVER", artigo.toString());

	}
	
	

}
