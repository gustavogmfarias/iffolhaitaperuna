package br.com.iffolhaitap.service;

import java.io.File;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.caelum.vraptor.observer.upload.UploadedFile;
import br.com.iffolhaitap.dao.AutorDao;
import br.com.iffolhaitap.model.Autor;

@RequestScoped
public class AutorService {

	@Inject AutorDao autorDao;
	@Inject LogService logService;

	public void adiciona(Autor autor, UploadedFile imagemAutor) throws Exception {
		
		if (imagemAutor != null) {
			File fotoSalva = new File("C:\\Workspace\\iffolha\\WebContent\\img\\imagens-autor",
					imagemAutor.getFileName());
			imagemAutor.writeTo(fotoSalva);
			autor.setImagem(imagemAutor.getFileName());
		}

		if (autorDao.existeAutorPorEmail(autor.getEmail())) {

			throw new Exception("Já existe autor cadastrado com esse e-mail");

		}
		
		
		
		autorDao.adiciona(autor);
		logService.criarLog("AUTOR-ADICIONAR", autor.toString());
		
	}

	public void atualizar(Autor autor, UploadedFile imagemAutor) throws Exception {
		
		if (imagemAutor != null) {
			File fotoSalva = new File("C:\\Workspace\\iffolha\\WebContent\\img\\imagens-autor",
					imagemAutor.getFileName());
			imagemAutor.writeTo(fotoSalva);
			autor.setImagem(imagemAutor.getFileName());
		}

		if (autorDao.existeAutorPorEmail(autor.getEmail()) && !autor.getEmail().equals(autor.getNovoEmail())) {

			throw new Exception("Já existe autor cadastrado com esse e-mail");

		}
		
		autorDao.atualizar(autor);
		logService.criarLog("AUTOR-ATUALIZAR", autor.toString());
	
	}
	
	public void remove(Autor autor) {
		
		autor = autorDao.get(autor.getId());
		autorDao.remove(autor);
		logService.criarLog("AUTOR-REMOVER", autor.toString());


		
	}
	
	
}
