package model;

import java.util.ArrayList;

import DAO.DAOContrato;

public class ServiceContrato implements IService<Contrato>{

	
	public void cadastrar(Contrato con) throws Exception {
		DAOContrato dao = new DAOContrato();
		dao.cadastrar(con);
		
	}
	public ArrayList<Contrato> listarCli(Contrato con) throws Exception {
		DAOContrato dao = new DAOContrato();		
		return dao.listar(con);
		
	}
	
	public ArrayList<Contrato> listarPs(Contrato con) throws Exception {
		DAOContrato dao = new DAOContrato();		
		return dao.listarPs(con);		
	}	
	
	public void deletar(Contrato obj) throws Exception {
		//FAZ NADA
		
	}
	
	public void atualizar(Contrato obj) throws Exception {
		// FAZ NADA
		
	}
	public ArrayList<Contrato> listar(Contrato obj) throws Exception {
		return null;
		//FAZ NADA
	}
	
	
  
}
