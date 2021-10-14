package br.com.iffolhaitap.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.com.iffolhaitap.model.GeneroTexto;

@RequestScoped
public class GeneroTextoDao extends HibernateDao<GeneroTexto> {

	@SuppressWarnings("unchecked")
	public List<GeneroTexto> lista(String busca) {
		if (busca == null) {
			busca = "";
		}

		Criteria criteria = session.createCriteria(classePersistida);
		criteria.add(Restrictions.ilike("genero", busca, MatchMode.ANYWHERE));
		
		return criteria.list();
		
		}

	public boolean existeGeneroTextoPorNome(String genero) {

		Criteria criteria = session.createCriteria(classePersistida);
		criteria.add(Restrictions.eq("genero", genero));
		
		return criteria.list().size()>0;
	}

	public GeneroTexto procuraPorNome(String genero) {


		Criteria criteria = session.createCriteria(classePersistida);
		criteria.add(Restrictions.eq("genero", genero));
		
		return (GeneroTexto) criteria.uniqueResult();
		
	}


	
	
	
}