package br.com.iffolhaitap.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;

@Entity(name="CONTATO")
public class Contato extends Entidade{


	@NotEmpty
	private String nome;
	
	@NotEmpty
	private String email;
	
	@NotEmpty
	private String assunto;
	
	@NotEmpty
	private String conteudo;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataDoEnvio;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(assunto, conteudo, dataDoEnvio, email, nome);
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
				&& Objects.equals(dataDoEnvio, other.dataDoEnvio) && Objects.equals(email, other.email)
				&& Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "Contato [nome=" + nome + ", email=" + email + ", assunto=" + assunto + ", conteudo=" + conteudo
				+ ", dataDoEnvio=" + dataDoEnvio + "]";
	}

	
}
