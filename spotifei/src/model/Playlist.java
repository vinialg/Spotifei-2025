/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author leona
 */

public class Playlist {
    private String id_playlist;
    private String nome_playlist;
    private String id_musica;
    private int id_usuario;
    private Musica musica;

//    Musica musica;
    public Playlist(String nome_playlist){
        this.nome_playlist = nome_playlist;
    }
    public Playlist(Musica musica, String nome_playlist, int id_usuario) {
        this.musica = musica;
//        this.id_playlist = id_playlist;
        this.nome_playlist = nome_playlist;
//        this.id_musica = id_musica;
        this.id_usuario = id_usuario;
    }

    public String getId_playlist() {
        return id_playlist;
    }

    public String getNome_playlist() {
        return nome_playlist;
    }

    public String getId_musica() {
        return id_musica;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public Musica getMusica() {
        return musica;
    }
    
        
    

    
}
