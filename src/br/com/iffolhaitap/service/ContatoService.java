package br.com.iffolhaitap.service;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.caelum.vraptor.observer.upload.UploadedFile;
import br.com.iffolhaitap.dao.ContatoDao;
import br.com.iffolhaitap.model.Contato;
import br.com.iffolhaitap.util.Sessao;

@RequestScoped
public class ContatoService {

	@Inject
	private Sessao sessao;
	@Inject
	private ContatoDao contatoDao;
	@Inject
	private TagService tagService;
	@Inject
	private LogService logService;

	public Contato adicionar(Contato contato) throws Exception {

		contato.setDataDoEnvio(new Date());
		contato = contatoDao.merge(contato);
		logService.criarLog("CONTATO-ADICIONAR", contato.toString());

		return contato;
	}

	public Contato atualizar(Contato contato) throws Exception {

		Contato contatoDoBancoDeDados = contatoDao.get(contato.getId());

		if (contato.getEstaRespondido() == true && contatoDoBancoDeDados.getEstaRespondido() == null ) {
			contato.setDataDeResposta(new Date());
			contato.setRespondidoPor(sessao.getUsuario());
		}
		contato = contatoDao.merge(contato);
		logService.criarLog("CONTATO-ATUALIZAR", contato.toString());

		return contato;
	}

	public void remove(Contato contato) {

		contato = contatoDao.get(contato.getId());
		contatoDao.remove(contato);
		logService.criarLog("CONTATO-REMOVER", contato.toString());

	}

}
