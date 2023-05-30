<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<!-- Required meta tags -->
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="X-UA-Compatible" content="ie=edge" />
<title>${sessao.configuracao.titulo}</title>
<!-- plugin css for this page -->
<link rel="stylesheet"
	href="${sessao.urlPadrao}assets/vendors/mdi/css/materialdesignicons.min.css" />
<link rel="stylesheet"
	href="${sessao.urlPadrao}assets/vendors/aos/dist/aos.css/aos.css" />
<!-- End plugin css for this page -->
<link rel="shortcut icon"
	href="${sessao.urlPadrao}img/imagens-config/${sessao.configuracao.favicon}" />

<!-- inject:css -->
<link rel="stylesheet" href="${sessao.urlPadrao}assets/css/style.css">
<link rel="stylesheet"
	href="${sessao.urlPadrao}assets/css/admin/video.css">

<!-- endinject -->
</head>

<body>



	<div class="container-scroller">
		<div class="main-panel">
			<!-- partial:partials/_navbar.html -->
			<header id="header">
				<div class="container">
					<nav class="navbar navbar-expand-lg navbar-light">
						<div class="navbar-top">
							<div class="d-flex justify-content-between align-items-center">
								<ul class="navbar-top-left-menu">

								</ul>
								<ul class="navbar-top-right-menu">
																	<li class="nav-item"><a target="_blank"
										href="${sessao.urlPadrao}adm/login" class="nav-link">Login</a>
									</li>

								</ul>
							</div>
						</div>
						<div class="navbar-bottom">
							<div class="d-flex justify-content-between align-items-center">
								<div>
									<a class="navbar-brand" href="${sessao.urlPadrao}"><img
										src="${sessao.urlPadrao}img/imagens-config/${sessao.configuracao.logo}"
										alt="" /></a>
								</div>
								<div>
									<button class="navbar-toggler" type="button"
										data-target="#navbarSupportedContent"
										aria-controls="navbarSupportedContent" aria-expanded="false"
										aria-label="Toggle navigation">
										<span class="navbar-toggler-icon"></span>
									</button>
									<div class="navbar-collapse justify-content-center collapse"
										id="navbarSupportedContent">
										<ul
											class="navbar-nav d-lg-flex justify-content-between align-items-center">
											<li>
												<button class="navbar-close">
													<i class="mdi mdi-close"></i>
												</button>
											</li>
											<li class="nav-item active"><a class="nav-link"
												href="${sessao.urlPadrao}">Home</a></li>
											<li class="nav-item"><a class="nav-link"
												href="${sessao.urlPadrao}noticias">Not&iacute;cias</a></li>
											<li class="nav-item"><a class="nav-link"
												href="${sessao.urlPadrao}artigos">Artigos</a></li>
															<li class="nav-item"><a class="nav-link"
												href="${sessao.urlPadrao}quemsomos">Quem Somos</a></li>
											<li class="nav-item"><a class="nav-link"
												href="${sessao.urlPadrao}contato">Contato</a></li>
										</ul>
									</div>
								</div>
								<ul class="social-media">
									<li><a href="${sessao.configuracao.facebook}"> <i
											class="mdi mdi-facebook"></i>
									</a></li>
									<li><a href="${sessao.configuracao.youtube}"> <i
											class="mdi mdi-youtube"></i>
									</a></li>
									<li><a href="${sessao.configuracao.instagram}"> <i
											class="mdi mdi-instagram"></i>
									</a></li>
								</ul>
							</div>
						</div>
					</nav>
				</div>
			</header>

			<!-- partial -->

			<div class="flash-news-banner"
				<c:if test="${sessao.configuracao.menuAlertaAtivo==false}">style="display:none;"</c:if>>
				<div class="container">
					<div class="d-lg-flex align-items-center justify-content-between">
						<div class="d-flex align-items-center">
							<p class="mb-0 " style="text-align: center; !important">${sessao.configuracao.menuAlerta}</p>
						</div>
					</div>
				</div>
			</div>

			<jsp:doBody></jsp:doBody>

			<!-- partial:partials/_footer.html -->
			<footer>
				<div class="footer-top">
					<div class="container">
						<div class="row">
							<div class="col-sm-5">
								<img
									src="${sessao.urlPadrao}img/imagens-config/${sessao.configuracao.logo}"
									class="footer-logo" alt="" />
								<h5 class="font-weight-normal mt-4 mb-5">O Jornal IFFolha
									Itaperuna foi inspirado no seu hom&ocirc;nimo do Instituto
									Federal Fluminense Campus P&aacute;dua. Trazemos
									not&iacute;cias do campus, artigos e outras
									informa&ccedil;&otilde;es produzidas pelos alunos.</h5>
								<ul class="social-media">
									<li><a href="${sessao.configuracao.facebook}"> <i
											class="mdi mdi-facebook"></i>
									</a></li>
									<li><a href="${sessao.configuracao.youtube}"> <i
											class="mdi mdi-youtube"></i>
									</a></li>
									<li><a href="${sessao.configuracao.instagram}"> <i
											class="mdi mdi-instagram"></i>
									</a></li>
								</ul>
							</div>
							<div class="col-sm-4">
								<h3 class="font-weight-bold mb-3">NOT&Iacute;CIAS RECENTES</h3>
								<c:forEach items="${tresUltimasNoticias}" var="noticia">

									<div class="row">
										<div class="col-sm-12">
											<div class="footer-border-bottom pb-2">
												<div class="row">
													<div class="col-3">
														<img
															src="${sessao.urlPadrao}img/imagens-noticia/${noticia.imagemPrincipal}"
															alt="thumb" class="img-fluid" />
													</div>
													<div class="col-9">
														<a class="font-weight-600"
															style="text-decoration: none; color: white;"
															href="${sessao.urlPadrao}noticias/${noticia.url}">${noticia.getTituloResumido()}...</a>
													</div>
												</div>
											</div>
										</div>
									</div>
								</c:forEach>
							</div>
							<div class="col-sm-3">
								<h3 class="font-weight-bold mb-3">NEWSLETTER</h3>
								<form action="${sessao.urlPadrao}adm/newsletters" method="post"
									role="form">
									<c:if test="${not empty mensagem}">
										<div class="alert alert-success" role="alert">
											${mensagem}</div>
									</c:if>
									<c:if test="${not empty errors}">
										<div class="container-fluid"
											style="padding-left: 0 !important;">

											<c:forEach items="${errors}" var="error">
												<span>${error.message}</span>
											</c:forEach>
												<span>${message}</span>


										</div>
									</c:if>
									<input id="newsletter" type="email"
										placeholder="insira um email v&aacute;lido"
										name="newsletter.email"> <input type="submit"
										value="cadastrar">
								</form>
								<div class="footer-border-bottom pb-2">
									<div class="d-flex justify-content-between align-items-center">
										<h5 class="mb-0 font-weight-600">Assine nossa newsletter
											e fique atualizado</h5>
										<div class="count">1</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="footer-bottom">
					<div class="container">
						<div class="row">
							<div class="col-sm-12">
								<div
									class="d-sm-flex justify-content-between align-items-center">
									<div class="fs-14 font-weight-600">
										&copy; 2022 @ <a href="https://www.bootstrapdash.com/"
											target="_blank" class="text-white"> IFFolha Itaperuna</a>.
										Todos os direitos reservados.
									</div>
									<div class="fs-14 font-weight-600">
										Theme by <a href="https://www.bootstrapdash.com/"
											target="_blank" class="text-white">BootstrapDash</a> &amp;
										Control Panel and Adaptation by <a
											href="http://gustavogmfarias.me" target="_blank"
											class="text-white">Gustavo Goulart</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</footer>
			<!-- partial -->
		</div>
	</div>
	<!-- inject:js -->
	<script
		src="${sessao.urlPadrao}assets/vendors/js/vendor.bundle.base.js"></script>
	<!-- endinject -->
	<!-- plugin js for this page -->
	<script src="${sessao.urlPadrao}assets/vendors/aos/dist/aos.js/aos.js"></script>
	<!-- End plugin js for this page -->
	<!-- Custom js for this page-->
	<script src="${sessao.urlPadrao}assets/js/demo.js"></script>
	<script src="${sessao.urlPadrao}assets/js/site.js"></script>
	<script src="${sessao.urlPadrao}assets/js/jquery.easeScroll.js"></script>


	<!-- End custom js for this page-->
</body>
</html>
