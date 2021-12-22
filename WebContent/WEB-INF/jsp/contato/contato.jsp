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
							<form class="m-3 validateForm load"
								action="${sessao.urlPadrao}adm/contatos" method="post"
								role="form" enctype="multipart/form-data">
								<h2 class="mb-2 font-weight-600">Preencha o formulário
									abaixo</h2>
								<hr>
								<c:if test="${not empty mensagem}">
									<div class="alert alert-success" role="alert">
										${mensagem}</div>
								</c:if>
								<c:if test="${not empty errors}">
									<div class="container-fluid">
										<div class="alert alert-danger alert-principal"
											style="margin-top: 15px; margin-bottom: 0px;">
											<a class="close" data-dismiss="alert"><i
												class="fa fa-times" aria-hidden="true"></i></a>
											<ul class="list-unstyled">
												<c:forEach items="${errors}" var="error">
													<c:if test="${error.message != 'Invalid upload'}">
														<li>${error.category}- ${error.message}</li>
													</c:if>
													<c:if test="${error.message == 'Invalid upload'}">
														<li><fmt:message key="invalid.image"></fmt:message></li>
													</c:if>
												</c:forEach>
											</ul>
										</div>
									</div>
								</c:if>
								<div class="form-group ">

									<div class="col-sm-12  grid-margin"></div>
									<label for="contatoNome" class="control-label">Nome:</label> <input
										class="form-control required" id="contatoNome" type="text"
										name="contato.nome" value="${contato.nome}">
								</div>
								<div class="form-group ">
									<label for="contatoEmail" class="control-label">E-mail:</label>
									<input class="form-control required" id="contatoEmail"
										type="text" name="contato.email" value="${contato.email}">
								</div>
								<div class="form-group ">
									<label for="contatoWhatsapp" class="control-label  init">Whatsapp:</label>
									<input class="form-control " id="contatoWhatsapp"
										name="contato.whatsapp" value="${contato.whatsapp}">
								</div>
								<div class="form-group custom-control custom-switch">
									<input name="contato.ehAluno" type="checkbox"
										class="custom-control-input" id="ehAluno"
										<c:if
            test="${ contato.ehAluno == true}">checked="checked"</c:if>>
									<label class="custom-control-label" for="ehAluno">Aluno
										do IFF-Itaperuna</label>
								</div>
								<div class="form-group ">
									<label for="contatoAssunto" class="control-label">Assunto:</label>
									<input class="form-control required" id="contatoAssunto"
										type="text" name="contato.assunto" value="${contato.assunto}">
								</div>
								<div class="form-group ">
									<label for="contatoConteudo" class="control-label  init">Conteúdo:</label>
									<textarea class="form-control required" id="contatoConteudo"
										name="contato.conteudo">${contato.conteudo}</textarea>
								</div>
								<div class="form-group ">
									<input type="submit" class="btn btn-primary"
										style="width: 100%;" value="Enviar" />
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- main-panel ends -->
	<!-- container-scroller ends -->
</template:site>