package br.com.iffolhaitap.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import org.hibernate.validator.constraints.NotEmpty;

@Entity(name = "AUTOR")
public class Autor extends Entidade {
		
    @NotEmpty
	private String nome;
    
    @NotEmpty
	private String email;
    
    @NotEmpty
    private String telefone;
    
	@ManyToMany
    private List<Noticia> noticias;
  
	@ManyToMany
    private List<Artigo> artigos;
    
	private String imagem = "";

	public Autor(String nome, String email, String telefone, List<Noticia> noticias, List<Artigo> artigos) {
		super();
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.noticias = noticias;
		this.artigos = artigos;
	}

	
	
	public Autor() {
		super();
	}



	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
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



	public String getImagem() {
		return imagem;
	}



	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
    


}
