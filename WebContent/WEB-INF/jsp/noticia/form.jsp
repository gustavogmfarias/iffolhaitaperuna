<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="card-body card-padding">
  <c:if test="${not empty usuario.id}">
    <input type="hidden" class="form-control" name="usuario.id"
			value="${usuario.id}">
    <input type="hidden" class="form-control" name="usuario.imagem"
			value="${usuario.imagem}">
	<input type="hidden" class="form-control" name="usuario.novoEmail"
			value="${usuario.email}">
  </c:if>
  
  <div class="form-group ">
    <label for="usuarioNome" class="control-label">Nome:</label>
    <input class="form-control required" id="noticiaTitulo" type="text" name="usuario.nome" value="${usuario.nome}">
  </div>
  
<div class="form-group ">
  <c:if test="${empty usuario.id}">
    <input type="submit" class="btn btn-primary" value="Validar" />
  </c:if>
  <c:if test="${not empty usuario.id}">
    <input type="submit" class="btn btn-primary" value="Validar" />
  </c:if>
  </div>
</div>
