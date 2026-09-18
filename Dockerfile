FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app

COPY pom.xml .
RUN mvn -B -q dependency:go-offline


COPY src ./src
RUN mvn -B -q clean package -DskipTests

FROM eclipse-temurin:17-jre AS runtime
WORKDIR /app


RUN groupadd -r app && useradd -r -g app app


COPY --from=build /app/target/*.jar app.jar
RUN chown app:app app.jar
USER app

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
