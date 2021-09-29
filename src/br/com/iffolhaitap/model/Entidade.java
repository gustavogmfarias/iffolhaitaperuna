package br.com.iffolhaitap.model;

import java.util.Objects;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Entidade {

	@GeneratedValue @Id
	private long id;

	public Entidade() {
	
	}

	public long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entidade other = (Entidade) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Entidade [id=" + id + "]";
	}

	
	
}
