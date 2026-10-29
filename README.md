# Web Wallet

Aplicação web de gestão financeira pessoal: o usuário registra receitas, despesas, categorias, metas e investimentos e analisa os dados. Não há integração bancária e nenhuma operação financeira real é executada.

Requisitos e indicadores: [docs/PROJECT.md](docs/PROJECT.md). Fases e tarefas: [docs/TASKS.md](docs/TASKS.md). Decisões de arquitetura: [docs/adr](docs/adr).

## Pré-requisitos

- JDK 21 ou superior (o projeto compila para Java 21)
- Node.js 20 ou superior
- Docker (para o PostgreSQL de desenvolvimento)

## Rodando localmente

1. Crie o arquivo de configuração e troque as senhas e o segredo do JWT:

   ```bash
   cp .env.example .env
   ```

2. Suba o banco:

   ```bash
   docker compose up -d
   ```

   Se a porta 5432 já estiver em uso, mude `POSTGRES_PORT` e o `DB_URL` no `.env`.

3. Rode o backend e o frontend. Veja [backend/README.md](backend/README.md) e [frontend/README.md](frontend/README.md).

O `.env` nunca é commitado. Toda configuração e todo segredo vêm de variáveis de ambiente.
