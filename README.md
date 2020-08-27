# API de compra de moeda estrangeira

 ## Regras de negócio:
  - Esta API deve chamar a API de cotações para calcular o valor final da operação
  - Só serão aceitas compras de USD ou EUR
  - O Cep deve ser informado neste primeiro MVP, enquanto não é possível chamar a API de contas
  - Ao finalizar a compra, serão retornadas opções de agências para retirada da moeda estrangeira em espécie
  - A consulta de compras deve ser feita pelo id do cliente

___
 ## Requisições de Porta:

 ### POST /cambio/compra
Efetua a compra de moeda estrangeira.

**Request Body**
```json
{
    "idCliente": 1,
    "tipoMoeda": "EUR",
    "quantidadeMoeda": 100,
    "cepCliente": "03043070"
}
```

**Response 201**
```json
{
    "compra": {
        "id": 14,
        "idCliente": 1,
        "tipoMoeda": "EUR",
        "dataSolicitacao": "2020-08-27T00:16:23.283",
        "quantidadeMoeda": 100.0,
        "taxaCambio": 0.18,
        "valorCotacao": 6.6321,
        "valorOperacao": 663.21
    },
    "agencias": [
        {
            "id": "0072",
            "nome": "SP RUA PIRATININGA",
            "endereco": "R PIRATININGA 870 - BRAS - SAO PAULO SP - CEP 03042-000"
        },
        {
            "id": "0187",
            "nome": "SP BRAS",
            "endereco": "AV RANGEL PESTANA 1244 - BRAS - SAO PAULO SP - CEP 03002-000"
        },
        {
            "id": "1666",
            "nome": "SP LARGO CONCORDIA",
            "endereco": "AV RANGEL PESTANA 2296 - BRAS - SAO PAULO SP - CEP 03002-000"
        },
        {
            "id": "0175",
            "nome": "SP RUA ORIENTE",
            "endereco": "R MARIA MARCOLINA 591 - BRAS - SAO PAULO SP - CEP 03011-001"
        }
    ]
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