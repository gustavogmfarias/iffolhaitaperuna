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

	@Get("/adm/login")
	public void login() {

	}

	@Post("/adm/logar")
	public void logar(Usuario usuario) {
		Usuario usuarioBanco = usuarioDao.procuraPorEmail(usuario.getEmail());

		if (usuarioBanco == null) {
			validator.add(new SimpleMessage("error", "Usuário não encontrado"));
			validator.onErrorRedirectTo(this).login();
		}

		if (!usuarioBanco.getSenha().equals(usuario.getSenha())) {
			validator.add(new SimpleMessage("error", "Senha inválida"));
			validator.onErrorRedirectTo(this).login();
		}

		sessao.setUsuario(usuarioBanco);
		result.include("message", "Usuário logado com sucesso");
		result.redirectTo(IndexController.class).inicio();

	}

	@Get("/adm/sair")
	public void sair() {

		sessao.setUsuario(null);
		result.redirectTo(this).login();

	}

}
