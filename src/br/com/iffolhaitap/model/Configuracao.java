package br.com.iffolhaitap.model;

import java.util.Objects;

import javax.persistence.Entity;

@Entity(name = "CONFIGURACAO")
public class Configuracao extends Entidade {

	private String titulo;
	private String logo;
	private String favicon;
	private String corBarraPrincipal;
	
	
	
	
	public Configuracao(String titulo, String logo, String favicon, String corBarraPrincipal) {
		super();
		this.titulo = titulo;
		this.logo = logo;
		this.favicon = favicon;
		this.corBarraPrincipal = corBarraPrincipal;
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

	@Override
	public String toString() {
		return "Configuracao [titulo=" + titulo + ", logo=" + logo + ", favicon=" + favicon + ", corBarraPrincipal="
				+ corBarraPrincipal + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(corBarraPrincipal, favicon, logo, titulo);
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
		return Objects.equals(corBarraPrincipal, other.corBarraPrincipal) && Objects.equals(favicon, other.favicon)
				&& Objects.equals(logo, other.logo) && Objects.equals(titulo, other.titulo);
	}
	
	

	
	
}
