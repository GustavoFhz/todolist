# 📌 ToDo List API - Java Spring Boot

Uma API REST para gerenciamento de tarefas utilizando Spring Boot, JPA e MySQL.

## 🚀 Tecnologias
- Java 17
- Spring Boot
- JPA / Hibernate
- MySQL
- Maven

## 🔧 Configuração do Projeto

### 1️⃣ Clonar o Repositório
```sh
git clone https://github.com/GustavoFhz/todolist.git
cd todolist
```

### 2️⃣ Configurar o Banco de Dados
Certifique-se de que o MySQL está rodando e crie o banco de dados:
```sql
CREATE DATABASE todos;
```
Edite o arquivo `application.properties` com as credenciais do banco:
```
spring.datasource.url=jdbc:mysql://localhost:3306/todos
spring.datasource.username=root
spring.datasource.password=sua_senha
```

### 3️⃣ Executar a Aplicação
```sh
mvn spring-boot:run
```

## 📌 Endpoints da API

### 🔹 Criar uma Tarefa
```http
POST /api
Content-Type: application/json
{
  "nome": "Fazer compras",
  "descricao": "Comprar leite e pão",
  "realizado": false,
  "prioridade": 2
}
```

### 🔹 Listar Todas as Tarefas
```http
GET /api
```

### 🔹 Buscar Tarefa por ID
```http
GET /api/{id}
```

### 🔹 Editar uma Tarefa
```http
PUT /api
Content-Type: application/json
{
  "id": 1,
  "nome": "Fazer compras",
  "descricao": "Comprar leite, pão e ovos",
  "realizado": false,
  "prioridade": 3
}
```

### 🔹 Atualizar Status da Tarefa
```http
PATCH /api/{id}/status?realizado=true
```

### 🔹 Remover uma Tarefa
```http
DELETE /api/{id}
```

