package br.com.iffolhaitap.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.NotEmpty;

@Entity(name = "NOTICIAIMAGEM")
public class NoticiaImagem extends Entidade {

	@NotEmpty
	private String descricao;

	@NotEmpty
	private String alt;

	@NotEmpty
	private String nome;
	
	@OneToOne
	private Noticia noticia;

	public NoticiaImagem(String descricao, String alt, String nome, Noticia noticia) {
		super();
		this.descricao = descricao;
		this.alt = alt;
		this.nome = nome;
		this.noticia = noticia;

		
	}

	public NoticiaImagem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getAlt() {
		return alt;
	}

	public void setAlt(String alt) {
		this.alt = alt;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
}
