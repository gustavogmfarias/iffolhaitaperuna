package br.com.iffolhaitap.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.com.iffolhaitap.model.Noticia;

@RequestScoped
public class NoticiaDao extends HibernateDao<Noticia> {

	@SuppressWarnings("unchecked")
	public List<Noticia> lista(String busca, Boolean ehDestaque) {
		if (busca == null) {
			busca = "";
		}

		Criteria criteria = session.createCriteria(classePersistida);
		criteria.add(Restrictions.ilike("titulo", busca, MatchMode.ANYWHERE));
		
		if(ehDestaque!=null) {
			criteria.add(Restrictions.eq("ehDestaque", ehDestaque));
			
		}
		return criteria.list();
		
		}

	
	
	
}