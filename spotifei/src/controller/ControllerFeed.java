/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import model.Playlist;
import DAO.MusicaDAO;
import DAO.Conexao;
import DAO.PlaylistDAO;
import DAO.UsuarioDAO;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
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
    private String campoTexto = "";

    public String getCampoTexto() {
        return campoTexto;
    }

    public void setCampoTexto(String campoTexto) {
        this.campoTexto = campoTexto;
    }
    
    private String nomePlaylistCriada = "";
    private int id_usuario;
    public ControllerFeed() {
    }
    private Feed feed;
    private String feed2;
    public ControllerFeed(Feed feed) {
        this.feed = feed;
    }
    Conexao conexao = new Conexao();
    Musica musica3;
    private boolean cliqueSimulado = false;
    ArrayList<Musica> musica2 = new ArrayList<>();
    JButton botao;
    private ArrayList<JButton> botoesMusica = new ArrayList<>();
    public void buscarMusica(){
        
//        String nomePlaylistCriada = "";
        try {
          
//            Feed feed = new Feed();
            musica2.clear();
            
            feed2 = feed.getBuscaTexto().getText();
            
            Connection conn = conexao.getConnection();
            MusicaDAO dao = new MusicaDAO(conn);
            ResultSet resultado2 = dao.consultarMusica2(feed2);
           
            while (resultado2.next()) {
                feed.getDez_ultimas().setVisible(false);
                feed.getMusicas_curtidas().setVisible(false);
                feed.getMusicas_descurtidas().setVisible(false);
                feed.getNova_playlist().setVisible(false);
                int id = resultado2.getInt("id");
                String musica = resultado2.getString("musica");
                String artista = resultado2.getString("artista");
                String album = resultado2.getString("album");
                String genero = resultado2.getString("genero");
                
                System.out.println("ID: " + id);
                System.out.println("musica " + musica);
                System.out.println("Artista: " + artista);
                System.out.println("Album: " + album);
                System.out.println("Gênero: " + genero);
 
                musica3 = new Musica(musica, artista,album, genero);
                musica2.add(musica3);     
                
            }
        
            feed.getPainel_inicial().setLayout(new BoxLayout(feed.getPainel_inicial(), BoxLayout.Y_AXIS));
//            feed.getPainel_inicial().removeAll();
//            feed.getPainel_inicial().revalidate();
//            feed.getPainel_inicial().repaint();
            new Thread(() -> {
                for (int i = 0; i < musica2.size(); i++) {
                    feed.getPainel_inicial().removeAll();
                    feed.getPainel_inicial().revalidate();
                    feed.getPainel_inicial().repaint();
//                    feed.getPainel_inicial().removeAll();
//                    feed.getPainel_inicial().revalidate();
//                    feed.getPainel_inicial().repaint();
                    final int index = i;

                    SwingUtilities.invokeLater(() -> {
                        // Cria um novo painel para a música (usando BoxLayout horizontal)
                        
                        JPanel panel = new JPanel(); 
                        
                        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS)); 
                        panel.setMaximumSize(new Dimension(1000, 40)); // Controla a largura
                        panel.setPreferredSize(new Dimension(1000, 40));
                       

                        // Cria o label
                        String path = "src/img/gunsnroses.jpeg"; 
                        ImageIcon ic = new ImageIcon(path);
                        Image nw = ic.getImage().getScaledInstance(50, 40, Image.SCALE_AREA_AVERAGING);
                        
                        //img.setIcon(nc); 
                        String nome = musica2.get(index).getMusica();
                        String artista = musica2.get(index).getNome();
//                        JLabel label = new JLabel(artista +": " + nome);
                        botao = new JButton(artista + ": "+ nome, new ImageIcon(nw));
                        botao.setHorizontalTextPosition(SwingConstants.RIGHT);
                        botao.setIconTextGap(10);
                        botao.setHorizontalAlignment(SwingConstants.LEFT);  
                        botao.setPreferredSize(new Dimension(400, 40));
                        botao.setMaximumSize(new Dimension(400, 40));
                        botao.setMinimumSize(new Dimension(400, 40));
                        botao.setAlignmentX(JButton.LEFT_ALIGNMENT);
                        
//                        botao.setBounds(0, 10, 0, 40); // Ajuste conforme necessário
                        panel.add(botao);
                        botoesMusica.add(botao);
                        int finalIndex = index;
                        botao.addActionListener(e -> {
                            Musica musicaSelecionada = musica2.get(finalIndex);
                            novamusica = new Musica(musicaSelecionada.getNome(), musicaSelecionada.getMusica(), musicaSelecionada.getAlbum(), musicaSelecionada.getGenero());
                            playlist = new Playlist(novamusica, campoTexto, id_usuario);
                            System.out.println("Selecionado: " + playlist.getMusica());
                        });
//                        label.setPreferredSize(new Dimension(50, 50)); // Define tamanho visível
//                        panel.add(label);
                        
                        // Adiciona o painel ao painel principal
                        feed.getPainel_inicial().add(panel);
                        feed.getPainel_inicial().revalidate();
                        feed.getPainel_inicial().repaint();
//                        musica2.clear();
                        
                    });
                    

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                
            }).start();
//            musica2.clear();
            }   catch(SQLException e){    
                e.printStackTrace(); // ou:
                System.out.println("Erro: " + e.getMessage());
    }
}
    private Playlist playlist;
    private Musica  novamusica;

    public void novaPlaylist(){ 
        JFrame frame = new JFrame("Playlists");
        try {
//            Feed feed = new Feed();
            
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 200);

            JPanel painel = new JPanel();
            painel.setLayout(new FlowLayout());

            // Botão inicial
            JButton novaPlaylist = new JButton("Nova Playlist");

            // Campo de texto e botão "criar", inicialmente invisíveis
            JTextField nomeDaPlaylist = new JTextField(20);
            JButton criarPlaylist = new JButton("Criar Playlist");
            nomeDaPlaylist.setVisible(false);
            criarPlaylist.setVisible(false);

            // Adiciona os componentes ao painel
            painel.add(novaPlaylist);
            painel.add(nomeDaPlaylist);
            painel.add(criarPlaylist);

            // Ação ao clicar no botão "Nova Playlist"
            novaPlaylist.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    novaPlaylist.setVisible(false);
                    nomeDaPlaylist.setVisible(true);
                    criarPlaylist.setVisible(true);
                    painel.revalidate();
                    painel.repaint();
                }
            });

            // Ação ao clicar em "Criar Playlist" (exemplo: mostrar nome)
            
            criarPlaylist.addActionListener(e -> {
                nomePlaylistCriada = nomeDaPlaylist.getText();
                JOptionPane.showMessageDialog(frame, "Nova playlist criada: Adicione uma música para a  " + nomePlaylistCriada);
                try {
                    Connection conn = conexao.getConnection();
                    PlaylistDAO dao_playlist2 = new PlaylistDAO(conn);
                    dao_playlist2.inserirNomePlaylist(nomePlaylistCriada, id_usuario);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(frame, "Playlist não criada!","Erro", JOptionPane.ERROR_MESSAGE);    
                    ex.printStackTrace();
                }
                // Aqui você poderia salvar no banco de dados etc.
            });
            Login login = new Login();
            frame.add(painel);
            frame.setVisible(true);
            Connection conn = conexao.getConnection();
            PlaylistDAO dao_playlist2 = new PlaylistDAO(conn);
            
            Musica musica3;
            ArrayList<Musica> musica2 = new ArrayList<>();
            ControllerLogin control_login = new ControllerLogin(login);
            PlaylistDAO dao_playlist;
            UsuarioDAO dao_user = new UsuarioDAO(conn);
            System.out.println(feed.getUsuario());
            ResultSet res = dao_user.consultar2(feed.getUsuario());
            
