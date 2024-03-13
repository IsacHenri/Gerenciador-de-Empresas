<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<c:if test="${not empty empresa}">
		A empresa ${empresa}  foi cadastrada com sucesso!
	</c:if>
	<c:if test="${empty empresa}">
		Nenhuma empresa cadastrada!!
	</c:if>
	
	<form action="/gerenciador/listarEmpresas" method="post">
    	<input type="submit" value="Lista">
	</form>
</body>
</html>