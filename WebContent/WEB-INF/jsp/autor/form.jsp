<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="card-body card-padding">
  <c:if test="${not empty autor.id}">
    <input type="hidden" class="form-control" name="autor.id"
			value="${autor.id}">
    <input type="hidden" class="form-control" name="autor.imagem"
			value="${autor.imagem}">
	<input type="hidden" class="form-control" name="autor.novoEmail"
			value="${autor.email}">	
			
  </c:if>
  
  <div class="form-group ">
    <label for="autorNome" class="control-label">Nome:</label>
    <input class="form-control required" id="autorNome" type="text" name="autor.nome" value="${autor.nome}">
  </div>
  
 <div class="form-group ">
    <label for="autorEmail" class="control-label">E-mail:</label>
    <input class="form-control required" id="autorEmail" type="email" name="autor.email" value="${autor.email}">
  </div>

 <div class="form-group ">
    <label for="autorTelefone" class="control-label">Telefone:</label>
    <input class="form-control required" id="autorTelefone" type="tel" name="autor.telefone" value="${autor.telefone}">
  </div>

 <div class="form-group ">
    <label for="autorImagem" class="control-label">Foto:</label>
    <input class="form-control" id="autorImagem" type="file" name="imagemAutor">
  </div>

<div class="form-group ">
  <c:if test="${empty autor.id}">
    <input type="submit" class="btn btn-primary" value="Validar" />
  </c:if>
  <c:if test="${not empty autor.id}">
    <input type="submit" class="btn btn-primary" value="Validar" />
  </c:if>
  </div>
</div>
