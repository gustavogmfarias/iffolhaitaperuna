package br.com.iffolhaitap.model;

import java.util.List;

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
	
	
	
}
