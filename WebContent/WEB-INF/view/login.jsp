<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <form action="/gerenciador/entrada" method="post">
        <label for="usuario">Usuário:</label>
        <input type="text" id="usuario" name="usuario" required />
        <br>
        <label for="senha">Senha:</label>
        <input type="password" id="senha" name="senha" required />
        <br>
        <input type="hidden" name="acao" value="NovaEmpresa">

        <input type="submit" value="Login" />
    </form>
</body>
</html>