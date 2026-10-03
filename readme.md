# UNILESTE API - Sistema de Matrícula Universitária

API RESTful desenvolvida para o processo de matrícula de alunos da UNILESTE (Universidade do Leste Paulista), permitindo o gerenciamento de cursos e matrículas

## 📋 Sobre o Projeto

Esta API foi desenvolvida para ser consumida pelo frontend existente da universidade, adicionando funcionalidades digitais ao site institucional. O sistema permite o gerenciamento de cursos e matrículas através de chamadas utilizando os endpoints

## 🚀 Funcionalidades

A API deve implementar os seguintes endpoints:

### Endpoints

- **Gerenciamento de Cursos**: Conjunto de endpoints para realizar as operações abaixo
  - Cadastro de curso
  - Leitura de curso
  - Alteração de curso
  - Deleção de curso (Não permitir a deleção se houver matrículas vinculadas)
  - Obter curso por ID
- **Gerenciamento de Matrículas**: Conjunto de endpoints para realizar as operações abaixo
  - Cadastro de matrícula
  - Leitura de matrícula
  - Alteração de matrícula
  - Deleção de matrícula
  - Obter matrícula por ID



## 📝 Especificações Técnicas

### API RESTful

Todos os endpoints deverão seguir o padrão REST utilizando o método HTTP correto, nomenclatura padrão das rotas e definição correta de códigos de retorno. 
Para os endpoint POST e PUT o corpo da requisição deverá ter o seguinte formato

Curso:
``` 
{
  "id": 0,
  "nome": "Curso",
  "valor": 1000.0
}
```

Matrícula:
```
{
  "id": 0
  "nome": "Fulano de Tal"
  "email": "fulano@unoeste.br",
  "cep": "1900-000",
  "endereco": "Rua dos bobos, Número 0",
  "bairro": "Bairro Teste",
  "cidade": "Presidente Prudente",
  "uf": "SP",
  "cursando": "S",
  "curso": {
    id: 1
  }
}
```



## 📚 Documentação

Todos os endpoints devem estar documentados com:
- Tag
- Sumário
- Corpo da requisição (quando aplicável)
- Códigos de reposta


## 🏁 Como Iniciar

1. Clone este repositório
2. Instale as dependências com `npm install`
3. Configure o banco de dados utilizando o script fornecido
4. Inicie o servidor com `npm start`
