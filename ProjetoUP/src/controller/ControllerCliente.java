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

public class ControllerCliente extends HttpServlet {
	   private static final long serialVersionUID = 1L;

	    protected void service (HttpServletRequest request ,HttpServletResponse response) throws ServletException, IOException{
	        PrintWriter out = response.getWriter();
	        String nome = request.getParameter("nome");
	        String cpf = request.getParameter("cpf");
	        String endereco = request.getParameter("endereco");
	        String email = request.getParameter("email");
	        String telefone = request.getParameter("telefone");
	        String senha = request.getParameter("senha");

	        Cliente c = new Cliente();
	        c.setCpf(cpf);
	        c.setNome(nome);
	        c.setEndereco(endereco);
	        c.setEmail(email);
	        c.setTelefone(telefone);
	        c.setSenha(senha);	       
	        
	        request.setAttribute("erroC", null);
	        request.setAttribute("cadastro", null);
	        
	        ServiceCliente sc = new ServiceCliente();
	        try {
	            
	        	sc.cadastrar(c);
	        	String cadastro = "Cadastrado com sucesso!";
	            request.setAttribute("cadastro", cadastro);
		        RequestDispatcher rDispatcher = request.getRequestDispatcher("telaInicial.jsp");
				rDispatcher.forward(request, response);
	            
	        } catch (Exception e) {
	        	out.print(e.getMessage());
	        	String erro ="Erro ao cadastrar! "+e.getMessage();
				request.setAttribute("erroC", erro);
	        	RequestDispatcher rDispatcher = request.getRequestDispatcher("cadastroC.jsp");
				rDispatcher.forward(request, response);
				
	        }
	        

	    }
	}


