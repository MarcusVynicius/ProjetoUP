package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Cliente;
import model.PrestadorServico;
import model.Servico;

import java.sql.SQLException;

public class DAOServico implements IDAO<Servico> {

	public void cadastrar(Servico servico) throws SQLException, ClassNotFoundException {

		Connection conexao = GerenciadorConexao.getInstancia().abrirConexao();

		String sql = "INSERT INTO Servico(id,nome,descricao)";
		sql += "VALUES (?, ?, ?)";

		PreparedStatement ps = conexao.prepareStatement(sql);
		ps.setString(1, servico.getId());
		ps.setString(2, servico.getNome());
		ps.setString(3, servico.getDescricao());
		ps.executeUpdate();
		GerenciadorConexao.getInstancia().fecharConexao(conexao);

	}

	public void deletar(Servico servico) throws SQLException, ClassNotFoundException {

		Connection conexao = GerenciadorConexao.getInstancia().abrirConexao();
		String sql = "DELETE FROM Servico WHERE id =?";

		PreparedStatement ps = conexao.prepareStatement(sql);
		ps.setString(1, servico.getId());
		ps.executeUpdate();
		GerenciadorConexao.getInstancia().fecharConexao(conexao);

	}

	public void alterar(Servico servico) throws SQLException, ClassNotFoundException {

		Connection conexao = GerenciadorConexao.getInstancia().abrirConexao();
		String sql = "UPDATE Servico SET nome=?,descricao=? WHERE id=?";

		PreparedStatement ps = conexao.prepareStatement(sql);
		ps.setString(1, servico.getNome());
		ps.setString(2, servico.getDescricao());
		ps.setString(3, servico.getId());
		ps.executeUpdate();
		GerenciadorConexao.getInstancia().fecharConexao(conexao);

	}

	public boolean verificarExistencia(String id) throws SQLException, ClassNotFoundException {
		Connection conexao = GerenciadorConexao.getInstancia().abrirConexao();
		String sql = "SELECT id from Servico";

		PreparedStatement ps = conexao.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			if (rs.getString(1).equals(id)) {
				GerenciadorConexao.getInstancia().fecharConexao(conexao);
				return true;
			}
		}
		GerenciadorConexao.getInstancia().fecharConexao(conexao);
		return false;

	}
	public String buscaNomeServ(Servico servico) throws SQLException, ClassNotFoundException {
		Connection conexao = GerenciadorConexao.getInstancia().abrirConexao();
		String sql = "SELECT nome from Servico where idServico = ?";
		PreparedStatement ps = conexao.prepareStatement(sql);
		ps.setString(1, servico.getId());
		ResultSet rs = ps.executeQuery();
		String nome = null;
		while (rs.next()) {
			nome = (rs.getString("nome"));
		}
		return nome;
	}

	public ArrayList<Servico> listarGeral() throws SQLException, ClassNotFoundException {
		Connection conexao = GerenciadorConexao.getInstancia().abrirConexao();

		String sql = "SELECT id,nome,descricao from Servico";

		ArrayList<Servico> listaTudo = new ArrayList<>();

		PreparedStatement ps = conexao.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Servico s = new Servico();

			s.setId(rs.getString("id"));
			s.setNome(rs.getString("nome"));
			s.setDescricao(rs.getString("descricao"));
			listaTudo.add(s);
		}
		GerenciadorConexao.getInstancia().fecharConexao(conexao);
		return listaTudo;

	}
	
	public ArrayList<Servico> listar(Servico serv) throws SQLException, ClassNotFoundException {
		Connection conexao = GerenciadorConexao.getInstancia().abrirConexao();

		String sql = "SELECT id,nome,descricao from Servico";

		ArrayList<Servico> listaTudo = new ArrayList<>();

		PreparedStatement ps = conexao.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Servico s = new Servico();

			s.setId(rs.getString("id"));
			s.setNome(rs.getString("nome"));
			s.setDescricao(rs.getString("descricao"));
			listaTudo.add(s);
		}
		GerenciadorConexao.getInstancia().fecharConexao(conexao);
		return listaTudo;

	}
	public Servico verificaServico(String nome) throws ClassNotFoundException, SQLException {

		Connection conexao = GerenciadorConexao.getInstancia().abrirConexao();
		String sql = "SELECT id,nome,descricao from servico where nome = ? ";

		PreparedStatement ps = conexao.prepareStatement(sql);
		ps.setString(1,nome);
		ResultSet rs = ps.executeQuery();
		Servico s = null;

		while (rs.next())	
		{
		if (nome.equals(rs.getString("nome"))) {
		s = new Servico();
		s.setNome(rs.getString("nome"));
		s.setId(rs.getString("id"));
		s.setDescricao(rs.getString("descricao"));	

		break;
		}	
		}	

		return s;

		}
	
	public void cadastrarContrato(Cliente cpfCli, Servico idServico, PrestadorServico cpfPS) throws SQLException, ClassNotFoundException {

		Connection conexao = GerenciadorConexao.getInstancia().abrirConexao();

		String sql = "INSERT INTO contrato(cpfCli,idServico,cpfPS)";
		sql += "VALUES (?, ?, ?)";

		PreparedStatement ps = conexao.prepareStatement(sql);
		ps.setString(1, cpfCli.getCpf());
		ps.setString(2, idServico.getId());
		ps.setString(3, cpfPS.getCpf());
		ps.executeUpdate();
		GerenciadorConexao.getInstancia().fecharConexao(conexao);

	}	
	
}
