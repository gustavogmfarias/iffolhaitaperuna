package br.com.iffolhaitap.dao;

import javax.enterprise.context.RequestScoped;

import org.hibernate.Criteria;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.iffolhaitap.model.Noticia;
import br.com.iffolhaitap.paginacao.Paginacao;

@RequestScoped
public class NoticiaDao extends HibernateDao<Noticia> {

	@SuppressWarnings("unchecked")
	public Paginacao<Noticia> lista(String busca, Integer paginaAtual, Boolean ehDestaque) {
		if (busca == null) {
			busca = "";
		}

		Conjunction conjuctionPaginacao = Restrictions.conjunction();
		conjuctionPaginacao.add(Restrictions.ilike("titulo", busca, MatchMode.ANYWHERE));

		if (ehDestaque != null && ehDestaque == true) {
			conjuctionPaginacao.add(Restrictions.eq("ehDestaque", ehDestaque));
		}

		Paginacao<Noticia> paginacao = paginar(conjuctionPaginacao, paginaAtual, Order.desc("id"));

		return paginacao;

	}

}