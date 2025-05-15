
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import model.Pessoa;
import model.Usuario;


public class UsuarioDAO {
    private Connection conn;

    public UsuarioDAO(Connection conn) {
        this.conn = conn;
    }
    
    public ResultSet consultar(Pessoa pessoa) throws SQLException{
        String sql = "select * from usuario where usuario = ? or email = ? and senha = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, pessoa.getUsuario());
        statement.setString(2, pessoa.getNome());
        statement.setString(3, pessoa.getSenha());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado;
    }
    
    public void inserir(Pessoa pessoa) throws SQLException{
        String sql = "insert into usuario (email, usuario, senha) values ('"
                      + pessoa.getNome()    + "', '"
                      + pessoa.getUsuario() + "', '"
                      + pessoa.getSenha()   + "')";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.execute();
        conn.close();
    }
    
    public void atualizar(Pessoa pessoa) throws SQLException{
        String sql = "update usuario set senha = ? where usuario = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, pessoa.getSenha());
        statement.setString(2, pessoa.getUsuario());
        statement.execute();
        conn.close();
    }
    
    public void remover(Pessoa pessoa) throws SQLException{
        String sql = "delete from usuario where usuario = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, pessoa.getUsuario());
        statement.execute();
        conn.close();
    }
    
}
