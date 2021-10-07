package br.com.iffolhaitap.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.com.iffolhaitap.model.Usuario;

@RequestScoped
public class UsuarioDao extends HibernateDao<Usuario> {

	@SuppressWarnings("unchecked")
	public List<Usuario> lista(String busca) {
		if (busca == null) {
			busca = "";
		}

		Criteria criteria = session.createCriteria(classePersistida);
		criteria.add(Restrictions.ilike("nome", busca, MatchMode.ANYWHERE));
		
		return criteria.list();
		
		}

	public boolean existeUsuarioPorEmail(String email) {

		Criteria criteria = session.createCriteria(classePersistida);
		criteria.add(Restrictions.eq("email", email));
		
		return criteria.list().size()>0;
	}

	public Usuario procuraPorEmail(String email) {


		Criteria criteria = session.createCriteria(classePersistida);
		criteria.add(Restrictions.eq("email", email));
		
		return (Usuario) criteria.uniqueResult();
		
	}


	
	
	
}