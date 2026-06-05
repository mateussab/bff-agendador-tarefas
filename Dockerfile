FROM maven:3.9.16-eclipse-temurin-21-alpine AS BUILD
WORKDIR /app
COPY . .

RUN mvn clean install -DskipTests
FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=build /app/target/*.jar /app/bff-agendador.jar
EXPOSE 8083
CMD  ["java", "-jar", "/app/bff-agendador.jar"]