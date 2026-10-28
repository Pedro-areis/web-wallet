# Web Wallet: instruções para agentes de IA

Aplicação web de gestão financeira pessoal. O usuário registra receitas, despesas, categorias, metas e investimentos e analisa os dados. **Não há integração bancária e nenhuma operação financeira real é executada**: os dados são inseridos pelo próprio usuário.

Responda ao usuário em **português (PT-BR)**.

Leia antes de trabalhar:
- [docs/PROJECT.md](../docs/PROJECT.md): o problema, os requisitos e a definição dos indicadores financeiros.
- [docs/TASKS.md](../docs/TASKS.md): fases, tarefas, decisões pendentes e o que já foi feito. Atualize ao concluir cada tarefa.

## Regras de trabalho (definidas pelo dono do projeto)

1. **Nomes no código em inglês.** Variáveis, métodos, classes, campos de DTO, rotas, tabelas e colunas devem ficar em inglês. Nomes em PT-BR que já existem devem ser refatorados para inglês, por exemplo `onwerUser`, os valores de enum `receita`/`despesa`/`pendente`/`pago`/`vencido` e a coluna `senha_hash`.
   - Textos exibidos ao usuário (labels, mensagens de erro e de validação) continuam em PT-BR.
   - Renomear algo persistido no banco (coluna, tabela, valor de enum guardado como texto com `CHECK`) exige migration Flyway nova e muda contratos da API. Trate como decisão de arquitetura (regra 3): proponha antes de fazer.
2. **Git: autonomia.** O agente pode commitar, fazer push e abrir PRs quando julgar necessário, sem pedir confirmação a cada vez.
   - Nunca commite direto na `main`. Crie uma branch a partir da `main` (`feature/…`, `fix/…`, `refactor/…`, `chore/…`).
   - Siga o padrão de commits do repositório: Conventional Commits com descrição em PT-BR, por exemplo `feat(wallet): cria endpoint de saldo`.
   - Faça commits pequenos e coesos, um assunto por commit. Não misture refatoração estrutural com regra de negócio nova.
   - Não use force push em branches compartilhadas nem pule hooks.
3. **Sempre explique o porquê.** Toda mudança deve ser apresentada com o problema que resolve, a solução escolhida e o motivo da escolha.
   - **Decisões que afetam a arquitetura devem ser consultadas antes de implementar.** Exemplos: nova dependência ou tecnologia, mudança no modelo de dados, mudança em contrato da API, nova camada ou padrão, mudança na estratégia de autenticação, renomeações persistidas.
4. **Na dúvida, pergunte.** Em qualquer trade-off, apresente as opções com prós e contras e pergunte ao dono do projeto. As decisões aprovadas viram ADRs em `docs/adr/` (formato abaixo).

## Forma de trabalho

O trabalho é incremental, em etapas aprovadas pelo dono do projeto. Para cada etapa:

1. Explique o problema e a prioridade.
2. Liste os arquivos afetados.
3. Descreva a solução e as alternativas consideradas.
4. Defina critérios de aceite verificáveis.
5. Implemente só o escopo aprovado.
6. Rode testes, build e lint.
7. Reporte o que mudou, os resultados e as limitações.

Não avance silenciosamente para a próxima etapa. O diagnóstico inicial e o plano em fases foram apresentados em 28/10/2026. Siga essa ordem, salvo decisão contrária: 0 build e ambiente · 1 estrutura de testes · 2 segurança e isolamento · 3 integridade do modelo · 4 base do frontend · 5 fluxos principais · 6 relatórios · 7 metas, orçamentos e investimentos · 8 acabamento · 9 dockerização e deploy.

## Estrutura e stack

