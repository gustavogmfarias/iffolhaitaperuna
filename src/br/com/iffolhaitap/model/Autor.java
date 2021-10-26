package br.com.iffolhaitap.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;

@Entity(name = "AUTOR")
public class Autor extends Entidade {
		
    @NotEmpty
	private String nome;
    
    @NotEmpty
	private String email;
    
    @NotEmpty
    private String telefone;
    
	@ManyToMany(mappedBy = "autores")
    private List<Noticia> noticias;
  
	@ManyToMany(mappedBy = "autores")
    private List<Artigo> artigos;
    
	@Transient
	private String novoEmail;
	
	private String imagem;

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

	public String getNovoEmail() {
		return novoEmail;
	}

	public void setNovoEmail(String novoEmail) {
		this.novoEmail = novoEmail;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(artigos, email, imagem, nome, noticias, novoEmail, telefone);
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
		Autor other = (Autor) obj;
		return Objects.equals(artigos, other.artigos) && Objects.equals(email, other.email)
				&& Objects.equals(imagem, other.imagem) && Objects.equals(nome, other.nome)
				&& Objects.equals(noticias, other.noticias) && Objects.equals(novoEmail, other.novoEmail)
				&& Objects.equals(telefone, other.telefone);
	}

	@Override
	public String toString() {
		return "Autor [nome=" + nome + ", email=" + email + ", telefone=" + telefone + "]";
	}



}
