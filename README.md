
# 🎵 Projeto Java: Spotifei – Gerenciador de Músicas e Playlists

## 1. Objetivo 🎯

O projeto **Spotifei** simula uma plataforma de gerenciamento musical, permitindo que usuários interajam com um sistema de cadastro, login, criação de playlists e adição de músicas.

A aplicação foi desenvolvida em **Java com interface gráfica Swing**, utilizando o **NetBeans GUI Builder** (`.form`), oferecendo uma experiência visual completa e intuitiva ao usuário.

### Funcionalidades principais:

- Interface gráfica com múltiplos JFrames (Swing);
- Cadastro e autenticação de usuários;
- Criação e gerenciamento de playlists;
- Cadastro, listagem e associação de músicas;
- Feed interativo com conteúdos personalizados;
- Persistência de dados com DAOs estruturados.

---

## 2. Forma de Compilação 👨‍💻

### Pré-requisitos:

- JDK instalado (Java Development Kit);
- IDE recomendada: **NetBeans** (por compatibilidade com arquivos `.form`);
- Sistema operacional com suporte à interface gráfica.

### Passos para executar:

1. **Abra o projeto no NetBeans**.
2. Certifique-se de que o `main` está na classe `Inicio.java`.
3. Clique em **Run** ou use o atalho `Shift + F6`.

> Também é possível compilar via terminal:
```bash
javac *.java
java Inicio
```

---

## 3. Funcionamento 🧩

### Interface Gráfica (JFrames - Swing)

- `Inicio.java` + `Inicio.form`: Tela inicial da aplicação, direciona para login ou cadastro.
- `Login.java` + `Login.form`: Tela de login com validação.
- `Cadastrar.java` + `Cadastrar.form`: Tela de cadastro de novos usuários.
- `Feed.java` + `Feed.form`: Tela principal do usuário com funcionalidades de visualização e interação musical.
- `Test2.java` + `Test2.form`: Protótipo/teste de interface (caso experimental).

---

### Camada de Controle

- `ControllerCadastro.java`: Gerencia a lógica de cadastro.
- `ControllerLogin.java`: Valida e autentica credenciais.
- `ControllerFeed.java`: Atualiza e apresenta o conteúdo do feed do usuário.

---

### Persistência e Acesso a Dados (DAO)

- `UsuarioDAO.java`: CRUD de usuários.
- `MusicaDAO.java`: Cadastro e listagem de músicas.
- `PlaylistDAO.java`: Criação, exclusão e gerenciamento de playlists.

---

### Modelo de Dados (Entidades)

- `Pessoa.java`: Classe base de usuários.
- `Usuario.java`: Usuário do sistema.
- `Musica.java`: Informações das músicas cadastradas.
- `Playlist.java`: Coleções de músicas criadas por usuários.
- `Artista.java`: Informações sobre artistas.
- `IconMusica.java`: Dados visuais associados à música.
- `Autenticacao.java`: Segurança e controle de acesso.

---

## 4. Estrutura do Projeto 🗂️

```
📁 src/
├── view/
│   ├── Inicio.java + Inicio.form
│   ├── Login.java + Login.form
│   ├── Cadastrar.java + Cadastrar.form
│   ├── Feed.java + Feed.form
│   └── Test2.java + Test2.form
├── controller/
│   ├── ControllerCadastro.java
│   ├── ControllerLogin.java
│   └── ControllerFeed.java
├── dao/
│   ├── UsuarioDAO.java
│   ├── PlaylistDAO.java
│   └── MusicaDAO.java
├── model/
│   ├── Pessoa.java
│   ├── Usuario.java
│   ├── Musica.java
│   ├── Playlist.java
│   ├── Artista.java
│   ├── IconMusica.java
│   └── Autenticacao.java
├── Conexao.java
```

---

## 5. Considerações Finais ✅

O Spotifei é um projeto completo, didático e modular que explora:

