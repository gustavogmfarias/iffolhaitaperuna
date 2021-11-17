package br.com.iffolhaitap.dao;

import javax.enterprise.context.RequestScoped;

import org.hibernate.Criteria;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.iffolhaitap.model.Video;
import br.com.iffolhaitap.paginacao.Paginacao;

@RequestScoped
public class VideoDao extends HibernateDao<Video> {

	@SuppressWarnings("unchecked")
	public Paginacao<Video> lista(String busca, Integer paginaAtual) {
		if (busca == null) {
			busca = "";
		}

		Conjunction conjuctionPaginacao = Restrictions.conjunction();
		conjuctionPaginacao.add(Restrictions.ilike("descricao", busca, MatchMode.ANYWHERE));

		Paginacao<Video> paginacao = paginar(conjuctionPaginacao, paginaAtual, Order.asc("descricao"));

		return paginacao;

	}

	public boolean existeVideoPorLink(String link) {

		Criteria criteria = session.createCriteria(classePersistida);
		criteria.add(Restrictions.eq("link", link));

		return criteria.list().size() > 0;
	}

	public Video procuraPorLink(String link) {

		Criteria criteria = session.createCriteria(classePersistida);
		criteria.add(Restrictions.eq("link", link));

		return (Video) criteria.uniqueResult();

	}

}