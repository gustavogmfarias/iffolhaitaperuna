package br.com.iffolhaitap.paginacao;

import java.util.ArrayList;
import java.util.List;

public class Paginacao<T> {

	private List<T> objetosDaPaginaAtual;
	private List<ItemPaginacao> itens;
	private Integer paginaAtual;
	private Integer quantidadeDePaginas;
	private Integer totalDeItens;

	public void setPaginas(Integer paginas, Integer paginaAtual) {
		this.itens = new ArrayList<>();
		this.paginaAtual = paginaAtual;
		this.quantidadeDePaginas = paginas;

		for (int i = 0; i < paginas; i++) {
			ItemPaginacao itemPaginacao = new ItemPaginacao();
			itemPaginacao.setNumeroDaPagina(i + 1);
			itemPaginacao.setPaginaAtual(paginaAtual);
			itens.add(itemPaginacao);
		}
	}

	public Boolean temProxima() {
		return paginaAtual < quantidadeDePaginas;
	}

	public Boolean temAnterior() {
		return paginaAtual > 1;
	}

	public Paginacao(List<T> objetosDaPaginaAtual, List<ItemPaginacao> itens, Integer paginaAtual,
			Integer quantidadeDePaginas, Integer totalDeItens) {
		super();
		this.objetosDaPaginaAtual = objetosDaPaginaAtual;
		this.itens = itens;
		this.paginaAtual = paginaAtual;
		this.quantidadeDePaginas = quantidadeDePaginas;
		this.totalDeItens = totalDeItens;
	}

	public Paginacao() {
		super();
	}

	public List<T> getObjetosDaPaginaAtual() {
		return objetosDaPaginaAtual;
	}

	public void setObjetosDaPaginaAtual(List<T> objetosDaPaginaAtual) {
		this.objetosDaPaginaAtual = objetosDaPaginaAtual;
	}

	public List<ItemPaginacao> getItens() {
		return itens;
	}

	public void setItens(List<ItemPaginacao> itens) {
		this.itens = itens;
	}

	public Integer getPaginaAtual() {
		return paginaAtual;
	}

	public void setPaginaAtual(Integer paginaAtual) {
		this.paginaAtual = paginaAtual;
	}

	public Integer getQuantidadeDePaginas() {
		return quantidadeDePaginas;
	}

	public void setQuantidadeDePaginas(Integer quantidadeDePaginas) {
		this.quantidadeDePaginas = quantidadeDePaginas;
	}

	public Integer getTotalDeItens() {
		return totalDeItens;
	}

	public void setTotalDeItens(Integer totalDeItens) {
		this.totalDeItens = totalDeItens;
	}

}
