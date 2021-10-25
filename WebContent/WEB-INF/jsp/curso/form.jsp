<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="card-body card-padding">
  <c:if test="${not empty curso.id}">
    <input type="hidden" class="form-control" name="curso.id"
			value="${curso.id}">
			 <input type="hidden" class="form-control" name="nomeAnterior"
			value="${curso.nome}">
  </c:if>
  
  <div class="form-group ">
    <label for="cursoNome" class="control-label">Nome:</label>
    <input class="form-control required" id="cursoNome" type="text" name="curso.nome" value="${curso.nome}">
  </div>
  
<div class="form-group ">
  <c:if test="${empty curso.id}">
    <input type="submit" class="btn btn-primary" value="Validar" />
  </c:if>
  <c:if test="${not empty curso.id}">
    <input type="submit" class="btn btn-primary" value="Validar" />
  </c:if>
  </div>
</div>
