package br.com.iffolhaitap.dao;

import javax.enterprise.context.RequestScoped;

import javax.persistence.Entity;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.iffolhaitap.model.Log;
import br.com.iffolhaitap.paginacao.Paginacao;

@Entity
@RequestScoped
public class LogDao extends HibernateDao<Log> {

	@SuppressWarnings("unchecked")
	public Paginacao<Log> lista(String busca, Integer paginaAtual) {
		if (busca == null) {
			busca = "";
		}

		Conjunction conjuctionPaginacao = Restrictions.conjunction();
		conjuctionPaginacao.add(Restrictions.ilike("titulo", busca, MatchMode.ANYWHERE));

		Paginacao<Log> paginacao = paginar(conjuctionPaginacao, paginaAtual, Order.desc("id"));
		
		return paginacao;

	}

}