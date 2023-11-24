# Baze

# Global Solution


## Endpoints

- Usuario

    - [Efetuar ](#login)
    - [Realizar ](#cadastrar)
    - [Atualizar ](#atualizar)
    - [Deletar ](#deletar)

- Bicicleta

    - [Listar](#listar_bicicleta)
    - [Inserir](#inserir_bicicleta)
    - [Atualizar](#atualizar_bicicleta)
    - [Deletar](#deletar_bicicleta)

- Corrida

    - [Listar ](#listar_corrida)
    - [Listar ](#listar_corrida)
    - [Registrar ](#registrar_corrida)
    - [Atualizar ](#atualizar_corrida)

- Desafio

    - [Listar  ](#listar_desafio)
    - [Cadastra ](#cadastrar_desafio)
    - [pesquisa ](#pesquisar_desafio)
    - [Atualizar ](#atualizar_desafio)
    - [Deletar ](#deletar_desafio)
    
- Endereço

    - [Cadastra Endereço](#cadastrar_endereco)
    - [Mostra endereços](#mostra_endereco)
    - [Atualizar endereço](#atualiza_endereco)
    - [Deletar endereço](#deleta_endereco)

- Registro

    - [Cadastra](#cadastrar_registro)
    - [Mostra](#mostra_registro)
    - [Atualizar](#atualiza_registro)
    - [Deletar](#deleta_registro)

- Telefone 

    - [Cadastra telefone ](#cadastrar_telefone)
    - [Mostra telefone ](#mostrar_telefone)
    - [Atualiza telefone ](#atualiza_telefone)
    - [Deleta Telefone ](#deletar_telefone)


---
### Descrição dos Endpoints

## Usuario

### Login

`GET` http://localhost:8080/api/usuarios/login

```js
{
    login: "matlencar",
    senha: "ola"
}
```
## Respostas que podem aparecer no GET :

| Código | Descrição |
|---|---|
| `200` | Requisição executada com sucesso (success).|
| `400` | Bad request|
| `404` | Registro pesquisado não encontrado (Not found).|
| `500` | Internal server error|
---
### Cadastrar
    
`POST` http://localhost:8080/api/usuarios

|    Campo     | Tipo | Obrigatorio | Descrição
|--------------|------|:-----------:|----------|
|     Nome     |String|     Sim     |Campo para preenchimento de nome do usuario
|     Email    |String|     Sim     |Campo obrigatorio para que o usuario possa se cadastrar
|     Login    |String|     Sim     |Campo obrigatoio para determinar nome do usuario na plataforma do APP 
|     Senha    |String|     Sim     |Campo obrigatorio para que o usuario tenha acesso a sua conta no APP
|     Idade    | int  |     Sim     |Campo obrigatorio para que o usuario tenha acesso a sua conta no APP
|      Rg      |String|     Sim     |É obrigatorio que o usuario informe em seu cadastro 
|     CPF      |String|     Sim     |É obrigatorio que o usuario informe em seu cadastro 
|     Genero   |String|     Sim     |Campo para inserir genero


```js
{
    "nome": "Julio",
    "email": "joao@email.com.br",
    "login": "joaozim",
    "senha": "ola",
    "idade": 18,
    "rg": "123255123",
    "cpf": "99955577712",
    "genero": "Masculino"
}
```
## Respostas que podem aparecer no POST :

| Código | Descrição |
|---|---|
| `201` | criado com sucesso (success)|
| `400` | Bad request|
| `401` | Dados de acesso inválidos|
| `404` | Registro pesquisado não encontrado (Not found)|
| `500` | Internal server error|
---
### Atualizar_Usuario

`PUT` http://localhost:8080/api/usuarios/{id}

|    Campo     | Tipo | Obrigatorio | Descrição
|--------------|------|:-----------:|----------|
|     Nome     |String|     Sim     |Campo para preenchimento de nome do usuario
|     Email    |String|     Sim     |Campo obrigatorio para que o usuario possa se cadastrar
|     Login    |String|     Sim     |Campo obrigatoio para determinar nome do usuario na plataforma do APP 
|     Senha    |String|     Sim     |Campo obrigatorio para que o usuario tenha acesso a sua conta no APP
|     Idade    | int  |     Sim     |Campo obrigatorio para que o usuario tenha acesso a sua conta no APP
|      Rg      |String|     Sim     |É obrigatorio que o usuario informe em seu cadastro 
|     CPF      |String|     Sim     |É obrigatorio que o usuario informe em seu cadastro 
|     Genero   |String|     Sim     |Campo para inserir genero

```js
{
    "nome": "Julio",
    "email": "joao@email.com.br",
    "login": "joaozim",
    "senha": "ola",
    "idade": 18,
    "rg": "123255123",
    "cpf": "99955577712",
    "genero": "Masculino"
}
```

## Respostas que podem aparecer no PUT :

| Código | Descrição |
|---|---|
| `201` | criado com sucesso (success)|
| `400` | Bad request|
| `401` | Dados de acesso inválidos|
| `404` | Registro pesquisado não encontrado (Not found)|
| `500` | Internal server error|
---

### Deletar_Usuario
`DELETE` /localhost/api/usuarios/{id}


```js
    {
        id: "1"
    }
```

## Respostas que podem aparecer no DELETE :

| Código | Descrição |
|---|---|
| `204` | Requisição executada com sucesso (success).|
| `400` | Erros de validação ou os campos informados não existem no sistema|
| `401` | Dados de acesso inválidos|
| `404` | Registro pesquisado não encontrado (Not found)|
| `405` | Método não implementado.|
| `500` | Internal server error|
---

## Bicicleta

### Listar_Bicicleta

`GET` http://localhost:8080/api/bicicletas

```js
{
    id:1
    aro: "15",
    quadro: 12,
    peso: "M",
    cor: "Vermelha",
    tipo: "Bicicleta mountain bike",
    marcha: 6
}
```
## Respostas que podem aparecer no GET :

| Código | Descrição |
|---|---|
| `200` | Requisição executada com sucesso (success).|
| `400` | Bad request|
| `404` | Registro pesquisado não encontrado (Not found).|
| `500` | Internal server error|
---
### Inserir_Categoria

`POST` /localhost/api/bicicletas

|    Campo     | Tipo | Obrigatorio | Descrição
|--------------|------|:-----------:|----------|
|     Aro      |String|     Sim     |Campo para preenchiment para informçoes da bicicleta
|   Quadro     |String|     Sim     |Campo para preenchimento das descrição da bicicleta
|     Peso     |String|     Sim     |Campo para preenchiment para informçoes da bicicleta
|   Altura     |String|     Sim     |Campo para preenchimento das descrição da bicicleta
|     Cor      |String|     Sim     |Campo para preenchiment para informçoes da bicicleta
|   Tipo       |String|     Sim     |Campo para preenchimento das descrição da bicicleta
|   Marcha     |String|     Sim     |Campo para preenchimento das descrição da bicicleta

```js
{
    "aro": "15",
    "quadro": 12,
    "peso": "M",
    "cor": "Vermelha",
    "tipo": "Bicicleta mountain bike",
    "marcha": 6
}

```
## Respostas que podem aparecer no POST :

| Código | Descrição |
|---|---|
| `201` | criado com sucesso (success)|
| `400` | Bad request|
| `401` | Dados de acesso inválidos.|
| `404` | Registro pesquisado não encontrado (Not found)|
| `500` | Internal server error|
---
### Atualizar_Bicicleta

`PUT` /localhost/api/bicicletas

|    Campo     | Tipo | Obrigatorio | Descrição
|--------------|------|:-----------:|----------|
|     Aro      |String|     Sim     |Campo para preenchiment para informçoes da bicicleta
|   Quadro     |String|     Sim     |Campo para preenchimento das descrição da bicicleta
|     Peso     |String|     Sim     |Campo para preenchiment para informçoes da bicicleta
|   Altura     |String|     Sim     |Campo para preenchimento das descrição da bicicleta
|     Cor      |String|     Sim     |Campo para preenchiment para informçoes da bicicleta
|   Tipo       |String|     Sim     |Campo para preenchimento das descrição da bicicleta
|   Marcha     |String|     Sim     |Campo para preenchimento das descrição da bicicleta

```js
{
    "aro": "15",
    "quadro": 12,
    "peso": "M",
    "cor": "Vermelha",
    "tipo": "Bicicleta mountain bike",
    "marcha": 6
}

```
## Respostas que podem aparecer no PUT :

| Código | Descrição |
|---|---|
| `201` | criado com sucesso (success)|
| `400` | Bad request|
| `401` | Dados de acesso inválidos.|
| `404` | Registro pesquisado não encontrado (Not found)|
| `500` | Internal server error|
---
### Deletar_Bicicleta

`DELETE` /localhost/api/bicicletas/{id}


```js
    {
        id: "1"
    }
```

## Respostas que podem aparecer no DELETE :

| Código | Descrição |
|---|---|
| `204` | Requisição executada com sucesso (success).|
| `400` | Erros de validação ou os campos informados não existem no sistema|
| `401` | Dados de acesso inválidos|
| `404` | Registro pesquisado não encontrado (Not found)|
| `500` | Internal server error|
---
## Corrida

### Listar_corrida
`GET` /localhost/api/corridas/

```js
   {
    id:"1",
    km: 10.0,
    tempo: 12.00
}
```

## Respostas que podem aparecer no GET :

| Código | Descrição |
|---|---|
| `200` | Requisição executada com sucesso (success).|
| `400` | Bad request|
| `404` | Registro pesquisado não encontrado (Not found).|
| `500` | Internal server error|

---
### Listar__Usuario
`GET` /localhost/api/corridas/{id}
```js
   {
    id:"1",
    km: 10.0,
    tempo: 12.00
}
```
## Respostas que podem aparecer no GET :

| Código | Descrição |
|---|---|
| `200` | Requisição executada com sucesso (success).|
| `400` | Bad request|
| `404` | Registro pesquisado não encontrado (Not found).|
| `500` | Internal server error|
---

### Registrar_corrida
`POST` /localhost/api/corridas

|    Campo     | Tipo | Obrigatorio | Descrição
|--------------|------|:-----------:|----------|
|      Km      |String|     Sim     | conta quilometros
|     tempo    |String|     Sim     | Registro da hora da corrida

```js
{
    "km": 10.0,
    "tempo": 12.00
}
```

## Respostas que podem aparecer no POST :

| Código | Descrição |
|---|---|
| `201` | criado com sucesso (success)|
| `400` | Bad request|
| `401` | Dados de acesso inválidos.|
| `404` | Registro pesquisado não encontrado (Not found)|
| `500` | Internal server error|
---

### Atualizar_corrida
`PUT` /localhost/api/corridas/{id}

|    Campo     | Tipo | Obrigatorio | Descrição
|--------------|------|:-----------:|----------|
|      Km      |String|     Sim     | conta quilometros
|     tempo    |String|     Sim     | Registro da hora da corrida

```js
{
    "km": 10.0,
    "tempo": 12.00
}
```

## Respostas que podem aparecer no PUT :

| Código | Descrição |
|---|---|
| `201` | criado com sucesso (success)|
| `400` | Bad request|
| `401` | Dados de acesso inválidos.|
| `404` | Registro pesquisado não encontrado (Not found)|
| `500` | Internal server error|
---

## Desafio

### Listar_Desafio
`GET` /localhost/api/desafios

```Js
{
    "nome": "Corrida de 6km",
    "descricao": "Objetivo e realizar uma pedalada de 8km durante a semana",
    "tempo": "10:00 minutos",
    "recompensa": "Vupom da decathlon"
}
```

## Respostas que podem aparecer no GET :

| Código | Descrição |
|---|---|
| `201` | criado com sucesso (success)|
| `400` | Bad request|
| `401` | Dados de acesso inválidos.|
| `404` | Registro pesquisado não encontrado (Not found)|
| `500` | Internal server error|
---

### Cadastrar_Desafio
`POST` /localhost/api/desafios
|    Campo     | Tipo | Obrigatorio | Descrição
|--------------|------|:-----------:|----------|
|   Nome       |String|     Sim     |Necessario para cadastrar um desafio
| descricao    |String|     Sim     |Necessario para cadastrar um desafio
|   tempo      |String|     Sim     |Necessario para cadastrar um desafio
| recompensa   |String|     Sim     |Necessario para cadastrar um desafio


```Js
{
    "nome": "Corrida de 6km",
    "descricao": "Objetivo e realizar uma pedalada de 8km durante a semana",
    "tempo": "10:00 minutos",
    "recompensa": "Vupom da decathlon"
}
```

## Respostas que podem aparecer no POST :

| Código | Descrição |
|---|---|
| `201` | criado com sucesso (success)|
| `400` | Bad request|
| `401` | Dados de acesso inválidos.|
| `404` | Registro pesquisado não encontrado (Not found)|
| `500` | Internal server error|
---

### Pesquisar_Desafio
`GET` /localhost/api/desafios/{id}
```Js

{
    "nome": "Corrida de 6km",
    "descricao": "Objetivo e realizar uma pedalada de 8km durante a semana",
    "tempo": "10:00 minutos",
    "recompensa": "Vupom da decathlon"
}

```

## Respostas que podem aparecer no GET :

| Código | Descrição |
|---|---|
| `201` | criado com sucesso (success)|
| `400` | Bad request|
| `401` | Dados de acesso inválidos.|
| `404` | Registro pesquisado não encontrado (Not found)|
| `500` | Internal server error|
---

### Atualizar_Desafio
`PUT` /localhost/api/desafios/{id}
|    Campo     | Tipo | Obrigatorio | Descrição
|--------------|------|:-----------:|----------|
|   Nome       |String|     Sim     |Necessario para cadastrar uma empresa
| Razão Social |String|     Sim     |Necessario para cadastrar uma empresa


```Js
{
    "nome": "Corrida de 6km",
    "descricao": "Objetivo e realizar uma pedalada de 8km durante a semana",
    "tempo": "10:00 minutos",
    "recompensa": "Vupom da decathlon"
}
```

## Respostas que podem aparecer no PUT :

| Código | Descrição |
|---|---|
| `201` | criado com sucesso (success)|
| `400` | Bad request|
| `401` | Dados de acesso inválidos.|
| `404` | Registro pesquisado não encontrado (Not found)|
| `500` | Internal server error|
---

### Deletar_desafio
`DELETE` /localhost/api/desafio/{id}

```js
    {
        id: "1"
    }
```
## Respostas que podem aparecer no DELETE :

| Código | Descrição |
|---|---|
| `204` | Requisição executada com sucesso (success)|
| `400` | Erros de validação ou os campos informados não existem no sistema|
| `401` | Dados de acesso inválidos|
| `404` | Registro pesquisado não encontrado (Not found)|
| `405` | Método não implementado.|
| `500` | Internal server error|
---
## Endereço

### Cadastrar_Endereco
`POST` /localhost/api/enderecos/{id}

|    Campo     | Tipo | Obrigatorio | Descrição
|--------------|------|:-----------:|----------|
|   CEP   |String| sim | Código de endereço postal usado para localizar a residência
| Logradouro |String|     Sim     |Necessario para cadastrar um endereço para um usuario
| Bairro | String | sim | nescessário para cadastrar do endereço do usuario
| Cidade | String | sim | nescessário para cadastrar do endereço do usuario
| Pais | String | sim | nescessário para cadastrar do endereço do usuario
| Numero | int | sim | Se refere ao numero da residência
| Complemento | String | sim | Aqui há uma pequena descrição para ajudar a localizar a residência 

```JS
{
    "id": 1
    "logradouro": "Rua jose azevedo",
    "numero": 1402,
    "bairro": "Jardins",
    "cidade": "São Paulo",
    "pais": "Brasil",
    "cep": "04555310",
    "complemento": "N/A"
}
```

## Respostas que podem aparecer no POST :

| Código | Descrição |
|---|---|
| `204` | Requisição executada com sucesso (success)|
| `400` | Erros de validação ou os campos informados não existem no sistema|
| `401` | Dados de acesso inválidos|
| `404` | Registro pesquisado não encontrado (Not found)|
| `405` | Método não implementado.|
| `500` | Internal server error|
---

### Mostra_Endereco
`GET` /localhost/api/enderecos/{id}
```JS
{
    "id": 1
    "logradouro": "Rua jose azevedo",
    "numero": 1402,
    "bairro": "Jardins",
    "cidade": "São Paulo",
    "pais": "Brasil",
    "cep": "04555310",
    "complemento": "N/A"
}
```

## Respostas que podem aparecer no GET :

| Código | Descrição |
|---|---|
| `204` | Requisição executada com sucesso (success)|
| `400` | Erros de validação ou os campos informados não existem no sistema|
| `401` | Dados de acesso inválidos|
| `404` | Registro pesquisado não encontrado (Not found)|
| `405` | Método não implementado.|
| `500` | Internal server error|
---

### Atualiza_Endereco
`PUT` /localhost/api/enderecos/{id}

|    Campo     | Tipo | Obrigatorio | Descrição
|--------------|------|:-----------:|----------|
|   CEP   |String| sim | Código de endereço postal usado para localizar a residência
| Logradouro |String|     Sim     |Necessario para cadastrar um endereço para um usuario
| Bairro | String | sim | nescessário para cadastrar do endereço do usuario
| Cidade | String | sim | nescessário para cadastrar do endereço do usuario
| Pais | String | sim | nescessário para cadastrar do endereço do usuario
| Numero | int | sim | Se refere ao numero da residência
| Complemento | String | sim | Aqui há uma pequena descrição para ajudar a localizar a residência 

```JS
{
    "id": 1
    "logradouro": "Rua jose azevedo",
    "numero": 1402,
    "bairro": "Jardins",
    "cidade": "São Paulo",
    "pais": "Brasil",
    "cep": "04555310",
    "complemento": "N/A"
}
```
## Respostas que podem aparecer no PUT :

| Código | Descrição |
|---|---|
| `204` | Requisição executada com sucesso (success)|
| `400` | Erros de validação ou os campos informados não existem no sistema|
| `401` | Dados de acesso inválidos|
| `404` | Registro pesquisado não encontrado (Not found)|
| `405` | Método não implementado.|
| `500` | Internal server error|
---

### Deleta_Endereco
`DELETE` /localhost/api/enderecoCliente/{id}
```js
    {
        id: "1"
    }
```

## Respostas que podem aparecer no DELETE :

| Código | Descrição |
|---|---|
| `204` | Requisição executada com sucesso (success)|
| `400` | Erros de validação ou os campos informados não existem no sistema|
| `401` | Dados de acesso inválidos|
| `404` | Registro pesquisado não encontrado (Not found)|
| `405` | Método não implementado.|
| `500` | Internal server error|

---
## Registro
### Cadastrar_registro
`POST` /localhost/api/registro

|    Campo     | Tipo | Obrigatorio | Descrição
|--------------|------|:-----------:|----------|
| horaRegistro |String|     Sim     | Necessario para cadastrar registro da corrida feita pelo usuario


```JS
{
    "horaRegistro": "12:30"
}

```
## Respostas que podem aparecer no POST :

| Código | Descrição |
|---|---|
| `204` | Requisição executada com sucesso (success)|
| `400` | Erros de validação ou os campos informados não existem no sistema|
| `401` | Dados de acesso inválidos|
| `404` | Registro pesquisado não encontrado (Not found)|
| `405` | Método não implementado.|
| `500` | Internal server error|
---

### Mostra_Endereco
`GET` /localhost/api/registros/{id}
```JS
{
    id:1
    "horaRegistro": "12:30"
}
```
## Respostas que podem aparecer no GET :

| Código | Descrição |
|---|---|
| `204` | Requisição executada com sucesso (success)|
| `400` | Erros de validação ou os campos informados não existem no sistema|
| `401` | Dados de acesso inválidos|
| `404` | Registro pesquisado não encontrado (Not found)|
| `405` | Método não implementado|
| `500` | Internal server error|
---
### Atualiza_Endereco_Empresa
`PUT` /localhost/api/registro/{id}

|    Campo     | Tipo | Obrigatorio | Descrição
|--------------|------|:-----------:|----------|
| horaRegistro |String|     Sim     | Necessario para cadastrar registro da corrida feita pelo usuario

```JS
{
    id:1
    "horaRegistro": "12:30"
}
```
## Respostas que podem aparecer no PUT :

| Código | Descrição |
|---|---|
| `204` | Requisição executada com sucesso (success)|
| `400` | Erros de validação ou os campos informados não existem no sistema|
| `401` | Dados de acesso inválidos|
| `404` | Registro pesquisado não encontrado (Not found)|
| `405` | Método não implementado.|
| `500` | Internal server error|
---
### Deleta_registro
`DELETE` /localhost/api/registros/{id}
```js
    {
        id: "1"
    }
```


### `Integrantes`

```js
        André Massao Nakamura RM93046

        Andrea Madureira RM95489

        Erick de Luca Pereira RM94554

        Matheus Alencar Silva RM94642

        Pedro Henrique Sanagiotto RM93182

```
