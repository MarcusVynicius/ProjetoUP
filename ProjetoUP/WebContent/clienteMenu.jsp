<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="DAO.DAOServico"%>
<%@page import="model.Servico"%>
<%@page import="java.util.*"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="model.Cliente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	Cliente c1 = (Cliente) session.getAttribute("cliente");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu</title>
</head>
<h1>
	Bem vindo! <% out.print(c1.getNome());%>	
</h1>

<body>
	<a href="clienteAlterar.jsp">Alterar dados</a>
	<br>
	<br>
	<br>
	<a href="clienteAlterar.jsp">Deletar</a>
	<br>
	<br>
	<br>
	<a href="telaInicial.jsp">Sair</a>
	<br>
	<br>
	<br>
	<fieldset style="width: 500px; margin: auto; background-color: pink;">
		<legend style="margin: auto;">Procurar Serviços!</legend>
		
		<br>
		<select style="margin-left: 200px; margin-top: 30px; margin-bottom: 30px;">
		<option>Serviços</option>
		<%
			//DAOServico dao = new DAOServico();
			//ArrayList<Servico> sv = dao.listarGeral();
			
			//for (Servico servico : sv) {
		%>
		<option>A</option>

		<%//}
			%>
</select>

		<br> <a href="servletContrato"><button
				style="margin-left: 200px; margin-top: 30px; margin-bottom: 30px;">Pesquisar</button></a>
	</fieldset>

</body>
</html>