package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PrestadorServico;
import model.ServicePrestadorServico;

public class ControllerPrestadorServicoAlt extends HttpServlet {
	   private static final long serialVersionUID = 1L;

	    protected void service (HttpServletRequest request ,HttpServletResponse response) throws ServletException, IOException{
	    	 PrintWriter out = response.getWriter(); 
	    	 String nome = request.getParameter("nome");
	    	 String cpf = request.getParameter("cpf");
		     String endereco = request.getParameter("endereco");
		     String email = request.getParameter("email");
		     String telefone = request.getParameter("telefone");
		     String senha = request.getParameter("senha");
	         
		     ServicePrestadorServico sps = new ServicePrestadorServico();
		     PrestadorServico pres = new PrestadorServico();
		     pres.setNome(nome);
		     pres.setCpf(cpf);
		     pres.setEndereco(endereco);
		     pres.setEmail(email);
		     pres.setTelefone(telefone);
		     pres.setSenha(senha);
		     try {
		    	   sps.atualizar(pres);
		    	   out.println("Dados Alterados com Sucesso!");
		    	   RequestDispatcher rDispatcher = request.getRequestDispatcher("prestadorMenu.jsp");
					rDispatcher.forward(request, response);
		       }catch(Exception e) {
		    	   out.println("Erro ao alterar "+ e.getMessage());
		       }
	    }
}
