# Projeto Gestão de Alunos

Este é um projeto de um sistema de Gestão de Alunos, desenvolvido em Java com o framework Spring Boot. A aplicação permite gerenciar informações de alunos e cursos.

## Tecnologias Utilizadas

- **Java 21**
- **Spring Boot**: Framework principal para a construção da aplicação.
- **Spring Web**: Para criar os controllers e endpoints REST.
- **Spring Data JPA**: Para a persistência de dados.
- **Thymeleaf**: Template engine para renderizar as páginas HTML no servidor.
- **Maven**: Gerenciador de dependências e build do projeto.
- **H2 Database**: Banco de dados em memória (padrão do Spring Boot para desenvolvimento).

## Estrutura do Projeto

O projeto segue a arquitetura Model-View-Controller (MVC) e está organizado da seguinte forma:

```
src/main/java/br/edu/fatecrl/p2_gestao_alunos/
├── controller/   # Controladores (MVC) que lidam com as requisições HTTP.
│   ├── AlunoController.java
│   └── CursoController.java
├── model/        # Entidades (Model) que representam os dados da aplicação.
│   ├── Aluno.java
│   └── Curso.java
└── repository/   # Repositórios (DAO) para interação com o banco de dados via JPA.
    ├── AlunoRepository.java
    └── CursoRepository.java
```

- `src/main/resources/templates`: Contém os arquivos HTML (views) renderizados pelo Thymeleaf.
  - `aluno/`: Páginas para CRUD de Alunos.
  - `curso/`: Páginas para CRUD de Cursos.
- `src/main/resources/static`: Arquivos estáticos como CSS e JavaScript.
- `pom.xml`: Arquivo de configuração do Maven, onde as dependências do projeto são declaradas.

## Como Executar

1. **Pré-requisitos**:

   - JDK 21 ou superior instalado.
   - Maven instalado (ou pode-se usar o Maven Wrapper incluído).

2. **Clone o repositório**:

   ```bash
   git clone <url-do-repositorio>
   ```

3. **Navegue até o diretório do projeto**:

   ```bash
   cd p2_gestao_alunos
   ```

4. **Execute a aplicação usando o Maven Wrapper**:

   - No Linux/macOS:
     ```bash
     ./mvnw spring-boot:run
     ```
   - No Windows:
     ```bash
     mvnw.cmd spring-boot:run
     ```

5. **Acesse a aplicação**:
   Abra seu navegador e acesse `http://localhost:8080`.
