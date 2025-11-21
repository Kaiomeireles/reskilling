# Global Solution 2025 – O Futuro do Trabalho
## Plataforma de Upskilling / Reskilling para 2030+ (API REST)

### 📌 Descrição
Esta API RESTful permite o cadastro de usuários e gestão de trilhas de aprendizagem voltadas a competências do futuro do trabalho (2030+), apoiando processos de upskilling (aperfeiçoamento) e reskilling (requalificação).

### 🎯 Funcionalidades
- CRUD completo de **Usuários**
- CRUD completo de **Trilhas de Aprendizagem**
- Arquitetura em camadas (Controller → Service → Repository)
- Banco relacional H2 com migrações Flyway
- Seeds automáticos com dados iniciais
- Validações com Bean Validation via DTOs
- Tratamento centralizado de erros + exceções customizadas

### 🧰 Tecnologias
- Java 21
- Spring Boot 3.3.x
- Spring Web
- Spring Data JPA
- Bean Validation
- Flyway
- H2 Database
- Lombok

---

## 🚀 Como executar localmente

### 1) Pré-requisitos
- Java 21 instalado
- Maven instalado (ou usar o wrapper da IDE)

### 2) Clonar / abrir projeto
Abra a pasta do projeto na sua IDE (IntelliJ/Eclipse/VSCode).

### 3) Instalar dependências e rodar
No terminal dentro da pasta:

```bash
mvn clean install
mvn spring-boot:run
```

A API sobe em:
`http://localhost:8080`

### 4) Console do H2
Acesse:
`http://localhost:8080/h2-console`

Configurações:
- JDBC URL: `jdbc:h2:mem:futurotrabalho`
- User: `sa`
- Password: *(vazio)*

Flyway cria as tabelas e insere os seeds automaticamente ao iniciar.

---

## 📌 Endpoints

### ✅ Usuários

**POST /usuarios**
```json
{
  "nome": "Pedro Santos",
  "email": "pedro@email.com",
  "areaAtuacao": "Marketing",
  "nivelCarreira": "Pleno"
}
```

**GET /usuarios**

**GET /usuarios/{id}**

**PUT /usuarios/{id}**
```json
{
  "nome": "Pedro Santos Atualizado",
  "email": "pedro@email.com",
  "areaAtuacao": "Marketing e Dados",
  "nivelCarreira": "Senior"
}
```

**DELETE /usuarios/{id}**

---

### ✅ Trilhas

**POST /trilhas**
```json
{
  "nome": "IA aplicada ao trabalho",
  "descricao": "Trilha focada em fundamentos e aplicações práticas de IA.",
  "nivel": "INICIANTE",
  "cargaHoraria": 50,
  "focoPrincipal": "IA"
}
```

**GET /trilhas**

**GET /trilhas/{id}**

**PUT /trilhas/{id}**
```json
{
  "nome": "IA aplicada ao trabalho (avançado)",
  "descricao": "Trilha aprofundada em IA.",
  "nivel": "AVANCADO",
  "cargaHoraria": 80,
  "focoPrincipal": "IA"
}
```

**DELETE /trilhas/{id}**

---

## 🧪 Como testar rápido
Você pode usar Postman, Insomnia ou curl.

Exemplo curl:
```bash
curl -X GET http://localhost:8080/usuarios
curl -X GET http://localhost:8080/trilhas
```

---

## 📂 Organização do Repositório
- `src/main/java` → controllers, services, repositories, models, DTOs, exceptions
- `src/main/resources/db/migration` → scripts Flyway
- `README.md` na raiz
- `INTEGRANTES.txt` na raiz

---

## 📎 Conexão com O Futuro do Trabalho e ODS
A plataforma promove educação contínua, requalificação e aperfeiçoamento de competências alinhadas ao futuro do trabalho, com foco em ODS 4 (Educação de Qualidade), ODS 8 (Trabalho Decente), ODS 9 (Inovação) e ODS 10 (Redução das Desigualdades).
