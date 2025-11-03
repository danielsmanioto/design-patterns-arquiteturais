# Design Patterns Arquiteturais e de Integração

Este documento lista os principais **padrões arquiteturais** e **de integração** utilizados em sistemas distribuídos, microsserviços e aplicações escaláveis.

---

## Configuration
Padrão para gerenciar configurações de forma centralizada e consistente entre serviços.  
**Exemplo:** Spring Cloud Config, Consul, etcd.

---

## Sequence
Representa a execução de passos coordenados, normalmente em fluxos de orquestração ou workflows.  
**Exemplo:** AWS Step Functions, Temporal.io, Camunda.

---

## Lock Distribuído
Mecanismo para evitar condições de corrida e garantir exclusividade em operações críticas em ambientes distribuídos.  
**Exemplo:** Redlock (Redis), Zookeeper.

---

## Circuit Breaker
Evita que falhas em um serviço se propaguem para outros, “abrindo o circuito” quando há erros sucessivos.  
**Exemplo:** Netflix Hystrix, Resilience4j.

---

## Pub/Sub
Padrão de comunicação assíncrona onde produtores publicam mensagens e consumidores as recebem por assinatura.  
**Exemplo:** Kafka, Google Pub/Sub, Redis Streams.

---

## Webhook
Permite a comunicação reativa entre sistemas via chamadas HTTP quando um evento ocorre.  
**Exemplo:** Notificação de pagamento (Stripe → seu backend).

---

## WebSocket
Canal de comunicação bidirecional e em tempo real entre cliente e servidor.  
**Exemplo:** Chats, dashboards, notificações ao vivo.

---

## Request/Response
Modelo clássico de comunicação síncrona entre cliente e servidor.  
**Exemplo:** REST, gRPC.

---

## Message Queue
Fila intermediária para desacoplar produtores e consumidores de mensagens.  
**Exemplo:** RabbitMQ, AWS SQS, ActiveMQ.

---

## Event Sourcing
Armazena o histórico completo de eventos que ocorreram, permitindo reconstruir o estado da aplicação.  
**Exemplo:** Axon Framework, Kafka + Snapshots.

---

## CQRS (Command Query Responsibility Segregation)
Separa operações de leitura (queries) e escrita (commands) para otimizar desempenho e escalabilidade.  
**Exemplo:** Leitura via cache, escrita via eventos.

---

## Saga Pattern
Coordena transações distribuídas em múltiplos serviços, garantindo consistência eventual.  
**Exemplo:** Orquestradas com Step Functions, coreografadas com eventos Kafka.

---

## API Gateway
Ponto único de entrada para múltiplos microsserviços, gerenciando autenticação, roteamento e segurança.  
**Exemplo:** Kong, NGINX, AWS API Gateway.

---

## Aggregator
Combina resultados de múltiplos serviços em uma única resposta agregada.  
**Exemplo:** API Gateway que chama vários microservices.

---

## Service Discovery
Permite que serviços encontrem e se comuniquem dinamicamente entre si.  
**Exemplo:** Eureka, Consul, Kubernetes DNS.

---

## Health Check
Verifica o status e a disponibilidade de serviços para orquestração e monitoramento.  
**Exemplo:** /health endpoint, Kubernetes livenessProbe.

---

## Retry / Timeout / Fallback
Padrões de resiliência que complementam o Circuit Breaker, controlando novas tentativas e respostas alternativas.  
**Exemplo:** Resilience4j Retry, Spring Retry.

---

## Bulkhead
Isola recursos (threads, conexões, instâncias) entre componentes para evitar falhas em cascata.  
**Exemplo:** Containers ou pools separados por serviço.

---

## Rate Limiting / Throttling
Controla a quantidade de requisições aceitas em um período para proteger o sistema de sobrecarga.  
**Exemplo:** API Gateway limitando 100 req/min.

---

## Load Balancer
Distribui requisições entre várias instâncias de um serviço.  
**Exemplo:** NGINX, HAProxy, AWS ALB.

---

## Centralized Logging
Coleta e consolida logs de vários serviços em um único ponto de análise.  
**Exemplo:** ELK Stack (Elasticsearch, Logstash, Kibana).

---

## Distributed Tracing
Rastreia o fluxo de requisições entre microsserviços para diagnóstico e monitoramento.  
**Exemplo:** OpenTelemetry, Jaeger, Zipkin.

