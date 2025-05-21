/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Musica;
import model.Pessoa;
import model.Playlist;
import view.Feed;

/**
 *
 * @author leona
 */
public class MusicaDAO {
    private Connection conn;
    public MusicaDAO(Connection conn) {
        this.conn = conn;
    }
    
    public ResultSet consultarMusica() throws SQLException {
        String sql = "select id, musica, artista, album, genero from musica";
        PreparedStatement statement = conn.prepareStatement(sql);

        // Aqui você executa a consulta corretamente
        ResultSet resultado = statement.executeQuery();
        
        return resultado;
    }
    
    public ResultSet consultarMusica2(String feed) throws SQLException {
        String sql = "select * from musica where musica = ? or artista = ? or genero = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, feed);
        statement.setString(2, feed);
        statement.setString(3, feed);
        // Aqui você executa a consulta corretamente
        ResultSet resultado = statement.executeQuery();
        
        return resultado;
    }
    public ResultSet consultarMusica3(String feed) throws SQLException {
        String sql = "select id from musica where musica = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, feed);
        // Aqui você executa a consulta corretamente
        ResultSet resultado = statement.executeQuery();
        
        return resultado;
    }
    
    public ResultSet consultarMusicaPlaylist(String nome_playlist, int id_musica) throws SQLException {
        String sql = "SELECT * FROM musica m JOIN musica_playlist mp ON m.id = mp.id_musica JOIN playlist p ON mp.id_playlist = p.id_playlist WHERE p.nome_playlist = ? AND p.id_usuario = ? ";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, nome_playlist);
        statement.setInt(2, id_musica);
        // Aqui você executa a consulta corretamente
        ResultSet resultado = statement.executeQuery();
        
        return resultado;
    }
    public void inserirPlaylist(Playlist playlist) throws SQLException{
        String sql = "insert into playlist (nome, id_musica, id_usuario) values ('"
                      + playlist.getNome_playlist()   + "', '"
                      + playlist.getId_musica() + "', '"
                      + playlist.getId_usuario()   +  "')";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.execute();
        conn.close();
    }
        
    public ResultSet consultarMusicasCurtidas(int id_usuario) throws SQLException {
        String sql = "SELECT m.* FROM musica m " +
                     "INNER JOIN musicas_curtidas mc ON m.id = mc.id_musica " +
                     "WHERE mc.id_usuario = ? " +
                     "ORDER BY mc.data_curtida DESC";
        
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id_usuario);
        
        return stmt.executeQuery();
    }
    
    /**
     * Consulta músicas descurtidas pelo usuário
     * @param id_usuario ID do usuário
     * @return ResultSet com as músicas descurtidas
     * @throws SQLException 
     */
    public ResultSet consultarMusicasDescurtidas(int id_usuario) throws SQLException {
        String sql = "SELECT m.* FROM musica m " +
                     "INNER JOIN musicas_descurtidas md ON m.id = md.id_musica " +
                     "WHERE md.id_usuario = ? " +
                     "ORDER BY md.data_descurtida DESC";
        
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id_usuario);
        
        return stmt.executeQuery();
    }
    
    /**
     * Verifica se uma música foi curtida pelo usuário
     * @param id_usuario ID do usuário
     * @param id_musica ID da música
     * @return true se a música foi curtida, false caso contrário
     * @throws SQLException 
     */
    public boolean verificarMusicaCurtida(int id_usuario, int id_musica) throws SQLException {
        String sql = "SELECT 1 FROM musicas_curtidas WHERE id_usuario = ? AND id_musica = ?";
        
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id_usuario);
        stmt.setInt(2, id_musica);
        
        ResultSet rs = stmt.executeQuery();
        boolean resultado = rs.next();
        
        rs.close();
        stmt.close();
        
        return resultado;
    }
    
    /**
     * Verifica se uma música foi descurtida pelo usuário
     * @param id_usuario ID do usuário
     * @param id_musica ID da música
     * @return true se a música foi descurtida, false caso contrário
     * @throws SQLException 
     */
    public boolean verificarMusicaDescurtida(int id_usuario, int id_musica) throws SQLException {
        String sql = "SELECT 1 FROM musicas_descurtidas WHERE id_usuario = ? AND id_musica = ?";
        
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id_usuario);
        stmt.setInt(2, id_musica);
        
        ResultSet rs = stmt.executeQuery();
        boolean resultado = rs.next();
        
        rs.close();
        stmt.close();
        
        return resultado;
    }
    
}
