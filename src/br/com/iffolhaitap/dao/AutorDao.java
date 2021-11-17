package br.com.iffolhaitap.dao;

import javax.enterprise.context.RequestScoped;

import org.hibernate.Criteria;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.iffolhaitap.model.Autor;
import br.com.iffolhaitap.paginacao.Paginacao;

@RequestScoped
public class AutorDao extends HibernateDao<Autor> {

	@SuppressWarnings("unchecked")
	public Paginacao<Autor> lista(String busca, Integer paginaAtual) {
		if (busca == null) {
			busca = "";
		}

		Conjunction conjuctionPaginacao = Restrictions.conjunction();
		conjuctionPaginacao.add(Restrictions.ilike("nome", busca, MatchMode.ANYWHERE));

		Paginacao<Autor> paginacao = paginar(conjuctionPaginacao, paginaAtual, Order.asc("nome"));

		return paginacao;

	}

	public boolean existeAutorPorEmail(String email) {

		Criteria criteria = session.createCriteria(classePersistida);
		criteria.add(Restrictions.eq("email", email));

		return criteria.list().size() > 0;
	}

	public Autor procuraPorEmail(String email) {

		Criteria criteria = session.createCriteria(classePersistida);
		criteria.add(Restrictions.eq("email", email));

		return (Autor) criteria.uniqueResult();

	}

}