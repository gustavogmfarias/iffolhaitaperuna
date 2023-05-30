package br.com.iffolhaitap.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.Entity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;

import br.com.iffolhaitap.paginacao.Paginacao;
import br.com.iffolhaitap.util.HibernateUtil;

@Entity
public class HibernateDao<T> {

	protected Session session;
	protected Class<T> classePersistida;
	private Integer numeroDeItensPorPaginaPadrao = 20;

	public HibernateDao() {
		this.session = HibernateUtil.currentSession();
		this.classePersistida = getGenericParameterizedTypeArgument();
	}

	@SuppressWarnings("unchecked")
	private Class<T> getGenericParameterizedTypeArgument() {
		Type genericSuperclass = this.getClass().getGenericSuperclass();

		ParameterizedType parameterizedType;

		if (genericSuperclass instanceof ParameterizedType) {
			parameterizedType = (ParameterizedType) genericSuperclass;
		} else {
			parameterizedType = (ParameterizedType) ((Class<T>) genericSuperclass).getGenericSuperclass();
		}

		return (Class<T>) parameterizedType.getActualTypeArguments()[0];
	}

	public void adiciona(T t) {
		this.session.save(t);
	}

	public void atualizar(T t) {
		this.session.merge(t);
	}

	public T merge(T t) {
		return (T) this.session.merge(t);

	}

	public void remove(T t) {

		this.session.delete(t);

	}

	@SuppressWarnings("unchecked")
	public T get(Long id) {
		return (T) session.get(classePersistida, id);

	}

	public List<T> buscaTodos() {

		Criteria criteria = session.createCriteria(classePersistida);

		return criteria.list();

	}

	public Paginacao<T> paginar(Conjunction conjuctionPaginacao, Integer paginaAtual) {

		return paginar(conjuctionPaginacao, paginaAtual, null);
	}

	public Paginacao<T> paginar(Conjunction conjuctionPaginacao, Integer paginaAtual, Order order, String... aliases) {
		if (paginaAtual == null || paginaAtual == 0) {
			paginaAtual = 1;
		}

		Integer itensTotais = contarTodosItens(conjuctionPaginacao, aliases);

		Integer paginas = encontraPaginas(itensTotais, this.numeroDeItensPorPaginaPadrao);

		Integer min = (paginaAtual * this.numeroDeItensPorPaginaPadrao) - this.numeroDeItensPorPaginaPadrao;
		Integer max = paginaAtual * this.numeroDeItensPorPaginaPadrao;
		Criteria criteria = session.createCriteria(classePersistida);
		if (aliases != null) {
			for (String alias : aliases) {
				criteria.createAlias(alias, alias);
			}
		}
		criteria.add(conjuctionPaginacao);

		if (order != null) {

			criteria.addOrder(order);

		}

		if (min > 0) {
			criteria.setFirstResult(min);
		}
		if (max > 0) {
			criteria.setMaxResults(numeroDeItensPorPaginaPadrao);
		}
		List<T> objetos = criteria.list();

		Paginacao<T> retorno = new Paginacao<T>();
		retorno.setPaginas(paginas, paginaAtual);
		retorno.setObjetosDaPaginaAtual(objetos);
		retorno.setTotalDeItens(itensTotais);

		return retorno;
	}

	private Integer encontraPaginas(Integer itensTotais, Integer numerosDeItensPorPaginaPadrao2) {
		if (itensTotais < numerosDeItensPorPaginaPadrao2)
			return 1;

		if (itensTotais % numerosDeItensPorPaginaPadrao2 == 0) {
			return itensTotais / numerosDeItensPorPaginaPadrao2;
		} else {
			Integer total = itensTotais / numerosDeItensPorPaginaPadrao2;
			return total + 1;
		}
	}

	private Integer contarTodosItens(Conjunction conjuctionPaginacao, String... aliases) {

		Criteria criteriaCount = session.createCriteria(classePersistida);

		if (aliases != null) {
			for (String alias : aliases) {
				criteriaCount.createAlias(alias, alias);
			}
		}

		criteriaCount.add(conjuctionPaginacao);
		criteriaCount.setProjection(Projections.rowCount());

		Long retorno = (Long) criteriaCount.uniqueResult();

		if (retorno == null) {
			return 0;
		} else {
			return retorno.intValue();
		}

	}

}
