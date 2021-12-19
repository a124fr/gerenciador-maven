<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page	import="java.util.List,br.com.empresa.gerenciador.modelo.Empresa"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Empresas</title>
</head>
<body>
	<c:import url="logout-parcial.jsp" />
		
	Usuário Logado: ${usuarioLogado.login} 

	<c:if test="${not empty nomeEmpresa}">
		<p>Empresa ${nomeEmpresa} cadastrada com sucesso!</p>
	</c:if>

	<h1>Lista de Empresas</h1>

	<a href="/gerenciador-maven/entrada?acao=NovaEmpresaForm">inserir</a>
	<ul>
		<c:forEach items="${empresas}" var="empresa">
			<fmt:parseDate value="${empresa.dataAbertura}" type="date" pattern="yyyy-MM-dd" var="parsedDate" />
			<fmt:formatDate value="${parsedDate}" type="date" pattern="dd/MM/yyyy" var="dataAberturaConvertida" />

			<li>
				${empresa.nome}- ${dataAberturaConvertida} 
				<a href="/gerenciador-maven/entrada?acao=MostraEmpresa&id=${empresa.id}">editar</a>
				<a href="/gerenciador-maven/entrada?acao=RemoveEmpresa&id=${empresa.id}">remover</a>	
			</li>
		</c:forEach>
	</ul>

</body>
</html>