/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author leona
 */
public class Usuario extends Pessoa{
    
    public Usuario(String nome, String usuario, String senha) {
        super(nome, usuario, senha);
    }  

    @Override
    public String toString() {
        return "Usuario{" + '}';
    } 
       
    
}
