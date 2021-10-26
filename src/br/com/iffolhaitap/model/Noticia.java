package br.com.iffolhaitap.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;

@Entity(name = "NOTICIA")
public class Noticia extends Entidade {

	@NotEmpty
	private String titulo;

	private String subtitulo;

	@NotEmpty
	@Lob
	private String conteudo;

	@OneToMany(mappedBy = "noticia")
	private List<NoticiaImagem> imagens;
	
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

	private boolean ehDestaque;

	private boolean ehAtiva;
	
	private int ordemDestaque;

	@Transient
	private String tagsEmTexto;

	public Noticia(String titulo, String subtitulo, String conteudo, List<NoticiaImagem> imagens, Usuario publicadoPor,
			Usuario editadoPor, Date dataDePublicacao, Date dataEdicao, List<Autor> autores, List<Tag> tags,
			List<Turma> turmas, List<Curso> cursos, boolean ehDestaque, int ordemDestaque, boolean ehAtiva) {
		super();
		this.titulo = titulo;
		this.subtitulo = subtitulo;
		this.conteudo = conteudo;
		this.imagens = imagens;
		this.publicadoPor = publicadoPor;
		this.editadoPor = editadoPor;
		this.dataDePublicacao = dataDePublicacao;
		this.dataEdicao = dataEdicao;
		this.autores = autores;
		this.tags = tags;
		this.turmas = turmas;
		this.cursos = cursos;
		this.ehDestaque = ehDestaque;
		this.ordemDestaque = ordemDestaque;
		this.ehAtiva = ehAtiva;


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

	public boolean isEhDestaque() {
		return ehDestaque;
	}

	public void setEhDestaque(boolean ehDestaque) {
		this.ehDestaque = ehDestaque;
	}

	public int getOrdemDestaque() {
		return ordemDestaque;
	}

	public void setOrdemDestaque(int ordemDestaque) {
		this.ordemDestaque = ordemDestaque;
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

	public String getTagsEmTexto() {
		return tagsEmTexto;
	}

	public void setTagsEmTexto(String tagsEmTexto) {
		this.tagsEmTexto = tagsEmTexto;
	}

	public String getTagsParaExibicao() {

		if (getTags() == null) {

			return "";
		}

		String tagsDaNoticia = "";

		for (Tag tag : getTags()) {

			tagsDaNoticia += tag.getNome() + ",";

		}
		return tagsDaNoticia;
	}

	public boolean isEhAtiva() {
		return ehAtiva;
	}

	public void setEhAtiva(boolean ehAtiva) {
		this.ehAtiva = ehAtiva;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(autores, conteudo, cursos, dataDePublicacao, dataEdicao, editadoPor,
				ehAtiva, ehDestaque, imagemPrincipal, imagens, ordemDestaque, publicadoPor, subtitulo, tags,
				tagsEmTexto, titulo, turmas);
		return result;
	}

	public String getImagemPrincipal() {
		return imagemPrincipal;
	}

	public void setImagemPrincipal(String imagemPrincipal) {
		this.imagemPrincipal = imagemPrincipal;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Noticia other = (Noticia) obj;
		return Objects.equals(autores, other.autores) && Objects.equals(conteudo, other.conteudo)
				&& Objects.equals(cursos, other.cursos) && Objects.equals(dataDePublicacao, other.dataDePublicacao)
				&& Objects.equals(dataEdicao, other.dataEdicao) && Objects.equals(editadoPor, other.editadoPor)
				&& ehAtiva == other.ehAtiva && ehDestaque == other.ehDestaque
				&& Objects.equals(imagemPrincipal, other.imagemPrincipal) && Objects.equals(imagens, other.imagens)
				&& ordemDestaque == other.ordemDestaque && Objects.equals(publicadoPor, other.publicadoPor)
				&& Objects.equals(subtitulo, other.subtitulo) && Objects.equals(tags, other.tags)
				&& Objects.equals(tagsEmTexto, other.tagsEmTexto) && Objects.equals(titulo, other.titulo)
				&& Objects.equals(turmas, other.turmas);
	}

	@Override
	public String toString() {
		return "Noticia [titulo=" + titulo + ", subtitulo=" + subtitulo + ", conteudo=" + conteudo + ", publicadoPor="
				+ publicadoPor + ", editadoPor=" + editadoPor + ", dataDePublicacao=" + dataDePublicacao
				+ ", dataEdicao=" + dataEdicao + "]";
	}

	
	
	
	
}
