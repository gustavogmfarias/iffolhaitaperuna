package br.com.iffolhaitap.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;
import org.jsoup.Jsoup;

@Entity(name = "VIDEO")
public class Video extends Entidade {

	@NotEmpty
	private String descricao;

	@NotEmpty
	private String link;

	private String imagem;

	private boolean ehDestaque;

	@Transient
	private String novoLink;

	public Video(String descricao, String link, String imagem, boolean ehDestaque, String novoLink) {
		super();
		this.descricao = descricao;
		this.link = link;
		this.imagem = imagem;
		this.ehDestaque = ehDestaque;
		this.novoLink = novoLink;
	}

	public Video() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public String getNovoLink() {
		return novoLink;
	}

	public void setNovoLink(String novoLink) {
		this.novoLink = novoLink;
	}



	public boolean isEhDestaque() {
		return ehDestaque;
	}

	public void setEhDestaque(boolean ehDestaque) {
		this.ehDestaque = ehDestaque;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(descricao, imagem, link, novoLink);
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
		Video other = (Video) obj;
		return Objects.equals(descricao, other.descricao) && Objects.equals(imagem, other.imagem)
				&& Objects.equals(link, other.link) && Objects.equals(novoLink, other.novoLink);
	}

	@Override
	public String toString() {
		return "Video [descricao=" + descricao + ", link=" + link + ", imagem=" + imagem + ", novoLink=" + novoLink
				+ "]";
	}

	public String getDescResumida() {

		String descResumida = Jsoup.parse(descricao).text();
		if (descResumida.length() < 40) {
			return descResumida;
		} else {
			return descResumida.substring(0, 40);
		}

	}

	public String getDescResumidaUltimos() {

		String descResumida = Jsoup.parse(descricao).text();
		if (descResumida.length() < 28) {
			return descResumida;
		} else {
			return descResumida.substring(0, 28);
		}

	}

}
