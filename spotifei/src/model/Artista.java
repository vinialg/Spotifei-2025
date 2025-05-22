/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author leona
 */
public class Artista extends Pessoa{
   
   private String album;

    public Artista(String nome,String album) {
        super(nome);
        this.album = album;
    }

    

    public String getAlbum() {
        return album;
    }
   
   
}
