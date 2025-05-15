/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import model.Playlist;
import DAO.MusicaDAO;
import DAO.Conexao;
import java.awt.Dimension;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import model.Musica;
import model.Pessoa;
import model.Usuario;
import view.Login;
import view.Feed;

/**
 *
 * @author leona
 */
public class ControllerFeed {

   
    public ControllerFeed() {
    }
    private Feed feed;

    public ControllerFeed(Feed feed) {
        this.feed = feed;
    }


    Conexao conexao = new Conexao();
    public void carregarMusica(){       
        try {
//            Feed feed = new Feed();
            Connection conn = conexao.getConnection();
            MusicaDAO dao = new MusicaDAO(conn);
            ResultSet resultado = dao.consultarMusica();
            Musica musica3;
            ArrayList<Musica> musica2 = new ArrayList<>();
            while (resultado.next()) {
                int id = resultado.getInt("id");
                String musica = resultado.getString("musica");
                String artista = resultado.getString("artista");
                String album = resultado.getString("album");

                System.out.println("ID: " + id);
                System.out.println("musica " + musica);
                System.out.println("Artista: " + artista);
                System.out.println("Album: " + album);
 
                musica3 = new Musica(musica, artista,album);
                musica2.add(musica3);     
                
            }
//            feed.getPainelPrincipal().setLayout(new BoxLayout(feed.getPainelPrincipal(), BoxLayout.Y_AXIS));
//            new Thread(() -> {
//                    for (int i = 0; i < musica2.size(); i++) {
//                        final int index = i;
//                        
//                        
//                        SwingUtilities.invokeLater(() -> {
//                            JPanel panel = new JPanel(null);
//                            panel.setPreferredSize(new Dimension(20, 20));
//                            if(musica2.get(index)!=null){
//                                String nome = musica2.get(index).getMusica();
//                                JLabel label = new JLabel("Músca " + nome);
//                                label.setBounds(0, 10, 10, 10);
//                                panel.add(label);
//
//                                feed.getPainelPrincipal().add(panel);
//                                feed.getPainelPrincipal().revalidate();
//                                feed.getPainelPrincipal().repaint();
//                            }
//                            
//                        });
//
//                        try {
//                            Thread.sleep(10); 
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }).start();
//            
//        }   catch(SQLException e){    
//                e.printStackTrace(); // ou:
//                System.out.println("Erro: " + e.getMessage());
//            }
        
            feed.getPainelPrincipal().setLayout(new BoxLayout(feed.getPainelPrincipal(), BoxLayout.Y_AXIS));

            new Thread(() -> {
                for (int i = 0; i < musica2.size(); i++) {
                    final int index = i;
//                    SwingUtilities.invokeLater(() -> {
//                        JPanel panel = new JPanel(); // Usa layout padrão
//                        //panel.setPreferredSize(new Dimension(400, 40)); // Largura igual à do painel principal
//                        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS)); 
//                        String nome = musica2.get(index).getMusica();
//                        JLabel label = new JLabel("Música: " + nome);
//                        label.setBounds(10, 50, 80, 80);
//                        panel.add(label);
//
//                        feed.getPainelPrincipal().add(panel);
//                        feed.getPainelPrincipal().revalidate();
//                        feed.getPainelPrincipal().repaint();
//                    });
                    SwingUtilities.invokeLater(() -> {
                        // Cria um novo painel para a música (usando BoxLayout horizontal)
                        
                        JPanel panel = new JPanel();
                        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
                        panel.setMaximumSize(new Dimension(400, 40)); // Controla a largura
                        panel.setPreferredSize(new Dimension(400, 40));

                        // Cria o label
                        String path = "C:\\Users\\leona\\Documents\\NetBeansProjects\\spotifei\\src\\img\\gunsnroses.jpeg";
                        ImageIcon ic = new ImageIcon(path);
                        Image nw = ic.getImage().getScaledInstance(50, 40, Image.SCALE_AREA_AVERAGING);
                        
                        //img.setIcon(nc); 
                        String nome = musica2.get(index).getMusica();
                        String artista = musica2.get(index).getArtista();
//                        JLabel label = new JLabel(artista +": " + nome);
                        JButton botao = new JButton(artista + ": "+ nome, new ImageIcon(nw));
                        botao.setBounds(100, 10, 200, 40); // Ajuste conforme necessário
                        panel.add(botao);
//                        label.setPreferredSize(new Dimension(50, 50)); // Define tamanho visível
//                        panel.add(label);

                        // Adiciona o painel ao painel principal
                        feed.getPainelPrincipal().add(panel);
                        feed.getPainelPrincipal().revalidate();
                        feed.getPainelPrincipal().repaint();
                    });
                    

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            
            }   catch(SQLException e){    
                e.printStackTrace(); // ou:
                System.out.println("Erro: " + e.getMessage());
        }

        

    }
}
