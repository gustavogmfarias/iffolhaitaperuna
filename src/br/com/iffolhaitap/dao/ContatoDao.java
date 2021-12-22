package br.com.iffolhaitap.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;

import org.hibernate.Criteria;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.iffolhaitap.model.Contato;
import br.com.iffolhaitap.paginacao.Paginacao;

@RequestScoped
public class ContatoDao extends HibernateDao<Contato> {

		public Paginacao<Contato> lista(String busca, Integer paginaAtual, Boolean estaRespondida) {
		if (busca == null) {
			busca = "";
		}

		Conjunction conjuctionPaginacao = Restrictions.conjunction();
		conjuctionPaginacao.add(Restrictions.ilike("assunto", busca, MatchMode.ANYWHERE));

		if (estaRespondida != null && estaRespondida == true) {
			conjuctionPaginacao.add(Restrictions.eq("estaRespondida", estaRespondida));
		}

		return paginar(conjuctionPaginacao, paginaAtual, Order.desc("id"));

	}

	public List<Contato> buscarTresUltimasContatos() {
		Criteria criteria = session.createCriteria(classePersistida);
		criteria.addOrder(Order.desc("id"));
		criteria.setMaxResults(3);
		return criteria.list();
	}

	public Contato pegarDestaque() {
		Criteria criteria = session.createCriteria(classePersistida);
		criteria.add(Restrictions.eq("estaRespondida", true));

		criteria.addOrder(Order.desc("id"));
		criteria.setMaxResults(1);

		return (Contato) criteria.uniqueResult();
	}

}