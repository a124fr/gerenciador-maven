<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/nova-empresa" var="linkServletNovaEmpresa" />

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Formul�rio Cadastro de Empresa</title>
</head>
<body>
	<form method="post" action="${linkServletNovaEmpresa}">
		
		Nome: <input type="text" name="nome" />
		
		Data Abertura: <input type="text" name="data" />
		
		<input type="submit" />		
	</form>
</body>
</html>