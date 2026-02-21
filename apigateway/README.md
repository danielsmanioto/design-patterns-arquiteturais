# API Gateway

Exemplos de **API Gateway** usando **Kong** e **NGINX**, orquestrando duas APIs simples escritas em Go.

## Estrutura

```
apigateway/
├── kong/
│   ├── api1/          # API 1 em Go (responde em /api1)
│   ├── api2/          # API 2 em Go (responde em /api2)
│   ├── kong.yml       # Configuração declarativa do Kong
│   └── docker-compose.yml
├── nginx/
│   ├── api1/          # API 1 em Go (responde em /api1)
│   ├── api2/          # API 2 em Go (responde em /api2)
│   ├── nginx.conf     # Configuração do NGINX
│   └── docker-compose.yml
└── README.md
```

## Como funciona

Cada gateway atua como ponto único de entrada e roteia as requisições para as APIs correspondentes:

| Rota    | Upstream     | Resposta            |
|---------|--------------|---------------------|
| `/api1` | api1:8080    | Hello from API 1    |
| `/api2` | api2:8080    | Hello from API 2    |

---

## Kong

O Kong opera em modo **DB-less** com configuração declarativa (`kong.yml`).

### Executando

```bash
cd kong
docker-compose up --build
```

### Testando

```bash
# API 1
curl http://localhost:8000/api1

# API 2
curl http://localhost:8000/api2
```

### Parando

```bash
docker-compose down
```

---

## NGINX

O NGINX atua como proxy reverso, roteando `/api1` e `/api2` para os respectivos serviços.

### Executando

```bash
cd nginx
docker-compose up --build
```

### Testando

```bash
# API 1
curl http://localhost:8080/api1

# API 2
curl http://localhost:8080/api2
```

### Parando

```bash
docker-compose down
```
