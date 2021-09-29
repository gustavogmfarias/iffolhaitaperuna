package br.com.iffolhaitap.controller;

import java.io.File;
import java.io.IOException;

import javax.inject.Inject;
import javax.validation.Valid;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.observer.upload.UploadedFile;
import br.com.caelum.vraptor.validator.Validator;
import br.com.iffolhaitap.dao.UsuarioDao;
import br.com.iffolhaitap.model.Usuario;

@Controller
public class UsuarioController {


	private final Result result;
	private final UsuarioDao dao;
	private final Validator validator;

	@Inject
	public UsuarioController(Result result, UsuarioDao dao, Validator validator) {
		this.result = result;
		this.dao = dao;
		this.validator = validator;

	}

	public UsuarioController() {
		this(null, null, null);
		
	}

	public void lista(String busca) {

		result.include("usuarioList", dao.lista(busca));
	}

	@Get
	public void novo() {

	}

	@Post
	public void adiciona(@Valid Usuario usuario, UploadedFile imagemUsuario) throws IOException {

		File fotoSalva = new File("C:\\Workspace\\iffolha\\WebContent\\img\\imagens-usuario", imagemUsuario.getFileName());
		imagemUsuario.writeTo(fotoSalva);

		usuario.setImagem(imagemUsuario.getFileName());

		validator.onErrorUsePageOf(this).novo();
		dao.adiciona(usuario);
		result.include("mensagem", "Usuario adicionado com sucesso");

		result.redirectTo(this).lista("");

	}

	@Get
	public void editar(Usuario usuario) {
		result.include("usuario", dao.busca(usuario));
	}

	@Post
	public void atualizar(@Valid Usuario usuario, UploadedFile imagemUsuario) throws IOException {

		if (imagemUsuario != null) {
			File fotoSalva = new File("C:\\Workspace\\iffolha\\WebContent\\imagens-Usuario",
					imagemUsuario.getFileName());
			imagemUsuario.writeTo(fotoSalva);
			usuario.setImagem(imagemUsuario.getFileName());
		}

		validator.onErrorUsePageOf(this).novo();
		dao.atualizar(usuario);
		result.include("mensagem", "Usuario atualizado com sucesso");

		result.redirectTo(this).lista("");

	}

	@Get
	public void remove(Usuario usuario) {

		dao.remove(usuario);
	}

}