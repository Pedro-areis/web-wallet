# 0002. Saldo da carteira calculado, não armazenado

## Contexto
O saldo da carteira pode ser guardado numa coluna e atualizado a cada transação, ou calculado a partir das transações. Editar e excluir transações (Fase 3) e os relatórios (Fase 6) dependem dessa escolha.

## Decisão
O saldo é **calculado**: saldo inicial + Σ receitas − Σ despesas até a data, por agregação no PostgreSQL. Não existe coluna de saldo atual como fonte da verdade.

## Alternativas consideradas
- **Saldo guardado:** leitura rápida, mas pode divergir das transações (edição, exclusão, concorrência) e exige reconciliação.
- **Saldo calculado:** sempre consistente e permite o saldo em qualquer data (evolução do saldo). Custo: agregação em cada leitura, mitigado por índices (Fase 6).

## Consequências
Editar ou excluir transações não exige ajuste de saldo. A definição de "Saldo da carteira em uma data" no PROJECT.md passa a valer. Se o volume exigir, snapshots ou cache entram por novo ADR.

## Status
Aceito (28/10/2026)
