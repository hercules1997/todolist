# Especifica o tipo de máquina ao servidor
FROM ubuntu:latest AS build 

# Instalação do Java 17
RUN apt-get update
RUN apt-get install openjdk-17-jdk -y

COPY . .

# Instalação do MAVEN
RUN apt-get install maven -y
RUN mvn clean install

# Cria uma imagem simples do docker
FROM openjdk:17-jdk-slim

# Tipo da porta
EXPOSE 8080

# Comando para rodar a aplicação
COPY --from=build /target/todolist-1.0.0.jar app.jar

ENTRYPOINT [ "java", "-jar", "app.jar" ]