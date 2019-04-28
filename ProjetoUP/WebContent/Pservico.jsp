<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<h1 align="center">P.Serviço</h1>
</head>
<body>
	<form action="servletPSLG" method="post">
		<fieldset style="width:300px;margin:auto;background-color:pink;">
		<table widht="300" cellpadding="10" align="center">
			<tr>
				<td>Cpf:</td>
				<td><input type="text" name="cpf"></td>
			</tr>

			<tr>
				<td>Senha:</td>
				<td><input type="password" name="senha"></td>
			</tr>
			<tr>
				<td><input type="reset" value="Limpar Campos"></td>
				<td><input type="submit" value="Entrar"></td>
			</tr>
		</table>
	</form>
	<a href="servletSvLista" align="center">Cadastre-se Aqui!</a>
	<% if(request.getAttribute("erroPSLG")!= null){
	%> 
	<p><% out.println(request.getAttribute("erroPSLG")); %> </p>	
	<% }
	%>
	</fieldset>
	

</body>
</html>