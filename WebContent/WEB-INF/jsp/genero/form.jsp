<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="card-body card-padding">
  <c:if test="${not empty generoTexto.id}">
    <input type="hidden" class="form-control" name="generoTexto.id"
			value="${generoTexto.id}">
  </c:if>
  
  <div class="form-group ">
    <label for="generoTextoGenero" class="control-label">Gênero:</label>
    <input class="form-control required" id="generoTextoGenero" type="text" name="generoTexto.genero" value="${generoTexto.genero}">
  </div>
  
<div class="form-group ">
  <c:if test="${empty generoTexto.id}">
    <input type="submit" class="btn btn-primary" value="Validar" />
  </c:if>
  <c:if test="${not empty generoTexto.id}">
    <input type="submit" class="btn btn-primary" value="Validar" />
  </c:if>
  </div>
</div>
