package br.com.iffolhaitap.model;

import java.util.List;

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

    
}
