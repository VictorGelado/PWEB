<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>
	<div class="container-fluid">
		<h1>Tarefas</h1>
		<table class="table">
			<thead>
				<tr>
					<th>Id</th>
					<th>Rementente</th>
					<th>Destinatário</th>
					<th>Titulo</th>
					<th>Descrição</th>
					<!--<th>&nbsp;</th>-->
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${e}" var="e" varStatus="id">
					<tr>
						<td>${e.id}</td>
						<td>${e.rementente}</td>
						<td>${e.destinatario}</td>
						<td>${e.titulo}</td>
						<td>${e.descricao}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="index.html" class="btn btn-primary">Voltar</a>
	</div>
</body>
</html>