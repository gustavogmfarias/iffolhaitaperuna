<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags"%>

<template:site>
	<div class="content-wrapper">
		<div class="container">
			<div class="row" data-aos="fade-up">

				<div class="col-xl-8 stretch-card grid-margin">
					<a style="text-style: none;"
						href="${sessao.urlPadrao}noticias/${destaque.url}">
						<div class="position-relative">
							<img
								src="${sessao.urlPadrao}img/imagens-noticia/${destaque.imagemPrincipal}"
								alt="banner" class="img-fluid "
								style="width: 724px; height: 410px" />
							<div class="banner-content">
								<div class="badge badge-danger fs-12 font-weight-bold mb-3">
									DESTAQUE IFFOLHA</div>
								<h1 class="mb-0">${destaque.titulo}</h1>
								<h1 class="mb-2">${destaque.subtitulo}</h1>
								<div class="fs-12">
									<span class="mr-2">Photo </span>
									<fmt:formatDate pattern="dd/MM/yyyy"
										value="${destaque.dataDePublicacao}" />
								</div>
							</div>
						</div>
					</a>
				</div>
				<div class="col-xl-4 stretch-card grid-margin">
					<div class="card bg-dark text-white">
						<div class="card-body">
							<h2>&Uacute;ltimas not&iacute;cias</h2>
							<c:forEach items="${tresUltimasNoticias}" var="noticia">
								<div
									class="d-flex border-bottom-blue pt-3 pb-4 align-items-center justify-content-between">
									<div class="pr-3">
										<h5>
											<a style="text-decoration: none; color: #71c53b;"
												href="${sessao.urlPadrao}noticias/${noticia.url}">${noticia.getTituloResumido()}...</a>
										</h5>
										<div class="fs-12">
											<span class="mr-2">Photo </span>
											<fmt:formatDate pattern="dd/MM/yyyy"
												value="${noticia.dataDePublicacao}" />
										</div>
									</div>
									<div class="rotate-img">
										<img style="width: 80px; height: 61px;"
											src="${sessao.urlPadrao}img/imagens-noticia/${noticia.imagemPrincipal}"
											alt="thumb" class="img-fluid img-lg" />
									</div>
								</div>
							</c:forEach>

						</div>
					</div>
				</div>
			</div>
			<div class="row" data-aos="fade-up">
				<div class="col-lg-3 stretch-card grid-margin">
					<div class="card">
						<div class="card-body">
							<h2>G&ecirc;nero</h2>
							<ul class="vertical-menu">
								<c:forEach items="${todosGeneros}" var="genero">
									<li><a
										href="${sessao.urlPadrao}artigos/generos/${genero.url}">${genero.genero}</a></li>
								</c:forEach>
							</ul>
						</div>
					</div>
				</div>
				<div class="col-lg-9 stretch-card grid-margin">
					<div class="card">
						<div class="card-body">
							<h2>
								<a
									href="https://www.youtube.com/channel/UCTZUjPXEdaGpmK7VyIlnNJQ/featured"
									style="text-decoration: none; color: black;">Artigos</a>
							</h2>
							<c:forEach items="${tresUltimosArtigos}" var="artigo">
								<a style="text-decoration: none; color: black;"
									href="${sessao.urlPadrao}artigos/${artigo.url}">
									<div class="row">
										<div class="col-sm-4 grid-margin">
											<div class="position-relative">
												<div class="rotate-img">
													<img style="height: 155px;"
														src="${sessao.urlPadrao}img/imagens-artigo/${artigo.imagemPrincipal}"
														alt="thumb" class="img-fluid" />
												</div>
												<div class="badge-positioned">
													<span class="badge badge-danger font-weight-bold">${artigo.genero.genero}</span>
												</div>
											</div>
										</div>
										<div class="col-sm-8  grid-margin">
											<h2 class="mb-2 font-weight-600">${artigo.titulo }</h2>
											<div class="fs-13 mb-2">
												<span class="mr-2">Photo </span>
												<fmt:formatDate pattern="dd/MM/yyyy"
													value="${artigo.dataDePublicacao}" />
											</div>
											<p class="mb-0">${artigo.conteudoResumido}</p>
										</div>
									</div>
								</a>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>

			<div class="row" data-aos="fade-up">
				<div class="col-sm-12 grid-margin">
					<div class="card">
						<div class="card-body">
							<div class="row">
								<div class="col-lg-8">
									<div class="card-title">Video</div>
									<div class="row">
										<c:forEach items="${destaquesVideo}" var="videoDestaque">
											<div class="col-sm-6 grid-margin">
												<div class="position-relative">
													<div class="rotate-img">
														<a style="text-decoration: none"
															href="${videoDestaque.link }" target="_blank"> <img
															style="width: 322px !important; height: 188px !important;"
															src="${sessao.urlPadrao}img/imagens-video/${videoDestaque.imagem}"
															alt="thumb" class="img-fluid" /></a>
													</div>
													<div class="badge-positioned w-90">
														<div
															class="d-flex justify-content-between align-items-center">
															<span class="badge badge-danger font-weight-bold">${videoDestaque.getDescResumida()}...</span>
															<div class="video-icon">
																<i class="mdi mdi-play"></i>
															</div>
														</div>
													</div>
												</div>

											</div>

										</c:forEach>
									</div>
								</div>


								<div class="col-lg-4">
									<div class="d-flex justify-content-between align-items-center">
										<div class="card-title">&Uacute;ltimos Videos</div>
										<p class="mb-3">
											<a
												href="https://www.youtube.com/channel/UCTZUjPXEdaGpmK7VyIlnNJQ/featured"
												style="text-decoration: none; color: black;" target="_blank">Ver
												todos</a>
										</p>
									</div>

									<c:forEach items="${videos}" var="video">
										<div
											class="d-flex justify-content-between align-items-center border-bottom pb-2">

											<div class="div-w-80 mr-3">
												<div class="rotate-img">
													<a href="${video.link }" target="_blank"> <img
														style="height: 72px !important; width: 96px !important;"
														src="${sessao.urlPadrao}img/imagens-video/${video.imagem}"
														alt="thumb" class="img-fluid" /></a>
												</div>
											</div>
											<a style="text-decoration: none !important; color: #3a3a3a;"
												href="${video.link}" target="_blank">
												<h3 style="text-decoration: none !important"
													class="font-weight-600 mb-0">
													${video.getDescResumidaUltimos()}...</h3>
											</a>

										</div>
									</c:forEach>

								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="row" data-aos="fade-up">
				<div class="col-sm-12">
					<div class="card">
						<div class="card-body">
							<div class="row">
								<div class="col-xl-12">
									<div class="card-title">Instagram</div>

									<div id="curator-feed-default-feed-layout"></div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- main-panel ends -->
	<!-- container-scroller ends -->
	<script type="text/javascript">
		/* curator-feed-default-feed-layout */
		(function() {
			var i, e, d = document, s = "script";
			i = d.createElement("script");
			i.async = 1;
			i.charset = "UTF-8";
			i.src = "https://cdn.curator.io/published/cdb22272-d50d-4215-b3d6-a264fa66f9a5.js";
			e = d.getElementsByTagName(s)[0];
			e.parentNode.insertBefore(i, e);
		})();
	</script>
</template:site>