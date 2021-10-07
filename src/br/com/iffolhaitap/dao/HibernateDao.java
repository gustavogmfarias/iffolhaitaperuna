package br.com.iffolhaitap.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.hibernate.Session;

import br.com.iffolhaitap.util.HibernateUtil;

public class HibernateDao<T>{

	protected Session session;
	protected Class<T> classePersistida;
	
	
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

	public void remove(T t) {

		this.session.delete(t);

	}

	@SuppressWarnings("unchecked")
	public T get(Long id) {
		return(T) session.get(classePersistida, id);
		
	}
	
}
