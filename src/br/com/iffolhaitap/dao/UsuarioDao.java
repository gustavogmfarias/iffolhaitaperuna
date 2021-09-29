package br.com.iffolhaitap.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.iffolhaitap.model.Usuario;

public class UsuarioDao {

	private final EntityManager em;

	@Inject
	public UsuarioDao(EntityManager em) {
		this.em = em;
	}

	public UsuarioDao() {

		this(null);

	}

	public void adiciona(Usuario usuario) {

		em.persist(usuario);
	}

	public void atualizar(Usuario usuario) {

		em.merge(usuario);
	}

	public void remove(Usuario usuario) {

		em.remove(busca(usuario));

	}

	public Usuario busca(Usuario usuario) {
		return em.find(Usuario.class, usuario.getId());
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> lista(String busca) {
		if (busca == null) {
			busca = "";
		}

		Query query = em.createQuery("select p from Usuario u where lower(u.nome) like :busca ");

		query.setParameter("busca", "%" + busca.toLowerCase() + "%");

		return query.getResultList();
	}
}