    <p>
  <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	      
  <c:if test="${not empty usuario.id}">
    <input type="hidden" class="form-control" name="usuario.id" value="${usuario.id}"> 
    <input type="hidden" class="form-control" name="usuario.imagem" value="${usuario.imagem}"> 
  </c:if>
</p>
    <p>Nome:
  <input class="form-control" type="text" name="usuario.nome" value="${usuario.nome}"> 
    <br>
    Senha:
<input type="text" class="form-control" name="usuario.senha" value="${usuario.valor}"> 
      <br>
      E-mail:
<input type="text" class="form-control" name="usuario.email" value="${usuario.email}">
<br>
Imagem:
<input type="file" class="form-control"  name="imagemUsuario" />
    </p>
		
		
		<c:if test="${empty usuario.id}">
		<input type="submit" class="btn btn-primary" value="Adicionar" />
</c:if>
		
		<c:if test="${not empty produto.id}">
		<input type="submit" class="btn btn-primary" value="Editar" />
		</c:if>
	
		
		