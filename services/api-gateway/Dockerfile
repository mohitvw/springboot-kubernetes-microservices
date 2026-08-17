FROM maven:3.9.6-eclipse-temurin-17 AS builder

WORKDIR /app

COPY build-parent/pom.xml build-parent/pom.xml
COPY services/api-gateway/pom.xml services/api-gateway/pom.xml

RUN mvn -f services/api-gateway/pom.xml dependency:go-offline

COPY build-parent build-parent
COPY services/api-gateway services/api-gateway

RUN mvn -f services/api-gateway/pom.xml clean package -DskipTests


FROM eclipse-temurin:17-jre

WORKDIR /app

COPY --from=builder /app/services/api-gateway/target/api-gateway-*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]