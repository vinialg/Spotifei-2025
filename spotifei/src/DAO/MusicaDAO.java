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
        String sql = "select id, musica, artista, album from musica";
        PreparedStatement statement = conn.prepareStatement(sql);

        // Aqui você executa a consulta corretamente
        ResultSet resultado = statement.executeQuery();
        
        return resultado;
    }
}
