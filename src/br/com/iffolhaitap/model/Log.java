package br.com.iffolhaitap.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "LOG")
public class Log extends Entidade {

	private String titulo;
	
	@Lob
	private String descricao;
	
	@OneToOne
	private Usuario usuario;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	public Log(String titulo, String descricao, Usuario usuario, Date date) {
		super();
		this.titulo = titulo;
		this.descricao = descricao;
		this.usuario = usuario;
		this.date = date;
	}
	public Log() {
		super();
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(date, descricao, titulo, usuario);
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
		Log other = (Log) obj;
		return Objects.equals(date, other.date) && Objects.equals(descricao, other.descricao)
				&& Objects.equals(titulo, other.titulo) && Objects.equals(usuario, other.usuario);
	}
	@Override
	public String toString() {
		return "Log [titulo=" + titulo + ", descricao=" + descricao + ", usuario=" + usuario + ", date=" + date + "]";
	}
	
	
	
}
