package br.com.iffolhaitap.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;

import br.com.iffolhaitap.model.Log;

@RequestScoped
public class LogDao extends HibernateDao<Log> {

	@SuppressWarnings("unchecked")
	public List<Log> lista(String busca) {
		if (busca == null) {
			busca = "";
		}

		Criteria criteria = session.createCriteria(classePersistida);
		criteria.addOrder(Order.desc("id"));

		return criteria.list();

	}

}