---

## Sidecar Pattern
Executa componentes auxiliares (proxy, logging, métricas) ao lado do serviço principal, compartilhando o mesmo host/pod.  
**Exemplo:** Envoy Proxy, Istio Sidecar.

---

## Adapter / Facade
Encapsula integrações externas, simplificando e padronizando a comunicação.  
**Exemplo:** Classe Adapter para API de terceiros.

---

## Dependency Injection
Padrão interno de código para gerenciar dependências de forma desacoplada e configurável.  
**Exemplo:** Spring Framework, Dagger, Guice.

---

## Observabilidade
Abrange logs, métricas e traces para garantir visibilidade total do comportamento do sistema.  
**Exemplo:** Prometheus, Grafana, OpenTelemetry.

---

# 🧭 Conclusão
Esses padrões ajudam a construir sistemas **resilientes, escaláveis e desacoplados**, essenciais em ambientes de **microsserviços e arquiteturas distribuídas**.

--
# 🧩 Padrões de Microsserviços

Os **padrões de microsserviços** ajudam a estruturar sistemas compostos por múltiplos serviços independentes, escaláveis e de fácil manutenção.  
Eles tratam desde o **design dos serviços** até **observabilidade, segurança e deploy**.

---

## Single Responsibility
Cada microsserviço deve ter uma responsabilidade clara e única, reduzindo o acoplamento e facilitando a evolução independente.  
**Exemplo:** um serviço apenas para autenticação, outro apenas para cobrança.

---

## Bounded Context
Baseado em DDD (Domain-Driven Design). Cada serviço representa um **contexto delimitado** do domínio.  
**Exemplo:** “Pagamento”, “Entrega”, “Catálogo” — cada um com suas próprias entidades e regras.

---

## Database per Service
Cada microsserviço tem seu próprio banco de dados, evitando acoplamento e promovendo autonomia.  
**Exemplo:** Serviço de pedidos com PostgreSQL; serviço de clientes com MongoDB.

---

## API Gateway
Ponto único de entrada para os microsserviços, tratando autenticação, roteamento, cache e rate limiting.  
**Exemplo:** Kong, NGINX, Traefik, AWS API Gateway.

---

## Service Discovery
Permite que microsserviços se encontrem dinamicamente sem depender de URLs fixas.  
**Exemplo:** Netflix Eureka, Consul, Kubernetes DNS.

---

## Config Server
Centraliza configurações para múltiplos microsserviços, com atualização dinâmica.  
**Exemplo:** Spring Cloud Config, Consul KV.

---

## Circuit Breaker
Evita falhas em cascata ao interromper chamadas para serviços que estão instáveis.  
**Exemplo:** Resilience4j, Hystrix.

---

## Saga Pattern
Gerencia **transações distribuídas**, garantindo consistência eventual entre múltiplos serviços.  
**Exemplo:** Orquestração via workflow (Step Functions, Temporal.io) ou coreografia via eventos (Kafka).

---

## CQRS
Separa comandos (escritas) de queries (leituras), melhorando escalabilidade e desempenho.  
**Exemplo:** gravação via eventos e leitura via projeções otimizadas.

---

## Event Sourcing
Registra todas as mudanças como eventos, permitindo reconstruir o estado atual do sistema.  
**Exemplo:** Kafka + snapshots, Axon Framework.

---

## Strangler Fig Pattern
Migra sistemas monolíticos para microsserviços de forma incremental, substituindo partes aos poucos.  
**Exemplo:** Novo serviço intercepta rotas do monólito até substituí-lo completamente.

---

## API Composition / Aggregator
Combina dados de múltiplos microsserviços em uma única resposta.  
**Exemplo:** Serviço “Order Summary” que junta informações de clientes, pagamentos e produtos.

---

## Backend for Frontend (BFF)
Cria uma API específica para cada tipo de cliente (web, mobile, IoT), otimizando payloads e performance.  
**Exemplo:** BFF para app mobile e outro para web.

---

## Service Mesh
Camada de infraestrutura que gerencia comunicação, segurança e observabilidade entre serviços.  
**Exemplo:** Istio, Linkerd, Consul Connect.

---

