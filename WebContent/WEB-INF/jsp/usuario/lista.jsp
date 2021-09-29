<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
>
<meta charset="ISO-8859-1">
<title>Listagem de Usuarios</title>
</head>
<body>
	<h1>Listagem de Usuarios do ${usuarioLogado.usuario.nome}</h1>

	<div class="Pequisar">
	
	<form action="<c:url value='/Usuario/lista'/>" method="post">
	
	<input class="form-control" type="text" name="busca" placeholder="digite o nome do Usuario">
	
	 </form>
	
	</div>
	<table class="table table-stripped table-hover table-bordered">
			<thead>
			<tr>
				<th>Nome</th>
				<th>Email</th>
				<th>Perfil</th>
				<th>Imagem</th>
			</tr>

		</thead>
		<tbody>
			<c:forEach items="${UsuarioList}" var="Usuario">

				<tr>
					<td>${Usuario.nome}</td>
					<td>${Usuario.valor}</td>
					<td>${Usuario.quantidade}</td>
					<td>
						<img alt="${Usuario.imagem}" class="img-fluid img-thumbnail" style="max-width: 200px;"  src="<c:url value='/imagens-Usuario/${Usuario.imagem}'/>">
					</td>
					<td><a
						href="<c:url value='/Usuario/remove?Usuario.id=${Usuario.id}'/>">Remover</a>
					</td>
					<td >
					<c:url value="/Usuario/editar?Usuario.id=${Usuario.id}" var="url"/>
					<a href="${url}">Editar</a> 
					</td>
				</tr>

			</c:forEach>

		</tbody>

	</table>
	${mensagem} <br>
	<a href="<c:url value='/Usuario/novo'/>"> Adicionar mais
		Usuarios! </a>
</body>
</html>