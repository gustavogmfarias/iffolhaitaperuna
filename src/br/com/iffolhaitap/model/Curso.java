package br.com.iffolhaitap.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotEmpty;

@Entity(name="CURSO")
public class Curso extends Entidade {

	
	@NotEmpty
	private String nome;
	
	@OneToMany(mappedBy = "curso")
	private List<Turma> turmas;
	
	@ManyToMany(mappedBy = "cursos")
	private List<Noticia> noticias;
	
	@ManyToMany(mappedBy = "cursos")
	private List<Noticia> artigos;

	public Curso(String nome, List<Turma> turmas, List<Noticia> noticias, List<Noticia> artigos) {
		super();
		this.nome = nome;
		this.turmas = turmas;
		this.noticias = noticias;
		this.artigos = artigos;
	}

	public Curso() {
		super();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	public List<Noticia> getNoticias() {
		return noticias;
	}

	public void setNoticias(List<Noticia> noticias) {
		this.noticias = noticias;
	}

	public List<Noticia> getArtigos() {
		return artigos;
	}

	public void setArtigos(List<Noticia> artigos) {
		this.artigos = artigos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(artigos, nome, noticias, turmas);
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
		Curso other = (Curso) obj;
		return Objects.equals(artigos, other.artigos) && Objects.equals(nome, other.nome)
				&& Objects.equals(noticias, other.noticias) && Objects.equals(turmas, other.turmas);
	}

	@Override
	public String toString() {
		return "Curso [nome=" + nome + "]";
	}


	
	
}
