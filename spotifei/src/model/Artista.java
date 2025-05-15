/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author leona
 */
public class Artista {
   private String artista;
   
   private String album;

    public Artista(String artista, String album) {
        this.artista = artista;
        this.album = album;
    }

    public String getArtista() {
        return artista;
    }

    public String getAlbum() {
        return album;
    }
   
   
}
