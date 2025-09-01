# ds-resilience-circuit-breaker 

## Versoes Java
- Versao Java projto : Java 17
- Versao Java instalado Java: 20

## Tecnoliogias
- Java
- Gradlew

## Build 

`./gradlew bootRun`

## Testando

`curl http://localhost:8080/api/teste`


for i in {1..9000}; do
curl -i http://localhost:8080/api/teste
done