<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../bootstrap/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="../base.css">
<meta charset="ISO-8859-1">
<title>Novo Usuario</title>
</head>
<body>


	<form action="<c:url value='/usuario/adiciona'/>" method="post" enctype="multipart/form-data"> 
	
		<%@include file="form.jsp"%>
	
	</form>


  <c:if test="${not empty errors}">
            <div class="alert alert-danger">
                <c:forEach var="error" items="${errors}">
                    ${error.category} - ${error.message}<br />
                </c:forEach>
            </div>
        </c:if>

</body>
</html>