<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="card-body card-padding">
	<c:if test="${not empty configuracao.id}">
		<input type="hidden" class="form-control" name="configuracao.id"
			value="${configuracao.id}">
		<input type="hidden" class="form-control" name="configuracao.logo"
			value="${configuracao.logo}">
		<input type="hidden" class="form-control" name="configuracao.favicon"
			value="${configuracao.favicon}">
	</c:if>

	<div class="form-group ">
		<label for="configTitulo" class="control-label">Título:</label> <input
			class="form-control required" id="configTitulo" type="text"
			name="configuracao.titulo" value="${configuracao.titulo}">
	</div>

	<div class="form-group ">
		<label for="configLogo" class="control-label">Logo </label> <input
			class="form-control file-imagem" id="configLogo" type="file"
			name="configLogo"
			data-initialPreview='[{"urlCompleta":"${sessao.urlPadrao}img/imagens-config/${configuracao.logo}"}]'>
	</div>

	<div class="form-group ">
		<label for="configFavIcon" class="control-label">FavIcon: </label> <input
			class="form-control file-imagem" id="configFavIcon" type="file"
			name="configFavIcon"
			data-initialPreview='[{"urlCompleta":"${sessao.urlPadrao}img/imagens-config/${configuracao.favicon}"}]'>
	</div>

	<div class="form-group ">
		<label for="configcorBarraPrincipal" class="control-label">Cor
			da Barra Principal do site</label> <input class="form-control required"
			id="configcorBarraPrincipal" name="configuracao.corBarraPrincipal"
			value="${configuracao.corBarraPrincipal}">
	</div>

	<div class="form-group custom-control custom-switch">
		<input name="configuracao.menuAlertaAtivo" type="checkbox"
			class="custom-control-input" id="menuAlertaAtivo"
			<c:if
            test="${configuracao.menuAlertaAtivo == true}">checked="checked"</c:if>>
		<label class="custom-control-label" for="menuAlertaAtivo">Menu
			Alerta Ativo?</label>
	</div>
	<div class="form-row ordem-destaque">
		<div class="form-group col-md ">
			<label for="menuAlerta" class="control-label">Conteúdo
				Alerta: (html)</label> <input class="form-control " id="menuAlerta"
				type="text" name="configuracao.menuAlerta"
				value="${configuracao.menuAlerta}">
		</div>
	</div>

	<div class="form-group ">
		<label for="facebook" class="control-label">Link do Facebook:</label>
		<input class="form-control" id="facebook" name="configuracao.facebook"
			value="${configuracao.facebook}">
	</div>

	<div class="form-group ">
		<label for="youtube" class="control-label">Link do Youtube:</label> <input
			class="form-control" id="youtube" name="configuracao.youtube"
			value="${configuracao.youtube}">
	</div>

	<div class="form-group ">
		<label for="instagram" class="control-label">Link do
			Instagram:</label> <input class="form-control" id="instagram"
			name="configuracao.instagram" value="${configuracao.instagram}">
	</div>

	<div class="form-group ">
		<c:if test="${empty configuracao.id}">
			<input type="submit" class="btn btn-primary" value="Validar" />
		</c:if>
		<c:if test="${not empty configuracao.id}">
			<input type="submit" class="btn btn-primary" value="Validar" />
		</c:if>
	</div>
</div>
