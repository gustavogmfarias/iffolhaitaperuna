<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="card-body card-padding">
  <c:if test="${not empty turma.id}">
    <input type="hidden" class="form-control" name="turma.id"
			value="${turma.id}">
  </c:if>
  
  <div class="form-group ">
    <label for="turmaNome" class="control-label">Nome:</label>
    <input class="form-control required" id="turmaNome" type="text" name="turma.nome" value="${turma.nome}">
  </div>
  
 <div class="form-group ">
    <label for="turmaCurso" class="control-label">Curso:</label>
	<select class="form-control required" id="turmaCurso" name="turma.curso.id" >
    	
		<option value="">Selecione um curso</option>
    	<c:forEach items="${cursoList}" var="curso">
	   		<option value="${curso.id}" <c:if test="${curso.id == turma.curso.id}">selected="selected"</c:if>>${curso.nome}</option> 
		</c:forEach>
  	</select>
  </div>


<div class="form-group ">
  <c:if test="${empty turma.id}">
    <input type="submit" class="btn btn-primary" value="Validar" />
  </c:if>
  <c:if test="${not empty turma.id}">
    <input type="submit" class="btn btn-primary" value="Validar" />
  </c:if>
  </div>
</div>
