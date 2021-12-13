<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List,br.com.empresa.gerenciador.servlet.Empresa" %>     
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Empresas</title>
</head>
<body>
	<h1>Lista de Empresas</h1>
	
	<ul>
		<c:forEach items="${empresas}" var="empresa">
			<fmt:parseDate  value="${empresa.dataAbertura}"  type="date" pattern="yyyy-MM-dd" var="parsedDate" />
			<fmt:formatDate value="${parsedDate}" type="date" pattern="dd/MM/yyyy" var="dataAberturaConvertida" />
		
			<li>${empresa.nome} - ${dataAberturaConvertida}</li>
		</c:forEach>
	</ul>
	
</body>
</html>