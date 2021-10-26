package br.com.iffolhaitap.service;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.iffolhaitap.dao.GeneroTextoDao;
import br.com.iffolhaitap.model.GeneroTexto;

@RequestScoped
public class GeneroService {

	@Inject private GeneroTextoDao generoDao;
	@Inject private LogService logService;

	public void adiciona(GeneroTexto generoTexto) throws Exception {

		
		if (generoDao.existeGeneroTextoPorNome(generoTexto.getGenero())) {
			throw new Exception("Já existe um Gênero de Texto cadastrado com esse genero");
		}
		
		generoDao.adiciona(generoTexto);
		logService.criarLog("GENEROTEXTO-ADICIONAR", generoTexto.toString());

	}
	
	public void remove(GeneroTexto generoTexto) {
		
		generoTexto = generoDao.get(generoTexto.getId());
		generoDao.remove(generoTexto);
		logService.criarLog("GENEROTEXTO-REMOVER", generoTexto.toString());


		
	}
	
}
