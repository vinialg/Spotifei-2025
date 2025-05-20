/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Playlist;
import model.Usuario;
import controller.ControllerLogin;
import javax.swing.JTextField;
/**
 *
 * @author leona
 */
public class PlaylistDAO {
    private Connection conn;
    ControllerLogin controller =  new ControllerLogin();
    public PlaylistDAO(Connection conn) {
        this.conn = conn;
    }
    public void inserirPlaylist(Playlist playlist) throws SQLException{
        String sql = "insert into usuario (nome_playlist, id_usuario) values ('"
                      + playlist.getNome_playlist() + playlist.getId_usuario() + "')";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.execute();
        conn.close();
    }
    
//    public void inserirNomePlaylist(JTextField jtextfield, int id_usuario) throws SQLException{
//        String sql = "insert into playlist (nome_playlist, id_usuario) values ('"
//                      + jtextfield + id_usuario + "')";
//        PreparedStatement statement = conn.prepareStatement(sql);
//        statement.execute();
//        conn.close();
//    }
    
    public void inserirNomePlaylist(String jtextfield, int id_usuario) throws SQLException {
        String sql = "INSERT INTO playlist (nome_playlist, id_usuario) VALUES (?, ?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, jtextfield.trim());
        statement.setInt(2, id_usuario);
        statement.executeUpdate(); // Use executeUpdate para INSERT
        statement.close();         // Feche o statement
        conn.close();              // Feche a conexão, se for apropriado aqui
    }
    
    public void inserirMusicaPlaylist(Playlist playlist) throws SQLException{
        String sql = "insert into musica_playlist (email, usuario, senha) values ('"
                      + playlist.getNome_playlist()    + "')";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.execute();
        conn.close();
    }
    
    public ResultSet consultarPlaylist(int id_usuario) throws SQLException {
        String sql = "select nome_playlist from playlist where id_usuario = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, id_usuario);
        // Aqui você executa a consulta corretamente
        ResultSet resultado = statement.executeQuery();
        
        return resultado;
    }
}
