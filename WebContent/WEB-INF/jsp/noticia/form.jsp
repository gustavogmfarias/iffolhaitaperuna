<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<div class="card-body card-padding">
  <c:if test="${not empty noticia.id}">
    <input type="hidden" class="form-control" name="noticia.id"
			value="${noticia.id}">
	
  </c:if>
  
  <div class="form-group ">
    <label for="noticiaTitulo" class="control-label">Título:</label>
    <input class="form-control required" id="noticiaTitulo" type="text" name="noticia.titulo" value="${noticia.titulo}">
  </div>
  
    <div class="form-group ">
    <label for="noticiaSubTitulo" class="control-label">SubTítulo:</label>
    <input class="form-control required" id="noticiaSubTitulo" type="text" name="noticia.subtitulo" value="${noticia.subtitulo}">
  </div>
  
     <div class="form-group ">
    <label for="noticiaConteudo" class="control-label">Conteúdo:</label>
    <textarea class="form-control required" id="noticiaConteudo" name="noticia.conteudo">${noticia.conteudo}</textarea>
  </div>
    
     <div class="form-group ">
    <label for="autoresNoticia" class="control-label">Autores:</label>
	<select multiple class="form-control required" id="autoresNoticia" name="noticia.autores[].id" >
    	
		<option value="">Selecione os autores</option>
    	<c:forEach items="${autoresList}" var="autor">
	   		<option value="${autor.id}" <c:if test="${fn:contains(noticia.autores, autor)}">selected="selected"</c:if>>${autor.nome}</option> 
		</c:forEach>
  	</select>
  </div>
  
  
       <div class="form-group ">
    <label for="turmasNoticia" class="control-label">Turmas:</label>
	<select multiple class="form-control " id="turmasNoticia" name="noticia.turmas[].id" >
    	
		<option value="">Selecione as turmas</option>
    	<c:forEach items="${turmasList}" var="turma">
	   		<option value="${turma.id}" <c:if test="${fn:contains(noticia.turmas, turma)}">selected="selected"</c:if>>${turma.nome}</option> 
		</c:forEach>
  	</select>
  </div>
  
        <div class="form-group ">
    <label for="cursosNoticia" class="control-label">Cursos:</label>
	<select multiple class="form-control " id="turmasNoticia" name="noticia.cursos[].id" >
    	
		<option value="">Selecione os Cursos</option>
    	<c:forEach items="${cursosList}" var="curso">
	   		<option value="${curso.id}" <c:if test="${fn:contains(noticia.cursos, curso)}">selected="selected"</c:if>>${curso.nome}</option> 
		</c:forEach>
  	</select>
  </div>
  
<div class="form-group custom-control custom-switch">
        <input name="noticia.ehDestaque" type="checkbox" class="custom-control-input" id="ehDestaque" <c:if
            test="${empty noticia.id || noticia.ehDestaque == true}">checked="checked"</c:if> >
        <label class="custom-control-label" for="ehDestaque">Notícia Destaque</label>
    </div>
    
   
      <div class="form-group ">
    <label for="noticiaOrdemDestaque" class="control-label">Ordem Destaque:</label>
    <input class="form-control " id="noticiaOrdemDestaque" type="text" name="noticia.ordemDestaque" value="${noticia.ordemDestaque}">
  </div>


<div class="form-group ">
  <c:if test="${empty noticia.id}">
    <input type="submit" class="btn btn-primary" value="Validar" />
  </c:if>
  <c:if test="${not empty noticia.id}">
    <input type="submit" class="btn btn-primary" value="Validar" />
  </c:if>
  </div>
</div>
