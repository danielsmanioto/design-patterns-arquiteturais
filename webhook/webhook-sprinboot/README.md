# WEBHOOK 

O que é um Webhook?
Um webhook é um endpoint HTTP (por exemplo, /webhook) criado para receber notificações automáticas de outro sistema quando algum evento acontece.

Exemplo: O GitHub envia uma requisição para o seu /webhook toda vez que alguém faz um push em um repositório.
Você não pede nada: Você só espera receber. O outro sistema te avisa quando algo acontece.

# Fluxo desenvolvido 

Rota implementada para receber de uma aplicacao terceira 
o sistema terceiro vai invocar a rota http://localhost:8086/webhook
e com isto nosso sistema sabera o que fazer. 

## Tecnologias
- JAVA25
- SPRING BOOT

## Testando 
curl -X POST http://localhost:8086/webhook \
-H "Content-Type: application/json" \
-H "X-Webhook-Token: meu-token-secreto" \
-d '{"mensagem":"Olá, webhook!"}'


# Testando via python
1. suba a aplicacao spring 
2. pip3 install requests
2. execute a aplicacao python 
3. python3 lambda_executa_webhook.py 