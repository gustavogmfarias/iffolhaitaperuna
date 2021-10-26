package br.com.iffolhaitap.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity(name = "TURMA")
public class Turma extends Entidade {

	@NotEmpty
	private String nome;

	@ManyToOne @NotNull
	private Curso curso;
	
	@ManyToMany(mappedBy = "turmas")
	private List<Noticia> noticias;
	
	@ManyToMany(mappedBy = "turmas")
	private List<Artigo> artigos;
	
	@Transient
	private String nomeAnterior;

	public Turma(String nome, Curso curso, List<Noticia> noticias, List<Artigo> artigos) {
		super();
		this.nome = nome;
		this.curso = curso;
		this.noticias = noticias;
		this.artigos = artigos;
	}

	public Turma() {
		super();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
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

	public String getNomeAnterior() {
		return nomeAnterior;
	}

	public void setNomeAnterior(String nomeAnterior) {
		this.nomeAnterior = nomeAnterior;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(artigos, curso, nome, nomeAnterior, noticias);
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
		Turma other = (Turma) obj;
		return Objects.equals(artigos, other.artigos) && Objects.equals(curso, other.curso)
				&& Objects.equals(nome, other.nome) && Objects.equals(nomeAnterior, other.nomeAnterior)
				&& Objects.equals(noticias, other.noticias);
	}

	@Override
	public String toString() {
		return "Turma [nome=" + nome + "]";
	}


	
	
}
