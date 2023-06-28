# Lojinha API Automação
Esse é um repositório que contém a automação de alguns teste de API Rest de um software denominado Lojinha. os sub-tópicos abaixo descrevem algumas decisões tomadas na estruturação do projeto.

## Tecnologias Utilizadas
. Java
oracle.com/java/technologies/javase/jdk18-archive-downloads.html
. JUnit
https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-engine/5.9.1
. Rest Assured
https://mvnrepository.com/artifact/io.rest-assured/rest-assured/5.2.0
. Maven
https://maven.apache.org/

## Testes Automatizados
Teste para validar as partições de equivalência relacionadas ao valor do produto na Lojinha, que estão relacionadas diretamente à regra de negócio que diz que o valor do produto deve estar entre R$ 0,01 e R$ 7000,00.

## Notas Gerais
- Sempre utilizamos a notação Before Each para capturar o token que será utlizado posteriormente nos métodos de teste.
- Armazenamos os dados que são enviados para a API através do uso de classes POJO.
- Criamos dados iniciais através do uso de classe Data Factory ara facilitar a criação e controle dos mesmos.
- Nesse projeto fazemos uso do JUnit 5, o que nos dá a possibilidade de usar a anotação DisplayName para dar descrições em português para nossos testes.
