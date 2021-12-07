package br.com.iffolhaitap.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;

import org.hibernate.Criteria;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.iffolhaitap.model.Artigo;
import br.com.iffolhaitap.model.GeneroTexto;
import br.com.iffolhaitap.model.Noticia;
import br.com.iffolhaitap.model.Tag;
import br.com.iffolhaitap.paginacao.Paginacao;

@RequestScoped
public class ArtigoDao extends HibernateDao<Artigo> {

	@SuppressWarnings("unchecked")
	public Paginacao<Artigo> lista(String busca, Integer paginaAtual, GeneroTexto genero, Tag tag) {
		if (busca == null) {
			busca = "";
		}

		Conjunction conjuctionPaginacao = Restrictions.conjunction();
		conjuctionPaginacao.add(Restrictions.ilike("titulo", busca, MatchMode.ANYWHERE));

		if (genero != null && genero.getId()>0) {
			conjuctionPaginacao.add(Restrictions.eq("genero", genero));
		}

		if (tag != null && tag.getId() > 0) {
			conjuctionPaginacao.add(Restrictions.eq("tags.id", tag.getId()));
			return paginar(conjuctionPaginacao, paginaAtual, Order.desc("id"), "tags");
		} else {
			return paginar(conjuctionPaginacao, paginaAtual, Order.desc("id"));
		}

	}

	public Artigo procuraPorUrl(Artigo artigo) {

		Criteria criteria = session.createCriteria(classePersistida);
		criteria.add(Restrictions.eq("url", artigo.getUrl()));

		return (Artigo) criteria.uniqueResult();

	}

	public List<Artigo> buscarTresUltimosArtigos() {
		Criteria criteria = session.createCriteria(classePersistida);
		criteria.addOrder(Order.desc("id"));
		criteria.setMaxResults(3);
		return criteria.list();
	}



}