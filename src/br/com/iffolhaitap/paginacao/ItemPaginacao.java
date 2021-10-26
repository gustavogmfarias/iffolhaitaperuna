package br.com.iffolhaitap.paginacao;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder @Getter @Setter
public class ItemPaginacao {
	private Integer numeroDaPagina;
	private Integer paginaAtual;

	public boolean ehPaginaAtual() {
		return numeroDaPagina.equals(paginaAtual);
	}
}
