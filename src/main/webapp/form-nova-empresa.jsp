<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada" var="linkEntradaServlet" />

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Formulário Cadastro de Empresa</title>
</head>
<body>
	<form method="post" action="${linkEntradaServlet}">
		<input type="hidden" name="acao" value="NovaEmpresa" />
		Nome: <input type="text" name="nome" />
		
		Data Abertura: <input type="text" name="data" />
		
		<input type="submit" />		
	</form>
</body>
</html>