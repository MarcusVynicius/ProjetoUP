package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cliente;
import model.ServiceCliente;

public class ControllerClienteAlt extends HttpServlet {
	   private static final long serialVersionUID = 1L;

	    protected void service (HttpServletRequest request ,HttpServletResponse response) throws ServletException, IOException{
	    	    PrintWriter out = response.getWriter();
	    	    String nome = request.getParameter("nome");
	    	    //String cpf = request.getParameter("cpf");
		        String endereco = request.getParameter("endereco");
		        String email = request.getParameter("email");
		        String telefone = request.getParameter("telefone");
		        String senha = request.getParameter("senha");   
		        Cliente c1 = (Cliente) request.getSession().getAttribute("cliente");
		        ServiceCliente sc = new ServiceCliente();
		        Cliente c = new Cliente();		        
		        c.setNome(nome);
		        c.setCpf(c1.getCpf());
		        c.setEndereco(endereco);
		        c.setEmail(email);
		        c.setTelefone(telefone);
		        c.setSenha(senha);        
		        		        
		       try {
		    	   sc.atualizar(c);
		    	   out.println("Dados Alterados com Sucesso!");
		    	   HttpSession session = request.getSession();
		    	   session.setAttribute("cliente", c);
		    	   RequestDispatcher rDispatcher = request.getRequestDispatcher("clienteMenu.jsp");
		    	   rDispatcher.forward(request, response);
		       }catch(Exception e) {
		    	   out.println("Erro ao alterar "+ e.getMessage());
		       }
	    }

}