- `backend/`: Spring Boot 3.5.7, Java 21, Spring Security + JWT (auth0 `java-jwt`), Spring Data JPA, Flyway, Lombok, springdoc.
- `frontend/`: React 19, TypeScript (strict), Vite 7, Tailwind 4, axios, react-router 7.
- Banco: PostgreSQL. O schema é versionado em `backend/src/main/resources/db/migration`.
- O backend é organizado por funcionalidade (`user`, `wallet`, `transactions`, `categories`, `special_categories`, `budgets`), cada uma com Controller → Service → Repository e DTOs em `dto/` como `record`. Mantenha esse padrão.

## Comandos

```bash
# backend (de dentro de backend/)
./mvnw verify
./mvnw spring-boot:run

# frontend (de dentro de frontend/)
npm ci
npm run dev
npm run build
npm run lint
```

> Até a Fase 0 terminar, o build do backend está quebrado: `modelVersion 4.1.0` no `pom.xml` e springdoc sem versão. Não presuma que os comandos acima funcionam antes disso.

## Regras técnicas obrigatórias

- **Isolamento de dados.** O usuário vem sempre do token (`@AuthenticationPrincipal`), nunca de `userId` na URL ou no corpo da requisição. Recursos de outro usuário retornam 404. A autorização acontece no backend; esconder algo no frontend não é segurança.
- **Banco.** Toda mudança de schema é uma migration Flyway nova (`V{n}__descricao.sql`). Nunca edite uma migration já aplicada. Avalie os dados existentes antes de adicionar `NOT NULL`, FKs ou renomeações.
- **Dinheiro.** Use `BigDecimal` em Java e `NUMERIC` no banco. Nunca use `double` ou `float`. Diferencie saldo, fluxo de caixa, receitas, despesas e valores investidos.
- **Agregações** (totais, relatórios) são feitas no PostgreSQL, não carregando listas para somar em Java.
- **Segredos** (JWT, banco) vêm de variáveis de ambiente e nunca são commitados.
- **Erros** retornam status HTTP corretos (400, 401, 404, 409), não `RuntimeException` genérica.
- **Testes.** Comportamento crítico (autorização, autenticação, regras financeiras, cálculos de relatórios) precisa de teste. Backend: JUnit + MockMvc + Testcontainers (PostgreSQL). Frontend: Vitest + Testing Library.
- **Simplicidade.** Nada de microsserviços, mensageria, cache distribuído ou tecnologia nova sem necessidade demonstrada e sem aprovação.

## Docker e deploy (planejado para o fim do desenvolvimento)

A aplicação será dockerizada para facilitar o deploy. O provedor de hospedagem ainda não foi escolhido, e essa etapa acontece **depois das fases de funcionalidade**, como última fase do plano.

- **Agora:** use Docker só no ambiente de desenvolvimento, com um `docker-compose` que sobe o PostgreSQL (Fase 0). Os testes usam Testcontainers.
- **Na fase final:**
  - Backend: Dockerfile multi-stage (build com JDK, runtime com JRE enxuta, usuário não-root).
  - Frontend: Dockerfile multi-stage (build com Node, arquivos estáticos servidos por um servidor web leve).
  - Um `docker-compose` com a stack completa.
  - A escolha das imagens base, do servidor web e do provedor é decisão de arquitetura: consulte antes.
- **Até lá:** mantenha a aplicação pronta para container, sem antecipar a dockerização.
  - Toda configuração vem de variáveis de ambiente.
  - Nada de caminhos absolutos ou específicos de máquina.
  - Logs vão para stdout.
  - A URL da API no frontend vem de `VITE_API_URL`.
  - Nada no código pode depender de um provedor de hospedagem específico.

## Fora do escopo (não implementar sem autorização explícita)

Integração bancária, importação automática de extratos, pagamentos e transferências reais, compra ou venda de investimentos, notificações e mensageria, insights com IA e lembretes recorrentes por e-mail.

## ADRs

Registre em `docs/adr/NNNN-titulo-curto.md` (numeração sequencial) com as seções: **Contexto**, **Decisão**, **Alternativas consideradas** (com trade-offs), **Consequências** e **Status** (proposto, aceito ou substituído). Escreva o ADR somente depois que o dono do projeto aprovar a decisão.
