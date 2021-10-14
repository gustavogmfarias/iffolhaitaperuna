package br.com.iffolhaitap.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity(name = "USUARIO")
public class Usuario extends Entidade {

	@NotEmpty(message="{usuario.nome.vazio}")
	private String nome;

	@NotEmpty(message="{usuario.senha.vazio}")
	@Size(min=6, max=15, message="{usuario.senha.min6max15}")
	private String senha;

	@Transient
	private String senhaConfirmacao;
	
	@Transient
	private String senhaAntiga;
	
	@Transient
	private String novoEmail;
	
	@NotEmpty(message="{usuario.email.vazio}")
	private String email;

	private String imagem = "";

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

	public String getSenhaConfirmacao() {
		return senhaConfirmacao;
	}

	public void setSenhaConfirmacao(String senhaConfirmacao) {
		this.senhaConfirmacao = senhaConfirmacao;
	}

	public String getSenhaAntiga() {
		return senhaAntiga;
	}

	public void setSenhaAntiga(String senhaAntiga) {
		this.senhaAntiga = senhaAntiga;
	}

	public String getNovoEmail() {
		return novoEmail;
	}

	public void setNovoEmail(String novoEmail) {
		this.novoEmail = novoEmail;
	}

	
	
}
