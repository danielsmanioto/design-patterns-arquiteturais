const express = require('express');
const axios   = require('axios');

const app = express();
const PORT = 3000;

const PESSOAS_URL = process.env.PESSOAS_URL || 'http://localhost:3001';
const CONTAS_URL  = process.env.CONTAS_URL  || 'http://localhost:3002';

/**
 * GET /agregado
 * Retorna todas as pessoas com suas respectivas contas agregadas.
 */
app.get('/agregado', async (req, res) => {
  try {
    const [pessoasResp, contasResp] = await Promise.all([
      axios.get(`${PESSOAS_URL}/pessoas`),
      axios.get(`${CONTAS_URL}/contas`),
    ]);

    const pessoas = pessoasResp.data;
    const contas  = contasResp.data;

    const resultado = pessoas.map(pessoa => ({
      ...pessoa,
      contas: contas.filter(c => c.pessoaId === pessoa.id),
    }));

    res.json(resultado);
  } catch (err) {
    res.status(502).json({ erro: 'Erro ao agregar dados', detalhes: err.message });
  }
});

/**
 * GET /agregado/:id
 * Retorna uma pessoa específica com suas contas.
 */
app.get('/agregado/:id', async (req, res) => {
  try {
    const id = req.params.id;

    const [pessoaResp, contasResp] = await Promise.all([
      axios.get(`${PESSOAS_URL}/pessoas/${id}`),
      axios.get(`${CONTAS_URL}/contas/pessoa/${id}`),
    ]);

    res.json({
      ...pessoaResp.data,
      contas: contasResp.data,
    });
  } catch (err) {
    const status = err.response?.status === 404 ? 404 : 502;
    res.status(status).json({ erro: 'Erro ao agregar dados', detalhes: err.message });
  }
});

app.listen(PORT, () => {
  console.log(`Serviço Aggregator rodando na porta ${PORT}`);
});
