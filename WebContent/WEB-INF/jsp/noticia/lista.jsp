<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="template" tagdir="/WEB-INF/tags"%>
<template:admin>
	<div class="header">
		<div class="container-fluid">
			<div class="header-body">
				<div class="row align-items-end">
					<div class="col">
						<h6 class="header-pretitle">
							<nav aria-label="breadcrumb">
								<ol class="breadcrumb">
									<li class="breadcrumb-item"><a
										href="${sessao.urlPadrao}adm">Home</a></li>
									<li class="breadcrumb-item active" aria-current="page">Notícias</li>
								</ol>
							</nav>
						</h6>
						<h1 class="header-title">Notícias</h1>
					</div>
					<div class="col-auto">
						<a href="${sessao.urlPadrao}adm/noticias/novo"
							class="btn btn-primary"> <i class="fas fa-plus"></i> Nova
							Notícia
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="container-fluid">
		<div class="row justify-content-center">
			<div class="col-12">
				<form class="form-inline" id="unidadeForm">
					<div class="col p-0">
						<label class="sr-only" for="noticiaTitulo">Título:</label> <input
							type="text" name="busca" value="${busca}"
							class="form-control mb-2 mr-sm-2 form-control-sm" id="titulo"
							placeholder="Ex.: olimpíadas"> <input
							<c:if test="${ehDestaque == true}"> checked="checked" </c:if>
							name="ehDestaque" type="checkbox"
							class="form-control mb-2 mr-sm-2 form-control-sm form-check-input"
							id="ehDestaque"> <span> Notícia Destaque?</span>
						<button type="submit" class="btn btn-outline-primary mb-2 btn-sm">
							<i class="fad fa-search"></i> Pesquisar
						</button>
					</div>



				</form>

			</div>
			<div class="col-12">
				<div class="table-responsive">
					<table class="table table-nowrap" id="noticiaTable">
						<thead>
							<tr>
								<th>Ativa</th>
								<th>Destaque</th>
								<th>Ordem</th>
								<th>Título</th>
								<th>Publicado por</th>
								<th>Data de Publicação</th>
								<th>Editado por</th>
								<th>Data de Edição</th>
								<th>Autores</th>
								<th>Turmas</th>
								<th>Cursos</th>
								<th>Imagem Principal</th>

							</tr>

						</thead>
						<tbody>
							<c:forEach items="${paginacao.objetosDaPaginaAtual}"
								var="noticia">

								<tr>
									<td><c:if test="${noticia.ehAtiva == true}">
											<label class="badge badge-pill badge-success p-2 pl-3 pr-3">Sim</label>
										</c:if>
										<c:if test="${noticia.ehAtiva == false}">
											<label class="badge badge-pill badge-danger p-2 pl-3 pr-3">Não</label>
										</c:if></td>
									<td><c:if test="${noticia.ehDestaque == true}">
											<label class="badge badge-pill badge-success p-2 pl-3 pr-3">Sim</label>
										</c:if>
										<c:if test="${noticia.ehDestaque == false}">
											<label class="badge badge-pill badge-danger p-2 pl-3 pr-3">Não</label>
										</c:if></td>
									<td>${noticia.ordemDestaque}</td>
									<td>${noticia.titulo}</td>
									<td>${noticia.publicadoPor.nome}</td>
									<td>${noticia.dataDePublicacao}</td>
									<td>${noticia.editadoPor.nome}</td>
									<td>${noticia.dataEdicao}</td>
									<td>${noticia.getNomeDosAutores()}</td>
									<td>${noticia.getNomeDasTurmas()}</td>
									<td>${noticia.getNomeDosCursos()}</td>
									<td><img alt="${noticia.imagemPrincipal}"
										class="img-fluid img-thumbnail" style="max-width: 80px;"
										src="${sessao.urlPadrao}img/imagens-noticia/${noticia.imagemPrincipal}">
									</td>
									<td><a href="javascript:void(0)"
										data-message="Você tem certeza que deseja apagar?"
										data-url="${sessao.urlPadrao}adm/noticias/${noticia.id}/apagar"
										class="btn btn-small btn-outline-warning button-remove"><i
											class="fa-fw far fa-trash"></i></a></td>
									<td><a
										href="${sessao.urlPadrao}adm/noticias/${noticia.id}/editar"
										class="btn btn-small btn-outline-secondary"><i
											class="fa-fw far fa-pencil-alt"></i></a></td>
								</tr>

							</c:forEach>

						</tbody>
					</table>
				</div>
			</div>
		</div>
							<nav aria-label="Navegação de página exemplo"
						style="background: none;">
						<div class="justify-content-start">Total de itens:
							${paginacao.totalDeItens}</div>

						<ul class="pagination justify-content-end">
							<li
								class="page-item <c:if test="${paginacao.temAnterior() == false}">disabled</c:if>">
								<a class="page-link"
								href="${sessao.urlPadrao}adm/noticias?paginaAtual=${paginacao.paginaAtual - 1}&busca=${busca}"
								tabindex="-1">Anterior</a>
							</li>
							<li class="page-item"><select
								class="page-link button-paginate">
									<c:forEach items="${paginacao.itens}" var="item">
										<option
											<c:if test="${item.ehPaginaAtual() == true}">selected</c:if>
											value="${item.numeroDaPagina}"
											data-link="${sessao.urlPadrao}adm/noticias?paginaAtual=${item.numeroDaPagina}&busca=${busca}">${item.numeroDaPagina}
											de ${paginacao.quantidadeDePaginas}</option>
									</c:forEach>
							</select></li>
							<li
								class="page-item <c:if test="${paginacao.temProxima() == false}">disabled</c:if>">
								<a class="page-link"
								href="${sessao.urlPadrao}adm/noticias?paginaAtual=${paginacao.paginaAtual + 1}&busca=${busca}">Próximo</a>
							</li>
						</ul>
					</nav>
	</div>
</template:admin>