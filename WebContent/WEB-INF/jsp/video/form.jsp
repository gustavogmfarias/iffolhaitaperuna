<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="card-body card-padding">
	<c:if test="${not empty video.id}">
		<input type="hidden" class="form-control" name="video.id"
			value="${video.id}">
		<input type="hidden" class="form-control" name="video.imagem"
			value="${video.imagem}">
		<input type="hidden" class="form-control" name="video.novoLink"
			value="${video.link}">

	</c:if>

	<div class="form-group ">
		<label for="videoDescricao" class="control-label">Descrição:</label>
		<input class="form-control required" id="videoDescricao" type="tel"
			name="video.descricao" value="${video.descricao}">
	</div>

	<div class="form-group ">
		<label for="videoLink" class="control-label">Link:</label> <input
			class="form-control required" id="videoLink" type="text"
			name="video.link" value="${video.link}">
	</div>

	<div class="form-group ">
		<label for="videoImagem" class="control-label">Imagem de Capa:</label> <input
			class="form-control" id="videoImagem" type="file" name="imagemVideo">
	</div>

	<div class="form-group ">
		<c:if test="${empty video.id}">
			<input type="submit" class="btn btn-primary" value="Validar" />
		</c:if>
		<c:if test="${not empty video.id}">
			<input type="submit" class="btn btn-primary" value="Validar" />
		</c:if>
	</div>
</div>
