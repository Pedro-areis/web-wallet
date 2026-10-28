# 0003. Limites unificados em budgets e metas em entidade própria

## Contexto
Hoje o limite de gasto existe em dois lugares (`special_categories.limit` e `budgets`) e metas financeiras compartilham a modelagem de categorias especiais, sem forma de atualizar o progresso.

## Decisão
- **Limites de gasto** são unificados em `budgets` (limite por categoria e período). `special_categories.limit` deixa de ser usado.
- **Metas** (valor-alvo, prazo, progresso) passam a uma **entidade própria**, separada de categorias e de orçamentos.

## Alternativas consideradas
- **Manter o modelo atual:** menos migrations, mas mantém a duplicação e o progresso de metas sem modelo adequado.
- **Unificar tudo numa só tabela:** menos tabelas, porém mistura conceitos com regras diferentes (limite recorrente × objetivo com prazo).
- **Unificar limites e separar metas (escolhida):** um conceito por tabela, regras de cálculo claras.

## Consequências
Exige migrations Flyway e mudança de contrato da API na Fase 7, com tratamento dos dados existentes. O desenho detalhado das tabelas será proposto antes de implementar.

## Status
Aceito (28/10/2026)
