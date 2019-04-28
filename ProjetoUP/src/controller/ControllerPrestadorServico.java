package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.PrestadorServico;
import model.ServicePrestadorServico;


public class ControllerPrestadorServico extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");
		String senha = request.getParameter("senha");
		String descricao = request.getParameter("descricao");
		String servico = request.getParameter("servico");
		String endereco = request.getParameter("endereco");
		
		
		PrestadorServico ps = new PrestadorServico();	
		ps.setNome(nome);
		ps.setCpf(cpf);
		ps.setEmail(email);
		ps.setTelefone(telefone);
		ps.setEndereco(endereco);
		ps.setSenha(senha);
		ps.setDescricao(descricao);
		ps.getServico().setId(servico);
		
		request.setAttribute("erroPS", null);

		ServicePrestadorServico sps = new ServicePrestadorServico();
		
		try {
		sps.cadastrar(ps);	
		RequestDispatcher rDispatcher = request.getRequestDispatcher("telaInicial.jsp");
		rDispatcher.forward(request, response);

		} catch (Exception e) {
			String erro = "Erro ao cadastrar! "+e.getMessage();
			request.setAttribute("erroPS", erro);
			RequestDispatcher rDispatcher = request.getRequestDispatcher("cadastroPS.jsp");
			rDispatcher.forward(request, response);		
			
		}

		}
	}


