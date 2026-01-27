# Web Wallet <img width="1" height="1" alt="image" src="https://github.com/user-attachments/assets/f87ec28f-edc1-4481-a8c1-2c40ba3f009b" />

Esse projeto tem o foco no meu aprendizado de novas tecnologias, entre elas: Java, Spring Boot, TypeScript e PostgreSQL. Além de outras ferramentas para organização durante o processo de desenvolvimento, como o Jira, Figma e Draw.io para modelagem do banco de dados.

## Esboço criado no Figma para melhor visualização do projeto:

<img width="939" height="856" alt="image" src="https://github.com/user-attachments/assets/a507cbca-aa19-483b-9248-f6c94a08b3f9" />

## Configuração application.properties:

spring.datasource.url=jdbc:postgresql://localhost:XXXX/seu_banco_de_dados <br>
spring.datasource.username=postgres<br>
spring.datasource.password=sua_senha<br>

spring.datasource.driver-class-name=org.postgresql.Driver<br>

spring.jpa.hibernate.ddl-auto=update<br>
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect<br>

api.security.token.secret=chave_secreta_jwt