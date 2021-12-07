package br.com.iffolhaitap.dao;

import javax.enterprise.context.RequestScoped;

import org.hibernate.Criteria;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.iffolhaitap.model.Newsletter;
import br.com.iffolhaitap.paginacao.Paginacao;

@RequestScoped
public class NewsletterDao extends HibernateDao<Newsletter> {

	@SuppressWarnings("unchecked")
	public Paginacao<Newsletter> lista(String busca, Integer paginaAtual) {
		if (busca == null) {
			busca = "";
		}

		Conjunction conjuctionPaginacao = Restrictions.conjunction();
		conjuctionPaginacao.add(Restrictions.ilike("email", busca, MatchMode.ANYWHERE));

		Paginacao<Newsletter> paginacao = paginar(conjuctionPaginacao, paginaAtual, Order.asc("email"));

		return paginacao;

	}

	public boolean existeNewsletterPorEmail(String email) {

		Criteria criteria = session.createCriteria(classePersistida);
		criteria.add(Restrictions.eq("email", email));

		return criteria.list().size()>0;
	}

	public Newsletter procuraPorEmail(String email) {


		Criteria criteria = session.createCriteria(classePersistida);
		criteria.add(Restrictions.eq("email", email));

		return (Newsletter) criteria.uniqueResult();

	}





}