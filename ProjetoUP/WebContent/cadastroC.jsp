<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro</title>
</head>
<body>
<body>

	<h2>Preencha o formulário</h2>
	<br />

	<form action="servletCC" method="post">


		<fieldset style="width:300px;background-color:pink;">
			<legend>Dados Pessoais</legend>
			<table cellspacing="10">
				<tr>
					<td><label for="nome">Nome: </label></td>
					<td align="left"><input type="text" name="nome"></td>
				</tr>
				<tr>
					<td><label for="cpf">Cpf: </label></td>
					<td align="left"><input type="text" name="cpf">
				</tr>
				<tr>
					<td><label for="endereco">Endereço: </label></td>
					<td align="left"><input type="text" name="endereco">
				</tr>
				<tr>
					<td><label for="telefone">Telefone: </label></td>
					<td align="left"><input type="text" name="telefone">
				</tr>
				<tr>
					<td><label for="email">Email: </label></td>
					<td align="left"><input type="email" name="email">
				</tr>
				<tr>
					<td><label for="senha">Senha: </label></td>
					<td align="left"><input type="password" name="senha">
				</tr>
				

 
			</table>
			<input type="submit" value="cadastrar">
			<% if(request.getAttribute("erroC")!= null){
			%> 
			<p><% out.println(request.getAttribute("erroC")); %> </p>	
			<% }
			%>
		</fieldset>
	</form>

</body>
</html>