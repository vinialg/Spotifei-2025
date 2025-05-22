
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
    
    public ResultSet consultar(Usuario usuario) throws SQLException{
        String sql = "select * from usuario where (usuario = ? or email = ?) and senha = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, usuario.getUsuario());
        statement.setString(2, usuario.getNome());
        statement.setString(3, usuario.getSenha());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado;
    }
    
    public ResultSet consultar2(Usuario usuario) throws SQLException{
        String sql = "select id from usuario where usuario = ? ";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, usuario.getUsuario());
        // Aqui você executa a consulta corretamente
        ResultSet resultado = statement.executeQuery();
        
        return resultado;
    }
    
    public void inserir(Usuario usuario) throws SQLException{
        String sql = "insert into usuario (email, usuario, senha) values ('"
                      + usuario.getNome()    + "', '"
                      + usuario.getUsuario() + "', '"
                      + usuario.getSenha()   + "')";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.execute();
        conn.close();
    }
    
    public void atualizar(Usuario usuario) throws SQLException{
        String sql = "update usuario set senha = ? where usuario = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, usuario.getSenha());
        statement.setString(2, usuario.getUsuario());
        statement.execute();
        conn.close();
    }
    
    public void remover(Usuario usuario) throws SQLException{
        String sql = "delete from usuario where usuario = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, usuario.getUsuario());
        statement.execute();
        conn.close();
    }
    
     public Usuario autenticar(String login, String senha) throws SQLException {
        String sql = "SELECT id, email, usuario, senha FROM usuario WHERE (usuario = ? OR email = ?) AND senha = ?";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, login);
            statement.setString(2, login);
            statement.setString(3, senha);
            
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    Usuario usuario = new Usuario(
                        rs.getString("email"),
                        rs.getString("usuario"),
                        rs.getString("senha")
                    );
                    usuario.setId_usuario(rs.getString("id"));
                    usuario.setAutenticado(true);
                    return usuario;
                }
            }
        }
        return null; // Usuário não encontrado ou senha incorreta
    }
    
}