## Sidecar Pattern
Executa componentes auxiliares (proxy, logs, métricas) junto com o serviço principal no mesmo pod/container.  
**Exemplo:** Envoy Proxy com cada microsserviço.

---

## Bulkhead
Isola recursos por serviço ou função, impedindo que a falha de um componente afete os demais.  
**Exemplo:** pools de threads separados para cada integração.

---

## Retry / Timeout / Fallback
Define políticas de repetição e tempo limite em chamadas remotas, evitando travamentos e degradação.  
**Exemplo:** Retry automático com backoff exponencial.

---

## Distributed Tracing
Permite rastrear requisições entre microsserviços para entender o fluxo completo e medir latência.  
**Exemplo:** Jaeger, Zipkin, OpenTelemetry.

---

## Centralized Logging
Consolida logs de todos os serviços em um único ponto de análise.  
**Exemplo:** ELK Stack (Elasticsearch, Logstash, Kibana), Loki + Grafana.

---

## Health Check / Heartbeat
Endpoints e mecanismos para verificar o estado de cada serviço.  
**Exemplo:** `/health` endpoint, Kubernetes `livenessProbe`.

---

## Canary Release
Implanta uma nova versão de serviço para uma pequena parcela dos usuários antes do rollout completo.  
**Exemplo:** 5% do tráfego com nova versão.

---

## Blue-Green Deployment
Mantém duas versões do ambiente (Blue e Green) para alternar releases sem downtime.  
**Exemplo:** Kubernetes com dois deployments ativos.

---

## Feature Toggle
Ativa ou desativa recursos sem necessidade de deploy, facilitando experimentos e rollbacks.  
**Exemplo:** LaunchDarkly, Unleash.

---

## Observability
Combina métricas, logs e traces para oferecer visibilidade completa sobre o comportamento dos microsserviços.  
**Exemplo:** Prometheus, Grafana, OpenTelemetry.

---

## Security Patterns
Define estratégias de autenticação, autorização e comunicação segura entre serviços.  
**Exemplo:** OAuth2, mTLS, JWT, API Keys.

---

## API Versioning
Permite evolução das APIs sem quebrar compatibilidade com versões antigas.  
**Exemplo:** `/v1/users`, `/v2/users`.

---

# 🧭 Conclusão

Os **padrões de microsserviços** garantem **independência, resiliência, escalabilidade e observabilidade**.  
Usados em conjunto com os **padrões arquiteturais** e **de integração**, formam a base para sistemas modernos e robustos.


# 🧠 Padrões Avançados para Arquitetos e Tech Leads

> Conjunto de práticas e padrões além do básico de microsserviços, voltados a arquiteturas modernas com foco em **back-end, dados e front-end**.

---

## 🔩 Backend e Integração

### Event-Driven Architecture (EDA)
Sistemas reativos baseados em eventos, promovendo baixo acoplamento e escalabilidade.  
**Exemplo:** microservices reagindo a eventos em Kafka, Pulsar ou SNS.

### Command Pattern
Encapsula requisições como objetos, permitindo filas, reprocessamentos e auditoria.  
**Exemplo:** Command Handler em sistemas CQRS.

### Outbox Pattern
Garante consistência entre banco e envio de eventos (solução para o “dual write problem”).  
**Exemplo:** Gravar evento e dado na mesma transação e depois publicar via worker.

### Idempotency Pattern
Evita efeitos colaterais em operações repetidas, essencial em sistemas distribuídos.  
**Exemplo:** API de pagamento com idempotency key.

### API Composition Layer
Camada intermediária que orquestra múltiplos microsserviços para simplificar o consumo por clientes.  
**Exemplo:** GraphQL Gateway, API Composer.

### GraphQL Federation
Divide o schema GraphQL em múltiplos subgrafos mantidos por equipes diferentes.  
**Exemplo:** Apollo Federation.

### Serverless Pattern
Divide responsabilidades em funções menores com escalabilidade automática.  
**Exemplo:** AWS Lambda, Azure Functions.

---

## 🧮 Padrões e Arquitetura de Dados

### Data Mesh
Arquitetura distribuída de dados baseada em domínios (autonomia + governança).  
**Exemplo:** cada domínio tem seu próprio “data product”.

### Data Lakehouse
Combina flexibilidade de Data Lakes com estrutura de Data Warehouses.  
**Exemplo:** Delta Lake, Apache Iceberg, Snowflake.

