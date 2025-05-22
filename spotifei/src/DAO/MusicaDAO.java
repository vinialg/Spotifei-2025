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
        String sql = "select * from musica";
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
    
//    public void registrarBuscaMusica(int id_usuario, int id_musica) throws SQLException {
//        String sql = "INSERT INTO historico_buscas (id_usuario, id_musica) VALUES (?, ?)";
//
//        PreparedStatement stmt = conn.prepareStatement(sql);
//        stmt.setInt(1, id_usuario);
//        stmt.setInt(2, id_musica);
//
//        stmt.executeUpdate();
//        stmt.close();
//    }
    public void registrarBuscaMusica(int id_usuario, int id_musica) throws SQLException {
        // Skip registration if user ID is invalid
        if (id_usuario <= 0) {
            System.out.println("Não foi possível registrar busca: usuário não autenticado.");
            return; // Skip recording search for invalid/guest users
        }

        String sql = "INSERT INTO historico_buscas (id_usuario, id_musica) VALUES (?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id_usuario);
        stmt.setInt(2, id_musica);
        stmt.executeUpdate();
        stmt.close();
    }
    
//    public void registrarBuscaMusica(Integer id_usuario, int id_musica) throws SQLException {
//        String sql = "INSERT INTO historico_buscas (id_usuario, id_musica) VALUES (?, ?)";
//        PreparedStatement stmt = conn.prepareStatement(sql);
//
//        if (id_usuario != null && id_usuario > 0) {
//            stmt.setInt(1, id_usuario);
//        } else {
//            stmt.setNull(1, java.sql.Types.INTEGER);
//        }
//
//        stmt.setInt(2, id_musica);
//        stmt.executeUpdate();
//        stmt.close();
//    }

    /**
     * Consulta as últimas músicas buscadas pelo usuário
     * @param id_usuario ID do usuário
     * @param limite Número máximo de músicas a retornar (ex: 10)
     * @return ResultSet com as músicas buscadas recentemente
     * @throws SQLException 
     */
    public ResultSet consultarUltimasMusicasBuscadas(int id_usuario, int limite) throws SQLException {
        // Use a subquery to first select the most recent searches for each unique music ID
        String sql = "SELECT m.* FROM musica m " +
                     "INNER JOIN (SELECT DISTINCT ON (id_musica) id_musica, data_busca " +
                     "            FROM historico_buscas " + 
                     "            WHERE id_usuario = ? " +
                     "            ORDER BY id_musica, data_busca DESC) h " +
                     "ON m.id = h.id_musica " +
                     "ORDER BY h.data_busca DESC " +
                     "LIMIT ?";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id_usuario);
        stmt.setInt(2, limite);
        return stmt.executeQuery();
    }
    
        public boolean deletarPlaylist(int id_playlist, int id_usuario) throws SQLException {
            // Primeiro remove todas as músicas da playlist
            String sqlRemoveMusicas = "DELETE FROM musica_playlist WHERE id_playlist = ?";
            PreparedStatement stmtRemoveMusicas = conn.prepareStatement(sqlRemoveMusicas);
            stmtRemoveMusicas.setInt(1, id_playlist);
            stmtRemoveMusicas.executeUpdate();
            stmtRemoveMusicas.close();

            // Depois remove a playlist
            String sqlRemovePlaylist = "DELETE FROM playlist WHERE id_playlist = ? AND id_usuario = ?";
            PreparedStatement stmtRemovePlaylist = conn.prepareStatement(sqlRemovePlaylist);
            stmtRemovePlaylist.setInt(1, id_playlist);
            stmtRemovePlaylist.setInt(2, id_usuario);

            int linhasAfetadas = stmtRemovePlaylist.executeUpdate();
            stmtRemovePlaylist.close();

            return linhasAfetadas > 0;
    }

    /**
     * Remove uma música específica de uma playlist
     * @param id_playlist ID da playlist
     * @param id_musica ID da música a ser removida
     * @return true se a música foi removida com sucesso, false caso contrário
     * @throws SQLException 
     */
    public boolean removerMusicaDaPlaylist(int id_playlist, int id_musica) throws SQLException {
        String sql = "DELETE FROM musica_playlist WHERE id_playlist = ? AND id_musica = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id_playlist);
        stmt.setInt(2, id_musica);

        int linhasAfetadas = stmt.executeUpdate();
        stmt.close();

        return linhasAfetadas > 0;
    }

    /**
     * Verifica se uma música está em uma playlist específica
     * @param id_playlist ID da playlist
     * @param id_musica ID da música
     * @return true se a música está na playlist, false caso contrário
     * @throws SQLException 
     */
    public boolean verificarMusicaNaPlaylist(int id_playlist, int id_musica) throws SQLException {
        String sql = "SELECT 1 FROM musica_playlist WHERE id_playlist = ? AND id_musica = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id_playlist);
        stmt.setInt(2, id_musica);

        ResultSet rs = stmt.executeQuery();
        boolean existe = rs.next();

        rs.close();
        stmt.close();

        return existe;
    }

    /**
     * Conta quantas músicas uma playlist possui
     * @param id_playlist ID da playlist
     * @return número de músicas na playlist
     * @throws SQLException 
     */
    public int contarMusicasNaPlaylist(int id_playlist) throws SQLException {
        String sql = "SELECT COUNT(*) as total FROM musica_playlist WHERE id_playlist = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id_playlist);

        ResultSet rs = stmt.executeQuery();
        int total = 0;
        if (rs.next()) {
            total = rs.getInt("total");
        }

        rs.close();
        stmt.close();

        return total;
    }
    
    
//    public ResultSet consultarUltimasMusicasBuscadas(int id_usuario, int limite) throws SQLException {
//        String sql = "SELECT DISTINCT m.* FROM musica m " +
//                     "INNER JOIN historico_buscas h ON m.id = h.id_musica " +
//                     "WHERE h.id_usuario = ? " +
//                     "ORDER BY h.data_busca DESC " +
//                     "LIMIT ?";
//
//        PreparedStatement stmt = conn.prepareStatement(sql);
//        stmt.setInt(1, id_usuario);
//        stmt.setInt(2, limite);
//
//        return stmt.executeQuery();
//    }
    
}
