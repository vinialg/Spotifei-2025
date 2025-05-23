# Spotifei-2025
Projeto da Disciplina CCM310 - ARQUITETURA DE SOFTWARE E PROGRAMAÇÃO ORIENTADA A OBJETOS

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


---

## 6. Licença 📄

Este projeto é de **uso livre para fins acadêmicos e educacionais**.  
Sinta-se à vontade para estudar, modificar e evoluir!

---
