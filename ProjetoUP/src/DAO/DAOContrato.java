package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Contrato;
import model.PrestadorServico;

public class DAOContrato implements IDAO<Contrato>{

	public void cadastrar(Contrato con) throws SQLException, ClassNotFoundException {		
			// abrindo conexao com o banco usando um singleton
			Connection conexao = GerenciadorConexao.getInstancia().abrirConexao();

			String sql = "INSERT INTO Contrato(cpfCli,idServico,cpfPS)";
			sql += "VALUES (?, ?, ?)";

			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, con.getCli().getCpf());
			ps.setString(2, con.getServ().getId());
			ps.setString(3, con.getPs().getCpf());
			
			ps.executeUpdate();
			GerenciadorConexao.getInstancia().fecharConexao(conexao);

		}
	
	public ArrayList<Contrato> listar(Contrato con) throws SQLException, ClassNotFoundException {
		Connection conexao = GerenciadorConexao.getInstancia().abrirConexao();

		String sql = "Select cli.nome as nomeCli, s.nome as nomeServ, ps.nome as nomePres from contrato as c" ; 
			   sql+= "inner join servico as s on c.idServico = s.id" ; 
		       sql+= "inner join cliente as cli on c.cpfCli = cli.cpfCli" ;
			   sql+= "inner join prestadorServico as ps on c.cpfPS = ps.cpfPS ";
			   sql+= "where cli.cpfCli = ?";
				

		ArrayList<Contrato> listaTudo = new ArrayList<>();

		PreparedStatement ps = conexao.prepareStatement(sql);
		ps.setString(1, con.getCli().getCpf());
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Contrato c = new Contrato();
			c.getCli().setNome(rs.getString("nomeCli"));
			c.getServ().setNome(rs.getString("nomeServ"));
			c.getPs().setNome(rs.getString("nomePres"));
			listaTudo.add(c);
		}
		GerenciadorConexao.getInstancia().fecharConexao(conexao);
		return listaTudo;

	}
	//Overload
	public ArrayList<Contrato> listarPs(Contrato con) throws SQLException, ClassNotFoundException {
		Connection conexao = GerenciadorConexao.getInstancia().abrirConexao();

		String sql = "Select cli.nome as nomeCli, s.nome as nomeServ, ps.nome as nomePres from contrato as c" ; 
			   sql+= "inner join servico as s on c.idServico = s.id" ; 
		       sql+= "inner join cliente as cli on c.cpfCli = cli.cpfCli" ;
			   sql+= "inner join prestadorServico as ps on c.cpfPS = ps.cpfPS ";
			   sql+= "where ps.cpfPS = ?";
				

		ArrayList<Contrato> listaTudo = new ArrayList<>();

		PreparedStatement ps = conexao.prepareStatement(sql);
		ps.setString(1, con.getPs().getCpf());
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Contrato c = new Contrato();
			c.getCli().setNome(rs.getString("nomeCli"));
			c.getServ().setNome(rs.getString("nomeServ"));
			c.getPs().setNome(rs.getString("nomePres"));
			listaTudo.add(c);
		}
		GerenciadorConexao.getInstancia().fecharConexao(conexao);
		return listaTudo;

	}
	
	public Integer qtdContrato(PrestadorServico pres) throws SQLException, ClassNotFoundException {
		Connection conexao = GerenciadorConexao.getInstancia().abrirConexao();

		String sql = "Select cli.nome as nomeCli, s.nome as nomeServ, ps.nome as nomePres from contrato as c" ; 
			   sql+= "inner join servico as s on c.idServico = s.id" ; 
		       sql+= "inner join cliente as cli on c.cpfCli = cli.cpfCli" ;
			   sql+= "inner join prestadorServico as ps on c.cpfPS = ps.cpfPS ";
			   sql+= "where ps.cpfPS = ?";		
	    Integer qtdCont = 0;	
		PreparedStatement ps = conexao.prepareStatement(sql);
		ps.setString(1, pres.getCpf());
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			qtdCont++;
			
		}
		GerenciadorConexao.getInstancia().fecharConexao(conexao);
		return qtdCont;

	}

	public void deletar(Contrato obj) throws SQLException, ClassNotFoundException {
		Connection conexao = GerenciadorConexao.getInstancia().abrirConexao();
		String sql = "DELETE FROM Contrato WHERE cpfCli =?";
		PreparedStatement ps = conexao.prepareStatement(sql);
		ps.setString(1, obj.getCli().getCpf());
		ps.executeUpdate();
		GerenciadorConexao.getInstancia().fecharConexao(conexao);
		
	}

	
	public void alterar(Contrato obj) throws SQLException, ClassNotFoundException {
		// FAZ NADA
		
	}

	
	public boolean verificarExistencia(String id) throws SQLException, ClassNotFoundException {
		// FAZ NADA
		return false;
	}

	
	

}
