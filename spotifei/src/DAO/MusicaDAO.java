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
    
    public void inserirPlaylist(Playlist playlist) throws SQLException{
        String sql = "insert into playlist (nome, id_musica, id_usuario) values ('"
                      + playlist.getNome_playlist()   + "', '"
                      + playlist.getId_musica() + "', '"
                      + playlist.getId_usuario()   +  "')";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.execute();
        conn.close();
    }
}
