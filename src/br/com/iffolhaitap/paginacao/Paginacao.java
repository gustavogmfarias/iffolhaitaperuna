package br.com.iffolhaitap.paginacao;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder @Getter @Setter @NoArgsConstructor @AllArgsConstructor
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

		for(int i = 0 ; i < paginas ; i++) {
			itens.add(ItemPaginacao.builder().numeroDaPagina(i + 1).paginaAtual(paginaAtual).build());
		}
	}

	public Boolean temProxima() {
		return paginaAtual < quantidadeDePaginas;
	}

	public Boolean temAnterior() {
		return paginaAtual > 1;
	}




}
