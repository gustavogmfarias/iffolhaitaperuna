<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
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
									<li class="breadcrumb-item"><a href="${sessao.urlPadrao}adm">Home</a></li>
									<li class="breadcrumb-item active" aria-current="page">Cursos</li>
								</ol>
							</nav>
						</h6>
						<h1 class="header-title">
							Cursos
						</h1>
					</div>
					<div class="col-auto">
						<a href="${sessao.urlPadrao}adm/cursos/novo" class="btn btn-primary">
							<i class="fas fa-plus"></i> Novo Curso
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
					<label class="sr-only" for="cursoNome">Nome</label>
					<input type="text" name="busca" value="${busca}" class="form-control mb-2 mr-sm-2 form-control-sm" id="nome"
						placeholder="Ex.: Sistemas de Informação">

					<button type="submit" class="btn btn-outline-primary mb-2 btn-sm"><i class="fad fa-search"></i>
						Pesquisar</button>
					</div>
				</form>

			</div>
			<div class="col-12">
				<div class="table-responsive">
					<table class="table table-nowrap" id="cursoTable">
						<thead>
			<tr>
				<th>Nome</th>
				<th>Turmas</th>
				<th>Notícias</th>
				<th>Artigos</th>
			</tr>

		</thead>
		<tbody>
			<c:forEach items="${paginacao.objetosDaPaginaAtual}" var="curso">

				<tr>
					<td>${curso.nome}</td>
					<td>${fn:length(curso.turmas)}</td>
					<td>${fn:length(curso.noticias)}</td>
					<td>${fn:length(curso.artigos)}</td>
					<td><a href="javascript:void(0)"
						data-message="Você tem certeza que deseja apagar?" data-url="${sessao.urlPadrao}adm/cursos/${curso.id}/apagar" class="btn btn-small btn-outline-warning button-remove"><i class="fa-fw far fa-trash"></i></a>
					</td>
					<td><a href="${sessao.urlPadrao}adm/cursos/${curso.id}/editar" class="btn btn-small btn-outline-secondary"><i class="fa-fw far fa-pencil-alt"></i></a></td>
				</tr>

			</c:forEach>

		</tbody>
					</table>
					<nav aria-label="Navegação de página exemplo"
						style="background: none;">
						<div class="justify-content-start">Total de itens:
							${paginacao.totalDeItens}</div>

						<ul class="pagination justify-content-end">
							<li
								class="page-item <c:if test="${paginacao.temAnterior() == false}">disabled</c:if>">
								<a class="page-link"
								href="${sessao.urlPadrao}adm/cursos?paginaAtual=${paginacao.paginaAtual - 1}&busca=${busca}"
								tabindex="-1">Anterior</a>
							</li>
							<li class="page-item"><select
								class="page-link button-paginate">
									<c:forEach items="${paginacao.itens}" var="item">
										<option
											<c:if test="${item.ehPaginaAtual() == true}">selected</c:if>
											value="${item.numeroDaPagina}"
											data-link="${sessao.urlPadrao}adm/cursos?paginaAtual=${item.numeroDaPagina}&busca=${busca}">${item.numeroDaPagina}
											de ${paginacao.quantidadeDePaginas}</option>
									</c:forEach>
							</select></li>
							<li
								class="page-item <c:if test="${paginacao.temProxima() == false}">disabled</c:if>">
								<a class="page-link"
								href="${sessao.urlPadrao}adm/cursos?paginaAtual=${paginacao.paginaAtual + 1}&busca=${busca}">Próximo</a>
							</li>
						</ul>
					</nav>
				</div>
			</div>
		</div>
	</div>
</template:admin>