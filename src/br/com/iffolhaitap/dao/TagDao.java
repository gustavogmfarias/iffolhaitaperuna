package br.com.iffolhaitap.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;

import javax.persistence.Entity;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.com.iffolhaitap.model.Noticia;
import br.com.iffolhaitap.model.Tag;

@Entity
@RequestScoped
public class TagDao extends HibernateDao<Tag> {

	@SuppressWarnings("unchecked")
	public List<Tag> lista(String busca) {
		if (busca == null) {
			busca = "";
		}

		Criteria criteria = session.createCriteria(classePersistida);
		criteria.add(Restrictions.ilike("nome", busca, MatchMode.ANYWHERE));

		return criteria.list();

		}

	public boolean existeTagPorNome(String nome) {

		Criteria criteria = session.createCriteria(classePersistida);
		criteria.add(Restrictions.eq("nome", nome));

		return criteria.list().size()>0;
	}

	public Tag procuraPorNome(String nome) {


		Criteria criteria = session.createCriteria(classePersistida);
		criteria.add(Restrictions.eq("nome", nome));

		return (Tag) criteria.uniqueResult();

	}

	public Tag procuraPorUrl(Tag tag) {

		Criteria criteria = session.createCriteria(classePersistida);
		criteria.add(Restrictions.eq("url", tag.getUrl()));

		return (Tag) criteria.uniqueResult();

	}



}