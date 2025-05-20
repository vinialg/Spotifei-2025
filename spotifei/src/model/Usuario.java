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
    String usuario, senha, id_usuario;

    public Usuario( String nome,String usuario, String senha) {
        super(nome);
        this.usuario = usuario;
        this.senha = senha;
    }
    

    

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }
    
    
    @Override
    public String toString() {
        return usuario;
    } 
       
    
}
