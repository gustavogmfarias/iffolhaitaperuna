<%@tag description="Template para páginas do admin" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">

		<title>Administra&ccedil;&atilde;o</title>
		<link rel="icon" type="image/png" href="${sessao.urlPadrao}img/favicon-32x32.png" sizes="32x32" />
		<link rel="icon" type="image/png" href="${sessao.urlPadrao}img/favicon-16x16.png" sizes="16x16" />

		<link href="${sessao.urlPadrao}css/plugins/bootstrap/bootstrap-theme.css" rel="stylesheet">
		<link href="${sessao.urlPadrao}css/plugins/fontawesome/all.min.css" rel="stylesheet">
		<link href="${sessao.urlPadrao}css/plugins/feather/feather.min.css" rel="stylesheet">
		<link href="${sessao.urlPadrao}css/plugins/codemirror/codemirror.css" rel="stylesheet">
		<link href="${sessao.urlPadrao}css/plugins/fileinput/fileinput.min.css" rel="stylesheet">
		<link href="${sessao.urlPadrao}css/plugins/datatables/datatables.min.css" rel="stylesheet">
		<link href="${sessao.urlPadrao}css/plugins/summernote/summernote.css" rel="stylesheet">
		<link href="${sessao.urlPadrao}css/plugins/summernote/summernote-bs4.css" rel="stylesheet">
		<link href="${sessao.urlPadrao}css/plugins/sweetalert/sweetalert.css" rel="stylesheet">
		<link href="${sessao.urlPadrao}css/plugins/toastr/toastr.min.css" rel="stylesheet">
		<link href="${sessao.urlPadrao}css/plugins/flatpickr/flatpickr.min.css" rel="stylesheet">
		<link href="${sessao.urlPadrao}css/plugins/select/bootstrap-select.min.css" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="https://at.alicdn.com/t/font_o5hd5vvqpoqiwwmi.css">

		<link href="${sessao.urlPadrao}css/admin/admin.css" rel="stylesheet">
		<script>
			var urlPadrao = '${sessao.urlPadrao}';
		</script>
	</head>
	<body>
		<nav class="navbar navbar-vertical fixed-left navbar-expand-md navbar-light d-print-none" id="sidebar">
			<div class="container-fluid">

				<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#sidebarCollapse" aria-controls="sidebarCollapse" aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>

				<a class="navbar-brand" href="${sessao.urlPadrao}/adm">
					<img src="${sessao.urlPadrao}img/logo-com-texto.png" class="navbar-brand-img mx-auto" alt="Internato">
					<div class="clearfix"></div>
				</a>

				<div class="collapse navbar-collapse" id="sidebarCollapse">

				<form class="mt-4 mb-3 d-md-none">
					<div class="input-group input-group-rounded input-group-merge">
						<input type="search" class="form-control form-control-rounded form-control-prepended" placeholder="Search" aria-label="Search">
						<div class="input-group-prepend">
							<div class="input-group-text">
								<span class="fe fe-search"></span>
							</div>
						</div>
					</div>
				</form>

				<ul class="navbar-nav">
					<li class="nav-item">
						<a href="${sessao.urlPadrao}adm/inicio" class="nav-link ">
							<i class="fad fa-home fa-fw mr-2"></i> Dashboard
						</a>
					</li>
					<li class="nav-item">
						<a href="${sessao.urlPadrao}adm/usuarios" class="nav-link ">
							<i class="fad fa-user-crown fa-fw mr-2"></i> Usu&aacute;rios
						</a>
					</li>
					<li class="nav-item">
						<a href="${sessao.urlPadrao}adm/autores" class="nav-link ">
							<i class="fad fa-user-edit mr-2"></i> Autores
						</a>
					</li>
						<li class="nav-item">
						<a href="${sessao.urlPadrao}adm/turmas" class="nav-link ">
							<i class="fad fa-user-crown fa-fw mr-2"></i> Turmas
						</a>
					</li>
						<li class="nav-item">
						<a href="${sessao.urlPadrao}adm/cursos" class="nav-link ">
							<i class="fad fa-user-crown fa-fw mr-2"></i> Cursos
						</a>
					</li>
							<li class="nav-item">
						<a href="${sessao.urlPadrao}adm/generosdetexto" class="nav-link ">
							<i class="fad fa-user-crown fa-fw mr-2"></i> Gêneros de Texto
						</a>
					</li>
					<li class="nav-item">
						<a href="${sessao.urlPadrao}adm/noticias" class="nav-link ">
							<i class="fad fa-user-crown fa-fw mr-2"></i> Noticias
						</a>
					</li>
				</ul>
				<hr class="navbar-divider my-3">

				<ul class="navbar-nav">
					<li class="nav-item">
						<a href="${sessao.urlPadrao}adm/unidades" class="nav-link ">
						<i class="fad fa-clinic-medical fa-fw mr-2"></i>
							Unidades
						</a>
					</li>
				</ul>


				<ul class="navbar-nav mt-auto">
					<li class="nav-item">
						<a href="${sessao.urlPadrao}adm/configuracao" class="nav-link ">
							<i class="fad fa-cogs fa-fw mr-2"></i> Configura&ccedil;&otilde;es
						</a>
					</li>
					<li class="nav-item">
						<a href="${sessao.urlPadrao}adm/alterarminhasenha" class="nav-link ">
							<i class="fad fa-key fa-fw mr-2"></i> Alterar senha
						</a>
					</li>
					<li class="nav-item">
						<a href="${sessao.urlPadrao}adm/sair" class="nav-link ">
							<i class="fad fa-sign-out fa-fw mr-2"></i> Sair
						</a>
					</li>
				</ul>
			</div>
			</div>
		</nav>

		<main class="main-content">

		<c:if test="${not empty errors}">
		<div class="container-fluid">
			<div class="alert alert-danger alert-principal" style="margin-top: 15px; margin-bottom: 0px;">
				<a class="close" data-dismiss="alert"><i class="fa fa-times" aria-hidden="true"></i></a>
				<ul class="list-unstyled">
					<c:forEach items="${errors}" var="error">
						<c:if test="${error.message != 'Invalid upload'}">
							<li>${error.message}</li>
						</c:if>
						<c:if test="${error.message == 'Invalid upload'}">
							<li><fmt:message key="invalid.image"></fmt:message></li>
						</c:if>
					</c:forEach>
				</ul>
			</div>
		</div>
		</c:if>
			<jsp:doBody/>
		</main>

		<script src="${sessao.urlPadrao}js/plugins/jquery/jquery-3.3.1.min.js"></script>
		<script src="${sessao.urlPadrao}js/plugins/popper/popper.min.js"></script>
		<script src="${sessao.urlPadrao}js/plugins/bootstrap/bootstrap.min.js"></script>
		<script src="${sessao.urlPadrao}js/plugins/moment/moment-with-locales.min.js"></script>
		<script src="${sessao.urlPadrao}js/plugins/mascara/meiomask.js"></script>
		<script src="${sessao.urlPadrao}js/plugins/fileinput/fileinput.min.js"></script>
		<script src="${sessao.urlPadrao}js/plugins/fileinput/themes/fa/theme.min.js"></script>
		<script src="${sessao.urlPadrao}js/plugins/fileinput/locales/pt-BR.js"></script>
		<script src="${sessao.urlPadrao}js/plugins/validate/jquery.validate.js"></script>
		<script src="${sessao.urlPadrao}js/plugins/validate/additional-methods.js"></script>
		<script src="${sessao.urlPadrao}js/plugins/validate/localization/messages_pt_BR.js"></script>
		<script src="${sessao.urlPadrao}js/plugins/codemirror/codemirror.js"></script>
		<script src="${sessao.urlPadrao}js/plugins/codemirror/keymap/sublime.js"></script>
		<script src="${sessao.urlPadrao}js/plugins/codemirror/addon/selection/selection-pointer.js"></script>
		<script src="${sessao.urlPadrao}js/plugins/codemirror/addon/edit/matchbrackets.js"></script>
		<script src="${sessao.urlPadrao}js/plugins/codemirror/addon/edit/closebrackets.js"></script>
		<script src="${sessao.urlPadrao}js/plugins/codemirror/addon/display/autorefresh.js"></script>
		<script src="${sessao.urlPadrao}js/plugins/codemirror/mode/xml/xml.js"></script>
		<script src="${sessao.urlPadrao}js/plugins/codemirror/mode/javascript/javascript.js"></script>
		<script src="${sessao.urlPadrao}js/plugins/codemirror/mode/css/css.js"></script>
		<script src="${sessao.urlPadrao}js/plugins/codemirror/mode/htmlmixed/htmlmixed.js"></script>
		<script src="${sessao.urlPadrao}js/plugins/summernote/summernote-bs4.min.js"></script>
		<script src="${sessao.urlPadrao}js/plugins/summernote/lang/summernote-pt-BR.js"></script>
		<script src="${sessao.urlPadrao}js/plugins/select/bootstrap-select.min.js"></script>
		<script src="${sessao.urlPadrao}js/plugins/select/i18n/defaults-pt_BR.min.js"></script>
		<script src="${sessao.urlPadrao}js/plugins/datatables/datatables.min.js"></script>
		<script src="${sessao.urlPadrao}js/plugins/sweetalert/sweetalert.min.js"></script>
		<script src="${sessao.urlPadrao}js/plugins/toastr/toastr.min.js"></script>
		<script src="${sessao.urlPadrao}js/plugins/flatpickr/flatpickr.min.js"></script>
		<script src="${sessao.urlPadrao}js/Ajax.js"></script>
		<script src="${sessao.urlPadrao}js/Modal.js"></script>

		<script src="${sessao.urlPadrao}js/admin/paginate.js"></script>
		<script src="${sessao.urlPadrao}js/admin/notificacao.js"></script>
		<script src="${sessao.urlPadrao}js/admin/admin.js"></script>
		<script src="${sessao.urlPadrao}js/admin/forms.js"></script>
		<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>

		<link href="${sessao.urlPadrao}css/plugins/summernote/summernote-bs4.css" rel="stylesheet">

		<c:if test="${not empty controlador}">
			<script src="${sessao.urlPadrao}js/admin/controller/${controlador}.js"></script>
		</c:if>
	<c:if test="${not empty message}">
			<script>
				(function() {
					notificacao('success', '${message}');
					console.log('${message}')
				})();
			</script>
		</c:if>
		<c:if test="${not empty error}">
			<script>
				(function() {
					notificacao('danger', '${error}');
					console.error('${error}')
				})();
			</script>
		</c:if>
		<c:if test="${not empty alert}">
			<script>
				(function() {
					notificacao('warning', '${alert}');
					console.warn('${alert}')
				})();
			</script>
		</c:if>

	<div style="display: none;" id="stackPrint">${stack}</div>
	<div style="display: none;" id="messagePrint">${messageErro}</div>
	<div style="display: none;" id="localizedMessagePrint">${localizedMessageErro}</div>

	</body>
</html>
