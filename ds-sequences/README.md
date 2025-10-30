# Sequencing
Ter um serviço separado que gera os IDs.
Esse serviço normalmente tem que aguentar concorrência e tem um banco de dados.

# INTERFACE 
API 

# TECNOLOGIAS 
Java 25, spring boot 

# Rotas 

`curl -X POST http://localhost:8080/api/sequences/user/next`

# Modelo de dados 

create table "sequence" (
name varchar(255) not null,
"value" bigint not null,
primary key (name)
);

insert into "sequence" (name, "value") values ('user', 1);

SELECT * FROM "sequence"


# Execucao
1. 
Acesse: http://localhost:8080/h2-console
JDBC URL: jdbc:h2:mem:testdb
User: sa

2. criar tabela na fase modelo de dados 

3. 