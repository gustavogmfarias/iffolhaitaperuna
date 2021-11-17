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
    <label for="configTitulo" class="control-label">Título:</label>
    <input class="form-control required" id="configTitulo" type="text" name="configuracao.titulo" value="${configuracao.titulo}">
  </div>
  
	<div class="form-group ">
		<label for="configLogo" class="control-label">Logo </label> <input class="form-control file-imagem" id="configLogo"
			type="file" name="configLogo"
			data-initialPreview='[{"urlCompleta":"${sessao.urlPadrao}img/imagens-config/${configuracao.logo}"}]'>
	</div>

	<div class="form-group ">
		<label for="configFavIcon" class="control-label">FavIcon: </label> <input class="form-control file-imagem" id="configFavIcon"
			type="file" name="configFavIcon"
			data-initialPreview='[{"urlCompleta":"${sessao.urlPadrao}img/imagens-config/${configuracao.favicon}"}]'>
	</div>
  
 <div class="form-group ">
    <label for="configcorBarraPrincipal" class="control-label">Cor da Barra Principal do site</label>
    <input class="form-control required" id="configcorBarraPrincipal" name="configuracao.corBarraPrincipal" value="${configuracao.corBarraPrincipal}">
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
