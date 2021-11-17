package br.com.iffolhaitap.service;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.iffolhaitap.dao.UsuarioDao;
import br.com.iffolhaitap.model.Usuario;
import br.com.iffolhaitap.util.HibernateUtil;
import br.com.iffolhaitap.util.Sessao;

@RequestScoped
public class LoginService {

	@Inject private UsuarioDao usuarioDao;
	@Inject private Sessao sessao;
	@Inject private LogService logService;

	public void logar(Usuario usuario) throws Exception {

		Usuario usuarioBanco = usuarioDao.procuraPorEmail(usuario.getEmail());

		if (usuarioBanco == null) {
			throw new Exception("Usuário não encontrado");
		}

		if (!usuarioBanco.getSenha().equals(usuario.getSenha())) {
			throw new Exception("Senha inválida");
		}

		sessao.setUsuario(usuarioBanco);


		
	}
	
	
	
}
