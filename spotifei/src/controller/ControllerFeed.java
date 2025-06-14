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
import java.awt.Component;
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
import model.IconMusica;
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
    private String campoTexto2 = "";
    public String getCampoTexto() {
        return campoTexto;
    }

    public void setCampoTexto(String campoTexto) {
        this.campoTexto = campoTexto;
    }

    public String getCampoTexto2() {
        return campoTexto2;
    }

    public void setCampoTexto2(String campoTexto2) {
        this.campoTexto2 = campoTexto2;
    }
    
    private String nomePlaylistCriada = "";
    private int id_usuario;
    public ControllerFeed() {
        feed.getDez_ultimas().addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            exibirDezUltimasMusicasBuscadas();
        }
        });
    }
    
    
    private Feed feed;
    private String feed2;
    public ControllerFeed(Feed feed) {
        this.feed = feed;
    }
    Conexao conexao = new Conexao();
    Musica musica3;
    IconMusica icon_musica1;
    private boolean cliqueSimulado = false;
    ArrayList<Musica> musica2 = new ArrayList<>();
    ArrayList<IconMusica> icon_musica2 = new ArrayList<>();
    JButton botao;
    private ArrayList<JButton> botoesMusica = new ArrayList<>();
    public void buscarMusica(){
        
//        String nomePlaylistCriada = "";
        try {
          
//            Feed feed = new Feed();
            musica2.clear();
            icon_musica2.clear();
            
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
                String caminho = resultado2.getString("caminho_local");
                
                System.out.println("ID: " + id);
                System.out.println("musica " + musica);
                System.out.println("Artista: " + artista);
                System.out.println("Album: " + album);
                System.out.println("Gênero: " + genero);
 
                musica3 = new Musica(id, musica, artista,album, genero);
                
                musica2.add(musica3);     
                icon_musica1 = new IconMusica(caminho);
                icon_musica2.add(icon_musica1);
                dao.registrarBuscaMusica(id_usuario, id);
                if (id_usuario != 0) {
                    dao.registrarBuscaMusica(id_usuario, id);
                } else{
                    System.out.println("Não há histórico de músicas ainda");
                }
            }
        
            feed.getPainel_inicial().setLayout(new BoxLayout(feed.getPainel_inicial(), BoxLayout.Y_AXIS));
//            feed.getPainel_inicial().removeAll();
//            feed.getPainel_inicial().revalidate();
//            feed.getPainel_inicial().repaint();
            new Thread(() -> {
                feed.getPainel_inicial().removeAll();
                feed.getPainel_inicial().revalidate();
                feed.getPainel_inicial().repaint();
                for (int i = 0; i < musica2.size(); i++) {
//                    feed.getPainel_inicial().removeAll();
//                    feed.getPainel_inicial().revalidate();
//                    feed.getPainel_inicial().repaint();
//                    feed.getPainel_inicial().removeAll();
//                    feed.getPainel_inicial().revalidate();
//                    feed.getPainel_inicial().repaint();
                    final int index = i;

                    SwingUtilities.invokeLater(() -> {
                        // Cria um novo painel para a música (usando BoxLayout horizontal)
                        
                        JPanel panel = new JPanel(); 
                        
                        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS)); 
                        panel.setMaximumSize(new Dimension(400, 40)); // Controla a largura
                        panel.setPreferredSize(new Dimension(400, 40));
                        panel.setAlignmentX(JPanel.LEFT_ALIGNMENT);
                       

                        // Cria o label
                        String icone_musica = icon_musica2.get(index).getIcon_caminho();
                        String path = icone_musica; 
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
                        botao.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mousePressed(MouseEvent e) {
                                if (SwingUtilities.isRightMouseButton(e)) {
                                    String texto = ((JButton) e.getSource()).getText();
                                    setCampoTexto2(texto);
                                }
                            }
                            
                        });
                        botao.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mousePressed(MouseEvent e) {
                                if (SwingUtilities.isLeftMouseButton(e)) {
                                    String texto = ((JButton) e.getSource()).getText();
//                                    setCampoTexto2(texto);
                                    int id_playlist;
                                    for (int cont = 0; cont < musica2.size(); cont++){
                                            final int index2 = cont;
                                            String var = musica2.get(index2).getNome() + ": " + musica2.get(index2).getMusica();
                                            if(var.equals(texto)){
    //                                        int id_playlist;
                                            try (Connection conn = conexao.getConnection()) {
                                                // Buscar ID da playlist
                                                PlaylistDAO dao_playlist = new PlaylistDAO(conn);
                                                ResultSet resultado3 = dao_playlist.consultarPlaylist2(id_usuario, campoTexto);

                                                
                                                if (resultado3.next()) {
                                                    id_playlist = resultado3.getInt("id_playlist");
                                                    resultado3.close(); // Fechar o ResultSet quando terminar
                                                } else {
                                                    JOptionPane.showMessageDialog(null, "Playlist não encontrada");
                                                    resultado3.close();
                                                    return;
                                                }

                                                // Buscar ID da música e inserir na playlist
                                                MusicaDAO dao = new MusicaDAO(conn);
                                                ResultSet resultado2 = dao.consultarMusica3(musica2.get(index2).getMusica()); // Usa o texto do botão diretamente

                                                if (resultado2.next()) {
                                                    System.out.println(resultado2.getInt("id"));
                                                    System.out.println(id_playlist);
                                                    int id_musica = resultado2.getInt("id");
                                                    // Inserir música na playlist
                                                    dao_playlist.inserirMusicaPlaylist(id_playlist, id_musica);
                                                    JOptionPane.showMessageDialog(null, "Música adicionada à playlist!");
                                                    resultado2.close();
                                                } else {
                                                    JOptionPane.showMessageDialog(null, "Música não encontrada");
                                                    resultado2.close();
                                                }

                                            } catch (SQLException ex) {
                                                JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
                                            }
                                        }
                                    }
                                }
                            }
                        });
                        
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
            frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/spotifei3-removebg-preview.png")));
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
//            Login login = new Login();
            frame.add(painel);
            frame.setVisible(true);
            Connection conn = conexao.getConnection();
            PlaylistDAO dao_playlist2 = new PlaylistDAO(conn);
            
            Musica musica3;
            ArrayList<Musica> musica2 = new ArrayList<>();
