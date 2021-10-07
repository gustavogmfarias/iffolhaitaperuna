<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<title>${configuracao.nome} - Login</title>
	<link rel="icon" type="image/png" href="${sessao.urlPadrao}img/favicon-32x32.png" sizes="32x32" />
	<link rel="icon" type="image/png" href="${sessao.urlPadrao}img/favicon-16x16.png" sizes="16x16" />

	<link href="${sessao.urlPadrao}css/plugins/bootstrap/bootstrap-theme.css" rel="stylesheet">
	<link href="${sessao.urlPadrao}css/admin/login.css" rel="stylesheet">
</head>

<body>

	<form class="form-signin d-flex flex-column align-items-center" action="${sessao.urlPadrao}adm/logar" method="post">
		<img class="mb-4 img-fluid w-100" src="${sessao.urlPadrao}img/logo-com-texto.png" alt="Delivery Smart">

		<h1 class="h5 m-3 font-weight-normal text-center">Administra&ccedil;&atilde;o</h1>

		<label for="inputEmail" class="sr-only">Usu&aacute;rio</label>
		<input name="usuario.email" type="text" id="inputEmail" class="form-control required" placeholder="Usu&aacute;rio"
			autofocus="">

		<label for="inputPassword" class="sr-only">Senha</label>
		<input name="usuario.senha" type="password" id="inputPassword" class="form-control required" placeholder="Senha">


		<button class="btn btn-lg btn-primary btn-block mb-4" type="submit">Entrar</button>

		<c:if test="${not empty message}">
			<div class="alert alert-success">
				${message}
			</div>
		</c:if>
		<c:if test="${not empty error}">
			<div class="alert alert-danger">
				${error}
			</div>
		</c:if>
		<c:if test="${not empty alert}">
			<div class="alert alert-warning">
				${alert}
			</div>
		</c:if>
				<c:if test="${not empty errors}">
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
		</c:if>
	</form>

	<script src="${sessao.urlPadrao}js/plugins/jquery/jquery-3.3.1.min.js"></script>
	<script src="${sessao.urlPadrao}js/plugins/bootstrap/bootstrap.min.js"></script>
	<script src="${sessao.urlPadrao}js/admin/notificacao.js"></script>
	<script src="${sessao.urlPadrao}js/admin/login.js"></script>
</body>

</html>