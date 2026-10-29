# Web Wallet <img width="1" height="1" alt="image" src="https://github.com/user-attachments/assets/f87ec28f-edc1-4481-a8c1-2c40ba3f009b" />

Esse projeto tem o foco no meu aprendizado de novas tecnologias, entre elas: Java, Spring Boot, TypeScript e PostgreSQL. Além de outras ferramentas para organização durante o processo de desenvolvimento, como o Jira, Figma e Draw.io para modelagem do banco de dados.

## Esboço criado no Figma para melhor visualização do projeto:

<img width="939" height="856" alt="image" src="https://github.com/user-attachments/assets/a507cbca-aa19-483b-9248-f6c94a08b3f9" />

## Rodando o backend

O `application.properties` lê tudo de variáveis de ambiente, listadas em [application-example.properties](src/main/resources/application-example.properties) e no `.env.example` da raiz:

| Variável | Descrição |
|---|---|
| `DB_URL` | URL JDBC do PostgreSQL |
| `DB_USERNAME` / `DB_PASSWORD` | credenciais do banco |
| `JWT_SECRET` | segredo usado para assinar o token |

Com o banco no ar (`docker compose up -d`, na raiz), carregue o `.env` e execute a partir de `backend/`:

```bash
set -a; . ../.env; set +a
./mvnw spring-boot:run
./mvnw verify
```

No PowerShell, defina as variáveis com `$env:DB_URL = "..."` antes de rodar. Na IDE, configure as mesmas variáveis na configuração de execução.

O Flyway aplica as migrations de `src/main/resources/db/migration` ao subir.
