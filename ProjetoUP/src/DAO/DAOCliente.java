package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Cliente;


public class DAOCliente implements IDAO<Cliente> {

	public void cadastrar(Cliente cliente) throws SQLException, ClassNotFoundException {
		// abrindo conexao com o banco usando um singleton

		Connection conexao = GerenciadorConexao.getInstancia().abrirConexao();

		String sql = "INSERT INTO Cliente(nome,cpfCli,endereco,telefone,email,senha)";
		sql += "VALUES (?, ?, ?, ?, ?, ?)";

		PreparedStatement ps = conexao.prepareStatement(sql);
		ps.setString(1, cliente.getNome());
		ps.setString(2, cliente.getCpf());
		ps.setString(3, cliente.getEndereco());
		ps.setString(4, cliente.getTelefone());
		ps.setString(5, cliente.getEmail());
		ps.setString(6, cliente.getSenha());

		ps.executeUpdate();
		GerenciadorConexao.getInstancia().fecharConexao(conexao);

	}

	public void deletar(Cliente cliente) throws SQLException, ClassNotFoundException {
		Connection conexao = GerenciadorConexao.getInstancia().abrirConexao();
		String sql = "DELETE FROM Cliente WHERE cpfCli =?";

		PreparedStatement ps = conexao.prepareStatement(sql);
		ps.setString(1, cliente.getCpf());
		ps.executeUpdate();
		GerenciadorConexao.getInstancia().fecharConexao(conexao);

	}

	public void alterar(Cliente cliente) throws SQLException, ClassNotFoundException {
		Connection conexao = GerenciadorConexao.getInstancia().abrirConexao();
		String sql = "UPDATE Cliente SET nome=?,endereco=?,telefone=?,email=?,senha=? WHERE cpfCli=?";

		PreparedStatement ps = conexao.prepareStatement(sql);
		ps.setString(1, cliente.getNome());
		ps.setString(2, cliente.getEndereco());
		ps.setString(3, cliente.getTelefone());
		ps.setString(4, cliente.getEmail());
		ps.setString(5, cliente.getSenha());
		ps.setString(6, cliente.getCpf());
		ps.executeUpdate();
		GerenciadorConexao.getInstancia().fecharConexao(conexao);

	}

	public boolean verificarExistencia(String cpf) throws SQLException, ClassNotFoundException {
		Connection conexao = GerenciadorConexao.getInstancia().abrirConexao();
		String sql = "SELECT cpfCli from Cliente";

		PreparedStatement ps = conexao.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			if (rs.getString(1).equals(cpf)) {
				GerenciadorConexao.getInstancia().fecharConexao(conexao);
				return true;
			}
		}
		GerenciadorConexao.getInstancia().fecharConexao(conexao);
		return false;

	}

	public ArrayList<Cliente> listar(Cliente cli) throws SQLException, ClassNotFoundException {
		Connection conexao = GerenciadorConexao.getInstancia().abrirConexao();

		String sql = "SELECT nome,cpfCli,endereco,telefone,email from Cliente";

		ArrayList<Cliente> listaTudo = new ArrayList<Cliente>();

		PreparedStatement ps = conexao.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Cliente c = new Cliente();
			c.setNome(rs.getString("nome"));
			c.setCpf((rs.getString("cpfCli")));
			c.setEndereco((rs.getString("endereco")));
			c.setTelefone((rs.getString("telefone")));
			c.setEmail((rs.getString("email")));
			c.setSenha((rs.getString("senha")));

			listaTudo.add(c);
		}
		GerenciadorConexao.getInstancia().fecharConexao(conexao);
		return listaTudo;

	}

	public Cliente verificaLogin(String cpf, String senha) throws ClassNotFoundException, SQLException {
		
		Connection conexao = GerenciadorConexao.getInstancia().abrirConexao();
		String sql = "SELECT nome,cpfCli,endereco,telefone,email,senha from cliente";

		PreparedStatement ps = conexao.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		Cliente c = null;

		while (rs.next())				
		  {
			if ((cpf.equals(rs.getString("cpfCli"))) && (senha.equals(rs.getString("senha")))) {
				c = new Cliente();
				c.setNome(rs.getString("nome"));
				c.setCpf((rs.getString("cpfCli")));
				c.setEndereco((rs.getString("endereco")));
				c.setTelefone((rs.getString("telefone")));
				c.setEmail((rs.getString("email")));
				c.setSenha((rs.getString("senha")));
				
				break;
			}			
		}		
			
		return c;

	}	
}