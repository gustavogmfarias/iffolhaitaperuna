package br.com.iffolhaitap.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;

@Entity(name="NEWSLETTER")
public class Newsletter extends Entidade{
	
	@NotEmpty
	private String nome;
	
	@NotEmpty
	private String email;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataDoEnvio;

}
