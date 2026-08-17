FROM maven:3.9.6-eclipse-temurin-17 AS builder

WORKDIR /app

COPY build-parent/pom.xml build-parent/pom.xml
COPY services/payment-service/pom.xml services/payment-service/pom.xml

RUN mvn -f services/payment-service/pom.xml dependency:go-offline

COPY build-parent build-parent
COPY services/payment-service services/payment-service

RUN mvn -f services/payment-service/pom.xml clean package -DskipTests


FROM eclipse-temurin:17-jre

WORKDIR /app

COPY --from=builder /app/services/payment-service/target/payment-service-*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]