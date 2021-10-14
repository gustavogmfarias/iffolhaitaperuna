<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="template" tagdir="/WEB-INF/tags" %>
<template:admin>
	<div class="header">
		<div class="container-fluid">
			<div class="header-body">
				<div class="row align-items-end">
					<div class="col">
						<h6 class="header-pretitle">
							<nav aria-label="breadcrumb">
								<ol class="breadcrumb">
									<li class="breadcrumb-item"><a href="${sessao.urlPadrao}">Home</a></li>
									<li class="breadcrumb-item"><a href="${sessao.urlPadrao}adm/generosdetexto">Gêneros de Texto</a></li>
									<li class="breadcrumb-item active" aria-current="page">Novo Gênero de Texto</li>
								</ol>
							</nav>
						</h6>
						<h1 class="header-title">
							Novo Gênero de Texto
						</h1>
					</div>
				</div>
			</div>
		</div>
	</div>
	<form class="m-3 validateForm load" action="${sessao.urlPadrao}adm/generosdetexto" method="post" role="form"
		enctype="multipart/form-data">
		<%@include file="form.jsp"%>
	</form>
	
	${mensagem} <br>

</template:admin>