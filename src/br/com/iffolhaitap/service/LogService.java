package br.com.iffolhaitap.service;

import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.iffolhaitap.dao.LogDao;
import br.com.iffolhaitap.model.Log;
import br.com.iffolhaitap.util.Sessao;

@RequestScoped
public class LogService {
	
	@Inject LogDao logDao;
	@Inject Sessao sessao;
	
	
	public void criarLog(String titulo, String descricao) {
		
		Log log = new Log(titulo, descricao, sessao.getUsuario(), new Date());
		logDao.adiciona(log);
	} 
	
	
}
