package controller;

import DAO.UsuarioDAO;
import DAO.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Usuario;
import view.Feed;
import view.Inicio;
import view.Login;

public class ControllerLogin {
    private Login view;
    private Usuario usuarioLogado;
    
    public ControllerLogin() {
    }
    
    public ControllerLogin(Login view) {
        this.view = view;
    }
    
    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }
    
    /**
     * Método corrigido para login do usuário
     */
    public void loginUsuario() {
        // Validação inicial dos campos
        String loginInput = view.getTxt_usuario_login().getText();
        String senhaInput = view.getTxt_senha_login().getText();
        
        if (loginInput == null || loginInput.trim().isEmpty()) {
            JOptionPane.showMessageDialog(view, 
                                          "Por favor, informe o usuário ou email!", 
                                          "Campo obrigatório",
                                          JOptionPane.WARNING_MESSAGE);

        }
        
        if (senhaInput == null || senhaInput.trim().isEmpty()) {
            JOptionPane.showMessageDialog(view, 
                                          "Por favor, informe a senha!", 
                                          "Campo obrigatório",
                                          JOptionPane.WARNING_MESSAGE);

        }
        
        // Criar usuário temporário para validação
        Usuario usuarioTemp = new Usuario("", loginInput.trim(), senhaInput);
        
        // Validar credenciais usando a interface
        if (!usuarioTemp.validarCredenciais()) {
            JOptionPane.showMessageDialog(view, 
                                          "Credenciais inválidas!", 
                                          "Erro de validação",
                                          JOptionPane.ERROR_MESSAGE);           

        }
        
        // Tentar autenticação no banco
        Conexao conexao = new Conexao();
        Connection conn = null;
        
        try {
            conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            
            // Usar o método específico de autenticação
            this.usuarioLogado = dao.autenticar(loginInput.trim(), senhaInput);
            
            if (this.usuarioLogado != null && this.usuarioLogado.isAutenticado()) {
                // Login bem-sucedido
                JOptionPane.showMessageDialog(view, 
                                              "Login efetuado com sucesso!", 
                                              "Sucesso",
                                              JOptionPane.INFORMATION_MESSAGE);
                
                // Abrir tela principal
                Feed feed = new Feed();
                feed.setUsuario(this.usuarioLogado);
                feed.setVisible(true);
                
                // Fechar tela de login
                view.dispose();
                
            } else {
                // Falha na autenticação
                JOptionPane.showMessageDialog(view, 
                                              "Usuário ou senha incorretos!", 
                                              "Erro de autenticação",
                                              JOptionPane.ERROR_MESSAGE);
                
                
                // Limpar campos
                view.getTxt_usuario_login().setText("");
                view.getTxt_senha_login().setText("");
                view.getTxt_usuario_login().requestFocus();
                Inicio inicio = new Inicio();
                inicio.setVisible(true);
                view.dispose();
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, 
                                          "Erro de conexão com o banco de dados!\n" + e.getMessage(), 
                                          "Erro",
                                          JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            
        } finally {
            // Fechar conexão se não for nula
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    /**
     * Método para logout do usuário
     */
    public void logoutUsuario() {
        if (this.usuarioLogado != null) {
            this.usuarioLogado.setAutenticado(false);
            this.usuarioLogado = null;
        }
    }
    
    /**
     * Verifica se há um usuário logado
     */
    public boolean isUsuarioLogado() {
        return this.usuarioLogado != null && this.usuarioLogado.isAutenticado();
    }
}