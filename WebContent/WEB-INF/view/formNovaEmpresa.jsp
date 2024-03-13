<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
</head>
<body>
	<form action="/gerenciador/entrada" method="post">
		Nome: <input type="text" name="nome" />
		Data: <input type="text" name="data" />
		<input type="hidden" name="acao" value="NovaEmpresa">
			<input type="submit" />
	</form>
  </body>
</html>

</body>
</html>