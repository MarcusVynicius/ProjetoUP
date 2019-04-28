package model;

import java.util.ArrayList;


import DAO.DAOPrestadorServico;
import exce��o.PrestadorException;

public class ServicePrestadorServico implements IService<PrestadorServico> {
	public void restricao(PrestadorServico prestadorServico) throws Exception {
		if (prestadorServico == null) {
			throw new PrestadorException("Informar os dados do prestador de servi�o");
		}
		// VALIDANDO CPF DO PRESTADOR DE SERVICO
		if (prestadorServico.getCpf().length() < 11 || prestadorServico.getCpf().length() > 11) {
			throw new PrestadorException("O CPF  deve possuir 11 digitos");
		}
		if (!prestadorServico.getCpf().matches("[0-9]+")) {
			throw new PrestadorException("O CPF  deve possuir apenas n�meros");
		}
		// VALIDANDO NOME DO PRESTADOR DE SERVICO
		if (prestadorServico.getNome() == null || prestadorServico.getNome().trim().equals("") == true) {
			throw new PrestadorException("Informar o Nome");
		}

		// VALIDANDO ENDERECO DO PRESTADOR DE SERVICO
		if (prestadorServico.getEndereco() == null || prestadorServico.getEndereco().trim().equals("") == true) {
			throw new PrestadorException("Informar o endere�o");
		}
		// VALIDANDO TELEFONE DO PRESTADOR DE SERVICO
		if (prestadorServico.getTelefone() == null || prestadorServico.getTelefone().trim().equals("")) {
			throw new PrestadorException("Informar o telefone");

		}
		// VALIDANDO EMAIL DO PRESTADOR DE SERVICO
		if (prestadorServico.getEmail() == null || prestadorServico.getEmail().trim().equals("")) {
			throw new PrestadorException("Informar o email");
		}
		if (prestadorServico.getSenha() == null || prestadorServico.getSenha().trim().equals("")) {
			throw new PrestadorException("Informar a senha");
		}
	}

	// CHAMAR NA CADAMA DE DADOS O METODO DE INSERIR PRESTADOR DE SERVICO SE ELE PASSAR PELA VALIDA��O
	public void cadastrar(PrestadorServico prestadorServico)throws Exception {
		
			restricao(prestadorServico);
			DAOPrestadorServico dao = new DAOPrestadorServico();
			dao.cadastrar(prestadorServico);		

	}
	// CHAMAR NA CADAMA DE DADOS O METODO DE DELETAR PRESTADOR DE SERVICO SE ELE PASSAR PELA VALIDA��O
	public void deletar(PrestadorServico prestadorServico)throws Exception {
		DAOPrestadorServico dao = new DAOPrestadorServico();
		if(dao.verificarExistencia(prestadorServico.getCpf())==true) {
			dao.deletar(prestadorServico);
		}

	}
	// CHAMAR NA CADAMA DE DADOS O METODO DE ALTERAR PRESTADOR DE SERVICO SE ELE PASSAR PELA VALIDA��O
	public void atualizar(PrestadorServico prestadorServico)throws Exception {
		restricao(prestadorServico);
		DAOPrestadorServico dao = new DAOPrestadorServico();
		dao.alterar(prestadorServico);

	}
	// CHAMAR NA CADAMA DE DADOS O METODO DE LISTAR PRESTADOR DE SERVICO PELO PARAMETRO DO IDSERVICO
	public ArrayList<PrestadorServico> listar(PrestadorServico pres)throws Exception {
		DAOPrestadorServico dao = new DAOPrestadorServico();
		return dao.listar(pres);
	}

}
