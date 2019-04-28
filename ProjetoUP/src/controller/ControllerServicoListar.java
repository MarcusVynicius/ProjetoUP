package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Dispatch;

import DAO.DAOServico;
import model.Servico;

public class ControllerServicoListar extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			DAOServico dao = new DAOServico();
			ArrayList<Servico> sv = dao.listarGeral();
			HttpSession sessi = req.getSession();
			sessi.setAttribute("serv", sv);			
			req.setAttribute("listaSv", sv );
			RequestDispatcher rDispatcher = req.getRequestDispatcher("cadastroPS.jsp");
	    	rDispatcher.forward(req, resp);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
