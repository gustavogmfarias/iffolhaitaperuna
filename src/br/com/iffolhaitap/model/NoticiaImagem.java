package br.com.iffolhaitap.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(alt, descricao, nome, noticia);
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
		NoticiaImagem other = (NoticiaImagem) obj;
		return Objects.equals(alt, other.alt) && Objects.equals(descricao, other.descricao)
				&& Objects.equals(nome, other.nome) && Objects.equals(noticia, other.noticia);
	}


	
	
}
