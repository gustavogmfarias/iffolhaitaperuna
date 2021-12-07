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
								<div class="col-xl-6">
									<div class="card-title">Instagram</div>
									<div class="row">
										<div class="col-xl-6 col-lg-8 col-sm-6">
											<div class="rotate-img">
												<img
													src="${sessao.urlPadrao}assets/images/dashboard/home_16.jpg"
													alt="thumb" class="img-fluid" />
											</div>
											<h2 class="mt-3 text-primary mb-2">Newsrooms exercise..</h2>
											<p class="fs-13 mb-1 text-muted">
												<span class="mr-2">Photo </span>10 Minutes ago
											</p>
											<p class="my-3 fs-15">Lorem Ipsum has been the industry's
												standard dummy text ever since the 1500s, when an unknown
												printer took</p>
											<a href="#" class="font-weight-600 fs-16 text-dark">Read
												more</a>
										</div>
										<div class="col-xl-6 col-lg-4 col-sm-6">
											<div class="border-bottom pb-3 mb-3">
												<h3 class="font-weight-600 mb-0">Social distancing is
													..</h3>
												<p class="fs-13 text-muted mb-0">
													<span class="mr-2">Photo </span>10 Minutes ago
												</p>
												<p class="mb-0">Lorem Ipsum has been the industry's</p>
											</div>
											<div class="border-bottom pb-3 mb-3">
												<h3 class="font-weight-600 mb-0">Panic buying is
													forcing..</h3>
												<p class="fs-13 text-muted mb-0">
													<span class="mr-2">Photo </span>10 Minutes ago
												</p>
												<p class="mb-0">Lorem Ipsum has been the industry's</p>
											</div>
											<div class="border-bottom pb-3 mb-3">
												<h3 class="font-weight-600 mb-0">Businesses ask
													hundreds..</h3>
												<p class="fs-13 text-muted mb-0">
													<span class="mr-2">Photo </span>10 Minutes ago
												</p>
												<p class="mb-0">Lorem Ipsum has been the industry's</p>
											</div>
											<div>
												<h3 class="font-weight-600 mb-0">Tesla's California
													factory..</h3>
												<p class="fs-13 text-muted mb-0">
													<span class="mr-2">Photo </span>10 Minutes ago
												</p>
												<p class="mb-0">Lorem Ipsum has been the industry's</p>
											</div>
										</div>
									</div>
								</div>
								<div class="col-xl-6">
									<div class="row">
										<div class="col-sm-6">
											<div class="card-title">Sport light</div>
											<div class="border-bottom pb-3">
												<div class="rotate-img">
													<img
														src="${sessao.urlPadrao}assets/images/dashboard/home_17.jpg"
														alt="thumb" class="img-fluid" />
												</div>
												<p class="fs-16 font-weight-600 mb-0 mt-3">Kaine: Trump
													Jr. may have</p>
												<p class="fs-13 text-muted mb-0">
													<span class="mr-2">Photo </span>10 Minutes ago
												</p>
											</div>
											<div class="pt-3 pb-3">
												<div class="rotate-img">
													<img
														src="${sessao.urlPadrao}assets/images/dashboard/home_18.jpg"
														alt="thumb" class="img-fluid" />
												</div>
												<p class="fs-16 font-weight-600 mb-0 mt-3">Kaine: Trump
													Jr. may have</p>
												<p class="fs-13 text-muted mb-0">
													<span class="mr-2">Photo </span>10 Minutes ago
												</p>
											</div>
										</div>
										<div class="col-sm-6">
											<div class="card-title">Celebrity news</div>
											<div class="row">
												<div class="col-sm-12">
													<div class="border-bottom pb-3">
														<div class="row">
															<div class="col-sm-5 pr-2">
																<div class="rotate-img">
																	<img
																		src="${sessao.urlPadrao}assets/images/dashboard/home_19.jpg"
																		alt="thumb" class="img-fluid w-100" />
																</div>
															</div>
															<div class="col-sm-7 pl-2">
																<p class="fs-16 font-weight-600 mb-0">Online
																	shopping ..</p>
																<p class="fs-13 text-muted mb-0">
																	<span class="mr-2">Photo </span>10 Minutes ago
																</p>
																<p class="mb-0 fs-13">Lorem Ipsum has been</p>
															</div>
														</div>
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-sm-12">
													<div class="border-bottom pb-3 pt-3">
														<div class="row">
															<div class="col-sm-5 pr-2">
																<div class="rotate-img">
																	<img
																		src="${sessao.urlPadrao}assets/images/dashboard/home_20.jpg"
																		alt="thumb" class="img-fluid w-100" />
																</div>
															</div>
															<div class="col-sm-7 pl-2">
																<p class="fs-16 font-weight-600 mb-0">Online
																	shopping ..</p>
																<p class="fs-13 text-muted mb-0">
																	<span class="mr-2">Photo </span>10 Minutes ago
																</p>
																<p class="mb-0 fs-13">Lorem Ipsum has been</p>
															</div>
														</div>
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-sm-12">
													<div class="border-bottom pb-3 pt-3">
														<div class="row">
															<div class="col-sm-5 pr-2">
																<div class="rotate-img">
																	<img
																		src="${sessao.urlPadrao}assets/images/dashboard/home_21.jpg"
																		alt="thumb" class="img-fluid w-100" />
																</div>
															</div>
															<div class="col-sm-7 pl-2">
																<p class="fs-16 font-weight-600 mb-0">Online
																	shopping ..</p>
																<p class="fs-13 text-muted mb-0">
																	<span class="mr-2">Photo </span>10 Minutes ago
																</p>
																<p class="mb-0 fs-13">Lorem Ipsum has been</p>
															</div>
														</div>
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-sm-12">
													<div class="pt-3">
														<div class="row">
															<div class="col-sm-5 pr-2">
																<div class="rotate-img">
																	<img
																		src="${sessao.urlPadrao}assets/images/dashboard/home_22.jpg"
																		alt="thumb" class="img-fluid w-100" />
																</div>
															</div>
															<div class="col-sm-7 pl-2">
																<p class="fs-16 font-weight-600 mb-0">Online
																	shopping ..</p>
																<p class="fs-13 text-muted mb-0">
																	<span class="mr-2">Photo </span>10 Minutes ago
																</p>
																<p class="mb-0 fs-13">Lorem Ipsum has been</p>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
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
</template:site>