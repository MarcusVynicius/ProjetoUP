package model;

import java.sql.SQLException;
import java.util.ArrayList;

import DAO.DAOCliente;
import exceção.ClienteException;

public class ServiceCliente implements IService<Cliente> {

	public void restricao(Cliente cliente) throws Exception {
		if (cliente == null) {
			throw new ClienteException("Informar os dados do Cliente");
		}
		// VALIDANDO CPF DO CLIENTE
		if (cliente.getCpf().length() < 11 || cliente.getCpf().length() > 11) {
			throw new ClienteException("O CPF  deve possuir 11 digitos");
		}
		if (!cliente.getCpf().matches("[0-9]+")) {
			throw new ClienteException("Cpf só deve conter números!");
		}
		// VALIDANDO NOME DO CLIENTE
		if (cliente.getNome() == null || cliente.getNome().trim().equals("") == true) {
			throw new ClienteException("Informar o nome");
		}

		// VALIDANDO ENDERECO DO CLIENTE
		if (cliente.getEndereco() == null || cliente.getEndereco().trim().equals("") == true) {
			throw new ClienteException("Informar o endereço");
		}
		// VALIDANDO TELEFONE DO CLIENTE
		if (cliente.getTelefone() == null || cliente.getTelefone().trim().equals("")) {
			throw new ClienteException("Informar o telefone");
		}
		// VALIDANDO EMAIL DO CLIENTE
		if (cliente.getEmail() == null || cliente.getEmail().trim().equals("")) {
			throw new ClienteException("Informar o email");
		}
		if (cliente.getSenha() == null || cliente.getSenha().trim().equals("")) {
			throw new ClienteException("Informar a senha");
		}
	}
	// CHAMAR NA CADAMA DE DADOS O METODO DE INSERIR CLIENTES SE ELE PASSAR PELA VALIDAÇÃO
	public void cadastrar(Cliente cliente) throws Exception {

		restricao(cliente);
		DAOCliente dados = new DAOCliente();
		if(dados.verificarExistencia(cliente.getCpf())== false) {
		dados.cadastrar(cliente);
		}else {
			throw new Exception();
		}

	}
	// CHAMAR NA CADAMA DE DADOS O METODO DE DELETAR CLIENTES SE ELE PASSAR PELA VALIDAÇÃO
	public void deletar(Cliente cliente)throws Exception {
		
			DAOCliente dao = new DAOCliente();
			if (dao.verificarExistencia(cliente.getCpf()) == true) {
				dao.deletar(cliente);
			}else {
				throw new Exception();
			}	

	}
	// CHAMAR NA CADAMA DE DADOS O METODO DE ALTERAR CLIENTES SE ELE PASSAR PELA VALIDAÇÃO
	public void atualizar(Cliente cliente) throws Exception {

		restricao(cliente);
		DAOCliente dao = new DAOCliente();
		if (dao.verificarExistencia(cliente.getCpf()) == true) {
			dao.alterar(cliente);
		}else {
			throw new Exception();
		}	
		
	}
	// CHAMAR NA CADAMA DE DADOS O METODO DE LISTAR CLIENTES
	public ArrayList<Cliente> listar(Cliente cli) throws ClassNotFoundException, SQLException {

		DAOCliente dao = new DAOCliente();
		return dao.listar(cli);

	}

}
