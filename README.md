# Sengundo desafio conexa

### Requesitos

- java version: 17
- lombok
- SDK: graalvm-ce-17

### Configuração do projeto

OBS: Caso o projeto seja aberto no Intellij, basta clickar na renderização logo ao lado.


```mvn compile install```

<br />

### O que foi feito

Toda regra de negocio ficou na camada de servico, utilização de mapper foi posto nessa api, visto que
na api anterior nao tem.

A decisão de por mapper nesta seria para preservar dados sensives da entidade de banco, que nao podem
ser de forma alguma expostos.

[regras do desafio](https://www.psicologiaviva.com.br/desafios/backend.html)


Path do h2
http://localhost:8090/h2-console

Ja consumindo as informaçoes da primeira api, o segundo desafio pede que:

 - insira mais um item na listagem de filmes
 - Escrever a nova listagem de filmes no console da aplicação
 - Salvar a nova listagem de filmes em um banco de dados H2 Database
 - Implementação de testes unitários

<br />

## Informaçoes de acesso do H2

Preencher o painel do H2 com as informçoes abaixo,
basta acessar: [h2-data-base](http://localhost:8090/h2-console)

Driver Class: org.h2.Driver

JDBC URL: jdbc:h2:mem:testdb

User Name: desafioconexa

Password: desafioconexa

<br />

***OBS:*** Caso nao consiga logar no painel do H2, verifique se seu host
nao esta sendo bloqueado.

<br />

## Request curl

Segue exemplos abaixo

### POST
```
curl -d '{"title": "Filme para teste", "episode_id": 20, "director": "diretor teste", "release_date": "2023-05-19"}' -H 'Content-Type: application/json' http://localhost:8090/sky
```

Resposta:

```
http://localhost:8090/sky
{"id":1,"title":"Filme para teste","director":"diretor teste","episode_id":20,"release_date":"2023-05-19"}
```

<br />

### GET

```
curl http://localhost:8090/sky
```

Resposta:

```
[{"id":1,"title":"Filme para teste","director":"diretor teste","episode_id":20,"release_date":"2023-05-19"}]% 
```