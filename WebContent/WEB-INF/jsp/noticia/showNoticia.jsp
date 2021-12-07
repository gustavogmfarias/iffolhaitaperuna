<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags"%>

<template:site>
	<div class="content-wrapper">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 stretch-card grid-margin">
					<div class="card">
						<div class="card-body">
							<div class="col-sm-12  grid-margin">

								<h2 class="mb-2 font-weight-600" id="noticiaTitulo">${noticia.titulo }</h2>
								<h4 class="mb-2 font-weight-600">
									<font class="noticiaSubtitulo"> ${noticia.subtitulo }</font>
								</h4>
								<div class="fs-13 mb-2">
									<table>
										<tbody>
											<tr>${noticia.dataDePublicacao} |
											</tr>
											<tr>Publicado por: ${noticia.publicadoPor.nome} |
											</tr>
											<tr>Autor(es):
											<c:forEach var="autor" items="${noticia.autores}">
												${autor.nome} |
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
								<hr>
								<p class="mb-0">${noticia.conteudo}</p>

								<ul class="tagNoticias">
									<c:forEach var="tag" items="${noticia.tags}">
										<li><a href="${sessao.urlPadrao}noticias/tags/${tag.url}">#${tag.nome}</a></li>
									</c:forEach>
								</ul>
							</div>
						</div>
					</div>

				</div>

			</div>


		</div>
	</div>
	<!-- main-panel ends -->
	<!-- container-scroller ends -->
</template:site>