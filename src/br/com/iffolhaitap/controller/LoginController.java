package br.com.iffolhaitap.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.iffolhaitap.dao.UsuarioDao;
import br.com.iffolhaitap.model.Usuario;
import br.com.iffolhaitap.service.LogService;
import br.com.iffolhaitap.service.LoginService;
import br.com.iffolhaitap.util.Sessao;

@Controller
public class LoginController {

	@Inject
	private Result result;
	@Inject
	private UsuarioDao usuarioDao;
	@Inject
	private Validator validator;
	@Inject
	private Sessao sessao;
	@Inject
	private LoginService loginService;
	@Inject
	private LogService logService;

	@Get("/adm/login")
	public void login() {

	}

	@Post("/adm/logar")
	public void logar(Usuario usuario) {

		try {
			loginService.logar(usuario);
		} catch (Exception e) {
			validator.add(new SimpleMessage("error", e.getMessage()));
			validator.onErrorRedirectTo(this).login();
		}
		
		result.include("message", "Usuário logado com sucesso");

		if (sessao.temUrlContinuacao()) {
			result.redirectTo(sessao.getUrlContinuacao());
		} else {
			result.redirectTo(IndexController.class).inicio();
		}
	}

	@Get("/adm/sair")
	public void sair() {

		Usuario usuario = new Usuario();
		usuario = sessao.getUsuario();
		sessao.setUsuario(null);
		logService.criarLog("USUARIO-DESLOGADO", usuario.toString());
		result.redirectTo(this).login();

	}

}
