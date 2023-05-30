package br.com.iffolhaitap.dao;

import javax.enterprise.context.RequestScoped;

import javax.persistence.Entity;
import org.hibernate.Criteria;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.iffolhaitap.model.Usuario;
import br.com.iffolhaitap.paginacao.Paginacao;

@Entity
@RequestScoped
public class UsuarioDao extends HibernateDao<Usuario> {

	@SuppressWarnings("unchecked")
	public Paginacao<Usuario> lista(String busca, Integer paginaAtual) {
		if (busca == null) {
			busca = "";
		}

		Conjunction conjuctionPaginacao = Restrictions.conjunction();
		conjuctionPaginacao.add(Restrictions.ilike("nome", busca, MatchMode.ANYWHERE));

		Paginacao<Usuario> paginacao = paginar(conjuctionPaginacao, paginaAtual, Order.asc("nome"));

		return paginacao;

	}

	public boolean existeUsuarioPorEmail(String email) {

		Criteria criteria = session.createCriteria(classePersistida);
		criteria.add(Restrictions.eq("email", email));
		
		return criteria.list().size()>0;
	}

	public Usuario procuraPorEmail(String email) {


		Criteria criteria = session.createCriteria(classePersistida);
		criteria.add(Restrictions.eq("email", email));
		
		return (Usuario) criteria.uniqueResult();
		
	}


	
	
	
}