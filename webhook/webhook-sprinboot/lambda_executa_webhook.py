import requests

url = "http://localhost:8086/webhook"
headers = {
    "Content-Type": "application/json",
    "X-Webhook-Token": "meu-token-secreto"
}
payload = {
    "mensagem": "Ola, webhook!"
}

response = requests.post(url, json=payload, headers=headers)

print("Status code:", response.status_code)
print("Resposta:", response.text)