<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="card-body card-padding">
  <c:if test="${not empty usuario.id}">
    <input type="hidden" class="form-control" name="usuario.id"
			value="${usuario.id}">
  </c:if>
  
    <div class="form-group ">
    <label for="usuarioSenha" class="control-label">Digite a Senha Anterior:</label>
    <input class="form-control required" id="usuarioSenha" type="password" name="usuario.senha" value="${usuario.senha}">
  </div>
  
  <div class="form-group ">
    <label for="usuarioSenha" class="control-label">Nova Senha:</label>
    <input class="form-control required" id="usuarioSenha" type="password" name="usuario.senha" value="${usuario.senha}">
  </div>
  
  <div class="form-group ">
    <label for="usuarioSenha" class="control-label">Digite novamente a nova Senha:</label>
    <input class="form-control required" id="usuarioSenha" type="password" name="usuario.senha" value="${usuario.senha}">
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
