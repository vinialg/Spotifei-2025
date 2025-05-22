/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author leona
 */
public class Usuario extends Pessoa implements Autenticacao{
    private String usuario, senha, id_usuario;
    private boolean autenticado;

    public Usuario( String nome,String usuario, String senha) {
        super(nome);
        this.usuario = usuario;
        this.senha = senha;
        this.autenticado = false;
    }
    
    

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }
    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }
    
    @Override
    public String toString() {
        return usuario;
    } 
       
    public boolean validarCredenciais() {
        // Validação básica - não permite campos vazios ou nulos
        if (usuario == null || usuario.trim().isEmpty()) {
            return false;
        }
        if (senha == null || senha.trim().isEmpty()) {
            return false;
        }
        // Validação adicional pode ser implementada aqui
        return true;
    }

    @Override
    public boolean isAutenticado() {
        return autenticado;
    }

    @Override
    public void setAutenticado(boolean autenticado) {
        this.autenticado = autenticado;
    }
    
}