//            ControllerLogin control_login = new ControllerLogin(login);
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
                            panel.setAlignmentX(JPanel.LEFT_ALIGNMENT);


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
                                        System.out.println(campoTexto);
                                        // Também pode exibir em uma mensagem se quiser
//                                        JOptionPane.showMessageDialog(null, "Texto copiado: " + textoBotao);
                                    }
                                }
                            });
                            
                            botao.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mousePressed(MouseEvent e) {
                                    if (SwingUtilities.isLeftMouseButton(e)) {
                                        String texto = ((JButton) e.getSource()).getText();
                                        System.out.println(texto);

                                        Connection conn = null;
                                        try {
                                            // Limpar a lista antes de adicionar novos itens
                                            musica2.clear();
                                            icon_musica2.clear();
                                            // Obter a conexão com o banco de dados
                                            conn = conexao.getConnection();
                                            MusicaDAO dao = new MusicaDAO(conn);

                                            // Ocultar outros painéis antes da consulta
                                            feed.getDez_ultimas().setVisible(false);
                                            feed.getMusicas_curtidas().setVisible(false);
                                            feed.getMusicas_descurtidas().setVisible(false);
                                            feed.getNova_playlist().setVisible(false);

                                            // Consultar músicas da playlist
                                            ResultSet resultado2 = dao.consultarMusicaPlaylist(texto, id_usuario);
                                            while (resultado2.next()) {
                                                int id = resultado2.getInt("id");
                                                String musica = resultado2.getString("musica");
                                                String artista = resultado2.getString("artista");
                                                String album = resultado2.getString("album");
                                                String genero = resultado2.getString("genero");
                                                String caminho = resultado2.getString("caminho_local");
                                                
                                                System.out.println("ID: " + id);
                                                System.out.println("Música: " + musica);
                                                System.out.println("Artista: " + artista);
                                                System.out.println("Álbum: " + album);
                                                System.out.println("Gênero: " + genero);
                                                
                                                Musica musica3 = new Musica(id, musica, artista, album, genero);
                                                musica2.add(musica3);
                                                icon_musica1 = new IconMusica(caminho);
                                                icon_musica2.add(icon_musica1);
                                            }

                                            // Atualizar a interface com os resultados
                                            atualizarInterfaceComResultados();

                                        } catch (SQLException ex) {
                                            ex.printStackTrace();
                                            JOptionPane.showMessageDialog(null, "Erro ao consultar músicas: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                                        } finally {
                                            // Você pode adicionar código para fechar a conexão se necessário
                                            // Dependendo de como seu pool de conexões está configurado
                                        }
                                    } else {
                                        System.out.println("Clique direito ou outro botão do mouse");
                                    }
                                }

                                // Método separado para atualizar a interface
                                private void atualizarInterfaceComResultados() {
                                    SwingUtilities.invokeLater(() -> {
                                        // Configurar o layout do painel
                                        feed.getPainel_inicial().setLayout(new BoxLayout(feed.getPainel_inicial(), BoxLayout.Y_AXIS));
                                        feed.getPainel_inicial().removeAll();

                                        // Adicionar os resultados ao painel
                                        for (int i = 0; i < musica2.size(); i++) {
                                            JPanel panel = new JPanel(); 
                                            panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS)); 
                                            panel.setMaximumSize(new Dimension(400, 40)); 
                                            panel.setPreferredSize(new Dimension(400, 40));
                                            panel.setAlignmentX(JPanel.LEFT_ALIGNMENT);
                                            
                                            // Carregar a imagem
                                            String icone_musica = icon_musica2.get(i).getIcon_caminho();
                                            String path = icone_musica; 
                                            
                                            ImageIcon ic = new ImageIcon(path);
                                            Image nw = ic.getImage().getScaledInstance(50, 40, Image.SCALE_AREA_AVERAGING);

                                            // Obter informações da música
                                            String nome = musica2.get(i).getMusica();
                                            String artista = musica2.get(i).getNome();

                                            // Criar botão com imagem e texto
                                            JButton botao = new JButton(artista + ": " + nome, new ImageIcon(nw));
                                            botao.setHorizontalTextPosition(SwingConstants.RIGHT);
                                            botao.setIconTextGap(10);
                                            botao.setHorizontalAlignment(SwingConstants.LEFT);  
                                            botao.setPreferredSize(new Dimension(400, 40));
                                            botao.setMaximumSize(new Dimension(400, 40));
                                            botao.setMinimumSize(new Dimension(400, 40));
                                            botao.setAlignmentX(JButton.LEFT_ALIGNMENT);
                                            
                                            botao.addMouseListener(new MouseAdapter() {
                                            @Override
                                            public void mousePressed(MouseEvent e) {
                                                if (SwingUtilities.isRightMouseButton(e)) {
                                                    String texto = ((JButton) e.getSource()).getText();
                                                    setCampoTexto2(texto);
                                                }
                                            }

                                            });

                                            panel.add(botao);
                                            botoesMusica.add(botao);
                                            feed.getPainel_inicial().add(panel);
                                        }

                                        // Atualizar o painel
                                        feed.getPainel_inicial().revalidate();
                                        feed.getPainel_inicial().repaint();
                                    });
                                }
                            });


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
    
    public void exibirDezUltimasMusicasBuscadas() {
        try {
            Connection conn = conexao.getConnection();
            MusicaDAO dao = new MusicaDAO(conn);

            // Limpa o arraylist de músicas
            musica2.clear();
            icon_musica2.clear();

            // Oculta outros painéis
            feed.getMusicas_curtidas().setVisible(false);
            feed.getMusicas_descurtidas().setVisible(false);
            feed.getNova_playlist().setVisible(false);

            // Consulta as 10 últimas músicas buscadas
            ResultSet resultado = dao.consultarUltimasMusicasBuscadas(id_usuario, 10);

            while (resultado.next()) {
                int id = resultado.getInt("id");
                String musica = resultado.getString("musica");
                String artista = resultado.getString("artista");
                String album = resultado.getString("album");
                String genero = resultado.getString("genero");
                String caminho = resultado.getString("caminho_local");

                Musica musica3 = new Musica(id, musica, artista, album, genero);
                musica2.add(musica3);
                icon_musica1 = new IconMusica(caminho);
                icon_musica2.add(icon_musica1);
            }

            resultado.close();

            // Configura o layout do painel
            feed.getPainel_inicial().setLayout(new BoxLayout(feed.getPainel_inicial(), BoxLayout.Y_AXIS));
            feed.getPainel_inicial().removeAll();
            feed.getPainel_inicial().revalidate();
            feed.getPainel_inicial().repaint();

            // Adiciona músicas ao painel
            for (int i = 0; i < musica2.size(); i++) {
                final int index = i;

                // Cria um novo painel para a música
                JPanel panel = new JPanel();
                panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
                panel.setMaximumSize(new Dimension(400, 40));
                panel.setPreferredSize(new Dimension(400, 40));
                panel.setAlignmentX(JPanel.LEFT_ALIGNMENT);

                // Carrega a imagem
                String icone_musica = icon_musica2.get(index).getIcon_caminho();
                String path = icone_musica; 
                ImageIcon ic = new ImageIcon(path);
                Image nw = ic.getImage().getScaledInstance(50, 40, Image.SCALE_AREA_AVERAGING);

                // Cria o botão com a música
                String nome = musica2.get(index).getMusica();
                String artista = musica2.get(index).getNome();

                JButton botao = new JButton(artista + ": " + nome, new ImageIcon(nw));
                botao.setHorizontalTextPosition(SwingConstants.RIGHT);
                botao.setIconTextGap(10);
                botao.setHorizontalAlignment(SwingConstants.LEFT);
                botao.setPreferredSize(new Dimension(400, 40));
                botao.setMaximumSize(new Dimension(400, 40));
                botao.setMinimumSize(new Dimension(400, 40));
                botao.setAlignmentX(JButton.LEFT_ALIGNMENT);

                panel.add(botao);
                botoesMusica.add(botao);

                // Adiciona evento de clique
                botao.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        if (SwingUtilities.isRightMouseButton(e)) {
                            String texto = ((JButton) e.getSource()).getText();
                            setCampoTexto2(texto);
                        }
                    }
                });

                botao.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        if (SwingUtilities.isLeftMouseButton(e)) {
                            String texto = ((JButton) e.getSource()).getText();
                            setCampoTexto2(texto);

                            // Código para adicionar música a uma playlist, se uma playlist estiver selecionada
                            if (!campoTexto.isEmpty()) {
                                int id_playlist;
                                for (int cont = 0; cont < musica2.size(); cont++) {
                                    final int index2 = cont;
                                    String var = musica2.get(index2).getNome() + ": " + musica2.get(index2).getMusica();
                                    if (var.equals(texto)) {
                                        try (Connection conn = conexao.getConnection()) {
                                            // Buscar ID da playlist
                                            PlaylistDAO dao_playlist = new PlaylistDAO(conn);
                                            ResultSet resultado3 = dao_playlist.consultarPlaylist2(id_usuario, campoTexto);

                                            if (resultado3.next()) {
                                                id_playlist = resultado3.getInt("id_playlist");
                                                resultado3.close();
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Playlist não encontrada");
                                                resultado3.close();
                                                return;
                                            }

                                            // Buscar ID da música e inserir na playlist
                                            MusicaDAO dao = new MusicaDAO(conn);
                                            ResultSet resultado2 = dao.consultarMusica3(musica2.get(index2).getMusica());

                                            if (resultado2.next()) {
                                                int id_musica = resultado2.getInt("id");
                                                // Inserir música na playlist
                                                dao_playlist.inserirMusicaPlaylist(id_playlist, id_musica);
                                                JOptionPane.showMessageDialog(null, "Música adicionada à playlist!");
                                                resultado2.close();
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Música não encontrada");
                                                resultado2.close();
                                            }
                                        } catch (SQLException ex) {
                                            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
                                        }
                                    }
                                }
                            }
                        }
                    }
                });
            
                feed.getPainel_inicial().add(panel);
            }

            feed.getPainel_inicial().revalidate();
            feed.getPainel_inicial().repaint();

            if (musica2.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Você ainda não tem histórico de buscas!",
                                             "Informação", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao exibir histórico de músicas: " + e.getMessage(),
                                         "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
        
    public void curtir() {
        try {
            // Verifica se há uma música selecionada
            if (campoTexto2.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Selecione uma música primeiro!", 
                                              "Aviso", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            Connection conn = conexao.getConnection();

            // Parseia o texto do botão para obter o nome da música
            // Formato esperado: "Artista: Nome da música"
            String textoCompleto = campoTexto2;
            int indexSeparador = textoCompleto.indexOf(": ");
            if (indexSeparador == -1) {
                JOptionPane.showMessageDialog(null, "Formato de música inválido!", 
                                             "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String artista = textoCompleto.substring(0, indexSeparador);
            String nomeMusica = textoCompleto.substring(indexSeparador + 2);

            System.out.println("Artista: " + artista);
            System.out.println("Nome da música: " + nomeMusica);

            // Consulta o ID da música
            MusicaDAO musicaDAO = new MusicaDAO(conn);
            int idMusica = -1;

            // Consulta usando o nome da música
            PreparedStatement musicaStmt = conn.prepareStatement(
                "SELECT id FROM musica WHERE musica = ?"
            );
            musicaStmt.setString(1, nomeMusica);
            ResultSet musicaResult = musicaStmt.executeQuery();

            if (musicaResult.next()) {
                idMusica = musicaResult.getInt("id");
                musicaResult.close();
                musicaStmt.close();
            } else {
                JOptionPane.showMessageDialog(null, "Música não encontrada no banco de dados!", 
                                             "Erro", JOptionPane.ERROR_MESSAGE);
                musicaResult.close();
                musicaStmt.close();
                conn.close();
                return;
            }

            System.out.println("ID da música encontrado: " + idMusica);

            // Verifica se a música já foi curtida pelo usuário
            PreparedStatement verificaStmt = conn.prepareStatement(
                "SELECT * FROM musicas_curtidas WHERE id_usuario = ? AND id_musica = ?"
            );
            verificaStmt.setInt(1, id_usuario);
            verificaStmt.setInt(2, idMusica);
            ResultSet verificaResult = verificaStmt.executeQuery();

            if (verificaResult.next()) {
                JOptionPane.showMessageDialog(null, "Você já curtiu esta música!", 
                                             "Aviso", JOptionPane.INFORMATION_MESSAGE);
                verificaResult.close();
                verificaStmt.close();
                conn.close();
                return;
            }
            verificaResult.close();
            verificaStmt.close();

            // Remove da lista de descurtidas, se estiver lá
            PreparedStatement removeDescurtidasStmt = conn.prepareStatement(
                "DELETE FROM musicas_descurtidas WHERE id_usuario = ? AND id_musica = ?"
            );
            removeDescurtidasStmt.setInt(1, id_usuario);
            removeDescurtidasStmt.setInt(2, idMusica);
            removeDescurtidasStmt.executeUpdate();
            removeDescurtidasStmt.close();

            // Adiciona a música às curtidas
            PreparedStatement stmt = conn.prepareStatement(
                "INSERT INTO musicas_curtidas (id_usuario, id_musica, data_curtida) VALUES (?, ?, CURRENT_TIMESTAMP)"
            );
            stmt.setInt(1, id_usuario);
            stmt.setInt(2, idMusica);

            int linhasAfetadas = stmt.executeUpdate();
            stmt.close();

            if (linhasAfetadas > 0) {
                JOptionPane.showMessageDialog(null, "Música curtida com sucesso!", 
                                             "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Não foi possível curtir a música!", 
                                             "Erro", JOptionPane.ERROR_MESSAGE);
            }

            conn.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao curtir música: " + e.getMessage(),
                                         "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    
    
    /**
     * Método para descurtir uma música
     * Adiciona a música à lista de músicas descurtidas pelo usuário
     */
    public void descurtir() {
        try {
            // Verifica se há uma música selecionada
            if (campoTexto2.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Selecione uma música primeiro!", 
                                              "Aviso", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            
            Connection conn = conexao.getConnection();
            
            // Parseia o texto do botão para obter o nome da música
            // Formato esperado: "Artista: Nome da música"
            String textoCompleto = campoTexto2;
            int indexSeparador = textoCompleto.indexOf(": ");
            if (indexSeparador == -1) {
                JOptionPane.showMessageDialog(null, "Formato de música inválido!", 
                                             "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            String artista = textoCompleto.substring(0, indexSeparador);
            String nomeMusica = textoCompleto.substring(indexSeparador + 2);
            
            // Consulta o ID da música
            MusicaDAO musicaDAO = new MusicaDAO(conn);
            int idMusica = -1;
            
            // Consulta usando o nome da música
            ResultSet resultado = musicaDAO.consultarMusica3(nomeMusica);
            if (resultado.next()) {
                idMusica = resultado.getInt("id");
                resultado.close();
            } else {
                JOptionPane.showMessageDialog(null, "Música não encontrada no banco de dados!", 
                                             "Erro", JOptionPane.ERROR_MESSAGE);
                resultado.close();
                return;
            }
            
            // Verifica se a música já foi descurtida pelo usuário
            PreparedStatement verificaStmt = conn.prepareStatement(
                "SELECT * FROM musicas_descurtidas WHERE id_usuario = ? AND id_musica = ?"
            );
            verificaStmt.setInt(1, id_usuario);
            verificaStmt.setInt(2, idMusica);
            ResultSet verificaResult = verificaStmt.executeQuery();
            
            if (verificaResult.next()) {
                JOptionPane.showMessageDialog(null, "Você já descurtiu esta música!", 
                                             "Aviso", JOptionPane.INFORMATION_MESSAGE);
                verificaResult.close();
                verificaStmt.close();
                return;
            }
            verificaResult.close();
            verificaStmt.close();
            
            // Remove da lista de curtidas, se estiver lá
            PreparedStatement removeCurtidasStmt = conn.prepareStatement(
                "DELETE FROM musicas_curtidas WHERE id_usuario = ? AND id_musica = ?"
            );
            removeCurtidasStmt.setInt(1, id_usuario);
            removeCurtidasStmt.setInt(2, idMusica);
            removeCurtidasStmt.executeUpdate();
            removeCurtidasStmt.close();
            
            // Adiciona a música às descurtidas
            PreparedStatement stmt = conn.prepareStatement(
                "INSERT INTO musicas_descurtidas (id_usuario, id_musica, data_descurtida) VALUES (?, ?, CURRENT_TIMESTAMP)"
            );
            stmt.setInt(1, id_usuario);
            stmt.setInt(2, idMusica);
            
            int linhasAfetadas = stmt.executeUpdate();
            stmt.close();
            
            if (linhasAfetadas > 0) {
                JOptionPane.showMessageDialog(null, "Música descurtida com sucesso!", 
                                             "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Não foi possível descurtir a música!", 
                                             "Erro", JOptionPane.ERROR_MESSAGE);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao descurtir música: " + e.getMessage(),
                                         "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    
    /**
     * Método para exibir as músicas curtidas pelo usuário
     */
    public void exibirMusicasCurtidas() {
        try {
            Connection conn = conexao.getConnection();
            MusicaDAO dao = new MusicaDAO(conn);
            
            // Limpa o arraylist de músicas
            musica2.clear();
            icon_musica2.clear();
            // Oculta outros painéis
            feed.getDez_ultimas().setVisible(false);
            feed.getMusicas_descurtidas().setVisible(false);
            feed.getNova_playlist().setVisible(false);
            
            // Consulta músicas curtidas
            ResultSet resultado = dao.consultarMusicasCurtidas(id_usuario);
            
            while (resultado.next()) {
                int id = resultado.getInt("id");
                String musica = resultado.getString("musica");
                String artista = resultado.getString("artista");
                String album = resultado.getString("album");
                String genero = resultado.getString("genero");
                String caminho = resultado.getString("caminho_local");
                
                Musica musica3 = new Musica(id, musica, artista, album, genero);
                musica2.add(musica3);
                icon_musica1 = new IconMusica(caminho);
                icon_musica2.add(icon_musica1);
                
            }
            
            resultado.close();
            
            // Configura o layout do painel
            feed.getPainel_inicial().setLayout(new BoxLayout(feed.getPainel_inicial(), BoxLayout.Y_AXIS));
            feed.getPainel_inicial().removeAll();
            feed.getPainel_inicial().revalidate();
            feed.getPainel_inicial().repaint();
            
            // Adiciona músicas ao painel
            for (int i = 0; i < musica2.size(); i++) {
                final int index = i;
                
                // Cria um novo painel para a música
                JPanel panel = new JPanel();
                panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
                panel.setMaximumSize(new Dimension(400, 40));
                panel.setPreferredSize(new Dimension(400, 40));
                panel.setAlignmentX(JPanel.LEFT_ALIGNMENT);
                // Carrega a imagem
                
                String icone_musica = icon_musica2.get(index).getIcon_caminho();
                String path = icone_musica;
                ImageIcon ic = new ImageIcon(path);
                Image nw = ic.getImage().getScaledInstance(50, 40, Image.SCALE_AREA_AVERAGING);
                
                // Cria o botão com a música
                String nome = musica2.get(index).getMusica();
                String artista = musica2.get(index).getNome();
                
                JButton botao = new JButton(artista + ": " + nome, new ImageIcon(nw));
                botao.setHorizontalTextPosition(SwingConstants.RIGHT);
                botao.setIconTextGap(10);
                botao.setHorizontalAlignment(SwingConstants.LEFT);
                botao.setPreferredSize(new Dimension(400, 40));
                botao.setMaximumSize(new Dimension(400, 40));
                botao.setMinimumSize(new Dimension(400, 40));
                botao.setAlignmentX(JButton.LEFT_ALIGNMENT);
                
                panel.add(botao);
                botoesMusica.add(botao);
                
                // Adiciona evento de clique
                botao.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        if (SwingUtilities.isLeftMouseButton(e)) {
                            String texto = ((JButton) e.getSource()).getText();
                            setCampoTexto2(texto);
                        }
                    }
                });
                
                feed.getPainel_inicial().add(panel);
            }
            
            feed.getPainel_inicial().revalidate();
            feed.getPainel_inicial().repaint();
            
            if (musica2.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Você ainda não tem músicas curtidas!",
                                             "Informação", JOptionPane.INFORMATION_MESSAGE);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao exibir músicas curtidas: " + e.getMessage(),
                                         "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    
    /**
     * Método para exibir as músicas descurtidas pelo usuário
     */
    public void exibirMusicasDescurtidas() {
        try {
            Connection conn = conexao.getConnection();
            MusicaDAO dao = new MusicaDAO(conn);
            
            // Limpa o arraylist de músicas
            musica2.clear();
            icon_musica2.clear();
            // Oculta outros painéis
            feed.getDez_ultimas().setVisible(false);
            feed.getMusicas_curtidas().setVisible(false);
            feed.getNova_playlist().setVisible(false);
            
            // Consulta músicas descurtidas
            ResultSet resultado = dao.consultarMusicasDescurtidas(id_usuario);
            
            while (resultado.next()) {
                int id = resultado.getInt("id");
                String musica = resultado.getString("musica");
                String artista = resultado.getString("artista");
                String album = resultado.getString("album");
                String genero = resultado.getString("genero");
                String caminho = resultado.getString("caminho_local");
                
                Musica musica3 = new Musica(id, musica, artista, album, genero);
                musica2.add(musica3);
                icon_musica1 = new IconMusica(caminho);
                icon_musica2.add(icon_musica1);
            }
            
            resultado.close();
            
            // Configura o layout do painel
            feed.getPainel_inicial().setLayout(new BoxLayout(feed.getPainel_inicial(), BoxLayout.Y_AXIS));
            feed.getPainel_inicial().removeAll();
            feed.getPainel_inicial().revalidate();
            feed.getPainel_inicial().repaint();
            
            // Adiciona músicas ao painel
            for (int i = 0; i < musica2.size(); i++) {
                final int index = i;
                
                // Cria um novo painel para a música
                JPanel panel = new JPanel();
                panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
                panel.setMaximumSize(new Dimension(400, 40));
                panel.setPreferredSize(new Dimension(400, 40));
                panel.setAlignmentX(JPanel.LEFT_ALIGNMENT);
                // Carrega a imagem
                String icone_musica = icon_musica2.get(index).getIcon_caminho();
                String path = icone_musica; 
                ImageIcon ic = new ImageIcon(path);
                Image nw = ic.getImage().getScaledInstance(50, 40, Image.SCALE_AREA_AVERAGING);
                
                // Cria o botão com a música
                String nome = musica2.get(index).getMusica();
                String artista = musica2.get(index).getNome();
                
                JButton botao = new JButton(artista + ": " + nome, new ImageIcon(nw));
                botao.setHorizontalTextPosition(SwingConstants.RIGHT);
                botao.setIconTextGap(10);
                botao.setHorizontalAlignment(SwingConstants.LEFT);
                botao.setPreferredSize(new Dimension(400, 40));
                botao.setMaximumSize(new Dimension(400, 40));
                botao.setMinimumSize(new Dimension(400, 40));
                botao.setAlignmentX(JButton.LEFT_ALIGNMENT);
                
                panel.add(botao);
                botoesMusica.add(botao);
                
                // Adiciona evento de clique
                botao.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        if (SwingUtilities.isLeftMouseButton(e)) {
                            String texto = ((JButton) e.getSource()).getText();
                            setCampoTexto2(texto);
                        }
                    }
                });
                
                feed.getPainel_inicial().add(panel);
            }
            
            feed.getPainel_inicial().revalidate();
            feed.getPainel_inicial().repaint();
            
            if (musica2.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Você ainda não tem músicas descurtidas!",
                                             "Informação", JOptionPane.INFORMATION_MESSAGE);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao exibir músicas descurtidas: " + e.getMessage(),
                                         "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    
   public void limpaMusica(){
       musica2.clear();
       icon_musica2.clear();
   }
   
    public void deletarPlaylist() {
     try {
         // Verifica se há uma playlist selecionada
         if (campoTexto.isEmpty()) {
             JOptionPane.showMessageDialog(null, "Selecione uma playlist primeiro!", 
                                           "Aviso", JOptionPane.INFORMATION_MESSAGE);
             return;
         }

         // Confirma a exclusão
         int resposta = JOptionPane.showConfirmDialog(null, 
                                                     "Tem certeza que deseja deletar a playlist '" + campoTexto + "'?", 
                                                     "Confirmar Exclusão", 
                                                     JOptionPane.YES_NO_OPTION,
                                                     JOptionPane.QUESTION_MESSAGE);

         if (resposta != JOptionPane.YES_OPTION) {
             return;
         }

         Connection conn = conexao.getConnection();
         PlaylistDAO dao_playlist = new PlaylistDAO(conn);

         // Primeiro, busca o ID da playlist
         ResultSet resultado = dao_playlist.consultarPlaylist2(id_usuario, campoTexto);

         if (!resultado.next()) {
             JOptionPane.showMessageDialog(null, "Playlist não encontrada!", 
                                          "Erro", JOptionPane.ERROR_MESSAGE);
             resultado.close();
             return;
         }

         int id_playlist = resultado.getInt("id_playlist");
         resultado.close();

         // Remove todas as músicas da playlist primeiro (devido à chave estrangeira)
         PreparedStatement deleteMusicasStmt = conn.prepareStatement(
             "DELETE FROM musica_playlist WHERE id_playlist = ?"
         );
         deleteMusicasStmt.setInt(1, id_playlist);
         deleteMusicasStmt.executeUpdate();
         deleteMusicasStmt.close();

         // Remove a playlist
         PreparedStatement deletePlaylistStmt = conn.prepareStatement(
             "DELETE FROM playlist WHERE id_playlist = ? AND id_usuario = ?"
         );
         deletePlaylistStmt.setInt(1, id_playlist);
         deletePlaylistStmt.setInt(2, id_usuario);

         int linhasAfetadas = deletePlaylistStmt.executeUpdate();
         deletePlaylistStmt.close();
         conn.close();

         if (linhasAfetadas > 0) {
             JOptionPane.showMessageDialog(null, "Playlist deletada com sucesso!", 
                                          "Sucesso", JOptionPane.INFORMATION_MESSAGE);

             // Limpa a seleção
             setCampoTexto("");

             // Atualiza a interface removendo a playlist da lista
             atualizarListaPlaylists();

         } else {
             JOptionPane.showMessageDialog(null, "Não foi possível deletar a playlist!", 
                                          "Erro", JOptionPane.ERROR_MESSAGE);
         }

     } catch (SQLException e) {
         JOptionPane.showMessageDialog(null, "Erro ao deletar playlist: " + e.getMessage(),
                                      "Erro", JOptionPane.ERROR_MESSAGE);
         e.printStackTrace();
     }
 }

 /**
  * Método para deletar uma música específica de uma playlist
  * Remove apenas a música selecionada (baseada no campoTexto2) da playlist atual (campoTexto)
  */
 
private void atualizarListaPlaylists() {
    try {
        ArrayList<Playlist> playlist = new ArrayList<>();
        Connection conn = conexao.getConnection();
        PlaylistDAO dao_playlist = new PlaylistDAO(conn);
        ResultSet resultado = dao_playlist.consultarPlaylist(id_usuario);
       
        // Limpa a lista atual
        while (resultado.next()) {
            String nome_Playlist = resultado.getString("nome_playlist"); 
            playlist.add(new Playlist(nome_Playlist));
        }
        resultado.close();
        
        // Atualiza a interface
        SwingUtilities.invokeLater(() -> {
            feed.getPainelPrincipal().removeAll();
            
            for (int i = 0; i < playlist.size(); i++) {
                final int index = i;
                
                JPanel panel = new JPanel(); 
                panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS)); 
                panel.setMaximumSize(new Dimension(400, 40));
                panel.setPreferredSize(new Dimension(400, 40));
                panel.setAlignmentX(JPanel.LEFT_ALIGNMENT);

                String nome_da_playlist = playlist.get(index).getNome_playlist();
                JButton botao = new JButton(nome_da_playlist);
                botao.setHorizontalTextPosition(SwingConstants.RIGHT);
                botao.setIconTextGap(10);
                botao.setHorizontalAlignment(SwingConstants.LEFT);  
                botao.setPreferredSize(new Dimension(400, 40));
                botao.setMaximumSize(new Dimension(400, 40));
                botao.setMinimumSize(new Dimension(400, 40));
                botao.setAlignmentX(JButton.LEFT_ALIGNMENT);
                
                panel.add(botao);
                
                // Adiciona os listeners do botão (você pode copiar os listeners existentes do método novaPlaylist)
                botao.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        if (SwingUtilities.isRightMouseButton(e)) {
                            String texto = ((JButton) e.getSource()).getText();
                            setCampoTexto(texto);
                        }
                    }
                });
                
                feed.getPainelPrincipal().add(panel);
            }
            
            feed.getPainelPrincipal().revalidate();
            feed.getPainelPrincipal().repaint();
        });
        
        conn.close();
        
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Erro ao atualizar lista de playlists: " + e.getMessage());
    }
}

/**
 * Método auxiliar para recarregar a playlist atual e mostrar as músicas atualizadas
 */
private void recarregarPlaylistAtual() {
    if (campoTexto.isEmpty()) {
        return;
    }
    
    try {
        // Limpar a lista antes de recarregar
        musica2.clear();
        icon_musica2.clear();
        Connection conn = conexao.getConnection();
        MusicaDAO dao = new MusicaDAO(conn);

        // Consultar músicas da playlist atual
        ResultSet resultado = dao.consultarMusicaPlaylist(campoTexto, id_usuario);
        while (resultado.next()) {
            int id = resultado.getInt("id");
            String musica = resultado.getString("musica");
            String artista = resultado.getString("artista");
            String album = resultado.getString("album");
            String genero = resultado.getString("genero");
            String caminho = resultado.getString("caminho_local");
            
            Musica musica3 = new Musica(id, musica, artista, album, genero);
            musica2.add(musica3);
            icon_musica1 = new IconMusica(caminho);
            icon_musica2.add(icon_musica1);
        }
        resultado.close();
        conn.close();

        // Atualizar a interface
        SwingUtilities.invokeLater(() -> {
            feed.getPainel_inicial().removeAll();
            
            for (int i = 0; i < musica2.size(); i++) {
                JPanel panel = new JPanel(); 
                panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS)); 
                panel.setMaximumSize(new Dimension(400, 40)); 
                panel.setPreferredSize(new Dimension(400, 40));
                panel.setAlignmentX(JPanel.LEFT_ALIGNMENT);

                // Carregar a imagem
                String icone_musica = icon_musica2.get(i).getIcon_caminho();
                String path = icone_musica;  
                ImageIcon ic = new ImageIcon(path);
                Image nw = ic.getImage().getScaledInstance(50, 40, Image.SCALE_AREA_AVERAGING);

                // Obter informações da música
                String nome = musica2.get(i).getMusica();
                String artista = musica2.get(i).getNome();

                // Criar botão com imagem e texto
                JButton botao = new JButton(artista + ": " + nome, new ImageIcon(nw));
                botao.setHorizontalTextPosition(SwingConstants.RIGHT);
                botao.setIconTextGap(10);
                botao.setHorizontalAlignment(SwingConstants.LEFT);  
                botao.setPreferredSize(new Dimension(400, 40));
                botao.setMaximumSize(new Dimension(400, 40));
                botao.setMinimumSize(new Dimension(400, 40));
                botao.setAlignmentX(JButton.LEFT_ALIGNMENT);
                
                botao.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        if (SwingUtilities.isRightMouseButton(e)) {
                            String texto = ((JButton) e.getSource()).getText();
                            setCampoTexto2(texto);
                        }
                    }
                });

                panel.add(botao);
                botoesMusica.add(botao);
                feed.getPainel_inicial().add(panel);
            }

            feed.getPainel_inicial().revalidate();
            feed.getPainel_inicial().repaint();
        });

    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Erro ao recarregar playlist: " + e.getMessage());
    }
}

 public void deletarMusicaDaPlaylist() {
     try {
         // Verifica se há uma playlist e uma música selecionadas
         if (campoTexto.isEmpty()) {
             JOptionPane.showMessageDialog(null, "Selecione uma playlist primeiro!", 
                                           "Aviso", JOptionPane.INFORMATION_MESSAGE);
             return;
         }

         if (campoTexto2.isEmpty()) {
             JOptionPane.showMessageDialog(null, "Selecione uma música primeiro!", 
                                           "Aviso", JOptionPane.INFORMATION_MESSAGE);
             return;
         }

         // Parseia o texto da música para obter o nome
         // Formato esperado: "Artista: Nome da música"
         String textoCompleto = campoTexto2;
         int indexSeparador = textoCompleto.indexOf(": ");
         if (indexSeparador == -1) {
             JOptionPane.showMessageDialog(null, "Formato de música inválido!", 
                                          "Erro", JOptionPane.ERROR_MESSAGE);
             return;
         }

         String artista = textoCompleto.substring(0, indexSeparador);
         String nomeMusica = textoCompleto.substring(indexSeparador + 2);

         // Confirma a exclusão
         int resposta = JOptionPane.showConfirmDialog(null, 
                                                     "Tem certeza que deseja remover '" + nomeMusica + "' da playlist '" + campoTexto + "'?", 
                                                     "Confirmar Remoção", 
                                                     JOptionPane.YES_NO_OPTION,
                                                     JOptionPane.QUESTION_MESSAGE);

         if (resposta != JOptionPane.YES_OPTION) {
             return;
         }

         Connection conn = conexao.getConnection();

         // Busca o ID da playlist
         PlaylistDAO dao_playlist = new PlaylistDAO(conn);
         ResultSet resultPlaylist = dao_playlist.consultarPlaylist2(id_usuario, campoTexto);

         if (!resultPlaylist.next()) {
             JOptionPane.showMessageDialog(null, "Playlist não encontrada!", 
                                          "Erro", JOptionPane.ERROR_MESSAGE);
             resultPlaylist.close();
             return;
         }

         int id_playlist = resultPlaylist.getInt("id_playlist");
         resultPlaylist.close();

         // Busca o ID da música
         MusicaDAO dao_musica = new MusicaDAO(conn);
         ResultSet resultMusica = dao_musica.consultarMusica3(nomeMusica);

         if (!resultMusica.next()) {
             JOptionPane.showMessageDialog(null, "Música não encontrada!", 
                                          "Erro", JOptionPane.ERROR_MESSAGE);
             resultMusica.close();
             return;
         }

         int id_musica = resultMusica.getInt("id");
         resultMusica.close();

         // Remove a música da playlist
         PreparedStatement deleteMusicaStmt = conn.prepareStatement(
             "DELETE FROM musica_playlist WHERE id_playlist = ? AND id_musica = ?"
         );
         deleteMusicaStmt.setInt(1, id_playlist);
         deleteMusicaStmt.setInt(2, id_musica);

         int linhasAfetadas = deleteMusicaStmt.executeUpdate();
         deleteMusicaStmt.close();
         conn.close();

         if (linhasAfetadas > 0) {
             JOptionPane.showMessageDialog(null, "Música removida da playlist com sucesso!", 
                                          "Sucesso", JOptionPane.INFORMATION_MESSAGE);

             // Limpa a seleção da música
             setCampoTexto2("");

             // Recarrega a playlist atual para mostrar a lista atualizada
             recarregarPlaylistAtual();

         } else {
             JOptionPane.showMessageDialog(null, "Não foi possível remover a música da playlist!\nVerifique se a música está realmente na playlist.", 
                                          "Erro", JOptionPane.ERROR_MESSAGE);
         }

     } catch (SQLException e) {
         JOptionPane.showMessageDialog(null, "Erro ao remover música da playlist: " + e.getMessage(),
                                      "Erro", JOptionPane.ERROR_MESSAGE);
         e.printStackTrace();
     }
 }
}
    
