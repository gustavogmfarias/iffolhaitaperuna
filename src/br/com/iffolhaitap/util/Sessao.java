package br.com.iffolhaitap.util;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("sessao")
@SessionScoped
public class Sessao implements Serializable{

	private static final long serialVersionUID = -2716020570285741943L;

	private String url;
	private String titulo;

	private String urlPadrao;


	public Sessao() {
	}

	public String getUrl() {
		return url;
	}



	public void setUrl(String url) {
		this.url = url;
	}



	public String getTitulo() {
		return titulo;
	}



	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}



	public String getUrlPadrao() {
		return urlPadrao;
	}



	public void setUrlPadrao(String urlPadrao) {
		this.urlPadrao = urlPadrao;
	}

}