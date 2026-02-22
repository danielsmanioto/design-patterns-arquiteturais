const express = require('express');

const app = express();
const PORT = 3001;

const pessoas = [
  { id: 1, nome: 'Alice Silva', email: 'alice@example.com' },
  { id: 2, nome: 'Bob Souza',   email: 'bob@example.com'   },
  { id: 3, nome: 'Carol Lima',  email: 'carol@example.com' },
];

app.get('/pessoas', (req, res) => {
  res.json(pessoas);
});

app.get('/pessoas/:id', (req, res) => {
  const pessoa = pessoas.find(p => p.id === Number(req.params.id));
  if (!pessoa) return res.status(404).json({ erro: 'Pessoa não encontrada' });
  res.json(pessoa);
});

app.listen(PORT, () => {
  console.log(`Serviço Pessoas rodando na porta ${PORT}`);
});