- Programação orientada a objetos;
- Integração com banco de dados;
- Interfaces visuais com Swing e NetBeans GUI Builder;
- Arquitetura em camadas: UI, Controller, DAO e Model.

### Possíveis melhorias futuras:

- Integração com banco de dados real (MySQL, PostgreSQL);
- Persistência em arquivos ou SQLite;
- Interface mais moderna com JavaFX;
- Criptografia de senhas e autenticação segura.

---

## 6. Licença 📄

Este projeto é de **uso livre para fins acadêmicos e educacionais**.  
Sinta-se à vontade para estudar, modificar e evoluir!

---

---

## 🧠 Explicação das Funções nos Arquivos Java

### 📄 Artista.java
- `Artista(String nome, String album)`: Construtor que define nome e álbum de um artista.
- `getAlbum()`: Retorna o nome do álbum.

### 📄 Usuario.java
- `Usuario(String nome, String usuario, String senha)`: Construtor da classe.
- `getUsuario()`, `getSenha()`: Retornam o nome de usuário e senha.
- `setId_usuario(String id_usuario)`: Define o ID do usuário.
- `toString()`: Retorna uma representação textual do usuário.
- `validarCredenciais()`: Verifica se o nome e senha correspondem aos dados válidos.
- `isAutenticado()`, `setAutenticado(boolean autenticado)`: Controlam o status de autenticação.

### 📄 Login.java (JFrame)
- `Login()`: Construtor da janela de login.
- `initComponents()`: Inicializa os componentes gráficos.
- `actionPerformed(ActionEvent evt)`, `keyPressed(KeyEvent evt)`: Lidam com eventos do teclado e botões.
- `txt_usuario_loginActionPerformed(KeyEvent evt)`, `txt_usuario_loginKeyPressed(KeyEvent evt)`: Reagem às ações no campo de texto.
- `btnConfirmarActionPerformed(ActionEvent evt)`: Executa a ação ao clicar no botão de confirmação.

### 📄 Feed.java, Inicio.java, Cadastrar.java (JFrames)
- Cada classe define uma interface gráfica diferente.
- Métodos `initComponents()` criam e organizam os componentes visuais.
- Métodos de eventos (`ActionPerformed`, etc.) capturam interações do usuário.

### 📄 Musica.java
- Define atributos de uma música: nome, artista, etc.
- Métodos getter/setter para manipulação.

### 📄 Playlist.java
- Armazena e gerencia listas de músicas.
- Permite adicionar, remover e listar faixas.

### 📄 Pessoa.java
- Classe genérica para abstração de usuários ou administradores.

### 📄 Autenticacao.java
- Lógica de verificação de login/autenticação.

### 📄 DAO (MusicaDAO, PlaylistDAO, UsuarioDAO)
- Realizam operações de persistência (salvar, carregar, excluir dados) com arquivos.
- Métodos comuns: `inserir`, `listar`, `buscarPorId`, `remover`.

### 📄 Controller (Cadastro, Login, Feed)
- Controlam as interações entre JFrames e DAO.
- Validam ações do usuário e acionam o DAO correspondente.

### 📄 Conexao.java
- Estabelece conexão com fontes de dados, arquivos ou banco de dados simulado.

---

---

## 🎮 ControllerFeed.java – Controlador do Feed

A classe `ControllerFeed` atua como intermediária entre a interface gráfica `Feed` (View) e as classes DAO que acessam os dados de músicas, playlists e usuários. Ela segue o padrão MVC (Model-View-Controller).

### 📌 Responsabilidades principais:

#### 🔄 `ControllerFeed(Feed telaFeed)`
- Construtor que recebe a tela de `Feed` e inicializa os dados visuais.
- Chama os métodos para carregar músicas, playlists e usuários.

#### 🎵 `carregarMusicas()`
- Acessa `MusicaDAO` para recuperar todas as músicas cadastradas.
- Atualiza a interface `telaFeed` com os nomes das músicas na lista visual.

