<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
									<li class="breadcrumb-item active" aria-current="page">Log</li>
								</ol>
							</nav>
						</h6>
						<h1 class="header-title">
							Log
						</h1>
					</div>
				</div>
			</div>
		</div>
	</div>

			<div class="col-12">
				<div class="table-responsive">
					<table class="table table-nowrap" id="autorTable">
						<thead>
			<tr>
				<th>Id</th>
				<th>Data</th>
				<th>Título</th>
				<th>Descrição</th>
				<th>Autor</th>
				
					
			</tr>

		</thead>
		<tbody>
			<c:forEach items="${logList}" var="log">

				<tr>
					<td>${log.id}</td>
					<td>${log.date}</td>
					<td>${log.titulo}</td>
					<td>${log.descricao}</td>
					<td>${log.usuario.nome}</td>
					
				</tr>

			</c:forEach>

		</tbody>
					</table>
				</div>
			</div>

</template:admin>