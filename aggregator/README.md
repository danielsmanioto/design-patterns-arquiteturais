# 🔀 Aggregator Pattern

O **Aggregator Pattern** é um padrão arquitetural onde um serviço centraliza chamadas a múltiplos microserviços e combina os resultados em uma **única resposta agregada**.

Muito utilizado em conjunto com API Gateways, o Aggregator evita que o cliente precise fazer várias chamadas separadas para obter dados relacionados.

---

## 🗂️ Estrutura

```
aggregator/
├── aggregator/           # Serviço Aggregator (porta 3000)
│   ├── src/
│   │   └── index.js
│   ├── Dockerfile
│   └── package.json
├── pessoas/              # Microserviço de Pessoas (porta 3001)
│   ├── src/
│   │   └── index.js
│   ├── Dockerfile
│   └── package.json
├── contas/               # Microserviço de Contas (porta 3002)
│   ├── src/
│   │   └── index.js
│   ├── Dockerfile
│   └── package.json
├── docker-compose.yml
└── README.md
```

---

## ⚙️ Como funciona

```
Cliente
  │
  ▼
Aggregator (:3000)
  ├──► Pessoas Service (:3001)  →  retorna lista de pessoas
  └──► Contas Service  (:3002)  →  retorna contas por pessoaId
  │
  ▼
Resposta agregada: pessoa + contas
```

O **Aggregator** realiza chamadas paralelas aos dois microserviços usando `Promise.all` e combina os dados antes de devolver ao cliente.

---

## 🚀 Executando

### Pré-requisitos

- [Docker](https://www.docker.com/)
- [Docker Compose](https://docs.docker.com/compose/)

### Subindo os serviços

```bash
docker-compose up --build
```

Todos os três serviços sobem automaticamente:

| Serviço     | URL                        | Descrição                         |
|-------------|----------------------------|-----------------------------------|
| Aggregator  | http://localhost:3000      | API que agrega pessoas + contas   |
| Pessoas     | http://localhost:3001      | Microserviço de pessoas           |
| Contas      | http://localhost:3002      | Microserviço de contas            |

---

## 🧪 Testando

### Dados agregados (todas as pessoas com contas)

```bash
curl http://localhost:3000/agregado
```

**Resposta:**

```json
[
  {
    "id": 1,
    "nome": "Alice Silva",
    "email": "alice@example.com",
    "contas": [
      { "id": 101, "pessoaId": 1, "tipo": "corrente", "saldo": 1500.00 },
      { "id": 102, "pessoaId": 1, "tipo": "poupança", "saldo": 3200.50 }
    ]
  },
  {
    "id": 2,
    "nome": "Bob Souza",
    "email": "bob@example.com",
    "contas": [
      { "id": 103, "pessoaId": 2, "tipo": "corrente", "saldo": 800.00 }
    ]
  },
  ...
]
```

### Dados agregados por ID

```bash
curl http://localhost:3000/agregado/1
```

**Resposta:**

```json
{
  "id": 1,
  "nome": "Alice Silva",
  "email": "alice@example.com",
  "contas": [
    { "id": 101, "pessoaId": 1, "tipo": "corrente", "saldo": 1500.00 },
    { "id": 102, "pessoaId": 1, "tipo": "poupança", "saldo": 3200.50 }
  ]
}
```

### Microserviços individualmente

```bash
# Lista todas as pessoas
curl http://localhost:3001/pessoas

# Busca pessoa por ID
curl http://localhost:3001/pessoas/2

# Lista todas as contas
curl http://localhost:3002/contas

# Lista contas de uma pessoa específica
curl http://localhost:3002/contas/pessoa/1
```

---

## 🛑 Parando

```bash
docker-compose down
```

---

## 💡 Conceito

> O Aggregator é um padrão fundamental em arquiteturas de microserviços: ao invés de o cliente realizar múltiplas chamadas, um serviço intermediário orquestra as chamadas e devolve os dados consolidados.

### Vantagens

- ✅ Reduz latência percebida pelo cliente (chamadas paralelas)
- ✅ Desacopla o cliente dos microserviços internos
- ✅ Facilita transformações e enriquecimento de dados
- ✅ Um único ponto de entrada para dados relacionados

### Desvantagens

- ⚠️ Ponto único de falha se não tiver resiliência (Circuit Breaker, Retry)
- ⚠️ Pode se tornar um "God Service" se não for bem delimitado
