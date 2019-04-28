package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DAOPrestadorServico;
import model.PrestadorServico;

public class ControllerPrestadorServicoLG  extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String cpf = request.getParameter("cpf");
		String senha = request.getParameter("senha");
		
		request.setAttribute("erroPSLG", null);
		
		DAOPrestadorServico dps = new DAOPrestadorServico();
		try {
			if (dps.verificaLogin(cpf, senha) != null) {
				PrestadorServico ps = dps.verificaLogin(cpf, senha);
				HttpSession session = request.getSession();
				session.setAttribute("prestador", ps);
				RequestDispatcher rDispatcher = request.getRequestDispatcher("prestadorMenu.jsp");
				rDispatcher.forward(request, response);
				
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			String erro ="Erro ao fazer login! ";
	   	    request.setAttribute("erroPSLG", erro);
			RequestDispatcher rDispatcher = request.getRequestDispatcher("Pservico.jsp");
	    	rDispatcher.forward(request, response);
	        
		}

	}
}
