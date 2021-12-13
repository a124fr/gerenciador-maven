<%
	String nomeEmpresa = "Alura";
	System.out.println(nomeEmpresa);		
%>
<!DOCTYPE html>

<html>
	<head>
		<title>Empresa criada!</title>
	</head>
	<body>
		<p>Empresa <%= nomeEmpresa %> cadastrada com sucesso!</p>
		<p>Empresa <% out.println(nomeEmpresa); %> cadastrada com sucesso!</p>
	</body>
</html>