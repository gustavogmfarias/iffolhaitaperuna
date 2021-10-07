<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="card-body card-padding">
  <c:if test="${not empty usuario.id}">
    <input type="hidden" class="form-control" name="usuario.id"
			value="${usuario.id}">
    <input type="hidden" class="form-control" name="usuario.imagem"
			value="${usuario.imagem}">
  </c:if>
  
  <div class="form-group ">
    <label for="usuarioNome" class="control-label">Nome:</label>
    <input class="form-control required" id="usuarioNome" type="text" name="usuario.nome" value="${usuario.nome}">
  </div>
  
  <div class="form-group ">
    <label for="usuarioSenha" class="control-label">Senha:</label>
    <input class="form-control required" id="usuarioSenha" type="password" name="usuario.senha" value="${usuario.senha}">
  </div>
  
 <div class="form-group ">
    <label for="usuarioEmail" class="control-label">E-mail:</label>
    <input class="form-control required" id="usuarioEmail" type="email" name="usuario.email" value="${usuario.email}">
  </div>

 <div class="form-group ">
    <label for="usuarioImagem" class="control-label">Imagem:</label>
    <input class="form-control" id="usuarioImagem" type="file" name="imagemUsuario">
  </div>

 <div class="form-group ">
    <label for="usuarioPerfil" class="control-label">Perfil:</label>
	<select class="form-control required" name="usuario.perfil" >
    	<option value=""></option>
   		<option value="ADMINISTRADOR" <c:if test="${usuario.perfil=='ADMINISTRADOR'}">selected="selected"</c:if>>Administrador</option> 
    	<option value="EDITOR" <c:if test="${usuario.perfil=='EDITOR'}">selected="selected"</c:if>>Editor</option>
  </select>
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
