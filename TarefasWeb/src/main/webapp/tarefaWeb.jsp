<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-BR">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Tarefa-web</title>


<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
	
	<link rel="stylesheet" href="./CSS/index.css">
</head>

<body>
	<div class="center">
		<h1>Tarefa</h1>

		<div class="alinhamento">
			<label for="titulo" class="labels">Titulo:</label> 
			<input type="text" name="tiulo" id="titulo" value="${t.titulo}" class="titulo">
		</div>
		<div class="alinhamento">

			<Label for="areaTexto" class="labels">Descrição:</Label>
			<textarea name="areaTexto" id="areaTexto">${t.descricao}</textarea>
		</div>
		<div class="alinhamento">
			<a href="index.html" class="btn btn-primary">Voltar</a>
		</div>
	</div>

</body>

</html>