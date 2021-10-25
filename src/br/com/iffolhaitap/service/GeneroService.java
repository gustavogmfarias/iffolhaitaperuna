package br.com.iffolhaitap.service;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.iffolhaitap.dao.GeneroTextoDao;
import br.com.iffolhaitap.model.GeneroTexto;

@RequestScoped
public class GeneroService {

	@Inject private GeneroTextoDao generoDao;

	public void adiciona(GeneroTexto generoTexto) throws Exception {

		
		if (generoDao.existeGeneroTextoPorNome(generoTexto.getGenero())) {
			throw new Exception("J� existe um G�nero de Texto cadastrado com esse genero");
		}
		
		generoDao.adiciona(generoTexto);

	}
	
	
	
}
