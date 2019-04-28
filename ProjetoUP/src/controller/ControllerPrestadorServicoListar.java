package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Contrato;
import model.ServiceContrato;

public class ControllerPrestadorServicoListar extends HttpServlet {
	   private static final long serialVersionUID = 1L;

	    protected void service (HttpServletRequest request ,HttpServletResponse response) throws ServletException, IOException{
	    	PrintWriter out = response.getWriter();
	    	Contrato c =(Contrato)request.getSession().getAttribute("prestador");
	    	try {
		    	   ServiceContrato sc = new ServiceContrato();
		    	   request.setAttribute("listaPS", sc.listarPs(c));
		    	   RequestDispatcher rDispatcher = request.getRequestDispatcher("prestadorListar.jsp");
		    	   rDispatcher.forward(request, response);
		    		
		    	}catch(Exception e) {
		    		out.println("erro "+e.getMessage());
		    	}
		    	
	    }
}
