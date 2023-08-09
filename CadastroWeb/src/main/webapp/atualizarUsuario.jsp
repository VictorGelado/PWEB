<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Atualizar usuário</title>
	<link
		href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
		rel="stylesheet"
		integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
		crossorigin="anonymous">
</head>
<body>
	<h1>Atualizar usuário</h1>
	<form action="alterarUsuario">
	 	<label for="name">Nome: </label>
	 	<input type="text" id="name">
	 	
	 	<label for="email">Email: </label>
	 	<input type="text" id="email">
	 	
	 	<label for="senha">Senha: </label>
	 	<input type="text" id="senha">
	 	
	 	<button type="submit" class="btn btn-success">Alterar</button>
	</form>
</body>
</html>