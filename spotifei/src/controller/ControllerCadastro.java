
package controller;


import DAO.Conexao;
import DAO.UsuarioDAO;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Usuario;
import view.Cadastrar;

public class ControllerCadastro {
    private Cadastrar view;
    
    public ControllerCadastro(Cadastrar view){
        this.view = view;
    }
    
    public void salvarAluno(){
        String email = view.getTxtEmail().getText();
        String usuario = view.getTxtUsuario().getText();
        String senha = view.getTxtSenha().getText();
        Usuario user = new Usuario(email, usuario,senha);
        
        Conexao conexao = new Conexao();
        try {
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            dao.inserir(user);
            JOptionPane.showMessageDialog(view, "Usuario Cadastrado!","Aviso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, "Usuário não cadastrado!","Erro", JOptionPane.ERROR_MESSAGE);
            
        }
    }
}
