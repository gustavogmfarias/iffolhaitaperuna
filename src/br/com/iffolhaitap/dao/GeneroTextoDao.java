package br.com.iffolhaitap.dao;

import javax.enterprise.context.RequestScoped;
import org.hibernate.Criteria;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import br.com.iffolhaitap.model.GeneroTexto;
import br.com.iffolhaitap.paginacao.Paginacao;

@RequestScoped
public class GeneroTextoDao extends HibernateDao<GeneroTexto> {

	@SuppressWarnings("unchecked")
	public Paginacao<GeneroTexto> lista(String busca, Integer paginaAtual) {
		if (busca == null) {
			busca = "";
		}

		Conjunction conjuctionPaginacao = Restrictions.conjunction();
		conjuctionPaginacao.add(Restrictions.ilike("genero", busca, MatchMode.ANYWHERE));

		Paginacao<GeneroTexto> paginacao = paginar(conjuctionPaginacao, paginaAtual, Order.asc("genero"));

		return paginacao;

	}
	
	public boolean existeGeneroTextoPorNome(String genero) {

		Criteria criteria = session.createCriteria(classePersistida);
		criteria.add(Restrictions.eq("genero", genero));

		return criteria.list().size() > 0;
	}

	public GeneroTexto procuraPorNome(String genero) {

		Criteria criteria = session.createCriteria(classePersistida);
		criteria.add(Restrictions.eq("genero", genero));

		return (GeneroTexto) criteria.uniqueResult();

	}

}