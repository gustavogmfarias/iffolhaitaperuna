<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<div class="card-body card-padding">
  <c:if test="${not empty noticia.id}">
    <input type="hidden" class="form-control" name="noticia.id"
			value="${noticia.id}">
	<input type="hidden" class="form-control" name="usuario.imagem"
			value="${noticia.imagemPrincipal}">
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
    <label for="noticiaConteudo" class="control-label textarea init">Conteúdo:</label>
    <textarea class="form-control required custom-html" id="noticiaConteudo" name="noticia.conteudo">${noticia.conteudo}</textarea>
  </div>
  
   <div class="form-group ">
    <label for="imagemNoticia" class="control-label">Imagem Principal:</label>
    <input class="form-control file-imagem" id="imagemNoticia" type="file" name="imagemNoticia"
    
    data-initialPreview='[{"urlCompleta":"${sessao.urlPadrao}img/imagens-noticia/${noticia.imagemPrincipal}"}]'
    
    >
  </div>
  
  <div class="form-group ">
    <label for="autoresNoticia"  class="control-label">Autores:</label>
    <select multiple data-live-search="true" class="form-control required custom-select" id="autoresNoticia" name="noticia.autores[].id" >
      <c:forEach items="${autoresList}" var="autor">
        <option value="${autor.id}" <c:if test="${fn:contains(noticia.autores, autor)}">selected="selected"</c:if>>${autor.nome}</option>
      </c:forEach>
    </select>
  </div>
  <div class="form-group ">
    <label for="turmasNoticia" class="control-label">Turmas:</label>
    <select multiple data-live-search="true" class="form-control custom-select" id="turmasNoticia" name="noticia.turmas[].id" >
      <c:forEach items="${turmasList}" var="turma">
        <option value="${turma.id}" <c:if test="${fn:contains(noticia.turmas, turma)}">selected="selected"</c:if>>${turma.nome}</option>
      </c:forEach>
    </select>
  </div>
  <div class="form-group ">
    <label for="cursosNoticia" class="control-label">Cursos:</label>
    <select data-live-search="true" liveSearchStyle="startsWith" multiple class="form-control custom-select" id="turmasNoticia" name="noticia.cursos[].id" >
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
  <div class="form-row ordem-destaque" <c:if test="${not empty noticia.id && noticia.ehDestaque==false }">style="display:none;"</c:if>>
    <div class="form-group col-md-1">
      <label for="noticiaOrdemDestaque" class="control-label">Ordem Destaque:</label>
      <input class="form-control " id="noticiaOrdemDestaque" type="text" name="noticia.ordemDestaque" value="${noticia.ordemDestaque}">
    </div>
  </div>
  
   <div class="form-group custom-control custom-switch">
    <input name="noticia.ehAtiva" type="checkbox" class="custom-control-input" id="ehAtiva" <c:if
            test="${empty noticia.id || noticia.ehAtiva == true}">checked="checked"</c:if> >
    <label class="custom-control-label" for="ehAtiva">Notícia Ativa</label>
  </div>
  
  <div class="form-group ">
    <label for="noticiaTags" class="control-label">Tags:</label>
    <input data-role="tagsinput" class="form-control " id="noticiaTags" type="text" name="noticia.tagsEmTexto" value="${noticia.getTagsParaExibicao()}">
  </div>
  <div class="form-group ">
    <c:if test="${empty noticia.id}">
      <input type="submit" class="btn btn-primary" value="Adicionar" />
    </c:if>
    <c:if test="${not empty noticia.id}">
      <input type="submit" class="btn btn-primary" value="Atualizar" />
    </c:if>
  </div>
</div>
