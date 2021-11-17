package br.com.iffolhaitap.paginacao;

public class ItemPaginacao {
	private Integer numeroDaPagina;
	private Integer paginaAtual;

	public boolean ehPaginaAtual() {
		return numeroDaPagina.equals(paginaAtual);
	}

	public ItemPaginacao(Integer numeroDaPagina, Integer paginaAtual) {
		super();
		this.numeroDaPagina = numeroDaPagina;
		this.paginaAtual = paginaAtual;
	}

	public ItemPaginacao() {
		super();
	}

	public Integer getNumeroDaPagina() {
		return numeroDaPagina;
	}

	public void setNumeroDaPagina(Integer numeroDaPagina) {
		this.numeroDaPagina = numeroDaPagina;
	}

	public Integer getPaginaAtual() {
		return paginaAtual;
	}

	public void setPaginaAtual(Integer paginaAtual) {
		this.paginaAtual = paginaAtual;
	}
	
	
	
}
