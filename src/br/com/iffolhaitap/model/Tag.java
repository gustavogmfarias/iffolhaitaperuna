package br.com.iffolhaitap.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import org.hibernate.validator.constraints.NotEmpty;

@Entity(name="TAG")
public class Tag extends Entidade{

	@NotEmpty
	private String nome;
	
	@ManyToMany(mappedBy = "tags")
	private List<Noticia> noticias;
	
	@ManyToMany(mappedBy = "tags")
	private List<Artigo> artigos;

	public Tag(String nome, List<Noticia> noticias, List<Artigo> artigos) {
		super();
		this.nome = nome;
		this.noticias = noticias;
		this.artigos = artigos;
	}

	public Tag() {
		super();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Noticia> getNoticias() {
		return noticias;
	}

	public void setNoticias(List<Noticia> noticias) {
		this.noticias = noticias;
	}

	public List<Artigo> getArtigos() {
		return artigos;
	}

	public void setArtigos(List<Artigo> artigos) {
		this.artigos = artigos;
	}

	
	
}
