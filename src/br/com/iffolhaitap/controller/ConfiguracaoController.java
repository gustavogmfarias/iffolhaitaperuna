package br.com.iffolhaitap.controller;

import java.io.IOException;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.observer.upload.UploadedFile;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.iffolhaitap.annotation.Privado;
import br.com.iffolhaitap.dao.ConfiguracaoDao;
import br.com.iffolhaitap.model.Configuracao;
import br.com.iffolhaitap.model.Perfil;
import br.com.iffolhaitap.service.ConfiguracaoService;
import br.com.iffolhaitap.util.HibernateUtil;
import br.com.iffolhaitap.util.Sessao;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Controller
public class ConfiguracaoController {

	@Inject
	private Result result;
	@ManyToOne
	@Inject
	private ConfiguracaoDao configuracaoDao;
	@Inject
	private Validator validator;
	@ManyToOne
	@Inject
	private Sessao sessao;
	@ManyToOne
	@Inject
	private ConfiguracaoService configuracaoService;

	@Privado(Perfil.ADMINISTRADOR)
	@Get("/adm/config")
	public void configuracoes() {

		Configuracao configuracao = new Configuracao();
		configuracao = configuracaoDao.get(1l);
		result.include("configuracao", configuracao);

	}

	@Privado(Perfil.ADMINISTRADOR)
	@Post("/adm/config")
	public void configuracoes(Configuracao configuracao, UploadedFile configLogo, UploadedFile configFavIcon) throws IOException {
		

		try {

			HibernateUtil.beginTransaction();
			configuracao = configuracaoService.atualizar(configuracao, configLogo, configFavIcon);
			sessao.setConfiguracao(configuracao);
			sessao.setTitulo(configuracao.getTitulo());
			HibernateUtil.commit();

		} catch (Exception e) {
			HibernateUtil.rollback();
			e.printStackTrace();
			validator.add(new SimpleMessage("error", e.getMessage()));
			validator.onErrorRedirectTo(this).configuracoes();
		}
		result.include("mensagem", "Confirgura��o atualizada com sucesso");
		result.redirectTo(this).configuracoes();

	}

}