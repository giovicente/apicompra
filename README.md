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

*Rota request:* http://k8s-itau.mastertech.com.br/cambio/compra

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

**Response 400 - Tipo de Moeda Inválido**

Retorno de uma tentativa de compra com moeda ainda não suportada pela aplicação. As moedas suportadas, conforme regra de negócio, são USD e EUR.

Body de Request
```json
{
    "idCliente": 3,
    "tipoMoeda": "BTC",
    "quantidadeMoeda": 500,
    "numeroAgencia": "0933"
}
```

Response
```json
{
    "timestamp": "2020-09-01T00:22:16.369+0000",
    "status": 400,
    "error": "Bad Request",
    "message": "Tipo de Moeda inválido: BTC",
    "path": "/"
}
```
**Response 400 - Agência inválida**

Retorno de uma tentativa de compra na qual foi informada uma agência que não existe.
```json
{
    "idCliente": 3,
    "tipoMoeda": "USD",
    "quantidadeMoeda": 500,
    "numeroAgencia": "9999"
}
```

Response
```json
{
    "timestamp": "2020-09-01T00:26:31.446+0000",
    "status": 400,
    "error": "Bad Request",
    "message": "A agência 9999 não é uma agência válida.",
    "path": "/"
}
```

 ### GET /cambio/compra?id_cliente
Devolve as operações de compra de um cliente.

O parâmetro id_cliente é obrigatório. Não é possível consultar a lista sem este parâmetro.

*Rota request:* http://k8s-itau.mastertech.com.br/cambio/compra?id_cliente=1

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

**Response 400 - id_cliente não informado**

*Rota request:* http://k8s-itau.mastertech.com.br/cambio/compra/

```json
{
    "timestamp": "2020-09-01T00:34:32.926+0000",
    "status": 400,
    "error": "Bad Request",
    "message": "Required Long parameter 'id_cliente' is not present",
    "path": "/"
}
```

### GET /cambio/compra/{id}
Consulta o detalhe de uma compra pelo id.

*Rota request:* http://k8s-itau.mastertech.com.br/cambio/compra/5

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

**Response 404**

Retorno de uma solicitação de um id de compra inexistente.

*Rota request:* http://k8s-itau.mastertech.com.br/cambio/compra/999999999999999

Response:
```json
{
    "timestamp": "2020-09-01T00:38:05.907+0000",
    "status": 404,
    "error": "Not Found",
    "message": "Compra não encontrada.",
    "path": "/999999999999999"
}
```