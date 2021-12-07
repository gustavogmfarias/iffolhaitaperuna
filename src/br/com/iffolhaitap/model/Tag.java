package br.com.iffolhaitap.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.iffolhaitap.util.FormatterString;

@Entity(name="TAG")
public class Tag extends Entidade{

	@NotEmpty
	private String nome;
	private String url;

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



	public String getUrl() {
		if(url==null || url.isEmpty()) {
			return new FormatterString().generateNamedUrl(nome);
		}
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(artigos, nome, noticias);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tag other = (Tag) obj;
		return Objects.equals(artigos, other.artigos) && Objects.equals(nome, other.nome)
				&& Objects.equals(noticias, other.noticias);
	}

	@Override
	public String toString() {
		return "Tag [nome=" + nome + "]";
	}

	public void montarUrl() {
		this.url = new FormatterString().generateNamedUrl(nome);

	}



}
