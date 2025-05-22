/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package spotifei;

import controller.ControllerFeed;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import javax.swing.JFrame;
import view.Cadastrar;
import view.Feed;
import view.Inicio;
import view.Teste;

/**
 *
 * @author leona
 */
public class Spotifei {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ///Inicio telaInicio = new Inicio();
        //telaInicio.setVisible(true);  
        //Cadastrar telaCadastro = new Cadastrar();
        //telaCadastro.setVisible(true);  
        Inicio feed2 = new Inicio();
        feed2.setVisible(true);
//        Feed telaCadastro = new Feed();
//        Teste telaCadastro = new Teste();
//        telaCadastro.setVisible(true);  
//        
        //JFrame frame = new JFrame("Janela Maximizada");
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Inicializa o JFrame
        //frame.setSize(800, 600);
        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);  // Maximiza o JFrame
        
        // Torna visível
        //frame.setVisible(true);

        // Obtém o tamanho e a posição do JFrame após ser maximizado
        /*Rectangle bounds = frame.getBounds();
        int x = bounds.x;  // Posição X
        int y = bounds.y;  // Posição Y
        int width = bounds.width;  // Largura
        int height = bounds.height;  // Altura

        System.out.println("Posição X: " + x + ", Y: " + y);
        System.out.println("Largura: " + width + ", Altura: " + height);*/
        
        /*Rectangle screenBounds = GraphicsEnvironment.getLocalGraphicsEnvironment()
                .getMaximumWindowBounds();

        System.out.println("Largura: " + screenBounds.width);
        System.out.println("Altura: " + screenBounds.height);*/
    }
    
}
