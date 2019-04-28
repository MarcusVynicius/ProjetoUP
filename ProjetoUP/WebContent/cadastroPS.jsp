<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="DAO.DAOServico"%>
<%@page import="model.Servico"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Cadastro</title>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>

<body>

	<h2>Preencha o formulário</h2>
	<br />

	<form action="servletPS" method="post">


		<fieldset style="background-color:pink;">
			<legend>Dados Pessoais</legend>
			<table>
				<tr>
					<td><label for="nome">Nome: </label></td>
					<td align="left"><input type="text" name="nome"></td>
				</tr>
				<tr>
					<td><label for="cpf">Cpf: </label></td>
					<td align="left"><input type="text" name="cpf">
				</tr>
				<tr>
					<td><label for="email">Email: </label></td>
					<td align="left"><input type="email" name="email">
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
					<td><label for="senha">Senha: </label></td>
					<td align="left"><input type="password" name="senha">
				</tr>
				<tr>
					<td><label for="descricao">Descricao: </label></td>
					<td align="left"><input type="text" name="descricao" style="height: 120px;" size="40" >
				</tr>
			</table>
			<br>
			
			
				<select name="servico">
					<option>Serviços</option>
					<%
					
						ArrayList<Servico> sv = (ArrayList<Servico>)request.getAttribute("listaSv");

						for (Servico servico : sv) {
					%>

					<option   value="<%out.print(servico.getId());%>">
						<%
							out.print(servico.getNome());
							
						%>
					</option>

					<%
						}
					%>
				</select>
			

			<input type="submit" value="cadastrar">
			<% if(request.getAttribute("erroPS")!= null){
			%> 
			<p><% out.println(request.getAttribute("erroPS")); %> </p>	
			<% }
			%>
		</fieldset>
	</form>