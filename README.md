# 📦 Produtos API

<div align="center">

![Java](https://img.shields.io/badge/Java-17+-orange?style=for-the-badge&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.0+-brightgreen?style=for-the-badge&logo=springboot)
![Maven](https://img.shields.io/badge/Maven-3.8+-blue?style=for-the-badge&logo=apachemaven)
![H2 Database](https://img.shields.io/badge/H2-in--memory%20DB-lightgrey?style=for-the-badge&logo=h2)
![Status](https://img.shields.io/badge/Status-Em%20Desenvolvimento-yellow?style=for-the-badge)

</div>

---

Uma API RESTful desenvolvida com **Java + Spring Boot** para gerenciamento de produtos.  
Permite operações de **CRUD completo**, com integração a banco de dados em memória (**H2**).  
Ideal para testes rápidos e simulações via ferramentas como **Insomnia** ou **Postman**.

---

## ⚙️ Tecnologias Utilizadas

- ✅ Java 17+
- ✅ Spring Boot
- ✅ Spring Data JPA
- ✅ H2 Database (em memória)
- ✅ Maven
- ✅ Insomnia (para testes de requisições)

---

## 🔁 Fluxo da API – Topologia

![Fluxo da Aplicação](https://github.com/user-attachments/assets/15f75861-aa9a-4913-8dfa-8294597cd828)

### 🧭 Explicação do fluxo:

1. **Cliente** envia uma requisição HTTP (via Insomnia, por exemplo)  
2. **Controller** recebe a requisição e direciona para a camada adequada  
3. **Service** processa a lógica de negócio (como calcular `valorTotal`)  
4. **Repository** realiza as operações de persistência com o H2  
5. **H2 Database** armazena os dados em tempo de execução (memória)

---

## 📮 Endpoints da API

| Método | Endpoint                  | Descrição                        |
|--------|---------------------------|----------------------------------|
| GET    | `/produtos`               | Retorna todos os produtos        |
| GET    | `/produtos/{id}`          | Retorna produto por ID           |
| POST   | `/produtos/create`        | Cria um novo produto             |
| PUT    | `/produtos/update/{id}`   | Atualiza um produto existente    |
| DELETE | `/produtos/delete/{id}`   | Deleta um produto por ID         |

---

## 📺 Demonstração da Aplicação

Veja o funcionamento da aplicação no vídeo abaixo:

👉 [Assista ao vídeo de demonstração](https://www.linkedin.com/in/vitor-honorato-3542861ba/)

---

## 🚀 Como Rodar o Projeto

### 📁 1. Clone o repositório

```bash
git clone https://github.com/vittorhonorato/Register-Products.git
cd produtosapi
```

## 🧰 2. Configure o ambiente

Este projeto utiliza o **Maven** para gerenciamento de dependências e o **Spring Boot** para execução.  
Certifique-se de ter o **Java 17 ou superior** e o **Maven** instalados na sua máquina.

### 🔗 Pré-requisitos:

- [Baixar Java 17+](https://adoptopenjdk.net/)
- [Baixar Maven 3.8+](https://maven.apache.org/download.cgi)

Verifique se estão instalados corretamente com os comandos abaixo:

```bash
java -version
mvn -version
```

## ▶️ 3. Execute o projeto com Maven

No terminal, execute o seguinte comando para iniciar a aplicação:

```bash
./mvnw spring-boot:run
```
- Windows: use mvnw ou mvnw.cmd
- Linux/Mac: use ./mvnw

 ## 🌐 4. Acesse a aplicação

Após iniciar o projeto com sucesso, a aplicação estará disponível nos seguintes endereços:

- **API REST**: [http://localhost:8080/produtos](http://localhost:8080/produtos)
- **Console H2**: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

### 🔑 Credenciais do Banco H2

- **JDBC URL**: `jdbc:h2:mem:meubanco`
- **Usuário**: `produtos`
- **Senha**: `password`

 ## 🧪 5. Teste os Endpoints da API

Você pode utilizar **Insomnia** ou **Postman** para testar os endpoints da API:

```http
GET     /produtos             → Lista todos os produtos  
GET     /produtos/{id}        → Retorna um produto específico  
POST    /produtos/create      → Cria um novo produto  
PUT     /produtos/update/{id} → Atualiza um produto existente  
DELETE  /produtos/delete/{id} → Remove um produto pelo ID  
```



