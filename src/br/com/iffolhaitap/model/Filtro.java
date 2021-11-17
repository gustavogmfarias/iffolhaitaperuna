package br.com.iffolhaitap.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity(name = "FILTRO")
public class Filtro extends Entidade {

	@Lob
	private String entrada;
	
	
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

	public Filtro(String nome, String senha, String email, String imagem, Perfil perfil) {
		super();
		this.nome = nome;
		this.senha = senha;
		this.email = email;
		this.imagem = imagem;
		this.perfil = perfil;
	}

	public Filtro() {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ Objects.hash(email, imagem, nome, novoEmail, perfil, senha, senhaAntiga, senhaConfirmacao);
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
		Filtro other = (Filtro) obj;
		return Objects.equals(email, other.email) && Objects.equals(imagem, other.imagem)
				&& Objects.equals(nome, other.nome) && Objects.equals(novoEmail, other.novoEmail)
				&& perfil == other.perfil && Objects.equals(senha, other.senha)
				&& Objects.equals(senhaAntiga, other.senhaAntiga)
				&& Objects.equals(senhaConfirmacao, other.senhaConfirmacao);
	}

	@Override
	public String toString() {
		return "Usuario [nome=" + nome + ", email=" + email + ", perfil=" + perfil + "]";
	}





	
	
}
