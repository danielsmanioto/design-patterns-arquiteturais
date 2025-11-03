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
