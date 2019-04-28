package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import model.PrestadorServico;

public class DAOPrestadorServico implements IDAO<PrestadorServico> {

	public void cadastrar(PrestadorServico prestadorServico) throws SQLException, ClassNotFoundException {
		// abrindo conexao com o banco usando um singleton

		Connection conexao = GerenciadorConexao.getInstancia().abrirConexao();

		String sql = "INSERT INTO prestadorservico(nome,cpfPS,endereco,telefone,email,descricao,idServico,senha)";
		sql += "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement ps = conexao.prepareStatement(sql);
		ps.setString(1, prestadorServico.getNome());
		ps.setString(2, prestadorServico.getCpf());
		ps.setString(3, prestadorServico.getEndereco());
		ps.setString(4, prestadorServico.getTelefone());
		ps.setString(5, prestadorServico.getEmail());
		ps.setString(6, prestadorServico.getDescricao());
		ps.setString(7, prestadorServico.getServico().getId());
		ps.setString(8, prestadorServico.getSenha());

		ps.executeUpdate();
		GerenciadorConexao.getInstancia().fecharConexao(conexao);

	}

	public void deletar(PrestadorServico prestadorServico) throws SQLException, ClassNotFoundException {
		Connection conexao = GerenciadorConexao.getInstancia().abrirConexao();
		String sql = "DELETE FROM PrestadorServ WHERE cpfPS =?";

		PreparedStatement ps = conexao.prepareStatement(sql);
		ps.setString(1, prestadorServico.getCpf());
		ps.executeUpdate();
		GerenciadorConexao.getInstancia().fecharConexao(conexao);

	}

	public void alterar(PrestadorServico prestadorServico) throws SQLException, ClassNotFoundException {
		Connection conexao = GerenciadorConexao.getInstancia().abrirConexao();
		String sql = "UPDATE PrestadorServ SET nome=?,endereco=?,telefone=?,email=?,descricao=? WHERE cpfPS=?";

		PreparedStatement ps = conexao.prepareStatement(sql);
		ps.setString(1, prestadorServico.getNome());
		ps.setString(2, prestadorServico.getEndereco());
		ps.setString(3, prestadorServico.getTelefone());
		ps.setString(4, prestadorServico.getEmail());
		ps.setString(5, prestadorServico.getDescricao());
		ps.setString(6, prestadorServico.getCpf());

		ps.executeUpdate();
		GerenciadorConexao.getInstancia().fecharConexao(conexao);

	}

	public boolean verificarExistencia(String cpf) throws SQLException, ClassNotFoundException {
		Connection conexao = GerenciadorConexao.getInstancia().abrirConexao();
		String sql = "SELECT cpfPS from PrestadorServ";

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

	public ArrayList<PrestadorServico> listar(PrestadorServico pres) throws SQLException, ClassNotFoundException {
		Connection conexao = GerenciadorConexao.getInstancia().abrirConexao();

		String sql = "SELECT nome,cpfPS,endereco,telefone,email,descricao,idServico from PrestadorServ where idServico=? ";

		ArrayList<PrestadorServico> listaTudo = new ArrayList<PrestadorServico>();

		PreparedStatement ps = conexao.prepareStatement(sql);
		ps.setString(1, pres.getServico().getId());
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			PrestadorServico p = new PrestadorServico();
			p.setNome(rs.getString("nome"));
			p.setCpf((rs.getString("cpfPS")));
			p.setEndereco((rs.getString("endereco")));
			p.setTelefone((rs.getString("telefone")));
			p.setEmail((rs.getString("email")));
			p.setDescricao(rs.getString("descricao"));
			p.getServico().setId(rs.getString("idServico"));

			listaTudo.add(p);
		}
		GerenciadorConexao.getInstancia().fecharConexao(conexao);
		return listaTudo;

	}

	public PrestadorServico verificaLogin(String cpf, String senha) throws ClassNotFoundException, SQLException {

		Connection conexao = GerenciadorConexao.getInstancia().abrirConexao();
		String sql = "SELECT nome,cpfPS,endereco,telefone,email,senha,descricao,idServico from prestadorServico";

		PreparedStatement ps = conexao.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		PrestadorServico pres = null;

		while (rs.next()) {
			if ((cpf.equals(rs.getString("cpfPS"))) && (senha.equals(rs.getString("senha")))) {
				pres = new PrestadorServico();
				pres.setNome(rs.getString("nome"));
				pres.setCpf((rs.getString("cpfPS")));
				pres.setEndereco((rs.getString("endereco")));
				pres.setTelefone((rs.getString("telefone")));
				pres.setEmail((rs.getString("email")));
				pres.setSenha((rs.getString("senha")));
				pres.setDescricao(rs.getString("descricao"));
				pres.getServico().setId(rs.getString("idServico"));
				break;

			}

		}
		return pres;
	}
}