#### 🎧 `carregarPlaylists()`
- Usa `PlaylistDAO` para obter todas as playlists do sistema.
- Insere os nomes das playlists em um componente gráfico da tela de feed.

#### 👥 `carregarUsuarios()`
- Acessa `UsuarioDAO` para listar os usuários do sistema.
- Mostra essas informações no componente visual apropriado da interface.

### 🧠 Observações:
- Segrega a lógica de apresentação, facilitando a manutenção.
- Segue o padrão MVC ao separar controle de dados e exibição visual.
- Melhora a escalabilidade e reutilização do código.

---

---

## 🎮 ControllerFeed.java – Controlador do Feed (Principal Classe Controladora)

`ControllerFeed.java` é uma classe Java que atua como controlador para a interface de feed de um aplicativo de música. Ela gerencia as interações do usuário com a view `Feed`, como busca de músicas, gerenciamento de playlists, curtidas/descurtidas de músicas e exibição de informações relacionadas. A classe interage com um banco de dados por meio de Objetos de Acesso a Dados (DAOs) para realizar operações CRUD e atualiza a interface do usuário (UI) utilizando componentes Swing.

A seguir, uma explicação de cada método da classe, detalhando seu propósito e funcionalidade.

## Métodos

### 1. `ControllerFeed()`
- **Propósito**: Construtor padrão que inicializa um ouvinte de ação para o botão "Últimas 10 Músicas" na view `Feed`.
- **Funcionalidade**:
  - Associa um `ActionListener` ao botão `Dez_ultimas` na view `Feed`.
  - Quando o botão é clicado, aciona o método `exibirDezUltimasMusicasBuscadas` para exibir as últimas 10 músicas buscadas pelo usuário.
- **Observações**:
  - Assume que o objeto `feed` já está instanciado.
  - Usado para configurar o tratamento inicial de eventos na interface do feed.

---

### 2. `ControllerFeed(Feed feed)`
- **Propósito**: Construtor que inicializa o controlador com uma referência à view `Feed`.
- **Funcionalidade**:
 Eocene - Atribui o objeto `Feed` fornecido à variável de instância `feed`.
  - Permite que o controlador interaja com os componentes da view `Feed`.
- **Observações**:
  - Essencial para vincular o controlador à interface do usuário, permitindo a manipulação de elementos da UI.

---

### 3. `buscarMusica()`
- **Propósito**: Busca músicas com base na entrada do usuário no campo de pesquisa e exibe os resultados na UI.
- **Funcionalidade**:
  - Obtém a consulta de pesquisa do campo de texto `BuscaTexto` da view `Feed`.
  - Limpa as listas de músicas e ícones (`musica2` e `icon_musica2`).
  - Consulta o banco de dados usando `MusicaDAO` para encontrar músicas correspondentes à consulta.
  - Cria objetos `Musica` e `IconMusica` para cada resultado e os armazena nas listas.
  - Registra a busca no banco de dados para o usuário logado (`id_usuario`).
  - Atualiza dinamicamente o painel `painel_inicial` na UI para exibir os resultados da busca como botões com nomes de músicas, artistas e ícones.
  - Cada botão suporta:
    - **Clique com botão direito**: Copia o texto da música (artista: nome da música) para `campoTexto2`.
    - **Clique com botão esquerdo**: Adiciona a música a uma playlist selecionada (se `campoTexto` contiver um nome de playlist).
- **Observações**:
  - Usa `SwingUtilities.invokeLater` para garantir atualizações seguras na UI.
  - Oculta outros botões da UI (`Dez_ultimas`, `Musicas_curtidas`, `Musicas_descurtidas`, `Nova_playlist`) durante a exibição dos resultados.
  - Trata exceções SQL exibindo erros no console.

---

