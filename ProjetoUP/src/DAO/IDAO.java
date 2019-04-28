package DAO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IDAO<T> {
    void cadastrar(T obj) throws SQLException, ClassNotFoundException;
    void deletar (T obj) throws SQLException, ClassNotFoundException;
    void alterar (T obj) throws SQLException, ClassNotFoundException;
    boolean verificarExistencia(String id) throws SQLException, ClassNotFoundException;
    ArrayList<T> listar(T obj) throws SQLException, ClassNotFoundException;
}
