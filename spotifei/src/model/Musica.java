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
    private int id_musica;
    private Pessoa nome;
    private String musica;
    private String genero;
    //private String caminho;

//    public Musica(String musica, String nome, String album) {
//        super(album);
//        this.nome = new Pessoa(nome);
//        this.musica = musica;

    public Musica(int id_musica, String musica, String nome, String album, String genero) {
        super(nome, album);
        this.nome = new Pessoa(nome);
        this.musica = musica;
        this.genero = genero;
    }

    public int getId_musica() {
        return id_musica;
    }
    
//    }
    public String getMusica() {
        return musica;
    }

    public String getGenero() {
        return genero;
    }
    
    public String toString() {
        return nome.getNome();
    }

    
    
}
