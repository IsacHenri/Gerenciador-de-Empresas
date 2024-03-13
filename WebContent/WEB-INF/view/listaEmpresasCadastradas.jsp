<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/entrada?acao=Cadastrar" var="formNovo" />

<html>
<body>

	Empresas cadastradas: <br>
	
	<ul> 
		<c:forEach items="${empresas}" var="empresa">
			<li> ${empresa.nome} <fmt:formatDate value="${empresa.data}" pattern="dd/MM/yyyy"/> 
			<a href="/gerenciador/entrada?acao=RemoveEmpresa&id=${empresa.id}">excluir</a>
			<a href="/gerenciador/entrada?acao=MostraEmpresa&id=${empresa.id}">alterar</a>
			</li>
		</c:forEach>
	</ul>
	
	<form action="${formNovo}" method="post">
    	<input type="submit" value="Adicionar">
	</form>
	
</body>
</html>