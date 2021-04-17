# receitas-drinks
> Este projeto é um Back For Front da aplicação receitas-drinks


![](../header.png)

## Instalação

### Service-Discovery

entre na pasta service-discovery e execute os comandos abaixo:

`mvn clean install`

`mvn spring-boot:run`


### Gateway

entre na pasta gateway e execute os comandos abaixo:

`mvn clean install`

`mvn spring-boot:run -Dspring-boot.run.profiles=dev`  (se passar o profile de `dev`, o gateway irá deixar passar qualquer requisição sem nenhuma segurança)

caso queira subir com a segurança ativa, basta rodar o comando 

`mvn spring-boot:run -Dspring-boot.run.profiles=prod`

### Aplicação

entre na pasta receitas-drinks e execute os comandos abaixo:

`mvn clean install`

`mvn spring-boot:run Dspring-boot.run.profiles=dev` (se passar o profile de `dev`, a aplicação irá carregar alguns registros de drinks default)

### Exemplo de uso

A aplicação é acessada via gateway que sobe na porta `5555`

Para verificar as rotas disponíveis, consulte o endpoint: `http://localhost:5555/actuator/routes`

Acessando a aplicação receitas-drinks via gateway: `http://localhost:5555/receitas-drinks/swagger-ui.html`

### Autenticação e Autorização

Autenticação e Autorização são realizadas na camada do Gateway, para se autenticar, você deve acessar o endpoint:

`POST http://localhost:5555/auth`

com o corpo:

` { "username": "seu_usuario", "password": "sua_senha" } `

você receberá um token JWT com o formato abaixo:

` { "authenticationToken": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36P" }`

sempre que for chamar um endpoint protegido, use o token JWT gerado no Header `Authorization` da requisição HTTP
