# Etapa 1: Construção (compilação do código)
FROM maven:3.8.4-openjdk-11 AS build

# Define o diretório de trabalho no contêiner
WORKDIR /app

# Copia os arquivos do projeto para o diretório de trabalho
COPY . /app

# Dá permissão ao script mvnw e compila a aplicação
RUN chmod +x ./mvnw && ./mvnw clean install

# Etapa 2: Execução (rodar a aplicação)
FROM openjdk:11-jre-slim

# Define o diretório de trabalho
WORKDIR /app

# Copia o arquivo JAR gerado pela etapa de build
COPY --from=build /app/target/*.jar /app/app.jar

# Expondo a porta que a aplicação irá rodar
EXPOSE 8080

# Comando para rodar a aplicação
CMD ["java", "-jar", "/app/app.jar"]
