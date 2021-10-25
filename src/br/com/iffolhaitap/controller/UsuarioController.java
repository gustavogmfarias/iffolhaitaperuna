package br.com.iffolhaitap.controller;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.observer.upload.UploadedFile;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.iffolhaitap.dao.UsuarioDao;
import br.com.iffolhaitap.model.Usuario;
import br.com.iffolhaitap.service.UsuarioService;
import br.com.iffolhaitap.util.HibernateUtil;
import br.com.iffolhaitap.util.Sessao;

@Controller
public class UsuarioController {

	@Inject private Result result;
	@Inject private UsuarioDao usuarioDao;
	@Inject private Validator validator;
	@Inject private Sessao sessao;
	@Inject private UsuarioService usuarioService;
	

	@Get("/adm/usuarios")
	public void lista(String busca) {
		List<Usuario> usuarios = usuarioDao.lista(busca);
		result.include("usuarioList", usuarios);
		result.include("busca", busca);

	}

	@Get("/adm/usuarios/novo")
	public void novo() {

	}

	@Post("/adm/usuarios")
	public void adiciona(@Valid Usuario usuario, UploadedFile imagemUsuario) throws IOException {

		try {
			HibernateUtil.beginTransaction();
			usuarioService.adiciona(usuario, imagemUsuario);
			HibernateUtil.commit();
		} catch (Exception e) {
			HibernateUtil.rollback();
			validator.add(new SimpleMessage("error", e.getMessage()));
			validator.onErrorRedirectTo(this).novo();
		}
		
		result.include("mensagem", "Usuario adicionado com sucesso");
		result.redirectTo(this).lista("");

	}

	@Get("/adm/usuarios/{usuario.id}/editar")
	public void editar(Usuario usuario) {
		result.include("usuario", usuarioDao.get(usuario.getId()));
	}

	@Post("/adm/usuarios/editar")
	public void atualizar(@Valid Usuario usuario, UploadedFile imagemUsuario) throws IOException {

		try {

			HibernateUtil.beginTransaction();
			usuarioService.atualizar(usuario, imagemUsuario);
			HibernateUtil.commit();

		} catch (Exception e) {
			HibernateUtil.rollback();
			validator.add(new SimpleMessage("error", e.getMessage()));
			validator.onErrorRedirectTo(this).editar(usuario);
		}

		result.include("mensagem", "Usuario atualizado com sucesso");

		result.redirectTo(this).lista("");

	}

	@Get("/adm/usuarios/{usuario.id}/apagar")
	public void remove(Usuario usuario) {

		try {

			HibernateUtil.beginTransaction();
			usuarioDao.remove(usuario);
			HibernateUtil.commit();
			result.include("mensagem", "Usuario removido com sucesso");
			result.redirectTo(this).lista("");
		} catch (Exception e) {
			HibernateUtil.rollback();
			validator.add(new SimpleMessage("error", "Transa��o n�o Efetuada"));
			validator.onErrorRedirectTo(this).lista("");
		}

	}

	@Get("/adm/alterarminhasenha")
	public void mudarMinhaSenha() {
		Usuario usuarioBd = usuarioDao.get(sessao.getUsuario().getId());
		result.include("usuario", usuarioBd);
	}

	@Post("/adm/alterarminhasenha")
	public void minhaSenha(Usuario usuario) {

		Usuario usuarioBd = usuarioDao.get(usuario.getId());

		if (!usuarioBd.getSenha().equals(usuario.getSenhaAntiga())) {
			validator.add(new SimpleMessage("error", "Senha atual inv�lida"));
			validator.onErrorRedirectTo(this).mudarMinhaSenha();
		}
		

		if (!usuario.getSenhaConfirmacao().equals(usuario.getSenha())) {
			validator.add(new SimpleMessage("error", "Senhas n�o coincidem"));
			validator.onErrorRedirectTo(this).mudarMinhaSenha();
		}

		try {
			HibernateUtil.beginTransaction();
			usuarioBd.setSenha(usuario.getSenha());
			usuarioDao.atualizar(usuarioBd);
			HibernateUtil.commit();
		} catch (Exception e) {
			HibernateUtil.rollback();
			validator.add(new SimpleMessage("error", "Transa��o n�o Efetuada"));
			result.redirectTo(this).mudarMinhaSenha();
		}
		result.include("message", "Senha atualizada com sucesso");
		result.redirectTo(this).mudarMinhaSenha();
	}

}
