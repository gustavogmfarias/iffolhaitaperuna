package br.com.iffolhaitap.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;

@Entity(name = "ARTIGO")
public class Artigo extends Entidade {

	@NotEmpty
	private String titulo;

	private String subtitulo;
	
	@NotEmpty
	@Lob
	private String conteudo;

	
	private String imagemPrincipal;
	
	@OneToOne
	private Usuario publicadoPor;

	@OneToOne
	private Usuario editadoPor;

	
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
	
	@ManyToOne
	private GeneroTexto genero;
	
	private boolean ehAtiva;

	@Transient
	private String tagsEmTexto;

	public Artigo(String titulo, String subtitulo, String imagemPrincipal, String conteudo, Usuario publicadoPor,
			Usuario editadoPor, Date dataDePublicacao, Date dataEdicao, List<Autor> autores, List<Tag> tags,
			List<Turma> turmas, List<Curso> cursos, GeneroTexto genero, boolean ehAtiva, String tagsEmTexto) {
		super();
		this.titulo = titulo;
		this.subtitulo = subtitulo;
		this.imagemPrincipal = imagemPrincipal;
		this.conteudo = conteudo;
		this.publicadoPor = publicadoPor;
		this.editadoPor = editadoPor;
		this.dataDePublicacao = dataDePublicacao;
		this.dataEdicao = dataEdicao;
		this.autores = autores;
		this.tags = tags;
		this.turmas = turmas;
		this.cursos = cursos;
		this.genero = genero;
		this.ehAtiva = ehAtiva;
		this.tagsEmTexto = tagsEmTexto;
	}

	public Artigo() {
		super();
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

	public String getImagemPrincipal() {
		return imagemPrincipal;
	}

	public void setImagemPrincipal(String imagemPrincipal) {
		this.imagemPrincipal = imagemPrincipal;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public Usuario getPublicadoPor() {
		return publicadoPor;
	}

	public void setPublicadoPor(Usuario publicadoPor) {
		this.publicadoPor = publicadoPor;
	}

	public Usuario getEditadoPor() {
		return editadoPor;
	}

	public void setEditadoPor(Usuario editadoPor) {
		this.editadoPor = editadoPor;
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
		if(tags == null) {
			 this.tags = new ArrayList<Tag>();
		}
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

	public GeneroTexto getGenero() {
		return genero;
	}

	public void setGenero(GeneroTexto genero) {
		this.genero = genero;
	}

	public boolean isEhAtiva() {
		return ehAtiva;
	}

	public void setEhAtiva(boolean ehAtiva) {
		this.ehAtiva = ehAtiva;
	}

	public String getTagsEmTexto() {
		return tagsEmTexto;
	}

	public void setTagsEmTexto(String tagsEmTexto) {
		this.tagsEmTexto = tagsEmTexto;
	}

	public String getNomeDosAutores() {

		if (getAutores() == null) {

			return "";
		}

		String nomeDosAutores = "";

		for (Autor autor : getAutores()) {

			nomeDosAutores += autor.getNome() + "<br/>";

		}
		return nomeDosAutores;
	}

	public String getNomeDasTurmas() {

		if (getTurmas() == null) {

			return "";
		}

		String nomeDasTurmas = "";

		for (Turma turma : getTurmas()) {

			nomeDasTurmas += turma.getNome() + "<br/>";

		}
		return nomeDasTurmas;
	}

	public String getNomeDosCursos() {

		if (getCursos() == null) {

			return "";
		}

		String nomeDosCursos = "";

		for (Curso curso : getCursos()) {

			nomeDosCursos += curso.getNome() + "<br/>";

		}
		return nomeDosCursos;
	}

	public String getTagsParaExibicao() {

		if (getTags() == null) {

			return "";
		}

		String tagsDoArtigo = "";

		for (Tag tag : getTags()) {

			tagsDoArtigo += tag.getNome() + ",";

		}
		return tagsDoArtigo;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(autores, conteudo, cursos, dataDePublicacao, dataEdicao, editadoPor,
				ehAtiva, genero, imagemPrincipal, publicadoPor, subtitulo, tags, tagsEmTexto, titulo, turmas);
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
		Artigo other = (Artigo) obj;
		return Objects.equals(autores, other.autores) && Objects.equals(conteudo, other.conteudo)
				&& Objects.equals(cursos, other.cursos) && Objects.equals(dataDePublicacao, other.dataDePublicacao)
				&& Objects.equals(dataEdicao, other.dataEdicao) && Objects.equals(editadoPor, other.editadoPor)
				&& ehAtiva == other.ehAtiva && Objects.equals(genero, other.genero)
				&& Objects.equals(imagemPrincipal, other.imagemPrincipal)
				&& Objects.equals(publicadoPor, other.publicadoPor) && Objects.equals(subtitulo, other.subtitulo)
				&& Objects.equals(tags, other.tags) && Objects.equals(tagsEmTexto, other.tagsEmTexto)
				&& Objects.equals(titulo, other.titulo) && Objects.equals(turmas, other.turmas);
	}

	@Override
	public String toString() {
		return "Artigo [titulo=" + titulo + ", subtitulo=" + subtitulo + ", publicadoPor=" + publicadoPor
				+ ", editadoPor=" + editadoPor + ", dataDePublicacao=" + dataDePublicacao + ", dataEdicao="
				+ dataEdicao + ", ehAtiva=" + ehAtiva + "]";
	}
	
	
}
