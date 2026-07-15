# 🏗️ Design Patterns Arquiteturais e de Integração

[![Status](https://img.shields.io/badge/status-active-success?style=flat-square)](https://github.com)
[![License](https://img.shields.io/badge/license-MIT-blue?style=flat-square)](LICENSE)
[![Language](https://img.shields.io/badge/language-Portuguese-informational?style=flat-square)](README.md)
[![Contributions](https://img.shields.io/badge/contributions-welcome-brightgreen?style=flat-square)](CONTRIBUTING.md)
[![Node.js](https://img.shields.io/badge/node.js-✓-success?style=flat-square)](package.json)
[![Docker](https://img.shields.io/badge/docker-ready-blue?style=flat-square)](Dockerfile)

> Guia completo dos principais **padrões arquiteturais**, **de integração** e **de microsserviços** utilizados em sistemas distribuídos e aplicações escaláveis.
---

## 📋 Como Contribuir

Este projeto segue uma estrutura **trunk-based development**:

- ✅ Crie uma branch com o padrão: `feature/**` partindo da branch `main`
- ✅ O PR será criado automaticamente
- ✅ Abra seu PR e aguarde a revisão

**Branches protegidas:**
- `main` - Requer PR review antes de merge

---

## 🔧 Padrões de Integração

### ✅ Configuration
Padrão para gerenciar configurações de forma centralizada e consistente entre serviços.  
**Exemplos:** Spring Cloud Config, Consul, etcd

### ✅ Sequence
Representa a execução de passos coordenados, normalmente em fluxos de orquestração ou workflows.  
**Exemplos:** AWS Step Functions, Temporal.io, Camunda

### ✅ Lock Distribuído
Mecanismo para evitar condições de corrida e garantir exclusividade em operações críticas em ambientes distribuídos.  
**Exemplos:** Redlock (Redis), Zookeeper

### ✅ Circuit Breaker
Evita que falhas em um serviço se propaguem para outros, "abrindo o circuito" quando há erros sucessivos.  
**Exemplos:** Netflix Hystrix, Resilience4j

### ✅ Pub/Sub
Padrão de comunicação assíncrona onde produtores publicam mensagens e consumidores as recebem por assinatura.  
**Exemplos:** Kafka, Google Pub/Sub, Redis Streams

### ✅ Webhook
Permite a comunicação reativa entre sistemas via chamadas HTTP quando um evento ocorre.  
**Exemplos:** Notificação de pagamento (Stripe → seu backend)

### ✅ WebSocket
Canal de comunicação bidirecional e em tempo real entre cliente e servidor.  
**Exemplos:** Chats, dashboards, notificações ao vivo

### ✅ Request/Response
Modelo clássico de comunicação síncrona entre cliente e servidor.  
**Exemplos:** REST, gRPC

### 🔄 Message Queue
Fila intermediária para desacoplar produtores e consumidores de mensagens.  
**Exemplos:** RabbitMQ, AWS SQS, ActiveMQ

### 📚 Event Sourcing
Armazena o histórico completo de eventos que ocorreram, permitindo reconstruir o estado da aplicação.  
**Exemplos:** Axon Framework, Kafka + Snapshots

### 🔀 CQRS (Command Query Responsibility Segregation)
Separa operações de leitura (queries) e escrita (commands) para otimizar desempenho e escalabilidade.  
**Exemplos:** Leitura via cache, escrita via eventos

### 🎭 Saga Pattern
Coordena transações distribuídas em múltiplos serviços, garantindo consistência eventual.  
**Exemplos:** Orquestradas com Step Functions, coreografadas com eventos Kafka

### ✅ API Gateway
Ponto único de entrada para múltiplos microsserviços, gerenciando autenticação, roteamento e segurança.  
**Exemplos:** Kong, NGINX, AWS API Gateway

### ✅ Aggregator
Combina resultados de múltiplos serviços em uma única resposta agregada.  
**Exemplos:** API Gateway que chama vários microservices

### 🔎 Service Discovery
Permite que serviços encontrem e se comuniquem dinamicamente entre si.  
**Exemplos:** Eureka, Consul, Kubernetes DNS

### 💚 Health Check
Verifica o status e a disponibilidade de serviços para orquestração e monitoramento.  
**Exemplos:** /health endpoint, Kubernetes livenessProbe

### 🔁 Retry / Timeout / Fallback
Padrões de resiliência que complementam o Circuit Breaker, controlando novas tentativas e respostas alternativas.  
**Exemplos:** Resilience4j Retry, Spring Retry

### 🚧 Bulkhead
Isola recursos (threads, conexões, instâncias) entre componentes para evitar falhas em cascata.  
**Exemplos:** Containers ou pools separados por serviço

### ⏱️ Rate Limiting / Throttling
Controla a quantidade de requisições aceitas em um período para proteger o sistema de sobrecarga.  
**Exemplos:** API Gateway limitando 100 req/min

### ⚖️ Load Balancer
Distribui requisições entre várias instâncias de um serviço.  
**Exemplos:** NGINX, HAProxy, AWS ALB

### 📊 Centralized Logging
Coleta e consolida logs de vários serviços em um único ponto de análise.  
**Exemplos:** ELK Stack (Elasticsearch, Logstash, Kibana)

### 📈 Distributed Tracing
Rastreia o fluxo de requisições entre microsserviços para diagnóstico e monitoramento.  
**Exemplos:** OpenTelemetry, Jaeger, Zipkin

### 🛣️ Sidecar Pattern
Executa componentes auxiliares (proxy, logging, métricas) ao lado do serviço principal, compartilhando o mesmo host/pod.  
**Exemplos:** Envoy Proxy, Istio Sidecar

### 🔌 Adapter / Facade
Encapsula integrações externas, simplificando e padronizando a comunicação.  
**Exemplos:** Classe Adapter para API de terceiros

### 💉 Dependency Injection
Padrão interno de código para gerenciar dependências de forma desacoplada e configurável.  
**Exemplos:** Spring Framework, Dagger, Guice

### 👁️ Observabilidade
Abrange logs, métricas e traces para garantir visibilidade total do comportamento do sistema.  
**Exemplos:** Prometheus, Grafana, OpenTelemetry

---

## 🎯 Conclusão - Padrões de Integração
Esses padrões ajudam a construir sistemas **resilientes, escaláveis e desacoplados**, essenciais em ambientes de **microsserviços e arquiteturas distribuídas**.

---

# 🧩 Padrões de Microsserviços

Os **padrões de microsserviços** ajudam a estruturar sistemas compostos por múltiplos serviços independentes, escaláveis e de fácil manutenção. Eles tratam desde o **design dos serviços** até **observabilidade, segurança e deploy**.

---

## 📐 Design e Arquitetura

### 🎯 Single Responsibility
Cada microsserviço deve ter uma responsabilidade clara e única, reduzindo o acoplamento e facilitando a evolução independente.  
**Exemplos:** um serviço apenas para autenticação, outro apenas para cobrança

### 🔍 Bounded Context
Baseado em DDD (Domain-Driven Design). Cada serviço representa um **contexto delimitado** do domínio.  
**Exemplos:** "Pagamento", "Entrega", "Catálogo" — cada um com suas próprias entidades e regras

### 🗄️ Database per Service
Cada microsserviço tem seu próprio banco de dados, evitando acoplamento e promovendo autonomia.  
**Exemplos:** Serviço de pedidos com PostgreSQL; serviço de clientes com MongoDB

## 🌐 Comunicação e Roteamento

### 🚪 API Gateway
Ponto único de entrada para os microsserviços, tratando autenticação, roteamento, cache e rate limiting.  
**Exemplos:** Kong, NGINX, Traefik, AWS API Gateway

### 🔍 Service Discovery
Permite que microsserviços se encontrem dinamicamente sem depender de URLs fixas.  
**Exemplos:** Netflix Eureka, Consul, Kubernetes DNS

### ⚙️ Config Server
Centraliza configurações para múltiplos microsserviços, com atualização dinâmica.  
**Exemplos:** Spring Cloud Config, Consul KV

## 🛡️ Resiliência

### 🔌 Circuit Breaker
Evita falhas em cascata ao interromper chamadas para serviços que estão instáveis.  
**Exemplos:** Resilience4j, Hystrix

### 🎭 Saga Pattern
Gerencia **transações distribuídas**, garantindo consistência eventual entre múltiplos serviços.  
**Exemplos:** Orquestração via workflow (Step Functions, Temporal.io) ou coreografia via eventos (Kafka)

## 📊 Padrões de Dados

### 🔀 CQRS
Separa comandos (escritas) de queries (leituras), melhorando escalabilidade e desempenho.  
**Exemplos:** gravação via eventos e leitura via projeções otimizadas

### 📚 Event Sourcing
Registra todas as mudanças como eventos, permitindo reconstruir o estado atual do sistema.  
**Exemplos:** Kafka + snapshots, Axon Framework

### 🔄 Strangler Fig Pattern
Migra sistemas monolíticos para microsserviços de forma incremental, substituindo partes aos poucos.  
**Exemplos:** Novo serviço intercepta rotas do monólito até substituí-lo completamente

### 🧩 API Composition / Aggregator
Combina dados de múltiplos microsserviços em uma única resposta.  
**Exemplos:** Serviço "Order Summary" que junta informações de clientes, pagamentos e produtos

## 👥 Cliente-Específico

### 📱 Backend for Frontend (BFF)
Cria uma API específica para cada tipo de cliente (web, mobile, IoT), otimizando payloads e performance.  
**Exemplos:** BFF para app mobile e outro para web

## 🔗 Infraestrutura

### 🛡️ Service Mesh
Camada de infraestrutura que gerencia comunicação, segurança e observabilidade entre serviços.  
**Exemplos:** Istio, Linkerd, Consul Connect

### 🛣️ Sidecar Pattern
Executa componentes auxiliares (proxy, logs, métricas) junto com o serviço principal no mesmo pod/container.  
**Exemplos:** Envoy Proxy com cada microsserviço

### 🚧 Bulkhead
Isola recursos por serviço ou função, impedindo que a falha de um componente afete os demais.  
**Exemplos:** pools de threads separados para cada integração

### 🔁 Retry / Timeout / Fallback
Define políticas de repetição e tempo limite em chamadas remotas, evitando travamentos e degradação.  
**Exemplos:** Retry automático com backoff exponencial

## 📡 Observabilidade

### 📈 Distributed Tracing
Permite rastrear requisições entre microsserviços para entender o fluxo completo e medir latência.  
**Exemplos:** Jaeger, Zipkin, OpenTelemetry

### 📊 Centralized Logging
Consolida logs de todos os serviços em um único ponto de análise.  
**Exemplos:** ELK Stack (Elasticsearch, Logstash, Kibana), Loki + Grafana

### 💚 Health Check / Heartbeat
Endpoints e mecanismos para verificar o estado de cada serviço.  
**Exemplos:** `/health` endpoint, Kubernetes `livenessProbe`

## 🚀 Deploy e Entrega

### 🎨 Canary Release
Implanta uma nova versão de serviço para uma pequena parcela dos usuários antes do rollout completo.  
**Exemplos:** 5% do tráfego com nova versão

### 🔵 Blue-Green Deployment
Mantém duas versões do ambiente (Blue e Green) para alternar releases sem downtime.  
**Exemplos:** Kubernetes com dois deployments ativos

### 🎚️ Feature Toggle
Ativa ou desativa recursos sem necessidade de deploy, facilitando experimentos e rollbacks.  
**Exemplos:** LaunchDarkly, Unleash

## 🔐 Segurança

### 👁️ Observabilidade
Combina métricas, logs e traces para oferecer visibilidade completa sobre o comportamento dos microsserviços.  
**Exemplos:** Prometheus, Grafana, OpenTelemetry

### 🔒 Security Patterns
Define estratégias de autenticação, autorização e comunicação segura entre serviços.  
**Exemplos:** OAuth2, mTLS, JWT, API Keys

### 📌 API Versioning
Permite evolução das APIs sem quebrar compatibilidade com versões antigas.  
**Exemplos:** `/v1/users`, `/v2/users`

---

## 🧭 Conclusão - Microsserviços

Os **padrões de microsserviços** garantem **independência, resiliência, escalabilidade e observabilidade**. Usados em conjunto com os **padrões arquiteturais** e **de integração**, formam a base para sistemas modernos e robustos.

---

# 🧠 Padrões Avançados para Arquitetos e Tech Leads

> Conjunto de práticas e padrões além do básico de microsserviços, voltados a arquiteturas modernas com foco em **back-end, dados e front-end**.

---

## 🔩 Backend e Integração

### 🎯 Event-Driven Architecture (EDA)
Sistemas reativos baseados em eventos, promovendo baixo acoplamento e escalabilidade.  
**Exemplos:** microservices reagindo a eventos em Kafka, Pulsar ou SNS

### 📋 Command Pattern
Encapsula requisições como objetos, permitindo filas, reprocessamentos e auditoria.  
**Exemplos:** Command Handler em sistemas CQRS

### 📤 Outbox Pattern
Garante consistência entre banco e envio de eventos (solução para o "dual write problem").  
**Exemplos:** Gravar evento e dado na mesma transação e depois publicar via worker

### 🔐 Idempotency Pattern
Evita efeitos colaterais em operações repetidas, essencial em sistemas distribuídos.  
**Exemplos:** API de pagamento com idempotency key

### 🎵 API Composition Layer
Camada intermediária que orquestra múltiplos microsserviços para simplificar o consumo por clientes.  
**Exemplos:** GraphQL Gateway, API Composer

### 📊 GraphQL Federation
Divide o schema GraphQL em múltiplos subgrafos mantidos por equipes diferentes.  
**Exemplos:** Apollo Federation

### ⚡ Serverless Pattern
Divide responsabilidades em funções menores com escalabilidade automática.  
**Exemplos:** AWS Lambda, Azure Functions

---

## 🧮 Padrões e Arquitetura de Dados

### 🌐 Data Mesh
Arquitetura distribuída de dados baseada em domínios (autonomia + governança).  
**Exemplos:** cada domínio tem seu próprio "data product"

### 🏛️ Data Lakehouse
Combina flexibilidade de Data Lakes com estrutura de Data Warehouses.  
**Exemplos:** Delta Lake, Apache Iceberg, Snowflake

### 📝 Change Data Capture (CDC)
Captura mudanças em tempo real nos bancos e envia para streams.  
**Exemplos:** Debezium, StreamSets, Kafka Connect

### 📊 Lambda Architecture
Combina processamento batch + stream para análises completas e em tempo real.  
**Exemplos:** Hadoop + Spark Streaming

### 🔄 Kappa Architecture
Processamento totalmente baseado em streams, simplificando pipelines.  
**Exemplos:** Kafka Streams, Flink

### 📋 Domain Data Contracts
Define contratos de dados entre domínios para garantir qualidade e versionamento.  
**Exemplos:** Avro Schema Registry, Protocol Buffers

---

## 🎨 Frontend Patterns

### 🧩 Micro Frontends
Divide o front-end em módulos independentes, alinhados com os domínios de negócio.  
**Exemplos:** cada time entrega seu microfrontend via Module Federation

### 📱 BFF (Backend for Frontend)
APIs específicas para cada tipo de cliente (mobile, web, IoT).  
**Exemplos:** Node.js ou GraphQL resolvers dedicados ao front

### 🎨 Design System / Component Library
Define padrões visuais e comportamentais reutilizáveis entre projetos.  
**Exemplos:** Storybook + Figma Tokens

### 📲 Progressive Web Apps (PWA)
Aplicações web com comportamento de app nativo (offline, push, installable).  
**Exemplos:** React + Workbox

### ⚡ SSR / SSG / ISR
Renderização híbrida para performance e SEO.  
**Exemplos:** Next.js (Static, Server-side ou Incremental Regeneration)

---

## ☁️ Infraestrutura, Entrega e Observabilidade

### 🔢 Twelve-Factor App
12 princípios para construir aplicações cloud-native.  
**Exemplos:** separação de configs, logs, processos stateless, etc

### 📦 GitOps
Fluxos de deploy e configuração controlados por versionamento.  
**Exemplos:** ArgoCD, Flux

### 🏗️ Infrastructure as Code (IaC)
Infra gerenciada como código versionado.  
**Exemplos:** Terraform, Pulumi

### 🐵 Chaos Engineering
Injeta falhas propositais para validar resiliência.  
**Exemplos:** Chaos Monkey, Gremlin

### 📋 Policy as Code
Automatiza regras de segurança e compliance.  
**Exemplos:** Open Policy Agent (OPA), Kyverno

### 📊 Observability-Driven Development (ODD)
Desenhar sistemas já pensando em métricas, logs e traces como parte do design.  
**Exemplos:** OpenTelemetry + Grafana + Tempo

---

## 🧭 Arquitetura Organizacional e Estratégica

### 🎯 Domain-Driven Design (DDD)
Base conceitual para dividir domínios e projetar microsserviços de forma coerente.  
**Exemplos:** Context Maps, Aggregates, Entities, Value Objects

### 🏛️ Hexagonal Architecture (Ports and Adapters)
Isola lógica de negócio das dependências externas.  
**Exemplos:** Camadas "core", "adapters", "ports"

### 🏢 Clean Architecture
Organiza camadas em círculos concêntricos, invertendo dependências.  
**Exemplos:** domínio no centro, frameworks na borda

### 🧅 Onion Architecture
Similar à Clean, reforça separação entre domínio e infraestrutura.

### 📝 Event Storming
Workshop colaborativo para mapear fluxos de domínio e identificar bounded contexts.  
**Exemplos:** sessões com post-its amarelos e laranjas 😄

### 👥 Team Topologies
Modelo organizacional que alinha times aos fluxos de valor e padrões de comunicação.  
**Exemplos:** Stream-aligned teams + Platform teams

### 🔄 Evolutionary Architecture
Permite que o sistema mude de forma incremental, guiado por métricas e fitness functions.  
**Exemplos:** métricas automatizadas que avaliam acoplamento, latência, etc

---

## 🏁 Conclusão

Esses padrões representam o **nível sênior/arquitetural moderno** — onde técnica e estratégia se unem:

- **Backend:** resiliência, consistência e orquestração  
- **Dados:** governança, streaming e produtos de dados  
- **Frontend:** modularidade e experiência unificada  
- **Infraestrutura:** automação e resiliência  
- **Organização:** times, domínios e evolução arquitetural  

> ⚙️ **Dominar esses padrões te coloca em outro patamar como arquiteto sênior**, conectando arquitetura técnica, organizacional e de produto.

---

## 📚 Estrutura do Repositório

```
design-patterns-arquiteturais/
├── aggregator/              # Padrão Aggregator com microsserviços
├── apigateway/              # API Gateway implementation
├── circuit_breaker/         # Circuit Breaker pattern
├── configuration/           # Configuration pattern
├── inbox-outbox-pattern/    # Inbox/Outbox pattern
├── lock-distribuido/        # Distributed Lock pattern
├── pub-sub-java-memory/     # Pub/Sub pattern (Java)
├── request-response/        # Request/Response pattern
├── sequence/                # Sequence pattern
├── webhook/                 # Webhook pattern
├── websocket/               # WebSocket pattern
├── patterns_azure.md        # Azure-specific patterns
└── README.md                # Este arquivo
```

---

## 🤝 Contribuições

Toda e qualquer contribuição é bem-vinda! Siga o padrão de branch `feature/**` e abra um Pull Request.

## 📄 Licença

Este projeto está sob a licença **MIT**. Veja o arquivo `LICENSE` para mais detalhes.

## 👤 Autor

**Daniel Augusto Smanioto**

---

**Última atualização:** 2026-07-14