### 4. `novaPlaylist()`
- **Propósito**: Cria uma nova playlist e exibe as playlists existentes do usuário na UI.
- **Funcionalidade**:
  - Abre uma nova janela `JFrame` intitulada "Playlists" com um botão para iniciar a criação de uma playlist.
  - Ao clicar no botão "Nova Playlist", exibe um campo de texto e um botão "Criar Playlist".
  - Ao inserir um nome de playlist e clicar em "Criar Playlist", o nome é salvo no banco de dados via `PlaylistDAO`.
  - Obtém o ID do usuário logado (`id_usuario`) consultando o banco de dados com o nome de usuário da view `Feed`.
  - Recupera todas as playlists do usuário e as exibe como botões no painel `painelPrincipal`.
  - Cada botão de playlist suporta:
    - **Clique com botão direito**: Copia o nome da playlist para `campoTexto`.
    - **Clique com botão esquerdo**: Exibe as músicas da playlist selecionada consultando o banco de dados e atualizando o painel `painel_inicial`.
- **Observações**:
  - Usa uma thread separada e `SwingUtilities.invokeLater` para atualizações na UI, evitando bloqueios.
  - Trata exceções SQL com mensagens de erro exibidas via `JOptionPane`.
  - Atualiza a UI dinamicamente para refletir a lista atual de playlists e suas músicas.

---

### 5. `exibirDezUltimasMusicasBuscadas()`
- **Propósito**: Exibe as últimas 10 músicas buscadas pelo usuário.
- **Funcionalidade**:
  - Limpa as listas `musica2` e `icon_musica2`.
  - Oculta outros botões da UI (`Musicas_curtidas`, `Musicas_descurtidas`, `Nova_playlist`).
  - Consulta o banco de dados usando `MusicaDAO` para recuperar as últimas 10 músicas buscadas pelo usuário.
  - Preenche as listas `musica2` e `icon_musica2` com objetos `Musica` e `IconMusica`.
  - Atualiza o painel `painel_inicial` para exibir as músicas como botões com nomes, artistas e ícones.
  - Cada botão suporta:
    - **Clique com botão direito**: Copia o texto da música para `campoTexto2`.
    - **Clique com botão esquerdo**: Adiciona a música a uma playlist selecionada (se `campoTexto` estiver definido).
  - Exibe uma mensagem se não houver histórico de buscas.
- **Observações**:
  - Garante o gerenciamento adequado de recursos fechando o `ResultSet`.
  - Trata exceções SQL com mensagens de erro via `JOptionPane`.

---

### 6. `curtir()`
- **Propósito**: Permite que o usuário "curta" uma música selecionada, adicionando-a à lista de músicas curtidas.
- **Funcionalidade**:
  - Verifica se uma música está selecionada (`campoTexto2` não está vazio).
  - Analisa o texto da música (formato: "Artista: Nome da música") para extrair o nome da música.
  - Consulta o banco de dados para obter o ID da música usando `MusicaDAO`.
  - Verifica se a música já foi curtida pelo usuário; em caso afirmativo, exibe uma mensagem e sai.
  - Remove a música da lista de descurtidas (se presente) para evitar conflitos.
  - Insere a música na tabela `musicas_curtidas` com o ID do usuário e um carimbo de data/hora.
  - Exibe uma mensagem de sucesso ou erro com base no resultado da operação.
- **Observações**:
  - Fecha adequadamente os recursos do banco de dados (`ResultSet`, `PreparedStatement`, `Connection`).
  - Trata exceções SQL com mensagens de erro via `JOptionPane`.

---

### 7. `descurtir()`
- **Propósito**: Permite que o usuário "descurta" uma música selecionada, adicionando-a à lista de músicas descurtidas.
- **Funcionalidade**:
  - Verifica se uma música está selecionada (`campoTexto2` não está vazio).
  - Analisa o texto da música para extrair o nome da música.
  - Consulta o banco de dados para obter o ID da música usando `MusicaDAO`.
  - Verifica se a música já foi descurtida; em caso afirmativo, exibe uma mensagem e sai.
  - Remove a música da lista de curtidas (se presente) para evitar conflitos.
  - Insere a música na tabela `musicas_descurtidas` com o ID do usuário e um carimbo de data/hora.
  - Exibe uma mensagem de sucesso ou erro com base no resultado da operação.
