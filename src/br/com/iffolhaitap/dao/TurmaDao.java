package br.com.iffolhaitap.dao;

import javax.enterprise.context.RequestScoped;

import javax.persistence.Entity;
import org.hibernate.Criteria;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.iffolhaitap.model.Turma;
import br.com.iffolhaitap.paginacao.Paginacao;

@Entity
@RequestScoped
public class TurmaDao extends HibernateDao<Turma> {

	@SuppressWarnings("unchecked")
	public Paginacao<Turma> lista(String busca, Integer paginaAtual) {
		if (busca == null) {
			busca = "";
		}

		Conjunction conjuctionPaginacao = Restrictions.conjunction();
		conjuctionPaginacao.add(Restrictions.ilike("nome", busca, MatchMode.ANYWHERE));

		Paginacao<Turma> paginacao = paginar(conjuctionPaginacao, paginaAtual, Order.asc("nome"));

		return paginacao;

	}

	public boolean existeTurmaPorNome(String nome) {

		Criteria criteria = session.createCriteria(classePersistida);
		criteria.add(Restrictions.eq("nome", nome));
		
		return criteria.list().size()>0;
	}

	public Turma procuraPorNome(String nome) {


		Criteria criteria = session.createCriteria(classePersistida);
		criteria.add(Restrictions.eq("nome", nome));
		
		return (Turma) criteria.uniqueResult();
		
	}


	
	
	
}