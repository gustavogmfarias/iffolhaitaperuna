package br.com.iffolhaitap.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;

import javax.persistence.Entity;
import org.hibernate.Criteria;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.iffolhaitap.model.Noticia;
import br.com.iffolhaitap.model.Tag;
import br.com.iffolhaitap.paginacao.Paginacao;

@Entity
@RequestScoped
public class NoticiaDao extends HibernateDao<Noticia> {

	@SuppressWarnings("unchecked")
	public Paginacao<Noticia> lista(String busca, Integer paginaAtual, Boolean ehDestaque, Tag tag, Boolean validarAtivo) {
		if (busca == null) {
			busca = "";
		}

		Conjunction conjuctionPaginacao = Restrictions.conjunction();
		conjuctionPaginacao.add(Restrictions.ilike("titulo", busca, MatchMode.ANYWHERE));

		if (ehDestaque != null && ehDestaque == true) {
			conjuctionPaginacao.add(Restrictions.eq("ehDestaque", ehDestaque));
		}
		
		if(validarAtivo)
			conjuctionPaginacao.add(Restrictions.eq("ehAtiva", true));
		
		if (tag != null && tag.getId() > 0) {
			conjuctionPaginacao.add(Restrictions.eq("tags.id", tag.getId()));
			return paginar(conjuctionPaginacao, paginaAtual, Order.desc("id"), "tags");
		} else {
			return paginar(conjuctionPaginacao, paginaAtual, Order.desc("id"));
		}

	}

	public Noticia procuraPorUrl(Noticia noticia) {

		Criteria criteria = session.createCriteria(classePersistida);
		criteria.add(Restrictions.eq("url", noticia.getUrl()));

		return (Noticia) criteria.uniqueResult();

	}

	public List<Noticia> buscarTresUltimasNoticias() {
		Criteria criteria = session.createCriteria(classePersistida);
		criteria.addOrder(Order.desc("id"));
		criteria.add(Restrictions.eq("ehDestaque", true));
		criteria.add(Restrictions.eq("ehAtiva", true));
		criteria.setMaxResults(3);
		return criteria.list();
	}

	public Noticia pegarDestaque() {
		Criteria criteria = session.createCriteria(classePersistida);
		criteria.add(Restrictions.eq("ehDestaque", true));
		criteria.add(Restrictions.eq("ehAtiva", true));

		criteria.addOrder(Order.desc("id"));
		criteria.setMaxResults(1);

		return (Noticia) criteria.uniqueResult();
	}

}