## References
https://learn.microsoft.com/en-us/azure/architecture/patterns/ 

# ☁️ Azure Architecture Patterns – Guia Completo

---

## 📌 O que são?

Patterns são soluções reutilizáveis para problemas comuns em sistemas distribuídos.

Objetivo:
- Escalabilidade
- Resiliência
- Performance
- Segurança

---

# 🧠 CATEGORIAS PRINCIPAIS

---

## 🔁 1. Resiliência (Fault Handling)

### Retry Pattern
- Reexecuta operações que falham temporariamente

### Circuit Breaker
- Evita chamadas repetidas a serviços falhos

### Timeout
- Evita espera infinita

### Health Endpoint Monitoring
- Monitora saúde de serviços

---

## ⚖️ 2. Escalabilidade & Performance

### Queue-Based Load Leveling
- Usa filas para absorver picos

### Competing Consumers
- Vários workers consumindo fila

### Throttling
- Limita requisições

### Cache-Aside
- Cache sob demanda

---

## 🧩 3. Data Management

### CQRS
- Separa leitura e escrita

### Event Sourcing
- Armazena eventos ao invés do estado

### Materialized View
- View otimizada para leitura

### Sharding
- Divide banco em partes

---

## 🔗 4. Messaging & Integration

### Publish/Subscribe
- Comunicação desacoplada

### Event-driven Architecture
- Sistema reage a eventos

### Message Broker
- Intermedia mensagens

### Claim Check
- Mensagens grandes fora da fila

---

## 🏗️ 5. Design & Implementation

### Strangler Fig
- Migração de monolito para microservices

### Sidecar
- Funcionalidade extra em container

### Ambassador
- Proxy para comunicação

### Adapter
- Traduz interfaces

---

## 🔐 6. Segurança

### Valet Key
- Acesso limitado a recursos

### Gatekeeper
- Protege entrada da aplicação

### Identity Management
- Gerenciamento de identidade

---

## 📊 7. Observabilidade & Gestão

### Logging & Monitoring
- Logs centralizados

### Distributed Tracing
- Rastreamento de requisições

### Auto Scaling
- Escala automática

---

## 💰 8. Otimização de custo

### Static Content Hosting
- Conteúdo em CDN

### Autoscaling
- Escala sob demanda

---

# 🧠 COMO USAR (ESSENCIAL)

## 1. Identifique o problema
- Latência?
- Falha?
- Escala?
- Consistência?

## 2. Escolha o pattern certo

## 3. Combine patterns

Exemplo:
- Retry + Circuit Breaker + Cache

---

# 🚀 EXEMPLO REAL

## Sistema de e-commerce

- API → Circuit Breaker
- Pedidos → Queue
- Catálogo → Cache
- Analytics → Event-driven
- Banco → CQRS

---

# 🎯 PRINCIPAIS PATTERNS (FOCO)

Se tiver pouco tempo, foque:

- Retry
- Circuit Breaker
- CQRS
- Cache-Aside
- Pub/Sub
- Queue-based load leveling

---

# 📌 REGRAS DE OURO

- Todo pattern tem trade-off
- Nunca usar pattern sem necessidade
- Combinar patterns é normal
- Pensar sempre em falhas

---

# 🎯 RESULTADO

Depois de dominar isso:

- Você pensa como arquiteto
- Sabe resolver problemas reais
- Consegue desenhar sistemas escaláveis
