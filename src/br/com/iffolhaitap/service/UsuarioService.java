package br.com.iffolhaitap.service;

import java.io.File;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.caelum.vraptor.observer.upload.UploadedFile;
import br.com.iffolhaitap.dao.UsuarioDao;
import br.com.iffolhaitap.model.Usuario;

@RequestScoped
public class UsuarioService {

	@Inject UsuarioDao usuarioDao;
	@Inject LogService logService;
	
	public void adiciona(Usuario usuario, UploadedFile imagemUsuario) throws Exception {
		
		if (imagemUsuario != null) {
			File fotoSalva = new File("C:\\Workspace\\iffolha\\WebContent\\img\\imagens-usuario", imagemUsuario.getFileName());
			imagemUsuario.writeTo(fotoSalva);
			usuario.setImagem(imagemUsuario.getFileName());
		}

		if (usuario.getPerfil() == null) {
			throw new Exception("Por favor, escolha um tipo de perfil para o usuário");
		}

		if (usuarioDao.existeUsuarioPorEmail(usuario.getEmail())) {
			throw new Exception("Já existe usuário cadastrado com esse e-mail");
		}

		usuarioDao.adiciona(usuario);
		logService.criarLog("USUARIO-ADICIONA", usuario.toString());
		
	}


	public void atualizar(Usuario usuario, UploadedFile imagemUsuario) throws Exception {
		
		if (imagemUsuario != null) {
			File fotoSalva = new File("C:\\Workspace\\iffolha\\WebContent\\img\\imagens-usuario",
					imagemUsuario.getFileName());
			imagemUsuario.writeTo(fotoSalva);
			usuario.setImagem(imagemUsuario.getFileName());
		}
		
		if (usuario.getPerfil() == null) {
			throw new Exception("Por favor, escolha um tipo de perfil para o usuário");

		}

		
		if (usuarioDao.existeUsuarioPorEmail(usuario.getEmail()) && !usuario.getEmail().equals(usuario.getNovoEmail())) {

			throw new Exception("Já existe usuário cadastrado com esse e-mail");

		}
		
		usuarioDao.atualizar(usuario);
		logService.criarLog("USUARIO-ATUALIZAR", usuario.toString());

	}


	public void remove(Usuario usuario) {
		
		usuario = usuarioDao.get(usuario.getId());
		usuarioDao.remove(usuario);
		logService.criarLog("USUARIO-REMOVER", usuario.toString());


		
	}


	

}
