package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DAOCliente;
import model.Cliente;

public class ControllerClienteLG extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String cpf = request.getParameter("cpf");
		String senha = request.getParameter("senha");

		request.setAttribute("erroCLG", null);
		
		DAOCliente dao = new DAOCliente();
		try {
			if (dao.verificaLogin(cpf, senha) != null) {
				Cliente c1 = dao.verificaLogin(cpf, senha);
				HttpSession session = request.getSession();
				session.setAttribute("cliente", c1);
				RequestDispatcher rDispatcher = request.getRequestDispatcher("clienteMenu.jsp");
				rDispatcher.forward(request, response);
				
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
		    String erro ="Erro ao fazer login! ";
		   	request.setAttribute("erroCLG", erro);
			RequestDispatcher rDispatcher = request.getRequestDispatcher("cliente.jsp");
	    	rDispatcher.forward(request, response);
	       
		}

	}

}
