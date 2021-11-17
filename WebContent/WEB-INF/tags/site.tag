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
	href="${sessao.urlPadrao}assets/images/favicon.png" />

<!-- inject:css -->
<link rel="stylesheet" href="${sessao.urlPadrao}assets/css/style.css">
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
									<li class="nav-item"><a href="#" class="nav-link"><i
											class="mdi mdi-magnify"></i></a></li>
									<li class="nav-item"><a href="#" class="nav-link">Login</a>
									</li>

								</ul>
							</div>
						</div>
						<div class="navbar-bottom">
							<div class="d-flex justify-content-between align-items-center">
								<div>
									<a class="navbar-brand" href="#"><img
										src="${sessao.urlPadrao}img/iffolha-logo-index.png" alt="" /></a>
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
												href="index.html">Home</a></li>
											<li class="nav-item"><a class="nav-link" href="noticias">Not&iacute;cias</a></li>
											<li class="nav-item"><a class="nav-link"
												href="pages/business.html">Artigos</a></li>
											<li class="nav-item"><a class="nav-link"
												href="pages/blog.html">Blog</a></li>
											<li class="nav-item"><a class="nav-link"
												href="pages/sports.html">Quem Somos</a></li>
											<li class="nav-item"><a class="nav-link"
												href="pages/art.html">Contato</a></li>
										</ul>
									</div>
								</div>
								<ul class="social-media">
									<li><a
										href="https://www.facebook.com/jornaliffolhaitaperuna"> <i
											class="mdi mdi-facebook"></i>
									</a></li>
									<li><a
										href="https://www.youtube.com/channel/UCTZUjPXEdaGpmK7VyIlnNJQ">
											<i class="mdi mdi-youtube"></i>
									</a></li>
									<li><a href="https://www.instagram.com/iffolhaitaperuna/">
											<i class="mdi mdi-instagram"></i>
									</a></li>
								</ul>
							</div>
						</div>
					</nav>
				</div>
			</header>

			<!-- partial -->
			<div class="flash-news-banner">
				<div class="container">
					<div class="d-lg-flex align-items-center justify-content-between">
						<div class="d-flex align-items-center">
							<span class="badge badge-dark mr-3">***LIVE AGORA *** </span>
							<p class="mb-0">IFFolha est&aacute; realizando uma live no
								momento. Clique e confira!</p>
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
								<img src="${sessao.urlPadrao}img/iffolha-logo-index.png"
									class="footer-logo" alt="" />
								<h5 class="font-weight-normal mt-4 mb-5">O Jornal IFFolha
									Itaperuna foi inspirado no seu hom&ocirc;nimo do Instituto
									Federal Fluminense Campus P&aacute;dua. Trazemos
									not&iacute;cias do campus, artigos e outras
									informa&ccedil;&otilde;es produzidas pelos alunos.</h5>
								<ul class="social-media">
									<li><a
										href="https://www.facebook.com/jornaliffolhaitaperuna"> <i
											class="mdi mdi-facebook"></i>
									</a></li>
									<li><a
										href="https://www.youtube.com/channel/UCTZUjPXEdaGpmK7VyIlnNJQ">
											<i class="mdi mdi-youtube"></i>
									</a></li>
									<li><a href="https://www.instagram.com/iffolhaitaperuna/">
											<i class="mdi mdi-instagram"></i>
									</a></li>
								</ul>
							</div>
							<div class="col-sm-4">
								<h3 class="font-weight-bold mb-3">NOT&Iacute;CIAS RECENTES</h3>
								<div class="row">
									<div class="col-sm-12">
										<div class="footer-border-bottom pb-2">
											<div class="row">
												<div class="col-3">
													<img
														src="${sessao.urlPadrao}assets/images/dashboard/home_1.jpg"
														alt="thumb" class="img-fluid" />
												</div>
												<div class="col-9">
													<h5 class="font-weight-600">Cotton import from USA to
														soar was American traders predict</h5>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-12">
										<div class="footer-border-bottom pb-2 pt-2">
											<div class="row">
												<div class="col-3">
													<img
														src="${sessao.urlPadrao}assets/images/dashboard/home_2.jpg"
														alt="thumb" class="img-fluid" />
												</div>
												<div class="col-9">
													<h5 class="font-weight-600">Cotton import from USA to
														soar was American traders predict</h5>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-12">
										<div>
											<div class="row">
												<div class="col-3">
													<img
														src="${sessao.urlPadrao}assets/images/dashboard/home_3.jpg"
														alt="thumb" class="img-fluid" />
												</div>
												<div class="col-9">
													<h5 class="font-weight-600 mb-3">Cotton import from
														USA to soar was American traders predict</h5>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="col-sm-3">
								<h3 class="font-weight-bold mb-3">NEWSLETTER</h3>
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
		</div>
		<div class="footer-bottom">
			<div class="container">
				<div class="row">
					<div class="col-sm-12">
						<div class="d-sm-flex justify-content-between align-items-center">
							<div class="fs-14 font-weight-600">
								&copy; 2022 @ <a href="https://www.bootstrapdash.com/"
									target="_blank" class="text-white"> IFFolha Itaperuna</a>.
								Todos os direitos reservados.
							</div>
							<div class="fs-14 font-weight-600">
								Theme by <a href="https://www.bootstrapdash.com/"
									target="_blank" class="text-white">BootstrapDash</a> &
								Administration System and Adaptation by <a
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
	<script src="./assets/js/demo.js"></script>
	<script src="./assets/js/jquery.easeScroll.js"></script>
	<!-- End custom js for this page-->
</body>
</html>
