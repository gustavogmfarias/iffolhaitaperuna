package br.com.iffolhaitap.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;

@Entity(name = "CONTATO")
public class Contato extends Entidade {

	@NotEmpty
	private String nome;

	@NotEmpty
	private String email;

	@NotEmpty
	private String assunto;

	@NotEmpty
	private String conteudo;

	private String whatsapp;

	@OneToOne
	private Usuario respondidoPor;

	private Boolean ehAluno = false;

	private Boolean estaRespondido = false;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataDoEnvio;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataDeResposta;

	public Contato() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Contato(String nome, String email, String assunto, String conteudo, String whatsapp, Usuario respondidoPor,
			Boolean ehAluno, Boolean estaRespondido, Date dataDoEnvio, Date dataDeResposta) {
		super();
		this.nome = nome;
		this.email = email;
		this.assunto = assunto;
		this.conteudo = conteudo;
		this.whatsapp = whatsapp;
		this.respondidoPor = respondidoPor;
		this.ehAluno = ehAluno;
		this.estaRespondido = estaRespondido;
		this.dataDoEnvio = dataDoEnvio;
		this.dataDeResposta = dataDeResposta;
	}

	@Override
	public String toString() {
		return "Contato [nome=" + nome + ", email=" + email + ", assunto=" + assunto + ", conteudo=" + conteudo
				+ ", whatsapp=" + whatsapp + ", ehAluno=" + ehAluno
				+ ", estaRespondido=" + estaRespondido + ", dataDoEnvio=" + dataDoEnvio + ", dataDeResposta="
				+ dataDeResposta + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(assunto, conteudo, dataDeResposta, dataDoEnvio, ehAluno, email,
				estaRespondido, nome, respondidoPor, whatsapp);
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
		Contato other = (Contato) obj;
		return Objects.equals(assunto, other.assunto) && Objects.equals(conteudo, other.conteudo)
				&& Objects.equals(dataDeResposta, other.dataDeResposta)
				&& Objects.equals(dataDoEnvio, other.dataDoEnvio) && Objects.equals(ehAluno, other.ehAluno)
				&& Objects.equals(email, other.email) && Objects.equals(estaRespondido, other.estaRespondido)
				&& Objects.equals(nome, other.nome) && Objects.equals(respondidoPor, other.respondidoPor)
				&& Objects.equals(whatsapp, other.whatsapp);
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

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public String getWhatsapp() {
		return whatsapp;
	}

	public void setWhatsapp(String whatsapp) {
		this.whatsapp = whatsapp;
	}

	public Usuario getRespondidoPor() {
		return respondidoPor;
	}

	public void setRespondidoPor(Usuario respondidoPor) {
		this.respondidoPor = respondidoPor;
	}

	public Boolean getEhAluno() {
		return ehAluno;
	}

	public void setEhAluno(Boolean ehAluno) {
		this.ehAluno = ehAluno;
	}

	public Boolean getEstaRespondido() {
		return estaRespondido;
	}

	public void setEstaRespondido(Boolean estaRespondido) {
		this.estaRespondido = estaRespondido;
	}

	public Date getDataDoEnvio() {
		return dataDoEnvio;
	}

	public void setDataDoEnvio(Date dataDoEnvio) {
		this.dataDoEnvio = dataDoEnvio;
	}

	public Date getDataDeResposta() {
		return dataDeResposta;
	}

	public void setDataDeResposta(Date dataDeResposta) {
		this.dataDeResposta = dataDeResposta;
	}



}