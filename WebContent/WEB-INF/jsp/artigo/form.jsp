<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<div class="card-body card-padding">
	<c:if test="${not empty artigo.id}">
		<input type="hidden" class="form-control" name="artigo.id"
			value="${artigo.id}">
		<input type="hidden" class="form-control" name="artigo.imagemPrincipal"
			value="${artigo.imagemPrincipal}">
	</c:if>
	<div class="form-group ">
		<label for="artigoTitulo" class="control-label">Título:</label> <input
			class="form-control required" id="artigoTitulo" type="text"
			name="artigo.titulo" value="${artigo.titulo}">
	</div>
	<div class="form-group ">
		<label for="artigoSubTitulo" class="control-label">SubTítulo:</label>
		<input class="form-control required" id="artigoSubTitulo" type="text"
			name="artigo.subtitulo" value="${artigo.subtitulo}">
	</div>
	<div class="form-group ">
		<label for="artigoConteudo" class="control-label textarea init">Conteúdo:</label>
		<textarea class="form-control required custom-html"
			id="artigoConteudo" name="artigo.conteudo">${artigo.conteudo}</textarea>
	</div>

	<div class="form-group ">
		<label for="imagemArtigo" class="control-label">Imagem
			Principal:</label> <input class="form-control file-imagem" id="imagemArtigo"
			type="file" name="imagemArtigo"
			data-initialPreview='[{"urlCompleta":"${sessao.urlPadrao}img/imagens-artigo/${artigo.imagemPrincipal}"}]'>
	</div>
	<div class="form-group ">
		<label for="GenerosArtigo" class="control-label">Gêneros:</label> <select
			multiple data-live-search="true"
			class="form-control required custom-select" id="GenerosArtigo"
			name="artigo.genero.id">
			<c:forEach items="${generosList}" var="genero">
				<option value="${genero.id}"
					<c:if test="${artigo.genero.id==genero.id}">selected="selected"</c:if>>${genero.genero}</option>
			</c:forEach>
		</select>
		<div class="form-group ">
			<label for="autoresArtigo" class="control-label">Autores:</label> <select
				multiple data-live-search="true"
				class="form-control required custom-select" id="autoresArtigo"
				name="artigo.autores[].id">
				<c:forEach items="${autoresList}" var="autor">
					<option value="${autor.id}"
						<c:if test="${fn:contains(artigo.autores, autor)}">selected="selected"</c:if>>${autor.nome}</option>
				</c:forEach>
			</select>
		</div>
		<div class="form-group ">
			<label for="turmasArtigo" class="control-label">Turmas:</label> <select
				multiple data-live-search="true" class="form-control custom-select"
				id="turmasArtigo" name="artigo.turmas[].id">
				<c:forEach items="${turmasList}" var="turma">
					<option value="${turma.id}"
						<c:if test="${fn:contains(artigo.turmas, turma)}">selected="selected"</c:if>>${turma.nome}</option>
				</c:forEach>
			</select>
		</div>
		<div class="form-group ">
			<label for="cursosArtigo" class="control-label">Cursos:</label> <select
				data-live-search="true" liveSearchStyle="startsWith" multiple
				class="form-control custom-select" id="turmasArtigo"
				name="artigo.cursos[].id">
				<c:forEach items="${cursosList}" var="curso">
					<option value="${curso.id}"
						<c:if test="${fn:contains(artigo.cursos, curso)}">selected="selected"</c:if>>${curso.nome}</option>
				</c:forEach>
			</select>
		</div>



		<div class="form-group custom-control custom-switch">
			<input name="artigo.ehAtiva" type="checkbox"
				class="custom-control-input" id="ehAtiva"
				<c:if
            test="${empty artigo.id || artigo.ehAtiva == true}">checked="checked"</c:if>>
			<label class="custom-control-label" for="ehAtiva">Artigo
				Ativo</label>
		</div>

		<div class="form-group ">
			<label for="artigoTags" class="control-label">Tags:</label> <input
				data-role="tagsinput" class="form-control " id="artigoTags"
				type="text" name="artigo.tagsEmTexto"
				value="${artigo.getTagsParaExibicao()}">
		</div>
		<div class="form-group ">
			<c:if test="${empty artigo.id}">
				<input type="submit" class="btn btn-primary" value="Adicionar" />
			</c:if>
			<c:if test="${not empty artigo.id}">
				<input type="submit" class="btn btn-primary" value="Atualizar" />
			</c:if>
		</div>
	</div>