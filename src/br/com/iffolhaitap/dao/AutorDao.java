package br.com.iffolhaitap.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.com.iffolhaitap.model.Autor;

@RequestScoped
public class AutorDao extends HibernateDao<Autor> {

	@SuppressWarnings("unchecked")
	public List<Autor> lista(String busca) {
		if (busca == null) {
			busca = "";
		}

		Criteria criteria = session.createCriteria(classePersistida);
		criteria.add(Restrictions.ilike("nome", busca, MatchMode.ANYWHERE));
		
		return criteria.list();
		
		}

	public boolean existeAutorPorEmail(String email) {

		Criteria criteria = session.createCriteria(classePersistida);
		criteria.add(Restrictions.eq("email", email));
		
		return criteria.list().size()>0;
	}

	public Autor procuraPorEmail(String email) {


		Criteria criteria = session.createCriteria(classePersistida);
		criteria.add(Restrictions.eq("email", email));
		
		return (Autor) criteria.uniqueResult();
		
	}


	
	
	
}