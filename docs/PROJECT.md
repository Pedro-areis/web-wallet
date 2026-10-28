# Web Wallet: projeto e requisitos

## O problema

Quem tenta organizar o próprio dinheiro costuma esbarrar em três dificuldades:

- **Não saber para onde o dinheiro vai.** Os gastos ficam espalhados entre dinheiro, cartões e contas diferentes. No fim do mês, sobra pouca clareza sobre o que foi gasto e em quê.
- **Planilhas dão trabalho e não analisam nada sozinhas.** Registrar é manual, e gráficos, comparações e acompanhamento de metas dependem de fórmulas que cada pessoa monta e mantém.
- **Os apps dos bancos mostram só o próprio banco.** Eles não juntam todas as carteiras e não acompanham metas pessoais. Além disso, muitas pessoas não querem conectar contas bancárias a um serviço de terceiros.

## O que o Web Wallet resolve

Um lugar único para a pessoa **registrar, organizar e analisar** a própria vida financeira, com dados que ela mesma insere:

- Registrar receitas e despesas em poucos segundos, por carteira e por categoria.
- Ver o saldo e a evolução ao longo do tempo, por semana e por mês.
- Entender os hábitos de gasto, com despesas por categoria e comparação entre períodos.
- Definir metas financeiras e acompanhar o progresso.
- Registrar investimentos e acompanhar a evolução dos valores.

**A aplicação não movimenta dinheiro.** Ela não se conecta a bancos, não faz pagamentos e não compra nem vende investimentos. Isso mantém os dados sob controle do usuário e o escopo simples.

## Para quem

Pessoas que querem organizar as finanças pessoais no Brasil: valores em reais (R$), interface em português, datas no formato brasileiro.

O projeto também serve para o autor aprender e praticar Java, Spring Boot, TypeScript, React e PostgreSQL.

## Requisitos funcionais

Legenda de status: ✅ implementado · ⚠️ parcial · ❌ ausente. A situação detalhada está no diagnóstico de 28/10/2026 e em [TASKS.md](TASKS.md).

### Conta e acesso
| Requisito | Status |
|---|---|
| Cadastro com nome, e-mail, data de nascimento e senha | ✅ (validação fraca) |
| Login com JWT e consulta dos próprios dados | ✅ |
| Encerrar sessão | ⚠️ o token não é removido |
| Editar o próprio perfil (e-mail, senha, nota) | ⚠️ endpoint inseguro; tela sem envio |
| Cada usuário vê e altera somente os próprios dados | ❌ falha crítica comprovada |

### Gestão financeira
| Requisito | Status |
|---|---|
| Carteiras (ex.: conta corrente, dinheiro, viagem) | ⚠️ backend pronto; tela mockada |
| Registrar receitas e despesas com valor, data, descrição, categoria e carteira | ⚠️ sem data informada, sem editar nem excluir |
| Categorias por usuário, usadas nas movimentações | ⚠️ existem, mas não se ligam às transações |
| Filtros por período, categoria e tipo | ❌ |
| Metas financeiras com valor-alvo e progresso | ⚠️ sem atualização do progresso |
| Limites de gasto e orçamentos por categoria | ⚠️ modelo duplicado (`special_categories.limit` × `budgets`), decisão pendente |
| Investimentos: registro de aplicações e do valor atual (sem operações reais) | ❌ |

### Análise e relatórios
| Requisito | Status |
|---|---|
| Dashboard com saldo, receitas e despesas do período | ❌ |
| Receitas × despesas por semana e por mês | ❌ |
| Evolução do saldo ao longo do tempo | ❌ |
| Despesas por categoria | ❌ |
| Comparação de gastos entre períodos | ❌ |
| Progresso das metas | ❌ |
| Evolução dos investimentos | ❌ |
| Indicadores de economia (ex.: taxa de poupança), só quando houver dados suficientes | ❌ |

## Requisitos não funcionais

- **Segurança:** autenticação JWT, e autorização aplicada no backend em toda operação. Esconder elementos no frontend não conta como proteção.
- **Consistência financeira:** valores em decimal exato e cálculos verificáveis, com definição documentada de cada indicador.
- **Usabilidade:** interface responsiva (celular e desktop), acessível, com estados de carregamento, vazio, sucesso e erro, e feedback após cada operação.
- **Desempenho:** agregações feitas no PostgreSQL, com índices adequados ao volume de dados.
- **Qualidade:** testes nas funcionalidades críticas (autorização, autenticação, regras financeiras, relatórios).
- **Portabilidade:** configuração por variáveis de ambiente; a aplicação será dockerizada no fim do desenvolvimento, para um provedor ainda a definir.

## Definição dos indicadores

Estas definições valem para toda a aplicação. Uma definição só muda com decisão registrada em ADR.

| Termo | Definição | Situação |
|---|---|---|
| Receitas do período | Soma das transações do tipo receita com data dentro do período | Proposta |
| Despesas do período | Soma das transações do tipo despesa com data dentro do período | Proposta |
| Fluxo de caixa do período | Receitas do período − despesas do período | Proposta |
| Saldo da carteira em uma data | Saldo inicial + Σ receitas − Σ despesas até a data | Proposta; depende da decisão "saldo calculado ou guardado" |
| Saldo total | Soma dos saldos das carteiras. **Não inclui** valores investidos | Proposta |
| Valor investido | Soma dos aportes − resgates registrados em investimentos | Proposta |
| Taxa de poupança | Fluxo de caixa ÷ receitas do período, exibida só quando as receitas forem maiores que zero | Proposta |

## Fora do escopo

**Agora:** integração com bancos, importação automática de extratos, pagamentos e transferências reais, compra ou venda de investimentos.

**Visão futura (só com autorização explícita):**
- Notificações e processamento assíncrono.
- Lembretes de metas por e-mail. Exemplo: avisar todo mês para registrar um aporte planejado. O lembrete só avisa; nenhum dinheiro é movimentado.
- Insights com IA sobre padrões de consumo, com transparência e cuidado com a privacidade.
