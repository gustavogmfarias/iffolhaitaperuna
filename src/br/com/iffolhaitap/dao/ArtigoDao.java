package br.com.iffolhaitap.dao;

import javax.enterprise.context.RequestScoped;

import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.iffolhaitap.model.Artigo;
import br.com.iffolhaitap.paginacao.Paginacao;

@RequestScoped
public class ArtigoDao extends HibernateDao<Artigo> {

	@SuppressWarnings("unchecked")
	public Paginacao<Artigo> lista(String busca, Integer paginaAtual) {
		if (busca == null) {
			busca = "";
		}

		Conjunction conjuctionPaginacao = Restrictions.conjunction();
		conjuctionPaginacao.add(Restrictions.ilike("titulo", busca, MatchMode.ANYWHERE));
	
		Paginacao<Artigo> paginacao = paginar(conjuctionPaginacao, paginaAtual, Order.desc("id"));
		

		return paginacao;

	}

	
	
	
}