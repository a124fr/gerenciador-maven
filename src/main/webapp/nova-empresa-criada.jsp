<%
	String nomeEmpresa = String.valueOf(request.getAttribute("nomeEmpresa"));
	System.out.println(nomeEmpresa);			
%>
<!DOCTYPE html>

<html>
	<head>
		<title>Empresa criada!</title>
	</head>
	<body>
		<p>Empresa <%= nomeEmpresa %> cadastrada com sucesso!</p>		
	</body>
</html>