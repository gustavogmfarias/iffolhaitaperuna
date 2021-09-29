package br.com.iffolhaitap.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.hibernate.validator.constraints.NotEmpty;

@Entity(name = "USUARIO")
public class Usuario extends Entidade {

	@NotEmpty(message="{usuario.nome.vazio}")
	private String nome;

	@NotEmpty(message="{usuario.senha.vazio}")
	private String senha;

	@NotEmpty(message="{usuario.email.vazio}")
	private String email;

	private String imagem;

	@Enumerated(EnumType.STRING)
	private Perfil perfil;

	public Usuario(String nome, String senha, String email, String imagem, Perfil perfil) {
		super();
		this.nome = nome;
		this.senha = senha;
		this.email = email;
		this.imagem = imagem;
		this.perfil = perfil;
	}

	public Usuario() {
		super();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

}
