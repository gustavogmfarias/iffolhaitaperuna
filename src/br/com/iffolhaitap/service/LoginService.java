package br.com.iffolhaitap.service;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.iffolhaitap.dao.UsuarioDao;
import br.com.iffolhaitap.model.Usuario;
import br.com.iffolhaitap.util.HibernateUtil;
import br.com.iffolhaitap.util.Sessao;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@RequestScoped
public class LoginService {

	@ManyToOne
	@Inject private UsuarioDao usuarioDao;
	@ManyToOne
	@Inject private Sessao sessao;
	@ManyToOne
	@Inject private LogService logService;

	public void logar(Usuario usuario) throws Exception {

		Usuario usuarioBanco = usuarioDao.procuraPorEmail(usuario.getEmail());

		if (usuarioBanco == null) {
			throw new Exception("Usu&aacute;rio no encontrado");
		}

		if (!usuarioBanco.getSenha().equals(usuario.getSenha())) {
			throw new Exception("Senha inv&aacute;lida");
		}

		sessao.setUsuario(usuarioBanco);



	}



}
