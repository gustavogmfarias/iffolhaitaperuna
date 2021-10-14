package br.com.iffolhaitap.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.com.iffolhaitap.model.Curso;

@RequestScoped
public class CursoDao extends HibernateDao<Curso> {

	@SuppressWarnings("unchecked")
	public List<Curso> lista(String busca) {
		if (busca == null) {
			busca = "";
		}

		Criteria criteria = session.createCriteria(classePersistida);
		criteria.add(Restrictions.ilike("nome", busca, MatchMode.ANYWHERE));
		
		return criteria.list();
		
		}

	public boolean existeCursoPorNome(String nome) {

		Criteria criteria = session.createCriteria(classePersistida);
		criteria.add(Restrictions.eq("nome", nome));
		
		return criteria.list().size()>0;
	}

	public Curso procuraPorNome(String nome) {


		Criteria criteria = session.createCriteria(classePersistida);
		criteria.add(Restrictions.eq("nome", nome));
		
		return (Curso) criteria.uniqueResult();
		
	}


	
	
	
}