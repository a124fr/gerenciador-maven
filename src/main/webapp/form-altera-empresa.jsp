<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:url value="/altera-empresa" var="linkServletAlteraEmpresa" />

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Formulário Altera Empresa</title>
</head>
<body>
	<form method="post" action="${linkServletAlteraEmpresa}">
	
		<input type="hidden" name="id" value="${empresa.id}" />
		
		Nome: <input type="text" name="nome" value="${empresa.nome}" />
		
		<fmt:parseDate value="${empresa.dataAbertura}" type="date" pattern="yyyy-MM-dd" var="parsedDate" />
		<fmt:formatDate value="${parsedDate}" type="date" pattern="dd/MM/yyyy" var="dataAberturaConvertida" />
				
		Data Abertura: <input type="text" name="data" value="${dataAberturaConvertida}" />
		
		<input type="submit" />		
	</form>
</body>
</html>