package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GerenciadorConexao {
	private static GerenciadorConexao instancia;

	private GerenciadorConexao() {

	}

	public static GerenciadorConexao getInstancia() {
		if (instancia == null) {
			instancia = new GerenciadorConexao();
		}
		return instancia;
	}

	public Connection abrirConexao() throws SQLException, ClassNotFoundException {
		String url = "jdbc:h2:~/star12"; 
		String user = "a"; 
		String password = "a"; 

		Class.forName("org.h2.Driver");

		Connection conexao = null;
		conexao = DriverManager.getConnection(url, user, password); 
		return conexao;
	}

	public void fecharConexao(Connection c) throws SQLException {
		if (c != null && (!c.isClosed())) {
			c.close();
		}

	}
}