/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author leona
 */
public class Playlist extends Musica{
    private String playlist;
    
    public Playlist(String playlist, String musica, String artista, String album) {
        super(musica, artista, album);
        this.playlist = playlist;
    }
        
    
}
