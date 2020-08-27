# API de compra de moeda estrangeira

 ## Regras de negócio:
  - Esta API deve chamar a API de cotações para calcular o valor final da operação
  - Só serão aceitas compras de USD ou EUR
  - O Cep deve ser informado neste primeiro MVP, enquanto não é possível chamar a API de contas
  - Ao finalizar a compra, serão retornadas opções de agências mais próximas ao Cep do cliente para retirada da moeda estrangeira em espécie
  - A consulta de compras deve ser feita pelo id do cliente

___
 ## Requisições de Compra:

 ### POST /cambio/compra
Efetua a compra de moeda estrangeira.

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
    "id": 27,
    "idCliente": 1,
    "tipoMoeda": "EUR",
    "dataSolicitacao": "2020-08-27T14:25:25.848",
    "quantidadeMoeda": 100.0,
    "taxaCambio": 0.18,
    "valorCotacao": 6.5832,
    "valorOperacao": 658.3199999999999,
    "numeroAgenciaRetirada": "7057",
    "nomeAgenciaRetirada": "PERSONNALITE ANGELICA",
    "enderecoAgenciaRetirada": "AV ANGELICA 1212 - STA CECILIA - SAO PAULO SP - CEP 01228-100"
}
```

 ### GET /cambio/compra?id_cliente=1
Devolve as operações de compra de um cliente

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
    },
    {
        "id": 6,
        "idCliente": 1,
        "tipoMoeda": "USD",
        "dataSolicitacao": "2020-08-26T21:40:54",
        "quantidadeMoeda": 100.0,
        "taxaCambio": 0.18,
        "valorCotacao": 5.6076,
        "valorOperacao": 560.76
    },
    {
        "id": 7,
        "idCliente": 1,
        "tipoMoeda": "EUR",
        "dataSolicitacao": "2020-08-26T21:44:01",
        "quantidadeMoeda": 100.0,
        "taxaCambio": 0.18,
        "valorCotacao": 6.6388,
        "valorOperacao": 663.88
    },
    {
        "id": 8,
        "idCliente": 1,
        "tipoMoeda": "EUR",
        "dataSolicitacao": "2020-08-26T21:45:22",
        "quantidadeMoeda": 100.0,
        "taxaCambio": 0.18,
        "valorCotacao": 6.6372,
        "valorOperacao": 663.72
    },
    {
        "id": 9,
        "idCliente": 1,
        "tipoMoeda": "EUR",
        "dataSolicitacao": "2020-08-26T23:09:10",
        "quantidadeMoeda": 100.0,
        "taxaCambio": 0.18,
        "valorCotacao": 6.6321,
        "valorOperacao": 663.21
    },
    {
        "id": 10,
        "idCliente": 1,
        "tipoMoeda": "EUR",
        "dataSolicitacao": "2020-08-26T23:10:41",
        "quantidadeMoeda": 100.0,
        "taxaCambio": 0.18,
        "valorCotacao": 6.6321,
        "valorOperacao": 663.21
    },
    {
        "id": 11,
        "idCliente": 1,
        "tipoMoeda": "USD",
        "dataSolicitacao": "2020-08-26T23:43:25",
        "quantidadeMoeda": 100.0,
        "taxaCambio": 0.18,
        "valorCotacao": 5.6076,
        "valorOperacao": 560.76
    },
    {
        "id": 12,
        "idCliente": 1,
        "tipoMoeda": "USD",
        "dataSolicitacao": "2020-08-27T00:00:00",
        "quantidadeMoeda": 100.0,
        "taxaCambio": 0.18,
        "valorCotacao": 5.6076,
        "valorOperacao": 560.76
    },
    {
        "id": 13,
        "idCliente": 1,
        "tipoMoeda": "USD",
        "dataSolicitacao": "2020-08-27T00:00:23",
        "quantidadeMoeda": 100.0,
        "taxaCambio": 0.18,
        "valorCotacao": 5.6076,
        "valorOperacao": 560.76
    },
    {
        "id": 14,
        "idCliente": 1,
        "tipoMoeda": "EUR",
        "dataSolicitacao": "2020-08-27T00:16:23",
        "quantidadeMoeda": 100.0,
        "taxaCambio": 0.18,
        "valorCotacao": 6.6321,
        "valorOperacao": 663.21
    }
]
```
 ### GET /cambio/compra/{id}
Consulta o detalhe de uma compra pelo id.

**Response 200**
```json
{
    "id": 7,
    "idCliente": 1,
    "tipoMoeda": "EUR",
    "dataSolicitacao": "2020-08-26T21:44:01",
    "quantidadeMoeda": 100.0,
    "taxaCambio": 0.18,
    "valorCotacao": 6.6388,
    "valorOperacao": 663.88
}
```