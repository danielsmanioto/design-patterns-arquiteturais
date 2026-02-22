const express = require('express');

const app = express();
const PORT = 3002;

const contas = [
  { id: 101, pessoaId: 1, tipo: 'corrente', saldo: 1500.00 },
  { id: 102, pessoaId: 1, tipo: 'poupança', saldo: 3200.50 },
  { id: 103, pessoaId: 2, tipo: 'corrente', saldo: 800.00  },
  { id: 104, pessoaId: 3, tipo: 'corrente', saldo: 4500.75 },
];

app.get('/contas', (req, res) => {
  res.json(contas);
});

app.get('/contas/pessoa/:pessoaId', (req, res) => {
  const pessoaId = Number(req.params.pessoaId);
  const contasDaPessoa = contas.filter(c => c.pessoaId === pessoaId);
  res.json(contasDaPessoa);
});

app.listen(PORT, () => {
  console.log(`Serviço Contas rodando na porta ${PORT}`);
});
