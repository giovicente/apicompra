# API de compra de moeda estrangeira

 ## Regras de negócio:
  - Esta API deve chamar a API de cotações para calcular o valor final da operação
  - Só serão aceitas compras de USD ou EUR
  - A agência para retirada da moeda estrangeira deve ser informada neste primeiro MVP
  - Ao finalizar a compra, serão retornadas as informações de agência de retirada e identificador do agendamento da retirada
  - A consulta de compras deve ser feita pelo id do cliente

___
 ## Requisições de Compra:

 ### POST /cambio/compra
Efetua a compra de moeda estrangeira.
Rota request: http://k8s-itau.mastertech.com.br/cambio/compra

**Request Body**
```json
{
    "idCliente": 1,
    "tipoMoeda": "EUR",
    "quantidadeMoeda": 100,
    "numeroAgencia": "7057"
}
```

**Response 201**
```json
{
    "id": 29,
    "idCliente": 1,
    "tipoMoeda": "EUR",
    "dataSolicitacao": "2020-08-27T16:11:23.866",
    "quantidadeMoeda": 100.0,
    "taxaCambio": 0.18,
    "valorCotacao": 6.5857,
    "valorOperacao": 658.57,
    "numeroAgenciaRetirada": "7057",
    "nomeAgenciaRetirada": "PERSONNALITE ANGELICA",
    "enderecoAgenciaRetirada": "AV ANGELICA 1212 - STA CECILIA - SAO PAULO SP - CEP 01228-100",
    "idAgendamento": 2
}
```

 ### GET /cambio/compra?id_cliente=1
Devolve as operações de compra de um cliente
Rota request: http://k8s-itau.mastertech.com.br/cambio/compra?id_cliente=1

**Response 200**
```json
[
    {
        "id": 1,
        "idCliente": 1,
        "tipoMoeda": "USD",
        "dataSolicitacao": null,
        "quantidadeMoeda": 100.0,
        "taxaCambio": 0.0,
        "valorCotacao": 5.6076,
        "valorOperacao": 560.76
    },
    {
        "id": 2,
        "idCliente": 1,
        "tipoMoeda": "USD",
        "dataSolicitacao": "2020-08-26T21:39:42",
        "quantidadeMoeda": 100.0,
        "taxaCambio": 0.18,
        "valorCotacao": 5.6076,
        "valorOperacao": 560.76
    },
    {
        "id": 3,
        "idCliente": 1,
        "tipoMoeda": "USD",
        "dataSolicitacao": "2020-08-26T21:40:08",
        "quantidadeMoeda": 173.44,
        "taxaCambio": 0.18,
        "valorCotacao": 5.6076,
        "valorOperacao": 972.582144
    },
    {
        "id": 4,
        "idCliente": 1,
        "tipoMoeda": "USD",
        "dataSolicitacao": "2020-08-26T21:40:26",
        "quantidadeMoeda": 173.0,
        "taxaCambio": 0.18,
        "valorCotacao": 5.6076,
        "valorOperacao": 970.1148
    },
    {
        "id": 5,
        "idCliente": 1,
        "tipoMoeda": "EUR",
        "dataSolicitacao": "2020-08-26T21:40:46",
        "quantidadeMoeda": 100.0,
        "taxaCambio": 0.18,
        "valorCotacao": 6.6366,
        "valorOperacao": 663.66
    }
]
```
 ### GET /cambio/compra/{id}
Consulta o detalhe de uma compra pelo id.
Rota request: http://k8s-itau.mastertech.com.br/cambio/compra/30

**Response 200**
```json
{
  "id": 5,
  "idCliente": 1,
  "tipoMoeda": "EUR",
  "dataSolicitacao": "2020-08-26T21:40:46",
  "quantidadeMoeda": 100.0,
  "taxaCambio": 0.18,
  "valorCotacao": 6.6366,
  "valorOperacao": 663.66
}
```