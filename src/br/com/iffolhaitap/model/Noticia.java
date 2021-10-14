package br.com.iffolhaitap.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;

@Entity(name = "NOTICIA")
public class Noticia extends Entidade {

	@NotEmpty
	private String titulo;

	@NotEmpty
	private String subtitulo;

	@NotEmpty
	@Lob
	private String conteudo;

	@OneToMany(mappedBy = "noticia")
	private List<NoticiaImagem> imagens;

	@OneToOne
	private Usuario publicadoPor;

	@OneToOne
	private Usuario editadorPor;

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

	@ManyToMany
	private List<Curso> cursos;

	public Noticia(String titulo, String subtitulo, String conteudo, List<NoticiaImagem> imagens, Usuario publicadoPor,
			Usuario editadorPor, Date dataDePublicacao, Date dataEdicao, List<Autor> autores, List<Tag> tags,
			List<Turma> turmas, List<Curso> cursos) {
		super();
		this.titulo = titulo;
		this.subtitulo = subtitulo;
		this.conteudo = conteudo;
		this.imagens = imagens;
		this.publicadoPor = publicadoPor;
		this.editadorPor = editadorPor;
		this.dataDePublicacao = dataDePublicacao;
		this.dataEdicao = dataEdicao;
		this.autores = autores;
		this.tags = tags;
		this.turmas = turmas;
		this.cursos = cursos;
	}

	public Noticia() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<NoticiaImagem> getImagens() {
		return imagens;
	}

	public void setImagens(List<NoticiaImagem> imagens) {
		this.imagens = imagens;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSubtitulo() {
		return subtitulo;
	}

	public void setSubtitulo(String subtitulo) {
		this.subtitulo = subtitulo;
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

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
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