- **Observações**:
  - Garante o fechamento adequado do `ResultSet`.
  - Trata exceções SQL com mensagens de erro via `JOptionPane`.

---

### 8. `exibirMusicasCurtidas()`
- **Propósito**: Exibe as músicas curtidas pelo usuário na UI.
- **Funcionalidade**:
  - Limpa as listas `musica2` e `icon_musica2`.
  - Oculta outros botões da UI (`Dez_ultimas`, `Musicas_descurtidas`, `Nova_playlist`).
  - Consulta o banco de dados usando `MusicaDAO` para recuperar todas as músicas curtidas pelo usuário.
  - Preenche as listas `musica2` e `icon_musica2` com objetos `Musica` e `IconMusica`.
  - Atualiza o painel `painel_inicial` para exibir as músicas curtidas como botões com nomes, artistas e ícones.
  - Cada botão suporta um clique com o botão esquerdo para copiar o texto da música para `campoTexto2`.
  - Exibe uma mensagem se não houver músicas curtidas.
- **Observações**:
  - Fecha o `ResultSet` para evitar vazamentos de recursos.
  - Trata exceções SQL com mensagens de erro via `JOptionPane`.

---

### 9. `exibirMusicasDescurtidas()`
- **Propósito**: Exibe as músicas descurtidas pelo usuário na UI.
- **Funcionalidade**:
  - Limpa as listas `musica2` e `icon_musica2`.
  - Oculta outros botões da UI (`Dez_ultimas`, `Musicas_curtidas`, `Nova_playlist`).
  - Consulta o banco de dados usando `MusicaDAO` para recuperar todas as músicas descurtidas pelo usuário.
  - Preenche as listas `musica2` e `icon_musica2` com objetos `Musica` e `IconMusica`.
  - Atualiza o painel `painel_inicial` para exibir as músicas descurtidas como botões com nomes, artistas e ícones.
  - Cada botão suporta um clique com o botão esquerdo para copiar o texto da música para `campoTexto2`.
  - Exibe uma mensagem se não houver músicas descurtidas.
- **Observações**:
  - Fecha adequadamente o `ResultSet`.
  - Trata exceções SQL com mensagens de erro via `JOptionPane`.

---

### 10. `limpaMusica()`
- **Propósito**: Limpa as listas de músicas e seus ícones.
- **Funcionalidade**:
  - Limpa os `ArrayLists` `musica2` e `icon_musica2`, redefinindo-os para estados vazios.
- **Observações**:
  - Usado para reiniciar o estado antes de realizar novas buscas ou exibir novas listas.

---

### 11. `deletarPlaylist()`
- **Propósito**: Exclui uma playlist selecionada do banco de dados e atualiza a UI.
- **Funcionalidade**:
  - Verifica se uma playlist está selecionada (`campoTexto` não está vazio).
  - Solicita confirmação do usuário para a exclusão.
  - Consulta o banco de dados para obter o ID da playlist usando `PlaylistDAO`.
  - Exclui todas as músicas associadas à playlist da tabela `musica_playlist`.
  - Exclui a playlist da tabela `playlist`.
  - Limpa a variável `campoTexto` e atualiza a lista de playlists na UI chamando `atualizarListaPlaylists`.
  - Exibe uma mensagem de sucesso ou erro com base no resultado da operação.
- **Observações**:
  - Garante o tratamento de restrições de chave estrangeira excluindo as músicas primeiro.
  - Fecha adequadamente os recursos do banco de dados.
  - Trata exceções SQL com mensagens de erro via `JOptionPane`.

---

