package br.com.iffolhaitap.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Lob;

@Entity(name = "CONFIGURACAO")
public class Configuracao extends Entidade {

	private String titulo;
	private String logo;
	private String favicon;
	private String corBarraPrincipal;
	private String facebook;
	private String instagram;
	private String youtube;
	@Lob
	private String menuAlerta;
	private Boolean menuAlertaAtivo = false;

	public Configuracao(String titulo, String logo, String favicon, String corBarraPrincipal, String facebook,
			String instagram, String youtube, String menuAlerta, Boolean menuAlertaAtivo) {
		super();
		this.titulo = titulo;
		this.logo = logo;
		this.favicon = favicon;
		this.corBarraPrincipal = corBarraPrincipal;
		this.facebook = facebook;
		this.instagram = instagram;
		this.youtube = youtube;
		this.menuAlerta = menuAlerta;
		this.menuAlertaAtivo = menuAlertaAtivo;
	}

	public Configuracao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getFavicon() {
		return favicon;
	}

	public void setFavicon(String favicon) {
		this.favicon = favicon;
	}

	public String getCorBarraPrincipal() {
		return corBarraPrincipal;
	}

	public void setCorBarraPrincipal(String corBarraPrincipal) {
		this.corBarraPrincipal = corBarraPrincipal;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getInstagram() {
		return instagram;
	}

	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}

	public String getYoutube() {
		return youtube;
	}

	public void setYoutube(String youtube) {
		this.youtube = youtube;
	}

	public String getMenuAlerta() {
		return menuAlerta;
	}

	public void setMenuAlerta(String menuAlerta) {
		this.menuAlerta = menuAlerta;
	}

	public Boolean getMenuAlertaAtivo() {
		return menuAlertaAtivo;
	}

	public void setMenuAlertaAtivo(Boolean menuAlertaAtivo) {
		this.menuAlertaAtivo = menuAlertaAtivo;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(corBarraPrincipal, facebook, favicon, instagram, logo, menuAlerta,
				menuAlertaAtivo, titulo, youtube);
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
		Configuracao other = (Configuracao) obj;
		return Objects.equals(corBarraPrincipal, other.corBarraPrincipal) && Objects.equals(facebook, other.facebook)
				&& Objects.equals(favicon, other.favicon) && Objects.equals(instagram, other.instagram)
				&& Objects.equals(logo, other.logo) && Objects.equals(menuAlerta, other.menuAlerta)
				&& Objects.equals(menuAlertaAtivo, other.menuAlertaAtivo) && Objects.equals(titulo, other.titulo)
				&& Objects.equals(youtube, other.youtube);
	}

	@Override
	public String toString() {
		return "Configuracao [titulo=" + titulo + ", logo=" + logo + ", favicon=" + favicon + ", corBarraPrincipal="
				+ corBarraPrincipal + ", facebook=" + facebook + ", instagram=" + instagram + ", youtube=" + youtube
				+ ", menuAlerta=" + menuAlerta + ", menuAlertaAtivo=" + menuAlertaAtivo + "]";
	}

}
