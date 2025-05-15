/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author leona
 */
public class Musica extends Artista{

    private String musica;
    //private String caminho;

    public Musica(String musica, String artista, String album) {
        super(artista, album);
        this.musica = musica;
    }

    public String getMusica() {
        return musica;
    }
    
    public String toString() {
        return "Musica: " + musica + ", Artista: " + getArtista() + ", Álbum: " + getAlbum();
    }

    
    
}
