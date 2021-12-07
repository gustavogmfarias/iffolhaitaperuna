<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags"%>

<template:site>
	<div class="content-wrapper">
		<div class="container">
			<div class="row" >
				<div class="col-lg-3 stretch-card grid-margin">
					<div class="card">
						<div class="card-body">
							<h2>Tags</h2>
							<ul class="vertical-menu">
								<c:forEach var="tag" items="${tags}">
									<li><a href="${sessao.urlPadrao}noticias/tags/${tag.url}">${tag.nome}</a></li>
								</c:forEach>
							</ul>
						</div>
					</div>
				</div>
				<div class="col-lg-9 stretch-card grid-margin">
					<div class="card">
						<div class="card-body">
						<div>
							<c:forEach var="noticia"
								items="${paginacao.objetosDaPaginaAtual}">
								<div class="row">
									<div class="col-sm-4 grid-margin">
										<div class="position-relative">
											<div class="rotate-img">
												<img
													src="${sessao.urlPadrao}img/imagens-noticia/${noticia.imagemPrincipal}"
													alt="thumb" class="img-fluid" />
											</div>
										</div>
									</div>
									<div class="col-sm-8  grid-margin">
										<a href="${sessao.urlPadrao}noticias/${noticia.url}">
											<h2 class="mb-2 font-weight-600" id="noticiaTitulo">${noticia.titulo }</h2>
											<h4 class="mb-2 font-weight-600">
												<font class="noticiaSubtitulo"> ${noticia.subtitulo }</font>
											</h4>
											<div class="fs-13 mb-2">
												<span class="mr-2">${noticia.dataDePublicacao} </span>Publicado
												por: ${noticia.publicadoPor.nome}
											</div>
											<p class="mb-0">${noticia.conteudoResumido}</p>
										</a>
										<ul class="tagNoticias">
											<c:forEach var="tag" items="${noticia.tags}">
												<li><a href="${sessao.urlPadrao}noticias/tags/${tag.url}">#${tag.nome}</a></li>
											</c:forEach>
										</ul>
									</div>
								</div>
							</c:forEach>
							</div>
							<nav aria-label="Navegação de página exemplo"
						style="background: none;">


						<ul class="pagination justify-content-center">
							<li
								class="page-item <c:if test="${paginacao.temAnterior() == false}">disabled</c:if>">
								<a class="page-link"
								href="${sessao.urlPadrao}noticias?paginaAtual=${paginacao.paginaAtual - 1}&busca=${busca}&tag.id=${tag.id}"
								tabindex="-1">Anterior</a>
							</li>
							<li class="page-item"><select
								class="page-link button-paginate">
									<c:forEach items="${paginacao.itens}" var="item">
										<option
											<c:if test="${item.ehPaginaAtual() == true}">selected</c:if>
											value="${item.numeroDaPagina}"
											data-link="${sessao.urlPadrao}noticias?paginaAtual=${item.numeroDaPagina}&busca=${busca}&tag.id=${tag.id}">${item.numeroDaPagina}
											de ${paginacao.quantidadeDePaginas}</option>
									</c:forEach>
							</select></li>
							<li
								class="page-item <c:if test="${paginacao.temProxima() == false}">disabled</c:if>">
								<a class="page-link"
								href="${sessao.urlPadrao}noticias?paginaAtual=${paginacao.paginaAtual + 1}&busca=${busca}&tag.id=${tag.id}">Próximo</a>
							</li>
						</ul>
					</nav>
						</div>

					</div>

				</div>
			</div>


		</div>
	</div>
	<!-- main-panel ends -->
	<!-- container-scroller ends -->
</template:site>