### 12. `atualizarListaPlaylists()`
- **Propósito**: Atualiza a UI para exibir as playlists atuais do usuário.
- **Funcionalidade**:
  - Consulta o banco de dados usando `PlaylistDAO` para recuperar todas as playlists do usuário.
  - Preenche um `ArrayList<Playlist>` com os nomes das playlists.
  - Limpa e atualiza o painel `painelPrincipal` para exibir botões de playlists.
  - Cada botão suporta um clique com o botão direito para copiar o nome da playlist para `campoTexto`.
  - Atualiza a UI usando `SwingUtilities.invokeLater` para garantir segurança de thread.
- **Observações**:
  - Chamado após a exclusão de uma playlist para atualizar a UI.
  - Trata exceções SQL com saída no console.

---

### 13. `recarregarPlaylistAtual()`
- **Propósito**: Recarrega e exibe as músicas da playlist atualmente selecionada.
- **Funcionalidade**:
  - Verifica se uma playlist está selecionada (`campoTexto` não está vazio).
  - Limpa as listas `musica2` e `icon_musica2`.
  - Consulta o banco de dados usando `MusicaDAO` para recuperar as músicas da playlist selecionada.
  - Preenche as listas `musica2` e `icon_musica2` com objetos `Musica` e `IconMusica`.
  - Atualiza o painel `painel_inicial` para exibir as músicas como botões com nomes, artistas e ícones.
  - Cada botão suporta um clique com o botão direito para copiar o texto da música para `campoTexto2`.
- **Observações**:
  - Usado para atualizar a visualização da playlist após modificações (por exemplo, adição ou remoção de músicas).
  - Trata exceções SQL com saída no console.

---

### 14. `deletarMusicaDaPlaylist()`
- **Propósito**: Remove uma música específica da playlist atualmente selecionada.
- **Funcionalidade**:
  - Verifica se uma playlist (`campoTexto`) e uma música (`campoTexto2`) estão selecionadas.
  - Analisa o texto da música para extrair o nome da música.
  - Solicita confirmação do usuário para a remoção.
  - Consulta o banco de dados para obter o ID da playlist usando `PlaylistDAO` e o ID da música usando `MusicaDAO`.
  - Exclui a música da tabela `musica_playlist`.
  - Limpa a variável `campoTexto2` e recarrega a playlist chamando `recarregarPlaylistAtual`.
  - Exibe uma mensagem de sucesso ou erro com base no resultado da operação.
- **Observações**:
  - Garante validação adequada das seleções e restrições do banco de dados.
  - Fecha adequadamente os recursos do banco de dados.
  - Trata exceções SQL com mensagens de erro via `JOptionPane`.

---

## Observações Adicionais
- **Manipulação da UI**: A classe usa componentes Swing (`JButton`, `JPanel`, `JFrame`, etc.) para criar uma interface dinâmica, com layouts gerenciados usando `BoxLayout` para arranjos verticais e horizontais.
- **Interação com Banco de Dados**: Depende de `Conexao`, `MusicaDAO`, `PlaylistDAO` e `UsuarioDAO` para operações no banco de dados, garantindo gerenciamento adequado de conexões e tratamento de erros.
- **Segurança de Threads**: Usa `SwingUtilities.invokeLater` e threads separadas para evitar travamentos na UI durante operações no banco de dados ou atualizações da interface.
- **Tratamento de Erros**: Usa consistentemente `JOptionPane` para exibir mensagens de erro amigáveis ao usuário e registra erros detalhados no console para depuração.
- **Dependências**: Requer os pacotes `model` (`Musica`, `IconMusica`, `Playlist`, `Usuario`), `view` (`Feed`, `Login`) e `DAO` (`MusicaDAO`, `PlaylistDAO`, `UsuarioDAO`, `Conexao`).

Esta classe é central para a funcionalidade do aplicativo de música, fornecendo uma interface robusta para gerenciar buscas de músicas, playlists e preferências do usuário.
