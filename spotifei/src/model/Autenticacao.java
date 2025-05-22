/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model;

/**
 *
 * @author leona
 */
public interface Autenticacao {
       /**
     * Valida as credenciais do usuário
     * @return true se as credenciais são válidas, false caso contrário
     */
    boolean validarCredenciais();
    
    /**
     * Verifica se o usuário está autenticado
     * @return true se autenticado, false caso contrário
     */
    boolean isAutenticado();
    
    /**
     * Define o status de autenticação do usuário
     * @param autenticado status de autenticação
     */
    void setAutenticado(boolean autenticado);
}
