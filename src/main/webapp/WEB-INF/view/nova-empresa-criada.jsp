<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Empresa criada!</title>
	</head>
	<body>
		<c:import url="logout-parcial.jsp" />
	
		<c:if test="${not empty nomeEmpresa}">
			<p>Empresa ${ nomeEmpresa } cadastrada com sucesso!</p>
		</c:if>
		<c:if test="${empty nomeEmpresa}">
			<p>Nenhuma empresa cadastrada!</p>		
		</c:if>
	</body>
</html>