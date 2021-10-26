package br.com.iffolhaitap.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotEmpty;

@Entity(name="GENEROTEXTO")
public class GeneroTexto extends Entidade {
	
	
    @NotEmpty
	private String genero;
	
    @OneToMany(mappedBy = "genero")
    private List<Artigo> artigos;

	public GeneroTexto(String genero, List<Artigo> artigos) {
		super();
		this.genero = genero;
		this.artigos = artigos;
	}

	public GeneroTexto() {
		super();
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public List<Artigo> getArtigos() {
		return artigos;
	}

	public void setArtigos(List<Artigo> artigos) {
		this.artigos = artigos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(artigos, genero);
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
		GeneroTexto other = (GeneroTexto) obj;
		return Objects.equals(artigos, other.artigos) && Objects.equals(genero, other.genero);
	}

	@Override
	public String toString() {
		return "GeneroTexto [genero=" + genero +"]";
	}

    
}
