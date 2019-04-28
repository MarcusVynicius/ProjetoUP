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

public class Contrato extends HttpServlet {
	   private static final long serialVersionUID = 1L;

	    protected void service (HttpServletRequest request ,HttpServletResponse response) throws ServletException, IOException{
	    	PrintWriter out = response.getWriter();
	    	PrestadorServico pres =(PrestadorServico) request.getSession().getAttribute("prestador");
	    	ServicePrestadorServico sps = new ServicePrestadorServico();
	    	try {
	    		request.setAttribute("listaCon", sps.listar(pres));
	    		 RequestDispatcher rDispatcher = request.getRequestDispatcher("contratarServ.jsp");
		    	   rDispatcher.forward(request, response);
	    		
	    	}catch(Exception e) {
	    		out.println("erro " + e.getMessage());
	    	}
	    	
	    }   	
}
