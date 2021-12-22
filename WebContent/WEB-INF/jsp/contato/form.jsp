<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<div class="card-body card-padding">
	<c:if test="${not empty contato.id}">
		<input type="hidden" class="form-control" name="contato.id"
			value="${contato.id}">



	</c:if>
	<div class="form-group ">
		<label for="contatoNome" class="control-label">Nome:</label> <input
			class="form-control required" id="contatoNome" type="text"
			name="contato.nome" value="${contato.nome}">
	</div>
		<div class="form-group ">
		<label for="contatoEmail" class="control-label">E-mail:</label> <input
			class="form-control required" id="contatoEmail" type="text"
			name="contato.email" value="${contato.email}">
	</div>
	<div class="form-group ">
		<label for="contatoAssunto" class="control-label">Assunto:</label> <input
			class="form-control required" id="contatoAssunto" type="text"
			name="contato.assunto" value="${contato.assunto}">
	</div>
	<div class="form-group ">
		<label for="contatoConteudo" class="control-label  init">Conteúdo:</label>
		<textarea class="form-control required"
			id="contatoConteudo" name="contato.conteudo" >${contato.conteudo}</textarea>
	</div>
	<div class="form-group ">
		<label for="contatoWhatsapp" class="control-label  init">Whatsapp:</label>
		<input class="form-control "
			id="contatoWhatsapp" name="contato.whatsapp" value="${contato.whatsapp}">
	</div>
	<div class="form-group custom-control custom-switch">
		<input name="contato.ehAluno" type="checkbox"
			class="custom-control-input" id="ehAluno"
			<c:if
            test="${ contato.ehAluno == true}">checked="checked"</c:if>>
		<label class="custom-control-label" for="ehAluno">Aluno do
			IFF-Itaperuna</label>
	</div>
	<div class="form-group custom-control custom-switch">
		<input name="contato.estaRespondido" type="checkbox"
			class="custom-control-input" id="estaRespondido"
			<c:if
            test="${ contato.estaRespondido == true}">checked="checked"</c:if>>
            <input type="hidden" class="form-control" name="contato.RespondidoPor"
			value="${sessao.usuario.id}">
		<label class="custom-control-label" for="estaRespondido">Está Respondido?
		</label>
	</div>

	<div class="form-group ">
		<c:if test="${empty contato.id}">
			<input type="submit" class="btn btn-primary" value="Adicionar" />
		</c:if>
		<c:if test="${not empty contato.id}">
			<input type="submit" class="btn btn-primary" value="Atualizar" />
		</c:if>
	</div>
</div>