package br.com.iffolhaitap.service;

import java.io.File;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.caelum.vraptor.observer.upload.UploadedFile;
import br.com.iffolhaitap.dao.ConfiguracaoDao;
import br.com.iffolhaitap.model.Configuracao;
import br.com.iffolhaitap.util.Sessao;

@RequestScoped
public class ConfiguracaoService {

	@Inject
	private Sessao sessao;
	@Inject
	private ConfiguracaoDao configuracaoDao;
	@Inject
	private LogService logService;

	public Configuracao atualizar(Configuracao configuracao, UploadedFile logo, UploadedFile favicon) throws Exception {

		if (logo != null) {
			File fotoSalva = new File("C:\\Workspace\\iffolha\\WebContent\\img\\imagens-config", logo.getFileName());
			logo.writeTo(fotoSalva);
			configuracao.setLogo(logo.getFileName());
		}

		if (favicon != null) {
			File fotoSalva = new File("C:\\Workspace\\iffolha\\WebContent\\img\\imagens-config", favicon.getFileName());
			favicon.writeTo(fotoSalva);
			configuracao.setFavicon(favicon.getFileName());
		}

		configuracao = configuracaoDao.merge(configuracao);
		logService.criarLog("CONFIGURACOES-ATUALIZAR", configuracao.toString());

		return configuracao;
	}

}
