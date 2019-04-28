package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cliente;
import model.ServiceCliente;

public class ControllerClienteD extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void service (HttpServletRequest req ,HttpServletResponse resp) throws ServletException, IOException{
        PrintWriter out = resp.getWriter();
        String cpf = req.getParameter("cpf");
        String senha = req.getParameter("senha");        
        ServiceCliente sc = new ServiceCliente();
        Cliente c = new Cliente();        
        c.setCpf(cpf);
        c.setSenha(senha);

        try {            
        	sc.deletar(c);
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