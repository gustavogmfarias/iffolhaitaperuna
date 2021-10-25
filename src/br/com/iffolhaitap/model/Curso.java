package br.com.iffolhaitap.model;

import java.util.List;

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
	
	
	
}
