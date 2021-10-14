package br.com.iffolhaitap.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.com.iffolhaitap.model.Turma;

@RequestScoped
public class TurmaDao extends HibernateDao<Turma> {

	@SuppressWarnings("unchecked")
	public List<Turma> lista(String busca) {
		if (busca == null) {
			busca = "";
		}

		Criteria criteria = session.createCriteria(classePersistida);
		criteria.add(Restrictions.ilike("nome", busca, MatchMode.ANYWHERE));
		
		return criteria.list();
		
		}

	public boolean existeTurmaPorNome(String nome) {

		Criteria criteria = session.createCriteria(classePersistida);
		criteria.add(Restrictions.eq("nome", nome));
		
		return criteria.list().size()>0;
	}

	public Turma procuraPorNome(String nome) {


		Criteria criteria = session.createCriteria(classePersistida);
		criteria.add(Restrictions.eq("nome", nome));
		
		return (Turma) criteria.uniqueResult();
		
	}


	
	
	
}