# Tarefas

Acompanhamento das fases do plano de refatoração. Requisitos e definições estão em [PROJECT.md](PROJECT.md).

Uma fase só começa com aprovação do dono do projeto. Ao concluir uma tarefa, marque `[x]` e anote o PR.

Status: ⬜ não iniciada · 🔄 em andamento · ✅ concluída

## Concluído

- [x] Diagnóstico do repositório (28/10/2026)
- [x] `.claude/CLAUDE.md` com as regras para agentes de IA
- [x] Organização do repositório: `.gitignore`, remoção dos arquivos da extensão de modernização, PROJECT.md e TASKS.md

## Decisões pendentes

- [ ] Java 21 ou 25 (sugestão: 21). Necessária na Fase 0.
- [ ] O que fazer com os 5 commits da `feature/integracao-api-tela-config-user` que não estão na `main` (endpoint `/me`, formatação de datas, service de carteira): abrir PR ou descartar. Necessária antes da Fase 4.
- [ ] Saldo calculado ou guardado (sugestão: calculado). Necessária na Fase 3.
- [ ] Metas e limites: unificar `special_categories.limit` com `budgets` e separar metas numa entidade própria? Necessária na Fase 7.

## ⬜ Fase 0: build e ambiente

- [ ] `pom.xml`: `modelVersion 4.0.0` e versão do springdoc
- [ ] Wrapper com Maven 3.9.x estável
- [ ] Flyway com versão gerenciada pelo Boot + `flyway-database-postgresql`
- [ ] `docker-compose` com PostgreSQL para desenvolvimento
- [ ] Configuração por variáveis de ambiente + `application-example`
- [ ] Frontend: `VITE_API_URL` + `.env.example`
- [ ] READMEs (raiz, backend, frontend) com o passo a passo para rodar localmente

**Aceite:** `./mvnw verify` e `npm ci && npm run build` passam numa máquina limpa com Docker; `docker compose up` sobe o banco; nenhum segredo fica no código.

## ⬜ Fase 1: estrutura de testes

- [ ] JUnit + MockMvc + Testcontainers (PostgreSQL) e perfil de teste
- [ ] Vitest + Testing Library no frontend
- [ ] Testes de caracterização que reproduzem as falhas de isolamento, a tomada de conta e a listagem de usuários

**Aceite:** `./mvnw test` roda contra PostgreSQL via Testcontainers, e esses testes falham antes da correção.

## ⬜ Fase 2: segurança e isolamento

- [ ] Usuário sempre vindo do token; fim do `userId` em URLs e corpos
- [ ] Queries por dono (`findByIdAndUser…`), retornando 404 para recurso de outro usuário
- [ ] Remover `GET /api/user`; perfil editável só via `/me`
- [ ] Tratamento global de erros com `ProblemDetail` (400, 401, 404, 409) e entry point de 401
- [ ] Validações: e-mail, tamanho mínimo de senha, tipo e valor da transação
- [ ] Expiração do token com `Instant`; segredo obrigatório e com tamanho mínimo

**Aceite:** os testes da Fase 1 passam; recurso de outro usuário retorna 404 em todos os endpoints; sem token retorna 401; validação retorna 400 com os campos; e-mail duplicado retorna 409.

## ⬜ Fase 3: integridade do modelo

- [ ] `ddl-auto=validate`; entidades alinhadas ao schema
- [ ] Data da transação informada pelo usuário
- [ ] Categoria como FK, com migration que aproveita os textos existentes
- [ ] Estratégia de saldo (conforme a decisão pendente)
- [ ] Editar e excluir transações
- [ ] Corrigir timestamps (`@CurrentTimestamp`) e defaults
- [ ] Renomear para inglês os nomes persistidos (enums, `senha_hash`), mediante aprovação

**Aceite:** a aplicação sobe com `validate`; o saldo exibido bate com o cálculo direto em SQL (coberto por teste); editar ou excluir mantém o saldo consistente; as migrations rodam sobre uma base com dados.

## ⬜ Fase 4: base do frontend

- [ ] Contexto de autenticação, guarda de rotas, logout real, interceptor de 401
- [ ] Imagens via `import` e nomes de arquivo consistentes
- [ ] Correção da exibição de datas (`LocalDate`)
- [ ] Componentes de carregando, vazio e erro; feedback sem `alert()`
- [ ] Lint sem erros

## ⬜ Fase 5: fluxos principais

- [ ] Telas reais de carteiras e categorias
- [ ] Registro rápido de receita e despesa
- [ ] Lista de transações com filtros (período, categoria, tipo) e paginação
- [ ] Dashboard com saldo, receitas e despesas do período

## ⬜ Fase 6: relatórios

- [ ] Endpoints agregados: receitas × despesas (semana e mês), despesas por categoria, evolução do saldo, comparação entre períodos
- [ ] Índices para as consultas
- [ ] Gráficos

**Aceite:** cada indicador segue a definição do PROJECT.md e tem teste com dados conhecidos.

## ⬜ Fase 7: metas, orçamentos e investimentos

- [ ] Modelo de metas e limites (conforme a decisão pendente)
- [ ] Módulo de investimentos (registro de aportes, resgates e valor atual)

## ⬜ Fase 8: acabamento

- [ ] Responsividade (375px a 1440px) e acessibilidade
- [ ] ADRs e documentação técnica
- [ ] Avaliar o upgrade para Spring Boot 4

## ⬜ Fase 9: dockerização e deploy

- [ ] Dockerfiles multi-stage do backend e do frontend
- [ ] `docker-compose` com a stack completa
- [ ] Escolha do provedor de hospedagem (decisão de arquitetura)
