
package controller;

import DAO.UsuarioDAO;
import DAO.Conexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Pessoa;
import model.Usuario;
//import view.AltExcFrame;
import view.Login;


public class ControllerLogin {
    private Login view;

    public ControllerLogin(Login view) {
        this.view = view;
    }
    
    public void loginUsuario(){
        Pessoa pessoa = new Pessoa(view.getTxt_usuario_login().getText(), 
                                view.getTxt_usuario_login().getText(),
                                view.getTxt_senha_login().getText());
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            ResultSet res = dao.consultar(pessoa);
            if(res.next()){
                JOptionPane.showMessageDialog(view, 
                                              "Login efetuado!", 
                                              "Aviso",
                                              JOptionPane.INFORMATION_MESSAGE);
                Pessoa pessoa2 = new Pessoa(res.getString("email"), 
                                         res.getString("usuario"), 
                                         res.getString("senha"));
                JOptionPane.showMessageDialog(view, "Usuario Logado!","Aviso", JOptionPane.INFORMATION_MESSAGE);
                /*Feed feed = new Feed(pessoa2);
                feed.setVisible(true);*/
                /*AltExcFrame aec = new AltExcFrame(aluno2);
                aec.setVisible(true);*/
            } else{
                JOptionPane.showMessageDialog(view, 
                                              "Login NÃO efetuado!", 
                                              "Aviso",
                                              JOptionPane.ERROR_MESSAGE);
            }
        } catch(SQLException e){    
            JOptionPane.showMessageDialog(view, 
                                              "Erro de conexão!", 
                                              "Aviso",
                                              JOptionPane.ERROR_MESSAGE);
        }
    }
}