### Change Data Capture (CDC)
Captura mudanças em tempo real nos bancos e envia para streams.  
**Exemplo:** Debezium, StreamSets, Kafka Connect.

### Lambda Architecture
Combina processamento batch + stream para análises completas e em tempo real.  
**Exemplo:** Hadoop + Spark Streaming.

### Kappa Architecture
Processamento totalmente baseado em streams, simplificando pipelines.  
**Exemplo:** Kafka Streams, Flink.

### Domain Data Contracts
Define contratos de dados entre domínios para garantir qualidade e versionamento.  
**Exemplo:** Avro Schema Registry, Protocol Buffers.

---

## 🎨 Frontend Patterns

### Micro Frontends
Divide o front-end em módulos independentes, alinhados com os domínios de negócio.  
**Exemplo:** cada time entrega seu microfrontend via Module Federation.

### BFF (Backend for Frontend)
APIs específicas para cada tipo de cliente (mobile, web, IoT).  
**Exemplo:** Node.js ou GraphQL resolvers dedicados ao front.

### Design System / Component Library
Define padrões visuais e comportamentais reutilizáveis entre projetos.  
**Exemplo:** Storybook + Figma Tokens.

### Progressive Web Apps (PWA)
Aplicações web com comportamento de app nativo (offline, push, installable).  
**Exemplo:** React + Workbox.

### SSR / SSG / ISR
Renderização híbrida para performance e SEO.  
**Exemplo:** Next.js (Static, Server-side ou Incremental Regeneration).

---

## ☁️ Infraestrutura, Entrega e Observabilidade

### Twelve-Factor App
12 princípios para construir aplicações cloud-native.  
**Exemplo:** separação de configs, logs, processos stateless, etc.

### GitOps
Fluxos de deploy e configuração controlados por versionamento.  
**Exemplo:** ArgoCD, Flux.

### Infrastructure as Code (IaC)
Infra gerenciada como código versionado.  
**Exemplo:** Terraform, Pulumi.

### Chaos Engineering
Injeta falhas propositais para validar resiliência.  
**Exemplo:** Chaos Monkey, Gremlin.

### Policy as Code
Automatiza regras de segurança e compliance.  
**Exemplo:** Open Policy Agent (OPA), Kyverno.

### Observability-Driven Development (ODD)
Desenhar sistemas já pensando em métricas, logs e traces como parte do design.  
**Exemplo:** OpenTelemetry + Grafana + Tempo.

---

## 🧭 Arquitetura Organizacional e Estratégica

### Domain-Driven Design (DDD)
Base conceitual para dividir domínios e projetar microsserviços de forma coerente.  
**Exemplo:** Context Maps, Aggregates, Entities, Value Objects.

### Hexagonal Architecture (Ports and Adapters)
Isola lógica de negócio das dependências externas.  
**Exemplo:** Camadas “core”, “adapters”, “ports”.

### Clean Architecture
Organiza camadas em círculos concêntricos, invertendo dependências.  
**Exemplo:** domínio no centro, frameworks na borda.

### Onion Architecture
Similar à Clean, reforça separação entre domínio e infraestrutura.

### Event Storming
Workshop colaborativo para mapear fluxos de domínio e identificar bounded contexts.  
**Exemplo:** sessões com post-its amarelos e laranjas 😄

### Team Topologies
Modelo organizacional que alinha times aos fluxos de valor e padrões de comunicação.  
**Exemplo:** Stream-aligned teams + Platform teams.

### Evolutionary Architecture
Permite que o sistema mude de forma incremental, guiado por métricas e fitness functions.  
**Exemplo:** métricas automatizadas que avaliam acoplamento, latência, etc.

---

# 🏁 Conclusão

Esses padrões representam o **nível sênior/arquitetural moderno** — onde técnica e estratégia se unem:

- Backend: resiliência, consistência e orquestração.  
- Dados: governança, streaming e produtos de dados.  
- Frontend: modularidade e experiência unificada.  
- Infra: automação e resiliência.  
- Organização: times, domínios e evolução arquitetural.

> ⚙️ **Dominar esses padrões te coloca em outro patamar como arquiteto sênior**, conectando arquitetura técnica, organizacional e de produto.
