package model;

import java.util.ArrayList;

public interface IService<T> {
	void cadastrar(T obj) throws Exception ;
	void deletar(T obj)throws Exception;
	void atualizar(T obj)throws Exception;
	ArrayList<T> listar(T obj)throws Exception;
		
	

}
