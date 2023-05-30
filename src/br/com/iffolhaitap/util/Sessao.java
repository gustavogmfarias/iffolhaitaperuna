package br.com.iffolhaitap.util;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.iffolhaitap.model.Configuracao;
import br.com.iffolhaitap.model.Usuario;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Named("sessao")
@SessionScoped
public class Sessao implements Serializable {

	@Id
	@GeneratedValue
	private static final long serialVersionUID = -2716020570285741943L;

	@ManyToOne
	private Usuario usuario;
	private String url;
	private String titulo;

	private String urlPadrao;
	private String urlContinuacao;
	@ManyToOne
	private Configuracao configuracao;

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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getUrlContinuacao() {
		return urlContinuacao;
	}

	public void setUrlContinuacao(String urlContinuacao) {
		this.urlContinuacao = urlContinuacao;
	}

	public void limparUrlDeContinuacao() {
		setUrlContinuacao(null);
	}

	public boolean temUrlContinuacao() {
		return this.urlContinuacao != null && !this.urlContinuacao.isEmpty();
	}

	public Configuracao getConfiguracao() {
		return configuracao;
	}

	public void setConfiguracao(Configuracao configuracao) {
		this.configuracao = configuracao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}