//            dao.inserir(user);
            
            
            if(res.next()){
//                JOptionPane.showMessageDialog(view, 
//                                              "Login efetuado!", 
//                                              "Aviso",
//                                              JOptionPane.INFORMATION_MESSAGE);
                id_usuario = res.getInt("id");
                System.out.println(id_usuario);
//                ResultSet resultado_playlist = dao_playlist2.consultarPlaylist(id_usuario);
//                String nome = nomeDaPlaylist.getText();
//                dao_playlist = new PlaylistDAO(conn);
               
//                dao_playlist.inserirNomePlaylist(nome, id_usuario);
//                try {
//                    dao_playlist2 = new PlaylistDAO(conn);
//                    System.out.println(nomePlaylistCriada);
//                    System.out.println(id_usuario);
//                    dao_playlist2.inserirNomePlaylist(nomePlaylistCriada, id_usuario);
//                } catch (SQLException ex) {
//                    JOptionPane.showMessageDialog(frame, "Playlist não criada!","Erro", JOptionPane.ERROR_MESSAGE);    
//                }
            

                feed.setVisible(true);
                
                /*AltExcFrame aec = new AltExcFrame(aluno2);
                aec.setVisible(true);*/
            } else{
//                JOptionPane.showMessageDialog(view, 
//                                              "Login NÃO efetuado!", 
//                                              "Aviso",
//                                              JOptionPane.ERROR_MESSAGE);
                feed.setVisible(false);
            }
            
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(frame, "Playlist não criada!","Erro", JOptionPane.ERROR_MESSAGE);

        }
            
    
            
            try{
                ArrayList<Playlist> playlist = new ArrayList<>();
                Connection conn = conexao.getConnection();
                PlaylistDAO dao_playlist5 = new PlaylistDAO(conn);
                ResultSet resultado2 = dao_playlist5.consultarPlaylist(id_usuario);
           
                while (resultado2.next()) {
//                    int id = resultado2.getInt(""); 
                    String nome_Playlist = resultado2.getString("nome_playlist"); 
//                    System.out.println(nome_Playlist);
                    playlist.add(new Playlist(nome_Playlist));
                }
                feed.getPainelPrincipal().setLayout(new BoxLayout(feed.getPainelPrincipal(), BoxLayout.Y_AXIS));
                new Thread(() -> {
                    feed.getPainelPrincipal().removeAll();
                    feed.getPainelPrincipal().revalidate();
                    feed.getPainelPrincipal().repaint();
                    for (int i = 0; i < playlist.size(); i++) {
                        final int index = i;

                        SwingUtilities.invokeLater(() -> {
                            // Cria um novo painel para a música (usando BoxLayout horizontal)

                            JPanel panel = new JPanel(); 
                            panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS)); 
                            panel.setMaximumSize(new Dimension(400, 40)); // Controla a largura
                            panel.setPreferredSize(new Dimension(400, 40));


                            // Cria o label

                            //img.setIcon(nc);
                            String nome_da_playlist = playlist.get(index).getNome_playlist();
    //                        JLabel label = new JLabel(artista +": " + nome);
                            System.out.println(nome_da_playlist);
                            JButton botao = new JButton(nome_da_playlist);
                            botao.setHorizontalTextPosition(SwingConstants.RIGHT);
                            botao.setIconTextGap(10);
                            botao.setHorizontalAlignment(SwingConstants.LEFT);  
                            botao.setPreferredSize(new Dimension(400, 40));
                            botao.setMaximumSize(new Dimension(400, 40));
                            botao.setMinimumSize(new Dimension(400, 40));
                            botao.setAlignmentX(JButton.LEFT_ALIGNMENT);
    //                        botao.setBounds(0, 10, 0, 40); // Ajuste conforme necessário
                            panel.add(botao);
                            botao.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mousePressed(MouseEvent e) {
                                    if (SwingUtilities.isRightMouseButton(e)) {
                                        String texto = ((JButton) e.getSource()).getText();
                                        setCampoTexto(texto);
                                        // Também pode exibir em uma mensagem se quiser
//                                        JOptionPane.showMessageDialog(null, "Texto copiado: " + textoBotao);
                                    }
                                }
                            });

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
            }  catch(SQLException e){    
                e.printStackTrace(); // ou:
                System.out.println("Erro: " + e.getMessage());
            }
        
        }
      
}
    
