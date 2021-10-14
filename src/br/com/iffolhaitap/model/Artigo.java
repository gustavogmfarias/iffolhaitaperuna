package br.com.iffolhaitap.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity(name = "ARTIGO")
public class Artigo extends Entidade {

	@NotEmpty
	private String titulo;

	@NotEmpty
	@Lob
	private String conteudo;

	@OneToOne
	private Usuario publicadoPor;

	@OneToOne
	private Usuario editadorPor;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataDePublicacao;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataEdicao;

	@ManyToMany
	private List<Autor> autores;

	@ManyToMany
	private List<Tag> tags;

	@ManyToMany
	private List<Turma> turmas;

	@ManyToOne
	private GeneroTexto genero;

	public Artigo(String titulo, String conteudo, Usuario publicadoPor, Usuario editadorPor, Date dataDePublicacao,
			Date dataEdicao, List<Autor> autores, List<Tag> tags, List<Turma> turmas, GeneroTexto genero) {
		super();
		this.titulo = titulo;
		this.conteudo = conteudo;
		this.publicadoPor = publicadoPor;
		this.editadorPor = editadorPor;
		this.dataDePublicacao = dataDePublicacao;
		this.dataEdicao = dataEdicao;
		this.autores = autores;
		this.tags = tags;
		this.turmas = turmas;
		this.genero = genero;
	}

	public Artigo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public Date getDataDePublicacao() {
		return dataDePublicacao;
	}

	public void setDataDePublicacao(Date dataDePublicacao) {
		this.dataDePublicacao = dataDePublicacao;
	}

	public Date getDataEdicao() {
		return dataEdicao;
	}

	public void setDataEdicao(Date dataEdicao) {
		this.dataEdicao = dataEdicao;
	}

	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	public GeneroTexto getGenero() {
		return genero;
	}

	public void setGenero(GeneroTexto genero) {
		this.genero = genero;
	}

	public Usuario getPublicadoPor() {
		return publicadoPor;
	}

	public void setPublicadoPor(Usuario publicadoPor) {
		this.publicadoPor = publicadoPor;
	}

	public Usuario getEditadorPor() {
		return editadorPor;
	}

	public void setEditadorPor(Usuario editadorPor) {
		this.editadorPor = editadorPor;
	}

}
