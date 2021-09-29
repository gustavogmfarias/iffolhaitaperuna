package br.com.iffolhaitap.model;

import java.util.Date;

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

	
}
