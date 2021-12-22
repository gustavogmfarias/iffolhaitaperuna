<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="card-body card-padding">
	<c:if test="${not empty newsletter.id}">
		<input type="hidden" class="form-control" name="newsletter.id"
			value="${newsletter.id}">
		<input type="hidden" class="form-control" name="emailAnterior"
			value="${newsletter.email}">
	</c:if>

	<div class="form-group ">
		<label for="newsletterNome" class="control-label">Email:</label> <input
			class="form-control required" id="newsletterEmail" type="text"
			name="newsletter.email" value="${newsletter.email}">
	</div>

	<div class="form-group ">
		<c:if test="${empty newsletter.id}">
			<input type="submit" class="btn btn-primary" value="Validar" />
		</c:if>
		<c:if test="${not empty newsletter.id}">
			<input type="submit" class="btn btn-primary" value="Validar" />
		</c:if>
	</div>
</div>
