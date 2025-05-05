# Use uma imagem oficial do Maven com OpenJDK
FROM maven:3.8.6-openjdk-21 AS build

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia os arquivos do seu repositório para o container
COPY . /app/

# Dá permissão de execução ao arquivo mvnw e executa o Maven para compilar o projeto
RUN chmod +x ./mvnw && ./mvnw clean install

# Define a imagem final (pode ser um OpenJDK ou um servidor web)
FROM openjdk:21-jdk

# Copia o arquivo JAR gerado para a imagem final
COPY --from=build /app/target/todo-list.jar /app/todo-list.jar

# Expõe a porta que o Spring Boot estará ouvindo
EXPOSE 8080

# Comando para rodar o jar
CMD ["java", "-jar", "/app/todo-list.jar"]
