package br.com.iffolhaitap.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;

@Entity(name="NEWSLETTER")
public class Newsletter extends Entidade{

	@NotEmpty
	private String email;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataDoEnvio;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(dataDoEnvio, email);
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
		Newsletter other = (Newsletter) obj;
		return Objects.equals(dataDoEnvio, other.dataDoEnvio) && Objects.equals(email, other.email)
				;
	}

	@Override
	public String toString() {
		return "Newsletter [email=" + email + ", dataDoEnvio=" + dataDoEnvio + "]";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataDoEnvio() {
		return dataDoEnvio;
	}

	public void setDataDoEnvio(Date dataDoEnvio) {
		this.dataDoEnvio = dataDoEnvio;
	}



}
