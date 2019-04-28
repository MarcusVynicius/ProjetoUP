<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="model.Cliente"%>
<%
	Cliente c1 = (Cliente) session.getAttribute("cliente");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dados</title>
<h1>Alterar Dados</h1>
</head>
<body>

	<form action="servletCAlt" method="post">
		<fieldset>
			<fieldset style="width: 300px; background-color: pink;">
				<legend>Dados Pessoais</legend>
				<table cellspacing="10">
					<tr>
						<td><label for="nome">Nome: </label></td>
						<td align="left"><input type="text"
							value="<%out.print(c1.getNome());%>" name="nome"></td>
					</tr>
					<tr>
						<td><label for="cpf">Cpf: </label></td>
						<td align="left"><input type="text" disabled>
					</tr>
					<tr>
						<td><label for="endereco">Endereço: </label></td>
						<td align="left"><input type="text"
							value="<%out.print(c1.getEndereco());%>" name="endereco">
					</tr>
					<tr>
						<td><label for="telefone">Telefone: </label></td>
						<td align="left"><input type="text"
							value="<%out.print(c1.getTelefone());%>" name="telefone">
					</tr>
					<tr>
						<td><label for="email">Email: </label></td>
						<td align="left"><input type="email"
							value="<%out.print(c1.getEmail());%>" name="email">
					</tr>
					<tr>
						<td><label for="senha">Senha: </label></td>
						<td align="left"><input type="password"
							value="<%out.print(c1.getSenha());%>" name="senha">
					</tr>



				</table>
				<input type="submit" value="alterar">
			</fieldset>
	</form>

</body>
</html>