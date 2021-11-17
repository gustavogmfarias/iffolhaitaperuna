package br.com.iffolhaitap.dao;

import javax.enterprise.context.RequestScoped;

import org.hibernate.Criteria;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.iffolhaitap.model.Curso;
import br.com.iffolhaitap.paginacao.Paginacao;

@RequestScoped
public class CursoDao extends HibernateDao<Curso> {

	@SuppressWarnings("unchecked")
	public Paginacao<Curso> lista(String busca, Integer paginaAtual) {
		if (busca == null) {
			busca = "";
		}

		Conjunction conjuctionPaginacao = Restrictions.conjunction();
		conjuctionPaginacao.add(Restrictions.ilike("nome", busca, MatchMode.ANYWHERE));

		Paginacao<Curso> paginacao = paginar(conjuctionPaginacao, paginaAtual, Order.asc("nome"));

		return paginacao;

	}

	public boolean existeCursoPorNome(String nome) {

		Criteria criteria = session.createCriteria(classePersistida);
		criteria.add(Restrictions.eq("nome", nome));
		
		return criteria.list().size()>0;
	}

	public Curso procuraPorNome(String nome) {


		Criteria criteria = session.createCriteria(classePersistida);
		criteria.add(Restrictions.eq("nome", nome));
		
		return (Curso) criteria.uniqueResult();
		
	}


	
	
	
}