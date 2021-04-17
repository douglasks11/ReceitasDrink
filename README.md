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
