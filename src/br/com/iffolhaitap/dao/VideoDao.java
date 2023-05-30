package br.com.iffolhaitap.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;

import javax.persistence.Entity;
import org.hibernate.Criteria;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.iffolhaitap.model.Video;
import br.com.iffolhaitap.paginacao.Paginacao;

@Entity
@RequestScoped
public class VideoDao extends HibernateDao<Video> {

	@SuppressWarnings("unchecked")
	public Paginacao<Video> lista(String busca, Integer paginaAtual, Boolean ehDestaque) {
		if (busca == null) {
			busca = "";
		}
		Conjunction conjuctionPaginacao = Restrictions.conjunction();

		if (ehDestaque != null && ehDestaque == true) {
			conjuctionPaginacao.add(Restrictions.eq("ehDestaque", ehDestaque));
		}

		conjuctionPaginacao.add(Restrictions.ilike("descricao", busca, MatchMode.ANYWHERE));

		Paginacao<Video> paginacao = paginar(conjuctionPaginacao, paginaAtual, Order.desc("id"));

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

	public List<Video> pegarDestaque() {
		Criteria criteria = session.createCriteria(classePersistida);
		criteria.add(Restrictions.eq("ehDestaque", true));

		criteria.addOrder(Order.desc("id"));
		criteria.setMaxResults(4);

		return criteria.list();
	}

	public List<Video> buscarCincoUltimosVideos() {
		Criteria criteria = session.createCriteria(classePersistida);
		criteria.addOrder(Order.desc("id"));
		criteria.setMaxResults(5);
		return criteria.list();
	}

}