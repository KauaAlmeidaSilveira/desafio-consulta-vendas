## Testes Manuais no Postman

Este sistema eficiente e flexível de vendas e vendedores oferece funcionalidades robustas para análise de desempenho. Abaixo estão os testes manuais realizados no Postman para as principais consultas:

### Sumário de Vendas por Vendedor (Teste 1)
- **Requisição:** `GET /sales/summary?minDate=2022-01-01&maxDate=2022-06-30`
- **Objetivo:** Verificar se a requisição retorna corretamente o sumário de vendas por vendedor no período informado.
- **Resultado Esperado:**
  ```json
  [
    {"sellerName": "Anakin", "total": 110571.0},
    {"sellerName": "Logan", "total": 83587.0},
    {"sellerName": "Loki Odinson", "total": 150597.0},
    {"sellerName": "Padme", "total": 135902.0},
    {"sellerName": "Thor Odinson", "total": 144896.0}
  ]
## Sumário de Vendas por Vendedor (Teste 2)
- **Requisição:** `GET /sales/summary`
- **Objetivo:** Verificar se a requisição retorna corretamente o sumário de vendas por vendedor dos últimos 12 meses.
- **Resultado Esperado:** Deve retornar o sumário de vendas no formato apropriado.

## Relatório de Vendas (Teste 1)
- **Requisição:** `GET /sales/report`
- **Objetivo:** Verificar se a requisição retorna corretamente o relatório de vendas dos últimos 12 meses.
- **Resultado Esperado:** Deve retornar o relatório de vendas no formato apropriado.

## Relatório de Vendas (Teste 2)
- **Requisição:** `GET /sales/report?minDate=2022-05-01&maxDate=2022-05-31&name=odinson`
- **Objetivo:** Verificar se a requisição retorna corretamente o relatório de vendas do período/vendedor informados.
- **Resultado Esperado:**
  ```json
  {
    "content": [
      {"id": 9, "date": "2022-05-22", "amount": 19476.0, "sellerName": "Loki Odinson"},
      {"id": 10, "date": "2022-05-18", "amount": 20530.0, "sellerName": "Thor Odinson"},
      {"id": 12, "date": "2022-05-06", "amount": 21753.0, "sellerName": "Loki Odinson"}
    ],
    // ...
  }
