package br.com.iffolhaitap.dao;

import javax.enterprise.context.RequestScoped;

import br.com.iffolhaitap.model.Configuracao;
import javax.persistence.Entity;

@Entity
@RequestScoped
public class ConfiguracaoDao extends HibernateDao<Configuracao> {



}