# VM-Database-API

## Sobre

Esta aplicação foi desenvolvida com o objetivo de abstrair a lógica de conexão com bancos de dados e de fornecer uma camada de segurança para essa conexão. A aplicação expõe APIs que outras aplicações podem consumir para interagir com o banco de dados.

## Tecnologias Utilizadas

- **Linguagem**: Java
- **Framework**: Spring Boot
- **Bibliotecas**:
  - Spring Health
  - Spring Data
  - Spring Security JPA
- **Banco de Dados**: H2 (para fallback)
- **AOP**: AspectJ
- **Containerização**: Docker
- Entre outras bibliotecas...

## Funcionalidades

- Leitura de um arquivo de configuração para determinar os parâmetros da conexão com o banco de dados.
- Exposição de uma API RESTful para permitir que outras aplicações interajam com o banco de dados.
- Implementação de mecanismos de segurança para a conexão com o banco de dados.
