package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PrestadorServico;
import model.ServicePrestadorServico;

public class ControllerPrestadorServicoD extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void service (HttpServletRequest req ,HttpServletResponse resp) throws ServletException, IOException{
        PrintWriter out = resp.getWriter(); {
        String cpf = req.getParameter("cpf");
        String senha = req.getParameter("senha");	
        ServicePrestadorServico sps = new ServicePrestadorServico();
        PrestadorServico pres = new PrestadorServico();
        pres.setCpf(cpf);
        pres.setSenha(senha);
        try {            
        	sps.deletar(pres);
            out.println("<html>");
            out.println("<body>");
            out.println("Usuário excluído com sucesso");
            out.println("</body>");
            out.println("</html>");  
            
         }catch (Exception e) {
            out.println("ERRO!!!"+e.getMessage());
            }
        }
    }

}
